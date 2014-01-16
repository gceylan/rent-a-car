package com.gceylan.rentacar.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gceylan.rentacar.dao.CarDao;
import com.gceylan.rentacar.dao.RentalDao;
import com.gceylan.rentacar.domain.Branch;
import com.gceylan.rentacar.domain.Car;
import com.gceylan.rentacar.domain.Rental;
import com.gceylan.rentacar.service.CarService;

@Service
public class CarServiceImpl implements CarService {
	
	@Autowired
	private CarDao carDao;
	
	@Autowired
	private RentalDao rentalDao;

	@Transactional
	public void addCar(Car car) {
		carDao.addCar(car);
	}

	@Transactional
	public Car getCarById(Integer carId) {
		return carDao.getCarById(carId);
	}

	@Transactional
	public void updateCar(Car car) {
		carDao.updateCar(car);
	}

	@Transactional
	public void deleteCar(Integer carId) {
		carDao.deleteCar(carId);
	}
	
	@Transactional
	public List<Car> getAllCars(Branch branch) {
		return carDao.getAllCars(branch);
	}
	
	/* aracýn alýnacaðýn þubeden, ilgili tarihlerde müsait olan araçlarý getir,
	 * ayný zamanda, diðer þubelere ait araçlardan da olanlarý getir.(bu biraz karýþýk)
	 *  */
	@Transactional
	public List<Car> getAvailableCarForRental(Branch alýsSube, Branch teslimSube, Date pickupDate, Date returnDate) {
		List<Car> rentableCarList = new ArrayList<Car>();
		
		List<Car> cars = carDao.getAvailableCars(alýsSube);
		
		/* dönüþ yerini de hesap ederek araçlarý getir */
		if (alýsSube.getId() != teslimSube.getId())
			cars.addAll(carDao.donusYerineGoreGetir(teslimSube, alýsSube));
		
		System.out.println("cars.size() = " + cars.size());

		if (cars.size() > 0) {
			for (Car car : cars) {
				boolean rentable = true;
				/*
				 * aracýn, henüz tamamlanmamýþ kiralamalarýný, alýþ tarihine göre
				 * sýrala(artan) (onaylanmamýþ ve tamamlanmamýþlarýný getir (yukarýdaki cümle ile ayný manada))
				 */
				System.out.println("Test Edilen Araç: " + car);
				List<Rental> carRentals = rentalDao.getAllCompleted(car.getId(), false);
				
				if (carRentals.size() > 0) {
					System.out.println("carRentals.size(): " + carRentals.size());
					for (Rental r : carRentals) {
						Date rentalPickUpDate = r.getPickupDate();
						Date rentalReturnDate = r.getReturnDate();
						
						System.out.println("rentalPickUpDate: " + rentalPickUpDate);
						System.out.println("rentalReturnDate: " + rentalReturnDate);
						
						/* +90, -90 dk, kiralamaya hazýrlanma evresi */
						Calendar c = Calendar.getInstance();
						c.setTime(rentalPickUpDate);
						c.add(Calendar.MINUTE, -90);
						rentalPickUpDate = c.getTime();
						
						c.setTime(rentalReturnDate);
						c.add(Calendar.MINUTE, 90);
						rentalReturnDate = c.getTime();
						
						System.out.println("rentalPickUpDate: " + rentalPickUpDate);
						System.out.println("rentalReturnDate: " + rentalReturnDate);
						
						System.out.println("rentable: " + rentable + " baþladý.");
						
						/* db de 12 - 15 arasý kiralanmýþ bir araç için */
						if (pickupDate.compareTo(rentalPickUpDate) == 0 || returnDate.compareTo(rentalReturnDate) == 0) {
							System.out.println("    > 193: alýþ tarihi = 12 || teslim tarihi = 15");
							rentable = false;
						} else if (
								(pickupDate.compareTo(rentalPickUpDate) > 0 && pickupDate.compareTo(rentalReturnDate) < 0)
								||
								(returnDate.compareTo(rentalPickUpDate) > 0 && returnDate.compareTo(rentalReturnDate) < 0)
								) {
							System.out.println("    > 201: 12 < alýþ tarihi < 15 || 12 < teslim tarihi < 15");
							rentable = false;
						} else if (
								(pickupDate.compareTo(rentalPickUpDate) < 0 && returnDate.compareTo(rentalReturnDate) > 0)
								) {
							System.out.println("    > 206: alýþ tarihi < 12 && teslim tarihi > 15");
							rentable = false;
						}
						
						System.out.println("rentable: " + rentable + " bitti.");
						/* rentable false ise hemen araç deðiþtir. aracýn kalan kiralamalarýný inceleme bile... */
						if (rentable == false) {
							System.out.println("   > Sonuç: ARAÇ KÝRALANAMAZ!!!");
							break;
						}
					}
					
					/* ama rentable true ise, kiralanabiliri araç listemize ekle */
					if (rentable) {
						System.out.println("   > Sonuç: ARAÇ KÝRALANABÝLÝR (rentableCarList listesine ekleniyor...)");
						rentableCarList.add(car);
					}
				}
				else {
					/*
					 * aracýn kiralama tablosunda hiçbir kaydý yoksa, hemen kirala :)
					 * */
					System.out.println("   > Sonuç: ARAÇ KÝRALANABÝLÝR (rentableCarList listesine ekleniyor...) ( hiç kaydý yok )");
					rentableCarList.add(car);
				}
			}
		}

		return rentableCarList;
	}
	
	@Transactional
	public void isAvailable(Integer carId, Integer value) {
		Car c = getCarById(carId);
		c.setAvailable((value == 0) ? false : true);
		carDao.updateCar(c);
	}
	
	@Transactional
	public Car isAvailableForRental(int selectedCarId, Date pickupDate, Date returnDate) {
		boolean rentable = true;
		/*
		 * aracýn, henüz tamamlanmamýþ kiralamalarýný, alýþ tarihine göre
		 * sýrala(artan) (onaylanmamýþ ve tamamlanmamýþlarýný getir)
		 */
		Car car = carDao.getCarById(selectedCarId);
		
		System.out.println("Test Edilen Araç: " + car);
		List<Rental> carRentals = rentalDao.getAllCompleted(car.getId(), false);
		
		if (carRentals.size() > 0) {
			System.out.println("carRentals.size(): " + carRentals.size());
			for (Rental r : carRentals) {
				Date rentalPickUpDate = r.getPickupDate();
				Date rentalReturnDate = r.getReturnDate();
				
				System.out.println("rentalPickUpDate: " + rentalPickUpDate);
				System.out.println("rentalReturnDate: " + rentalReturnDate);
				
				Calendar c = Calendar.getInstance();
				c.setTime(rentalPickUpDate);
				c.add(Calendar.MINUTE, -90);
				rentalPickUpDate = c.getTime();
				
				c.setTime(rentalReturnDate);
				c.add(Calendar.MINUTE, 90);
				rentalReturnDate = c.getTime();
				
				System.out.println("rentalPickUpDate: " + rentalPickUpDate);
				System.out.println("rentalReturnDate: " + rentalReturnDate);
				
				System.out.println("rentable: " + rentable + " baþladý.");
				
				/* db de 12 - 15 arasý kiralanmýþ bir araç için */
				if (pickupDate.compareTo(rentalPickUpDate) == 0 || returnDate.compareTo(rentalReturnDate) == 0) {
					System.out.println("    > 193: alýþ tarihi = 12 || teslim tarihi = 15");
					rentable = false;
				} else if (
						(pickupDate.compareTo(rentalPickUpDate) > 0 && pickupDate.compareTo(rentalReturnDate) < 0)
						||
						(returnDate.compareTo(rentalPickUpDate) > 0 && returnDate.compareTo(rentalReturnDate) < 0)
						) {
					System.out.println("    > 201: 12 < alýþ tarihi < 15 || 12 < teslim tarihi < 15");
					rentable = false;
				} else if (
						(pickupDate.compareTo(rentalPickUpDate) < 0 && returnDate.compareTo(rentalReturnDate) > 0)
						) {
					System.out.println("    > 206: alýþ tarihi < 12 && teslim tarihi > 15");
					rentable = false;
				}
				
				System.out.println("rentable: " + rentable + " bitti.");
			}
		} else {
			/*
			 * aracýn kiralama tablosunda hiçbir kaydý yoksa, hemen kirala :)
			 * */
			System.out.println("   > Sonuç: ARAÇ KÝRALANABÝLÝR( hiç kaydý yok )");
			return car;
		}
		
		if (rentable) {
			System.out.println("   > Sonuç: ARAÇ KÝRALANABÝLÝR");
			return car;
		} else {
			return null;
		}
	}
	
	@Transactional
	public List<Car> donusYerineGoreGetir(Branch pickupBranch, Branch returnBranch) {
		return carDao.donusYerineGoreGetir(pickupBranch, returnBranch);
	}
	
	public void setCarDao(CarDao carDao) {
		this.carDao = carDao;
	}
	
	public void setRentalDao(RentalDao rentalDao) {
		this.rentalDao = rentalDao;
	}

}

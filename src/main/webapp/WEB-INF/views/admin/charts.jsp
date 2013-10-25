<div class="row">
	<div class="col-lg-12">
		<h1>
			Charts <small>Display Your Data</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="index.html"><i class="icon-dashboard"></i>
					Dashboard</a></li>
			<li class="active"><i class="icon-bar-chart"></i> Charts</li>
		</ol>
		<div class="alert alert-info alert-dismissable">
			<button type="button" class="close" data-dismiss="alert"
				aria-hidden="true">&times;</button>
			There are two options for charts: <a
				href="http://www.flotcharts.org/" target="_blank" class="alert-link">Flot
				charts</a> and <a href="http://www.oesmith.co.uk/morris.js/"
				class="alert-link" target="_blank">morris.js</a>. Choose which one
			best suits your needs, and make sure to master the documentation to
			get the most out of these charts!
		</div>
	</div>
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<h2>Flot Charts</h2>
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="icon-bar-chart"></i> Line Graph Example with Tooltips
				</h3>
			</div>
			<div class="panel-body">
				<div class="flot-chart">
					<div class="flot-chart-content" id="flot-chart-line"></div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-4">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="icon-long-arrow-right"></i> Pie Chart Example with
					Tooltips
				</h3>
			</div>
			<div class="panel-body">
				<div class="flot-chart">
					<div class="flot-chart-content" id="flot-chart-pie"></div>
				</div>
				<div class="text-right">
					<a href="#">View Details <i class="icon-circle-arrow-right"></i></a>
				</div>
			</div>
		</div>
	</div>
	<div class="col-lg-8">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="icon-long-arrow-right"></i> Multiple Axes Line Graph
					Example with Tooltips and Raw Data
				</h3>
			</div>
			<div class="panel-body">
				<div class="flot-chart">
					<div class="flot-chart-content" id="flot-chart-multiple-axes"></div>
				</div>
				<div class="text-right">
					<a href="#">View Details <i class="icon-circle-arrow-right"></i></a>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-6">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="icon-long-arrow-right"></i> Moving Line Chart
				</h3>
			</div>
			<div class="panel-body">
				<div class="flot-chart">
					<div class="flot-chart-content" id="flot-chart-moving-line"></div>
				</div>
				<div class="text-right">
					<a href="#">View Details <i class="icon-circle-arrow-right"></i></a>
				</div>
			</div>
		</div>
	</div>
	<div class="col-lg-6">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="icon-long-arrow-right"></i> Bar Graph with Tooltips
				</h3>
			</div>
			<div class="panel-body">
				<div class="flot-chart">
					<div class="flot-chart-content" id="flot-chart-bar"></div>
				</div>
				<div class="text-right">
					<a href="#">View Details <i class="icon-circle-arrow-right"></i></a>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<h3>Additional Flot Chart Information</h3>
		<p>
			Full documentation for Flot can be found at <a
				href="http://www.flotcharts.org/" target="_blank">http://www.flotcharts.org/</a>.
			Flot has a lot of different options available, and they have a bunch
			of plugins as well that allow you to do neat things. Here we are
			using the tooltip plugin, the resize plugin, and the pie chart
			plugin, but there are many more to choose from. The documentation is
			a bit more advanced and requires a good deal of JavaScript knowledge
			in order to make the charts work for you.
		</p>
		<p>
			<strong>NOTE:</strong> The charts are responsive, and the Flot charts
			are redrawn when the window resizes. The only one that needs a page
			refresh on a window resize is the pie chart. If you find a way to fix
			this, please let me know.
		</p>
	</div>
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<h2>morris.js Charts</h2>
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="icon-bar-chart"></i> Area Line Graph Example with
					Tooltips
				</h3>
			</div>
			<div class="panel-body">
				<div id="morris-chart-area"></div>
			</div>
		</div>
	</div>
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-4">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="icon-long-arrow-right"></i> Donut Chart Example
				</h3>
			</div>
			<div class="panel-body">
				<div id="morris-chart-donut"></div>
				<div class="text-right">
					<a href="#">View Details <i class="icon-circle-arrow-right"></i></a>
				</div>
			</div>
		</div>
	</div>
	<div class="col-lg-4">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="icon-long-arrow-right"></i> Line Graph Example with
					Tooltips
				</h3>
			</div>
			<div class="panel-body">
				<div id="morris-chart-line"></div>
				<div class="text-right">
					<a href="#">View Details <i class="icon-circle-arrow-right"></i></a>
				</div>
			</div>
		</div>
	</div>
	<div class="col-lg-4">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="icon-long-arrow-right"></i> Bar Graph Example
				</h3>
			</div>
			<div class="panel-body">
				<div id="morris-chart-bar"></div>
				<div class="text-right">
					<a href="#">View Details <i class="icon-circle-arrow-right"></i></a>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<h3>Additional morris.js Information</h3>
		<p>
			Full documentation for morris.js charts can be found at <a
				href="http://www.oesmith.co.uk/morris.js/" target="_blank">http://www.oesmith.co.uk/morris.js/</a>.
			The chart options for morris.js are <a
				href="http://www.oesmith.co.uk/morris.js/lines.html" target="_blank">line
				&amp; area charts</a>, <a
				href="http://www.oesmith.co.uk/morris.js/bars.html">bar charts</a>,
			and <a href="http://www.oesmith.co.uk/morris.js/donuts.html"
				target="_blank">donut charts</a>. The documentation is pretty
			straight forward, and you will want to look at it in order to get the
			most out of the charts.
		</p>
		<p>
			<strong>NOTE:</strong> The charts are responsive, but they are drawn
			when the window loads. If you change the window size, for instance
			resizing your brownser window, you will need to refresh the page to
			redraw the chart responsively. According to morris.js, automatically
			redrawing charts on window resizing is being worked into their next
			big update.
	</div>
</div>
<!-- /.row -->
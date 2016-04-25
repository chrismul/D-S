<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="initial-scale=1.0, maximum-scale=2.0">

<title>Query</title>
<link rel="stylesheet" href="media/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="resources/syntax/shCore.css">
<link rel="stylesheet" type="text/css" href="resources/demo.css">
<link rel="stylesheet" type="text/css" href="media/css/bootstrap-datetimepicker.css">
<link rel="stylesheet" type="text/css" href="media/css/select2.min.css">
<link rel="stylesheet" type="text/css" href="media/css/jquery.dataTables.min.css">
<link rel="stylesheet" type="text/css" href="media/css/mainPage.css">
<style type="text/css">

	#placeholder {
		width: 800px;
		height: 400px;
	}
	
	.demo-placeholder {
	font-size: 14px;
	line-height: 1.2em;
	}
	
	a {	color: #069; }
	a:hover { color: #28b; }
	
	.legend table {
		position: relative;
		width: 300px;
		border-spacing: 5px;
		font-size: 20px;
	}
	
	@media screen and (min-width: 10px) {
		.modal-open .modal{
			overflow-x: auto;
		}
        .modal-dialog {
         	width: 800px;
        }
    }

</style>
<script type="text/javascript" language="javascript" src="media/js/jquery.js"></script>
<script type="text/javascript" language="javascript" src="resources/syntax/shCore.js"></script>
<script type="text/javascript" src="media/js/bootstrap.min.js"></script>
<script type="text/javascript" src="media/js/transition.js"></script>
<script type="text/javascript" src="media/js/moment-with-locales.js"></script>
<script type="text/javascript" src="media/js/collapse.js"></script>
<script type="text/javascript" src="media/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" language="javascript" class="init"></script>
<script type="text/javascript" src="media/js/select2.full.js"></script>
<script language="javascript" type="text/javascript" src="media/js/jquery.flot.js"></script>
<script language="javascript" type="text/javascript" src="media/js/jquery.flot.pie.js"></script>
<script type="text/javascript" src="media/js/jquery.dataTables.js"></script>
</head>

<body>
	<br/>
	<div class="container">
		<div class="jumbotron" style="background: #337AB7; font-family: HelveticaNeue,Helvetica,Arial,sans-serif">
			<header>
				<h1>iLib</h1>
			</header>
		</div>
	</div>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span>
				</button>
				<a href="#" id="logintype" class="navbar-brand"><span></span></a>
				<a class="navbar-brand" href="#" id="userBar"></a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li style="font-size: 1.5em;">
						<a href="logout">
							<span class="glyphicon glyphicon-log-out"></span> Log out
						</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="dropdown">
		<button id="button1" class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">
			<b>Select Query</b> <span class="caret"></span>
		</button>
		<ul class="dropdown-menu">
			<li><a id="availQuery1" onClick=selectQuery(1)>View All tracks</a></li>
			<li><a id="availQuery14" onClick=selectQuery(14)>Display unique Event IDs and Cause Codes for a given IMSI</a></li>
			<li><a id="availQuery9" onClick=selectQuery(9)>Display number of failures for a given IMSI during a time period.</a></li>
			<li><a id="availQuery2" onClick=selectQuery(2)>Display IMSIs with failures during a time period</a></li>
			<li><a id="availQuery3" onClick=selectQuery(3)>Display number of failures for a given model of phone, during a time period</a></li>
			<li><a id="availQuery16" onClick=selectQuery(16)>Display IMSIs for a given Failure Class</a></li>	
			<li><a id="availQuery4" onClick=selectQuery(4)>Display the number of failures and their total duration during a time period for each IMSI</a></li>
			<li><a id="availQuery5" onClick=selectQuery(5)>Display the unique Event ID and Cause Code combinations and the number of occurrences for a given model of phone</a></li>
			<li><a id="availQuery12" onClick=selectQuery(12)>Display top 10 Market/Operator/Cell ID combinations with failures during a time period</a></li>			 
			<li><a id="availQuery15" onClick=selectQuery(15)>Display top 10 IMSIs with failures during a time period</a></li>
			
			
		</ul>
	</div>
	<br>
	<br>
	<div class="col-lg-12">
		<div class="panel panel-primary">
			<div id="phead" class="panel-heading">
				<h4>Currently Selected Query: <u id="selectedquery"></u></h4>
			</div>
			<div id="collapseOne" class="panel-collapse collapse in">
				<div class="panel-body" style="font-size: 15px;">
					<div class="container" id="datetimepickers">
						<div class='col-md-6'>
							<div class="form-group">
								<label for="fromdatetimepicker">From:</label>
								<div class='input-group date' id='fromdatetimepicker'>
									<input id="datefrom" type='text' class="form-control" /> 
									<span class="input-group-addon"> 
										<span class="glyphicon glyphicon-calendar"></span>
									</span>
								</div>
							</div>
						</div>
						<div class='col-md-6'>
							<div class="form-group">
								<label for="todatetimepicker">To:</label>
								<div class='input-group date' id='todatetimepicker'>
									<input id="dateto" type='text' class="form-control" /> 
									<span class="input-group-addon"> 
										<span class="glyphicon glyphicon-calendar"></span>
									</span>
								</div>
							</div>
						</div>
					</div>
					<div class="container" id="tacPicker">
						<div class='col-lg-4 col-md-4'>
							<div class="form-group">
								<label for="manufacturerDropdown">Choose Manufacturer:</label> 
								<select id="manufacturerDropdown" class="js-data-example-ajax" style="width: 300px">
								</select>
							</div>
						</div>
						<div class='col-lg-4 col-md-4'>
							<div class="form-group">
								<label for="modelDropdown">Choose Model:</label> 
								<select id="modelDropdown" class="js-data-example-ajax" style="width: 300px">
								</select>
							</div>
						</div>
					</div>
					<div class="container" id="imsiPicker">
						<label for="imsiDropdown">Choose IMSI:</label> 
						<select id="imsiDropdown" class="js-data-example-ajax" style="width: 400px">
						</select>
					</div>
					<div class="container" id="failurePicker">
						<label for="failureDropdown">Choose Failure Class:</label> 
						<select id="failureDropdown" class="js-data-example-ajax" style="width: 400px">
						</select>
					</div>
					<button id="query1" type="button" class="btn btn-primary">Run Query</button>
				</div>
			</div>
		</div>
	</div>
	<br />
	<br />
	<div id="resultsCollapse" class="col-lg-12" style="display: none">
		<div class="panel panel-primary">
			<div id="phead2" class="panel-heading">
				<h4 id="selectedquery2"></h4>
			</div>
			<div id="collapseTwo" class="collapse">
				<div class="panel-body" style="font-size: 15px;">
					<div id="resultsDiv" style="display: none;">
						<table id="dataTable" class="display">
						</table>
					</div>
				</div>
				<div class="panel-footer" style="font-size: 15px;">				
					<button id="graph_button" type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" onclick="clearPercent()">View Graph of Results</button>
				</div>
			</div>
		</div>
	</div>
	<br />
	<br />		
	<div id="myModal" class="modal fade" role="dialog">
	  <div class="modal-dialog">
		
		<div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	        <h4 class="modal-title" id="graphTitle"></h4>
	      </div>
	      <div class="modal-body">
	        <div id="placeholder" ></div>
	      </div>
	      <div class="modal-footer">
	      	<div class="col-lg-10">
	      		<p align="left"><b id = "percent"></b></p>
	      	</div>
	      	<div class="col-lg-2">
	      		<button type="button" class="btn btn-default" data-dismiss="modal" >Close</button>
	      	</div>
	      </div>
	    </div>
	
	  </div>
	</div>
	<script>
	//	const QUERYPAGELIMIT = 20;
	//	var selectedQuery=1;
	//	selectQuery(1);
		
		$(document).ready(function() {
			$(function() {
	//			$(".js-example-responsive").select2();
				setUserDetails();
			});
		});
		
		

		function setUserDetails() {

			$.ajax({
				type : 'GET',
				url : './rest/users/currentUser',
				success : function(data) {
					alert(data);
					var userBar = document.getElementById("userBar");
					userBar.innerHTML = "Privilege type: " + data;
					
				},
			});
		}
		
		
		
		
	</script>
</body>
</html>

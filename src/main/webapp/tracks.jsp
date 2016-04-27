<!DOCTYPE HTML>
<html>
<head>
	<title>Admin Menu</title>

	<!-- bootstrap dropdown -->
 	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	
	<link rel="stylesheet" type="text/css" href="SearchStyle.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script type="text/javascript" src="UserScripts.js"></script> 
	<script type="text/javascript" src="AdminScripts.js"></script> 
	
	<!-- TABLES -->
	<link rel="stylesheet"	href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css"></style>
	<script type="text/javascript" 	src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>

</head>

<body>
<div id="container">
<!--header-->
	<div id="header">
		<img src="http://brentwoodnylibrary.org/images/icon/headphones.png" width="120" height="135" style="float:left;">
		<!-- <center><img src="logo.PNG" height = "120px"></center>-->
		<div id="userinfo">
			<p id="loggedin"></p>
			<p id="typeofuser">Administrator</p>
			<a id="logout" href="logout">Logout</a>
		</div>
	</div>
	
	
<!--sidebar-->
	<div Id="sidebar">
	
	<div id="searchType" class="sidebar">
		<h3>Admin Controls</h3>
		<button onclick="displayUploads()" class="btn btn-primary" type="button">View Uploaded Data Files</button><p></p>
 		<button id="failedEntriesBtn" onclick="displayfailuredata()" class="btn btn-primary" type="button">View Failed Entries</button><p></p>
		<button id="userCtrlsBtn" onclick="UserFunctionsButton()" class="btn btn-primary" type="button">User Controls</button><p></p>
	</div>		
	<div id="footer">Copyright &copy; iLib <br></div>
</div>

</body>
</html>
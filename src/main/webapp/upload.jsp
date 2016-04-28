<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE HTML>
<html lang="en">
<head>
 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">


    <title>Upload backup</title>

    <link rel="stylesheet" href="media/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="resources/syntax/shCore.css">
	<link rel="stylesheet" type="text/css" href="resources/demo.css">
	<link rel="stylesheet" href="media/css/bootstrap-table.css">
	<link rel="stylesheet" type="text/css" href="media/css/select2.min.css">
	<link rel="stylesheet" type="text/css" href="media/css/mainPage.css">
	<style type="text/css" class="init"></style>
	<script type="text/javascript" language="javascript" src="media/js/jquery.js"></script>
	<script type="text/javascript" language="javascript" src="resources/syntax/shCore.js"></script>
	<script type="text/javascript" src="media/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="media/js/transition.js"></script>
	<script type="text/javascript" src="media/js/moment-with-locales.js"></script>
	<script type="text/javascript" src="media/js/collapse.js"></script>
	<script type="text/javascript" language="javascript" class="init"></script>
	<script type="text/javascript" src="media/js/select2.full.js"></script>
	<style type="text/css">

body { margin:0;
	  /*background-color: #003366;*/
	  background: red; /* For browsers that do not support gradients */
    background: -moz-linear-gradient(#003366, #FFFFFF); /* For Firefox 3.6 to 15 */
    background: linear-gradient(#78B733, #FFFFFF); /* Standard syntax */}

</style>
    <!-- Custom styles for this template -->
    <link href="upload.css" rel="stylesheet">

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
				<a class="navbar-brand" href="#" id="userBar"></a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li style="font-size: 1.8em;">
						<a href="logout">
							<span class="glyphicon glyphicon-log-out"></span> Log out
						</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="col-lg-12">
		<div class="panel panel-primary">
			<div id="phead2" class="panel-heading">
				<h4>Upload Library</h4>
			</div>
			<div class="panel-body" style="font-size: 15px;">
		
			       <p>  
			       <input id="up" type="text" name="uploadFile" button class="btn btn-primary" />
			       </p>  
			       <input id="upload-button" type="button" onclick="upload()" value="Upload File" button class="btn btn-lg btn-primary" />
					
				</form>
			</div>
		</div>
	</div>
	<script>
	
	function upload(){
	var filename = document.getElementById("up").value;
	$.ajax({
	  type: 'GET',
	  url: './rest/load/'+encodeURI(filename),
	  success: window.location.assign("http://localhost:8080/iTunesLibrary/home.jsp")
	  
	});
	
}
	
	</script>
</body>
</html>
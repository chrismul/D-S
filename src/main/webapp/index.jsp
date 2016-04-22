<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="viewport" content="width=1,initial-scale=1,user-scalable=1" />
	<title>Coolbeanzzz</title>

	<!-- link href="http://fonts.googleapis.com/css?family=Lato:100italic,100,300italic,300,400italic,400,700italic,700,900italic,900" rel="stylesheet" type="text/css"-->
	<link rel="stylesheet" type="text/css" href="media/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="media/css/style.css" />
	
	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<section class="container login-form">
		<section>
			<form name="loginform" method="post" action="" role="login">
				<h2 class="form-signin-heading">iTunes User Login</h2>

				<div class="form-group">
					<input type="text" name="username" required class="form-control" placeholder="Enter username" />
					<span class="glyphicon glyphicon-user"></span>
				</div>
				
				<div class="form-group">
					<input type="password" name="password" required class="form-control" placeholder="Enter password" />
					<span class="glyphicon glyphicon-lock"></span>
				</div>
				
				<button type="submit" value='Login' name="login" class="btn btn-primary btn-block">Login</button>
				<%
  					if (request.getAttribute("shiroLoginFailure")!=null) {
				%>
						Username or password incorrect
				<%
 				 	}
				%>
			</form>
		</section>
	</section>
	
	<script src="media/js/jquery.js"></script>
	<script src="media/js/bootstrap.min.js"></script>
</body>
</html>
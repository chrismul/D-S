<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html>
<head>
        <meta charset="utf-8">
        <meta name="viewport" content="initial-scale=1.0, maximum-scale=2.0">

        <title>A table of data returned by an Ajax call - courtesy of
Bootstrap Tables</title>
        <link rel="stylesheet"
href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="resources/syntax/shCore.css">
        <!--link rel="stylesheet" type="text/css" href="resources/demo.css"-->
        <link rel="stylesheet" href="media/css/bootstrap-table.css">
        <link rel="stylesheet" href="media/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="resources/syntax/shCore.css">
<link rel="stylesheet" type="text/css" href="resources/demo.css">
<link rel="stylesheet" type="text/css" href="media/css/bootstrap-datetimepicker.css">
<link rel="stylesheet" type="text/css" href="media/css/select2.min.css">
<link rel="stylesheet" type="text/css" href="media/css/jquery.dataTables.min.css">
<link rel="stylesheet" type="text/css" href="media/css/mainPage.css">
        <style type="text/css" class="init">
		
        </style>
        <script type="text/javascript" language="javascript" src="media/js/jquery.js"></script>
        <script type="text/javascript" language="javascript" src="resources/syntax/shCore.js"></script>
        <script type="text/javascript" language="javascript" src="resources/demo.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
        <script src="media/js/bootstrap-table.js"></script>
     
        
        <script type="text/javascript" src="media/js/jquery.dataTables.js"></script>
   
		
        <script type="text/javascript">
        $(document).ready(function() {
			
	//			$(".js-example-responsive").select2();
	
	
				$.ajax({
					type : 'GET',
					url : './rest/tracks',
					dataType: 'json',
					success : function(data) {
						$('#cdTable').dataTable({
							data: data,
							columns:[
							        {'data': 'id'},
							        {'data': 'name'},
							        {'data': 'artist'},
							        {'data': 'album'},
							        {'data': 'genre'},
							        {'data': 'year'},   
							        {'data': 'location'},
							     		    
							        						         
							         ]
						
						});
						
					}
				});
			});

			//	setUserDetails();
		
		

	//	function setUserDetails() {

			
        </script>
</head>

<body>



        <table id="cdTable">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Artist</th>
        <th>Album</th>
        <th>Genre</th>
        <th>Year</th>
        <th>Location</th>

    </tr>
    </thead>
</table>

</body>
</html>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="initial-scale=1.0, maximum-scale=2.0">

<title>iLib</title>
<link rel="stylesheet" href="media/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="resources/syntax/shCore.css">
<link rel="stylesheet" type="text/css" href="resources/demo.css">
<link rel="stylesheet" type="text/css"
	href="media/css/bootstrap-datetimepicker.css">
<link rel="stylesheet" type="text/css" href="media/css/select2.min.css">
<link rel="stylesheet" type="text/css"
	href="media/css/jquery.dataTables.min.css">
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

a {
	color: #069;
}

a:hover {
    color: #ff8000;
}

.legend table {
	position: relative;
	width: 300px;
	border-spacing: 5px;
	font-size: 20px;
}
body { margin:0;
	  /*background-color: #003366;*/
	  background: red; /* For browsers that do not support gradients */
    background: -moz-linear-gradient(#003366, #FFFFFF); /* For Firefox 3.6 to 15 */
    background: linear-gradient(#78B733, #FFFFFF); /* Standard syntax */}

</style>
<script type="text/javascript" language="javascript"
	src="media/js/jquery.js"></script>
<script type="text/javascript" language="javascript"
	src="resources/syntax/shCore.js"></script>
<script type="text/javascript" src="media/js/bootstrap.min.js"></script>
<script type="text/javascript" src="media/js/transition.js"></script>
<script type="text/javascript" src="media/js/moment-with-locales.js"></script>
<script type="text/javascript" src="media/js/collapse.js"></script>
<script type="text/javascript"
	src="media/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" language="javascript" class="init"></script>
<script type="text/javascript" src="media/js/select2.full.js"></script>
<script language="javascript" type="text/javascript"
	src="media/js/jquery.flot.js"></script>
<script language="javascript" type="text/javascript"
	src="media/js/jquery.flot.pie.js"></script>
<script type="text/javascript" src="media/js/jquery.dataTables.js"></script>
</head>

<body>
	<br />
	<div class="container">
		<div class="jumbotron"
			style="background: #337AB7; font-family: HelveticaNeue, Helvetica, Arial, sans-serif">
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
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#" id="userBar"></a>
			</div>
			
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
				</ul>
				<ul class="nav navbar-nav navbar-left">
					<li style="font-size: 1.5em;"><a href="upload.jsp"> <span
							class="glyphicon glyphicon-log-out"></span> Upload File
					</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li style="font-size: 1.5em;"><a href="logout"> <span
							class="glyphicon glyphicon-log-out"></span> Log out
					</a></li>
				</ul>
			</div>
		</div>
	</nav>
	
	<div class="dropdown">
		<button id="button1" class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">
			<b>Choose option</b> <span class="caret"></span>
		</button>
		<ul class="dropdown-menu">
			<li><a id="availQuery1" onClick=selectQuery(1)>Show Libraries</a></li>
			<li><a id="availQuery2" onClick=selectQuery(2)>View playlists for a given Lib ID</a></li>
			<li><a id="availQuery3" onClick=selectQuery(3)>View playlists by name</a></li>
			<li><a id="availQuery4" onClick=selectQuery(4)>View tracks by artist</a></li>
			<li><a id="availQuery5" onClick=selectQuery(5)>View tracks by genre</a></li>
			<li><a id="availQuery6" onClick=selectQuery(6)>View All tracks in playlists</a></li>
			
			
		</ul>
	</div>
	
	
	<br />
	<br />
	
	
	
	
	
	
	
	<div class="col-lg-12">
		<div class="panel panel-primary">
			<div id="phead" class="panel-heading">
				<h4>
					<u id="selectedquery"></u>
				</h4>
			</div>
			<div id="collapseOne" class="panel-collapse collapse in">
				<div class="panel-body" style="font-size: 12px;">
					
					<div class="container" id="libIdPicker" style="display:none;">
						<label for="libIdDropdown">Choose Lib Id:</label> 
						<select id="libIdDropdown" class="js-data-example-ajax" style="width: 400px">
						</select>
					</div>
					<div class="container" id="playlistNamePicker" style="display:none;">
						<label for="playlistNameDropdown">Choose Playlist:</label> 
						<select id="playlistNameDropdown" class="js-data-example-ajax" style="width: 400px">
						</select>
					</div>
					<div class="container" id="trackArtistPicker" style="display:none;">
						<label for="trackArtistDropdown">Choose Artist:</label> 
						<select id="trackArtistDropdown" class="js-data-example-ajax" style="width: 400px">
						</select>
					</div>
					<div class="container" id="trackGenrePicker" style="display:none;">
						<label for="trackGenreDropdown">Choose Genre:</label> 
						<select id="trackGenreDropdown" class="js-data-example-ajax" style="width: 400px">
						</select>
					</div>
					<button id="query1" type="button" class="btn btn-primary">View</button>
				</div>
			</div>
		</div>
	</div>	
	<br />
	<br />
	




	<div id="tab1" class="col-lg-12" style="display:none;">
		<div class="panel panel-primary">
			<div id="phead" class="panel-heading">
				<h4>
					Library: <u id="selectedquery"></u>
				</h4>
			</div>
			<div id="collapseOne" class="panel-collapse collapse in">
				<div class="panel-body" style="font-size: 12px;">
					
					<table id="libraryTable">
						<thead>
							<tr>
								<th>ID</th>
								<th>Username</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
	</div>	
	
	
	
	
	<div id="tab2" class="col-lg-12" style="display:none;">
		<div class="panel panel-primary">
			<div id="phead2" class="panel-heading">
				<h4>
					Playlist: <u id="selectedquery"></u>
				</h4>
			</div>
			<div id="collapseOne2" class="panel-collapse collapse in">
				<div class="panel-body" style="font-size: 12px;">
				
					<table id="playlistTable">
						<thead>
							<tr>
								<th>ID</th>
								<th>Name</th>
								<th>Library ID</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
	</div>

	<div id="tab3" class="col-lg-12" style="display:none;">
		<div class="panel panel-primary">
			<div id="phead3" class="panel-heading">
				<h4>
					Tracks: <u id="selectedquery"></u>
				</h4>
			</div>
			<div id="collapseOne3" class="panel-collapse collapse in">
				<div class="panel-body" style="font-size: 12px;">
					<table id="trackTable">
						<thead>
							<tr>
								<th>ID</th>
								<th>Name</th>
								<th>Artist</th>
								<th>Album</th>
								<th>Genre</th>
								<th>Year</th>
								<th>Location</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
	</div>
	
	<div id="tab5" class="col-lg-12" style="display:none;">
		<div class="panel panel-primary">
			<div id="phead5" class="panel-heading">
				<h4>
					Playlist Tracks: <u id="selectedquery"></u>
				</h4>
			</div>
			<div id="collapseOne5" class="panel-collapse collapse in">
				<div class="panel-body" style="font-size: 12px;">
					<table id="ptrackTable">
						<thead>
							<tr>
								<th>Library ID</th>
								<th>Username</th>
								<th>Playlist ID</th>
								<th>Playlist Name</th>
								<th>Track ID</th>
								<th>Name</th>
								<th>Artist</th>
								<th>Album</th>
								<th>Genre</th>
								<th>Year</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
	</div>
	
	<div id="tab4" class="col-lg-12" style="display:none;">
		<div class="panel panel-primary">
			<div id="phead4" class="panel-heading">
				<h4>
					Tracks: <u id="selectedquery"></u>
				</h4>
			</div>
			<div id="collapseOne4" class="panel-collapse collapse in">
				<div class="panel-body" style="font-size: 12px;">
					<table id="trackTable2">
						<thead>
							<tr>
								<th>ID</th>
								<th>Name</th>
								<th>Artist</th>
								<th>Album</th>
								<th>Genre</th>
								<th>Year</th>
								<th>Location</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
	</div>
	
	
	
	<br />
	<br />
	

	<script>
	
	var selectedQuery=1;
	
	var username = null;
	
		$(document).ready(function() {
			$(function() {
				$(".js-example-responsive").select2();
				setUserDetails();
			});
		});

		function setUserDetails() {
			$.ajax({
				type : 'GET',
				url : './rest/users/currentUser',
				success : function(data) {
					var userBar = document.getElementById("userBar");
					username = data[0];
					userBar.innerHTML = "Logged in as: " + username;
				},
			});
		}

		function displayLibraries() {
			
			$.ajax({
				type : 'GET',
				url : './rest/library/getLibrary/'+encodeURI(username),
				dataType : 'json',
				success : function(data) {
					$('#libraryTable').dataTable({
						data : data,
						columns : [ {
							'data' : 'libraryPersistentId'
						}, {
							'data' : 'user.username'
						},]
					});
				}
			});
			$('#tab1').show();
			$('#tab2').hide();
			$('#tab3').hide();
			$('#tab4').hide();
			$('#tab5').hide();
		}
		
		
		function displayPlaylistsforLibId() {
			
			$.ajax({
				type : 'GET',
				url : './rest/playlist/getPlaylistsInLibrary/'+$("#libIdDropdown").select2('data')[0].text,
				dataType : 'json',
				success : function(data) {
					$('#playlistTable').dataTable({
						data : data,
						columns : [ {
							'data' : 'playlistId'
						}, {
							'data' : 'playlistName'
						}, {
							'data' : 'library.libraryPersistentId'
						}, ]
					});
				}
			});
			$('#tab1').hide();
			$('#tab2').show();
			$('#tab3').hide();
			$('#tab4').hide();
			$('#tab5').hide();
		}
		
		function displayTracksbyArtist() {
			
			$.ajax({
				type : 'GET',
				url : './rest/tracks/il-2/'+$("#trackArtistDropdown").select2('data')[0].text,
				dataType : 'json',
				success : function(data) {
					$('#trackTable').dataTable({
						data : data,
						columns : [ {
							'data' : 'trackId'
						}, {
							'data' : 'name'
						}, {
							'data' : 'artist'
						}, {
							'data' : 'album'
						}, {
							'data' : 'genre'
						}, {
							'data' : 'year'
						}, {
							'data' : 'location'
						}, ]
					});
				}
			});
			
			$('#tab1').hide();
			$('#tab2').hide();
			$('#tab3').show();
			$('#tab4').hide();
			$('#tab5').hide();
		}
		
		function displayTracksbyGenre() {
			
			$.ajax({
				type : 'GET',
				url : './rest/tracks/il-1/'+$("#trackGenreDropdown").select2('data')[0].text,
				dataType : 'json',
				success : function(data) {
					$('#trackTable2').dataTable({
						data : data,
						columns : [ {
							'data' : 'trackId'
						}, {
							'data' : 'name'
						}, {
							'data' : 'artist'
						}, {
							'data' : 'album'
						}, {
							'data' : 'genre'
						}, {
							'data' : 'year'
						}, {
							'data' : 'location'
						}, ]
					});
				}
			});
			
			$('#tab1').hide();
			$('#tab2').hide();
			$('#tab3').hide();
			$('#tab4').show();
			$('#tab5').hide();
			
		}
		
		
		
function tracksInPlaylist() {
			$.ajax({
				type : 'GET',
				url : './rest/playlistTrack',
				dataType : 'json',
				success : function(data) {
					$('#ptrackTable').dataTable({
						data : data,
						columns : [ {
							'data' : 'playlist.library.libraryPersistentId'
						}, {
							'data' : 'playlist.library.user.username'
						}, {
							'data' : 'playlist.playlistId'
						}, {
							'data' : 'playlist.playlistName'
						},{
							'data' : 'track.trackId'
						}, {
							'data' : 'track.name'
						}, {
							'data' : 'track.artist'
						}, {
							'data' : 'track.album'
						}, {
							'data' : 'track.genre'
						}, {
							'data' : 'track.year'
						},  ]
					});
				}
			});
			
			$('#tab1').hide();
			$('#tab2').hide();
			$('#tab3').hide();
			$('#tab4').hide();
			$('#tab5').show();
		}
		
		$("#libIdDropdown").select2({
		placeholder: 'Lib Id',
			 			ajax: {
			 				type : 'GET',
			 				url : './rest/library/getLibraryIds',
			 				success : function(data){
			 					for(i=0;i<data.length;i++){
			 						var opt = data[i];  
			 						var text = "<option value=\""+i+"\">"+opt+"</option>";
			 						$("#libIdDropdown").append(text);
			 					}
			 					var $example = $("#libIdDropdown").select2();
			 					$example.val("0").trigger("change");
			 				},
			 			}});
			 		
		
		$("#playlistNameDropdown").select2({
			placeholder: 'Playlist Name',
				 			ajax: {
 				type : 'GET',
 				url : './rest/playlist/getPlaylistNames',
 				success : function(data){
 					for(i=0;i<data.length;i++){
 						var opt = data[i];  
 						var text = "<option value=\""+i+"\">"+opt+"</option>";
 						$("#playlistNameDropdown").append(text);
 					}
 					var $example = $("#playlistNameDropdown").select2();
 					$example.val("0").trigger("change");
 				},
				 			}});
		
		$("#trackArtistDropdown").select2({
			placeholder: 'Artist Name',
				 			ajax: {
 				type : 'GET',
 				url : './rest/tracks/artists',
 				success : function(data){
 					for(i=0;i<data.length;i++){
 						var opt = data[i];  
 						var text = "<option value=\""+i+"\">"+opt+"</option>";
 						$("#trackArtistDropdown").append(text);
 					}
 					var $example = $("#trackArtistDropdown").select2();
 					$example.val("0").trigger("change");
 				},
				 			}});
		
		
		$("#trackGenreDropdown").select2({
			placeholder: 'Genre',
				 			ajax: {
 				type : 'GET',
 				url : './rest/tracks/genres',
 				success : function(data){
 					for(i=0;i<data.length;i++){
 						var opt = data[i];  
 						var text = "<option value=\""+i+"\">"+opt+"</option>";
 						$("#trackGenreDropdown").append(text);
 					}
 					var $example = $("#trackGenreDropdown").select2();
 					$example.val("0").trigger("change");
 				},
				 			}});
		
		$("#query1").click(function() {
			validate();
		});
		
		function validate(){
			switch(selectedQuery){
			case 1:
					showData();
				break;
			case 2:
				if($("#libIdDropdown").select2('data').length<1){
					alert("Select Lib Id");
				}
				else{
					showData();
				}
				break;
			case 3:
				if($("#playlistNameDropdown").select2('data').length<1){
					alert("Select Playlist Name");
				}
				else{
					showData();
				}
				break;
			case 4:
				if($("#trackArtistDropdown").select2('data').length<1){
					alert("Choose Artist");
				}
				else{
					showData();
				}
				break;
			case 5:
				if($("#trackGenreDropdown").select2('data').length<1){
					alert("Choose Genre");
				}
				else{
					showData();
				}
				break;
			case 6:
					showData();
				break;
			}
		}
		
		function showData(){
			$('#collapseOne').collapse("hide");
			setTimeout(getData, 300);
		}
		
		function getData() {
			var queryUrl='./rest/';
switch(selectedQuery){
			case 1:
				displayLibraries();
				break;
			case 2:
				displayPlaylistsforLibId();
				break;
			case 3:
			//	queryUrl+="playlist/getPlaylistsInLibrary/"+$("#libIdDropdown").select2('data')[0].text;
				break;
			case 4:
				displayTracksbyArtist();
				break;
			case 5:
				displayTracksbyGenre();
				break;
			case 6:
				tracksInPlaylist();
				break;
			}
		}			
			

					
				
					
		
		function selectQuery(i){
						
			var libIdPicker=document.getElementById("libIdPicker");
			var playlistNamePicker=document.getElementById("playlistNamePicker");
			var trackArtistPicker=document.getElementById("trackArtistPicker");
			var trackGenrePicker=document.getElementById("trackGenrePicker");
			
			selectedQuery=i;
			document.getElementById("selectedquery").innerHTML=document.getElementById("availQuery"+selectedQuery).innerHTML;
			
			libIdPicker.style.display="none";
			playlistNamePicker.style.display="none";
			trackArtistPicker.style.display="none";
			trackGenrePicker.style.display="none";
			
			switch(selectedQuery){
			case 1:
				break;
			case 2:
				libIdPicker.style.display="block";
				break;
			case 3:
				playlistNamePicker.style.display="block";
				break;
			case 4:
				trackArtistPicker.style.display="block";
				break;
			case 5:
				trackGenrePicker.style.display="block"
				break;
			case 6:
				break;
			}
			$('#collapseOne').collapse("show");
			$('#collapseTwo').collapse('hide');
		}
		
	</script>
</body>
</html>

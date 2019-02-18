<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<style>
body
{
	margin:0;
	font-family:Verdana, sans-serif;
	background-image:url("images/Mbgimg0.jpg") no-repeat y center center fixed;
	webkit-background-size: cover;
    moz-background-size: cover;
    o-background-size: cover;
    background-size: cover;
    min-height: 100%;
}

#menu ul ul
{
	display:none;
	position:absolute;
	background-color:#5c5c5c;
}

#menu ul li:hover ul
{
	display:block;
}

.nav-container
{
	display:flex;
	flex-direction:row;
	width:100%;
	margin:0;
	padding:0;
	background-color:darkslategrey;
	list-style-type:none;
}

.nav-item
{
	padding:20px;
	cursor:pointer;
}

.nav-item a
{
	text-align:center;
	text-decoration:none;
	color:white;
}

.nav-item:nth-child(1)
{
	background-color:lightseagreen;
}

.nav-item:hover
{
	background-color : grey;
}

</style>

<title>MounT Main</title>
</head>
<body style="background-image:url(images/Mbgimg0.jpg);">
	<%-------------------- 위 메뉴선택바 --------------------%>
	<nav>
		<div id="menu">
		<ul class="nav-container">
			<li class="nav-item"><a href="">메인으로</a></li>
			<li class="nav-item"><a href="">산 소개</a></li>
			<li class="nav-item"><a href="">공지사항</a></li>
			<li class="nav-item"><a href="">회원공간</a>
				<ul>
					<li><a href="">산행모집</a></li>
					<li><a href="">커뮤니티</a></li>
				</ul>
			</li>
			<li class="nav-item"><a href="">산행후기</a>
				<ul>
					<li><a href="">갤러리</a></li>
					<li><a href="">후기</a></li>
				</ul>
			</li>
			<li class="nav-item"><a href="">고객센터</a>
				<ul>
					<li><a href="">문의하기</a></li>
					<li><a href="">신고하기</a></li>
				</ul>
			</li>
		</ul>
		</div>
	</nav>
	<%-------------------- 사진 슬라이드쇼 --------------------%>
	<div class="w3-content w3-section" style="max-width:500px">
		<img class="mySlides w3-animate-fading" src="images/Mimg1.jpg" style="width:100%">
		<img class="mySlides w3-animate-fading" src="images/Mimg2.jpg" style="width:100%">
		<img class="mySlides w3-animate-fading" src="images/Mimg3.jpg" style="width:100%">
		<img class="mySlides w3-animate-fading" src="images/Mimg4.jpg" style="width:100%">
		<img class="mySlides w3-animate-fading" src="images/Mimg5.jpg" style="width:100%">
		<img class="mySlides w3-animate-fading" src="images/Mimg6.jpg" style="width:100%">
		
		<button class="w3-button w3-black w3-display-left" onclick="plusDivs(-1)">&#10094;</button>
  		<button class="w3-button w3-black w3-display-right" onclick="plusDivs(1)">&#10095;</button>
	</div>
	
<script>

var myIndex = 0;
carousel();

function carousel() 
{
  var i;
  var x = document.getElementsByClassName("mySlides");
  for (i = 0; i < x.length; i++) 
  {
    x[i].style.display = "none";  
  }
  myIndex++;
  if (myIndex > x.length) {myIndex = 1}    
  x[myIndex-1].style.display = "block";  
  setTimeout(carousel, 5000);    
}

</script>
	
</body>
</html>
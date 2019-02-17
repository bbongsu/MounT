<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
myColor = new Array
(
"000000","101010","202020","303030",
"404040","505050","606060","707070",
"808080","909090","A0A0A0","B0B0B0",
"C0C0C0","D0D0D0","E0E0E0","FFFFFF"
);

myCnt = 0;
function myFade(){
     if (myCnt != 16){
         document.bgColor = "#" + myColor[myCnt];
         myTime = ( myCnt==0 || myCnt==15 ) ? 1000 : 50;
         myCnt++;
         setTimeout( "myFade()", myTime );
     }
     else
     {
    	 location.href = "login.jsp";
     }
}
</script>
 
<br><br><br><br><br><br><br>
<p align="center">
<font color="#FFFFFF" size="5">
<strong>1조</strong>
</font><br><br>
<font color="#FFFFFF" size="6">
<strong>Hello! Welcome to</strong>
</font><br><br>
<font color="#000000" size="6">
<strong>MounT Homepage</strong>
</font><br>
</p>
 
 
<script type="text/javascript">
myFade();
</script>
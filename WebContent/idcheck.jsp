<%@page import="register.registerDAO"%>
<%@page import="register.iregisterDAO"%>
<%
String id = request.getParameter("id");
System.out.println("id = " + id);

iregisterDAO dao = registerDAO.getInstance();
boolean isS = dao.getId(id);

if(isS)
{
	out.print("NO");
}
else
{	
	out.print("OK");
}
%>
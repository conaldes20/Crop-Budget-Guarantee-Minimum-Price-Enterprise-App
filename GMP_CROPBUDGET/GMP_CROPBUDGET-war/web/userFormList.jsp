<%-- 
    Document   : userFormList
    Created on : Jul 30, 2016, 12:32:00 AM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CROP BUDGET</title>
  <style>
body, input {
	font-family: Calibri, Arial;
	margin: 0px;
	padding: 0px;
}
#header h2 {
	color: white;
	background-color: #3275A8;
	height: 40px;
	padding: 5px 0 0 5px;
}       
#content { 
    padding: 5px; 
    margin: 5px; 
    text-align: center
}
</style>
<body>
    <div id="content" align="center"> 
  <c:if test="${fn:length(errors) == 0 && loginParams != ''}">
      <p><font color=red>${loginParams}</font>
  </c:if>    
  <c:if test="${respmsg != ''}" >	
      <p><font color=blue>Message from server: ${respmsg}</font>
  </c:if>
   <br/>
  <c:if test="${fn:length(errors) != 0}" >	
     <p><font color=red>ERROR MESSAGE:</font>
     <ul>
        <c:forEach var="item" items="${errors}">
          <li ><font color=red>${item}</font>
        </c:forEach>
     </ul>
  </c:if>
  <fieldset>
      <H3>PROJECTED RETURNS USING CROP BUDGET: ADD USER</H3> 
        <form name="user" action="cropbdgtgmp" method="post">
        <table class="datatable" border=0 cellspacing=2 cellpadding=2 width="50%" align="center">
            <tr align=center valign=top>
                <td width="220" height="20" bgcolor="#CCFFFF">User Name:</td>
                <td bgcolor="#E0E0E0"><input type="text" name="username" value="${username}" /></td>
            </tr>
            <tr align=center valign=top>
                <td width="220" height="20" bgcolor="#CCFFFF">Password:</td>
                <td bgcolor="#E0E0E0"><input type="password" name="password" value="${password}" /></td>
            </tr> 
            <tr align=center valign=top>
                <td width="220" height="20" bgcolor="#CCFFFF">Role:</td>
                <td bgcolor="#E0E0E0"><input type="text" name="role" value="${role}" /></td>
            </tr> 
            <tr align=center valign=top>
                <td width="220" height="20" bgcolor="#CCFFFF"></td>
                <td bgcolor="#E0E0E0"><input type="submit" name="addusrparams" value="Save" /></td>            
            </tr>
            
        </table> 
        </form>
        <br/>
        <table class="datatable" border=0 cellspacing=2 cellpadding=2 width="50%" align="center"> 
            <tr align=center valign=top>
                <td bgcolor="#C0C0C0">Username</td>               
                <td bgcolor="#C0C0C0">Role</td>
            </tr>
            <c:forEach var="item" items="${usernamesRoles}">
                <tr align=center valign=top>                    
                    <td bgcolor="#E0E0E0">${item.username}</td> <td bgcolor="#E0E0E0">${item.role}</td>
                </tr>
            </c:forEach>
        </table>        
  </fieldset>    
</div> 
  <a href="serviceslist.jsp">Services list Page</a>
</body>
</html>       

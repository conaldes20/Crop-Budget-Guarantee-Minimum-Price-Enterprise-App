<%-- 
    Document   : login
    Created on : Jul 29, 2016, 12:18:56 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head><title>CROP BUDGET</title>

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
        
        <c:if test="${respmsg != ''}" >	
            <p><font color=blue>${respmsg}</font>
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
      <H3>PROJECTED RETURNS USING CROP BUDGET: ${reqservice}</H3>           
         <form name="servath" action="cropbdgtgmp" method="post">
        <table class="datatable" border=0 cellspacing=2 cellpadding=2 width="50%" align="center">
            <tr align=center valign=top>
                <td width="220" height="20" bgcolor="#CCFFFF">User Name:</td>
                <td bgcolor="#E0E0E0"><input type="text" name="userlogin" value="${userlogin}"/></td>
            </tr>
            <tr align=center valign=top>
                <td width="220" height="20" bgcolor="#CCFFFF">Password:</td>
                <td bgcolor="#E0E0E0"><input type="password" name="psswdlogin" value="${psswdlogin}" /></td>
            </tr>            
            <tr align=center valign=top>
                <td width="220" height="20" bgcolor="#CCFFFF">
                    <input type="hidden" name="reqservice" value="${reqservice}"/>
                    <input type="hidden" name="fromlogin" value="login" />
                    <input type="hidden" name="accesscntrl" value="access"/>
                    <input type="hidden" name="locdetails" value="${locdetails}"/> 
                </td>
                <td bgcolor="#E0E0E0"><input type="submit" name="logincntrl" value="Submit" /></td>            
            </tr> 
        </table>
       </form>
    </fieldset> 
</div>
    <a href="serviceslist.jsp">Services list Page</a>
</body>
</html>  

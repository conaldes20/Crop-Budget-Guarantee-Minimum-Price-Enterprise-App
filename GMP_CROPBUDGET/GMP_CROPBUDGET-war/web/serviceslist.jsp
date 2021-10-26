<%-- 
    Document   : index
    Created on : Jul 30, 2016, 9:46:59 AM
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
    <H3>PROJECTED RETURNS USING CROP BUDGET</H3>
    <br>
  <fieldset>
  <c:choose>
    <c:when test="${fn:length(servicesA) == 0}">
        <p>No Services.
    </c:when>
    <c:when test="${fn:length(servicesA) != 0}">    
    <table border=0 cellspacing=2 cellpadding=2 width="50%" align="center">
        <tr align=center valign=top>
            <td bgcolor="#C0C0C0" colspan="2">Available Services</td>
        </tr>
        
          <c:forEach var="item" items="${servicesA}">
              <tr align=center valign=top>
          <td height="10" bgcolor="#CCFFFF"><div align="center"><p><b> ${item}</b></div></td>
          <td height="10" bgcolor="#E0E0E0"><div align="center"><p><b>
          <%-- <c:choose>
            <c:when test="${item == 'DataEntry'}">
                <form name="servath" action="/ControllerServlet" method="post">
            </c:when>
            <c:when test="${item == 'UpdateCropLocationLists'}">
                <form name="servath" action="/ControllerServlet" method="post">
            </c:when>
            <c:when test="${item == 'ViewReport'}">
                <form name="servath" action="reportVars.jsp" method="post">
            </c:when>
            <c:when test="${item == 'DataUpdate'}">
                <form name="servath" action="reportVars.jsp" method="post">
            </c:when>
            <c:when test="${item == 'UserAccessControl'}">
                <form name="servath" action="login.jsp" method="post">
            </c:when>        
            <c:otherwise>

            </c:otherwise>
            <input type="hidden" name="reqservice" value="${item}" /> 
            <input type="submit" value="Connect" />
            </c:choose>
            </form> --%>
            <form name="servath" action="cropbdgtgmp" method="get">
                <input type="hidden" name="reqservice" value="${item}" /> 
                <input type="submit" name="indecntrl" value="Connect" />
            </form>
            </b></div></td>
            </tr>
        </c:forEach>            
    </table>
    </c:when>
    <c:otherwise>
    </c:otherwise>
   </c:choose>
  <br>
  </fieldset>
  </div>
    <a href="index.jsp">Back to Home Page</a>
</body>
</html>
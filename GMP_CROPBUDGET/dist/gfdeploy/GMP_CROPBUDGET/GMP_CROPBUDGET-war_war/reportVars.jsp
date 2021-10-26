<%-- 
    Document   : reportVars
    Created on : Jul 30, 2016, 12:26:59 AM
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
  <c:if test="${fn:length(errors) != 0}" >	
     <p><font color=red>ERROR MESSAGE:</font>
     <ul>
        <c:forEach var="item" items="${errors}">
          <li ><font color=red>${item}</font>
        </c:forEach>
     </ul>
  </c:if>
  <fieldset>
      <H3>PROJECTED RETURNS USING CROP BUDGET: SELECT CROP AND YEAR RANGE</H3>
      <form name="user" action="cropbdgtgmp" method="get">
    <table class="datatable" border=0 cellspacing=2 cellpadding=2 width="50%" align="center">
        
        <tr align=center valign=top>
            <td bgcolor="#CCFFFF">
                <SELECT NAME="CROP" SIZE="3">
                    <c:forEach var="item" items="${crops}">
                        <OPTION>${item}</OPTION>
                    </c:forEach> 
                </SELECT>
            </td>
        </tr>
        <tr align=center valign=top>
            <td bgcolor="#CCFFFF">
                <SELECT NAME="LOCATION" SIZE="3">
                    <c:forEach var="item" items="${locations}">
                        <OPTION>${item}</OPTION>
                    </c:forEach>
                </SELECT>
            </td>
        </tr>
        <tr  align=center valign=top>
            <td bgcolor="#CCFFFF">
                <SELECT NAME="STARTYEAR" SIZE="3">
                    <c:forEach var="item" items="${years}">
                        <OPTION>${item}</OPTION>
                    </c:forEach>
                </SELECT>
            </td>
        </tr>
        <tr align=center valign=top>
            <td bgcolor="#CCFFFF">
                <SELECT NAME="ENDYEAR" SIZE="3">
                    <c:forEach var="item" items="${years}">
                        <OPTION>${item}</OPTION>
                    </c:forEach>
                </SELECT>
            </td>
        </tr>
        <tr  align=center valign=top>
            <td bgcolor="#CCFFFF">
                <input type="submit" name="rptVarContl" value="Connect" />
            </td>
        </tr>
       
    </table>
    </form>
  </fieldset>
  <a href="serviceslist.jsp">Services list Page</a>
  </div>
</body>
</html>      
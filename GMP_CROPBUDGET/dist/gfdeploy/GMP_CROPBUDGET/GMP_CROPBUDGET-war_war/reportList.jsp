<%-- 
    Document   : reportList
    Created on : Jul 30, 2016, 12:22:58 AM
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
  <fieldset>
      <H3>PROJECTED RETURNS USING CROP BUDGET: LIST OF REPORTS</H3> 
      <form name="cropBDGVUP" action="cropbdgtgmp" method="get"> 
  <table class="datatable" border=0 cellspacing=1 cellpadding=1 width="100%" align="center">      
     <tr align=center valign=top>
        <td bgcolor="#C0C0C0">CROP AND LOCATION</td>
        <td bgcolor="#C0C0C0"></td>
        <td bgcolor="#C0C0C0"></td>
        <td bgcolor="#C0C0C0"></td>
        <td bgcolor="#C0C0C0"></td>
     </tr>   
     <tr>
         <td width="520" height="5" bgcolor="#CCFFFF"><p>If Yield(tons/ha) is 2 and Market Price/ton is N70,000, ignore the text boxes.</p></td>          
         <td bgcolor="#E0E0E0" colspan="2">Yield(tons/ha):<input type="text" name="yield" maxlength="2"/> 
          </td>
          <td bgcolor="#E0E0E0" colspan="2">Market Price/ton:<input type="text" name="mktp" maxlength="7"/>
          </td>
          
     </tr>
        <c:forEach var="item" items="${locationsInfos}">             
        <tr>     
                <td width="520" height="5" bgcolor="#CCFFFF"><div align="right"><p><b> ${item}</b></div></td>          
                <td bgcolor="#E0E0E0"> 
                      <input type="hidden" name="locdetails" value="${item}" />
                      <input type="submit" name="viewTAContl" value="View TYPE A" />
                </td>
                <td bgcolor="#E0E0E0"> 
                      <input type="hidden" name="locdetails" value="${item}" />
                      <input type="submit" name="viewTBContl" value="View TYPE B" />
                </td>
                <td bgcolor="#E0E0E0">
                      <input type="hidden" name="locdetails" value="${item}" />
                      <input type="hidden" name="reqservice" value="RatesUpdate" />
                      <input type="submit" name="updateRContl" value="Update RATE" />
                </td>
                <td bgcolor="#E0E0E0">
                      <input type="hidden" name="locdetails" value="${item}" />
                      <input type="hidden" name="reqservice" value="QtiesUpdate" />
                      <input type="submit" name="updateQContl" value="Update QTY" />
                </td>             
        </tr>             
        </c:forEach>
    </table>
    </form>
  </div>
  <a href="reportVars.jsp">Back to Report Variables Page</a>
</body>
</html>
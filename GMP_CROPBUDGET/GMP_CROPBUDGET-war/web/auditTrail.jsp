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
          <form name="audittrl" action="cropbdgtgmp" method="post">
          <table class="datatable" border=0 cellspacing=1 cellpadding=1 width="70%" align="center">      
            <tr align=center valign=top>
                <td bgcolor="#C0C0C0" colspan="2">LOGGED SUMMARY ON A DATE</td>
            </tr> 
            <tr>
                <td bgcolor="#E0E0E0">
                    <pre style="font-size: 12pt">                                       
                        User Name    : <input type="text" name="${usrname}"/> 
                        Date Format (DD/MM/YYYY)
                        Starting Date: <input type="text" name="${logDate1}"/> 
                        Ending Date  : <input type="text" name="${logDate2}"/> 
                    </pre>
                </td>
            </tr>                        
            <tr>
                <td bgcolor="#E0E0E0">                          
                       <input type="submit" name="usrncntrl" value="Get Summaries" />                    
                </td>
            </tr>
           </table>
           <table class="datatable" border=0 cellspacing=1 cellpadding=1 width="70%" align="center">
            <c:forEach var="item" items="${loggedsummaries}">
            <tr>
                <%--  <td height="5" bgcolor="#CCFFFF"><div align="right"><p><b> ${item}</b></div></td> --%>
                <td bgcolor="#E0E0E0">
                     <%-- <input type="hidden" name="lgdetail" value="${item}"/>
                     <input type="hidden" name="username" value="${usrname}"/>
                     --%>
                     <input type="submit" name="loggedcntrl" value="${item}" />
                </td>
            </tr>
            </c:forEach>
           </table>
           <table class="datatable" border=0 cellspacing=1 cellpadding=1 width="70%" align="center">
            <tr align=center valign=top>
                <td height="5" bgcolor="#CCFFFF" colspan="2">LOGGED DETAILS</td>
            </tr>            
            <tr align=center valign=top>
                <td height="50" bgcolor="#E0E0E0" colspan="2"><p>${loggeddetails}</p></td>
            </tr> 
           </table> 
          </form>
       </fieldset>    
    </div>
    <a href="serviceslist.jsp">Services list Page</a>
</body>
</html>  

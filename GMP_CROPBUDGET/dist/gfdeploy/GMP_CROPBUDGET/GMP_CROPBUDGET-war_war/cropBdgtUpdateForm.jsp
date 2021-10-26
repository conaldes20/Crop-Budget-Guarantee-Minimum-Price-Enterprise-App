<%-- 
    Document   : cropBDGTForm
    Created on : Jul 29, 2016, 11:06:36 PM
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
    
<style type="text/css">
<!--
.font2 {
	font-family: Lucida Console, Monaco, monospace;
}
.font1 {
	font-family: Palatino Linotype, Book Antiqua, Palatino, serif;
}
.font2 {
	font-family: Verdana, Geneva, sans-serif;
}
.font2 {
	font-family: Tahoma, Geneva, sans-serif;
}
.font3 {
	font-family: Tahoma, Geneva, sans-serif;
}
.font3 {
	font-family: Tahoma, Geneva, sans-serif;
}
.font3 {
	font-family: Tahoma, Geneva, sans-serif;
}
.font3 {
	font-family: Tahoma, Geneva, sans-serif;
}
.font3 {
	font-family: Tahoma, Geneva, sans-serif;
}
.font3 {
	font-family: Tahoma, Geneva, sans-serif;
}
.font4 {
	font-family: Palatino Linotype, Book Antiqua, Palatino, serif;
}
.font4 {
	font-family: Palatino Linotype, Book Antiqua, Palatino, serif;
}
.font4 {
	font-family: Palatino Linotype, Book Antiqua, Palatino, serif;
}
.font4 {
	font-family: Palatino Linotype, Book Antiqua, Palatino, serif;
}
#font5 {
	font-family: Lucida Sans Unicode, Lucida Grande, sans-serif;
}
#font5 {
	font-family: Lucida Sans Unicode, Lucida Grande, sans-serif;
}
#font5 {
	font-family: Georgia, Times New Roman, Times, serif;
}
#font5 {
	font-family: Georgia, Times New Roman, Times, serif;
}
#font5 {
	color: #000;
}
.fontAA {
	font-family: Verdana, Geneva, sans-serif;
}
.fontAA {
	font-family: Verdana, Geneva, sans-serif;
}
#font3 {
	font-family: Tahoma, Geneva, sans-serif;
}
.fontAA {
	font-family: Lucida Console, Monaco, monospace;
}
.fontAA .fontAA strong {
	font-family: Times New Roman, Times, serif;
}
.fontAA .fontAA strong {
	font-family: Courier New, Courier, monospace;
}
.fontAA .fontAA strong {
	font-family: Verdana, Geneva, sans-serif;
}
.fontAA .fontAA strong {
	font-family: Arial, Helvetica, sans-serif;
}
.fontAA .fontAA strong {
	font-family: Trebuchet MS, Arial, Helvetica, sans-serif;
}
.fontAA .fontAA strong {
	font-family: MS Serif, New York, serif;
}
body p {
	font-family: Verdana, Geneva, sans-serif;
}
-->
</style>
<script src="SpryAssets/SpryValidationSelect.js" type="text/javascript"></script>
<link href="SpryAssets/SpryValidationSelect.css" rel="stylesheet" type="text/css" />
</head>

<body>
    <div align="center"> 
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
   </div>
	<form action="cropbdgtgmp" method="post">    
      <table width="670" border="0" align="center">
         <tr>
        	<td  height="2" bgcolor="#999900" colspan="2"><h3 align="center"><b>PROJECTED RETURNS USING CROP BUDGET</b></h3></td>
        </tr>          
        <tr>
          <td width="675" height="40" bgcolor="#99FF99">
          <table width="687" border="1">
            <tr>
              <td width="87" rowspan="19"><table width="84" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="77" class="font4">STAGE 1</td>
                </tr>
              </table></td>
              <td height="28" colspan="5">
              <div>
                   <p>CROP:
  <input name="crop" type="text" id="croptxt" value="${cbdgtparams.getCrop()}" size="25" maxlength="25" />  
                   </p>
                   <p>LOCATION:
  <input name="location" type="text" id="locationtxt" value="${cbdgtparams.getLocation()}" size="45" maxlength="45" />
                   </p>
                   <p>YEAR:
  <input name="year" type="text" id="yeartxt" value="${cbdgtparams.getYeear()}" size="6" maxlength="6" />  
                   FARMING TYPE:
  <input name="farmingtype" type="text" id="plttypetxt" value="${cbdgtparams.getPltype()}" size="25" maxlength="25" />
                   </p>
</div>
               
                      <span class="fontAA"></span><span class="fontAA"></span></td>
            </tr>
            <tr class="font1">
              <td width="88"><div align="center">Main Operation</div></td>
              <td width="109"><div align="center">Activity</div></td>
              <td width="85"><div align="center">Units</div></td>
              <td width="188"><div align="center">Quantity</div></td>
              <td width="90"><div align="center">Rate N</div></td>
            </tr>
            <tr>
              <td rowspan="6"><table cellspacing="0" cellpadding="0">
                <tr>
                  <td width="182" class="font3">Land Preparation</td>
                </tr>
              </table></td>
              <td height="10"></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td width="109" height="29" class="font2">Land Rent</td>
              <td width="85" class="font2"><div align="center">Lump Sum</div></td>
              <td><label for="lrsum"></label>
                ${cbdgtqties.getQuantity1()}              </td>
              <td><label for="rate1"></label>
                <div align="center">
                  <input name="rate1" type="text" id="rate1" value="${cbdgtparams.getVarrate1()}" size="15" maxlength="15" />
              </div></td>
            </tr>
            <tr>
              <td width="109" height="32" class="font2">Land Preparation</td>
              <td width="85" class="font2" valign="middle"><div align="center">man-days</div></td>
              <td><label for="lrsum"></label>
                ${cbdgtqties.getQuantity2()}                </td>
              <td><label for="rate1"></label>
                <div align="center">
                  <input name="rate2" type="text" id="rate2" value="${cbdgtparams.getVarrate2()}" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td width="109" height="30" class="font2">Ploughing</td>
              <td width="85" class="font2"><div align="center">ha</div></td>
              <td><label for="lrsum"></label>
                ${cbdgtqties.getQuantity3()}                </td>
              <td><label for="rate1"></label>
                <div align="center">
                  <input name="rate3" type="text" id="rate3" value="${cbdgtparams.getVarrate3()}" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td width="109" height="28" class="font2">Ridging</td>
              <td width="85" class="font2"><div align="center">ha</div></td>
              <td><label for="lrsum"></label>
                ${cbdgtqties.getQuantity4()}                </td>
              <td><label for="rate1"></label>
                <div align="center">
                  <input name="rate4" type="text" id="rate4" value="${cbdgtparams.getVarrate4()}" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td width="109" height="29" class="font2">Harrowing</td>
              <td width="85" class="font2"><div align="center">ha</div></td>
              <td><label for="lrsum"></label>
                ${cbdgtqties.getQuantity5()}                </td>
              <td><label for="rate1"></label>
                <div align="center">
                  <input name="rate5" type="text" id="rate5" value="${cbdgtparams.getVarrate5()}" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td rowspan="6"><table cellspacing="0" cellpadding="0">
                <tr>
                  <td width="182" class="font3">Seedling and Planting</td>
                </tr>
              </table></td>
              <td width="109" height="26" class="font2">Seeds</td>
              <td width="85" class="font2"><div align="center">kg/ha</div></td>
              <td><label for="lrsum"></label>
                ${cbdgtqties.getQuantity6()}                </td>
              <td><label for="rate1"></label>
                <div align="center">
                  <input name="rate6" type="text" id="rate6" value="${cbdgtparams.getVarrate6()}" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td width="109" height="32" class="font2">Seed dressing</td>
              <td width="85" class="font2"><div align="center">3kg/ha</div></td>
              <td><label for="lrsum"></label>
                ${cbdgtqties.getQuantity7()}                </td>
              <td><label for="rate1"></label>
                <div align="center">
                  <input name="rate7" type="text" id="rate7" value="${cbdgtparams.getVarrate7()}" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td width="109" height="36" class="font2">Planting</td>
              <td width="85" class="font2"><div align="center">man-days/ha</div></td>
              <td><label for="lrsum"></label>
                ${cbdgtqties.getQuantity8()}                </td>
              <td><label for="rate1"></label>
                <div align="center">
                  <input name="rate8" type="text" id="rate8" value="${cbdgtparams.getVarrate8()}" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td width="109" height="31" class="font2">1st weeding</td>
              <td width="85" class="font2"><div align="center">man-days/ha</div></td>
              <td><label for="lrsum"></label>
                ${cbdgtqties.getQuantity9()}                </td>
              <td><label for="rate1"></label>
                <div align="center">
                  <input name="rate9" type="text" id="rate9" value="${cbdgtparams.getVarrate9()}" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td width="109" height="31" class="font2">2nd hand weeding</td>
              <td width="85" class="font2"><div align="center">man-days/ha</div></td>
              <td><label for="lrsum"></label>
                ${cbdgtqties.getQuantity10()}                </td>
              <td><label for="rate1"></label>
                <div align="center">
                  <input name="rate10" type="text" id="rate10" value="${cbdgtparams.getVarrate10()}" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td width="109" height="29" class="font2">Transportation Cost</td>
              <td width="85" class="font2"><div align="center">Bag</div></td>
              <td><label for="lrsum"></label>
                ${cbdgtqties.getQuantity11()}                </td>
              <td><label for="rate1"></label>
                <div align="center">
                  <input name="rate11" type="text" id="rate11" value="${cbdgtparams.getVarrate11()}" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td rowspan="5"><table cellspacing="0" cellpadding="0">
                <tr>
                  <td width="181" class="font3">Fertilizer Application</td>
                </tr>
              </table></td>
              <td width="109" height="33" class="font2">Basical Application</td>
              <td width="85" class="font2"><div align="center">Bag</div></td>
              <td><label for="lrsum"></label>
                ${cbdgtqties.getQuantity12()}                </td>
              <td><label for="rate1"></label>
                <div align="center">
                  <input name="rate12" type="text" id="rate12" value="${cbdgtparams.getVarrate12()}" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td width="109" height="44" class="font2">Side dressing (4-5 weeks after planting) with NPK</td>
              <td width="85" class="font2"><div align="center">Bag</div></td>
              <td><label for="lrsum"></label>
                ${cbdgtqties.getQuantity13()}                </td>
              <td><label for="rate1"></label>
                <div align="center">
                  <input name="rate13" type="text" id="rate13" value="${cbdgtparams.getVarrate13()}" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td width="109" height="34" class="font2">Application of NPK Fertilizer/day</td>
              <td width="85" class="font2"><div align="center">man-days/ha</div></td>
              <td><label for="lrsum"></label>
                ${cbdgtqties.getQuantity14()}                </td>
              <td><label for="rate1"></label>
                <div align="center">
                  <input name="rate14" type="text" id="rate14" value="${cbdgtparams.getVarrate14()}" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td width="109" height="30" class="font2">Application of urea Fertilizer/day</td>
              <td width="85" class="font2"><div align="center">man-days/ha</div></td>
              <td><label for="lrsum"></label>
                ${cbdgtqties.getQuantity15()}                </td>
              <td><label for="rate1"></label>
                <div align="center">
                  <input name="rate15" type="text" id="rate15" value="${cbdgtparams.getVarrate15()}" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td width="109" height="27" class="font2">Bird Scarng</td>
              <td width="85" class="font2"><div align="center">man-days/ha</div></td>
              <td>${cbdgtqties.getQuantity16()}              </td>
              <td><div align="center">
                <input name="rate16" type="text" id="rate16" value="${cbdgtparams.getVarrate16()}" size="15" maxlength="15" />
              </div></td>
            </tr>
            <tr>
              <td rowspan="5"><table width="87" cellpadding="0" cellspacing="0" class="font4">
                <tr>
                  <td width="85">STAGE 2</td>
                </tr>
              </table></td>
              <td rowspan="5"><table cellspacing="0" cellpadding="0">
                <tr>
                  <td width="183" class="font3">Pest and Disease Control</td>
                </tr>
              </table></td>
              <td height="23" class="font2"></td>
              <td class="font2"><div align="center"></div></td>
              <td><div align="center"></div></td>
              <td><div align="center"></div></td>
            </tr>
            <tr>
              <td width="109" height="33" class="font2">Insecticide</td>
              <td width="85" class="font2"><div align="center">litre/ha</div></td>
              <td><label for="lrsum"></label>
                <div align="center">${cbdgtqties.getQuantity17()}
                </div></td>
              <td><label for="rate1"></label>
                <div align="center">
                  <input name="rate17" type="text" id="rate17" value="${cbdgtparams.getVarrate17()}" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td width="109" height="31" class="font2">Labour (Spraying)</td>
              <td width="85" class="font2"><div align="center">man-days/ha</div></td>
              <td><label for="lrsum"></label>
                <div align="center">${cbdgtqties.getQuantity18()}
              </div></td>
              <td><label for="rate1"></label>
                <div align="center">
                  <input name="rate18" type="text" id="rate18" value="${cbdgtparams.getVarrate18()}" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td width="109" height="32" class="font2">Transportation</td>
              <td width="85" class="font2"><div align="center">Lump Sum</div></td>
              <td><label for="lrsum"></label>
                <div align="center">${cbdgtqties.getQuantity19()}
                </div></td>
              <td><label for="rate1"></label>
                <div align="center">
                  <input name="rate19" type="text" id="rate19" value="${cbdgtparams.getVarrate19()}" size="15" maxlength="15" />
                </div></td>
            </tr>            
          </table>
        </tr>
        <tr>
            <td width="675"><div align="center"><em>                                
                <input type="submit" name="updaterate" id="font5" value="UPDATE"  style="background-color:#FC3"/>
      			 </em></div>
            </td>
            <td width="17"><div align="center"><em>                                
                <input type="hidden" name="locdetails" value="${locdetails}" />
      			 </em></div>
            </td>
            <td width="17"><div align="center"><em>                                
                <input type="hidden" name="fromSelf" value="self" />
      			 </em></div>
            </td>
  	</tr>        
      </table>
</form>
<a href="reportList.jsp">Report list page</a>
</body>
</html>

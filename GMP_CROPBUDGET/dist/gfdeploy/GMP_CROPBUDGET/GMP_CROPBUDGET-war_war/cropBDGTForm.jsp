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
  </div>
	<form action="cropbdgtgmp" method="post">    
      <table width="670" border="0" align="center">
         <tr>
        	<td  height="2" bgcolor="#999900" colspan="2"><h3 align="center"><b>PROJECTED RETURNS USING CROP BUDGET</b></h3></td>
        </tr>          
        <tr>
          <td width="664" height="40" bgcolor="#99FF99">
          <table width="682" border="1">
            <tr>
              <td width="87" rowspan="19"><table width="84" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="77" class="font4">STAGE 1</td>
                </tr>
              </table></td>
              <td height="20" colspan="5">
              <div>
                   <p>CROP:
                    <select name="crop" id="crop">
                        <c:forEach var="item" items="${crops}">
                            <OPTION>${item}</OPTION>
                        </c:forEach>
                    </select>  
                   LOCATION:
                    <select name="location" id="loc">
                        <c:forEach var="item" items="${locations}">
                              <OPTION>${item}</OPTION>
                        </c:forEach>
                    </select>
                   </p>
                   <p>YEAR:
                    <select name="year" id="yer">
                        <c:forEach var="item" items="${years}">
                            <OPTION>${item}</OPTION>
                        </c:forEach>
                    </select> 
                   FARMING TYPE:
                    <select name="farmingtype" id="fmtype">
                        <c:forEach var="item" items="${farmingtypes}">
                            <OPTION>${item}</OPTION>
                        </c:forEach>
                    </select>
                   </p>
</div>
               
                      <span class="fontAA"></span><span class="fontAA"></span></td>
            </tr>
            <tr class="font1">
              <td width="88"><div align="center">Main Operation</div></td>
              <td width="112"><div align="center">Activity</div></td>
              <td width="55"><div align="center">Units</div></td>
              <td width="188"><div align="center">Quantity</div></td>
              <td width="92"><div align="center">Rate N</div></td>
            </tr>
            <tr>
              <td rowspan="6"><table cellspacing="0" cellpadding="0">
                <tr>
                  <td width="182" class="font3">Land Preparation</td>
                </tr>
              </table></td>
              <td height="24"></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td width="112" height="29" class="font2">Land Rent</td>
              <td width="55" class="font2"><div align="center">Lump Sum</div></td>
              <td><label for="lrsum"></label>
                <div align="center">${cbdgtqties.getQuantity1()}
              </div></td>
              <td><label for="rate1"></label>
                <div align="right">
                  <input name="rate1" type="text" id="rate1" size="15" maxlength="15" />
              </div></td>
            </tr>
            <tr>
              <td width="112" height="32" class="font2">Land Preparation</td>
              <td width="55" class="font2" valign="middle"><div align="center">man-days</div></td>
              <td><label for="lrsum"></label>
                <div align="center">${cbdgtqties.getQuantity2()}
                </div></td>
              <td><label for="rate2"></label>
                <div align="right">
                  <input name="rate2" type="text" id="rate2" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td width="112" height="30" class="font2">Ploughing</td>
              <td width="55" class="font2"><div align="center">ha</div></td>
              <td><label for="lrsum"></label>
                <div align="center">${cbdgtqties.getQuantity3()}
                </div></td>
              <td><label for="rate3"></label>
                <div align="right">
                  <input name="rate3" type="text" id="rate3" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td width="112" height="28" class="font2">Ridging</td>
              <td width="55" class="font2"><div align="center">ha</div></td>
              <td><label for="lrsum"></label>
                <div align="center">${cbdgtqties.getQuantity4()}
                </div></td>
              <td><label for="rate4"></label>
                <div align="right">
                  <input name="rate4" type="text" id="rate4" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td width="112" height="29" class="font2">Harrowing</td>
              <td width="55" class="font2"><div align="center">ha</div></td>
              <td><label for="lrsum"></label>
                <div align="center">${cbdgtqties.getQuantity5()}
                </div></td>
              <td><label for="rate5"></label>
                <div align="right">
                  <input name="rate5" type="text" id="rate5" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td rowspan="6"><table cellspacing="0" cellpadding="0">
                <tr>
                  <td width="182" class="font3">Seedling and Planting</td>
                </tr>
              </table></td>
              <td width="112" height="26" class="font2">Seeds</td>
              <td width="55" class="font2"><div align="center">kg/ha</div></td>
              <td><label for="lrsum"></label>
                <div align="center">${cbdgtqties.getQuantity6()}
                </div></td>
              <td><label for="rate6"></label>
                <div align="right">
                  <input name="rate6" type="text" id="rate6" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td width="112" height="32" class="font2">Seed dressing</td>
              <td width="55" class="font2"><div align="center">3kg/ha</div></td>
              <td><label for="lrsum"></label>
                <div align="center">${cbdgtqties.getQuantity7()}
                </div></td>
              <td><label for="rate7"></label>
                <div align="right">
                  <input name="rate7" type="text" id="rate7" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td width="112" height="36" class="font2">Planting</td>
              <td width="55" class="font2"><div align="center">man-days/ha</div></td>
              <td><label for="lrsum"></label>
                <div align="center">${cbdgtqties.getQuantity8()}
                </div></td>
              <td><label for="rate8"></label>
                <div align="right">
                  <input name="rate8" type="text" id="rate8" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td width="112" height="31" class="font2">1st weeding</td>
              <td width="55" class="font2"><div align="center">man-days/ha</div></td>
              <td><label for="lrsum"></label>
                <div align="center">${cbdgtqties.getQuantity9()}
                </div></td>
              <td><label for="rate9"></label>
                <div align="right">
                  <input name="rate9" type="text" id="rate9" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td width="112" height="31" class="font2">2nd hand weeding</td>
              <td width="55" class="font2"><div align="center">man-days/ha</div></td>
              <td><label for="lrsum"></label>
                <div align="center">${cbdgtqties.getQuantity10()}
                </div></td>
              <td><label for="rate10"></label>
                <div align="right">
                  <input name="rate10" type="text" id="rate10" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td width="112" height="29" class="font2">Transportation Cost</td>
              <td width="55" class="font2"><div align="center">Bag</div></td>
              <td><label for="lrsum"></label>
                <div align="center">${cbdgtqties.getQuantity11()}
                </div></td>
              <td><label for="rate11"></label>
                <div align="right">
                  <input name="rate11" type="text" id="rate11" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td rowspan="5"><table cellspacing="0" cellpadding="0">
                <tr>
                  <td width="181" class="font3">Fertilizer Application</td>
                </tr>
              </table></td>
              <td width="112" height="33" class="font2">Basical Application</td>
              <td width="55" class="font2"><div align="center">Bag</div></td>
              <td><label for="lrsum"></label>
                <div align="center">${cbdgtqties.getQuantity12()}
                </div></td>
              <td><label for="rate12"></label>
                <div align="right">
                  <input name="rate12" type="text" id="rate12" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td width="112" height="44" class="font2">Side dressing (4-5 weeks after planting) with NPK</td>
              <td width="55" class="font2"><div align="center">Bag</div></td>
              <td><label for="lrsum"></label>
                <div align="center">${cbdgtqties.getQuantity15()}
                </div></td>
              <td><label for="rate13"></label>
                <div align="right">
                  <input name="rate13" type="text" id="rate13" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td width="112" height="34" class="font2">Application of NPK Fertilizer/day</td>
              <td width="55" class="font2"><div align="center">man-days/ha</div></td>
              <td><label for="lrsum"></label>
                <div align="center">${cbdgtqties.getQuantity14()}
                </div></td>
              <td><label for="rate14"></label>
                <div align="right">
                  <input name="rate14" type="text" id="rate14" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td width="112" height="30" class="font2">Application of urea Fertilizer/day</td>
              <td width="55" class="font2"><div align="center">man-days/ha</div></td>
              <td><label for="lrsum"></label>
                <div align="center">${cbdgtqties.getQuantity15()}
                </div></td>
              <td><label for="rate15"></label>
                <div align="right">
                  <input name="rate15" type="text" id="rate15" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td width="112" height="27" class="font2">Bird Scarng</td>
              <td width="55" class="font2"><div align="center">man-days/ha</div></td>
              <td><div align="center">${cbdgtqties.getQuantity16()}
              </div></td>
              <td><div align="right">
                <input name="rate16" type="text" id="rate16" size="15" maxlength="15" />
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
              <td><div align="right"></div></td>
            </tr>
            <tr>
              <td width="112" height="33" class="font2">Insecticide</td>
              <td width="55" class="font2"><div align="center">litre/ha</div></td>
              <td><label for="lrsum"></label>
                <div align="center">${cbdgtqties.getQuantity17()}
                </div></td>
              <td><label for="rate17"></label>
                <div align="right">
                  <input name="rate17" type="text" id="rate17" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td width="112" height="31" class="font2">Labour (Spraying)</td>
              <td width="55" class="font2"><div align="center">man-days/ha</div></td>
              <td><label for="lrsum"></label>
                <div align="center">${cbdgtqties.getQuantity18()}
                </div></td>
              <td><label for="rate18"></label>
                <div align="right">
                  <input name="rate18" type="text" id="rate18" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td width="112" height="32" class="font2">Transportation</td>
              <td width="55" class="font2"><div align="center">Lump Sum</div></td>
              <td><label for="lrsum"></label>
                <div align="center">${cbdgtqties.getQuantity19()}
                </div></td>
              <td><label for="rate19"></label>
                <div align="right">
                  <input name="rate19" type="text" id="rate19" size="15" maxlength="15" />
                </div></td>
            </tr>
            
          </table>
        
        </tr>
        <tr>
            <td width="664"><div align="center"><em>                
       		<input type="submit" name="addcpbdgtrate" id="font5" value="SUBMIT"  style="background-color:#FC3"/>
      			 </em></div>
            </td>
        </tr>        
      </table>
</form>
<a href="serviceslist.jsp">Services list Page</a>
</body>
</html>


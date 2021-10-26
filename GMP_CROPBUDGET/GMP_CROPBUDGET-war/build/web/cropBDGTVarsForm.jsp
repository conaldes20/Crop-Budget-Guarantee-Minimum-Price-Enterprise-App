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
      <table width="581" border="0" align="center">
         <tr>
        	<td  height="2" bgcolor="#999900" colspan="2"><h3 align="center"><b>PROJECTED RETURNS USING CROP BUDGET</b></h3></td>
        </tr>          
        <tr>
          <td width="668" height="40" bgcolor="#99FF99">
          <table width="592" border="1">
            <tr>
              <td width="87" rowspan="18"><table width="84" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="77" class="font4">STAGE 1</td>
                </tr>
              </table></td>
              <td width="83"><div align="center">Main Operation</div></td>
              <td width="190"><div align="center">Activity</div></td>
              <td width="83"><div align="center">Units</div></td>
              <td width="90"><div align="center">Quantity</div></td>
            </tr>
            <tr>
              <td rowspan="6"><table cellspacing="0" cellpadding="0">
                <tr>
                  <td width="182" class="font3">Land Preparation</td>
                </tr>
              </table></td>
              <td height="9"></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td width="190" height="29" class="font2">Land Rent</td>
              <td width="83" class="font2"><div align="center">Lump Sum</div></td>
              <td><label for="qty1"></label>
                <div align="center">
                  <input name="qty1" type="text" id="qty1" value="${cbdgtqties.getQuantity1()}" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td width="190" height="32" class="font2">Land Preparation</td>
              <td width="83" class="font2" valign="middle"><div align="center">man-days</div></td>
              <td><label for="qty2"></label>
                <div align="center">
                  <input name="qty2" type="text" id="qty2" value="${cbdgtqties.getQuantity2()}" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td width="190" height="30" class="font2">Ploughing</td>
              <td width="83" class="font2"><div align="center">ha</div></td>
              <td><label for="qty3"></label>
                <div align="center">
                  <input name="qty3" type="text" id="qty3" value="${cbdgtqties.getQuantity3()}" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td width="190" height="28" class="font2">Ridging</td>
              <td width="83" class="font2"><div align="center">ha</div></td>
              <td><label for="qty4"></label>
                <div align="center">
                  <input name="qty4" type="text" id="qty4" value="${cbdgtqties.getQuantity4()}" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td width="190" height="29" class="font2">Harrowing</td>
              <td width="83" class="font2"><div align="center">ha</div></td>
              <td><label for="qty5"></label>
                <div align="center">
                  <input name="qty5" type="text" id="qty5" value="${cbdgtqties.getQuantity5()}" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td rowspan="6"><table cellspacing="0" cellpadding="0">
                <tr>
                  <td width="182" class="font3">Seedling and Planting</td>
                </tr>
              </table></td>
              <td width="190" height="26" class="font2">Seeds</td>
              <td width="83" class="font2"><div align="center">kg/ha</div></td>
              <td><label for="qty6"></label>
                <div align="center">
                  <input name="qty6" type="text" id="qty6" value="${cbdgtqties.getQuantity6()}" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td width="190" height="32" class="font2">Seed dressing</td>
              <td width="83" class="font2"><div align="center">3kg/ha</div></td>
              <td><label for="qty7"></label>
                <div align="center">
                  <input name="qty7" type="text" id="qty7" value="${cbdgtqties.getQuantity7()}" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td width="190" height="36" class="font2">Planting</td>
              <td width="83" class="font2"><div align="center">man-days/ha</div></td>
              <td><label for="qty8"></label>
                <div align="center">
                  <input name="qty8" type="text" id="qty8" value="${cbdgtqties.getQuantity8()}" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td width="190" height="31" class="font2">1st weeding</td>
              <td width="83" class="font2"><div align="center">man-days/ha</div></td>
              <td><label for="qty9"></label>
                <div align="center">
                  <input name="qty9" type="text" id="qty9" value="${cbdgtqties.getQuantity9()}" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td width="190" height="31" class="font2">2nd hand weeding</td>
              <td width="83" class="font2"><div align="center">man-days/ha</div></td>
              <td><label for="qty10"></label>
                <div align="center">
                  <input name="qty10" type="text" id="qty10" value="${cbdgtqties.getQuantity10()}" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td width="190" height="29" class="font2">Transportation Cost</td>
              <td width="83" class="font2"><div align="center">Bag</div></td>
              <td><label for="qty11"></label>
                <div align="center">
                  <input name="qty11" type="text" id="qty11" value="${cbdgtqties.getQuantity11()}" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td rowspan="5"><table cellspacing="0" cellpadding="0">
                <tr>
                  <td width="181" class="font3">Fertilizer Application</td>
                </tr>
              </table></td>
              <td width="190" height="33" class="font2">Basic Application</td>
              <td width="83" class="font2"><div align="center">Bag</div></td>
              <td><label for="qty12"></label>
                <div align="center">
                  <input name="qty12" type="text" id="qty12" value="${cbdgtqties.getQuantity12()}" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td width="190" height="44" class="font2">Side dressing (4-5 weeks after planting) with NPK</td>
              <td width="83" class="font2"><div align="center">Bag</div></td>
              <td><label for="qty13"></label>
                <div align="center">
                  <input name="qty13" type="text" id="qty13" value="${cbdgtqties.getQuantity13()}" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td width="190" height="34" class="font2">Application of NPK Fertilizer/day</td>
              <td width="83" class="font2"><div align="center">man-days/ha</div></td>
              <td><label for="qty14"></label>
                <div align="center">
                  <input name="qty14" type="text" id="qty14" value="${cbdgtqties.getQuantity14()}" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td width="190" height="30" class="font2">Application of urea Fertilizer/day</td>
              <td width="83" class="font2"><div align="center">man-days/ha</div></td>
              <td><label for="qty15"></label>
                <div align="center">
                  <input name="qty15" type="text" id="qty15" value="${cbdgtqties.getQuantity15()}" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td width="190" height="27" class="font2">Bird Scarng</td>
              <td width="83" class="font2"><div align="center">man-days/ha</div></td>
              <td><div align="center">
                <input name="qty16" type="text" id="qty16" value="${cbdgtqties.getQuantity16()}" size="15" maxlength="15" />
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
            </tr>
            <tr>
              <td width="190" height="33" class="font2">Insecticide</td>
              <td width="83" class="font2"><div align="center">litre/ha</div></td>
              <td><label for="qty17"></label>
                <div align="center">
                  <input name="qty17" type="text" id="qty17" value="${cbdgtqties.getQuantity17()}" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td width="190" height="31" class="font2">Labour (Spraying)</td>
              <td width="83" class="font2"><div align="center">man-days/ha</div></td>
              <td><label for="qty18"></label>
                <div align="center">
                  <input name="qty18" type="text" id="qty18" value="${cbdgtqties.getQuantity18()}" size="15" maxlength="15" />
                </div></td>
            </tr>
            <tr>
              <td width="190" height="32" class="font2">Transportation</td>
              <td width="83" class="font2"><div align="center">Lump Sum</div></td>
              <td><label for="qty19"></label>
                <div align="center">
                  <input name="qty19" type="text" id="qty19" value="${cbdgtqties.getQuantity19()}" size="15" maxlength="15" />
                </div></td>
            </tr>
            
          </table>
        
        </tr>
        <tr>
            <td width="668"><div align="center"><em>      			
       		<input type="submit" name="addcpbdgtqty" id="font5" value="SUBMIT"  style="background-color:#FC3"/>
      			 </em></div>
            </td>
  		</tr>        
      </table>
</form>
<a href="serviceslist.jsp">Services list Page</a>
</body>
</html>


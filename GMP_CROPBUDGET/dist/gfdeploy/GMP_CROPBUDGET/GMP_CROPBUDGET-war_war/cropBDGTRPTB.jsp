<%-- 
    Document   : cropBDGTRPT
    Created on : Jul 30, 2016, 12:11:14 AM
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
.fontam {
	font-family: Comic Sans MS, cursive;
}
.coloam {
	color: #400000;
}
.cololoc {
	color: #800000;
}
.cololocf {
	font-family: Comic Sans MS, cursive;
}
.fontcrp {
	font-family: Comic Sans MS, cursive;
}
.colorp2 {
	color: #800000;
}
.font2 strong {
	font-family: Verdana, Geneva, sans-serif;
}
.font2 strong {
	font-family: Georgia, Times New Roman, Times, serif;
}
.coloxx {
	color: #000;
}
.cololocf {
	color: #400000;
}
.cololocf {
	color: #800000;
}
-->
</style>
<script src="SpryAssets/SpryValidationSelect.js" type="text/javascript"></script>
<link href="SpryAssets/SpryValidationSelect.css" rel="stylesheet" type="text/css" />
</head>
<body> 	
    <div align="center">      
  <c:if test="${response != ''}" >	
      <p><font color=blue>Message from server: ${response}</font>
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
      <table width="936" border="0" align="center">
         <tr>
        	<td  height="2" bgcolor="#999900" colspan="2"><h3 align="center"><b>PROJECTED RETURNS USING CROP BUDGET</b></h3></td>
        </tr>          
        <tr>
          <td width="930" height="40" bgcolor="#99FF99">
          <table width="928" border="1">
            <tr>
              <td width="87" rowspan="19"><table width="84" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="77" class="font4">STAGE 1</td>
                </tr>
              </table></td>
              <td height="35" colspan="7">
                <p>
                <label for="crop"></label>
                <label><span class="fontAA">CROP:</span></label>
                <span class="colorp2"><em>
                ${cbdgtparams.getCrop()}</em></span> 
                <label> <span class="fontAA">LOCATION:</span></label>
                <span class="cololoc"><em>
                ${cbdgtparams.getLocation()}</em></span>
                <label><span class="coloxx">YEAR:</span></label>
                <span class="cololoc"><em>
                ${cbdgtparams.getYeear()}</em></span>
                </p>
                <p>
                  <label><span class="fontAA">FARMING TYPE:</span></label>
                  <span class="cololoc"><em>
              ${cbdgtparams.getPltype()}</em></span>                </td>
            </tr>
            <tr class="font1">
              <td width="184"><div align="center">Main Operation</div></td>
              <td width="117"><div align="center">Activity</div></td>
              <td width="162"><div align="center">Units</div></td>
              <td width="71"><div align="center">Quantity</div></td>
              <td width="62"><div align="center">Rate N</div></td>
              <td width="82"><div align="center">Amount per Ha</div></td>
              <td width="116"><div align="center">Remarks</div></td>
            </tr>
            <tr>
              <td rowspan="6"><table cellspacing="0" cellpadding="0">
                <tr>
                  <td width="182" class="font3">Land Preparation</td>
                </tr>
              </table></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td width="117" class="font2">Land Rent</td>
              <td width="162" class="font2"><div align="center">Lump Sum</div></td>
              <td><label for="lrsum"></label>
                
              <div align="center">${cbdgtqties.getQuantity1()} </div></td>
              <td class="coloam"><div align="right"><em>${cbdgtparams.getVarrate1()}</em></div></td>
              <td class="coloam"><div align="right"><em>${cbdgtamunts.getAmount1()}</em></div></td>
              <td></td>
            </tr>
            <tr>
              <td width="117" class="font2">Land Preparation</td>
              <td width="162" class="font2"> 
              <div align="center">man-days</div></td>
              <td><label for="lrsum"></label>
                
                <div align="center">${cbdgtqties.getQuantity2()} </div></td>
              <td class="coloam"><div align="right"><em>${cbdgtparams.getVarrate2()}</em></div></td>
              <td class="coloam"><div align="right"><em>${cbdgtamunts.getAmount2()}</em></div></td>
              <td></td>
            </tr>
            <tr>
              <td width="117" class="font2">Ploughing</td>
              <td width="162" class="font2"><div align="center">ha</div></td>
              <td><label for="lrsum"></label>
                
                <div align="center">${cbdgtqties.getQuantity3()}</div></td>
              <td class="coloam"><div align="right"><em>${cbdgtparams.getVarrate3()}</em></div></td>
              <td class="coloam"><div align="right"><em>${cbdgtamunts.getAmount3()}</em></div></td>
              <td></td>
            </tr>
            <tr>
              <td width="117" class="font2">Ridging</td>
              <td width="162" class="font2"><div align="center">ha</div></td>
              <td><label for="lrsum"></label>
                
                <div align="center">${cbdgtqties.getQuantity4()}</div></td>
              <td class="coloam"><div align="right"><em>${cbdgtparams.getVarrate4()}</em></div></td>
              <td class="coloam"><div align="right"><em>${cbdgtamunts.getAmount4()}</em></div></td>
              <td></td>
            </tr>
            <tr>
              <td width="117" class="font2">Harrowing</td>
              <td width="162" class="font2"><div align="center">ha</div></td>
              <td><label for="lrsum"></label>
                
                <div align="center">${cbdgtqties.getQuantity5()} </div></td>
              <td class="coloam"><div align="right"><em>${cbdgtparams.getVarrate5()}</em></div></td>
              <td class="coloam"><div align="right"><em>${cbdgtamunts.getAmount5()}</em></div></td>
              <td></td>
            </tr>
            <tr>
              <td rowspan="6"><table cellspacing="0" cellpadding="0">
                <tr>
                  <td width="182" class="font3">Seedling and Planting</td>
                </tr>
              </table></td>
              <td width="117" class="font2">Seeds</td>
              <td width="162" class="font2"><div align="center">kg/ha</div></td>
              <td><label for="lrsum"></label>
                
                <div align="center">${cbdgtqties.getQuantity6()} </div></td>
              <td class="coloam"><div align="right"><em>${cbdgtparams.getVarrate6()}</em></div></td>
              <td class="coloam"><div align="right"><em>${cbdgtamunts.getAmount6()}</em></div></td>
              <td></td>
            </tr>
            <tr>
              <td width="117" class="font2">Seed dressing</td>
              <td width="162" class="font2"><div align="center">3kg/ha</div></td>
              <td><label for="lrsum"></label>
                
                <div align="center">${cbdgtqties.getQuantity7()} </div></td>
              <td class="coloam"><div align="right"><em>${cbdgtparams.getVarrate7()}</em></div></td>
              <td class="coloam"><div align="right"><em>${cbdgtamunts.getAmount7()}</em></div></td>
              <td></td>
            </tr>
            <tr>
              <td width="117" class="font2">Planting</td>
              <td width="162" class="font2"><div align="center">man-days/ha</div></td>
              <td><label for="lrsum"></label>
                
                <div align="center">${cbdgtqties.getQuantity8()} </div></td>
              <td class="coloam"><div align="right"><em>${cbdgtparams.getVarrate8()}</em></div></td>
              <td class="coloam"><div align="right"><em>${cbdgtamunts.getAmount8()}</em></div></td>
              <td></td>
            </tr>
            <tr>
              <td width="117" class="font2">1st weeding</td>
              <td width="162" class="font2"><div align="center">man-days/ha</div></td>
              <td><label for="lrsum"></label>
                
                <div align="center">${cbdgtqties.getQuantity9()} </div></td>
              <td class="coloam"><div align="right"><em>${cbdgtparams.getVarrate9()}</em></div></td>
              <td class="coloam"><div align="right"><em>${cbdgtamunts.getAmount9()}</em></div></td>
              <td></td>
            </tr>
            <tr>
              <td width="117" class="font2">2nd hand weeding</td>
              <td width="162" class="font2"><div align="center">man-days/ha</div></td>
              <td><label for="lrsum"></label>
                
                <div align="center">${cbdgtqties.getQuantity10()} </div></td>
              <td class="coloam"><div align="right"><em>${cbdgtparams.getVarrate10()}</em></div></td>
              <td class="coloam"><div align="right"><em>${cbdgtamunts.getAmount10()}</em></div></td>
              <td></td>
            </tr>
            <tr>
              <td width="117" class="font2">Transportation Cost</td>
              <td width="162" class="font2"><div align="center">Bag</div></td>
              <td><label for="lrsum"></label>
                
                <div align="center">${cbdgtqties.getQuantity11()} </div></td>
              <td class="coloam"><div align="right"><em>${cbdgtparams.getVarrate11()}</em></div></td>
              <td class="coloam"><div align="right"><em>${cbdgtamunts.getAmount11()}</em></div></td>
              <td></td>
            </tr>
            <tr>
              <td rowspan="5"><table cellspacing="0" cellpadding="0">
                <tr>
                  <td width="181" class="font3">Fertilizer Application</td>
                </tr>
              </table></td>
              <td width="117" class="font2">Basic Application</td>
              <td width="162" class="font2"><div align="center">Bag</div></td>
              <td><label for="lrsum"></label>
                
                <div align="center">${cbdgtqties.getQuantity12()} </div></td>
              <td class="coloam"><div align="right"><em>${cbdgtparams.getVarrate12()}</em></div></td>
              <td class="coloam"><div align="right"><em>${cbdgtamunts.getAmount12()}</em></div></td>
              <td></td>
            </tr>
            <tr>
              <td width="117" class="font2">Side dressing (4-5 weeks after planting) with NPK</td>
              <td width="162" class="font2"><div align="center">Bag</div></td>
              <td><label for="lrsum"></label>
                
                <div align="center">${cbdgtqties.getQuantity13()} </div></td>
              <td class="coloam"><div align="right"><em>${cbdgtparams.getVarrate13()}</em></div></td>
              <td class="coloam"><div align="right"><em>${cbdgtamunts.getAmount13()}</em></div></td>
              <td></td>
            </tr>
            <tr>
              <td width="117" class="font2">Application of NPK Fertilizer/day</td>
              <td width="162" class="font2"><div align="center">man-days/ha</div></td>
              <td><label for="lrsum"></label>
                
                <div align="center">${cbdgtqties.getQuantity14()} </div></td>
              <td class="coloam"><div align="right"><em>${cbdgtparams.getVarrate14()}</em></div></td>
              <td class="coloam"><div align="right"><em>${cbdgtamunts.getAmount14()}</em></div></td>
              <td></td>
            </tr>
            <tr>
              <td width="117" class="font2">Application of urea Fertilizer/day</td>
              <td width="162" class="font2"><div align="center">man-days/ha</div></td>
              <td><label for="lrsum"></label>
                
                <div align="center">${cbdgtqties.getQuantity15()} </div></td>
              <td class="coloam"><div align="right"><em>${cbdgtparams.getVarrate15()}</em></div></td>
              <td class="coloam"><div align="right"><em>${cbdgtamunts.getAmount15()}</em></div></td>
              <td></td>
            </tr>
            <tr>
              <td width="117" class="font2">Bird Scaring</td>
              <td width="162" class="font2"><div align="center">man-days/ha</div></td>
              <td><div align="center">${cbdgtqties.getQuantity16()}</div></td>
              <td class="coloam"><div align="right"><em>${cbdgtparams.getVarrate16()}</em></div></td>
              <td class="coloam"><div align="right"><em>${cbdgtamunts.getAmount16()}</em></div></td>
              <td></td>
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
              <td class="font2"></td>
              <td class="font2"><div align="center"></div></td>
              <td><div align="center"></div></td>
              <td class="coloam"><div align="right"><em></em></div></td>
              <td class="coloam"><div align="right"><em></em></div></td>
              <td></td>
            </tr>
            <tr>
              <td width="117" class="font2">Insecticide</td>
              <td width="162" class="font2"><div align="center">litre/ha</div></td>
              <td><label for="lrsum"></label>
                
                <div align="center">${cbdgtqties.getQuantity17()} </div></td>
              <td class="coloam"><div align="right"><em>${cbdgtparams.getVarrate17()}</em></div></td>
              <td class="coloam"><div align="right"><em>${cbdgtamunts.getAmount17()}</em></div></td>
              <td></td>
            </tr>
            <tr>
              <td width="117" class="font2">Labour (Spraying)</td>
              <td width="162" class="font2"><div align="center">man-days/ha</div></td>
              <td><label for="lrsum"></label>
                
                <div align="center">${cbdgtqties.getQuantity18()} </div></td>
              <td class="coloam"><div align="right"><em>${cbdgtparams.getVarrate18()}</em></div></td>
              <td class="coloam"><div align="right"><em>${cbdgtamunts.getAmount18()}</em></div></td>
              <td></td>
            </tr>
            <tr>
              <td width="117" class="font2">Transportation</td>
              <td width="162" class="font2"><div align="center">Lump Sum</div></td>
              <td><label for="lrsum"></label>
                
                <div align="center">${cbdgtqties.getQuantity19()} </div></td>
              <td class="coloam"><div align="right"><em>${cbdgtparams.getVarrate19()}</em></div></td>
              <td class="coloam"><div align="right"><em>${cbdgtamunts.getAmount19()}</em></div></td>
              <td></td>
            </tr>
            <tr>
              <td class="font2">Total Cost</td>
              <td class="font2"><div align="center"></div></td>
              <td><div align="center"></div></td>
              <td class="coloam"><div align="right"></div></td>
              <td class="coloam"><div align="right"><em>${cbdgtamunts.getAmount20()}</em></div></td>
              <td></td>
            </tr>
            <tr>
              <td rowspan="11"><table cellspacing="0" cellpadding="0">
                <tr>
                  <td width="87" class="font4">STAGE 3</td>
                </tr>
              </table></td>
              <td rowspan="9"><table cellspacing="0" cellpadding="0">
                <tr>
                  <td width="181" height="19" class="font3">Total Variable Cost</td>
                </tr>
              </table></td>
              <td class="font2"></td>
              <td class="font2"><div align="center"></div></td>
              <td><div align="center"></div></td>
              <td class="coloam"><div align="right"></div></td>
              <td class="coloam"><div align="right"></div></td>
              <td></td>
            </tr>
            <tr>
              <td width="117" height="80" class="font2">Harvesting and other miscellaneous expenses at 10% of the total cost</td>
              <td width="162" align="right" class="font2"><div align="center">10.00%</div></td>
              <td><div align="center"></div></td>
              <td class="coloam"><div align="right"></div></td>
              <td class="coloam"><div align="right"><em>${cbdgtamunts.getAmount21()}</em></div></td>
              <td width="116">Assumption: The harvesting and miscellaneous expenses of the total cost.</td>
            </tr>
            <tr>
              <td height="23" class="font2">Total variable cost- TVC(a)</td>
              <td class="font2"><div align="center"></div></td>
              <td><div align="center"></div></td>
              <td class="coloam"><div align="right"></div></td>
              <td class="coloam"><div align="right"><em>${cbdgtamunts.getAmount22()}</em></div></td>
              <td width="116"></td>
            </tr>
            <tr>
              <td width="117" height="23" class="font2">Production cost per ton (b)</td>
              <td class="font2"><div align="center">a/c</div></td>
              <td><div align="center"></div></td>
              <td class="coloam"><div align="right"></div></td>
              <td class="coloam"><div align="right"><em>${cbdgtamunts.getAmount23()}</em></div></td>
              <td width="116"></td>
            </tr>
            <tr>
              <td height="23" class="font2">Yield ( tons/ha) ( c )</td>
              <td class="font2"><div align="center">70,000</div></td>
              <td><div align="center"></div></td>
              <td class="coloam"><div align="right"></div></td>
              <td class="coloam"><div align="right"></div></td>
              <td width="116"></td>
            </tr>
            <tr>
              <td width="117" height="23" class="font2">Market Price/ton (d)</td>
              <td class="font2"><div align="center"></div></td>
              <td><div align="center"></div></td>
              <td class="coloam"><div align="right"></div></td>
              <td class="coloam"><div align="right"></div></td>
              <td></td>
            </tr>
            <tr>
              <td height="24" class="font2">Expected Revenue ( e) </td>
              <td class="font2"><div align="center">
                <table cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="127">c*d</td>
                  </tr>
                </table>
              </div></td>
              <td><div align="center"></div></td>
              <td class="coloam"><div align="right"></div></td>
              <td class="coloam"><div align="right"><em>${cbdgtamunts.getAmount24()}</em></div></td>
              <td></td>
            </tr>
            <tr>
              <td width="117" class="font2">Return on Investment (f)</td>
              <td class="font2"><div align="center">(e-a)/a</div></td>
              <td><div align="center"></div></td>
              <td class="coloam"><div align="right"></div></td>
              <td class="coloam"><div align="right"><em>${cbdgtamunts.getAmount25()}</em></div></td>
              <td></td>
            </tr>
            <tr>
              <td width="117" class="font2">Return on Investment (N)(g)</td>
              <td class="font2"><div align="center">d*f</div></td>
              <td><div align="center"></div></td>
              <td class="coloam"><div align="right"></div></td>
              <td class="coloam"><div align="right"><em>${cbdgtamunts.getAmount26()}</em></div></td>
              <td></td>
            </tr>
            <tr>
              <td></td>
              <td class="font2">Marginal Returns/ton (h)</td>
              <td class="font2"><div align="center">g/c</div></td>
              <td><div align="center"></div></td>
              <td class="coloam"><div align="right"></div></td>
              <td class="coloam"><div align="right"><em>${cbdgtamunts.getAmount27()}</em></div></td>
              <td></td>
            </tr>
            <tr>
              <td></td>
              <td class="font2">Minimum Selling Price/ton N)</td>
              <td class="font2"><div align="center">b+h</div></td>
              <td><div align="center"></div></td>
              <td class="coloam"><div align="right"></div></td>
              <td class="coloam"><div align="right"><em>${cbdgtamunts.getAmount28()}</em></div></td>
              <td></td>
            </tr>
            <tr>
              <td><table cellspacing="0" cellpadding="0">
                <tr>
                  <td width="113" class="font3">Recommended /Proposed GMP</td>
                </tr>
              </table></td>
              <td class="font2">(e)=(d)</td>
              <td class="font2"></td>
              <td><div align="center"></div></td>
              <td class="coloam"><div align="center"></div></td>
              <td class="coloam"><div align="right"><em>
                ${cbdgtamunts.getAmount29()}
              </em></div></td>
              <td><div align="right"></div></td>
            </tr>
          </table>        
        </tr>        
      </table>
      <table width="1015" border="1">  
</table>
<a href="reportList.jsp">Report list page</a>
</body>
</html>

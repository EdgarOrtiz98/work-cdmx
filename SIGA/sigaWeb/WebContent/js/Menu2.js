window.defaultStatus="SIGA - Sistema Integral de Gestión Administrativa";
window.seleccionado=null;
window.seleccionadomenu=null;
enciende=function(e,b,c){
	if(!b) var b='#00204F';
	if(!c) var c='#FFFFFF';
	if (seleccionado!=e)
	{
		e.style.backgroundColor=b;
		e.style.color=c;
	}
}
apaga=function(e,b,c)
{
	if(!b) var b='transparent';
	if(!c) var c='#00204F';
	if (seleccionado!=e)
	{
		e.style.backgroundColor=b;
		e.style.color=c;
	}
}
ira=function(e,newwin,o)
{
	if(!o) var o=window;
	if(!newwin) o.frames['contenido'].document.location.href = e;
	else window.open(e,newwin)
}
getVar=function(nombre){
    var url = document.location.href;
    if ( url.indexOf(nombre) != -1 )
	{
        posiIni = url.indexOf("=", url.indexOf(nombre))
        barre = url.indexOf("&", posiIni)
        posiFin = (barre != -1 ? barre : url.length)
        return url.substring(posiIni+1,posiFin)
    } else
	{
    	return ''
    }
}
/////////Inicio Calendario
var Nav4 = ((navigator.appName == "Netscape") && (parseInt(navigator.appVersion) == 4));
IELinkClicks = new Array();
vWinCal="";
function isAlpha(check){
var space = " :;.,'?/<>??!?^~@#$%&*()=-_|[]{}"+'"'+"\\\n\t";
for(var i=0;i<space.length;i++)
    {
    if(check==space.charAt(i)) 
      {return false;}
    }
if(check=="")  {return false;}
if(check==null) {return false;}
return true;
}
function isValid(aux){
var valor="";
var i=0;
while (i<aux.length)
  {
   if(isAlpha(aux.charAt(i)) || valor!="")
     valor+=aux.charAt(i);
   i+=1;
  }
return valor;
}
//////Calendario
function valida(a,b,fi){
	
	if ((b.value=='') || (b.value==' ')){
		show_calendar(a);
	}else{
		
		if ((a.substring(13,14)=='F') || (a.substring(13,14)=='I')){
			if (fi.value!=''){
				var hano1=fi.value;
				var hmes1=fi.value;
				var hdia1=fi.value;
				var jano1=b.value;
				var jmes1=b.value;
				var jdia1=b.value;
				var hano=hano1.substring(6,10);
				var hmes=hmes1.substring(0,2);
				var hdia=hdia1.substring(3,5);
				var jano=jano1.substring(6,10);
				var jmes=jmes1.substring(0,2);
				var jdia=jdia1.substring(3,5);
				var dini = new Date(hano,hmes,hdia);
				
				var dfin = new Date(jano,jmes,jdia);
				if (a.substring(13,14)=='F'){
					if (dini>dfin){
						b.value="";
						alert("La fecha de Inicio es mayor a la fecha Final.");
						show_calendar(a);
					}
				}else{
					if (dini<dfin){
						b.value="";
						alert("La fecha de Inicio es mayor a la fecha Final.");
						show_calendar(a);
					}
				}
			}
		}		
	}
}
function trim(str)
{
	for(var i = 0 ; i<str.length && str.charAt(i)==" " ; i++ ) ;
	var sig= str.substring(i,str.length); 
	for(var i = 0 ; i<sig.length && sig.charAt(i)=="." ; i++ ) ;
	var fin= sig.substring(i,sig.length); 
	
	return fin;
}
var currHref = (document.location.href + "&").toLowerCase();
var dbName = currHref.substring(0, currHref.indexOf(".nsf")+4);
var weekend = [0,6];
var weekendColor = "#CCCCCC";
var fontface = "Verdana";
var fontsize = 2;
var gNow = new Date();
var ggWinCal;
isNav = false; //(navigator.appName.indexOf("Netscape") != -1) ? true : false;
isIE = true; //(navigator.appName.indexOf("Microsoft") != -1) ? true : false;
Calendar.Months = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
"Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"];
// Non-Leap year Month days..
Calendar.DOMonth = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
// Leap year Month days..
Calendar.lDOMonth = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
function Calendar(p_item, p_WinCal, p_month, p_year, p_format) {
	if ((p_month == null) && (p_year == null))	return;
	if (p_WinCal == null)
		this.gWinCal = ggWinCal;
	else
		this.gWinCal = p_WinCal;
	
	if (p_month == null) {
		this.gMonthName = null;
		this.gMonth = null;
		this.gYearly = true;
	} else {
		this.gMonthName = Calendar.get_month(p_month);
		this.gMonth = new Number(p_month);
		this.gYearly = false;
	}
	this.gYear = p_year;
	this.gFormat = p_format;
	this.gBGColor = "white";
	this.gFGColor = "white";
	this.gTextColor = "#006699";
	this.gHeaderColor = "white";
	this.gReturnItem = p_item;
}
Calendar.get_month = Calendar_get_month;
Calendar.get_daysofmonth = Calendar_get_daysofmonth;
Calendar.calc_month_year = Calendar_calc_month_year;
Calendar.print = Calendar_print;
function Calendar_get_month(monthNo) {
	return Calendar.Months[monthNo];
}
function Calendar_get_daysofmonth(monthNo, p_year) {
	/* 
	Check for leap year ..
	1.Years evenly divisible by four are normally leap years, except for... 
	2.Years also evenly divisible by 100 are not leap years, except for... 
	3.Years also evenly divisible by 400 are leap years. 
	*/
	if ((p_year % 4) == 0) {
		if ((p_year % 100) == 0 && (p_year % 400) != 0)
			return Calendar.DOMonth[monthNo];
	
		return Calendar.lDOMonth[monthNo];
	} else
		return Calendar.DOMonth[monthNo];
}
function Calendar_calc_month_year(p_Month, p_Year, incr) {
	/* 
	Will return an 1-D array with 1st element being the calculated month 
	and second being the calculated year 
	after applying the month increment/decrement as specified by 'incr' parameter.
	'incr' will normally have 1/-1 to navigate thru the months.
	*/
	var ret_arr = new Array();
	
	if (incr == -1) {
		// B A C K W A R D
		if (p_Month == 0) {
			ret_arr[0] = 11;
			ret_arr[1] = parseInt(p_Year) - 1;
		}
		else {
			ret_arr[0] = parseInt(p_Month) - 1;
			ret_arr[1] = parseInt(p_Year);
		}
	} else if (incr == 1) {
		// F O R W A R D
		if (p_Month == 11) {
			ret_arr[0] = 0;
			ret_arr[1] = parseInt(p_Year) + 1;
		}
		else {
			ret_arr[0] = parseInt(p_Month) + 1;
			ret_arr[1] = parseInt(p_Year);
		}
	}
	
	return ret_arr;
}
function Calendar_print() {
	ggWinCal.print();
}
function Calendar_calc_month_year(p_Month, p_Year, incr) {
	/* 
	Will return an 1-D array with 1st element being the calculated month 
	and second being the calculated year 
	after applying the month increment/decrement as specified by 'incr' parameter.
	'incr' will normally have 1/-1 to navigate thru the months.
	*/
	var ret_arr = new Array();
	
	if (incr == -1) {
		// B A C K W A R D
		if (p_Month == 0) {
			ret_arr[0] = 11;
			ret_arr[1] = parseInt(p_Year) - 1;
		}
		else {
			ret_arr[0] = parseInt(p_Month) - 1;
			ret_arr[1] = parseInt(p_Year);
		}
	} else if (incr == 1) {
		// F O R W A R D
		if (p_Month == 11) {
			ret_arr[0] = 0;
			ret_arr[1] = parseInt(p_Year) + 1;
		}
		else {
			ret_arr[0] = parseInt(p_Month) + 1;
			ret_arr[1] = parseInt(p_Year);
		}
	}
	
	return ret_arr;
}
// This is for compatibility with Navigator 3, we have to create and discard one object before the prototype object exists.
new Calendar();
Calendar.prototype.getMonthlyCalendarCode = function() {
	var vCode = "";
	var vHeader_Code = "";
	var vData_Code = "";
	
	// Begin Table Drawing code here..
	vCode = vCode + "<TABLE BORDER=0 width=10% align=center>";
	
	vHeader_Code = this.cal_header();
	vData_Code = this.cal_data();
	vCode = vCode + vHeader_Code + vData_Code;
	
	vCode = vCode + "</TABLE>";
	
	return vCode;
}
Calendar.prototype.show = function() {
	var vCode = "";
	
	this.gWinCal.document.open();
	// Setup the page...
	this.wwrite("<html>");
	this.wwrite("<head><title>Calendar</title>");
	this.wwrite("</head>");
	this.wwrite("<body onBlur='window.focus()' onunload='window.opener.expedientef.submit();' LEFTMARGIN='0' TOPMARGIN='0' MARGINWIDTH='0' MARGINHEIGHT='0' BACKGROUND='../Imagenes/fondo_claro.jpg'" + 
		"link=\"" + this.gLinkColor + "\" " + 
		"vlink=\"" + this.gLinkColor + "\" " +
		"alink=\"" + this.gLinkColor + "\" " +
		//"text=#006699 onLoad='if (opener) opener.blockEvents()'; onunload='if (opener) opener.unblockEvents()'>");
		"text=#006699");
	this.wwriteA("<br><center><FONT FACE='" + fontface + "' SIZE=3 color=#006699><B>");
	this.wwriteA(this.gMonthName + " " + this.gYear);
	this.wwriteA("</B></center>");
	// Show navigation buttons
	var prevMMYYYY = Calendar.calc_month_year(this.gMonth, this.gYear, -1);
	var prevMM = prevMMYYYY[0];
	var prevYYYY = prevMMYYYY[1];
	var nextMMYYYY = Calendar.calc_month_year(this.gMonth, this.gYear, 1);
	var nextMM = nextMMYYYY[0];
	var nextYYYY = nextMMYYYY[1];
	
	this.wwrite("<TABLE WIDTH='100%'  BORDER=0 CELLSPACING=0 CELLPADDING=0'><TR><TD ALIGN=center VALIGN=bottom>");
	this.wwrite("<A HREF=\"" +
		"javascript:window.opener.Build(" + 
		"'" + this.gReturnItem + "', '" + this.gMonth + "', '" + (parseInt(this.gYear)-1) + "', '" + this.gFormat + "'" +
		");" +
		"\"><img src='../Imagenes/b_anioanterior.gif' border=0><\/A></TD><TD ALIGN=center VALIGN=bottom>");
	this.wwrite("<A HREF=\"" +
		"javascript:window.opener.Build(" + 
		"'" + this.gReturnItem + "', '" + prevMM + "', '" + prevYYYY + "', '" + this.gFormat + "'" +
		");" +
		"\"><img src='../Imagenes/b_mesanterior.gif' border=0><\/A></TD><TD ALIGN=center VALIGN=bottom>");
	this.wwrite("<A HREF=\"" +
		"javascript:window.opener.Build(" + 
		"'" + this.gReturnItem + "', '" + nextMM + "', '" + nextYYYY + "', '" + this.gFormat + "'" +
		");" +
		"\"><img src='../Imagenes/b_messiguiente.gif' border=0><\/A></TD><TD ALIGN=center VALIGN=bottom>");
	this.wwrite("<A HREF=\"" +
		"javascript:window.opener.Build(" + 
		"'" + this.gReturnItem + "', '" + this.gMonth + "', '" + (parseInt(this.gYear)+1) + "', '" + this.gFormat + "'" +
		");" +
		"\"><img src='../Imagenes/b_aniosiguiente.gif' border=0><\/A></TD></TR></TABLE>");
	// Get the complete calendar code for the month..
	vCode = this.getMonthlyCalendarCode();
	this.wwrite(vCode);
	this.wwrite("</font></body></html>");
	this.gWinCal.document.close();
}
Calendar.prototype.showY = function() {
	var vCode = "";
	var i;
	var vr, vc, vx, vy;		// Row, Column, X-coord, Y-coord
	var vxf = 285;			// X-Factor
	var vyf = 200;			// Y-Factor
	var vxm = 10;			// X-margin
	var vym;				// Y-margin
	if (isIE)	vym = 75;
	else if (isNav)	vym = 25;
	
	this.gWinCal.document.open();
	this.wwrite("<html>");
	this.wwrite("<head><title>Calendar</title>");
	this.wwrite("<style type='text/css'>\n<!--");
	for (i=0; i<12; i++) {
		vc = i % 3;
		if (i>=0 && i<= 2)	vr = 0;
		if (i>=3 && i<= 5)	vr = 1;
		if (i>=6 && i<= 8)	vr = 2;
		if (i>=9 && i<= 11)	vr = 3;
		
		vx = parseInt(vxf * vc) + vxm;
		vy = parseInt(vyf * vr) + vym;
		this.wwrite(".lclass" + i + " {position:absolute;top:" + vy + ";left:" + vx + ";}");
	}
	this.wwrite("-->\n</style>");
	this.wwrite("</head>");
	this.wwrite("<body " + 
		"link=\"" + this.gLinkColor + "\" " + 
		"vlink=\"" + this.gLinkColor + "\" " +
		"alink=\"" + this.gLinkColor + "\" " +
		"text=\"" + this.gTextColor + "\">");
	this.wwrite("<FONT FACE='" + fontface + "' SIZE=2><B>");
	this.wwrite("Year : " + this.gYear);
	this.wwrite("</B><BR>");
	// Show navigation buttons
	var prevYYYY = parseInt(this.gYear) - 1;
	var nextYYYY = parseInt(this.gYear) + 1;
	
	this.wwrite("<TABLE WIDTH='100%' BORDER=1 align=center  CELLSPACING=0 CELLPADDING=0'><TR><TD ALIGN=center>");
	this.wwrite("<A HREF=\"" +
		"javascript:window.opener.Build(" + 
		"'" + this.gReturnItem + "', null, '" + prevYYYY + "', '" + this.gFormat + "'" +
		");" +
		"\" alt='Prev Year'>ioo<\/A></TD><TD ALIGN=center>");
	this.wwrite("<A HREF=\"javascript:window.print();\">Print</A></TD><TD ALIGN=center>");
	this.wwrite("<A HREF=\"" +
		"javascript:window.opener.Build(" + 
		"'" + this.gReturnItem + "', null, '" + nextYYYY + "', '" + this.gFormat + "'" +
		");" +
		"\">ioo<\/A></TD></TR></TABLE><BR>");
	// Get the complete calendar code for each month..
	var j;
	for (i=11; i>=0; i--) {
		if (isIE)
			this.wwrite("<DIV ID=\"layer" + i + "\" CLASS=\"lclass" + i + "\">");
		else if (isNav)
			this.wwrite("<LAYER ID=\"layer" + i + "\" CLASS=\"lclass" + i + "\">");
		this.gMonth = i;
		this.gMonthName = Calendar.get_month(this.gMonth);
		vCode = this.getMonthlyCalendarCode();
		this.wwrite(this.gMonthName + "/" + this.gYear + "<BR>");
		this.wwrite(vCode);
		if (isIE)
			this.wwrite("</DIV>");
		else if (isNav)
			this.wwrite("</LAYER>");
	}
	this.wwrite("</font><BR></body></html>");
	this.gWinCal.document.close();
}
Calendar.prototype.wwrite = function(wtext) {
	this.gWinCal.document.writeln(wtext);
}
Calendar.prototype.wwriteA = function(wtext) {
	this.gWinCal.document.write(wtext);
}
Calendar.prototype.cal_header = function() {
	var vCode = "";
	
	vCode = vCode + "<TR>";
	vCode = vCode + "<TD WIDTH='14%'><FONT SIZE='2' FACE='" + fontface + "' COLOR='#006699'><B>Dom</B></FONT></TD>";
	vCode = vCode + "<TD WIDTH='14%'><FONT SIZE='2' FACE='" + fontface + "' COLOR='#006699'><B>Lun</B></FONT></TD>";
	vCode = vCode + "<TD WIDTH='14%'><FONT SIZE='2' FACE='" + fontface + "' COLOR='#006699'><B>Mar</B></FONT></TD>";
	vCode = vCode + "<TD WIDTH='14%'><FONT SIZE='2' FACE='" + fontface + "' COLOR='#006699'><B>Mie</B></FONT></TD>";
	vCode = vCode + "<TD WIDTH='14%'><FONT SIZE='2' FACE='" + fontface + "' COLOR='#006699'><B>Jue</B></FONT></TD>";
	vCode = vCode + "<TD WIDTH='14%'><FONT SIZE='2' FACE='" + fontface + "' COLOR='#006699'><B>Vie</B></FONT></TD>";
	vCode = vCode + "<TD WIDTH='16%'><FONT SIZE='2' FACE='" + fontface + "' COLOR='#006699'><B>Sab</B></FONT></TD>";
	vCode = vCode + "</TR>";
	
	return vCode;
}
Calendar.prototype.cal_data = function() {
	var vDate = new Date();
	vDate.setDate(1);
	vDate.setMonth(this.gMonth);
	vDate.setFullYear(this.gYear);
	var vFirstDay=vDate.getDay();
	var vDay=1;
	var vLastDay=Calendar.get_daysofmonth(this.gMonth, this.gYear);
	var vOnLastDay=0;
	var vCode = "";
	/*
	Get day for the 1st of the requested month/year..
	Place as many blank cells before the 1st day of the month as necessary. 
	*/
	vCode = vCode + "<TR>";
	for (i=0; i<vFirstDay; i++) {
		vCode = vCode + "<TD WIDTH='14%'" + this.write_weekend_string(i) + "><FONT SIZE='2' FACE='" + fontface + "'>&nbsp;</FONT></TD>";
	}
	// Write rest of the 1st week
	for (j=vFirstDay; j<7; j++) {
		vCode = vCode + "<TD WIDTH='14%'" + this.write_weekend_string(j) + "><FONT SIZE='2' FACE='" + fontface + "'>" + 
			"<A HREF='#' " + 
				"onClick=\"self.opener.document." + this.gReturnItem + ".value='" + 
				this.format_data(vDay) + 
				"';self.opener.document.forms[0].pasaanio.value ='"+this.format_data(vDay).substring(6)+"';    window.close();\">" + 
				this.format_day(vDay) + 
			"</A>" + 
			"</FONT></TD>";
		vDay=vDay + 1;
	}
	vCode = vCode + "</TR>";
	// Write the rest of the weeks
	for (k=2; k<7; k++) {
		vCode = vCode + "<TR>";
		for (j=0; j<7; j++) {
			vCode = vCode + "<TD WIDTH='14%'" + this.write_weekend_string(j) + "><FONT SIZE='2' FACE='" + fontface + "'>" + 
				"<A HREF='#' " + 
					"onClick=\"self.opener.document." + this.gReturnItem + ".value='" + 
					this.format_data(vDay) + 
				"';self.opener.document.forms[0].pasaanio.value ='"+this.format_data(vDay).substring(6)+"';    window.close();\">" + 
				this.format_day(vDay) + 
				"</A>" + 
				"</FONT></TD>";
			vDay=vDay + 1;
			if (vDay > vLastDay) {
				vOnLastDay = 1;
				break;
			}
		}
		if (j == 6)
			vCode = vCode + "</TR>";
		if (vOnLastDay == 1)
			break;
	}
	
	// Fill up the rest of last week with proper blanks, so that we get proper square blocks
	for (m=1; m<(7-j); m++) {
		if (this.gYearly)
			vCode = vCode + "<TD WIDTH='14%'" + this.write_weekend_string(j+m) + 
			"><FONT SIZE='2' FACE='" + fontface + "' COLOR='gray'>&nbsp;</FONT></TD>";
		else
			vCode = vCode + "<TD WIDTH='14%'" + this.write_weekend_string(j+m) + 
			"><FONT SIZE='2' FACE='" + fontface + "' COLOR='gray'>" + m + "</FONT></TD>";
	}
	
	return vCode;
}
Calendar.prototype.format_day = function(vday) {
	var vNowDay = gNow.getDate();
	var vNowMonth = gNow.getMonth();
	var vNowYear = gNow.getFullYear();
	if (vday == vNowDay && this.gMonth == vNowMonth && this.gYear == vNowYear)
		return ("<FONT COLOR=\"RED\"><B>" + vday + "</B></FONT>");
	else
		return (vday);
}
Calendar.prototype.write_weekend_string = function(vday) {
	var i;
	// Return special formatting for the weekend day.
	for (i=0; i<weekend.length; i++) {
		if (vday == weekend[i])
			return (" BGCOLOR=\"" + weekendColor + "\"");
	}
	
	return "";
}
Calendar.prototype.format_data = function(p_day) {
	var vData;
	var vMonth = 1 + this.gMonth;
	vMonth = (vMonth.toString().length < 2) ? "0" + vMonth : vMonth;
	var vMon = Calendar.get_month(this.gMonth).substr(0,3).toUpperCase();
	var vFMon = Calendar.get_month(this.gMonth).toUpperCase();
	var vY4 = new String(this.gYear);
	var vY2 = new String(this.gYear.substr(2,2));
	var vDD = (p_day.toString().length < 2) ? "0" + p_day : p_day;
	switch (this.gFormat) {
		case "MM\/DD\/YYYY" :
			vData = vMonth + "\/" + vDD + "\/" + vY4;
			break;
		case "MM\/DD\/YY" :
			vData = vMonth + "\/" + vDD + "\/" + vY2;
			break;
		case "MM-DD-YYYY" :
			vData = vMonth + "-" + vDD + "-" + vY4;
			break;
		case "MM-DD-YY" :
			vData = vMonth + "-" + vDD + "-" + vY2;
			break;
		case "DD\/MON\/YYYY" :
			vData = vDD + "\/" + vMon + "\/" + vY4;
			break;
		case "DD\/MON\/YY" :
			vData = vDD + "\/" + vMon + "\/" + vY2;
			break;
		case "DD-MON-YYYY" :
			vData = vDD + "-" + vMon + "-" + vY4;
			break;
		case "DD-MON-YY" :
			vData = vDD + "-" + vMon + "-" + vY2;
			break;
		case "DD\/MONTH\/YYYY" :
			vData = vDD + "\/" + vFMon + "\/" + vY4;
			break;
		case "DD\/MONTH\/YY" :
			vData = vDD + "\/" + vFMon + "\/" + vY2;
			break;
		case "DD-MONTH-YYYY" :
			vData = vDD + "-" + vFMon + "-" + vY4;
			break;
		case "DD-MONTH-YY" :
			vData = vDD + "-" + vFMon + "-" + vY2;
			break;
		case "DD\/MM\/YYYY" :
			vData = vDD + "\/" + vMonth + "\/" + vY4;
			break;
		case "DD\/MM\/YY" :
			vData = vDD + "\/" + vMonth + "\/" + vY2;
			break;
		case "DD-MM-YYYY" :
			vData = vDD + "-" + vMonth + "-" + vY4;
			break;
		case "DD-MM-YY" :
			vData = vDD + "-" + vMonth + "-" + vY2;
			break;
		default :
			vData = vMonth + "\/" + vDD + "\/" + vY4;
	}
	return vData;
}
function Build(p_item, p_month, p_year, p_format) {
	var p_WinCal = ggWinCal;
	gCal = new Calendar(p_item, p_WinCal, p_month, p_year, p_format);
	// Customize your Calendar here..
	gCal.gBGColor="white";
	gCal.gLinkColor="black";
	gCal.gTextColor="black";
	gCal.gHeaderColor="White";
	// Choose appropriate show function
	if (gCal.gYearly)	gCal.showY();
	else	gCal.show();
}
function show_calendar() {
	/* 
		p_month : 0-11 for Jan-Dec; 12 for All Months.
		p_year	: 4-digit year
		p_format: Date format (mm/dd/yyyy, dd/mm/yy, ...)
		p_item	: Return Item.
	*/
	p_item = arguments[0];
	if (arguments[1] == null)
		p_month = new String(gNow.getMonth());
	else
		p_month = arguments[1];
	if (arguments[2] == "" || arguments[2] == null)
		p_year = new String(gNow.getFullYear().toString());
	else
		p_year = arguments[2];
	if (arguments[3] == null)
		p_format = "DD/MM/YYYY";				//MODIFICAR PARA EL FORMATO DE CALENDARIO
	else
		p_format = arguments[3];
	vWinCal = window.open("", "Calendar", "width=250,height=250,status=no,resizable=no,top=200,left=200,modal=yes");
	vWinCal.opener = self;
	ggWinCal = vWinCal;
	Build(p_item, p_month, p_year, p_format);
}

/*
Yearly Calendar Code Starts here
*/
function show_yearly_calendar(p_item, p_year, p_format) {
	// Load the defaults..
	if (p_year == null || p_year == "")
		p_year = new String(gNow.getFullYear().toString());
	if (p_format == null || p_format == "")
		p_format = "MM/DD/YYYY";
	var vWinCal = window.open("", "Calendar", "scrollbars=yes");
	vWinCal.opener = self;
	ggWinCal = vWinCal;
	Build(p_item, null, p_year, p_format);
}
///////FIN CALENDARIO

//////Mensaje en TASKBAR
function infoscroll(seed,looped){var text1 = "SiSAPv2.5";
var text2 = "                                              MEVE Soluciones";
var msg=text1+text2;var putout = " ";
        var c   = 1;
	if (looped > 10) {
		window.status="SiSAPv2.5";
	}
	else if (seed > 100) 
{
                seed--;
                var cmd="infoscroll(" + seed + "," + looped + ")";
                timerTwo=window.setTimeout(cmd,100);
        }
        else if (seed <= 100 && seed > 0) {
                for (c=0 ; c < seed ; c++) {
                        putout+=" ";
                }
putout+=msg.substring(0,100-seed);	
                seed--;
                var cmd="infoscroll(" + seed + "," + looped + ")";
                    window.status=putout;
                timerTwo=window.setTimeout(cmd,100);
        }
        else if (seed <= 0) 
{
                if (-seed < msg.length) 
{
                        putout+=msg.substring(-seed,msg.length);
                        seed--;
                        var cmd="infoscroll(" + seed + "," + looped + ")";
                        window.status=putout;
                        timerTwo=window.setTimeout(cmd,100); // 100
                }
                else {
                        window.status=" ";
			looped += 1;
			var cmd = "infoscroll(100," + looped + ")";
                       timerTwo=window.setTimeout(cmd,75); // 75
                }
        }
}
/////////////FIN MENSAJE TASKBAR
/////////////VALIDA PORCENTAJE
function valPorcentaje(field) {
if (isNaN(field.value)) field.value = "";
if (field.value > 100) field.value = "";
if (field.value < 0) field.value = "";
if (field.value.indexOf("-") != -1) field.value = "";
}
/////////////FIN VALIDA PORCENTAJE
/////////////VALIDA NUMERO POSITIVO
function valNumPositivo(field) {
if (isNaN(field.value)) field.value = "";
if (field.value < 0) field.value = "";
if (field.value.indexOf("-") != -1) field.value = "";
}
/////////////FIN VALIDA NUMERO POSITIVO
/////////////VALIDA Currency
function valCurrency(field) {
var ab = '1234567890,.';
var i = 0;
while (i < field.value.length) {
	if (ab.indexOf(field.value.substr(i,1)) == -1) field.value = "";
	i = i +1;
}
}
/////////////FIN VALIDA Currency
/////////////VALIDA NUMERO ENTERO POSITIVO
function valNumEntPositivo(field) {
if (isNaN(field.value)) field.value = "";
if (field.value < 0) field.value = "";
if (field.value.indexOf("-") != -1) field.value = "";
if (field.value.indexOf(".") != -1) field.value = "";
if (field.value.indexOf(",") != -1) field.value = "";
}
/////////////FIN VALIDA NUMERO POSITIVO
/////////////VALIDA HORA
function validHora(field) {
var valid = "0123456789:"
var ok = "yes";
var temp;
	for (var i=0; i<field.value.length; i++) {
		temp = "" + field.value.substring(i, i+1);
		if (valid.indexOf(temp) == "-1") ok = "no";
	}
	if (ok == "no") {
		field.value="";
	}else{
		if (field.value.length > 5) field.value="";
		if (field.value.length == 5) { //validar horas menor de 24 horas
			if (field.value.substring(0,field.value.indexOf(":")) > 24) field.value="";;
		}
		//validar minutos menor de 59 minutos
		if (field.value.substring(field.value.indexOf(":")+1,field.value.indexOf(":")+3) > 59) field.value="";
		return false;
   	}
}
/////////////fin VALIDA HORA
/////////////INI SCROLL
function zx(){
	if (fq++<mesleng-1){
		document.title=message.substring(fq,mesleng);
		setTimeout("zx()",scrspd);
	}
	else{
		fq=0;
		setTimeout("zz()",scrspd);
	}
}
function zz(){
	disp = disp + message.charAt(fq);
	document.title=disp;
	fq++;
	if (fq<mesleng) {
		setTimeout("zz()",scrspd)}
	else {
		fq=-1;
		disp="";
		setTimeout("zx()",scrspd);}
} 
///FIN SCROLL
//VALIDA FECHA
function validafec(b,fi){
	var doc=document.forms[0];
	var hano1=b.value;
	var hmes1=b.value;
	var hdia1=b.value;
	var jano1=fi.value;
	var jmes1=fi.value;
	var jdia1=fi.value;
	var hano=hano1.substring(6,10);
	var hmes=hmes1.substring(0,2);
	var hdia=hdia1.substring(3,5);
	var jano=jano1.substring(6,10);
	var jmes=jmes1.substring(0,2);
	var jdia=jdia1.substring(3,5);
	var dini = new Date(hano,hmes,hdia);		
	var dfin = new Date(jano,jmes,jdia);
	
	if (dini>dfin){
		return 1;
	}else{
		return 0;
	}
}
//FIN VALIDA FECHA
//CALCULA DIAS ENTRE FECHA Y FECHA
function calculaDias(b,fi){
	var doc=document.forms[0];
	var hano1=b.value;
	var hmes1=b.value;
	var hdia1=b.value;
	var jano1=fi.value;
	var jmes1=fi.value;
	var jdia1=fi.value;
	var hano=hano1.substring(6,10);
	var hmes=hmes1.substring(0,2);
	var hdia=hdia1.substring(3,5);
	var jano=jano1.substring(6,10);
	var jmes=jmes1.substring(0,2);
	var jdia=jdia1.substring(3,5);
	var dini = new Date(hano,hmes,hdia);		
	var dfin = new Date(jano,jmes,jdia);
	
	if (dini>dfin){
		return 0;
	}else{
		return (dfin - dini)/86400000;
	}
}
//FIN CALCULA DIAS ENTRE FECHA Y FECHA
//////////Funciones para hacer que el calendario se quede en el frente
function deadend() {
	if (vWinCal && !vWinCal.closed) {
		vWinCal.focus()
		return false
	}
}
function checkModal() {
	if (vWinCal && !vWinCal.closed) {
		vWinCal.focus();
	}
}
function blockEvents() {
	if (Nav4) {
		window.captureEvents(Event.CLICK | Event.MOUSEDOWN | Event.MOUSEUP | Event.FOCUS)
		window.onclick = deadend
	} else {
		disableForm()
	}
	window.onfocus = checkModal
}
function unblockEvents() {
	if (Nav4) {
		window.releaseEvents(Event.CLICK | Event.MOUSEDOWN | Event.MOUSEUP | Event.FOCUS)
		window.onclick = null
		window.onfocus = null
	} else {
		enableForms()
	}
}
function enableForms() {	
		
			for (var j = 0; j < document.forms[0].elements.length; j++) {
				document.forms[0].elements[j].disabled = false
			}
		
			for (i = 0; i < document.links.length; i++) {
			document.links[i].onclick = IELinkClicks[i];
			}
}
function disableForm () {
			for (var j = 0; j < document.forms[0].elements.length; j++) {
				document.forms[0].elements[j].disabled = true
			}
		
		for (i = 0; i < document.links.length; i++) {
			IELinkClicks[i] = document.links[i].onclick
			document.links[i].onclick = deadend
		}
	}
//////////FIN Funciones para hacer que el calendario se quede en el frente
////////////Eliminar el mensaje de "No documents found"
function CheckNoDocuments() { 
	if (document.getElementById("view").innerHTML.indexOf("No documents found") > 0) {
		document.getElementById("view").innerHTML = ""
		document.getElementById("msg").innerHTML = msg
	} 
} // end function
/*--------------------------------------------------|
| dTree 2.05 | www.destroydrop.com/javascript/tree/ |
|---------------------------------------------------|
| Copyright (c) 2002-2003 Geir Landró               |
|                                                   |
| This script can be used freely as long as all     |
| copyright messages are intact.                    |
|                                                   |
| Updated: 17.04.2003                               |
|--------------------------------------------------*/
// Node object
function Node(id, pid, name, url, title, target, icon, iconOpen, open) {
	this.id = id;
	this.pid = pid;
	this.name = name;
	this.url = url;
	this.title = title;
	this.target = target;
	this.icon = icon;
	this.iconOpen = iconOpen;
	this._io = open || false;
	this._is = false;
	this._ls = false;
	this._hc = false;
	this._ai = 0;
	this._p;
};
// Tree object
function dTree(objName) {
	this.config = {
		target					: null,
		folderLinks				: true,
		useSelection				: true,
		useCookies				: true,
		useLines				: true,
		useIcons				: true,
		useStatusText				: false,
		closeSameLevel			: false,
		inOrder					: false
	}
	this.icon = {
		root				: '../Imagenes/base.gif',
		folder				: '../Imagenes/folder.gif',
		folderOpen			: '../Imagenes/folderopen.gif',
		node				: '../Imagenes/page.gif',
		empty				: '../Imagenes/empty.gif',
		line				: '../Imagenes/line.gif',
		join				: '../Imagenes/join.gif',
		joinBottom			: '../Imagenes/joinbottom.gif',
		plus				: '../Imagenes/plus.gif',
		plusBottom			: '../Imagenes/plusbottom.gif',
		minus				: '../Imagenes/minus.gif',
		minusBottom			: '../Imagenes/minusbottom.gif',
		nlPlus				: '../Imagenes/nolines_plus.gif',
		nlMinus				: '../Imagenes/nolines_minus.gif'
	};
	this.obj = objName;
	this.aNodes = [];
	this.aIndent = [];
	this.root = new Node(-1);
	this.selectedNode = null;
	this.selectedFound = false;
	this.completed = false;
};
// Adds a new node to the node array
dTree.prototype.add = function(id, pid, name, url, title, target, icon, iconOpen, open) {
	this.aNodes[this.aNodes.length] = new Node(id, pid, name, url, title, target, icon, iconOpen, open);
};
// Open/close all nodes
dTree.prototype.openAll = function() {
	this.oAll(true);
};
dTree.prototype.closeAll = function() {
	this.oAll(false);
};
// Outputs the tree to the page
dTree.prototype.toString = function() {
	var str = '<div class="dtree">\n';
	if (document.getElementById) {
		if (this.config.useCookies) this.selectedNode = this.getSelected();
		str += this.addNode(this.root);
	} else str += 'Browser not supported.';
	str += '</div>';
	if (!this.selectedFound) this.selectedNode = null;
	this.completed = true;
	return str;
};
// Creates the tree structure
dTree.prototype.addNode = function(pNode) {
	var str = '';
	var n=0;
	if (this.config.inOrder) n = pNode._ai;
	for (n; n<this.aNodes.length; n++) {
		if (this.aNodes[n].pid == pNode.id) {
			var cn = this.aNodes[n];
			cn._p = pNode;
			cn._ai = n;
			this.setCS(cn);
			if (!cn.target && this.config.target) cn.target = this.config.target;
			if (cn._hc && !cn._io && this.config.useCookies) cn._io = this.isOpen(cn.id);
			if (!this.config.folderLinks && cn._hc) cn.url = null;
			if (this.config.useSelection && cn.id == this.selectedNode && !this.selectedFound) {
					cn._is = true;
					this.selectedNode = n;
					this.selectedFound = true;
			}
			str += this.node(cn, n);
			if (cn._ls) break;
		}
	}
	return str;
};
// Creates the node icon, url and text
dTree.prototype.node = function(node, nodeId) {
	var str = '<div class="dTreeNode">' + this.indent(node, nodeId);
	if (this.config.useIcons) {
		if (!node.icon) node.icon = (this.root.id == node.pid) ? this.icon.root : ((node._hc) ? this.icon.folder : this.icon.node);
		if (!node.iconOpen) node.iconOpen = (node._hc) ? this.icon.folderOpen : this.icon.node;
		if (this.root.id == node.pid) {
			node.icon = this.icon.root;
			node.iconOpen = this.icon.root;
		}
		str += '<img id="i' + this.obj + nodeId + '" src="' + ((node._io) ? node.iconOpen : node.icon) + '" title="" />';
	}
	if (node.url) {
		str += '<a id="s' + this.obj + nodeId + '" class="' + ((this.config.useSelection) ? ((node._is ? 'nodeSel' : 'node')) : 'node') + '" href="' + node.url + '"';
		if (node.title) str += ' title="' + node.title + '"';
		if (node.target) str += ' target="' + node.target + '"';
		if (this.config.useStatusText) str += ' onmouseover="window.status=\'' + node.name + '\';return true;" onmouseout="window.status=\'\';return true;" ';
		if (this.config.useSelection && ((node._hc && this.config.folderLinks) || !node._hc))
			str += ' onclick="javascript: ' + this.obj + '.s(' + nodeId + ');"';
		str += '>';
	}
	else if ((!this.config.folderLinks || !node.url) && node._hc && node.pid != this.root.id)
		str += '<a href="javascript: ' + this.obj + '.o(' + nodeId + ');" class="node">';
	str += node.name;
	if (node.url || ((!this.config.folderLinks || !node.url) && node._hc)) str += '</a>';
	str += '</div>';
	if (node._hc) {
		str += '<div id="d' + this.obj + nodeId + '" class="clip" style="display:' + ((this.root.id == node.pid || node._io) ? 'block' : 'none') + ';">';
		str += this.addNode(node);
		str += '</div>';
	}
	this.aIndent.pop();
	return str;
};
// Adds the empty and line icons
dTree.prototype.indent = function(node, nodeId) {
	var str = '';
	if (this.root.id != node.pid) {
		for (var n=0; n<this.aIndent.length; n++)
			str += '<img src="' + ( (this.aIndent[n] == 1 && this.config.useLines) ? this.icon.line : this.icon.empty ) + '" title="" />';
		(node._ls) ? this.aIndent.push(0) : this.aIndent.push(1);
		if (node._hc) {
			str += '<a href="javascript: ' + this.obj + '.o(' + nodeId + ');"><img id="j' + this.obj + nodeId + '" src="';
			if (!this.config.useLines) str += (node._io) ? this.icon.nlMinus : this.icon.nlPlus;
			else str += ( (node._io) ? ((node._ls && this.config.useLines) ? this.icon.minusBottom : this.icon.minus) : ((node._ls && this.config.useLines) ? this.icon.plusBottom : this.icon.plus ) );
			str += '" title="" /></a>';
		} else str += '<img src="' + ( (this.config.useLines) ? ((node._ls) ? this.icon.joinBottom : this.icon.join ) : this.icon.empty) + '" title="" />';
	}
	return str;
};
// Checks if a node has any children and if it is the last sibling
dTree.prototype.setCS = function(node) {
	var lastId;
	for (var n=0; n<this.aNodes.length; n++) {
		if (this.aNodes[n].pid == node.id) node._hc = true;
		if (this.aNodes[n].pid == node.pid) lastId = this.aNodes[n].id;
	}
	if (lastId==node.id) node._ls = true;
};
// Returns the selected node
dTree.prototype.getSelected = function() {
	var sn = this.getCookie('cs' + this.obj);
	return (sn) ? sn : null;
};
// Highlights the selected node
dTree.prototype.s = function(id) {
	if (!this.config.useSelection) return;
	var cn = this.aNodes[id];
	if (cn._hc && !this.config.folderLinks) return;
	if (this.selectedNode != id) {
		if (this.selectedNode || this.selectedNode==0) {
			eOld = document.getElementById("s" + this.obj + this.selectedNode);
			eOld.className = "node";
		}
		eNew = document.getElementById("s" + this.obj + id);
		eNew.className = "nodeSel";
		this.selectedNode = id;
		if (this.config.useCookies) this.setCookie('cs' + this.obj, cn.id);
	}
};
// Toggle Open or close
dTree.prototype.o = function(id) {
	var cn = this.aNodes[id];
	this.nodeStatus(!cn._io, id, cn._ls);
	cn._io = !cn._io;
	if (this.config.closeSameLevel) this.closeLevel(cn);
	if (this.config.useCookies) this.updateCookie();
};
// Open or close all nodes
dTree.prototype.oAll = function(status) {
	for (var n=0; n<this.aNodes.length; n++) {
		if (this.aNodes[n]._hc && this.aNodes[n].pid != this.root.id) {
			this.nodeStatus(status, n, this.aNodes[n]._ls)
			this.aNodes[n]._io = status;
		}
	}
	if (this.config.useCookies) this.updateCookie();
};
// Opens the tree to a specific node
dTree.prototype.openTo = function(nId, bSelect, bFirst) {
	if (!bFirst) {
		for (var n=0; n<this.aNodes.length; n++) {
			if (this.aNodes[n].id == nId) {
				nId=n;
				break;
			}
		}
	}
	var cn=this.aNodes[nId];
	if (cn.pid==this.root.id || !cn._p) return;
	cn._io = true;
	cn._is = bSelect;
	if (this.completed && cn._hc) this.nodeStatus(true, cn._ai, cn._ls);
	if (this.completed && bSelect) this.s(cn._ai);
	else if (bSelect) this._sn=cn._ai;
	this.openTo(cn._p._ai, false, true);
};
// Closes all nodes on the same level as certain node
dTree.prototype.closeLevel = function(node) {
	for (var n=0; n<this.aNodes.length; n++) {
		if (this.aNodes[n].pid == node.pid && this.aNodes[n].id != node.id && this.aNodes[n]._hc) {
			this.nodeStatus(false, n, this.aNodes[n]._ls);
			this.aNodes[n]._io = false;
			this.closeAllChildren(this.aNodes[n]);
		}
	}
}
// Closes all children of a node
dTree.prototype.closeAllChildren = function(node) {
	for (var n=0; n<this.aNodes.length; n++) {
		if (this.aNodes[n].pid == node.id && this.aNodes[n]._hc) {
			if (this.aNodes[n]._io) this.nodeStatus(false, n, this.aNodes[n]._ls);
			this.aNodes[n]._io = false;
			this.closeAllChildren(this.aNodes[n]);		
		}
	}
}
// Change the status of a node(open or closed)
dTree.prototype.nodeStatus = function(status, id, bottom) {
	eDiv	= document.getElementById('d' + this.obj + id);
	eJoin	= document.getElementById('j' + this.obj + id);
	if (this.config.useIcons) {
		eIcon	= document.getElementById('i' + this.obj + id);
		eIcon.src = (status) ? this.aNodes[id].iconOpen : this.aNodes[id].icon;
	}
	eJoin.src = (this.config.useLines)?
	((status)?((bottom)?this.icon.minusBottom:this.icon.minus):((bottom)?this.icon.plusBottom:this.icon.plus)):
	((status)?this.icon.nlMinus:this.icon.nlPlus);
	eDiv.style.display = (status) ? 'block': 'none';
};
// [Cookie] Clears a cookie
dTree.prototype.clearCookie = function() {
	var now = new Date();
	var yesterday = new Date(now.getTime() - 1000 * 60 * 60 * 24);
	this.setCookie('co'+this.obj, 'cookieValue', yesterday);
	this.setCookie('cs'+this.obj, 'cookieValue', yesterday);
};
// [Cookie] Sets value in a cookie
dTree.prototype.setCookie = function(cookieName, cookieValue, expires, path, domain, secure) {
	document.cookie =
		escape(cookieName) + '=' + escape(cookieValue)
		+ (expires ? '; expires=' + expires.toGMTString() : '')
		+ (path ? '; path=' + path : '')
		+ (domain ? '; domain=' + domain : '')
		+ (secure ? '; secure' : '');
};
// [Cookie] Gets a value from a cookie
dTree.prototype.getCookie = function(cookieName) {
	var cookieValue = '';
	var posName = document.cookie.indexOf(escape(cookieName) + '=');
	if (posName != -1) {
		var posValue = posName + (escape(cookieName) + '=').length;
		var endPos = document.cookie.indexOf(';', posValue);
		if (endPos != -1) cookieValue = unescape(document.cookie.substring(posValue, endPos));
		else cookieValue = unescape(document.cookie.substring(posValue));
	}
	return (cookieValue);
};
// [Cookie] Returns ids of open nodes as a string
dTree.prototype.updateCookie = function() {
	var str = '';
	for (var n=0; n<this.aNodes.length; n++) {
		if (this.aNodes[n]._io && this.aNodes[n].pid != this.root.id) {
			if (str) str += '.';
			str += this.aNodes[n].id;
		}
	}
	this.setCookie('co' + this.obj, str);
};
// [Cookie] Checks if a node id is in a cookie
dTree.prototype.isOpen = function(id) {
	var aOpen = this.getCookie('co' + this.obj).split('.');
	for (var n=0; n<aOpen.length; n++)
		if (aOpen[n] == id) return true;
	return false;
};
// If Push and pop is not implemented by the browser
if (!Array.prototype.push) {
	Array.prototype.push = function array_push() {
		for(var i=0;i<arguments.length;i++)
			this[this.length]=arguments[i];
		return this.length;
	}
};
if (!Array.prototype.pop) {
	Array.prototype.pop = function array_pop() {
		lastElement = this[this.length-1];
		this.length = Math.max(this.length-1,0);
		return lastElement;
	}
};

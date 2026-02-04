// GeneralFunctions.js

// GeneralFunctions.js JavaScript Document
//IsEmpty(strString)			//Verifica si strString es un valor nulo
//IsNumeric(strString)			//Verifica si strString es un valor numero
//IsNumberFloat(strString)		//Verifica si strString es un valor numero flotante
//IsNumberint(strString)		//Verifica si strString es un valor numero entero
//IsAlpha(strString)			//Verifica si strString es un valor alfabetico
//IsTimeGeneral(timeStr)		//Verifica si timeStr es un valor de hora valido
//IsEmail(strString)			//Verifica si strString es un valor de Direccion de Correo electronico
//IsSymbol(character)			//Verifica si character esta contenido en la lista de simbolos
//ValidPorcent(Field)			//Valida que un campo contiene un valor de porcentaje valido
//ValidNumber(evt)				//Valida que un campo contiene un valor numero (sin punto decimal)
//ValidCurrency(Field)			//Valida que un campo contiene un valor de moneda
//ValidNumentPositivo(Field)	//Valida que un campo contiene un valor de numero entero positivo
//ValidHora(strField)			//Valida que un campo tenga el valor de una hora valida
//ValidRadio(strField, TitleField)	//Valida que se seleccione una opcion en un campo RadioButton
//ValidComboBox(strField, TitleField)	//Valida que se seleccione una opcion en un campo ComboBox
//ValidTextBox(strField, TitleField)	//Valida que se capture un texto en un campo
//ValidFormatDate(strField,  TitleField, strDatestyle)	//Funcion para Validar el Formato de Fecha a dd/mm/yy o dd/mmm/yy
//LeapYear(intYear)				//Devuelve si el año es Bisiesto (Forma parte de la Funcion FormatDate())
//trim(strString)				//Quita los espacio al inicio y al final de un texto
//replaceCharacters(strString,inChar,outChar)	//Remplaza todas las ocurrencias de un carácter dado en una cadena con otro carácter
//removeRepeatChar(strString, delimiter)	//Quita el carácter delimiter de toda una cadena
//Contains(strString, checkString)	//Devuelve la posicion de inicio de un String que esta contenido en otro
//bubbleSort(theArray)			//Ordena un arreglo alfabeticamente o numericamente en orden ascendente
//printPage()					//Imprime el contenido de un documento
//setStatusBar(strString)		//Despliega el mensaje en el StatusBar
//findobj(theobj, theDoc)		//Localiza un objeto dentro de un documento por DoM
//openForm(Page, FieldName, winParams)	//Abre una pagina enviando en el uRL el nombre del campo y su valor como parámetro
//SetCookie(name,value)			//Coloca en la Cookie un valor "value" asignado a un nombre de variable "name"
//DeleteCookie(name)			//Borra de la Cookie la variable "name" y su valor
//getCookieVal(offset)			//Obtiene de la cookie el string desde la posicion "offset" especificada
//GetCookie(name)				//Obtiene de la Cookie el valor contenido en la variable "name"
//WriteCookie()					//Devuelve el contenido completo de la Cookie
//disableRightClick(e)			//Deshabilita la Funcion de click derecho del Mouse para no tener el menu contextual
//RememberPage(refDocument, urlRef)	//Funcion para adicionar el url de la pagina que se esta accediendo al campo Historial
//GoPage(DocReference, DocDestino, Method	//Funcion para ir a la pagina anterior guardada en el campo link
//ToolTip						//Aparece un mensaje cerca del cerca del cursor del mouse



//Funciones

function IsEmpty(strString)
{
//Verifica si strString es un valor nulo
  if ((strString.length==0) ||
   (strString==null)) {
      return true;
   }
   else { return false; }
}

function IsNumeric(strString)
{
//Verifica si strString es un valor numero
var strValidChars = "0123456789.-";
var strChar;
var blnResult = true;
if (strString.length == 0) return false;
for (i = 0; i < strString.length && blnResult == true; i++)
 {
 strChar = strString.charAt(i);
 if (strValidChars.indexOf(strChar) == -1)
  {
  blnResult = false;
  }
 }
return blnResult;
}

function IsNumberFloat(strString)
{
//Verifica si strString es un valor numero flotante
  return (!isNaN(parseFloat(strString))) ? true : false;
}

function IsNumberint(strString)
{
//Verifica si strString es un valor numero entero
  return (!isNaN(parseint(strString))) ? true : false;
}

function IsAlpha(strString)
{
//Verifica si strString es un valor alfabetico 
var letters="abcdefghijklmnopqrstuvwxyz";
var LeTTeRS="ABCDeFGHiJKLMNoPQRSTuVWXYZ";
// es un String o un character?
if(strString.length>1)
 {
 for(j=0;j<strString.length;j++)
  {
  // Llamada recursiva a isAlpha para cada caracter
  alpha=isAlpha(strString.substring(j,j+1));
  if(!alpha) 
   return alpha;
  }
 return alpha;
 }
else
 {
 // Si es alfabetico entonces devuelve true
 if(letters.indexOf(strString)>=0 || LeTTeRS.indexOf(strString)>=0)
  return true;
 return false;
    }
}

function IsTimeGeneral(timeStr) 
{
//Verifica si timeStr es un valor de hora valido
var timePat = /^(\d{1,2}):(\d{2})(:(\d{2}))?(\s?(AM|am|PM|pm))?$/;

var matchArray = timeStr.match(timePat);
if (matchArray == null)
 {
 return false;
 }
hour = matchArray[1];
minute = matchArray[2];
second = matchArray[4];
ampm = matchArray[6];

if (second=="") { second = null; }
if (ampm=="") { ampm = null }

if (hour < 0  || hour > 23)
 {
 return false;
 }
if (hour <= 12 && ampm == null)
 {
 alert("Debe especificar AM o PM.");
 return false;
 }
if  (hour > 12 && ampm != null)
 {
 ampm=null;
 return false;
 }
if (minute<0 || minute > 59)
 {
 return false;
 }
if (second != null && (second < 0 || second > 59))
 {
 return false;
 }
return true;
}


function IsEmail(strString)
{
//Verifica si strString es un valor de Direccion de Correo electronico
   return (strString.indexOf(".") > 2) && (strString.indexOf("@") > 0); 
}

function IsSymbol(character)
{
//Verifica si character" esta contenido en la lista de simbolos
var symbols = " :;.,'?/<>??!?^~@#$%&*()=-_|[]{}"+'"'+"\\\n\t";
for(var i=0; i<symbols.length; i++)
    {
    if(character==symbols.charAt(i)) 
      {return true;}
    }
if(character=="")  {return true;}
if(character==null) {return true;}
return false;
}

function ValidPorcent(Field)
{
//Valida que un campo contiene un valor de porcentaje valido
if (isNaN(Field.value)) 
 Field.value = "";
if (Field.value > 100)
 Field.value = "";
if (Field.value < 0)
 Field.value = "";
if (Field.value.indexOf("-") != -1)
 Field.value = "";
}

function ValidNumber(evt)
{ 
//Valida que un campo contiene un valor numero (sin punto decimal)
//onKeyPress="return numeralsonly(event)"
    evt = (evt) ? evt : event; 
    var charCode = (evt.charCode) ? evt.charCode : ((evt.keyCode) ? evt.keyCode :  
        ((evt.which) ? evt.which : 0)); 
    if (charCode > 31 && (charCode < 48 || charCode > 57) && charCode != 46 ) { 
        alert("ingrese unicamente valores numericos en este campo."); 
        return false; 
    } 
    return true; 
}

function ValidCurrency(Field)
{
//Valida que un campo contiene un valor de moneda
num=Field.value;
num = num.toString().replace(/\$|\,/g,'');
if(isNaN(num))
 num = "0";
sign = (num == (num = Math.abs(num)));
num = Math.floor(num*100+0.50000000001);
cents = num%100;
num = Math.floor(num/100).toString();
if(cents<10)
 cents = "0" + cents;
for (var i = 0; i < Math.floor((num.length-(1+i))/3); i++)
 num = num.substring(0,num.length-(4*i+3))+','+num.substring(num.length-(4*i+3));
Field.value=(((sign)?'':'-') + num + '.' + cents);
}

function ValidNumentPositivo(Field)
{
//Valida que un campo contiene un valor de numero entero positivo
if (isNaN(Field.value)) Field.value = "";
if (Field.value < 0) Field.value = "";
if (Field.value.indexOf("-") != -1) Field.value = "";
if (Field.value.indexOf(".") != -1) Field.value = "";
if (Field.value.indexOf(",") != -1) Field.value = "";
}

function ValidHora(strField, TitleField)
{
//Valida que un campo tenga el valor de una hora valida
var Field=eval("document.forms[0]." + strField);
var valor=Field.value;
var msgError="Capture el campo :'" + TitleField + "'";
var timePat = /^(\d{1,2}):(\d{1,2})(:(\d{1,2}))?(\s?(AM|am|PM|pm))?$/;

var matchArray = valor.match(timePat);
if (matchArray == null)
 {
 alert(msgError);
 Field.focus();
 return false;
 }
hour = matchArray[1];
minute = matchArray[2];
second = matchArray[4];
ampm = matchArray[6];

if (second=="") { second = null; }
if (ampm=="") { ampm = null }

if (hour < 0  || hour > 23)
 {
 alert(msgError + ", Especifique una hora mayor a 0 y menor a 23");
 Field.focus();
 return false;
 }
if  (ampm != null)
 {
 alert(msgError + ", La hora es invalida");
 Field.focus();
 return false;
 }
if (minute<0 || minute > 59)
 {
 alert(msgError + ", Los minutos son invalidos");
 Field.focus();
 return false;
 }
if (second < 0 || second > 59)
 {
 alert(msgError + ", Los segundos son invalidos");
 Field.focus();
 return false;
 }
if (second == null)
 {
 second="00";
 }
if(hour<12)
 Field.value=hour + ":" + minute + ":" + second;
else
 Field.value=hour + ":" + minute + ":" + second;
return true;
}

function ValidRadio(strField, TitleField)
{
//Valida que se seleccione una opcion en un campo RadioButton
    var valid = false;
    var Field=eval("document.forms[0]." + strField);
    for (var i = 0; i < Field.length; i++) { 
        if (Field[i].checked) { 
            return true; 
        } 
    } 
 alert("Capture el campo : '"+TitleField + "'");
 Field.focus();
    return false; 
}

function ValidComboBox(strField, TitleField)
{
//Valida que se seleccione una opcion en un campo ComboBox 
var valor;
valor= eval("document.forms[0]." + strField + ".options[document.forms[0]." + strField + ".selectedIndex].text");
if(valor == null | valor == "")
 {
 alert("Capture el campo : '"+TitleField + "'");
 eval("document.forms[0]." + strField + ".focus()");
 return false;
 } 
else
 return true;
}

function ValidTextBox(strField, TitleField)
{
//Valida que se capture un texto en un campo 
var valor;
valor= eval("document.forms[0]." + strField + ".value");
valor=trim(valor);
//eval("document.forms[0]." + strField + ".value = '" + valor +"';");
if(valor == null | valor == "")
 {
 alert("Capture el campo : '"+TitleField + "'");
 eval("document.forms[0]." + strField + ".focus()");
 return false;
 }
else
 return true;
}

function ValidFormatDate(strField,  TitleField, strDatestyle)
{
//Funcion para Formatear la Fecha a dd/mm/yy o dd/mmm/yy
var strDate;
var strDateArray;
var strDay;
var strMonth;
var strYear;
var intday;
var intMonth;
var intYear;
var booFound = false;
var datefield = eval("document.forms[0]." + strField);
var strSeparatorArray = new Array("-"," ","/",".");
var validSeparator="/";
var intelementNr;
var err = 0;
var msgError="Capture correctamente el campo :'" + TitleField + "' con formato (" + strDatestyle + ")";
var strMonthArray = new Array(12);
strMonthArray[0] = "ene";
strMonthArray[1] = "Feb";
strMonthArray[2] = "Mar";
strMonthArray[3] = "Abr";
strMonthArray[4] = "May";
strMonthArray[5] = "Jun";
strMonthArray[6] = "Jul";
strMonthArray[7] = "Ago";
strMonthArray[8] = "Sep";
strMonthArray[9] = "oct";
strMonthArray[10] = "Nov";
strMonthArray[11] = "Dic";
strDate = datefield.value;
if (strDate.length < 1) {
 alert(msgError);
 eval("document.forms[0]." + strField + ".focus()");
 return false;
}

for (intelementNr = 0; intelementNr < strSeparatorArray.length; intelementNr++)
{
 if (strDate.indexOf(strSeparatorArray[intelementNr]) != -1)
  {
  validSeparator=strSeparatorArray[intelementNr];
  }
}

strDateArray = strDate.split(validSeparator);
if (strDateArray.length != 3)
{
 alert(msgError);
 eval("document.forms[0]." + strField + ".focus()");
 return false;
}
else
{
 if(strDatestyle == 'dd/mm/yy' || strDatestyle == 'dd/mm/yyyy')
  {
  strDay = strDateArray[0];
  strMonth = strDateArray[1];
  strYear = strDateArray[2];
  }
 if(strDatestyle == 'yy/mm/dd' || strDatestyle == 'yyyy/mm/dd')
  {
  strYear = strDateArray[0];
  strMonth = strDateArray[1];
  strDay = strDateArray[2];
  }
 if(strDatestyle =='mm/dd/yy')
  {
  strMonth = strDateArray[0];
  strDay = strDateArray[1];
  strYear = strDateArray[2];
  }
}
if(strYear.length <= 1 | strYear.length > 4)
{
 alert(msgError);
 eval("document.forms[0]." + strField + ".focus()");
 return false;
}
else
{
 intYear = parseInt(strYear, 10);
 if (isNaN(intYear))
 {
  alert(msgError);
  eval("document.forms[0]." + strField + ".focus()");
  return false;
 }
}
if(strDay.length <= 0 | strDay.length > 2)
{
 alert(msgError);
 eval("document.forms[0]." + strField + ".focus()");
 return false;
}
else
{
 intday = parseInt(strDay, 10);
 if (isNaN(intday))
 {
  alert(msgError);
  eval("document.forms[0]." + strField + ".focus()");
  return false;
 }
}
if(strMonth <= 0 & strMonth > 3)
{
 alert(msgError);
 eval("document.forms[0]." + strField + ".focus()");
 return false;
}
else
{
 intMonth = parseInt(strMonth, 10);
 if (isNaN(intMonth))
 {
  for (i = 0;i<12;i++)
  {
   if (strMonth.toUpperCase() == strMonthArray[i].toUpperCase())
   {
    intMonth = i+1;
    strMonth = strMonthArray[i];
    i = 12;
   }
  }
  if (isNaN(intMonth))
  {
   alert(msgError);
   eval("document.forms[0]." + strField + ".focus()");
   return false;
     }
 }

 if (intMonth>12 || intMonth<1)
 {
  alert(msgError);
  eval("document.forms[0]." + strField + ".focus()");
  return false;
 }

 if ((intMonth == 1 || intMonth == 3 || intMonth == 5 || intMonth == 7 || intMonth == 8 || intMonth == 10 || intMonth == 12) && (intday > 31 || intday < 1))
 {
  alert(msgError);
  eval("document.forms[0]." + strField + ".focus()");
  return false;
 }
 if ((intMonth == 4 || intMonth == 6 || intMonth == 9 || intMonth == 11) && (intday > 30 || intday < 1)) {
  alert(msgError);
  eval("document.forms[0]." + strField + ".focus()");
  return false;
 }
 if (intMonth == 2)
 {
  if (intday < 1)
  {
   alert(msgError);
   eval("document.forms[0]." + strField + ".focus()");
   return false;
  }
  if (LeapYear(intYear) == true)
  {
   if (intday > 29)
   {
    alert(msgError);
    eval("document.forms[0]." + strField + ".focus()");
    return false;
   }
  }
  else
  {
   if (intday > 28)
   {
    alert(msgError);
    eval("document.forms[0]." + strField + ".focus()");
    return false;
   }
  }
 }
}
if (strDatestyle=="dd/mm/yy")  datefield.value = strDay+"/" + strMonth + "/" + strYear;
if (strDatestyle=="dd/mmm/yy") datefield.value = intday+"/" + strMonthArray[intMonth-1] + "/" + strYear;
return true;
}

function LeapYear(intYear)
{
//Devuelve si el año es Bisiesto (Forma parte de la Funcion FormatDate())
if (intYear % 100 == 0) {
 if (intYear % 400 == 0) { return true; }
}
else {
 if ((intYear % 4) == 0) { return true; }
}
return false;
}

function trim(strString)
{
//Quita los espacio al inicio y al final de un texto
   if (typeof strString != "string") { return strString; }
   var retValue = strString;
   var ch = retValue.substring(0, 1);
   while (ch == " ") {
      retValue = retValue.substring(1, retValue.length);
      ch = retValue.substring(0, 1);
   }
   ch = retValue.substring(retValue.length-1, retValue.length);
   while (ch == " ") {
      retValue = retValue.substring(0, retValue.length-1);
      ch = retValue.substring(retValue.length-1, retValue.length);
   }
   while (retValue.indexOf("  ") != -1) {
      retValue = retValue.substring(0, retValue.indexOf("  ")) + retValue.substring(retValue.indexOf("  ")+1, retValue.length); 
   }
   return retValue;
}

function replaceCharacters(strString,inChar,outChar)
{
//Remplaza todas las ocurrencias de un carácter dado en una cadena con otro carácter
  var strString = strString.split(inChar);
  strString = strString.join(outChar);
  return strString;
}

function removeRepeatChar(strString, delimiter)
{
//Quita el carácter delimiter de toda una cadena
  var returnString = "";
  splitstring = strString.split(delimiter);
  for(i = 0; i < splitstring.length; i++)
    {
    if (splitstring[i]!="") returnString += splitstring[i] + delimiter;
    }
  return returnString;
}

function Contains(strString, checkString)
{
//Devuelve la posicion de inicio de un String que esta contenido en otro
  return strString.indexOf(checkString);
}

function bubbleSort(theArray)
{
//ordena un arreglo alfabeticamente o numericamente en orden ascendente
  var i, j;
  for (i = theArray.length - 1; i >= 0; i--)
  {
    for (j = 0; j <= i; j++)
    {
      if (theArray[j+1] < theArray[j])
      {
        var temp = theArray[j];
        theArray[j] = theArray[j+1];
        theArray[j+1] = temp;
      }
    }
  }
  return theArray;
}

function printPage()
{
//imprime el contenido de un documento
print(document);
}

function setStatusBar(strString)
{
//Despliega el mensaje en el StatusBar
self.status = strString;
}

function findobj(theobj, theDoc)
{
//Localiza un objeto dentro de un documento por DoM
// example: obj = findobj("image1");
//  Campo=findobj("NombreCampo", document)
  var p, i, foundobj;
  
  if(!theDoc) theDoc = document;
  if( (p = theobj.indexOf("?")) > 0 && parent.frames.length)
  {
    theDoc = parent.frames[theobj.substring(p+1)].document;
    theobj = theobj.substring(0,p);
  }
  if(!(foundobj = theDoc[theobj]) && theDoc.all) 
 foundobj = theDoc.all[theobj];
  for (i=0; !foundobj && i < theDoc.forms.length; i++) 
 foundobj = theDoc.forms[i][theobj];
  for(i=0; !foundobj && theDoc.layers && i < theDoc.layers.length; i++) 
 foundobj = findobj(theobj,theDoc.layers[i].document);
  if(!foundobj && document.getelementByid) 
 foundobj = document.getelementByid(theobj);
  return foundobj;
}

function openForm(Page, FieldName, winParams)
{
//Abre una pagina enviando en el uRL el nombre del campo y su valor como parámetro
var currHref = (document.location.href + "&").toLowerCase();
var dbName = currHref.substring(0, currHref.indexOf(".nsf")+4);
var newuRL;
var formula;
var currVal;

newuRL=dbName +"/"+Page+"&login"

if (FieldName != '')
{
//obtiene el valor del campo y envia el nombre del campo y el valor por medio del uRL
 formula = "document.forms[0]." + FieldName + ".value";
 currVal = eval(formula);
 newuRL+="&"+FieldName+"="+currVal;
}
winParams += ",toolbar=no, directories=no,status=no,scrollbars=yes,resize=no, resizable=no,menubar=no,dependent=yes,showdialogmodal=false,alwaysRaised=yes";
var newWindow = window.open(newuRL,currVal, winParams);                                                                 
}

function SetCookie(name,value)
{
//Coloca en la Cookie un valor "value" asignado a un nombre de variable "name"
var argv=SetCookie.arguments;
var argc=SetCookie.arguments.length;
var expires= (argc>2) ? argv[2] : null;
var path   = (argc>3) ? argv[3] : null;
var domain = (argc>4) ? argv[4] : null;
var secure = (argc>5) ? argv[5] : false;
if(expires==null) val1="";
else              val1=(";expires=" + expires.toGMTString());
if(path==null)    val2="";
else              val2=(";path=" + path);
if(domain==null)  val3="";
else              val3=";domain=" + domain;
if(secure==true)  val4=";secure";
else              val4="";
document.cookie = name + "=" + escape(value)+val1+val2+val3+val4;
}

function DeleteCookie(name)
{
//Borra de la Cookie la variable "name" y su valor
var exp=new Date();
exp.setTime(exp.getTime());
var cval=GetCookie(name);
document.cookie = name +"="+cval+";expires="+exp.toGMTString();
}

function getCookieVal(offset)
{
//obtiene de la cookie el string desde la posicion "offset" especificada
var endstr=document.cookie.indexOf(";",offset);
if(endstr==-1)
  endstr=document.cookie.length;
return unescape(document.cookie.substring(offset,endstr));
}

function GetCookie(name)
{
//obtiene de la Cookie el valor contenido en la variable "name"
var arg=name+"=";
var alen=arg.length;
var clen=document.cookie.length;
var i=0;
 while(i<clen)
 {
 var j=i+alen;
 if(document.cookie.substring(i,j)==arg)
   return getCookieVal(j)
 i=document.cookie.indexOf(" ",i)+1;
 if(i==0)  break;
 }
return null;
}

function WriteCookie()
{
//Devuelve el contenido completo de la Cookie
return document.cookie;
}

function disableRightClick(e)
{
//Deshabilita la Funcion de click derecho del Mouse para no tener el menu contextual
  var message = "Right click disabled";
  
  if(!document.rightClickDisabled) // initialize
  {
    if(document.layers) 
    {
      document.captureevents(event.MouSeDoWN);
      document.onmousedown = disableRightClick;
    }
    else document.oncontextmenu = disableRightClick;
    return document.rightClickDisabled = true;
  }
  if(document.layers || (document.getelementByid && !document.all))
  {
    if (e.which==2||e.which==3)
    {
      alert(message);
      return false;
    }
  }
  else
  {
    alert(message);
    return false;
  }
}

function RememberPage(refDocument, urlRef)
{
//Funcion para adicionar el url de la pagina que se esta accediendo al campo Historial
//RememberPage(window.parent.parent.i.document, document.location.href)
//RememberPage(window.parent.i.document,url);
var currHref = document.location.href;
var arrayurl;
if(urlRef==null) urlRef=currHref;
link=findobj("link");
if(link==null)
 link=findobj("link",refDocument);
//alert(urlRef);
strLink=link.value;
arrayurl=strLink.split("@");
strLink="";
for(i=0; i<=arrayurl.length-1;i++)
 {
 if (arrayurl[i] != currHref && trim(arrayurl[i]) != "")
   strLink=strLink + arrayurl[i] + "@";
  }
 strLink=strLink+ urlRef + "@";
 link.value=strLink;
}

function GoPage(DocReference, DocDestino, Method)
{
//Funcion para ir a la pagina anterior guardada en el campo link
//GoPage(window.parent.parent.i.document, document,"");
//GoPage(window.parent.i.document, window.document,url);
var currHref = DocDestino.location.href;
if(Method !="")
 currHref =Method;
link=findobj("link",DocReference);
if(link != null)
{
 strLink=link.value;
 arrayurl=strLink.split("@");
 strLink="";
 for(i=0; i<=arrayurl.length-1;i++)
  {
  if (arrayurl[i] != currHref && trim(arrayurl[i]) != "")
   {
   strLink=strLink + arrayurl[i] + "@";
   lasturl=arrayurl[i];
   }
  if (arrayurl[i] == currHref)
   i=arrayurl.length;

  }
 link.value=strLink;
 //alert("currHref :" + currHref + ".\n\nLink:" + arrayurl.join("\n") + ".\n\narrayurl.length:" + arrayurl.length + ".\n\n lasturl:" + lasturl);
 arrayurl=strLink.split("@");
 DocDestino.location.assign(lasturl);
}
else
 history.go(-1);
//window.location.href='/' + window.parent.i.document.forms[0].link.value;
}

//ToolTip
//Aparece un mensaje cerca del cerca del cursor del mouse
// example:
// onMouseover="toolTip('tool tip text here')";
// onMouseout="toolTip()";
// -or-
// onMouseover="toolTip('more good stuff', '#FFFF00', 'orange')";
// onMouseout="toolTip()"; 
/*
MoVe this to the <body>:
<div id="toolTipLayer" style="position:absolute; visibility: hidden"></div>
<script language="JavaScript"><!--
initToolTips(); //--></script>
*/
var ns4 = document.layers;
var ns6 = document.getelementByid && !document.all;
var ie4 = document.all;
offsetX = 0;
offsetY = 20;
var toolTipSTYLe="";
function initToolTips()
{
//inicializa el Layer del ToolTip
  if(ns4||ns6||ie4)
  {
    if(ns4) toolTipSTYLe = document.toolTipLayer;
    else if(ns6) toolTipSTYLe = document.getelementByid("toolTipLayer").style;
    else if(ie4) toolTipSTYLe = document.all.toolTipLayer.style;
    if(ns4) document.captureevents(event.MouSeMoVe);
    else
    {
      toolTipSTYLe.visibility = "visible";
      toolTipSTYLe.display = "none";
    }
    document.onmousemove = moveToMouseLoc;
  }
}
function toolTip(msg, fg, bg)
{
//Asigna el ToolTip un mensaje con un Foreground y un background especificado
  if(toolTip.arguments.length < 1) // hide
  {
    if(ns4) toolTipSTYLe.visibility = "hidden";
    else toolTipSTYLe.display = "none";
  }
  else // show
  {
    if(!fg) fg = "#777777";
    if(!bg) bg = "#FFFFFF";
    var content =
    '<table border="0" cellspacing="0" cellpadding="1" bgcolor="' + fg + '"><td>' +
    '<table border="0" cellspacing="0" cellpadding="1" bgcolor="' + bg + 
    '"><td align="center"><font face="sans-serif" color="' + fg +
    '" size="-2">&nbsp\;' + msg +
    '&nbsp\;</font></td></table></td></table>';
    if(ns4)
    {
      toolTipSTYLe.document.write(content);
      toolTipSTYLe.document.close();
      toolTipSTYLe.visibility = "visible";
    }
    if(ns6)
    {
      document.getelementByid("toolTipLayer").innerHTML = content;
      toolTipSTYLe.display='block'
    }
    if(ie4)
    {
      document.all("toolTipLayer").innerHTML=content;
      toolTipSTYLe.display='block'
    }
  }
}

function moveToMouseLoc(e)
{
  if(ns4||ns6)
  {
    x = e.pageX;
    y = e.pageY;
  }
  else
  {
    x = event.x + document.body.scrollLeft;
    y = event.y + document.body.scrollTop;
  }
  toolTipSTYLe.left = x + offsetX;
  toolTipSTYLe.top = y + offsetY;
  return true;
}

 
function Recursive_Binary_Search(term,values,low,hi)
{
if (low>=hi) { return -1; } //not found
mid=parseInt(low+hi/2);
if (values[mid]==term) { return mid; }
if (values[mid]<term)
  { return(Recursive_Binary_Search(term,values,mid+1,hi)); }
else
  { return(Recursive_Binary_Search(term,values,low,mid)); }
}

 
function Binary_Search(term, values, val_count)
{
low=0;
hi=val_count;
mid=parseInt(hi/2);
while (low<=hi-1)
  {
 if(values[mid]==term)
    {
    return mid;
    }
 if(values[mid]<term)
    {
    mid=parseInt((mid+hi+1)/2);
    }
 else
    {
    mid=parseInt((low+mid)/2);
    }
  }
return -1;  //not found
}

function Borrar()
{
	doc=document.forms[0];
	var form = document.forms[0]; 
	var cadena="";

	for (var i = 0; i < form.elements.length; i++) 
	{  
		if (form.elements[i].type == 'checkbox') 
		{      
			if (form.elements[i].name == 'Borrar') 
			{       
				if (form.elements[i].checked == true)
				{
					valor = form.elements[i].value;
					if(valor != "") 
						cadena = cadena +valor + ' ';        
				}
			}
		}
	}
	if (cadena == "") 
	alert("Debe seleccionar un Registro");
	else 
	{
		if (confirm("Está usted seguro de que desea borrar el/los Registro(s)?")) 
		{    
			 doc.accion.value="borrar";
			 doc.submit();
		} 
		else 
			alert("Su petici\xF3n de borrado ya fue cancelada");
	}
}

///////////FUNCIONES DE MENU
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

function MM_swapImgRestore()
{ //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}

function MM_preloadImages()
{ //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d)
{ //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage()
{ //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null)
 {
 document.MM_sr[j++]=x;
 if(!x.oSrc) 
  x.oSrc=x.src; 
 x.src=a[i+2];
 }
}

function salirSistema() 
{ 
	if ( confirm('¿Esta seguro que desea salir del sistema?') )
		{ 
			// window.top.close(); 
			var ruta=window.top.document.location.href;
			var liga=ruta.substring(0,ruta.indexOf(".nsf")+4)+"/ideUsuFW?OpenForm";
			window.top.document.location.replace(liga);
			location.reload([forceGet]);
		} 
} 
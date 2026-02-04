/*
 **************************************************************
 * Copyright (C) 2007 SHCP 
 * CGTIyC - alejandro_gavia@hacienda.gob.mx
 * 
 * $$Archivo: 	funcionesCGTIC-SIGA.js
 * $$Revisi\xF3n: 	DARG - Funciones para los JSP de Instrucciones.
 * $$Fecha: 	12 de Enero de 2007
 * 
 * Este software es informaci\xF3n propietaria y confidencial de la SHCP - CGTIyC. 
 ***************************************************************
 */

var tipoAcceso= 1;
var tiempoEstimado = 0;
var tipoTabla = 0;
var idArea=0;
var isEdited=false;

// Funci\xF3n para salir de la pagina principal. Regresa al asunto en cuesti\xF3n...
function salir(){
    //alert(globalURL);
    if (isEdited){
        if(!confirm("Ha editado las intrucciones de este asunto. ¿Esta seguro que desea salir sin guardar?")){
            return;
        }
    }
    window.location = globalURL;
}

// Funci\xF3n para insertar una instrucci\xF3n...
function insertRow(){
    if (document.getElementById("ua")){
        if (document.getElementById("ua").value!=idArea){
            alert("No puede agregar una instrucci\xF3n si no es de su Unidad Administrativa.");
            return;
        }
    }

//Acceso  
    var A ="0";
    if (document.getElementById("B").checked == true){
        A = "1";
    }
//Requerido  
    var R ="0";
/*  Este campo ya no es \xFAtil ...
    if (document.getElementById("R").checked == true){
        R = "1";
    }
*/
//Puesto
    var pto =document.getElementById("pto").value;
//Instrucci\xF3n  
    var instr =document.getElementById("instr").value;
    var otraInstr ="";
    if (instr == "[otra]")
        otraInstr = document.getElementById("otraInstr").value;
//T.A. 
    var ta =document.getElementById("ta").value;
//Tiempo Estimado     
    var tiemp = document.getElementById("tiemp").value;
// Id del Asunto
    var idAsunto = document.getElementById("idAsunto").value;
// Id de la instrucci\xF3n
    var idInstr = document.getElementById("idInstr").value;
    
    var uri = rutaBase + "/cgtic/tablaInstrucciones.jsp?idAsunto=" +  idAsunto + 
        "&idInstr=" + idInstr + "&action=insert";
    
    uri += "&A=" + A + "&R=" + R + "&pto=" + pto + "&instr=" + instr + "&otraInstr=" + 
        otraInstr + "&ta=" + ta + "&tiemp=" + tiemp + "&tipoTabla=" + tipoTabla;
    
    var msg="";
    
    if (pto=="null")
        msg+= "\n- Debe seleccionar un puesto.";
    
    if (instr=="null")
        msg+= "\n- Debe seleccionar o definir una instrucci\xF3n.";
    
    if (tiemp=="")
        msg+= "\n- Debe establecer un tiempo definido mayor o igual a cero.";
    
    if (IsNumeric(tiemp)==false)
        msg+= "\n- El tiempo definido debe ser num\xE9rico.";
    
    if (msg.length < 1){
        //alert (uri);
        var msgConf = "El tiempo sobrepasa el n\xFAmero de d\xEDas restantes para atender este asunto.";
        msgConf += "\n    Tiempo restante para atender instrucci\xF3n: \t"+ tiempoEstimado  + "\n    Tiempo estimado de atenci\xF3n: \t\t" + tiemp + "\n\n¿Desea agregar la instrucci\xF3n?";
        if (Number(tiemp)>tiempoEstimado){
            if (!confirm(msgConf)){
                document.getElementById("tiemp").focus();                
                return;
            }
        }
	var tableInstr = document.getElementById("tableInstr");
	tableInstr.src = uri;
	clearFields();
        isEdited=true;
	document.getElementById("btnGuarda").style.visibility = "visible";
        
    }else{
        msg = "Atienda los siguientes mensajes: \n" + msg;
        alert(msg);
    }
}

// Funci\xF3n para borrar una instrucci\xF3n...
function delRow(){
    if(document.getElementById("instStat").value=="1"){
        alert("No puede eliminar \xE9sta instrucci\xF3n.");
    }
    if (document.getElementById("indexRow").value==""){
        alert("Debe seleccionar una instrucci\xF3n existente.");
        return false;
    }
    var msgD="";
    //Extraemos el texto del "Responsable / Puesto"...
    var objSel = document.getElementById("pto"); 
    msgD += "\nResponsable / Puesto: \t" + objSel.options[objSel.selectedIndex].text ;
	//alert(msgD);
    objSel = document.getElementById("instr"); 
    msgD += "\nInstrucci\xF3n: \t\t";
    if (objSel.value=="[otra]"){
        msgD += document.getElementById("otraInstr").value;
    }else{
        msgD += objSel.options[objSel.selectedIndex].text ;
    }
    
    if (confirm("¿Esta seguro que desea eliminar la instrucci\xF3n?\n" + msgD ) ){
    // Id del Asunto
        var idAsunto = document.getElementById("idAsunto").value;
    // Id de la instrucci\xF3n
        var idInstr = document.getElementById("idInstr").value;
    
        var uri = rutaBase + "/cgtic/tablaInstrucciones.jsp?idAsunto=" +  
            idAsunto + "&idInstr=" + idInstr + "&action=delete&indexRow=" +
            document.getElementById("indexRow").value + "&tipoTabla=" + tipoTabla;
        //alert (uri);
        var tableInstr = document.getElementById("tableInstr");
        tableInstr.src = uri;
        clearFields();
        isEdited=true;
	document.getElementById("btnGuarda").style.visibility = "visible";
        
    }
}

// Funci\xF3n para actualizar instrucciones...
function updateInstr(){
//Acceso  
    var A ="0";
    if (document.getElementById("B").checked == true){
        A = "1";
    }
//Requerido  
    var R ="0";
//Puesto
    var pto =document.getElementById("pto").value;
//Instrucci\xF3n  
    var instr =document.getElementById("instr").value;
    var otraInstr ="";
    if (instr == "[otra]"){
        otraInstr = document.getElementById("otraInstr").value;
        if(otraInstr==""){
        	alert("Debe capturar el Nombre de la Instrucci\xF3n");
        	return false;
        }
    }
//T.A. 
    var ta =document.getElementById("ta").value;
//Tiempo Estimado     
    var tiemp = document.getElementById("tiemp").value;
// Id del Asunto
    var idAsunto = document.getElementById("idAsunto").value;
// Id de la instrucci\xF3n
    var idInstr = document.getElementById("idInstr").value;
// Estatus de la instrucci\xF3n
    var instStat = document.getElementById("instStat").value;
// Indice de la Instrucci\xF3n...
    var indexRow = document.getElementById("indexRow").value;
// Auto
	var auto = document.getElementById("auto").value;

// Se ensambla la URI para la tabla de instrucciones
    var uri = rutaBase + "/cgtic/tablaInstrucciones.jsp?idAsunto=" +  idAsunto + 
        "&idInstr=" + idInstr + "&action=update";
    
    uri += "&A=" + A + "&R=" + R + "&pto=" + pto + "&instr=" + instr + "&otraInstr=" + 
        otraInstr + "&ta=" + ta + "&tiemp=" + tiemp + "&indxRow=" + indexRow  + 
        "&instStat=" + instStat + "&tipoTabla=" + tipoTabla + "&auto="+auto;
    
    var msg="";
    
    if (pto=="null")
        msg+= "\n- Debe seleccionar un puesto.";
    
    if (instr=="null")
        msg+= "\n- Debe seleccionar o definir una instrucci\xF3n.";
    
    if (tiemp=="")
        msg+= "\n- Debe establecer un tiempo definido mayor o igual a cero.";
    
    if (IsNumeric(tiemp)==false)
        msg+= "\n- El tiempo definido debe ser num\xE9rico.";

    if (msg.length < 1){
    	if(instStat>0){
        	alert("No se puede Actualizar el registro ya que esta en tr\xE1mite");
        	return false;
        }else{
        	var msgConf = "El tiempo sobrepasa el n\xFAmero de d\xEDas restantes para atender este asunto.";
        	msgConf += "\n    Tiempo restante para atender instrucci\xF3n: \t"+ tiempoEstimado  + "\n    Tiempo estimado de atenci\xF3n: \t\t" + tiemp + "\n\n¿Desea agregar la instrucci\xF3n?";
        
        	if (Number(tiemp)>tiempoEstimado){
            	if (!confirm(msgConf)){
                	document.getElementById("tiemp").focus();                
                	return;
            	}
        	}	
        }
	var tableInstr = document.getElementById("tableInstr");
	tableInstr.src = uri;
	// Se deshabil\xEDta bot\xF3n para actualizar la instrucci\xF3n...
	document.getElementById("btnActInst").style.visibility = "hidden";
	clearFields();
        isEdited=true;
	document.getElementById("btnGuarda").style.visibility = "visible";

    }else{
        msg = "Atienda los siguientes mensajes: \n" + msg;
        alert(msg);
    }    

}

// Funci\xF3n para  Guardar las instrucciones creadas...
function SaveRows(){
    if (isEdited){
        if (confirm("\xBFEsta seguro que desea guardar las instrucciones?")){
        // Id del Asunto
            var idAsunto = document.getElementById("idAsunto").value;
        // Id de la instrucci\xF3n
            var idInstr = document.getElementById("idInstr").value;
        	var uri = rutaBase + "/cgtic/tablaInstrucciones.jsp?idAsunto=" +  
                idAsunto + "&idInstr=" + idInstr + "&action=saveAll" + "&tipoTabla=" + tipoTabla;
            var tableInstr = document.getElementById("tableInstr");
            tableInstr.src = uri;
            isEdited=false;
            clearFields();
        }else{
            document.getElementById("tiemp").focus();
        }
    }else{
        alert("A\xFAn no ha realizado ning\xFAn cambio.");
    }
}


function dataLineChanged(){
    //checkEnabled(0);
//dataLine
    var dataLine =document.getElementById("dataLine").value;
    var tempArray = new Array();
    tempArray = dataLine.split(',');
    //validar checkbox
    var check = tempArray[13];
    //checkbox activado
    if(check == 'true') {
    //indexRow    
        document.getElementById("indexRow").value = tempArray[0];
    //Acceso  
        if (tempArray[1]=="1")
            document.getElementById("B").checked = true;
        else if (tempArray[1]=="0")
            document.getElementById("B").checked = false;
            else
            	document.getElementById("B").checked = true;
        
    //Requerido  
        if (tempArray[2]=="1")
            document.getElementById("R").checked = true;
        else
            document.getElementById("R").checked = false;
        
    // UA
        if (tempArray[11] && tempArray[11] != "0" && tempArray[11] != ""){
            document.getElementById("ua").value=tempArray[11];
            //alert(tempArray[12]);
            changeUA(tempArray[12]);
            document.getElementById("varPtoInst").value = tempArray[3] + "," + tempArray[4] + "," + tempArray[5];
        }
    // Puesto ...(Se deja al final, para dar tiempo a la carga de UA's, en su caso)
        document.getElementById("pto").value = tempArray[3];
        changePuesto(tempArray[3]);
            
    //Instrucci\xF3n  
        document.getElementById("instr").value = tempArray[4];
        var otraInstr ="";
        if (tempArray[4]=="[otra]"){
            document.getElementById("otraInstr").value = tempArray[5];
            document.getElementById("otraInstr").style.visibility = "visible";
        }else{
            document.getElementById("otraInstr").value = "";
            document.getElementById("otraInstr").style.visibility = "hidden";
        }
    //T.A.
        document.getElementById("ta").value = tempArray[6];
    //Tiempo Estimado     
        document.getElementById("tiemp").value = tempArray[7];
    // Id del Asunto
        document.getElementById("idAsunto").value=tempArray[8];
    // Id de la instrucci\xF3n
        document.getElementById("idInstr").value=tempArray[9];
    // Id Status
        document.getElementById("instStat").value=tempArray[10];
    // Auto    
            document.getElementById("auto").value=tempArray[12];
    // Se habil\xEDta bot\xF3n para actualizar la instrucci\xF3n...
        document.getElementById("btnActInst").style.visibility = "visible";
        if(tempArray[10]!="0")
            document.getElementById("btnDel").style.visibility = "hidden";
        
        document.getElementById("btnInst").style.visibility = "hidden";
    // Verificar "Tipo de atenci\xF3n"(informativa) para el "Tiempo estimado"...
        if (tempArray[6]=="1"){
            if (tempArray[14]=="0"){
               document.getElementById("tiemp").value= "0";
               document.getElementById("tiemp").disabled= true;
            }else{
               document.getElementById("tiemp").value= "2";
               document.getElementById("tiemp").disabled= false;
            }
        }
        
        checkEnabled(tempArray[10]);
        document.getElementById("btnInst").style.visibility = "hidden";
        if (tempArray[10]=="4"||tempArray[10]=="2"){
            document.getElementById("btnActInst").style.visibility = "hidden";
            document.getElementById("tiemp").disabled= true;    
        }
        if(document.getElementById("ua")){
            if(document.getElementById("ua").value!=idArea){
                    //alert(tempArray[10]);
                checkEnabled(tempArray[10]);
                    document.getElementById("pto").disabled = true;    
                document.getElementById("btnDel").style.visibility = "hidden";
            }else if(tempArray[12]==1){
                    //checkEnabled(tempArray[10]);
                    document.getElementById("pto").disabled = true;    
                document.getElementById("btnDel").style.visibility = "visible";
            }
        }
    }
    //checkbox sin activar
    else {
        clearFields();
    }
    //alert(tempArray[10]);
/*
    if (tipoAcceso==0){
        if (tempArray[10]=="0"){
            document.getElementById("A").checked = false;
            document.getElementById("A").disabled = true;
        }
    }
*/
    

}

// Funci\xF3n para la selecci\xF3n de Otra Instrucci\xF3n...
function selInstr(){
    if (document.getElementById("instr").value== "[otra]"){
        document.getElementById("otraInstr").style.visibility = "visible";
        document.getElementById("otraInstr").focus();    
    }else{
        document.getElementById("otraInstr").style.visibility = "hidden";
    }
    document.getElementById("otraInstr").value = "";
}

/*
 Funci\xF3n para validar si una cadena de texto es num\xE9rica
 return boolean      
 */
function IsNumeric(sText)
{
   var ValidChars = "0123456789.";
   var IsNumber=true;
   var Char;
   for (i = 0; i < sText.length && IsNumber == true; i++) 
      { 
      Char = sText.charAt(i); 
      if (ValidChars.indexOf(Char) == -1) 
         {
         IsNumber = false;
         }
      }
   return IsNumber;
}

/*
 Funci\xF3n para validar si es num\xE9rico lo que se esta tecleando en un campo. 
 En caso de no ser num\xE9rico regresa false y no permite que se escriba el caracter
 return boolean      
 */
function soloNumeros(ev){
    var unicode=ev.charCode? ev.charCode : ev.keyCode
    if (unicode<48||unicode>57) //si no es un numero
        return false //deshabilita el keyPress
}
/*
 Funci\xF3n para validar si es num\xE9rico lo que se esta tecleando en un campo. 
 En caso de no ser num\xE9rico regresa false y no permite que se escriba el caracter
 return boolean      
 */
function soloAlfanumerico(ev){
    var isNot = false;
    var unicode=ev.charCode? ev.charCode : ev.keyCode;
    if (unicode==32)  //si es espacio 
        return  true; //habilita el keyPress
    if (unicode>47 && unicode<58)  //si es un numero
        return  true; 
    if (unicode>64 && unicode<91)  //si es mayuscula
        return  true; //habilita el keyPress
    if (unicode>96 && unicode<123)  //si es minuscula
        return  true; //habilita el keyPress
/*
    if (unicode>159 && unicode<166)  //si es acento o ©,
        isNot =  true; //habilita el keyPress
    Esta parte se reemplaza por:
*/
    if(
        (unicode>=16 && unicode<=18) || 
        (unicode>=33 && unicode<=41) || 
        unicode==45 || 
        unicode==9 ||
        unicode==20 || 
        unicode==91 || 
        unicode==93 || 
        unicode==27 ||  
        unicode==144 || 
        unicode==145 || 
        unicode==255 ||
        unicode==39 ||
        unicode==191 ||
        unicode==44 ||
        unicode==124 ||
        (unicode>=60 && unicode <=63) 
     )
        return false;
/*
    if (unicode==225 || // \xE1
        unicode==233 ||	// \xE9
        unicode==237 ||	// \xED
        unicode==243 ||	// \xF3
        unicode==250 ||	// \xFA
        unicode==241 ||	// ñ
        unicode==209 ||	// Ñ
//        unicode==44  ||	// ,
        unicode==46  ||	// .
        unicode==58  ||	// :
        unicode==191 ||	// ¿
        unicode==63  	// ?
        )
        return  true; //habilita el keyPress
*/
	//alert(unicode + "\n" + isNot);

//    return isNot;
}


/*
  Funcion para loimpiar los campos del formulario
*/
function clearFields(){

    document.getElementById("B").checked = true;
    document.getElementById("R").checked = false;
    document.getElementById("pto").value = "null";
    document.getElementById("instr").value = "null";
    document.getElementById("ta").value = "0";
    document.getElementById("tiemp").value = tiempoEstimado;
    document.getElementById("otraInstr").value = "";
    document.getElementById("otraInstr").style.visibility = "hidden";
    document.getElementById("indexRow").value = "";
    
    document.getElementById("btnSalir").style.cursor = "hand";
    document.getElementById("btnInst").style.cursor = "hand";
    document.getElementById("btnDel").style.visibility = "visible";
    document.getElementById("btnDel").style.cursor = "hand";
    document.getElementById("btnGuarda").style.cursor = "hand";

    document.getElementById("iFrmPtoDiv").style.visibility = "hidden";
    document.getElementById("iFrmPtoDiv").style.height = "0";
    document.getElementById("iFrmPto").style.visibility = "hidden";
    document.getElementById("iFrmPto").style.height = "0";
    
   // var tableInstr = window.frames['tableInstr'];
    for (i=0;i<24;i++){
        if (document.getElementById("rowLn"+i)){    
            if(document.getElementById("R" + i + "C7").value=="0"){
                styleTR="tableBody";
                }
            else{
                styleTR="tableBody2";    
            }
            if (document.getElementById("R" + i + "C1").value=="[otra]" &&
                document.getElementById("R" + i + "C1a").value==""){ 
                styleTR="tableBodyRed";    
                }
            document.getElementById("rowLn"+i).className = styleTR;
            //tableInstr.document.getElementById("rowLn"+i).className ="tableBody";
   	    document.getElementById("iRw"+i).checked = false;
        }
    }
    document.getElementById("btnActInst").style.visibility = "hidden";
    document.getElementById("btnDel").style.visibility = "visible";
/*
    if (isEdited){
	document.getElementById("btnGuarda").style.visibility = "visible";
    }else{
    	document.getElementById("btnGuarda").style.visibility = "hidden";
    }
*/
    checkEnabled("0");
      
    if (document.getElementById("ua")){
   
	var UAlabel = document.getElementById("uaLabel");
	UAlabel.innerText = UAlabel.textContent ="";	
        if (idArea!=""&&idArea!="0"){    
            var objSel = document.getElementById("ua");
            objSel.value=idArea;
	        UAlabel.innerText = UAlabel.textContent = objSel.options[objSel.selectedIndex].text;
	       changeUA(0);
    	} 
    }else{
    /*
        if (tipoAcceso==1){
            document.getElementById("A").disabled = false;
        }else{
            document.getElementById("A").checked = false;
            document.getElementById("A").disabled = true;
        }
        */
    }
}

/*
  Funci\xF3n para traer la informaci\xF3n de un puesto cuando es seleccionado
*/
function changePuesto(idPto){
    if (idPto==""||idPto=="null"){
        var iFrmPto = document.getElementById("iFrmPto");
        uri = "";
        iFrmPto.src = uri;
        document.getElementById("iFrmPtoDiv").style.visibility = "hidden";
        document.getElementById("iFrmPtoDiv").style.height = "0";
        document.getElementById("iFrmPto").style.visibility = "hidden";
        document.getElementById("iFrmPto").style.height = "0";
    }else{
        var iFrmPto = document.getElementById("iFrmPto");
        uri = rutaBase + "/cgtic/detallePuesto.jsp?puestoPar=" + idPto;
        iFrmPto.src = uri;
        document.getElementById("iFrmPtoDiv").style.visibility = "visible";
        document.getElementById("iFrmPtoDiv").style.height = "90";
        document.getElementById("iFrmPto").style.visibility = "visible";
        document.getElementById("iFrmPto").style.height = "90";
        document.getElementById("iFrmPto").style.width = "640";
    }
}

function modificaInstruccion(){
    objSel=document.getElementById("instr"); 
    if (objSel.selectedIndex==-1) return; 
    if (objSel.value=='null')return; 
    if (objSel.value=='[otra]')return; 

    document.getElementById("otraInstr").value = objSel.options[objSel.selectedIndex].text;
    document.getElementById("instr").value = "[otra]";
    document.getElementById("otraInstr").style.visibility = "visible";
    document.getElementById("otraInstr").focus();
}

// Revisar seg\xFAn el estatus de la instrucci\xF3n si los campos se habilitan o no...
function checkEnabled(idStat){
    //De cualquier forma el campo de Tiempo siempre esta habilitado...
   document.getElementById("tiemp").disabled= false;

   if (idStat=="0"){
        document.getElementById("B").disabled = false;
        document.getElementById("R").disabled = false;
        document.getElementById("pto").disabled = false;
        document.getElementById("instr").disabled = false;
        document.getElementById("otraInstr").disabled= false;
        document.getElementById("ta").disabled= false;
	if (document.getElementById("ua"))
	    document.getElementById("ua").disabled= false;

        document.getElementById("btnModIns").style.visibility = "visible";
        document.getElementById("btnInst").style.visibility = "visible";
        document.getElementById("btnDel").style.visibility = "visible";
        
        document.getElementById("pto").focus();    
    }else{
        document.getElementById("B").disabled = true;
        document.getElementById("R").disabled = true;
        document.getElementById("pto").disabled = true;
        document.getElementById("instr").disabled = true;
        document.getElementById("otraInstr").disabled= true;
        document.getElementById("ta").disabled= true;
	if (document.getElementById("ua"))
	    document.getElementById("ua").disabled= true;

        document.getElementById("btnModIns").style.visibility = "hidden";
        document.getElementById("btnInst").style.visibility = "hidden";
        document.getElementById("btnDel").style.visibility = "hidden";
        
        //Solo se deja libre el tiempo...
        document.getElementById("tiemp").focus();    
    }

    if (document.getElementById("ta").value=="1"){
        //document.getElementById("tiemp").value= "0";
        document.getElementById("tiemp").disabled= true;
    }


}

//Cuando cambie el valor de Tipo de Atenci\xF3n...
function changeTA(valTA){
    if (valTA=="1"){
        document.getElementById("tiemp").disabled=true;
        document.getElementById("tiemp").value="0";
    }else{
        document.getElementById("tiemp").value = tiempoEstimado;
        document.getElementById("tiemp").disabled= false;
    }
}

function changeTAEspecial(valTA){
   if (valTA=="1"){
        document.getElementById("tiemp").value = "2";//Parametrizar
        document.getElementById("tiemp").disabled= false;
  
    }else{
        document.getElementById("tiemp").value = tiempoEstimado;//Parametrizar
        document.getElementById("tiemp").disabled= false;
    }
}


// Cuando cambia la Unidad Administrativa...
function changeUA(bandera){

    document.getElementById("varPtoInst").value="";

    //Creamos objeto Select
    var ptoSel =document.getElementById("pto");

    // Limpiar el combo...
    ptoSel.options.length = 0;
    
    // Agregamos la opci\xF3n de [selecionar]...
    var opt= document.createElement('option');
    opt.value="null";
    opt.text='[Seleccionar]';
    try{ptoSel.add(opt,null);}catch(ex){ptoSel.add(opt);}
    //Establecemos esa opci\xF3n por default...
    ptoSel.value="null";
    changePuesto("null");

    if (document.getElementById("ua").value!="null"){
        //Creamos objeto Select de Instrucciones
        
        //var instrSel = document.getElementById("instr");
    
        // Limpiar el combo...
        //instrSel.options.length = 0;
        
        // Agregamos la opci\xF3n de [selecionar]...
        //var optIn= document.createElement('option');
        //optIn.value="null";
        //optIn.text='[Seleccionar]';

        //try{
          // instrSel.add(optIn,null);
          
           //}catch(ex){
             // instrSel.add(optIn);
           //}
        //Establecemos esa opci\xF3n por default...
        //instrSel.value="null";
    }

    // Llamamos a la carga de los puestos (AJAX "virtual")
    //alert(bandera);
    var iFrmAJAX = document.getElementById("iFrmSupport");
    uri = rutaBase + "/cgtic/getPuestosByUA.jsp?action=getPtoByUA&ua=" + 
        document.getElementById("ua").value + "&usr_ua=" + idArea+"&id_tur="+idUsr+"&ban="+bandera;
    iFrmAJAX.src = uri;

    //Establecemos el enfoque hacia el campo "Puestos"...
    ptoSel.focus();
    var objSel = document.getElementById("ua"); 
    var UAlabel = document.getElementById("uaLabel");
    UAlabel.innerText = UAlabel.textContent = objSel.options[objSel.selectedIndex].text;
}

function ptoInstChanged(){
//alert(document.getElementById("varPtoInst").value);

   if (document.getElementById("varPtoInst") && document.getElementById("varPtoInst").value!=""){
        var PtoInst =document.getElementById("varPtoInst").value;
        var tempArray = new Array();
        tempArray = PtoInst.split(',');
// Puesto ...
        document.getElementById("pto").value = tempArray[0];
        changePuesto(tempArray[0]);
        
//Instrucci\xF3n  
        document.getElementById("instr").value = tempArray[1];
        var otraInstr ="";
        if (tempArray[1]=="[otra]"){
            document.getElementById("otraInstr").value = tempArray[2];
            document.getElementById("otraInstr").style.visibility = "visible";
        }else{
            document.getElementById("otraInstr").value = "";
            document.getElementById("otraInstr").style.visibility = "hidden";
        }
        document.getElementById("instr").focus();	
    }
     
}

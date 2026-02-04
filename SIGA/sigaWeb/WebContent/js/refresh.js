function timeValueToday(){
    var date=new Date();
    var hora=date.getHours();
    var minuto=date.getMinutes();
    if(hora>=6&&minuto>=0&&){
        document.forms[0].elements[0].value='1';
        if(!confirm("El proceso esta fuera de horario, ¿Desea continuar?"))
            window.history.go(-1);
    }
    else{
        document.forms[0].elements[0].value='2';
    }
    return true;
}
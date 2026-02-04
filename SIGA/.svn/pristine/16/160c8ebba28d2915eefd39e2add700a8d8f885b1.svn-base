package gob.hacienda.cgtic.siga.util;

import java.util.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Comparator;

public class ComparatorIntruccionesResult implements Comparator {
    private int criterio;
    private int campo;

    public ComparatorIntruccionesResult(int criterio, int campo) {
        this.criterio = criterio;
        this.campo = campo;
    }

    public int compare(Object o1, Object o2) {
        String[] oS1 = (String[])o1;
        String[] oS2 = (String[])o2;
        int resultado = 0;
        //Verifica que tipo de campo es Texto/Fecha para realizar la comparacion apropiadamente
        if (campo == 2) {
            resultado = comparaFechas(oS1[campo], oS2[campo]);
        } else {
            resultado = oS1[campo].compareTo(oS2[campo]);
        }
        //Si los campos tienen el mismo valor se revisa por el criterio fijo: folio
        if (resultado == 0) {
            resultado = oS1[1].compareTo(oS2[1]);
        }
        if (criterio == 1) {
            return resultado;
        } else {
            return -resultado;
        }
    }

    private int comparaFechas(String fecha1, String fecha2) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date dfecha1 = null;
        Date dfecha2 = null;
        try {
            dfecha1 = formato.parse(fecha1);
            dfecha2 = formato.parse(fecha2);
        } catch (ParseException e) {
            dfecha1 = new Date();
            dfecha2 = dfecha1; 
        }
        return dfecha1.compareTo(dfecha2);
    }
}

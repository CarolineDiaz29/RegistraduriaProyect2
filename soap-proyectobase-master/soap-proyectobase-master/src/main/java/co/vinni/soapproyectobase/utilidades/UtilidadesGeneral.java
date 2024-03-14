package co.vinni.soapproyectobase.utilidades;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilidadesGeneral {
    public static Date convertirStringDate(String fecha){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date fechadate = simpleDateFormat.parse(fecha);
            return fechadate;
        } catch (ParseException e) {
        }
        return null;
    }
}

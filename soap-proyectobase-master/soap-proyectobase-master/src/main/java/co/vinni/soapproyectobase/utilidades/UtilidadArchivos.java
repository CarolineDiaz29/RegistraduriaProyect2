package co.vinni.soapproyectobase.utilidades;

import java.io.*;
import java.util.List;

public class UtilidadArchivos {

    public static boolean guardar(String archivo, Object objeto) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(objeto);
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public static Object obtener(String archivo) {
        Object objetoConsultado;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            objetoConsultado = ois.readObject();
            return objetoConsultado;
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }

    public static void modificar(String archivo, List objetoModificado) {
        guardar(archivo, objetoModificado);
    }
}

package co.vinni.soapproyectobase;

import co.vinni.soapproyectobase.controladores.ControladorCiudadano;
import co.vinni.soapproyectobase.controladores.ControladorPersona;
import co.vinni.soapproyectobase.controladores.ControladorRegistrador;
import co.vinni.soapproyectobase.controladores.ControladorNacimientos;
import co.vinni.soapproyectobase.dto.*;
import co.vinni.soapproyectobase.entidades.*;
import co.vinni.soapproyectobase.repositorios.RespositorioCiudadano;
import co.vinni.soapproyectobase.repositorios.RespositorioPersona;
import co.vinni.soapproyectobase.repositorios.RespositorioRegistrador;
import co.vinni.soapproyectobase.repositorios.RespositorionNacimientos;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@SpringBootApplication
@Log4j2
public class SoapProyectobaseApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(SoapProyectobaseApplication.class, args);
        System.out.println("proyecto base");

    }

    @Autowired
    RespositorioPersona repoPersona;
    RespositorioRegistrador repoRegis;
    RespositorionNacimientos RepoNaci;
    RespositorioCiudadano RepoCiu;

    @Override
    public void run(String... arg) throws Exception{
        Date date = new Date("29/02/2004");
        Persona p = new Persona( 1023861049,"RC", "Diaz", "Sarmiento", "Yipsi Caroline", date, "Bogota", "F", "O*");

        repoPersona.save(p);

        List<Persona> listPers = repoPersona.findAll();
        for(Persona persona: listPers){
            System.out.println(persona);
        }

        /*Date date2 = new Date("02/03/2004");
        Nacimientos n = new Nacimientos(1,date2,"Yipsi Diaz", "Bryan Montes");

        RepoNaci.save(n);

        List<Nacimientos> listNac = RepoNaci.findAll();
        for(Nacimientos nacimientos: listNac){
            System.out.println(nacimientos);
        }*/

        /*Ciudadano c = new Ciudadano("Yipsi Diaz", "Ingrid Sarmiento", "Fredy Diaz");

        RepoCiu.save(c);

        List<Ciudadano> listCiu = RepoCiu.findAll();
        for(Ciudadano ciudadano: listCiu){
            System.out.println(ciudadano);
        }*/


    }
        /*Scanner scanner = new Scanner(System.in);
        ControladorPersona controladorPersona = new ControladorPersona();
        ControladorCiudadano controladorCiudadano = new ControladorCiudadano();
        ControladorRegistrador controladorRegistrador = new ControladorRegistrador();
        ControladorNacimientos controladorNacimientos = new ControladorNacimientos();


        int opcion;
        do {
            System.out.println("------ Menú Principal ------");
            System.out.println("1. Registrar");
            System.out.println("2. Consultar");
            System.out.println("3. Modificaciones");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    registrarMenu(scanner, controladorCiudadano, controladorPersona, controladorRegistrador, controladorNacimientos);
                    break;
                case 2:
                    consultarMenu(scanner, controladorCiudadano, controladorRegistrador, controladorNacimientos, controladorPersona);
                    break;
                case 3:
                    modificarMenu(scanner, controladorCiudadano, controladorRegistrador, controladorNacimientos,controladorPersona);
                    break;
                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 0);
    }

    private static void registrarMenu(Scanner scanner, ControladorCiudadano controladorCiudadano, ControladorPersona controladorPersona,
                                      ControladorRegistrador controladorRegistrador, ControladorNacimientos controladorNacimientos) {
        int opcion;
        do {
            System.out.println("------ Menú de Registro ------");
            System.out.println("1. Registrar Ciudadano");
            System.out.println("2. Registrar Nacimiento");
            System.out.println("0. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("-----Ciudadano-----");
                    System.out.print("Tipo de Identidad: ");
                    String tipoIdentidadCiudadano = null;
                    boolean entradaValida = false;

                    while (!entradaValida) {
                        String opcionTipoIdentidad = scanner.next().toUpperCase();

                        switch (opcionTipoIdentidad) {
                            case "RC":
                                tipoIdentidadCiudadano = opcionTipoIdentidad;
                                entradaValida = true;
                                break;
                            default:
                                System.out.println("Opción no válida. Por favor, seleccione RC");
                                System.out.print("Tipo de Identidad: ");
                                break;
                        }
                    }
                    int documentoCiudadano;
                    while (true) {
                        System.out.print("Documento: ");
                        if (scanner.hasNextInt()) {
                            documentoCiudadano = scanner.nextInt();
                            break;
                        } else {
                            System.out.println("Por favor, ingrese solo números.");
                            scanner.next();
                        }
                    }
                    System.out.print("Primer Apellido: ");
                    String PriACiudadano = scanner.next();
                    System.out.print("Segundo Apellido: ");
                    String SegACiudadano = scanner.next();
                    System.out.print("Nombres: ");
                    scanner.nextLine();
                    String NomCiudadano = scanner.nextLine();
                    System.out.print("Fecha de Nacimiento (dd/MM/yyyy): ");
                    String fechNCiudadano = scanner.next();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Date fechaNCiu = null;
                    try {
                        fechaNCiu = sdf.parse(fechNCiudadano);
                    } catch (ParseException e) {
                        System.out.println("Error al parsear la fecha. Asegúrate de ingresarla en el formato correcto (dd/MM/yyyy).");
                        break;
                    }
                    System.out.print("Lugar de Nacimiento: ");
                    String LugNCiudadano = scanner.next();
                    System.out.print("Sexo: ");
                    String SexCiudadano = scanner.next();
                    System.out.print("Rh: ");
                    String RhCiudadano = scanner.next();
                    System.out.println("-----Datos de la Mamá-----");
                    System.out.print("Tipo de Identidad (RC/TI/CC): ");
                    String tipoIdentidadmama = null;
                    boolean entradaValida2 = false;

                    while (!entradaValida2) {
                        String opcionTipoIdentidad = scanner.next().toUpperCase();

                        switch (opcionTipoIdentidad) {
                            case "RC":
                                tipoIdentidadmama = opcionTipoIdentidad;
                                entradaValida2 = true;
                                break;
                            case "TI":
                                tipoIdentidadmama = opcionTipoIdentidad;
                                entradaValida2 = true;
                                break;
                            case "CC":
                                tipoIdentidadmama = opcionTipoIdentidad;
                                entradaValida2 = true;
                                break;
                            default:
                                System.out.println("Opción no válida. Por favor, seleccione RC, TI o CC");
                                System.out.print("Tipo de Identidad (RC/TI/CC): ");
                                break;
                        }
                    }
                    int documentoCMama;
                    while (true) {
                        System.out.print("Documento: ");
                        if (scanner.hasNextInt()) {
                            documentoCMama = scanner.nextInt();
                            break;
                        } else {
                            System.out.println("Por favor, ingrese solo números.");
                            scanner.next();
                        }
                    }
                    System.out.print("Primer Apellido: ");
                    String PriAMama = scanner.next();
                    System.out.print("Segundo Apellido: ");
                    String SegAMama = scanner.next();
                    System.out.print("Nombres: ");
                    scanner.nextLine();
                    String NomMama = scanner.nextLine();
                    System.out.print("Fecha de Nacimiento (dd/MM/yyyy): ");
                    String fechNmama;
                    SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
                    Date fechaNma = null;

                    while (true) {
                        try {
                            fechNmama = scanner.next();
                            fechaNma = sdf2.parse(fechNmama);
                            break;  // Break out of the loop if parsing is successful
                        } catch (ParseException e) {
                            System.out.println("Error al parsear la fecha. Asegúrate de ingresarla en el formato correcto (dd/MM/yyyy).");
                            System.out.print("Fecha de Nacimiento (dd/MM/yyyy): ");
                        }
                    }

                    System.out.print("Lugar de Nacimiento: ");
                    String LugNMama = scanner.next();
                    System.out.print("Sexo: ");
                    String SexMama = scanner.next();
                    System.out.print("Rh: ");
                    String RhMama = scanner.next();
                    System.out.println("-----Datos de la Papá");
                    System.out.print("Tipo de Identidad (RC/TI/CC): ");
                    String tipoIdentidadpapa = null;
                    boolean entradaValida3 = false;

                    while (!entradaValida3) {
                        String opcionTipoIdentidad = scanner.next().toUpperCase();

                        switch (opcionTipoIdentidad) {
                            case "RC":
                                tipoIdentidadpapa = opcionTipoIdentidad;
                                entradaValida3 = true;
                                break;
                            case "TI":
                                tipoIdentidadpapa = opcionTipoIdentidad;
                                entradaValida3 = true;
                                break;
                            case "CC":
                                tipoIdentidadpapa = opcionTipoIdentidad;
                                entradaValida3 = true;
                                break;
                            default:
                                System.out.println("Opción no válida. Por favor, seleccione RC, TI o CC");
                                System.out.print("Tipo de Identidad (RC/TI/CC): ");
                                break;
                        }
                    }
                    int documentoCPapa;
                    while (true) {
                        System.out.print("Documento: ");
                        if (scanner.hasNextInt()) {
                            documentoCPapa = scanner.nextInt();
                            break;
                        } else {
                            System.out.println("Por favor, ingrese solo números.");
                            scanner.next();
                        }
                    }
                    System.out.print("Primer Apellido: ");
                    String PriAPapa = scanner.next();
                    System.out.print("Segundo Apellido: ");
                    String SegAPapa = scanner.next();
                    System.out.print("Nombres: ");
                    scanner.nextLine();
                    String NomPapa = scanner.nextLine();
                    System.out.print("Fecha de Nacimiento (dd/MM/yyyy): ");
                    String fechNPapa;
                    SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy");
                    Date fechaNPa = null;

                    while (true) {
                        try {
                            fechNPapa = scanner.next();
                            fechaNPa = sdf3.parse(fechNPapa);
                            break;  // Break out of the loop if parsing is successful
                        } catch (ParseException e) {
                            System.out.println("Error al parsear la fecha. Asegúrate de ingresarla en el formato correcto (dd/MM/yyyy).");
                            System.out.print("Fecha de Nacimiento (dd/MM/yyyy): ");
                        }
                    }
                    System.out.print("Lugar de Nacimiento: ");
                    String LugNPapa = scanner.next();
                    System.out.print("Sexo: ");
                    String SexPapa = scanner.next();
                    System.out.print("Rh: ");
                    String RhPapa = scanner.next();
                    TipoIdentidadDto identidadCiu = new TipoIdentidadDto(tipoIdentidadCiudadano);
                    TipoIdentidadDto identidadMama = new TipoIdentidadDto(tipoIdentidadmama);
                    TipoIdentidadDto identidadPapa = new TipoIdentidadDto(tipoIdentidadpapa);
                    PersonaDto persona = new PersonaDto(identidadCiu, documentoCiudadano, PriACiudadano, SegACiudadano, NomCiudadano, fechaNCiu, LugNCiudadano, SexCiudadano, RhCiudadano);
                    PersonaDto Mama = new PersonaDto(identidadMama, documentoCMama, PriAMama, SegAMama, NomMama, fechaNma, LugNMama, SexMama, RhMama);
                    PersonaDto Papa = new PersonaDto(identidadPapa, documentoCPapa, PriAPapa, SegAPapa, NomPapa, fechaNPa, LugNPapa, SexPapa, RhPapa);
                    controladorPersona.registrarPersona(persona);
                    controladorPersona.registrarPersona(Mama);
                    controladorPersona.registrarPersona(Papa);
                    CiudadanoDto ciudadano = new CiudadanoDto(Papa,Mama,persona);
                    controladorCiudadano.registrarCiudadano(ciudadano);
                    break;
                case 2:
                    System.out.println("-----Nacimientos-----");
                    System.out.println("-----Datos Ciudadano-----");
                    int documentoNac;
                    PersonaDto personaCiudadano = null;

                    while (true) {
                        System.out.print("Documento: ");
                        if (scanner.hasNextInt()) {
                            documentoNac = scanner.nextInt();
                            personaCiudadano = controladorPersona.consultarPersona(documentoNac);
                            if (personaCiudadano != null) {
                                break;
                            } else {
                                System.out.println("No se encontró persona con el documento proporcionado.");
                            }
                        } else {
                            System.out.println("Por favor, ingrese solo números.");
                            scanner.next();
                        }
                    }
                    System.out.print("Fecha de Registro (dd/MM/yyyy): ");
                    String fechReg = scanner.next();
                    SimpleDateFormat sdfR = new SimpleDateFormat("dd/MM/yyyy");
                    Date fechare = null;
                    try {
                        fechare = sdfR.parse(fechReg);
                    } catch (ParseException e) {
                        System.out.println("Error al parsear la fecha. Asegúrate de ingresarla en el formato correcto (dd/MM/yyyy).");
                        System.out.print("Fecha de Registro (dd/MM/yyyy): ");
                        break;
                    }
                    System.out.println("-----Datos Registrador-----");
                    System.out.println("-----Registrador-----");
                    System.out.print("Tipo de Identidad (CC): ");
                    String tipoIdentidadReg = null;
                    boolean entradaValida4 = false;

                    while (!entradaValida4) {
                        String opcionTipoIdentidad = scanner.next().toUpperCase();

                        switch (opcionTipoIdentidad) {
                            case "CC":
                                tipoIdentidadReg = opcionTipoIdentidad;
                                entradaValida4 = true;
                                break;
                            default:
                                System.out.println("Opción no válida. Por favor, seleccione CC");
                                System.out.print("Tipo de Identidad (CC): ");
                                break;
                        }
                        int documentoRegi;
                        while (true) {
                            System.out.print("Documento: ");
                            if (scanner.hasNextInt()) {
                                documentoRegi = scanner.nextInt();
                                break;
                            } else {
                                System.out.println("Por favor, ingrese solo números.");
                                scanner.next();
                            }
                        }
                        System.out.print("Primer Apellido: ");
                        String PriARegi = scanner.next();
                        System.out.print("Segundo Apellido: ");
                        String SegARegi = scanner.next();
                        System.out.print("Nombres: ");
                        scanner.nextLine();
                        String NomRegi = scanner.nextLine();
                        System.out.print("Fecha de Nacimiento (dd/MM/yyyy): ");
                        String fechNRegiStr = scanner.next();
                        SimpleDateFormat sdf4 = new SimpleDateFormat("dd/MM/yyyy");
                        Date fechaNRegi = null;
                        try {
                            fechaNRegi = sdf4.parse(fechNRegiStr);
                        } catch (ParseException e) {
                            System.out.println("Error al parsear la fecha. Asegúrate de ingresarla en el formato correcto (dd/MM/yyyy).");
                            System.out.print("Fecha de Nacimiento (dd/MM/yyyy): ");
                            break;
                        }
                        System.out.print("Lugar de Nacimiento: ");
                        String LugNRegi = scanner.next();
                        System.out.print("Sexo: ");
                        String sexRegi = scanner.next();
                        System.out.print("Rh: ");
                        String RhRegi = scanner.next();
                        System.out.print("Sede: ");
                        scanner.nextLine();
                        String SedeRegi = scanner.nextLine();
                        TipoIdentidadDto identidad4 = new TipoIdentidadDto(tipoIdentidadReg);
                        PersonaDto persona4 = new PersonaDto(identidad4, documentoRegi, PriARegi, SegARegi, NomRegi, fechaNRegi, LugNRegi, sexRegi, RhRegi);
                        controladorPersona.registrarPersona(persona4);
                        RegistradorDto registrador = new RegistradorDto(persona4, SedeRegi);
                        controladorRegistrador.registrarRegistrador(registrador);
                        NacimientosDto nacimientos = new NacimientosDto(personaCiudadano, fechare, registrador);
                        controladorNacimientos.registrarNacimientos(nacimientos);
                        break;
                    }
                case 0:
                    System.out.println("Volviendo al Menú Principal");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
    } while (opcion != 0);
}

    private static void consultarMenu(Scanner scanner, ControladorCiudadano controladorCiudadano,
                                      ControladorRegistrador controladorRegistrador, ControladorNacimientos controladorNacimientos, ControladorPersona controladorPersona) {
        int opcion;
        do {
            System.out.println("------ Menú de Consultas ------");
            System.out.println("1. Consultar Ciudadanos");
            System.out.println("2. Consultar Registradores");
            System.out.println("3. Consultar Nacimientos");
            System.out.println("0. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    int opcion2;
                    do {
                        System.out.println("------ Menú de Consultas Ciudadanos ------");
                        System.out.println("1. Consultar Ciudadanos");
                        System.out.println("2. Consultar Ciudadano por Documento");
                        System.out.println("0. Volver al Menú Principal");
                        System.out.print("Seleccione una opción: ");
                        opcion2 = scanner.nextInt();

                        switch (opcion2) {
                            case 1:
                                System.out.println("-----Ciudadanos-----");
                                System.out.println("Consultar Ciudadanos");
                                List<CiudadanoDto> listaCiudadanos = controladorCiudadano.consultarCiudadanos();
                                if (!listaCiudadanos.isEmpty()) {
                                    for (CiudadanoDto ciu : listaCiudadanos) {
                                        System.out.println("Ciudadano:"+ ciu.getNacido());
                                        System.out.println("Madre: "+ ciu.getMama());
                                        System.out.println("Padre: "+ ciu.getPapa());
                                    }
                                } else {
                                    System.out.println("La lista de ciudadanos está vacía.");
                                }
                                break;
                            case 2:
                                int documentoCon;
                                PersonaDto personaConsultada = null;

                                while (true) {
                                    System.out.print("Documento: ");
                                    if (scanner.hasNextInt()) {
                                        documentoCon = scanner.nextInt();
                                        personaConsultada = controladorPersona.consultarPersona(documentoCon);
                                        break;
                                    } else {
                                        System.out.println("Por favor, ingrese solo números.");
                                        scanner.next();
                                    }
                                }

                                if (personaConsultada != null) {
                                    System.out.println("TipoIdentidad: " + personaConsultada.getTipoDocumento());
                                    System.out.println("Documento: "+ personaConsultada.getDocumento());
                                    System.out.println("Primer Apellido: "+ personaConsultada.getPrimerApellido());
                                    System.out.println("Segundo Apellido: "+ personaConsultada.getSegundoApellido());
                                    System.out.println("Nombres: "+ personaConsultada.getNombres());
                                    System.out.println("Fecha de Nacimiento:" + personaConsultada.getFechadeNacimiento());
                                    System.out.println("Lugar de Nacimiento: " + personaConsultada.getLugardeNacimiento());
                                    System.out.println("Sexo: "+ personaConsultada.getSexo());
                                    System.out.println("RH: " + personaConsultada.getRh());
                                } else {
                                    System.out.println("No se encontró persona con el documento proporcionado.");
                                }
                                break;
                            case 0:
                                System.out.println("Volviendo al Menú de Consultas");
                                break;
                            default:
                                System.out.println("Opción no válida. Intente nuevamente.");
                                break;
                        }
                    } while (opcion2 != 0);
                    break;
                case 2:
                                System.out.println("------Registradores------");
                                List<Registrador> listaRegistradores = controladorRegistrador.consultarRegistradores();
                                if (!listaRegistradores.isEmpty()) {
                                    for (Registrador regi : listaRegistradores) {
                                        System.out.println("Datos Registrador: " + regi.getRegistrador());
                                        System.out.println("Sede: " + regi.getSede());
                                    }
                                } else {
                                    System.out.println("La lista de Registradores está vacía.");
                                }
                case 3:
                    int opcion4;
                    do {
                        System.out.println("------ Menú de Consultas Nacimientos ------");
                        System.out.println("1. Consultar Nacimientos");
                        System.out.println("2. Consultar Nacimientos por Fecha");
                        System.out.println("0. Volver al Menú Principal");
                        System.out.print("Seleccione una opción: ");
                        opcion4 = scanner.nextInt();

                        switch (opcion4) {
                            case 1:
                                System.out.println("-----Nacimientos-----");
                                List<NacimientosDto> listaNacimientos = controladorNacimientos.consultarNacimientos();
                                if (!listaNacimientos.isEmpty()) {
                                    for (NacimientosDto naci : listaNacimientos) {
                                        System.out.println(naci);
                                    }
                                } else {
                                    System.out.println("La lista de Nacimientos está vacía.");
                                }

                                break;
                            case 2:
                                Date fechaNReC = null;

                                while (true) {
                                    System.out.print("Fecha de registro (dd/MM/yyyy): ");
                                    String fechNCon = scanner.next();
                                    SimpleDateFormat sdf5 = new SimpleDateFormat("dd/MM/yyyy");

                                    try {
                                        fechaNReC = sdf5.parse(fechNCon);
                                        break;
                                    } catch (ParseException e) {
                                        System.out.println("Error al parsear la fecha. Asegúrate de ingresarla en el formato correcto (dd/MM/yyyy).");
                                    }
                                }
                                List<NacimientosDto> nacimientosList = controladorNacimientos.consultarNacimientosporFecha(fechaNReC);
                                if (nacimientosList != null && !nacimientosList.isEmpty()) {
                                    for (NacimientosDto nacimientos : nacimientosList) {
                                        System.out.println("Ciudadano: " + nacimientos.getPersona());
                                        System.out.println("Fecha de Registro: " + nacimientos.getFecha());
                                        System.out.println("Registrador: " + nacimientos.getRegistrador());
                                    }
                                } else {
                                    System.out.println("La lista de Nacimientos está vacía o es null.");
                                }
                                break;
                            case 0:
                                System.out.println("Volviendo al Menú de Consultas");
                                break;
                            default:
                                System.out.println("Opción no válida. Intente nuevamente.");
                                break;
                        }
                    } while (opcion4 != 0);
                    break;
                case 0:
                    System.out.println("Volviendo al Menú Principal");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 0);
    }

    private static void modificarMenu(Scanner scanner, ControladorCiudadano controladorCiudadano,
                                      ControladorRegistrador controladorRegistrador, ControladorNacimientos controladorNacimientos, ControladorPersona controladorPersona) {
        int opcion;
        do {
            System.out.println("------ Menú de Modificaciones ------");
            System.out.println("1. Modificar Ciudadano");
            System.out.println("0. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    /*System.out.println("-----Modificar Ciudadano-----");
                    TipoIdentidad identidad1 = new TipoIdentidad("CC");
                    PersonaDto personaModificada = new PersonaDto(identidad1, 1000287921, "Diaz", "Sarmiento", "Yipsi Caroline", new Date(), "Bogota", "F", "O+");
                    boolean resultadoModificacion = controladorPersona.modificarPersona(1000287921, identidad1);
                    if (resultadoModificacion) {
                        System.out.println("Persona modificada correctamente.");
                    } else {
                        System.out.println("Error al intentar modificar la persona.");
                    }
                    break;
                case 0:
                    System.out.println("Volviendo al Menú Principal");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 0);*/



    }


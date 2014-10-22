import java.io.IOException;
import java.io.FileNotFoundException;


/** Esta clase se debera encargar de probar y validar el funcionamiento completo de las clases implementadas.
 * En este caso concreto debera trabajarse con un objeto de tipo ArchivoLH que maneje registros de tipo RegistroBiblioteca.
 * Deberan probarse TODOS y cada uno de los metodos implementados en la clase ArchivoLH en TODAS las posibles
 * condiciones de ejecucion de los mismos, con el fin de validar a traves de los volcados por pantalla que el
 * funcionamiento de la practica es totalmente correcto.
 */

public class PruebasBibliotecasLH {


    /**
     * Permite probar las clases ArchivoLH y RegistroBiblioteca implementadas por los alumnos.
     */

    public PruebasBibliotecasLH(){

        try{

            // 0) EJEMPLO DE CREACION DE UN ARCHIVO DE REGISTROS DE BIBLIOTECA NUEVO
            // Creamos un objeto del tipo de registro que manejara este archivo: RegistroBiblioteca.
            // Creamos un objeto ArchivoLH asociado a un fichero nuevo para registros de tipo RegistroBiblioteca
            // Volcamos el fichero por la consola para comprobar que la creacion del fichero se ha realizado
            // correctamente

            RegistroBiblioteca B = new RegistroBiblioteca();
            ArchivoLH archivoBiblioteca = new ArchivoLH(B, "biblioteca.dat");
            System.out.println("0) ********************* VOLCADO del contenido del archivo al crearlo ***********************************************");
            archivoBiblioteca.volcar();
            System.out.println("*********************************************************************************************************************");
            System.out.println();

            // 1) *************
            // EJEMPLO DE CREACION DE ARCHIVO.
            // El fichero de registros existe. Validar que su contenido es exactamente el mismo que la ultima vez que se trabajo con el.
            // Metemos algo en el archivo para comprobar que se borra al crearlo de nuevo.
            RegistroBiblioteca registroDummy = new RegistroBiblioteca(13, "Conde Duque", 28015, 300);
            registroDummy.setControl(RegistroLH.REGISTRO_OCUPADO);
            archivoBiblioteca.setRegistro(registroDummy);
            archivoBiblioteca.escribirRegistro();

            //Creamos el archivo.
            ArchivoLH archivoBibliotecaCreado = new ArchivoLH(B,"biblioteca.dat");

            System.out.println("1) ******************** VOLCADO del contenido al crearlo cuando ya este creado **************************************");
            archivoBibliotecaCreado.volcar();
            System.out.println("*********************************************************************************************************************");
            System.out.println();
            //*************


            // 2) *************
            // EJEMPLO DE APERTURA DE ARCHIVO.
            // El fichero de registros existe. Validar que su contenido es exactamente el mismo que la ultima vez que se trabajo con el.
            // Metemos algo en el archivo para comprobar que se borra al crearlo de nuevo.
            RegistroBiblioteca registroDummy1 = new RegistroBiblioteca(48, "Acuña", 28008, 500);
            registroDummy1.setControl(RegistroLH.REGISTRO_OCUPADO);
            archivoBibliotecaCreado.setRegistro(registroDummy);
            archivoBibliotecaCreado.escribirRegistro();

            // Abrimos el archivo.
            archivoBibliotecaCreado = new ArchivoLH(B,"biblioteca.dat", "r");

            System.out.println("2) ******************** VOLCADO del contenido al abrirlo cuando ya este creado **************************************");
            archivoBibliotecaCreado.volcar();
            System.out.println("*********************************************************************************************************************");
            System.out.println();
            //*************

            // 3) *************
            // EJEMPLO DE APERTURA DE ARCHIVO.
            // El fichero de registros NO existe. Debe saltar la excepcion FileNotFoundException que debera capturarse e indicar por la consola esta situacion mediante un mensaje de error

            // Abrimos el archivo.

            //****DESCOMENTAR LINEA PARA PROBAR!****
            // archivoBibliotecaCreado = new ArchivoLH(R,"bibliotecaNoExiste.dat", "r");

            System.out.println("3) ******************** VOLCADO del contenido del archivo al abrirlo cuando no existe *******************************");
            archivoBibliotecaCreado.volcar();
            System.out.println("*********************************************************************************************************************");
            System.out.println();
            //*************

            // 4) EJEMPLO DE INSERCION DE UN NUEVO REGISTRO
            RegistroBiblioteca registro1 = new RegistroBiblioteca(20, "Azcona", 28002, 200);
            registro1.setControl(RegistroLH.REGISTRO_OCUPADO);
            archivoBiblioteca.setRegistro(registro1);
            archivoBiblioteca.escribirRegistro();
            System.out.println("4) ******************** VOLCADO despues de aniadir el primer registro ***********************************************");
            archivoBiblioteca.volcar();
            System.out.println("*********************************************************************************************************************");
            System.out.println();


            // 5) EJEMPLO DE INSERCION DE DOS REGISTROS MAS
            RegistroBiblioteca registro2 = new RegistroBiblioteca(15, "Eugenio Trias", 28009, 250);
            registro2.setControl(RegistroLH.REGISTRO_OCUPADO);
            archivoBiblioteca.setRegistro(registro2);
            archivoBiblioteca.escribirRegistro();

            RegistroBiblioteca registro3 = new RegistroBiblioteca(16, "Buenavista", 28006, 360);
            registro3.setControl(RegistroLH.REGISTRO_OCUPADO);
            archivoBiblioteca.setRegistro(registro3);
            archivoBiblioteca.escribirRegistro();
            System.out.println("5) ******************** VOLCADO despues de aniadir tres registros ***************************************************");
            archivoBiblioteca.volcar();
            System.out.println("*********************************************************************************************************************");
            System.out.println();

            // 6) *************
            // EJEMPLO DE LECTURA DEL REGISTRO 0
            archivoBiblioteca.leerRegistro(0);
            RegistroBiblioteca registro0 = (RegistroBiblioteca)archivoBiblioteca.getRegistro();
            System.out.println("6) ******************** DATOS del registro que esta en la posicion 0 ************************************************");
            System.out.println(registro0.toString());
            System.out.println("*********************************************************************************************************************");
            System.out.println();
            //*************

            // 7) *************
            // EJEMPLO DE LECTURA DEL UN REGISTRO FUERA DE RANGO
            archivoBiblioteca.leerRegistro(100);
            RegistroBiblioteca registroMAX = (RegistroBiblioteca)archivoBiblioteca.getRegistro();
            System.out.println("7) ******************** DATOS del registro que esta en la posicion fuera del rango **********************************");
            System.out.println(registroMAX.toString());
            System.out.println("*********************************************************************************************************************");
            System.out.println();
            //*************


            // 8) EJEMPLO DE LECTURA DE UN REGISTRO QUE EXISTE
            archivoBiblioteca.leerRegistro(1);
            RegistroBiblioteca registro8 = (RegistroBiblioteca)archivoBiblioteca.getRegistro();
            System.out.println("8) ******************** DATOS del registro que esta en la POSICION 1 ************************************************");
            System.out.println(registro8.toString());
            System.out.println("*********************************************************************************************************************");
            System.out.println();


            //9) *************
            // EJEMPLO DE BORRADO DEL REGISTRO 0
            archivoBiblioteca.borrarRegistro(0);
            System.out.println("9) ******************** VOLCADO despues de borrar el registro de la POSICION 0 **************************************");
            archivoBiblioteca.volcar();
            System.out.println("*********************************************************************************************************************");
            System.out.println();
            //*************

            // 10) *************
            // EJEMPLO DE BORRADO DE UN REGISTRO FUERA DE RANGO.
            archivoBiblioteca.borrarRegistro(100);
            System.out.println("10) ******************** VOLCADO despues de borrar el registro de la POSICION 100 (FUERA DE RANGO) ******************");
            archivoBiblioteca.volcar();
            System.out.println("*********************************************************************************************************************");
            System.out.println();
            //*************

            // 11) *************
            // EJEMPLO DE BORRADO DE UN REGISTRO QUE SE ENCUENTRA EN LA LISTA DE HUECOS.
            // No hay nada en el registro 50. Es un hueco.
            archivoBiblioteca.borrarRegistro(50);
            System.out.println("11) *********** VOLCADO despues de borrar el registro de la POSICION 50 (DENTRO DE RANGO, lista de huecos) **********");
            archivoBiblioteca.volcar();
            System.out.println("*********************************************************************************************************************");
            System.out.println();
            //*************

            // 12) EJEMPLO DE BORRADO DE UN REGISTRO QUE EXISTE
            archivoBiblioteca.borrarRegistro(2);
            System.out.println("12) ******************** VOLCADO despues de borrar el registro de la POSICION 2 *************************************");
            archivoBiblioteca.volcar();
            System.out.println("*********************************************************************************************************************");
            System.out.println();

            archivoBiblioteca.borrarRegistro(3);
            System.out.println("13) ******************** VOLCADO despues de borrar el registro de la POSICION 3 *************************************");
            archivoBiblioteca.volcar();
            System.out.println("*********************************************************************************************************************");
            System.out.println();



            RegistroBiblioteca registroF = new RegistroBiblioteca(59, "Estoy en dos", 28009, 50);
            registroF.setControl(RegistroLH.REGISTRO_OCUPADO);
            archivoBiblioteca.setRegistro(registroF);
            archivoBiblioteca.escribirRegistro();



            System.out.println("14) ******************** VOLCADO despues de insertar el registro ***************************************************");
            archivoBiblioteca.volcar();
            System.out.println("*********************************************************************************************************************");
            System.out.println();



            // EJEMPLO DE CIERRE DEL ARCHIVO DE LIBROS
            archivoBiblioteca.cerrarArchivo();



            /**
             * Deberan probarse los siguientes metodos en las situaciones indicadas
             * 	- constructor de ArchivoLH que CREA el fichero. Situaciones:
             * 		- el fichero no existe. Validar que lo crea y que el archivo contiene el registro 0 completo (con todos los
             *        campos de un registro de tipo RegistroBiblioteca) y con el campo control a -1.
             *
             *        0) Funciona.
             *
             *      - el fichero existe. Validar que borra su contenido y que el archivo contiene el registro 0 completo (con todos los
             *        campos de un registro de tipo RegistroBiblioteca) y con el campo control a -1.
             *
             *        1) Funciona.
             *
             *  - constructor de ArchivoLH que ABRE el fichero. Situaciones:
             *  	- El fichero de registros existe. Validar que su contenido es exactamente el mismo que la ultima vez que
             *        se trabajo con el.
             *
             *        2) Funciona.
             *
             *      - El fichero de registros no existe. Debe saltar la excepcion FileNotFoundException que debera capturarse e
             *        indicar por la consola esta situacion mediante un mensaje de error
             *
             *        3) Funciona.
             *
             *  - escribirRegistro. Situaciones:
             *      - La lista de huecos esta vacia. Validar que el registro se ha incluido como ultimo registro del fichero y que
             *        el valor devuelto por el metodo es correcto
             *
             *        4) Funciona.
             *
             *      - La lista de huecos NO esta vacia. Validar que el registro se ha incluido en la posicion indicada por la
             *        cabecera de la lista de huecos y que esta se ha actualizado convenientemente. Ademas, debera comprobarse que
             *        el valor devuelto por el metodo es correcto.
             *
             *        5) Funciona.
             *
             *  - leerRegistro. Situaciones:
             *  	- leer el registro 0. Validar que los datos que devuelve son del ultimo registro del fichero.
             *
             *        6) Funciona.
             *
             *      - leer un registro que se encuentre en una posicion superior al numero de registros del fichero. Validar que
             *        los datos que devuelve son del ultimo registro del fichero.
             *
             *        7) Funciona.
             *
             *      - leer un registro que se encuentre en una posicion valida.  Validar que los datos que devuelve son los asociados
             *        al registro almacenado en la posicion indicada
             *
             *        8) Funciona.
             *
             *  - borrarRegistro. Situaciones:
             *      - borrar el registro 0. Validar que no tiene ningun efecto sobre el fichero.
             *
             *        9) Funciona.
             *
             *      - borrar un registro que se encuentre en una posicion superior al numero de registros del fichero.Validar que no
             *        tiene ningun efecto sobre el fichero.
             *
             *        10) Funciona.
             *
             *      - borrar un registro que se encuentre en la lista de huecos. Validar que no tiene ningun efecto sobre el fichero.
             *
             *        11) Funciona.
             *
             *      - borrar un registro que se encuentre en una posicion valida y que contenga informacion util (que no esta en la
             *        lista de huecos).
             *
             *        12) Funciona.
             *
             */

        }catch (IOException ioe){
            System.out.println("Error de entrada/salida sobre archivoBiblioteca: "+ ioe.getMessage());
        }

    }

    public static void main(String[] args) {
        new PruebasBibliotecasLH();
    }

}

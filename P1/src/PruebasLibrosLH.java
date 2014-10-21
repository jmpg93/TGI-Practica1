import java.io.IOException;
import java.io.FileNotFoundException;

 
/** Esta clase se debera encargar de probar y validar el funcionamiento completo de las clases implementadas.
  * En este caso concreto debera trabajarse con un objeto de tipo ArchivoLH que maneje registros de tipo RegistroLibro.
  * Deberan probarse TODOS y cada uno de los metodos implementados en la clase ArchivoLH en TODAS las posibles
  * condiciones de ejecucion de los mismos, con el fin de validar a traves de los volcados por pantalla que el
  * funcionamiento de la practica es totalmente correcto.
  */

   public class PruebasLibrosLH {


	 /**
	   * Permite probar las clases ArchivoLH y RegistroLibro implementadas por los alumnos.
	   */
	   public PruebasLibrosLH(){

		try{
			// 0) EJEMPLO DE CREACION DE UN ARCHIVO DE REGISTROS DE LIBROS NUEVO
			// Creamos un objeto del tipo de registro que manejara este archivo: RegistroLibro.
			// Creamos un objeto ArchivoLH asociado a un fichero nuevo para registros de tipo RegistroLibro
			// Volcamos el fichero por la consola para comproibar que la creacion del fichero se ha realizado
			// correctamente
			RegistroLibro R = new RegistroLibro();
			ArchivoLH archivoLibros= new ArchivoLH(R,"libros.dat");
		    System.out.println("0) ******************** VOLCADO del contenido del archivo al crearlo ************************************************");
		    archivoLibros.volcar();
		    System.out.println("*********************************************************************************************************************");
		    System.out.println();



            // 1) *************
            // EJEMPLO DE CREACION DE ARCHIVO.
            // El fichero de registros existe. Validar que su contenido es exactamente el mismo que la ultima vez que se trabajo con el.
            // Metemos algo en el archivo para comprobar que se borra al crearlo de nuevo.
            RegistroLibro registroDummy = new RegistroLibro(41, "Nivel 5", "novela policiaca", 300);
            registroDummy.setControl(RegistroLH.REGISTRO_OCUPADO);
            archivoLibros.setRegistro(registroDummy);
            archivoLibros.escribirRegistro();

            //Creamos el archivo.
            ArchivoLH archivoLibrosCreado = new ArchivoLH(R,"libros.dat");

            System.out.println("1) ******************** VOLCADO del contenido al crearlo cuando ya este creado **************************************");
            archivoLibrosCreado.volcar();
            System.out.println("*********************************************************************************************************************");
            System.out.println();
            //*************



            // 2) *************
            // EJEMPLO DE APERTURA DE ARCHIVO.
            // El fichero de registros existe. Validar que su contenido es exactamente el mismo que la ultima vez que se trabajo con el.
            // Metemos algo en el archivo para comprobar que se borra al crearlo de nuevo.
            RegistroLibro registroDummy1 = new RegistroLibro(48, "Nivel 5", "novela blanca", 600);
            registroDummy1.setControl(RegistroLH.REGISTRO_OCUPADO);
            archivoLibrosCreado.setRegistro(registroDummy);
            archivoLibrosCreado.escribirRegistro();

            // Abrimos el archivo.
            archivoLibrosCreado = new ArchivoLH(R,"libros.dat", "r");

            System.out.println("2) ******************** VOLCADO del contenido al abrirlo cuando ya este creado **************************************");
            archivoLibrosCreado.volcar();
            System.out.println("*********************************************************************************************************************");
            System.out.println();
            //*************


            // 3) *************
            // EJEMPLO DE APERTURA DE ARCHIVO.
            // El fichero de registros NO existe. Debe saltar la excepcion FileNotFoundException que debera capturarse e indicar por la consola esta situacion mediante un mensaje de error


            // Abrimos el archivo.

            //****DESCOMENTAR LINEA PARA PROBAR!****
            // archivoLibrosCreado = new ArchivoLH(R,"librosNoExiste.dat", "r");

            System.out.println("3) ******************** VOLCADO del contenido del archivo al abrirlo cuando no existe *******************************");
            archivoLibrosCreado.volcar();
            System.out.println("*********************************************************************************************************************");
            System.out.println();
            //*************


            // 4) EJEMPLO DE INSERCION DE UN NUEVO REGISTRO
		    // Creamos el objeto de tipo RegistroLibro con los datos a insertar, hacemos que la propiedad registro de
		    // ArchivoLH apunte a este registro y finalmente lo escribimos en el
		    // archivo. Volcamos el fichero por la consola para comprobar que la insercion
		    // del registro se ha realizado correctamente
		    RegistroLibro registro1 = new RegistroLibro(40, "El paraiso del idioma", "novela negra", 496);
            registro1.setControl(RegistroLH.REGISTRO_OCUPADO);
		    archivoLibros.setRegistro(registro1);
		    archivoLibros.escribirRegistro();		    
		    System.out.println("4) ******************** VOLCADO despues de aniadir el primer registro ***********************************************");
			archivoLibros.volcar();
		    System.out.println("*********************************************************************************************************************");
		    System.out.println();


            // 5) EJEMPLO DE INSERCION DE DOS REGISTROS MAS
		    RegistroLibro registro2 = new RegistroLibro(10, "Viaje en el tiempo 5", "infantil", 400);
            registro2.setControl(RegistroLH.REGISTRO_OCUPADO);
		    archivoLibros.setRegistro(registro2);
		    archivoLibros.escribirRegistro();		    
		    
		    RegistroLibro registro3 = new RegistroLibro(30, "El invierno del mundo", "novela historica", 960);
            registro3.setControl(RegistroLH.REGISTRO_OCUPADO);
		    archivoLibros.setRegistro(registro3);
		    archivoLibros.escribirRegistro();	
		    System.out.println("5) ******************** VOLCADO despues de aniadir tres registros ***************************************************");
			archivoLibros.volcar();
		    System.out.println("*********************************************************************************************************************");
		    System.out.println();

            // 6) *************
            // EJEMPLO DE LECTURA DEL REGISTRO 0
            archivoLibros.leerRegistro(0);
            RegistroLibro registro0 = (RegistroLibro)archivoLibros.getRegistro();
            System.out.println("6) ******************** DATOS del registro que esta en la posicion 0 ************************************************");
            System.out.println(registro0.toString());
            System.out.println("*********************************************************************************************************************");
            System.out.println();
            //*************

            // 7) *************
            // EJEMPLO DE LECTURA DEL UN REGISTRO FUERA DE RANGO
            archivoLibros.leerRegistro(100);
            RegistroLibro registroMAX = (RegistroLibro)archivoLibros.getRegistro();
            System.out.println("7) *********** DATOS del registro que esta en la posicion fuera del rango ******");
            System.out.println(registroMAX.toString());
            System.out.println("*********************************************************************************************************************");
            System.out.println();
            //*************


		    // 8) EJEMPLO DE LECTURA DE UN REGISTRO QUE EXISTE
		    archivoLibros.leerRegistro(1);
		    RegistroLibro registro8 = (RegistroLibro)archivoLibros.getRegistro();
		    System.out.println("8) ******************** DATOS del registro que esta en la POSICION 1 ************************************************");
			System.out.println(registro8.toString());
		    System.out.println("*********************************************************************************************************************");
		    System.out.println();


            //9) *************
            // EJEMPLO DE BORRADO DEL REGISTRO 0
            archivoLibros.borrarRegistro(0);
            System.out.println("9) ******************** VOLCADO despues de borrar el registro de la POSICION 0 **************************************");
            archivoLibros.volcar();
            System.out.println("*********************************************************************************************************************");
            System.out.println();
            //*************

            // 10) *************
            // EJEMPLO DE BORRADO DE UN REGISTRO FUERA DE RANGO.
            archivoLibros.borrarRegistro(100);
            System.out.println("10) ******************** VOLCADO despues de borrar el registro de la POSICION 100 (FUERA DE RANGO) ******************");
            archivoLibros.volcar();
            System.out.println("*********************************************************************************************************************");
            System.out.println();
            //*************

            // 11) *************
            // EJEMPLO DE BORRADO DE UN REGISTRO QUE SE ENCUENTRA EN LA LISTA DE HUECOS.
            // No hay nada en el registro 50. Es un hueco.
            archivoLibros.borrarRegistro(50);
            System.out.println("11) ******************** VOLCADO despues de borrar el registro de la POSICION 50 (DENTRO DE RANGO, lista de huecos)**");
            archivoLibros.volcar();
            System.out.println("*********************************************************************************************************************");
            System.out.println();
            //*************

		    // 12) EJEMPLO DE BORRADO DE UN REGISTRO QUE EXISTE
		    archivoLibros.borrarRegistro(2);
		    System.out.println("12) ******************** VOLCADO despues de borrar el registro de la POSICION 2 **************************************");
			archivoLibros.volcar();
		    System.out.println("*********************************************************************************************************************");
		    System.out.println();

		    
		    // EJEMPLO DE CIERRE DEL ARCHIVO DE LIBROS
		    archivoLibros.cerrarArchivo();

		    
		    /**
		     * Deberan probarse los siguientes metodos en las situaciones indicadas
		     * 	- constructor de ArchivoLH que CREA el fichero. Situaciones:
		     * 		- el fichero no existe. Validar que lo crea y que el archivo contiene el registro 0 completo (con todos los
		     *        campos de un registro de tipo RegistroLibro) y con el campo control a -1.
             *
             *         0) Mostrado en el ejemplo. Funciona.
             *
		     *      - el fichero existe. Validar que borra su contenido y que el archivo contiene el registro 0 completo (con todos los
		     *        campos de un registro de tipo RegistroLibro) y con el campo control a -1.
             *
             *         1) Si creamos el archivo cuando el primer registro se ha añadido, se comprueba al hacer el volcado del fichero que borra el contenido anterior del mismo.
             *
             *
             *
		     *  - constructor de ArchivoLH que ABRE el fichero. Situaciones:
		     *  	- El fichero de registros existe. Validar que su contenido es exactamente el mismo que la ultima vez que 
		     *        se trabajo con el.
             *
             *        2)Funciona
             *
		     *      - El fichero de registros no existe. Debe saltar la excepcion FileNotFoundException que debera capturarse e
		     *        indicar por la consola esta situacion mediante un mensaje de error
             *
             *        3) Funciona
             *
             *
             *
		     *  - escribirRegistro. Situaciones:
		     *      - La lista de huecos esta vacia. Validar que el registro se ha incluido como ultimo registro del fichero y que
		     *        el valor devuelto por el metodo es correcto
             *
             *        4) Funciona, desarrollado en el ejemplo.
             *
		     *      - La lista de huecos NO esta vacia. Validar que el registro se ha incluido en la posicion indicada por la
		     *        cabecera de la lista de huecos y que esta se ha actualizado convenientemente. Ademas, debera comprobarse que 
		     *        el valor devuelto por el metodo es correcto.
             *
             *        5) Funciona, se insertan dos registros nuevos.
             *
             *
             *
		     *  - leerRegistro. Situaciones:
		     *  	- leer el registro 0. Validar que los datos que devuelve son del ultimo registro del fichero.
             *
             *        6) Funciona, en este caso devuelve la novela historica.
             *
		     *      - leer un registro que se encuentre en una posicion superior al numero de registros del fichero. Validar que 
		     *        los datos que devuelve son del ultimo registro del fichero.
             *
             *        7) Funciona, de nuevo la novela historica.
             *
		     *      - leer un registro que se encuentre en una posicion valida.  Validar que los datos que devuelve son los asociados
		     *        al registro almacenado en la posicion indicada
             *
             *        8) Funciona, venia implementado.
             *
             *
             *
		     *  - borrarRegistro. Situaciones:
		     *      - borrar el registro 0. Validar que no tiene ningun efecto sobre el fichero.
             *
             *        9) Funciona.
             *
		     *      - borrar un registro que se encuentre en una posicion superior al numero de registros del fichero.Validar que no 
		     *        tiene ningun efecto sobre el fichero.
             *
             *        10) Funciona
             *
		     *      - borrar un registro que se encuentre en la lista de huecos. Validar que no tiene ningun efecto sobre el fichero.
             *
             *       11) Funciona.
             *
		     *      - borrar un registro que se encuentre en una posicion valida y que contenga informacion util (que no esta en la
		     *        lista de huecos).
             *
             *        12) Funciona.
		     *         
		     */


		    
		}catch (IOException ioe){
			System.out.println("Error de entrada/salida sobre archivoLibros: "+ioe.getMessage());
		}
		
	   }
	
	public static void main(String[] args) {
		new PruebasLibrosLH();
	}

}



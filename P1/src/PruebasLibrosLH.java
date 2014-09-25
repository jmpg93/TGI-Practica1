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
			// EJEMPLO DE CREACION DE UN ARCHIVO DE REGISTROS DE LIBROS NUEVO
			// Creamos un objeto del tipo de registro que manejara este archivo: RegistroLibro.
			// Creamos un objeto ArchivoLH asociado a un fichero nuevo para registros de tipo RegistroLibro
			// Volcamos el fichero por la consola para comproibar que la creacion del fichero se ha realizado
			// correctamente
			RegistroLibro R = new RegistroLibro();
			ArchivoLH archivoLibros= new ArchivoLH(R,"libros.dat");
		    System.out.println("********* volcado del contenido del archivo al crearlo **********************");
		    archivoLibros.volcar();
		    System.out.println("*****************************************************************************");
		    System.out.println();
		    
            // EJEMPLO DE INSERCION DE UN NUEVO REGISTRO
		    // Creamos el objeto de tipo RegistroLibro con los datos a insertar, hacemos que la propiedad registro de
		    // ArchivoLH apunte a este registro y finalmente lo escribimos en el
		    // archivo. Volcamos el fichero por la consola para comprobar que la insercion
		    // del registro se ha realizado correctamente
		    RegistroLibro registro1 = new RegistroLibro(40, "Nivel 5", "novela negra", 496);
            registro1.setControl(RegistroLH.REGISTRO_OCUPADO);
		    archivoLibros.setRegistro(registro1);
		    archivoLibros.escribirRegistro();		    
		    System.out.println("***********volcado despues de aniadir el primer registro********************");
			archivoLibros.volcar();
		    System.out.println("***************************************************************************");
		    System.out.println();
   
            // EJEMPLO DE INSERCION DE DOS REGISTROS MAS		    
		    RegistroLibro registro2 = new RegistroLibro(10, "Viaje en el tiempo 5", "infantil", 400);
            registro2.setControl(RegistroLH.REGISTRO_OCUPADO);
		    archivoLibros.setRegistro(registro2);
		    archivoLibros.escribirRegistro();		    
		    
		    RegistroLibro registro3 = new RegistroLibro(30, "El invierno del mundo", "novela historica", 960);
            registro3.setControl(RegistroLH.REGISTRO_OCUPADO);
		    archivoLibros.setRegistro(registro3);
		    archivoLibros.escribirRegistro();	
		    System.out.println("***********volcado despues de aniadir tres registros************************");
			archivoLibros.volcar();
		    System.out.println("***************************************************************************");
		    System.out.println();
		    
		    // EJEMPLO DE LECTURA DE UN REGISTRO QUE EXISTE
		    archivoLibros.leerRegistro(1);
		    RegistroLibro registro8 = (RegistroLibro)archivoLibros.getRegistro();
		    System.out.println("***********datos del registro que esta en la posicion 1 ********************");
			System.out.println(registro8.toString());
		    System.out.println("***************************************************************************");
		    System.out.println();
		      
		    // EJEMPLO DE BORRADO DE UN REGISTRO QUE EXISTE
		    archivoLibros.borrarRegistro(2);
		    System.out.println("***********volcado despues de borrar el registro de la posicion 2**********");
			archivoLibros.volcar();
		    System.out.println("***************************************************************************");
		    System.out.println();

		    
		    // EJEMPLO DE CIERRE DEL ARCHIVO DE LIBROS
		    archivoLibros.cerrarArchivo();

		    
		    /**
		     * Deberan probarse los siguientes metodos en las situaciones indicadas
		     * 	- constructor de ArchivoLH que CREA el fichero. Situaciones:
		     * 		- el fichero no existe. Validar que lo crea y que el archivo contiene el registro 0 completo (con todos los
		     *        campos de un registro de tipo RegistroLibro) y con el campo control a -1.
		     *      - el fichero existe. Validar que borra su contenido y que el archivo contiene el registro 0 completo (con todos los
		     *        campos de un registro de tipo RegistroLibro) y con el campo control a -1.
		     *  - constructor de ArchivoLH que ABRE el fichero. Situaciones:
		     *  	- El fichero de registros existe. Validar que su contenido es exactamente el mismo que la ultima vez que 
		     *        se trabajo con el.
		     *      - El fichero de registros no existe. Debe saltar la excepcion FileNotFoundException que debera capturarse e
		     *        indicar por la consola esta situacion mediante un mensaje de error
		     *  - escribirRegistro. Situaciones:
		     *      - La lista de huecos esta vacia. Validar que el registro se ha incluido como ultimo registro del fichero y que
		     *        el valor devuelto por el metodo es correcto
		     *      - La lista de huecos NO esta vacia. Validar que el registro se ha incluido en la posicion indicada por la
		     *        cabecera de la lista de huecos y que esta se ha actualizado convenientemente. Ademas, debera comprobarse que 
		     *        el valor devuelto por el metodo es correcto.
		     *  - leerRegistro. Situaciones:
		     *  	- leer el registro 0. Validar que los datos que devuelve son del ultimo registro del fichero.
		     *      - leer un registro que se encuentre en una posicion superior al numero de registros del fichero. Validar que 
		     *        los datos que devuelve son del ultimo registro del fichero.
		     *      - leer un registro que se encuentre en una posicion valida.  Validar que los datos que devuelve son los asociados
		     *        al registro almacenado en la posicion indicada
		     *  - borrarRegistro. Situaciones:
		     *      - borrar el registro 0. Validar que no tiene ningun efecto sobre el fichero.
		     *      - borrar un registro que se encuentre en una posicion superior al numero de registros del fichero.Validar que no 
		     *        tiene ningun efecto sobre el fichero.
		     *      - borrar un registro que se encuentre en la lista de huecos. Validar que no tiene ningun efecto sobre el fichero.
		     *      - borrar un registro que se encuentre en una posicion valida y que contenga informacion util (que no esta en la
		     *        lista de huecos).
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



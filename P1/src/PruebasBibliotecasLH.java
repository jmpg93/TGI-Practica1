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
           System.out.println("0) ********* VOLCADO del contenido del archivo al crearlo *********************");
           archivoBiblioteca.volcar();
           System.out.println("*******************************************************************************");
           System.out.println();

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
             *        1)
             *
		     *  - constructor de ArchivoLH que ABRE el fichero. Situaciones:
		     *  	- El fichero de registros existe. Validar que su contenido es exactamente el mismo que la ultima vez que
		     *        se trabajo con el.
             *
             *        2)
             *
		     *      - El fichero de registros no existe. Debe saltar la excepcion FileNotFoundException que debera capturarse e
		     *        indicar por la consola esta situacion mediante un mensaje de error
             *
             *        3)
             *
		     *  - escribirRegistro. Situaciones:
		     *      - La lista de huecos esta vacia. Validar que el registro se ha incluido como ultimo registro del fichero y que
		     *        el valor devuelto por el metodo es correcto
             *
             *        4)
             *
		     *      - La lista de huecos NO esta vacia. Validar que el registro se ha incluido en la posicion indicada por la
		     *        cabecera de la lista de huecos y que esta se ha actualizado convenientemente. Ademas, debera comprobarse que 
		     *        el valor devuelto por el metodo es correcto.
             *
             *        5)
             *
		     *  - leerRegistro. Situaciones:
		     *  	- leer el registro 0. Validar que los datos que devuelve son del ultimo registro del fichero.
             *
             *        6)
             *
		     *      - leer un registro que se encuentre en una posicion superior al numero de registros del fichero. Validar que 
		     *        los datos que devuelve son del ultimo registro del fichero.
             *
             *        7)
             *
		     *      - leer un registro que se encuentre en una posicion valida.  Validar que los datos que devuelve son los asociados
		     *        al registro almacenado en la posicion indicada
             *
             *        8)
             *
		     *  - borrarRegistro. Situaciones:
		     *      - borrar el registro 0. Validar que no tiene ningun efecto sobre el fichero.
             *
             *        9)
             *
		     *      - borrar un registro que se encuentre en una posicion superior al numero de registros del fichero.Validar que no 
		     *        tiene ningun efecto sobre el fichero.
             *
             *        10)
             *
		     *      - borrar un registro que se encuentre en la lista de huecos. Validar que no tiene ningun efecto sobre el fichero.
             *
             *        10)
             *
		     *      - borrar un registro que se encuentre en una posicion valida y que contenga informacion util (que no esta en la
		     *        lista de huecos).
             *
             *        11)
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

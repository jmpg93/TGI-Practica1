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
		    
		    /**
		     * Deberan probarse los siguientes metodos en las situaciones indicadas
		     * 	- constructor de ArchivoLH que CREA el fichero. Situaciones:
		     * 		- el fichero no existe. Validar que lo crea y que el archivo contiene el registro 0 completo (con todos los
		     *        campos de un registro de tipo RegistroBiblioteca) y con el campo control a -1.
		     *      - el fichero existe. Validar que borra su contenido y que el archivo contiene el registro 0 completo (con todos los
		     *        campos de un registro de tipo RegistroBiblioteca) y con el campo control a -1.
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
		    		
	   }
	
	public static void main(String[] args) {
		new PruebasBibliotecasLH();
	}

}

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Clase que representar un registro generico para archivos con gestion de lista de huecos. Esta sera la superclase de todas aquellas clases
 * que representen un tipo de registro para archivos con gestion de lista de huecos. 
 * Las clases que hereden de RegistroLH deberan reescribir los metodos leerRegistro y escribirRegistro para los campos concretos que incorporen
 * @version 1.0, (c)2013
 * @author TGI-BBDD
 */

  public class RegistroLH extends Registro{
	
	 /** 
	   * Valor utilizado para indicar que el campo control del registro es el fin de la lista de huecos.
	   */
	   public static final int FIN_LISTA = -1; 	// fin de la lista de huecos

	 /** 
	   * Valor utilizado para indicar que un registro tiene datos validos.
	   */
	   public static final int REGISTRO_OCUPADO = -2; 	// registro ocupado

	 /** 
	   * Tamaño del registro en bytes. Solo incluye la informacion que añade este registro.
	   */
	   private static final int TAMANIO_REGISTRO = (Integer.SIZE/8) ;

	 /** 
	   * Propiedad utilizada para indicar que el registro mantiene informacion util o para la gestion de la lista de huecos (de los registros borrados).
	   */
	   private int control;


	 /** 
	   * Inicializa un registro con valores predeterminados. Concretamente inicializa el campo de control a ocupado
	   * @see Registro
	   */
	   public RegistroLH(){
		   super();
		   this.setControl( RegistroLH.REGISTRO_OCUPADO );
	   }
	
	
	 /** 
	   * Inicializa un registro con los valores proporcionados.
	   * @param control Valor de la propiedad <code>control</code>.
	   * @see Registro
	   */
	   public RegistroLH(int control){
		   super();
		   this.setControl(control);
	   }
	
	
	 /** 
	   * Fija el valor de la propiedad <code>control</code> del registro.
	   * @param control Campo de control del registro.
	   */
	   public void setControl(int control){
		   this.control = control;	
	   }
	
	   
	 /** 
	   * Recupera el valor de la propiedad <code>control</code> del registro.
	   * @return control Campo de control del registro.
	   */
	   public int getControl(){	
		   return this.control;		
	   }

	   
	 /** 
	   * Devuelve la longitud completa (incluidos los campos que hereda) de este tipo de registro en bytes 
	   * @return int longitud del registro en bytes.
	   */	
	   public int longitudRegistro()
	   {
		   return RegistroLH.TAMANIO_REGISTRO + super.longitudRegistro();
	   }
	
	   
	 /** 
	   * Indica si el registro esta ocupado (utilizado).
	   * @return Valor logico que indica si el registro mantiene informacion util (true) o esta incluido en la lista de huecos (false).
	   */
	   public boolean estaOcupado(){
		   return (this.control==RegistroLH.REGISTRO_OCUPADO);
	   }
	
	   
     /** 
       * Escribe en el archivo que se pasa como parametro todos los campos del registro. 
       * @param archivo Archivo fisico sobre el que se escribir el contenido de este registro.
       * @throws IOException Si se produce un error al realizar la operacion.
       * @see Registro
       */
	   public void escribir(RandomAccessFile archivo) throws IOException {
		   archivo.writeInt( this.getControl() );
	   }
 	
	   
     /** 
       * Lee del archivo que se pasa como parametro el contenido con el que se modifican los campos de este registro 
       * @throws IOException Si se produce un error al realizar la operacion.
       * @see Registro
       */
	   public void leer(RandomAccessFile archivo) throws IOException {
		   this.setControl( archivo.readInt() );
	   }
 

	 /** 
	   * Convierte el contenido de los campos del registro en una cadena de caracteres.
	   * @return Cadena de texto con los contenidos del registro.
	   */
	   public String toString()
	   {
		   return "RegistroLH [control=" + this.getControl() + "]";
	   }
    
}

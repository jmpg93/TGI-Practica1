import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Clase que representa un registro para archivos con gestion de lista de huecos, que incorpora ademas el campo numReg (clave primaria) de tipo int. 
 * Las clases que hereden de RegistroNumReg deberan reescribir los metodos leerRegistro y escribirRegistro para los campos concretos que incorporen
 * @version 1.0, (c)2013
 * @author TGI-BBDD
 */

  public class RegistroNumReg extends RegistroLH{

	 /**
	   * Tamaño del registro en bytes. Solo incluye la informacion que añade este registro.
	   */
	   private static final int TAMANIO_REGISTRO = (Integer.SIZE/8) ;
	
	   
	 /** 
	   * Propiedad utilizada para mantener el valor del campo numReg.
	   */
	   private int numReg;


	 /** 
	   * Inicializa un registro con valores predeterminados. Concretamente inicializa el campo de control a ocupado y numReg a 0
	   */
	   public RegistroNumReg(){
		   super();
		   this.setNumReg( 0 );
	   }
	
	
	 /** 
	   * Inicializa un registro con los valores proporcionados.
	   * @param numReg Valor de la propiedad <code>numReg</code>.
	   * @see RegistroLH
	   */
	   public RegistroNumReg(int control, int numReg){
		   super(control);
		   this.setNumReg(numReg);
	   }
	
	
	 /** 
	   * Fija el valor de la propiedad <code>numReg</code> del registro.
	   * @param numReg valor a asignar a la propiedad numReg.
	   */
	   public void setNumReg(int numReg){
		   this.numReg = numReg;	
	   }
	   
	
	 /** 
	   * Recupera el valor de la propiedad <code>numReg</code> del registro.
	   * @return numReg valor de la propiedad numReg.
	   */
	   public int getNumReg(){	
		   return this.numReg;		
	   }
     
	   
     /** 
	   * Devuelve la longitud completa (incluidos los campos que hereda) de este tipo de registro en bytes 
       * @return int longitud del registro en bytes.
       */	
       public int longitudRegistro()
       {
    	   return RegistroNumReg.TAMANIO_REGISTRO + super.longitudRegistro();
       } 
       
	
     /** 
       * Escribe en el archivo que se pasa como parametro todos los campos del registro. 
       * @param archivo Archivo fisico sobre el que se escribir el contenido de este registro.
       * @throws IOException Si se produce un error al realizar la operacion.
       * @see RegistroLH

       */
       public void escribir(RandomAccessFile archivo) throws IOException {
    	   super.escribir(archivo);
    	   archivo.writeInt( this.getNumReg() );
       }
 
       
     /** 
       * Lee del archivo que se pasa como parametro el contenido con el que se modifican los campos de este registro 
       * @throws IOException Si se produce un error al realizar la operacion.
       * @see RegistroLH
       */
       public void leer(RandomAccessFile archivo) throws IOException {
    	   super.leer(archivo);
    	   this.setNumReg( archivo.readInt());
       }
 	  
       
	 /** 
	   * Convierte el contenido de los campos del registro en una cadena de caracteres.
	   * @return Cadena de texto con los contenidos del registro.
	   */
	   public String toString()
	   {
		   return "RegistroNumReg [control=" + super.getControl() + ", numReg = "+ this.getNumReg()+"]";
	   }
   
}

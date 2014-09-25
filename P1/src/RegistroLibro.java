import java.io.IOException;
import java.io.RandomAccessFile;

/** 
 * Clase que representa un registro de campos asociados a un libro.
 * @version 1.0, (c)2014
 * @author TGI-BBDD
 */

  public class RegistroLibro extends RegistroNumReg{


	 /** 
	   * Numero de caracteres del campo <code>titulo</code>.
	   */
	   public static final int TAMANIO_TITULO = 30;		

	 /** 
	   * Numero de caracteres del campo <code>tipo</code>.
	   */
	   public static final int TAMANIO_TIPO = 25; 
	    

	 
	 /** 
	   * Inicializa un registro con valores predeterminados. Campo control a ocupado, numero de registro el 0, titulo y tipo a cadena de caracteres vacia y numero de paginas a 0
	   */
	   public RegistroLibro() 
	   {
	   }

	 /** 
	   * Inicializa un registro con los valores proporcionados en los parametros del metodo. 
	   * Ademas, el campo de control debera aparecer como ocupado
	   * @param numReg Numero del registro.
	   * @param titulo Titulo del libro.
	   * @param tipo Tipo de libro (cientifico, literatura clasica, aventuras, infantil, de viaje, ...)
	   * @param numPaginas Numero de paginas del libro
	   */
	   public RegistroLibro( int numReg, String titulo, String tipo, int numPaginas )
	   {
	   }
	 

	 /** 
	   * Fija el valor de la propiedad <code>titulo</code>.
	   * @param titulo Titulo del libro.
	   */
	   public void setTitulo( String titulo )
	   {
	   }

	   
	 /** 
	   * Recupera el valor de la propiedad <code>titulo</code>.
	   * @return Titulo del libro.
	   */
	   public String getTitulo() 
	   { 
	   }

	   
	 /** 
	   * Fija el valor de la propiedad <code>tipo</code>.
       * @param tipo Tipo de libro.
       */
	   public void setTipo( String tipo )
	   {
	   }

	   
	 /** 
	   * Recupera el valor de la propiedad <code>tipo</code>.
	   * @return Tipo de libro
	   */
	   public String getTipo() 
	   {
	   }
	
	   
	 /** 
	   * Fija el valor de la propiedad <code>numPaginas</code>.
	   * @param numPaginas Numero de paginas del libro.
	   */
	   public void setNumPaginas( int numPaginas )
	   {
	   }

	   
	 /** 
	   * Recupera el valor de la propiedad <code>numPaginas</code>.
	   * @return Numero de paginas del libro
	   */
	   public int getNumPaginas() 
	   { 
	   }
	
     
	 /** 
	   * Devuelve la longitud completa (incluidos los campos que hereda) de este tipo de registro en bytes 
	   * @return int longitud del registro en bytes.
	   */	
	   public int longitudRegistro()
	   {
	   } 
	   
   
	 /** 
	   * Escribe en el archivo que se pasa como parametro todos los campos del registro.
	   * @param archivo Archivo fisico sobre el que se desea escribir el contenido de este registro 
	   * (el valor de todos sus campos, incluidos los que hereda).
	   * @throws IOException Si se produce un error de Entrada/Salida al realizar la operacion.
	   * @see RegistroNumReg
	   */
	   public void escribir(RandomAccessFile archivo) throws IOException {
	   }

	   
	 /** 
	   * Lee del archivo que se pasa como parametro el contenido con el que se modifican los campos de este registro 
	   * @throws IOException Si se produce un error de Entrada/Salido al realizar la operacion.
	   * @see RegistroNumReg
	   */
	   public void leer(RandomAccessFile archivo) throws IOException {		
	   }

	   
	 /** 
	   * Convierte el contenido de los campos del registro en una cadena de caracteres.
	   * @return Cadena de texto con los contenidos del registro. DEBER tener el siguiente formato: 
	   *       "RegistroLibro [control=valorControl, numReg=valorNumReg, titulo=valorTitulo, tipo=valorTipo, numero paginas=valorNumeroPaginas]"
	   */
	   public String toString()
	   {
	   }
	   
  }

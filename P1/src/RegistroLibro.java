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

    private String titulo;
    private String tipo;
    private int numPag;


	 
	 /** 
	   * Inicializa un registro con valores predeterminados. Campo control a ocupado, numero de registro el 0, titulo y tipo a cadena de caracteres vacia y numero de paginas a 0
	   */
	   public RegistroLibro() 
	   {
           super();
           setTitulo("");
           setTipo("");
           setNumPaginas(0);
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
           super(RegistroLH.REGISTRO_OCUPADO,numReg);
           this.setTitulo(titulo);
           this.setNumPaginas(numPaginas);
           this.setTipo(tipo);

	  }
	 

	 /** 
	   * Fija el valor de la propiedad <code>titulo</code>.
	   * @param titulo Titulo del libro.
	   */
	   public void setTitulo( String titulo )
	   {
           this.titulo = titulo;
	   }

	   
	 /** 
	   * Recupera el valor de la propiedad <code>titulo</code>.
	   * @return Titulo del libro.
	   */
	   public String getTitulo() 
	   {
        return titulo;
	   }

	   
	 /** 
	   * Fija el valor de la propiedad <code>tipo</code>.
       * @param tipo Tipo de libro.
       */
	   public void setTipo( String tipo )
	   {
        this.tipo = tipo;
	   }

	   
	 /** 
	   * Recupera el valor de la propiedad <code>tipo</code>.
	   * @return Tipo de libro
	   */
	   public String getTipo() 
	   {
           return  tipo;
	   }
	
	   
	 /** 
	   * Fija el valor de la propiedad <code>numPaginas</code>.
	   * @param numPaginas Numero de paginas del libro.
	   */
	   public void setNumPaginas( int numPaginas )
	   {
           numPag = numPaginas;
	   }

	   
	 /** 
	   * Recupera el valor de la propiedad <code>numPaginas</code>.
	   * @return Numero de paginas del libro
	   */
	   public int getNumPaginas() 
	   {
           return numPag;
	   }
	
     
	 /** 
	   * Devuelve la longitud completa (incluidos los campos que hereda) de este tipo de registro en bytes 
	   * @return int longitud del registro en bytes.
	   */	
	   public int longitudRegistro()
	   {
           return this.TAMANIO_TIPO + this.TAMANIO_TITULO + super.longitudRegistro();
	   } 
	   
   
	 /** 
	   * Escribe en el archivo que se pasa como parametro todos los campos del registro.
	   * @param archivo Archivo fisico sobre el que se desea escribir el contenido de este registro 
	   * (el valor de todos sus campos, incluidos los que hereda).
	   * @throws IOException Si se produce un error de Entrada/Salida al realizar la operacion.
	   * @see RegistroNumReg
	   */
	   public void escribir(RandomAccessFile archivo) throws IOException {
           super.escribir(archivo);
           archivo.writeInt( this.getNumPaginas() );
           archivo.writeUTF(this.getTipo());
           archivo.writeUTF(this.getTitulo());
   	   }

	   
	 /** 
	   * Lee del archivo que se pasa como parametro el contenido con el que se modifican los campos de este registro 
	   * @throws IOException Si se produce un error de Entrada/Salido al realizar la operacion.
	   * @see RegistroNumReg
	   */
	   public void leer(RandomAccessFile archivo) throws IOException {
           super.leer(archivo);
           this.setNumReg( archivo.readInt());
           this.setNumPaginas(archivo.readInt());
           this.setTipo(archivo.readUTF());
           this.setTitulo(archivo.readUTF());
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

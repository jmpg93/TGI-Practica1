import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Clase que representar un registro generico que no contiene ningun campo. Esta sera la superclase de todas aquellas clases
 * que representen un tipo de registro. 
 *  La clases que hereden de Registro deberan implementar los metodos leerRegistro y escribirRegistro para los campos concretos que incorporen
 * @version 1.0, (c)2013
 * @author TGI-BBDD
 */

   public abstract class Registro extends Object{

     /**
       * Tamaño en bytes del registro.
       */
       private static final int TAMANIO_REGISTRO = 0;
      
     /** 
       * Inicializa un registro con valores predeterminados.
       */
       public Registro() 
       {
       }
  
       
     /** 
       * Devuelve la longitud de este tipo de registros en bytes 
       * @return int longitud del registro en bytes.
       */	
       public int longitudRegistro()
       {
     	  return Registro.TAMANIO_REGISTRO;
       }  

       
     /** 
       * Escribe en el archivo que se pasa como parametro todos los campos del registro.
       * @param archivo Archivo fisico sobre el que se escribir el contenido de este registro.
       * @throws IOException Si se produce un error al realizar la operacion.
       */
       public abstract void escribir(RandomAccessFile archivo) throws IOException;
	

     /** 
       * Lee del archivo que se pasa como parametro el contenido con el que se modifica este registro 
       * @param archivo Archivo fisico sobre del que lee el contenido de este registro.
       * @throws IOException Si se produce un error al realizar la operacion.
       */
       public abstract void leer(RandomAccessFile archivo) throws IOException;
	
	
     /** 
       * Convierte el contenido de los campos del registro en una cadena de caracteres.
       * @return Cadena de texto con los contenidos del registro.
       */	
       public String toString()
       {
    	   return "Registro ";
       }
  
       
     /** 
       * Lee del archivo que se pasa como segundo parametro tantos carateres como los indicados 
       * por el parametro <code>longitud</code> a partir de la posicion apuntada por el puntero de lectura.
       * Este metodo podra/debera utilizarse desde cualquiera de las clases hijas que necesiten leer de un fichero 
       * un campo cuyo contenido sea una cadena de caracteres de una longitud concreta.
       * @param longitud Cantidad de caracteres a leer.
       * @param archivo Archivo fisico  del que lee los caracteres indicados
       * @return Cadena con los caracteres leidos.
       * @throws IOException Si se produce un error al realizar la operacion. 
       */
       protected String leerCadena( int longitud, RandomAccessFile archivo ) throws IOException
       {
    	   char cadena[] = new char[longitud];

    	   for ( int cuenta = 0; cuenta < cadena.length; cuenta++ ) {
    		   cadena[cuenta] = archivo.readChar();
           }     
    	   return new String( cadena ).replace( '\0', ' ' );
       }

       
     /** 
       * Escribe en el archivo que se pasa como tercer paametro la cadena indicada por el parametro <code>cadena</code> con 
       * tantos carateres como los indicados por el parametro <code>longitud</code>, a partir de la posicion apuntada por el 
       * puntero de escritura.
       * Este metodo podra/debera utilizarse desde cualquiera de las clases hijas que necesiten escribir en un fichero 
       * un campo cuyo contenido sea una cadena de caracteres de una longitud concreta. Si la cadena de caracteres pasada
       * como parametro tiene menos longitud que la indicada en el segundo parametro, el metodo se encarga de rellenar con
       * blancos el resto de caracteres. Si la cadena de caracteres pasada como parametro tiene una longitud mayor que la 
       * indicada como segundo parametro, el metodo se encarga de eliminar los caracteres finales que sobran.
       * @param cadena cadena a escribir.
       * @param longitud Cantidad de caracteres a escribir de la cadena.
       * @param archivo Archivo fisico  en el que escriben los caracteres indicados
       * @throws IOException Si se produce un error al realizar la operacion. 
       */
       protected void escribirCadena( String cadena, int longitud, RandomAccessFile archivo) throws IOException
       {
    	   StringBuffer bufer = null;

    	   if ( cadena != null ) 
    		   bufer = new StringBuffer( cadena );
    	   else 
    		   bufer = new StringBuffer( longitud );
    	   bufer.setLength( longitud );
    	   archivo.writeChars( bufer.toString() );
       }

} 
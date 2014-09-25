import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.io.File;

/**
 * Clase capaz de manipular un archivo de tipo <code>RandomAccessFile</code> 
 * compuesto por registros de tipo <code>Registro</code>. 
 * @version 1.0, (c)2013
 * @author TGI-BBDD
 */

  public class Archivo extends Object {

     /** 
       * Tipo de registros gestionados para este tipo de archivo.
       *  @see Registro
       */
	   protected Registro registro;

     /** 
       * Fichero de acceso aleatorio utilizado para contener los registros.
       * @see java.io.RandomAccessFile
       */
	   protected RandomAccessFile archivo = null;
 
	   
     /** 
       * Crea un objeto de tipo <code>Archivo</code> inicializando el tipo de registro que es
       * capaz de manejar con el registro que se indica como primer parametro. Ademas, inicializa 
       * la propiedad <code>archivo</code> asociandola al fichero en disco cuyo nombre
       * se pasa como segundo parametro (que debera existir) y dejando el fichero abierto 
       * en el modo indicado por el parametro <code>modo</code>
       * @param registro Objeto de tipo Registro que se desea que maneje en este archivo 
       * @param nombreArchivo Nombre del archivo a abrir (el fichero debe existir).
       * @param modo Modo de apertura del archivo.
       * @throws FileNotFoundException Si al intentar abrir el archivo este no existe, independientemente 
       *         de que se abra para solo lectura o lectura y escritura
       * @see Registro
       * @see java.io.RandomAccessFile
       */
	   public Archivo(Registro registro, String nombreArchivo, String modo) throws FileNotFoundException 
	   {
		   File archivoFisico = new File(nombreArchivo);

		   this.registro = registro;
		   if (!archivoFisico.exists()) throw (new FileNotFoundException("Error. El fichero indicado no existe"));
		   this.archivo = new RandomAccessFile( nombreArchivo, modo );
	   }
	   

     /** 
       * Crea un objeto de tipo <code>Archivo</code> inicializando el tipo de registro que es
       * capaz de manejar con el registro que se indica como primer parametro.  Ademas, inicializa 
       * la propiedad <code>archivo</code>  asociandola a un nuevo fichero vacio (lo crea) en disco
       * con el nombre indicado por el parametro <code>nombreArchivo</code> y deja abierto el fichero para
       * operaciones de lectura y/o escritura. Si el fichero existe, trunca su tamaño a cero.
       * @param registro Objeto de tipo Registro que se desea que maneje en este archivo 
       * @param nombreArchivo Nombre del archivo a crear (si el fichero existe trunca su tamaño a cero).
       * @throws FileNotFoundException Si no se tienen permisos sobre el fichero dado.
       * @see Registro
       * @see java.io.RandomAccessFile
       */
	   public Archivo(Registro registro, String nombreArchivo) throws FileNotFoundException 
	   {
		   File archivoFisico = new File(nombreArchivo);

		   this.setRegistro ( registro );
		   if(archivoFisico.exists()) archivoFisico.delete(); //si el fichero existe se trunca su tamanio a cero
		   this.archivo = new RandomAccessFile( nombreArchivo, "rw" );
	   }
	   

     /** 
       * Cierra el archivo actualmente en uso. Una vez ejecutado este metodo cualquier intento de acceso al fichero
       * asociado a este objeto (mediante los metodos escribirRegistro, leerRegistro, numRegistros o volcar) provocara
       * una excepcion de tipo IOException.
       * @throws IOException Si se produce un error al realizar la operacion. 
       */
	   public void cerrarArchivo() throws IOException {
		   this.archivo.close();
	   }
	   

     /** 
       * Recupera el valor de la propiedad <code>registro</code>.
       * @return Objeto registro asociado a este archivo.
       */
	   public Registro getRegistro() 
	   { 
		   return this.registro; 
	   }

	   
     /** 
       * Fija el valor de la propiedad <code>registro</code> asociado a este archivo.
       * @param registro Registro con los valores a modificar en la propiedad <code>registro</code>.
       */
	   public void setRegistro(Registro registro)
	   {
		   this.registro = registro;
	   }
	   
	   
     /** 
       * Escribe en el archivo actualmente en uso el contenido del registro mantenido en la propiedad <code>registro</code>, 
       * en la posicion indicada como parametro del metodo.
       * @param posicion Posicion que ocupa en el fichero el registro a escribir (el primer registro es el 0)
       * @throws IOException Si se produce un error al realizar la operacion.
       * @see Registro
       */
	   protected void escribirRegistro(int posicion) throws IOException {
		   this.archivo.seek(posicion * this.registro.longitudRegistro());
		   this.registro.escribir(this.archivo);
	   }


     /** 
       * Lee del archivo actualmente en uso el registro indicado por el parametro <code>posicion</code>.
       * Si el parametro <code>posicion</code> no es valido, se leera el ultimo registro del archivo. El
       * contenido leido se almacena en la propiedad <code>registro</code>.
       * @param posicion Numero de registro a leer (el primer registro es el 0).
       * @throws IOException si se produce un error al realizar la operacion 
       * @see Registro
       */
	   public void leerRegistro(int posicion) throws IOException {

		   if(posicion>this.numRegistros()){
			   this.archivo.seek(this.archivo.length()-this.registro.longitudRegistro());
		   } 
		   else {
			   this.archivo.seek(posicion*this.registro.longitudRegistro());
		   }
		   this.registro.leer(this.archivo);
	   }
	
	
     /** 
       * Devuelve el numero de registros del archivo actualmente en uso.
       * @return El numero de registros del archivo actualmente en uso.
       * @throws IOException Si se produce un error al realizar la operacion.
       */
	   public long numRegistros() throws IOException {
		   long num;
	       num = this.archivo.length()/this.registro.longitudRegistro();
	       return num;
	   }
	
	   
     /** 
       * Vuelca por la salida estandar el contenido del archivo actualmente en uso.
       * @throws IOException Si se produce un error al realizar la operacion. 
       */
	   public void volcar() throws IOException {
		   int pos=0;
		   this.archivo.seek(0);
		   while (this.archivo.getFilePointer() < this.archivo.length()) {
			   this.leerRegistro(pos);
			   System.out.println(this.registro.toString());
			   pos++;
		   }
	   }

}

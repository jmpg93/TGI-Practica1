import java.io.IOException; 
import java.io.RandomAccessFile;

/**
 Clase que representa un registro de campos asociados a una biblioteca.
 * @version 1.0, (c)2014
 * @author TGI-BBDD
 */

public class RegistroBiblioteca extends RegistroNumReg{

    /**
     * Numero de caracteres del campo <code>nombre</code>.
     */
    public static final int TAMANIO_NOMBRE = 25;
    public static final int TAMANIO_CAPACIDAD = (Integer.SIZE/8) ;

    private String nombre;
    private int cofigoPostal;
    private int capacidad;

    /**
     * Inicializa un registro con valores predeterminados. Campo control a ocupado, numero de registro el 0, nombre a cadena de caracteres vacia y codigo postal y capacidad a 0
     */
    public RegistroBiblioteca()
    {
        super(RegistroLH.REGISTRO_OCUPADO, 0);
        this.setNombre("");
        this.setCapacidad(0);
        this.setCodPostal(0);

    }

    /**
     * Inicializa un registro con los valores proporcionados en los parametros del metodo.
     * Ademas, el campo de control debera aparecer como ocupado
     * @param numReg Numero del registro.
     * @param nombre Nombre de la biblioteca.
     * @param codPostal Codigo postal de la biblioteca.
     * @param capacidad Capacidad de personas que admite la biblioteca.
     */
    public RegistroBiblioteca( int numReg, String nombre, int codPostal, int capacidad )
    {
        super(RegistroLH.REGISTRO_OCUPADO,numReg);
        this.setNombre(nombre);
        this.setCapacidad(capacidad);
        this.setCodPostal(codPostal);
    }


    /**
     * Fija el valor de la propiedad <code>nombre</code>.
     * @param nombre Nombre de la biblioteca.
     */
    public void setNombre( String nombre )
    {
        this.nombre = nombre;
    }


    /**
     * Recupera el valor de la propiedad <code>nombre</code>.
     * @return Nombre de la biblioteca.
     */
    public String getNombre()
    {
        return  this.nombre;
    }


    /**
     * Fija el valor de la propiedad <code>codPostal</code>.
     * @param codPostal Codigo postal de la biblioteca.
     */
    public void setCodPostal( int codPostal )
    {
        this.cofigoPostal = codPostal;
    }


    /**
     * Recupera el valor de la propiedad <code>codPostal</code>.
     * @return Codigo postal de la biblioteca.
     */
    public int getCodPostal()
    {
        return this.cofigoPostal;
    }


    /**
     * Fija el valor de la propiedad <code>capacidad</code>.
     * @param capacidad Capacidad de personas que admite la biblioteca.
     */
    public void setCapacidad( int capacidad )
    {
        this.capacidad = capacidad;
    }


    /**
     * Recupera el valor de la propiedad <code>capacidad</code>.
     * @return Capacidad de personas que admite la biblioteca
     */
    public int getCapacidad()
    {
        return this.capacidad;
    }


    /**
     * Devuelve la longitud completa (incluidos los campos que hereda) de este tipo de registro en bytes
     * @return int longitud del registro en bytes.
     */
    public int longitudRegistro()
    {
        //Dos veces la capacidad por que es el tamanño de un entero. En este caso hay dos, capacidad y codigo postal.
        return this.TAMANIO_NOMBRE*2 + this.TAMANIO_CAPACIDAD*2 + super.longitudRegistro();
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
        archivo.writeInt( this.getCapacidad() );
        this.escribirCadena(getNombre(), this.TAMANIO_NOMBRE, archivo);
        archivo.writeInt(this.getCodPostal());

    }


    /**
     * Lee del archivo que se pasa como parametro el contenido con el que se modifican los campos de este registro
     * @throws IOException Si se produce un error de Entrada/Salido al realizar la operacion.
     * @see RegistroNumReg
     */
    public void leer(RandomAccessFile archivo) throws IOException {
        super.leer(archivo);
        this.setCapacidad( archivo.readInt());
        this.setNombre(leerCadena(this.TAMANIO_NOMBRE, archivo));
        this.setCodPostal(archivo.readInt());
    }


    /**
     * Convierte el contenido de los campos del registro en una cadena de caracteres.
     * @return Cadena de texto con los contenidos del registro. DEBER tener el siguiente formato:
     *       "RegistroBiblioteca [control=valorControl, numReg=valorNumReg, nombre=valorNombre, codigo postal=valorCodPostal, capacidad=valorCapacidad]"
     */
    public String toString()
    {
        return "RegistroNumReg [control=" + super.getControl() + ", numReg = "+ this.getNumReg()+ ", nombre = " + this.getNombre() + ", capacidad = " + this.getCapacidad() + ", codigo postal = " + this.getCodPostal() + "]";
    }

}

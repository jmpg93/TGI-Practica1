import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Clase capaz de manipular un archivo de tipo <code>RandomAccessFile</code> 
 * compuesto por registros de tipo <code>RegistroLH</code>, con gestion de Lista de Huecos.
 * En esta version se emplea el primer registro COMPLETO del fichero (el 0) para mantener la cabecera de la lista de huecos. 
 * Este es un registro con uso especial, por lo que el primer registro de datos sera el 1.  
 * @version 1.0, (c)2014
 * @author TGI-BBDD
 */

public class ArchivoLH extends Archivo{

    /**
     * Crea un objeto de tipo <code>ArchivoLH</code> inicializando el tipo de registro que es
     * capaz de manejar con el registro que se indica como primer parametro, de tipo RegistroLH.
     * Ademas, inicializa la propiedad <code>archivo</code> asociandola al archivo cuyo nombre
     * se pasa como segundo parametro (que debera existir) y dejando el fichero abierto
     * en el modo indicado por el parametro <code>modo</code>. El fichero asociado al objeto ArchivoLH mantendra
     * la estructura de la lista de huecos mediante el campo de control del registro 0, que almacenara
     * la cabecera de la lista de huecos, y el campo control de los registros que se ha indicado que se borren.
     * @param registro Objeto de tipo RegistroLH que se desea manejar en este archivo
     * @param nombreArchivo Nombre del archivo a abrir (el fichero debe existir).
     * @param modo Modo de apertura del archivo.
     * @throws FileNotFoundException Si al intentar abrir el archivo, este no existe, independientemente de que
     *         se abra para solo lectura o lectura y escritura
     * @see RegistroLH
     * @see java.io.RandomAccessFile
     */
    public ArchivoLH (RegistroLH registro, String nombreArchivo, String modo)throws FileNotFoundException
    {
        super(registro, nombreArchivo, modo);

    }


    /**
     * Crea un objeto de tipo <code>ArchivoLH</code> inicializando el tipo de registro que es
     * capaz de manejar con el registro que se indica como primer parametro, de tipo RegistroLH.
     * Ademas, inicializa la propiedad <code>archivo</code> asociandola a un nuevo archivo vacio (lo crea)
     * con el nombre indicado por el parametro <code>nombreArchivo</code> y deja abierto el fichero para
     * operaciones de lectura y/o escritura. Si el fichero existe, trunca su tamanio a cero. El fichero asociado
     * al objeto ArchivoLH mantendra la estructura de la lista de huecos mediante el campo de control del registro 0,
     * que almacenara la cabecera de la lista de huecos, y el campo control de los registros que se ha indicado que
     * se borren. En este constructor debera crearse el registro 0 completo en el fichero, inicializando correctamente
     * la cabecera de la lista de huecos.
     * @param registro Objeto de tipo RegistroLH que se desea que maneje en este archivo
     * @param nombreArchivo Nombre del archivo a crear (si el fichero existe trunca su tamanio a cero).
     * @throws FileNotFoundException Si no se tienen permisos sobre el fichero dado.
     * @see RegistroLH
     * @see java.io.RandomAccessFile
     */
    public ArchivoLH (RegistroLH registro, String nombreArchivo)throws FileNotFoundException
    {
        super(registro, nombreArchivo);

        registro.setControl(RegistroLH.FIN_LISTA);
        try {
            super.escribirRegistro(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Lee del archivo actualmente en uso el registro indicado por el parametro <code>posicion</code>.
     * Si el parametro <code>posicion</code> no es valido (es menor que 1 o mayor que el numero de registros)
     * se leera el contenido del ultimo registro del fichero. El contenido leido se almacena en la propiedad
     * <code>registro</code>.
     * @param posicion Numero de registro a leer.
     * @throws IOException si se produce un error al realizar la operacion
     * @see RegistroLH
     */
    public void leerRegistro(int posicion) throws IOException {
        //Leemos el contenido del ultimo registro
        if(posicion>this.numRegistros() || posicion < 1){
            this.archivo.seek(this.archivo.length()-this.registro.longitudRegistro());
        }
        else {
            this.archivo.seek(posicion*this.registro.longitudRegistro());
        }
        this.registro.leer(this.archivo);
    }


    /**
     * Lee del archivo  actualmente en uso el registro indicado por el parametro <code>posicion</code>.
     * Si el parametro <code>posicion</code> no es valido se leera el ultimo registro del archivo. Este metodo
     * servira para leer registros del archivo en uso sobre una variable RegistroLH auxiliar en vez de sobre
     * la propiedad <code>registro</code> del objeto ArchivoLH.
     * @param posicion Numero de registro a leer.
     * @return devuelve el registro leido
     * @throws IOException si se produce un error al realizar la operacion
     * @see RegistroLH
     */
    protected RegistroLH leerRegistroLH(int posicion) throws IOException {
        RegistroLH registro = new RegistroLH();
        //Si estamos fuera de rango leemos el ultimo
        if((posicion>this.numRegistros())||(posicion<1)){
            posicion = (int)this.numRegistros();
        }
        super.archivo.seek(posicion*super.registro.longitudRegistro());
        registro.leer(super.archivo);
        return registro;
    }


    /**
     * Escribe en el archivo actualmente en uso el contenido del registro mantenido en la propiedad
     * <code>registro</code>. Si la lista de huecos esta vacia, el registro
     * se aniadira al final del fichero. En caso contrario, se escribira en el registro del fichero
     * que indique la cabecera de la lista de huecos y se actualiza esta convenientemente. Todas
     * las modificaciones deben quedar reflejadas en el archivo en disco.
     * @return El numero de registro de disco en el que se escribe el registro
     * @throws IOException Si se produce un error al realizar la operacion.
     * @see RegistroLH
     */
    public int escribirRegistro() throws IOException {
        //Siempre hay que reposicionar a 0
        archivo.seek(0);
        int control = archivo.readInt();


        //Si el control es fin de lista, escribimos al final
        if (control == RegistroLH.FIN_LISTA) {
            control = (int) (this.numRegistros() + 1);
        }
        //Si el control no es fin de lista buscamos el siguiente elemento en la lista de huecos. Ponemos el control de este en la cima de la lista.
        //3->2->-1 => 2->-1
        else {

            int anterior;
            this.archivo.seek(control * this.registro.longitudRegistro());
            anterior = this.archivo.readInt();

            this.archivo.seek(control * this.registro.longitudRegistro());
            this.archivo.writeInt(RegistroLH.REGISTRO_OCUPADO);

            this.archivo.seek(0);
            this.archivo.writeInt(anterior);

        }
        this.archivo.seek(control * this.registro.longitudRegistro());
        registro.escribir(this.archivo);

        return control;

    }


    /**
     * Escribe en el archivo actualmente en uso el contenido del registro de tipo registroLH asociado
     * al parametro <code>registroLH</code> en la posicion apuntada por el puntero de escritura.
     * @param registroLH RegistroLH a escribir.
     * @throws IOException Si se produce un error al realizar la operacion.
     * @see RegistroLH
     */
    protected void escribirRegistroLH(RegistroLH registroLH) throws IOException {
        registroLH.escribir(super.archivo);
    }


    /**
     * Aniade a la lista de huecos del archivo actualmente en uso el registro que ocupa la posicion indicada
     * por el parametro <code>posicion</code>.
     * Si el parametro <code>posicion</code> no es valido (registro fuera de rango -menor que 1 o mayor que
     * el numero de registros del fichero- o registro no ocupado), no se se realizara ningun borrado .
     * @param posicion numero que indica la posicion del registro a borrar.
     */
    public void borrarRegistro(int posicion) throws IOException {
        //Tenemos que estar dentro del rango
        if((posicion < 1 || posicion > this.numRegistros()))
        {
            System.out.println("La posicion que busca del registro no existe en el archivo");
        }
        else if (posicion <= this.numRegistros()) //No hacemos nada si la posicion es mayor que los registros que hay
        {
            this.archivo.seek(posicion*this.registro.longitudRegistro());
            int controlB = this.archivo.readInt();

            if(controlB == RegistroLH.REGISTRO_OCUPADO)
            {
                this.archivo.seek(0);
                int control = archivo.readInt();
                //Sustitumos la cima de la lista en la posicion del registro que queremos borrar
                this.archivo.seek(posicion * this.registro.longitudRegistro());
                this.archivo.writeInt( control );
                //Escribimos en la cima de la lista la posicion que hemos borrado y que ahora apunta a la antigua posicion que tenia la cima
                this.archivo.seek(0);
                this.archivo.writeInt( posicion);

            }
        }
    }


    /**
     * Devuelve el numero de registros total que actualmente hay en el fichero (contabiliza tanto los que mantienen informacion
     * util como los incluidos en la lista de huecos). No debe contabilizar el registro 0.
     * @return El numero de registros del archivo.
     * @throws IOException Si se produce un error al realizar la operacion.
     */
    public long numRegistros() throws IOException {
        //El registro 0 no cuenta.
        return super.numRegistros() - 1;
    }


    /**
     * Vuelca por la salida estandar el contenido del archivo actualmente en uso.
     * @throws IOException Si se produce un error al realizar la operacion.
     */
    public void volcar() throws IOException {
        int cabeceraLH;
        super.archivo.seek(0);
        cabeceraLH = super.archivo.readInt();
        System.out.println("Cabecera de la lista de huecos: "+ cabeceraLH + ". Registros en uso(ocupados+libres): "+ this.numRegistros());
        for (int pos=1; pos<=this.numRegistros(); pos++) {
            this.leerRegistro(pos);
            System.out.println("Registro "+ pos + ";   " + super.registro.toString());
        }
        System.out.println("************************************************* FIN DEL VOLCADO ***************************************************");
    }
}

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package aa4_woodshops;
/**
 * Clase que representa a un proveedor.
 */
public class Proveedor {
    private String nif;
    private String nombre;

    /**
     * Constructor de la clase Proveedor.
     *
     * @param nif    el NIF del proveedor
     * @param nombre el nombre del proveedor
     */
    public Proveedor(String nif, String nombre) {
        this.nif = nif;
        this.nombre = nombre;
    }

    /**
     * Obtiene el NIF del proveedor.
     *
     * @return el NIF del proveedor
     */
    public String getNif() {
        return this.nif;
    }

    /**
     * Establece el NIF del proveedor.
     *
     * @param nif el NIF del proveedor
     */
    public void setNif(String nif) {
        this.nif = nif;
    }

    /**
     * Obtiene el nombre del proveedor.
     *
     * @return el nombre del proveedor
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Establece el nombre del proveedor.
     *
     * @param nombre el nombre del proveedor
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve una representación en forma de cadena del objeto Proveedor.
     *
     * @return una cadena que representa el objeto Proveedor
     */
    public String toString() {
        return "Proveedor{nif=" + this.nif + ", nombre=" + this.nombre + "}";
    }
}
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package aa4_woodshops;
/**
 * Creamos la clase Clientes
 */
public abstract class Clientes {
    String nombre;
    String nif;

    /**
     * Constructor de la clase Clientes.
     *
     * @param nombre El nombre del cliente.
     * @param nif    El NIF del cliente.
     */
    public Clientes(String nombre, String nif) {
        this.nombre = nombre;
        this.nif = nif;
    }

    /**
     * Obtiene el nombre del cliente.
     *
     * @return El nombre del cliente.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Establece el nombre del cliente.
     *
     * @param nombre El nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el NIF del cliente.
     *
     * @return El NIF del cliente.
     */
    public String getNif() {
        return this.nif;
    }

    /**
     * Establece el NIF del cliente.
     *
     * @param nif El NIF del cliente.
     */
    public void setNif(String nif) {
        this.nif = nif;
    }

    public String toString() {
        return "Clientes{nombre='" + this.nombre + "', nif='" + this.nif + "'}";
    }
}
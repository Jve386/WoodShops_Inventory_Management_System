//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package aa4_woodshops;
/**
 * Clase WoodFriend que extiende de la clase Clientes y representa a los clientes del tipo "WoodFriend"
 * que tienen un descuento especial.
 */
public class WoodFriend extends Clientes {
    String CodigoSocio;

    /**
     * Constructor de la clase WoodFriend que recibe el nombre, NIF y código de socio.
     * @param nombre nombre del cliente
     * @param nif NIF del cliente
     * @param codigoSocio código de socio del cliente
     */
    public WoodFriend(String nombre, String nif, String codigoSocio) {
        super(nombre, nif);
        this.CodigoSocio = codigoSocio;
    }

    /**
     * Método para agregar un objeto WoodFriend a la lista de WoodFriends.
     * @param wf objeto WoodFriend a agregar
     */
    public void addWoodFriend(WoodFriend wf) {
    }

    /**
     * Método para obtener el código de socio del WoodFriend.
     * @return código de socio del WoodFriend
     */
    public String getCodigoSocio() {
        return this.CodigoSocio;
    }

    /**
     * Método para establecer el código de socio del WoodFriend.
     * @param codigoSocio código de socio a establecer
     */
    public void setCodigoSocio(String codigoSocio) {
        this.CodigoSocio = codigoSocio;
    }

    /**
     * Método toString que devuelve una representación en forma de cadena del objeto WoodFriend.
     * @return representación en forma de cadena del objeto WoodFriend
     */
    public String toString() {
        return "WoodFriend{CodigoSocio='" + this.CodigoSocio + "', nombre='" + this.nombre + "', nif='" + this.nif + "'}";
    }
}

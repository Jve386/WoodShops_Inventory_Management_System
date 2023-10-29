//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package aa4_woodshops;
/**
 * Clase que representa a los profesionales, que son clientes con un descuento adicional.
 */
public class Profesionales extends Clientes {
    Double Descuento;

    /**
     * Constructor de la clase Profesionales.
     *
     * @param nombre    el nombre del profesional
     * @param nif       el NIF del profesional
     * @param descuento el descuento aplicado al profesional
     */
    public Profesionales(String nombre, String nif, Double descuento) {
        super(nombre, nif);
        this.Descuento = descuento;
    }

    /**
     * Obtiene el descuento del profesional.
     *
     * @return el descuento del profesional
     */
    public Double getDescuento() {
        return this.Descuento;
    }

    /**
     * Establece el descuento del profesional.
     *
     * @param descuento el descuento del profesional
     */
    public void setDescuento(Double descuento) {
        this.Descuento = descuento;
    }

    /**
     * Devuelve una representación en forma de cadena del objeto Profesionales.
     *
     * @return una cadena que representa el objeto Profesionales
     */
    public String toString() {
        return "Profesionales{Descuento=" + this.Descuento + ", nombre='" + this.nombre + "', nif='" + this.nif + "'}";
    }
}
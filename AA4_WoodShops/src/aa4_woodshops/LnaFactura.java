//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package aa4_woodshops;
/**
 * Creamos la clase LnaFactura
 */
public class LnaFactura {
    Producto art;
    int cantidad;

    /**
     * Crea una nueva línea de factura con el producto y la cantidad especificados.
     *
     * @param art      El producto de la línea de factura.
     * @param cantidad La cantidad del producto en la línea de factura.
     */
    public LnaFactura(Producto art, int cantidad) {
        this.art = art;
        this.cantidad = cantidad;
    }
    /**
     * Obtiene el producto de la línea de factura.
     *
     * @return El producto de la línea de factura.
     */
    public Producto getArt() {
        return this.art;
    }
    /**
     * Establece el producto de la línea de factura.
     *
     * @param art El producto de la línea de factura.
     */
    public void setArt(Producto art) {
        this.art = art;
    }
    /**
     * Obtiene la cantidad del producto en la línea de factura.
     *
     * @return La cantidad del producto en la línea de factura.
     */
    public int getCantidad() {
        return this.cantidad;
    }
    /**
     * Establece la cantidad del producto en la línea de factura.
     *
     * @param cantidad La cantidad del producto en la línea de factura.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
/**
 * Devuelve una representación en cadena de la línea de factura.
 *
 * @return Representación
 */
    public String toString() {
        return "LnaFactura{art=" + this.art + ", cantidad=" + this.cantidad + "}";
    }
}

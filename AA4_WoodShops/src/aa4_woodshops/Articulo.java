//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package aa4_woodshops;

/**
 * Creamos la clase Articulo
 */

public class Articulo extends Producto {
    private TipoArticulo art;

    /**
     * Constructor de la clase Articulo.
     *
     * @param codigo       El código del artículo.
     * @param descripcion  La descripción del artículo.
     * @param proveedor    El proveedor del artículo.
     * @param precioVenta  El precio de venta del artículo.
     * @param stock        El stock del artículo.
     * @param art          El tipo de artículo.
     */
    public Articulo(String codigo, String descripcion, Proveedor proveedor, Double precioVenta, int stock, TipoArticulo art) {
        super(codigo, descripcion, proveedor, precioVenta, stock);
        this.art = art;
    }
    /**
     * Obtiene el tipo de artículo.
     *
     * @return El tipo de artículo.
     */
    public TipoArticulo getArt() {
        return this.art;
    }

    /**
     * Establece el tipo de artículo.
     *
     * @param art El tipo de artículo a establecer.
     */

    public void setArt(TipoArticulo art) {
        this.art = art;
    }

    /**
     * Devuelve una representación en cadena del objeto Articulo.
     *
     * @return Una cadena que representa el objeto Articulo.
     */

    public String toString() {
        String var10000 = super.toString();
        return var10000 + "Articulo{art='" + this.art + "'}";
    }
}

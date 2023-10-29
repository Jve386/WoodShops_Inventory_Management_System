//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package aa4_woodshops;

/**
 * Creamos la clase Barniz
 */

public class Barniz extends Producto {
    private int ml;
    private TipoColor tipoC;

    /**
     * Generamos el contructor de la clase Barniz
     *
     * @param codigo      String codigo
     * @param descripcion String Descripción
     * @param proveedor   Clase proveedor
     * @param precioVenta Double Precio de venta
     * @param stock       int stock de producto
     * @param tipocolor   Clase TipoColor
     * @param ml          int milímetros
     */

    public Barniz(String codigo, String descripcion, Proveedor proveedor, Double precioVenta, int stock, TipoColor tipoC, int ml) {
        super(codigo, descripcion, proveedor, precioVenta, stock);
        this.ml = ml;
        this.tipoC = tipoC;
    }

    public TipoColor getTipoColor() {
        return this.tipoC;
    }

    /**
     * Establece el tipo de color del barniz.
     *
     * @param tipoC El tipo de color a establecer.
     */
    public void setTipoColor(TipoColor tipoC) {
        this.tipoC = tipoC;
    }

    /**
     * Obtiene la cantidad de mililitros del barniz.
     *
     * @return La cantidad de mililitros del barniz.
     */
    public int getMl() {
        return this.ml;
    }

    /**
     * Establece la cantidad de mililitros del barniz.
     *
     * @param ml La cantidad de mililitros a establecer.
     */
    public void setMl(int ml) {
        this.ml = ml;
    }

    /**
     * Devuelve una representación en cadena del objeto Barniz.
     *
     * @return Una cadena que representa el objeto Barniz.
     */
    public String toString() {
        String var10000 = super.toString();
        return var10000 + "Barniz{tipoColor='" + this.tipoC + "', ml=" + this.ml + "}";
    }
}
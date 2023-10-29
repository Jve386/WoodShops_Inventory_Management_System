//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package aa4_woodshops;
/**
 * Clase que representa un tablero, que es un tipo de producto.
 */
public class Tablero extends Producto {
    private int alto;
    private int ancho;
    private TiposMadera tipoM;
    /**
     * Constructor de la clase Tablero.
     *
     * @param codigo       El código del tablero.
     * @param descripcion  La descripción del tablero.
     * @param proveedor    El proveedor del tablero.
     * @param precioVenta  El precio de venta del tablero.
     * @param stock        El stock disponible del tablero.
     * @param alto         La altura del tablero.
     * @param ancho        El ancho del tablero.
     * @param tipoM        El tipo de madera del tablero.
     */
    public Tablero(String codigo, String descripcion, Proveedor proveedor, Double precioVenta, int stock, int alto, int ancho, TiposMadera tipoM) {
        super(codigo, descripcion, proveedor, precioVenta, stock);
        this.alto = alto;
        this.ancho = ancho;
        this.tipoM = tipoM;
    }

    /**
     * Obtiene la altura del tablero.
     *
     * @return La altura del tablero.
     */
    public float getAlto() {
        return (float) this.alto;
    }

    /**
     * Establece la altura del tablero.
     *
     * @param alto La altura del tablero a establecer.
     */
    public void setAlto(int alto) {
        this.alto = alto;
    }

    /**
     * Obtiene el ancho del tablero.
     *
     * @return El ancho del tablero.
     */
    public int getAncho() {
        return this.ancho;
    }

    /**
     * Establece el ancho del tablero.
     *
     * @param ancho El ancho del tablero a establecer.
     */
    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    /**
     * Obtiene el tipo de madera del tablero.
     *
     * @return El tipo de madera del tablero.
     */
    public TiposMadera getTipoM() {
        return this.tipoM;
    }

    /**
     * Establece el tipo de madera del tablero.
     *
     * @param tipoM El tipo de madera del tablero a establecer.
     */
    public void setTipo(TiposMadera tipoM) {
        this.tipoM = tipoM;
    }

    /**
     * Devuelve una representación en cadena de texto del objeto Tablero.
     *
     * @return La representación en cadena de texto del objeto Tablero.
     */
    @Override
    public String toString() {
        String parentToString = super.toString();
        return parentToString + "Tablero{alto=" + this.alto + ", ancho=" + this.ancho + ", tipo madera=" + this.tipoM + "}";
    }
}
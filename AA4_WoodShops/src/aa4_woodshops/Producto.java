//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package aa4_woodshops;
/**
 * Clase que representa los productos.
 */
public class Producto {

    private String codigo;
    private String descripcion;
    private Proveedor proveedor;
    private Double precioVenta;
    private int stock;

    /**
     * Constructor de la clase Producto.
     *
     * @param codigo      el código del producto
     * @param descripcion la descripción del producto
     * @param proveedor   el proveedor del producto
     * @param precioVenta el precio de venta del producto
     * @param stock       el stock del producto
     */
    public Producto(String codigo, String descripcion, Proveedor proveedor, Double precioVenta, int stock) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.proveedor = proveedor;
        this.precioVenta = precioVenta;
        this.stock = stock;
    }

    /**
     * Obtiene el código del producto.
     *
     * @return el código del producto
     */
    public String getCodigo() {
        return this.codigo;
    }

    /**
     * Establece el código del producto.
     *
     * @param codigo el código del producto
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Obtiene la descripción del producto.
     *
     * @return la descripción del producto
     */
    public String getDescripcion() {
        return this.descripcion;
    }

    /**
     * Establece la descripción del producto.
     *
     * @param descripcion la descripción del producto
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el precio de venta del producto.
     *
     * @return el precio de venta del producto
     */
    public double getPrecioVenta() {
        return this.precioVenta;
    }

    /**
     * Establece el precio de venta del producto.
     *
     * @param precioVenta el precio de venta del producto
     */
    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    /**
     * Obtiene el proveedor del producto.
     *
     * @return el proveedor del producto
     */
    public Proveedor getProveedor() {
        return this.proveedor;
    }

    /**
     * Establece el proveedor del producto.
     *
     * @param proveedor el proveedor del producto
     */
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    /**
     * Obtiene el stock del producto.
     *
     * @return el stock del producto
     */
    public int getStock() {
        return this.stock;
    }

    /**
     * Establece el stock del producto.
     *
     * @param stock el stock del producto
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Devuelve una representación en forma de cadena del objeto Producto.
     *
     * @return una cadena que representa el objeto Producto
     */
    public String toString() {
        return "Producto{codigo=" + this.codigo + ", descripcion='" + this.descripcion + "', proveedor=" + this.proveedor + ", precioVenta=" + this.precioVenta + ", stock=" + this.stock + "}";
    }
}

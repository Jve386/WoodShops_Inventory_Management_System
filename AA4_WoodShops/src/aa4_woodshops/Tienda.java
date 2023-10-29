//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package aa4_woodshops;

import java.util.ArrayList;
import java.util.Iterator;
/**
 * Clase Tienda que recogerá el nombre de las tiendas y los productos
 */
public class Tienda {
    private String nomTienda;
    private ArrayList<Producto> productos = new ArrayList();
    private ArrayList<Factura> facturas = new ArrayList();
    /**
     * Constructor de la clase Tienda que recibe el nombre de la tienda.
     *
     * @param nomTienda El nombre de la tienda.
     */
    public Tienda(String nomTienda) {
        this.nomTienda = nomTienda;
    }

    public Tienda(String nomTienda, ArrayList<Producto> productos) {
        this.nomTienda = nomTienda;
        this.productos = productos;
    }
    /**
     * Constructor de la clase Tienda que recibe un nombre y una lista de productos.
     * @param nomTienda string
     * @param productos lista de productos
     */
    public Tienda(String nomTienda, Producto productos) {
        this.nomTienda = nomTienda;
        this.productos.add(productos);
    }
    /**
     * Agrega un producto a la lista de productos de la tienda.
     *
     * @param productos El producto a agregar.
     */
    public void addProducto(Producto productos) {
        this.productos.add(productos);
    }
    /**
     * Obtiene el nombre de la tienda.
     *
     * @return El nombre de la tienda.
     */
    public String getNomTienda() {
        return this.nomTienda;
    }
    /**
     * Establece el nombre de la tienda.
     *
     * @param nomTienda El nombre de la tienda a establecer.
     */
    public void setNomTienda(String nomTienda) {
        this.nomTienda = nomTienda;
    }
    /**
     * Obtiene la lista de productos de la tienda.
     *
     * @return La lista de productos de la tienda.
     */
    public ArrayList<Producto> getProductos() {
        return this.productos;
    }
    /**
     * Establece la lista de productos de la tienda.
     *
     * @param productos La lista de productos de la tienda a establecer.
     */
    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }
    /**
     * Muestra los productos de la tienda filtrados por tipo.
     *
     * @param tipo El tipo de producto a mostrar.
     */
    public void mostrarProductos(String tipo) {
        System.out.println("Introduzca el producto: ");
        String clase = "class aa3_woodshops." + tipo;
        Iterator<Producto> it = this.productos.iterator();

        while(it.hasNext()) {
            Producto prod = (Producto)it.next();
            if (prod.getClass().getName().equals(clase) && tipo.equals("Tablero")) {
                Tablero tab = (Tablero)prod;
                System.out.println(tab);
            }

            if (prod.getClass().getName().equals(clase) && tipo.equals("Barniz")) {
                Barniz bz = (Barniz)prod;
                System.out.println(bz);
            }

            if (prod.getClass().getName().equals(clase) && tipo.equals("Articulo")) {
                Articulo art = (Articulo)prod;
                System.out.println(art);
            }
        }

    }
    /**
     * Obtiene el producto de la tienda con el código especificado.
     *
     * @param codigoProducto El código del producto a buscar.
     * @return El producto con el código especificado, o null si no se encuentra.
     */
    public Producto getProducto(String codigoProducto) {
        Iterator<Producto> it = this.productos.iterator();

        Producto prod;
        do {
            if (!it.hasNext()) {
                return null;
            }

            prod = (Producto)it.next();
        } while(!prod.getCodigo().equals(codigoProducto));

        return prod;
    }
    /**
     * Agrega una factura a la lista de facturas de la tienda.
     *
     * @param factura La factura a agregar.
     */
    public void addFactura(Factura factura) {
        this.facturas.add(factura);
    }
    /**
     * Obtiene la lista de facturas de la tienda.
     *
     * @return La lista de facturas de la tienda.
     */
    public ArrayList<Factura> getFacturas() {
        return this.facturas;
    }
    /**
     * Establece la lista de facturas de la tienda.
     *
     * @param facturas La lista de facturas de la tienda a establecer.
     */
    public void setFacturas(ArrayList<Factura> facturas) {
        this.facturas = facturas;
    }
    /**
     * Devuelve una representación en cadena de texto del objeto Tienda.
     *
     * @return La representación en cadena de texto del objeto Tienda.
     */
    public String toString() {
        return "Tienda{nomTienda='" + this.nomTienda + "', productos=" + this.productos + ", facturas=" + this.facturas + "}";
    }
    /**
     * Agrega un artículo a la lista de productos de la tienda.
     *
     * @param art El artículo a agregar.
     */
    public void addArticulo(Articulo art) {
        this.productos.add(art);
    }

    /**
     * Agrega un barniz a la lista de productos de la tienda.
     *
     * @param bz El barniz a agregar.
     */
    public void addBarniz(Barniz bz) {
        this.productos.add(bz);
    }

    /**
     * Agrega un tablero a la lista de productos de la tienda.
     *
     * @param tab El tablero a agregar.
     */
    public void addTablero(Tablero tab) {
        this.productos.add(tab);
    }
}

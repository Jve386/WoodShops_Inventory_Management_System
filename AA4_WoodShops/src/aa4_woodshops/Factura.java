//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package aa4_woodshops;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * Creamos la clase Factura
 */
public class Factura {
    private String codigofactura;
    private LocalDate fechaCompra;
    private Clientes cliente;
    private ArrayList<LnaFactura> lnasFacturas = new ArrayList();
    private Double descuento;
    private Double total;

    /**
     * Constructor de la clase Factura.
     *
     * @param codigofactura El código de la factura.
     * @param fechaCompra   La fecha de compra de la factura.
     * @param total double
     */
    public Factura(String codigofactura, LocalDate fechaCompra) {
        this.codigofactura = codigofactura;
        this.fechaCompra = fechaCompra;
        this.total = 0.0;
    }

    /**
     * Constructor de la clase Factura.
     *
     * @param codigofactura El código de la factura.
     * @param fechaCompra   La fecha de compra de la factura.
     * @param cliente       El cliente asociado a la factura.
     * @param total double
     */
    public Factura(String codigofactura, LocalDate fechaCompra, Clientes cliente) {
        this.codigofactura = codigofactura;
        this.fechaCompra = fechaCompra;
        this.cliente = cliente;
        this.total = 0.0;
    }
    /**
     * Constructor de la clase Factura.
     *
     * @param codigofactura El código de la factura.
     * @param fechaCompra   La fecha de compra de la factura.
     * @param cliente       El cliente asociado a la factura.
     * @param descuento     El descuento aplicado a la factura.
     */
    public Factura(String codigofactura, LocalDate fechaCompra, Clientes cliente, Double descuento) {
        this.codigofactura = codigofactura;
        this.cliente = cliente;
        this.fechaCompra = fechaCompra;
        this.descuento = descuento;
        this.total = 0.0;
    }
    /**
     * Agrega una línea de factura a la factura.
     *
     * @param lnasFactura La línea de factura a agregar.
     */
    public void addLnaFactura(LnaFactura lnasFactura) {
        this.lnasFacturas.add(lnasFactura);
        this.recalcularTotal();
    }
    /**
     * Recalcula el total de la factura.
     */
    private void recalcularTotal() {
        LnaFactura lnaFactura;
        for(Iterator var1 = this.lnasFacturas.iterator(); var1.hasNext(); this.total = this.total + lnaFactura.getArt().getPrecioVenta() * (double)lnaFactura.getCantidad()) {
            lnaFactura = (LnaFactura)var1.next();
        }

    }
    /**
     * Obtiene el código de la factura.
     *
     * @return El código de la factura.
     */
    public String getCodigofactura() {
        return this.codigofactura;
    }
    /**
     * Establece el código de la factura.
     *
     * @param codigofactura El código de la factura.
     */
    public void setCodigofactura(String codigofactura) {
        this.codigofactura = codigofactura;
    }
    /**
     * Obtiene el cliente asociado a la factura.
     *
     * @return El cliente asociado a la factura.
     */
    public Clientes getCliente() {
        return this.cliente;
    }
    /**
     * Establece el cliente asociado a la factura
     *
     * @param Cliente El cliente asociado a la factura
     */
    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }
    /**
     * Obtiene la fecha de compra de la factura.
     *
     * @return La fecha de compra de la factura.
     */
    public LocalDate getFechaCompra() {
        return this.fechaCompra;
    }
    /**
     * Establece la fecha de compra de la factura.
     *
     * @param fechaCompra La fecha de compra de la factura.
     */
    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    /**
     * Obtiene el total de la factura.
     *
     * @return El total de la factura.
     */
    public Double getTotal() {
        return this.total;
    }
    /**
     * Establece el total de la factura.
     *
     * @param total El total de la factura.
     */
    public void setTotal(Double total) {
        this.total = total;
    }
    /**
     * Obtiene el descuento aplicado a la factura.
     *
     * @return El descuento aplicado a la factura.
     */
    public Double getDescuento() {
        return this.descuento;
    }
    /**
     * Agrega una línea de factura a la factura.
     *
     * @param lnaFactura La línea de factura a agregar.
     */
    public void setLnaFactura(LnaFactura lnaFactura) {
        this.lnasFacturas.add(lnaFactura);
    }
    /**
     * Establece la lista de líneas de factura de la factura.
     *
     * @param lnasFacturas La lista de líneas de factura.
     */
    public void setLnasFacturas(ArrayList<LnaFactura> lnasFacturas) {
        this.lnasFacturas = lnasFacturas;
    }
    /**
     * Obtiene la lista de líneas de factura de la factura.
     *
     * @return La lista de líneas de factura.
     */
    public ArrayList<LnaFactura> getLnasFacturas() {
        return this.lnasFacturas;
    }
    /**
     * Establece el descuento aplicado a la factura.
     *
     * @param descuento El descuento aplicado a la factura.
     */
    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }
    /**
     * Devuelve una representación en cadena de la factura.
     *
     * @return Representación en cadena de la factura.
     */

    public String toString() {
        return "Factura{factura='" + this.codigofactura + "', fechaCompra=" + this.fechaCompra + ", cliente=" + this.cliente + ", lnasFacturas=" + this.lnasFacturas + ", descuento=" + this.descuento + ", total=" + this.total + "}";
    }
}

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package aa4_woodshops;

        /**
         * Clase principal AA4_WoodShops que albergara el menú.
         */

import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Random;
import java.util.UUID;
import java.util.Arrays;
import java.lang.ref.Cleaner;

        /**
         *
         * @author Javier de la Vega Eder
        */

public class AA4_WoodShops {
    Scanner teclado;

        /**
         * Inicializamos sede y tienda
         */

    Sede sede;
    Tienda tienda;

        /**
         * Clase principal que contiene el método de entrada para el programa de WoodShops.
         */
    public AA4_WoodShops() {
        this.teclado = new Scanner(System.in);
        this.sede = new Sede();
        this.tienda = null;
    }
        /**
         * Punto de entrada del programa.
         *
         * @param args Los argumentos de línea de comandos (no se utilizan en este programa).
         */
    public static void main(String[] args) {
        AA4_WoodShops prg = new AA4_WoodShops();
        prg.inicio();
    }
        /**
         * Muestra un menú de opciones y permite al usuario seleccionar una opción para realizar diversas acciones.
         * Las opciones disponibles incluyen mostrar tiendas, mostrar productos en una tienda, mostrar el stock de un producto en todas las tiendas,
         * mostrar proveedores, mostrar clientes, añadir productos, añadir clientes, añadir tickets y mostrar todos los tickets por fecha.
         * El usuario puede seleccionar la opción '0' para salir del menú y finalizar el programa.
         */
    void inicio() {
        boolean salir = false;
        this.loadInfo();

        do {
            System.out.println(" ");
            System.out.println("Elige una opción:");
            System.out.println("(1) Mostrar tiendas");
            System.out.println("(2) Mostrar productos en una tienda");
            System.out.println("(3) Mostrar Stock de un producto en todas las tiendas");
            System.out.println("(4) Mostrar proveedores");
            System.out.println("(5) Mostrar clientes");
            System.out.println("(6) Añadir productos");
            System.out.println("(7) Añadir clientes");
            System.out.println("(8) Añadir tickets");
            System.out.println("(9) Mostrar todos los tickets por fecha");
            System.out.println("(a) Mostrar facturación total de todas las tiendas");
            System.out.println("(0) Salir.");
            System.out.println("");
            char opcio = this.demanarOpcioMenu();
            switch (opcio) {
                case '0':
                    salir = true;
                    break;
                case '1':
                    this.showStores();
                    break;
                case '2':
                    this.showProducts();
                    break;
                case '3':
                    this.productsStock();
                    break;
                case '4':
                    this.addProviders();
                    break;
                case '5':
                    this.showCustomers();
                    break;
                case '6':
                    this.addProduct();
                    break;
                case '7':
                    this.addCustomer();
                    break;
                case '8':
                    this.addSale();
                    break;
                case '9':
                    this.showSales();
                case 'a':
                    this.showTotals();
            }
        } while(!salir);

    }

            void showTotals() {
                double totalVentas = 0.0;

                System.out.println("");
                System.out.println("");
                System.out.println("Estas son todas las tiendas seleccionadas: ");
                System.out.println("");
                ArrayList<Tienda> tiendas = this.sede.getTiendas();
                Iterator var2 = tiendas.iterator();

                while(var2.hasNext()) {
                    Tienda tienda = (Tienda) var2.next();
                    System.out.println(tienda.getNomTienda());
                }

                System.out.println("");
                System.out.println("");
                System.out.println("Fecha de inicio para mostrar tickets: ");
                System.out.println("");
                String fechaInicialStr = this.teclado.nextLine();
                LocalDate fechaInicial = LocalDate.parse(fechaInicialStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                System.out.println("");
                System.out.println("");
                System.out.println("Fecha hasta la cuál deseas visualizar los tickets: ");
                String fechaFinalStr = this.teclado.nextLine();
                LocalDate fechaFinal = LocalDate.parse(fechaFinalStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                System.out.println("");


                for (Tienda tienda : tiendas) {
                    ArrayList<Factura> facturas = tienda.getFacturas();
                    Iterator var9 = facturas.iterator();

                    while(var9.hasNext()) {
                        Factura factura = (Factura) var9.next();
                        LocalDate fechaCompra = factura.getFechaCompra();
                        if (!fechaCompra.isBefore(fechaInicial) && !fechaCompra.isAfter(fechaFinal)) {
                            totalVentas += factura.getTotal();
                        }
                    }
                }

                System.out.println("El total de ventas en el periodo seleccionado es: " + totalVentas + "€");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.print("Pulsa ENTER para continuar.");
                this.teclado.nextLine();
            }

            /**
             * Metodo para mostrar tiendas.
             * @return nada.
             * @throws NoSuchElementException si ocurre un error al obtener la lista de tiendas de la sede.
             */
    public void showStores() {
        System.out.println("");
        System.out.println("Tiendas: ");
        ArrayList<Tienda> tiendas = this.sede.getTiendas();

        Iterator var2 = tiendas.iterator();

        while(var2.hasNext()) {
            Tienda tienda = (Tienda)var2.next();
            System.out.println(tienda.getNomTienda());
        }
        System.out.println("");
        System.out.print("Presiona ENTER para volver al menú principal.");
        this.teclado.nextLine();

    }

            /**
             * Metodo para añadir clientes
             *
             * @param nombreCliente El nombre del cliente a agregar.
             * @param nifCliente    El NIF del cliente a agregar.
             * @param tipoCliente   El tipo de cliente a agregar ("P" para Profesional o "W" para WoodFriend).
             */

    void addCustomer() {
        System.out.println("Introduce el nombre: ");
        String nombreCliente = this.teclado.nextLine();
        System.out.println("Introduce el nif: ");
        String nifCliente = this.teclado.nextLine();
        System.out.println("Introduce el tipo de cliente: (1)Profesional o (2)WoodFriend");
        String tipoCliente = this.teclado.nextLine().toUpperCase();
        if (tipoCliente.equals("1")) {
            System.out.println("Introduce el descuento: ");
            Double descuento = this.teclado.nextDouble();
            this.teclado.nextLine();
            Clientes clientes = new Profesionales(nombreCliente, nifCliente, descuento);
            this.sede.addCustomers(clientes);
        } else if (tipoCliente.equals("2")) {
            System.out.println("Introduce el código de socio: ");
            String codigoSocio = this.teclado.nextLine();
            Clientes clientes = new WoodFriend(nombreCliente, nifCliente, codigoSocio);
            this.sede.addCustomers(clientes);
        }

        System.out.println("");
        System.out.print("¿Quiere introducir otro Cliente? Y/N ");
        if (this.teclado.nextLine().equalsIgnoreCase("Y")) {
            this.addCustomer();
        } else {
            System.out.println("");
            System.out.println("");
            System.out.print("Cliente añadido.");
            System.out.print("Pulsa ENTER para continuar.");
            this.teclado.nextLine();
        }

    }
            /**
             * Metodo para mostrar a los clientes
             * @return nada.
             * @throws NoSuchElementException si ocurre un error al obtener la lista de clientes de la sede.
             */

    void showCustomers() {
        System.out.println("");
        System.out.println("");
        System.out.println("Lista de clientes: ");
        System.out.println("");
        ArrayList<Clientes> clientes = this.sede.getClientes();
        Iterator var2 = clientes.iterator();

        while(var2.hasNext()) {
            Clientes cliente = (Clientes)var2.next();
            if (cliente.getClass().getName().equals("aa4_woodshops.Profesionales")) {
                System.out.println(cliente.getNombre() + " -> Profesional");
            } else {
                System.out.println(cliente.getNombre() + " -> WoodFriend");
            }
        }

        System.out.println("");
        System.out.println("");
        System.out.print("Pulsa ENTER para continuar.");
        this.teclado.nextLine();
    }
            /**
             * Metodo para agregar venta a una tienda.
             *
             * @return nada.
             * @throws NoSuchElementException si ocurre un error al obtener la lista de tiendas o clientes de la sede.
             */
    void addSale() {
        System.out.println("");
        System.out.println("");
        System.out.println("Escoge entre las siguientes tiendas: ");
        System.out.println("");
        ArrayList<Tienda> tiendas = this.sede.getTiendas();
        Iterator var3 = tiendas.iterator();

        while(var3.hasNext()) {
            Tienda tienda = (Tienda)var3.next();
            System.out.println(tienda.getNomTienda());
        }

        System.out.println("");
        System.out.println("Indica el nombre de tienda:");
        String nombreTienda = this.teclado.nextLine().toUpperCase();
        Tienda tienda = this.sede.getTienda(nombreTienda);
        if (tienda == null) {
            System.out.println("La tienda escrita no está en la base de datos.");
        } else {
            System.out.println("Indica el numero de factura:");
            String codigofactura = this.teclado.nextLine();
            System.out.println("Introduzca la fecha de la compra: (Format:dd/MM/yyyy)");
            LocalDate fechaCompra = LocalDate.parse(this.teclado.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            System.out.println("¿Ya está registrado en el sistema?:  (S) / (N) ");
            String clienteRegistrado = this.teclado.nextLine().toUpperCase();
            if (clienteRegistrado.equals("S")) {
                System.out.println("Listado de clientes registrados:");
                ArrayList<Clientes> clientes = this.sede.getClientes();
                Comparator<Clientes> comp = Comparator.comparing(Clientes::getNombre);
                Collections.sort(clientes, comp);
                Iterator var9 = clientes.iterator();

                Clientes cliente;
                while(var9.hasNext()) {
                    cliente = (Clientes)var9.next();
                    PrintStream var10000 = System.out;
                    String var10001 = cliente.getNombre();
                    var10000.println("-" + var10001 + " -> " + cliente.getNif() + " -> " + cliente.getClass().getName());
                }

                System.out.println("Escribe el nombre del cliente:");
                String nombreCliente = this.teclado.nextLine().toUpperCase();
                cliente = this.sede.getCliente(nombreCliente);
                System.out.println("Productos: ");
                ArrayList<Producto> productos = tienda.getProductos();
                boolean acabar = false;
                if (cliente instanceof Profesionales) {
                    Profesionales prof = (Profesionales)cliente;
                    Double descuento = prof.getDescuento();
                    Factura factura = new Factura(codigofactura, fechaCompra, cliente, descuento);
                    factura = this.pedirLnasFactura(factura, tienda);
                    tienda.addFactura(factura);
                } else if (cliente instanceof WoodFriend) {
                    WoodFriend wood = (WoodFriend)cliente;
                    Factura factura = new Factura(codigofactura, fechaCompra, cliente);
                    factura = this.pedirLnasFactura(factura, tienda);
                    tienda.addFactura(factura);
                }

                this.teclado.nextLine();
            } else if (clienteRegistrado.equals("N")) {
                Factura factura = new Factura(codigofactura, fechaCompra);
                factura = this.pedirLnasFactura(factura, tienda);
                tienda.addFactura(factura);
            }

            System.out.println("");
            System.out.println("");
            System.out.println("Pulsa ENTER para continuar.");
            this.teclado.nextLine();
        }
    }
            /**
             * Metodo para solicitar info sobre productos comprados y cantidades para una factura.
             * Muestra la lista de productos disponibles en la tienda y solicita al usuario que ingrese el código del producto.
             * Luego, solicita la cantidad de producto comprado y crea un objeto LnaFactura con el producto y la cantidad.
             * Agrega el objeto LnaFactura a la factura actual.
             * Repite el proceso si el usuario desea agregar otro producto a la factura.
             *
             * @param factura la factura actual a la que se agregarán las líneas de factura.
             * @param tienda la tienda donde se realizará la compra.
             * @return la factura actualizada con las líneas de factura agregadas.
            */
    private Factura pedirLnasFactura(Factura factura, Tienda tienda) {
        boolean acabar = false;
        new ArrayList();

        while(!acabar) {
            Iterator var5 = tienda.getProductos().iterator();

            Producto prod;
            while(var5.hasNext()) {
                prod = (Producto)var5.next();
                PrintStream var10000 = System.out;
                String var10001 = prod.getCodigo();
                var10000.println(var10001 + " -> " + prod.getDescripcion());
            }

            System.out.println("Escribe el código del producto:");
            String codigoProducto = this.teclado.nextLine().toUpperCase();
            prod = tienda.getProducto(codigoProducto);
            this.teclado.nextLine();
            if (prod == null) {
                System.out.println("El producto no está en la base de datos.");
            } else {
                System.out.println("Introduce la cantidad de producto comprado:");
                int cantidad = this.teclado.nextInt();
                this.teclado.nextLine();
                LnaFactura lnaFactura = new LnaFactura(prod, cantidad);
                factura.addLnaFactura(lnaFactura);
                this.teclado.nextLine();
                System.out.println("¿Añadir otro producto? (S) / (N) ");
                String opcion = this.teclado.nextLine().toUpperCase();
                if (opcion.equals("N")) {
                    acabar = true;
                }
            }
        }

        return factura;
    }
            /**
             * Muestra los tickets de venta en un rango de fechas para una tienda específica.
             *
             * Muestra una lista de las tiendas disponibles y solicita al usuario que ingrese el nombre de la tienda.
             * Luego, solicita al usuario que ingrese la fecha de inicio y la fecha final para filtrar los tickets de venta.
             * Muestra los tickets de venta que se encuentran dentro del rango de fechas especificado, incluyendo el número de factura,
             * la fecha de compra, el cliente, el descuento y el total.
             *
             * Si la tienda indicada no está en la base de datos, muestra un mensaje indicando que la tienda no está disponible.
             *
             * @see Factura
             * @see Tienda
             */

            void showSales() {
                System.out.println("");
                System.out.println("");
                System.out.println("Escoge entre las siguientes tiendas: ");
                System.out.println("");
                System.out.println("");
                ArrayList<Tienda> tiendas = this.sede.getTiendas();
                Iterator var2 = tiendas.iterator();

                Tienda tienda;
                while(var2.hasNext()) {
                    tienda = (Tienda)var2.next();
                    System.out.println(tienda.getNomTienda());
                }
                System.out.println("");
                System.out.println("");
                System.out.println("Escribe el nombre de la tienda:");
                System.out.println("");
                String nombreTienda = this.teclado.nextLine().toUpperCase();
                tienda = this.sede.getTienda(nombreTienda);
                if (tienda == null) {
                    System.out.println("La tienda indicada no está en la base de datos.");
                } else {
                    System.out.println("");
                    System.out.println("");
                    System.out.println("Fecha de inicio para mostrar tickets: ");
                    System.out.println("");
                    String fechaInicialStr = this.teclado.nextLine();
                    LocalDate fechaInicial = LocalDate.parse(fechaInicialStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    System.out.println("");
                    System.out.println("");
                    System.out.println("Fecha hasta la cuál deseas visualizar los tickets: ");
                    String fechaFinalStr = this.teclado.nextLine();
                    LocalDate fechaFinal = LocalDate.parse(fechaFinalStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    System.out.println("");
                    ArrayList<Factura> facturas = tienda.getFacturas();
                    Iterator var9 = facturas.iterator();

                    while(var9.hasNext()) {
                        Factura factura = (Factura)var9.next();
                        LocalDate fechaCompra = factura.getFechaCompra();
                        if (!fechaCompra.isBefore(fechaInicial) && !fechaCompra.isAfter(fechaFinal)) {
                            System.out.println("Numero factura : " + factura.getCodigofactura());
                            System.out.println("Fecha de Compra  : " + factura.getFechaCompra());
                            System.out.println("Cliente : " + factura.getCliente().getNombre());
                            System.out.println("Descuento : " + factura.getDescuento());
                            System.out.println("Total : " + factura.getTotal());
                            System.out.println("");


                        }
                    }

                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.print("Pulsa ENTER para continuar.");
                    this.teclado.nextLine();
                }
            }

            /**
             * Solicita al usuario que elija una opción del menú.
             *
             * Muestra un mensaje solicitando al usuario que elija una opción del menú.
             * Lee la respuesta del usuario desde la entrada estándar y la devuelve como un carácter.
             * Si la respuesta está vacía, se devuelve un espacio en blanco como carácter.
             *
             * @return El carácter que representa la opción elegida por el usuario.
             */
    char demanarOpcioMenu() {
        System.out.println("");
        System.out.print("Elegir opción: ");
        String resp = this.teclado.nextLine();
        if (resp.isEmpty()) {
            resp = " ";
        }

        return resp.charAt(0);
    }
            /**
             * Agrega una nueva tienda al sistema.
             *
             * Muestra un mensaje solicitando al usuario que introduzca el nombre de la tienda.
             * Lee el nombre de la tienda desde la entrada estándar y lo almacena en una variable.
             * Crea una nueva instancia de la clase Tienda con el nombre proporcionado.
             * Asigna la tienda creada al objeto Sede.
             *
             * @return El nombre de la tienda agregada.
             */
    String addStores() {
        System.out.println("Introduzca el nombre de la tienda: ");
        String nombreTienda = this.teclado.nextLine().toUpperCase();
        this.tienda = new Tienda(nombreTienda);
        this.sede.setTienda(this.tienda);
        return nombreTienda;
    }
            /**
             * Agrega un nuevo producto a una tienda específica.
             *
             * Muestra un mensaje solicitando al usuario que elija una tienda de la lista disponible.
             * Lee el nombre de la tienda desde la entrada estándar y busca la tienda correspondiente en la sede.
             * Si la tienda no existe, se muestra un mensaje de error.
             * Si la tienda existe, se solicita al usuario que introduzca el código, descripción, proveedor, precio de venta y stock del producto.
             * Luego, se le pide al usuario que especifique el tipo de producto (tablero, barniz o artículo) mediante una opción.
             * Dependiendo del tipo de producto seleccionado, se solicitan y registran los detalles adicionales del producto.
             * Finalmente, el producto se asigna a la tienda correspondiente en la sede.
             */
    void addProduct() {
        Tablero tab = null;
        Barniz bar = null;
        Articulo art = null;
        String nombreTienda = "";
        System.out.println("");
        System.out.println("Escoge entre las siguientes tiendas: ");
        System.out.println("");
        ArrayList<Tienda> tiendas = this.sede.getTiendas();
        Iterator var6 = tiendas.iterator();

        while(var6.hasNext()) {
            Tienda tienda = (Tienda)var6.next();
            System.out.println(tienda.getNomTienda());
        }

        System.out.println("");
        System.out.println("");
        System.out.println("Indica el nombre de la tienda:");
        nombreTienda = this.teclado.nextLine().toUpperCase();
        Tienda tienda = this.sede.getTienda(nombreTienda);
        if (tienda == null) {
            System.out.println("La tienda indicada no existe.");
        } else {
            System.out.println("");
            System.out.println("Intoduzca el codigo del producto indicando A para tabla, B para barniz y C para articulo: ");
            String codigo = this.teclado.nextLine().toUpperCase();
            System.out.println("");
            System.out.println("Intoduzca la descripcion del producto: ");
            String descripcion = this.teclado.nextLine();
            System.out.println("");
            System.out.println("Intoduzca el nif del proveedor del producto: ");
            String nif = this.teclado.nextLine();
            System.out.println("");
            System.out.println("Intoduzca el nombre del proveedor del producto: ");
            String nombre = this.teclado.nextLine();
            Proveedor proveedor = new Proveedor(nif, nombre);
            this.sede.addProveedor(proveedor);
            System.out.println("");
            System.out.println("Intoduzca el precio de venta del producto: ");
            double precioVenta = this.teclado.nextDouble();
            System.out.println("");
            System.out.println("Introduzca el stock del producto");
            int stock = this.teclado.nextInt();
            this.teclado.nextLine();
            System.out.println("");
            System.out.println("Intoduzca el tipo de producto: (1)Tablero, (2)Barniz,(3)Articulo");
            switch (this.teclado.nextLine().toUpperCase()) {
                case "1":
                    System.out.println("Introduce la altura de la tabla en cm: ");
                    int altura = this.teclado.nextInt();
                    System.out.println("Introduce el ancho de la tabla cm: ");
                    int ancho = this.teclado.nextInt();
                    System.out.println("Introduce el tipo de madera 1.- osb, 2.- particulas, 3.- mdf, 4.- contrachapado : ");
                    this.teclado.nextLine();
                    String opM = this.teclado.nextLine();
                    TiposMadera tipoM = null;
                    switch (opM) {
                        case "1":
                            tipoM = TiposMadera.osb;
                            break;
                        case "2":
                            tipoM = TiposMadera.particulas;
                            break;
                        case "3":
                            tipoM = TiposMadera.mdf;
                            break;
                        case "4":
                            tipoM = TiposMadera.contrachapado;
                    }

                    tab = new Tablero(codigo, descripcion, proveedor, precioVenta, stock, altura, ancho, tipoM);
                    this.sede.asignarArticuloTienda(tab, nombreTienda);
                    break;
                case "2":
                    System.out.println("Introduce el volumen en mililitros: ");
                    int ml = this.teclado.nextInt();
                    System.out.println("Introduce el Color 1.- natural, 2.- marron, 3.- rojo, 4.- gris : ");
                    this.teclado.nextLine();
                    String opB = this.teclado.nextLine();
                    TipoColor tipoC = null;
                    switch (opB) {
                        case "1":
                            tipoC = TipoColor.natural;
                            break;
                        case "2":
                            tipoC = TipoColor.marron;
                            break;
                        case "3":
                            tipoC = TipoColor.rojo;
                            break;
                        case "4":
                            tipoC = TipoColor.gris;
                    }

                    bar = new Barniz(codigo, descripcion, proveedor, precioVenta, stock, tipoC, ml);
                    this.sede.asignarArticuloTienda(bar, nombreTienda);
                    break;
                case "3":
                    System.out.println("Introduce el tipo de articulo 1.- armario, 2.- cama, 3.- mesa, 4.- cajonera : ");
                    String opA = this.teclado.nextLine();
                    TipoArticulo a = null;
                    switch (opA) {
                        case "1":
                            a = TipoArticulo.armario;
                            break;
                        case "2":
                            a = TipoArticulo.cama;
                            break;
                        case "3":
                            a = TipoArticulo.mesa;
                            break;
                        case "4":
                            a = TipoArticulo.cajonera;
                    }

                    art = new Articulo(codigo, descripcion, proveedor, precioVenta, stock, a);
                    this.sede.asignarArticuloTienda(art, nombreTienda);
            }

        }
    }
            /**
             * Muestra los productos de una tienda específica según el tipo especificado.
             *
             * Muestra un mensaje solicitando al usuario que elija una tienda de la lista disponible.
             * Lee el nombre de la tienda desde la entrada estándar y busca la tienda correspondiente en la sede.
             * Si la tienda no existe, se muestra un mensaje de error.
             * Si la tienda existe, se solicita al usuario que introduzca el tipo de producto que desea mostrar: tablero, barniz, artículo o todos.
             * Según el tipo seleccionado, se muestran los productos correspondientes de la tienda.
             */
    public void showProducts() {
        System.out.println("Escoge entre las siguientes tiendas: ");
        System.out.println("");
        ArrayList<Tienda> tiendas = this.sede.getTiendas();
        Iterator var3 = tiendas.iterator();

        while(var3.hasNext()) {
            Tienda tienda = (Tienda)var3.next();
            System.out.println(tienda.getNomTienda());
        }

        System.out.println("");
        System.out.println("Indica el nombre de la tienda:");
        String nombreTienda = this.teclado.nextLine().toUpperCase();
        Tienda tienda = this.sede.getTienda(nombreTienda);
        if (tienda == null) {
            System.out.println("La tienda indicada no existe.");
        } else {
            System.out.println("");
            System.out.println("Introduzca el tipo de producto: (1)Tablero,(2)Barniz,(3)Articulo,(4)Todo");
            String p = this.teclado.nextLine().toUpperCase();
            ArrayList<Producto> productos = tienda.getProductos();
            Iterator<Producto> itp = productos.iterator();
            switch (p) {
                case "4":
                    while(itp.hasNext()) {
                        System.out.println(itp.next());
                    }

                    return;
                case "1":
                    this.showProductType(itp, "1");
                    break;
                case "2":
                    this.showProductType(itp, "2");
                    break;
                case "3":
                    this.showProductType(itp, "3");
            }

        }
    }
            /**
             * Muestra los productos de un tipo específico de una tienda.
             *
             * Recibe un iterador de productos y un tipo de producto como parámetros.
             * Recorre los productos utilizando el iterador y compara el código de cada producto con el tipo especificado.
             * Si el código del producto coincide con el tipo, se muestra el producto en la salida estándar.
             *
             * @param it   Iterador de productos
             * @param tipo Tipo de producto a mostrar (1: tablero, 2: barniz, 3: artículo)
             */
    void showProductType(Iterator<Producto> it, String tipo) {
        while(it.hasNext()) {
            Producto prd = (Producto)it.next();
            String codigo = prd.getCodigo();
            switch (tipo) {
                case "1":
                    if (codigo.substring(0, 1).equals("1")) {
                        System.out.println(prd);
                    }
                    break;
                case "2":
                    if (codigo.substring(0, 1).equals("2")) {
                        System.out.println(prd);
                    }
                case "3":
                    if (codigo.substring(0, 1).equals("3")) {
                        System.out.println(prd);
                    }
            }
        }

    }

            /**
             * Muestra el stock y el precio de venta de un artículo específico en todas las tiendas.
             *
             * @param codigo el código del producto a consultar el stock.
             */
    public void productsStock() {
        System.out.println("Ingrese codigo producto: ");
        String codigo = this.teclado.nextLine().toUpperCase();
        System.out.println("");
        System.out.println("Stock para el artículo: " + codigo);
        System.out.println("");

        // Obtener la lista de tiendas
        ArrayList<Tienda> tiendas = this.sede.getTiendas();

        // Iterar sobre cada tienda
        for (Tienda tienda : tiendas) {
            ArrayList<Producto> prods = tienda.getProductos();

            // Iterar sobre los productos de la tienda actual
            for (Producto prod : prods) {
                if (prod.getCodigo().equals(codigo)) {
                    System.out.println("Tienda : " + tienda.getNomTienda());
                    System.out.println("Stock  : " + prod.getStock());
                    System.out.println("Precio : " + prod.getPrecioVenta());
                }
            }
        }

        System.out.println("");
        System.out.print("Presiona ENTER para volver al menú principal.");
        this.teclado.nextLine();
    }

            /**
             * Muestra el listado de proveedores disponibles.
             *
             * @return el listado de proveedores.
             */

    public void addProviders() {
        System.out.println("Listado de proveedores: ");
        System.out.println("");
        ArrayList<Proveedor> proveedores = this.sede.getProveedores();
        Iterator var2 = proveedores.iterator();

        while(var2.hasNext()) {
            Proveedor proveedor = (Proveedor)var2.next();
            PrintStream var10000 = System.out;
            String var10001 = proveedor.getNombre();
            var10000.println(var10001 + " -> " + proveedor.getNif());
        }

        System.out.println("");
        System.out.print("Presiona ENTER para volver al menú principal.");
        this.teclado.nextLine();
    }


            /**
             * Carga la información inicial del sistema, agregando proveedores, tiendas, clientes y facturas.
             */
    public void loadInfo() {
        Proveedor proveedor1 = new Proveedor("12345678A", "WOODS PROVIDER");
        this.sede.addProveedor(proveedor1);
        Proveedor proveedor2 = new Proveedor("98754625S", "BARNIZ LLUIS");
        this.sede.addProveedor(proveedor2);
        Proveedor proveedor3 = new Proveedor("2584769OS", "MM MOBLES");
        this.sede.addProveedor(proveedor3);
        ArrayList<Proveedor> tab = this.sede.getProveedores();
        Proveedor maderas = (Proveedor)tab.get(0);
        Proveedor barniz = (Proveedor)tab.get(1);
        Proveedor articulos = (Proveedor)tab.get(2);
        Producto producto1 = new Tablero("T001", "Tablero 100x100 osb", proveedor1, 100.0, 320, 20, 10, TiposMadera.osb);
        Producto producto2 = new Barniz("B001", "Barniz 2L marron", proveedor2, 160.0, 240, TipoColor.marron, 750);
        Producto producto3 = new Articulo("A001", "armario doble puerta", proveedor3, 170.0, 140, TipoArticulo.armario);
        ArrayList<Producto> productosTienda1 = new ArrayList();
        productosTienda1.add(producto1);
        productosTienda1.add(producto2);
        productosTienda1.add(producto3);
        this.tienda = new Tienda("MercatWoods");
        this.tienda.setProductos(productosTienda1);
        this.sede.addTienda(this.tienda);
        Producto producto4 = new Tablero("T001", "Tablero 100x100 osb", proveedor1, 110.0, 220, 250, 130, TiposMadera.osb);
        Producto producto5 = new Barniz("B001", "Barniz 2L marron", proveedor2, 55.0, 92, TipoColor.marron, 5750);
        Producto producto6 = new Articulo("A001", "armario doble puerta", proveedor3, 65.0, 150, TipoArticulo.armario);
        Producto producto7 = new Tablero("T002", "Tablero 100x100 arce", proveedor1, 70.0, 150, 300, 150, TiposMadera.mdf);
        Producto producto8 = new Barniz("B002", "Barniz 2L marron", proveedor2, 85.0, 120, TipoColor.marron, 750);
        Producto producto9 = new Articulo("A002", "cama de matrimonio", proveedor3, 90.0, 150, TipoArticulo.cama);
        Producto producto10 = new Tablero("T003", "Tablero 100x100 contrachapado", proveedor1, 60.0, 150, 250, 150, TiposMadera.contrachapado);
        Producto producto11 = new Barniz("B003", "Barniz madera gris", proveedor2, 80.0, 120, TipoColor.gris, 750);
        Producto producto12 = new Articulo("A003", "cajonera", proveedor3, 120.0, 35, TipoArticulo.cajonera);
        ArrayList<Producto> productosTienda2 = new ArrayList();
        productosTienda2.add(producto4);
        productosTienda2.add(producto5);
        productosTienda2.add(producto6);
        productosTienda2.add(producto7);
        productosTienda2.add(producto8);
        productosTienda2.add(producto9);
        productosTienda2.add(producto10);
        productosTienda2.add(producto11);
        productosTienda2.add(producto12);
        this.tienda = new Tienda("Madericas");
        this.tienda.setProductos(productosTienda2);
        this.sede.addTienda(this.tienda);
        Producto producto13 = new Tablero("T003", "Tablero 250x150 contrachapado", proveedor1, 150.0, 180, 250, 150, TiposMadera.contrachapado);
        Producto producto14 = new Barniz("B003", "Barniz 10L gris", proveedor2, 180.0, 20, TipoColor.gris, 10000);
        Producto producto15 = new Articulo("A003", "cajonera", proveedor3, 150.0, 35, TipoArticulo.cajonera);
        ArrayList<Producto> productosTienda3 = new ArrayList();
        productosTienda3.add(producto13);
        productosTienda3.add(producto14);
        productosTienda3.add(producto15);
        this.tienda = new Tienda("Woodsap");
        this.tienda.setProductos(productosTienda3);
        this.sede.addTienda(this.tienda);
        Clientes clientes_1 = new Profesionales("ORION", "45783216A", 10.0);
        this.sede.addCustomers(clientes_1);
        Clientes clientes_2 = new Profesionales("XAVI", "36124857A", 15.0);
        this.sede.addCustomers(clientes_2);
        Clientes clientes_3 = new Profesionales("MANEL", "58327416A", 10.0);
        this.sede.addCustomers(clientes_3);
        Clientes clientes_4 = new Profesionales("DAVID", "43128576A", 20.0);
        this.sede.addCustomers(clientes_4);
        Clientes clientes_5 = new WoodFriend("GABRIELA", "82416357S", "00001");
        this.sede.addCustomers(clientes_5);
        Clientes clientes_6 = new WoodFriend("LUISINA", "31958642A", "00002");
        this.sede.addCustomers(clientes_6);
        Clientes clientes_7 = new WoodFriend("LUCIANO", "36124857B", "00003");
        this.sede.addCustomers(clientes_7);
        Clientes clientes_8 = new WoodFriend("LIDIA", "47615823T", "00004");
        this.sede.addCustomers(clientes_8);
        ArrayList<Clientes> clis = this.sede.getClientes();
        Clientes cli1 = (Clientes)clis.get(0);
        Clientes cli2 = (Clientes)clis.get(1);
        Clientes cli3 = (Clientes)clis.get(2);
        Clientes cli4 = (Clientes)clis.get(3);
        Clientes cli5 = (Clientes)clis.get(4);
        Clientes cli6 = (Clientes)clis.get(5);
        Clientes cli7 = (Clientes)clis.get(6);
        Clientes cli8 = (Clientes)clis.get(7);
        ArrayList<Tienda> tiendas = this.sede.getTiendas();
        Tienda shop1 = (Tienda)tiendas.get(0);
        Tienda shop2 = (Tienda)tiendas.get(1);
        Tienda shop3 = (Tienda)tiendas.get(2);
        shop1.setNomTienda("MercatWoods");
        shop2.setNomTienda("Madericas");
        shop3.setNomTienda("Wodsap");
        new ArrayList();
        LnaFactura lnaFactura1 = new LnaFactura(producto1, 6);
        LnaFactura lnaFactura2 = new LnaFactura(producto2, 3);
        LnaFactura lnaFactura3 = new LnaFactura(producto3, 9);
        LnaFactura lnaFactura4 = new LnaFactura(producto4, 7);
        LnaFactura lnaFactura5 = new LnaFactura(producto5, 2);
        LnaFactura lnaFactura6 = new LnaFactura(producto6, 4);
        LnaFactura lnaFactura7 = new LnaFactura(producto7, 5);
        LnaFactura lnaFactura8 = new LnaFactura(producto8, 1);
        LnaFactura lnaFactura9 = new LnaFactura(producto9, 8);
        Factura factura1 = new Factura("i0001", LocalDate.parse("11/05/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")), cli1, 10.0);
        factura1.addLnaFactura(lnaFactura1);
        factura1.addLnaFactura(lnaFactura2);
        shop1.addFactura(factura1);
        Factura factura2 = new Factura("i0002", LocalDate.parse("12/05/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")), cli2, 15.0);
        factura2.addLnaFactura(lnaFactura3);
        factura2.addLnaFactura(lnaFactura4);
        shop1.addFactura(factura2);
        Factura factura3 = new Factura("i0003", LocalDate.parse("13/05/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")), cli3, 10.0);
        factura3.addLnaFactura(lnaFactura5);
        factura3.addLnaFactura(lnaFactura6);
        shop1.addFactura(factura3);
        Factura factura4 = new Factura("i0004", LocalDate.parse("14/05/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")), cli4, 20.0);
        factura4.addLnaFactura(lnaFactura7);
        factura4.addLnaFactura(lnaFactura8);
        shop1.addFactura(factura4);
        int numFacturas = shop1.getFacturas().size();
        Factura factura5 = new Factura("i0001", LocalDate.parse("11/05/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")), cli1, 10.0);
        factura5.addLnaFactura(lnaFactura9);
        factura5.addLnaFactura(lnaFactura1);
        shop2.addFactura(factura5);
        Factura factura6 = new Factura("i0002", LocalDate.parse("12/05/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")), cli2, 15.0);
        factura6.addLnaFactura(lnaFactura2);
        factura6.addLnaFactura(lnaFactura3);
        shop2.addFactura(factura6);
        Factura factura7 = new Factura("i0003", LocalDate.parse("13/05/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")), cli3, 10.0);
        factura7.addLnaFactura(lnaFactura7);
        factura7.addLnaFactura(lnaFactura3);
        shop2.addFactura(factura7);
        Factura factura8 = new Factura("i0004", LocalDate.parse("14/05/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")), cli4, 20.0);
        factura8.addLnaFactura(lnaFactura4);
        factura8.addLnaFactura(lnaFactura8);
        shop2.addFactura(factura8);
        int NumFacturas = shop2.getFacturas().size();
        Factura factura9 = new Factura("i0001", LocalDate.parse("11/05/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")), cli1, 10.0);
        factura9.addLnaFactura(lnaFactura9);
        factura9.addLnaFactura(lnaFactura2);
        shop3.addFactura(factura9);
        Factura factura10 = new Factura("i0002", LocalDate.parse("12/05/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")), cli2, 15.0);
        factura10.addLnaFactura(lnaFactura4);
        factura10.addLnaFactura(lnaFactura1);
        shop3.addFactura(factura10);
        Factura factura11 = new Factura("i0003", LocalDate.parse("13/05/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")), cli3, 10.0);
        factura11.addLnaFactura(lnaFactura4);
        shop3.addFactura(factura11);
        Factura factura12 = new Factura("i0004", LocalDate.parse("14/05/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")), cli4, 20.0);
        factura12.addLnaFactura(lnaFactura8);
        shop3.addFactura(factura12);
    }
}

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package aa4_woodshops;

import java.util.ArrayList;
import java.util.Iterator;
    /**
     * Clase que representa la sede de la empresa.
     */
public class Sede {
    private ArrayList<Tienda> tiendas = new ArrayList();
    private ArrayList<Proveedor> proveedores = new ArrayList();
    private ArrayList<Clientes> clientes = new ArrayList();
    private ArrayList<Profesionales> profesional = new ArrayList();
    private ArrayList<WoodFriend> wf = new ArrayList();

    /**
     * Constructor por defecto de la clase Sede.
     */
    public Sede() {
    }
        /**
         * Constructor de la clase Sede que recibe las tiendas, proveedores y clientes.
         *
         * @param tiendas     las tiendas de la sede
         * @param proveedores los proveedores de la sede
         * @param clientes    los clientes de la sede
         */
        public Sede(ArrayList<Tienda> tiendas, ArrayList<Proveedor> proveedores, ArrayList<Clientes> clientes) {
            this.tiendas = tiendas;
            this.proveedores = proveedores;
            this.clientes = clientes;
        }

        /**
         * Añade una tienda a la sede.
         *
         * @param tienda la tienda a añadir
         */
        public void setTienda(Tienda tienda) {
            this.tiendas.add(tienda);
        }

        /**
         * Constructor de la clase Sede que recibe una lista de tiendas.
         *
         * @param tiendas las tiendas de la sede
         */
        public Sede(ArrayList<Tienda> tiendas) {
            this.tiendas = tiendas;
        }

        /**
         * Obtiene los proveedores de la sede.
         *
         * @return los proveedores de la sede
         */
        public ArrayList<Proveedor> getProveedores() {
            return this.proveedores;
        }

        /**
         * Establece los proveedores de la sede.
         *
         * @param proveedores los proveedores de la sede
         */
        public void setProveedores(ArrayList<Proveedor> proveedores) {
            this.proveedores = proveedores;
        }

        /**
         * Obtiene las tiendas de la sede.
         *
         * @return las tiendas de la sede
         */
        public ArrayList<Tienda> getTiendas() {
            return this.tiendas;
        }

        /**
         * Establece las tiendas de la sede.
         *
         * @param tiendas las tiendas de la sede
         */
        public void setTiendas(ArrayList<Tienda> tiendas) {
            this.tiendas = tiendas;
        }

        /**
         * Obtiene los clientes de la sede.
         *
         * @return los clientes de la sede
         */
        public ArrayList<Clientes> getClientes() {
            return this.clientes;
        }

        /**
         * Establece los clientes de la sede.
         *
         * @param clientes los clientes de la sede
         */
        public void setClientes(ArrayList<Clientes> clientes) {
            this.clientes = clientes;
        }

        /**
         * Obtiene una tienda de la sede por su nombre.
         *
         * @param nomTienda el nombre de la tienda a buscar
         * @return la tienda encontrada o null si no se encontró ninguna
         */
        public Tienda getTienda(String nomTienda) {
            boolean encontrado = false;
            Iterator<Tienda> it = this.tiendas.iterator();

            while(!encontrado && it.hasNext()) {
                Tienda tienda = (Tienda)it.next();
                if (tienda.getNomTienda().toUpperCase().equals(nomTienda.toUpperCase())) {
                    return tienda;
                }
            }

            return null;
        }

        /**
         * Asigna un artículo a una tienda.
         *
         * @param prod      el artículo a asignar
         * @param nomTienda el nombre de la tienda
         */
    public void asignarArticuloTienda(Producto prod, String nomTienda) {
        boolean encontrado = false;
        Iterator<Tienda> it = this.tiendas.iterator();

        while(!encontrado && it.hasNext()) {
            Tienda tienda = (Tienda)it.next();
            if (tienda.getNomTienda().toUpperCase().equals(nomTienda.toUpperCase())) {
                ArrayList<Producto> prods = tienda.getProductos();
                prods.add(prod);
                tienda.setProductos(prods);
                encontrado = true;
            }
        }

    }
        /**
         * Devuelve una representación en forma de cadena de la sede.
         *
         * @return la representación en forma de cadena de la sede
         */
    public String toString() {
        return "Sede{tiendas=" + this.tiendas + ", proveedores=" + this.proveedores + ", clientes=" + this.clientes + "}";
    }
        /**
         * Agrega un proveedor a la lista de proveedores.
         *
         * @param proveedor El proveedor a agregar.
         */
    public void addProveedor(Proveedor proveedor) {
        this.proveedores.add(proveedor);
    }
        /**
         * Agrega una tienda a la lista de tiendas.
         *
         * @param tienda La tienda a agregar.
         */
    public void addTienda(Tienda tienda) {
        this.tiendas.add(tienda);
    }
        /**
         * Obtiene la lista de profesionales.
         *
         * @return La lista de profesionales.
         */
    public ArrayList<Profesionales> getProfesional() {
        return this.profesional;
    }
        /**
         * Establece la lista de profesionales.
         *
         * @param profesional La lista de profesionales a establecer.
         */
    public void setProfesional(ArrayList<Profesionales> profesional) {
        this.profesional = profesional;
    }
        /**
         * Obtiene la lista de WoodFriends.
         *
         * @return La lista de WoodFriends.
         */
    public ArrayList<WoodFriend> getWf() {
        return this.wf;
    }
        /**
         * Establece la lista de WoodFriends.
         *
         * @param wf La lista de WoodFriends a establecer.
         */
    public void setWf(ArrayList<WoodFriend> wf) {
        this.wf = wf;
    }
        /**
         * Obtiene una lista de profesionales según el tipo de cliente especificado.
         *
         * @param tipoCliente El tipo de cliente para filtrar la lista.
         * @return Una lista de profesionales que coinciden con el tipo de cliente.
         */
    public ArrayList<Profesionales> getProfesionales(String tipoCliente) {
        ArrayList<Profesionales> profesionales = new ArrayList();
        // Lógica para filtrar la lista de profesionales según el tipo de cliente
        return profesionales;
    }
        /**
         * Obtiene una lista de WoodFriends según el tipo de cliente especificado.
         *
         * @param tipoCliente El tipo de cliente para filtrar la lista.
         * @return Una lista de WoodFriends que coinciden con el tipo de cliente.
         */
    public ArrayList<WoodFriend> getWoodFriends(String tipoCliente) {
        ArrayList<WoodFriend> woodFriends = new ArrayList();
        // Lógica para filtrar la lista de WoodFriends según el tipo de cliente
        return woodFriends;
    }
        /**
         * Agrega un profesional a la lista de profesionales.
         *
         * @param profesional El profesional a agregar.
         */
    public void addProfesionales(Profesionales profesional) {
        this.profesional.add(profesional);
    }
        /**
         * Agrega un cliente a la lista de clientes.
         *
         * @param clientes El cliente a agregar.
         */
    public void addCustomers(Clientes clientes) {
        this.clientes.add(clientes);
    }
        /**
         * Obtiene un cliente por su nombre.
         *
         * @param nomCliente El nombre del cliente a buscar.
         * @return El objeto Clientes correspondiente al nombre especificado, o null si no se encuentra.
         */
    public Clientes getCliente(String nomCliente) {
        Iterator<Clientes> it = this.clientes.iterator();

        Clientes cliente;
        do {
            if (!it.hasNext()) {
                return null;
            }

            cliente = (Clientes)it.next();
        } while(!cliente.getNombre().toUpperCase().equals(nomCliente.toUpperCase()));

        return cliente;
    }
}

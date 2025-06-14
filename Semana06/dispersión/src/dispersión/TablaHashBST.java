package dispersión;

public class TablaHashBST {
    private NodoBST[] tabla;
    private int capacidad;
    private int colisiones;

    public TablaHashBST(int capacidad) {
        this.capacidad = capacidad;
        tabla = new NodoBST[capacidad];
        colisiones = 0;
    }

    private int hash(String clave) {
        return Math.abs(clave.hashCode()) % capacidad;
    }

    public void insertar(Cliente cliente) {
        String clave = cliente.getClave();
        int indice = hash(clave);

        if (tabla[indice] == null) {
            tabla[indice] = new NodoBST(cliente);
        } else {
            colisiones++;
            insertarEnBST(tabla[indice], cliente);
        }
    }

    private void insertarEnBST(NodoBST nodo, Cliente cliente) {
        int comparacion = cliente.getClave().compareTo(nodo.cliente.getClave());
        
        if (comparacion < 0) {
            if (nodo.izquierda == null) {
                nodo.izquierda = new NodoBST(cliente);
            } else {
                insertarEnBST(nodo.izquierda, cliente);
            }
        } else if (comparacion > 0) {
            if (nodo.derecha == null) {
                nodo.derecha = new NodoBST(cliente);
            } else {
                insertarEnBST(nodo.derecha, cliente);
            }
        }
    }

    public Cliente buscar(String clave) {
        int indice = hash(clave);
        return buscarEnBST(tabla[indice], clave);
    }

    private Cliente buscarEnBST(NodoBST nodo, String clave) {
        if (nodo == null) return null;
        
        int comparacion = clave.compareTo(nodo.cliente.getClave());
        
        if (comparacion == 0) {
            return nodo.cliente;
        } else if (comparacion < 0) {
            return buscarEnBST(nodo.izquierda, clave);
        } else {
            return buscarEnBST(nodo.derecha, clave);
        }
    }

    public int getColisiones() {
        return colisiones;
    }
}
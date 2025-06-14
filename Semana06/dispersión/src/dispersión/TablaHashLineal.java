package dispersión;

public class TablaHashLineal {
    private Cliente[] tabla;
    private int capacidad;
    private int tamaño;
    private int colisiones;

    public TablaHashLineal(int capacidad) {
        this.capacidad = capacidad;
        tabla = new Cliente[capacidad];
        tamaño = 0;
        colisiones = 0;
    }

    private int hash(String clave) {
        return Math.abs(clave.hashCode()) % capacidad;
    }

    public void insertar(Cliente cliente) {
        if (tamaño == capacidad) {
            System.out.println("Tabla llena");
            return;
        }

        String clave = cliente.getClave();
        int indice = hash(clave);
        int indiceInicial = indice;

        while (tabla[indice] != null) {
            colisiones++;
            indice = (indice + 1) % capacidad;
            if (indice == indiceInicial) break; // Evitar bucle infinito
        }

        tabla[indice] = cliente;
        tamaño++;
    }

    public Cliente buscar(String clave) {
        int indice = hash(clave);
        int indiceInicial = indice;

        while (tabla[indice] != null) {
            if (tabla[indice].getClave().equals(clave)) {
                return tabla[indice];
            }
            indice = (indice + 1) % capacidad;
            if (indice == indiceInicial) break;
        }
        return null;
    }

    public int getColisiones() {
        return colisiones;
    }
}
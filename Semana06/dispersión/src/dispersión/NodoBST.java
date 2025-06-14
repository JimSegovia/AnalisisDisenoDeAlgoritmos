package dispersión;

public class NodoBST {
    Cliente cliente;
    NodoBST izquierda;
    NodoBST derecha;

    public NodoBST(Cliente cliente) {
        this.cliente = cliente;
        this.izquierda = null;
        this.derecha = null;
    }
}
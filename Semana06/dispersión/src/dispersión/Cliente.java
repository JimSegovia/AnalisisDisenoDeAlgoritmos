
package dispersión;

public class Cliente {
    private String codigo;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String correo;
    private String direccion;
    private String codigoPostal;

    public Cliente(String codigo, String nombres, String apellidos, 
                   String telefono, String correo, String direccion, 
                   String codigoPostal) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
    }

    public String getClave() {
        return nombres + " " + apellidos;  // Clave para el hash
    }
    
    @Override
    public String toString() {
        return nombres + " " + apellidos + " (" + codigo + ")";
    }

}
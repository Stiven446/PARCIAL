public class Cliente {
    private int idCliente;
    private String nombre;
    private String telefono;
    private String correo;

    public Cliente(int idCliente, String nombre, String telefono, String correo) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    public void registrarCliente() {
        System.out.println("Cliente registrado: " + nombre);
    }
}

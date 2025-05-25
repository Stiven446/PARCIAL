public class EstadoBicicleta {
    private int idEstado;
    private String nombreEstado;

    public EstadoBicicleta(int idEstado, String nombreEstado) {
        this.idEstado = idEstado;
        this.nombreEstado = nombreEstado;
    }

    public void obtenerEstado() {
        System.out.println("Estado: " + nombreEstado);
    }

    public void cambiarEstado(String estado) {
        this.nombreEstado = estado;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }
}


public class Bicicleta {
    protected int idBicicleta;
    protected String marca;
    protected String modelo;
    protected EstadoBicicleta estado;
    protected float costo;

    public Bicicleta(int idBicicleta, String marca, String modelo, EstadoBicicleta estado, float costo) {
        this.idBicicleta = idBicicleta;
        this.marca = marca;
        this.modelo = modelo;
        this.estado = estado;
        this.costo = costo;
    }

    public void cambiarEstado(EstadoBicicleta nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public void verificarEstado() {
        estado.obtenerEstado();
    }

    public void modificarDatos() {
        System.out.println("Modificando datos de la bicicleta genérica.");
    }

    public void mostrarTipo() {
        System.out.println("Tipo: Bicicleta genérica.");
    }
}


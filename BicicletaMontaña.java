public class BicicletaMontaña extends Bicicleta {
    private String tipoSuspension;

    public BicicletaMontaña(int idBicicleta, String marca, String modelo, EstadoBicicleta estado, float costo, String tipoSuspension) {
        super(idBicicleta, marca, modelo, estado, costo);
        this.tipoSuspension = tipoSuspension;
    }

    public void ajustarSuspension() {
        System.out.println("Ajustando suspensión: " + tipoSuspension);
    }

    @Override
    public void modificarDatos() {
        System.out.println("Modificando datos de bicicleta de montaña.");
    }

    @Override
    public void mostrarTipo() {
        System.out.println("Tipo: Bicicleta de montaña.");
    }
}

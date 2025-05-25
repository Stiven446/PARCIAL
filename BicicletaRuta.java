public class BicicletaRuta extends Bicicleta {
    private float peso;

    public BicicletaRuta(int idBicicleta, String marca, String modelo, EstadoBicicleta estado, float costo, float peso) {
        super(idBicicleta, marca, modelo, estado, costo);
        this.peso = peso;
    }

    public void medirAerodinámica() {
        System.out.println("Midiendo aerodinámica. Peso: " + peso + " kg");
    }

    @Override
    public void modificarDatos() {
        System.out.println("Modificando datos de bicicleta de ruta.");
    }

    @Override
    public void mostrarTipo() {
        System.out.println("Tipo: Bicicleta de ruta.");
    }
}

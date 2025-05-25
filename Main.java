import java.util.Date;

public class Main {
    public static void main(String[] args) {
        EstadoBicicleta estadoNueva = new EstadoBicicleta(1, "Nueva");
        EstadoBicicleta estadoUsada = new EstadoBicicleta(2, "Usada");

        Bicicleta bici1 = new BicicletaMontaña(101, "Trek", "X-Caliber", estadoNueva, 1000f, "Hidráulica");
        Bicicleta bici2 = new BicicletaRuta(102, "Giant", "Propel", estadoUsada, 1500f, 7.5f);

        // Polimorfismo: método sobrescrito se invoca dependiendo del objeto real
        bici1.modificarDatos(); // BicicletaMontaña
        bici2.modificarDatos(); // BicicletaRuta

        bici1.verificarEstado();
        bici2.verificarEstado();

        bici1.mostrarTipo(); // BicicletaMontaña
        bici2.mostrarTipo(); // BicicletaRuta

        Cliente cliente = new Cliente(1, "Carlos", "12345678", "carlos@email.com");
        cliente.registrarCliente();

        Alquiler alquiler = new Alquiler(1, new Date(2025 - 1900, 4, 20), new Date(2025 - 1900, 4, 25));
        alquiler.iniciarAlquiler();
        alquiler.finalizarAlquiler();
        alquiler.calcularCosto();
    }
}

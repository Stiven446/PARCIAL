import java.util.Date;

// Clase EstadoBicicleta
class EstadoBicicleta {
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

// Clase Bicicleta
class Bicicleta {
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

// Subclase BicicletaMontaña
class BicicletaMontaña extends Bicicleta {
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

// Subclase BicicletaRuta
class BicicletaRuta extends Bicicleta {
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

// Clase Cliente
class Cliente {
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

// Clase Alquiler
class Alquiler {
    private int idAlquiler;
    private Date fechaInicio;
    private Date fechaFin;

    public Alquiler(int idAlquiler, Date fechaInicio, Date fechaFin) {
        this.idAlquiler = idAlquiler;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public void iniciarAlquiler() {
        System.out.println("Alquiler iniciado el " + fechaInicio);
    }

    public void finalizarAlquiler() {
        System.out.println("Alquiler finalizado el " + fechaFin);
    }

    public void calcularCosto() {
        long dias = (fechaFin.getTime() - fechaInicio.getTime()) / (1000 * 60 * 60 * 24);
        float costo = dias * 50; // Costo diario estimado
        System.out.println("Costo total del alquiler: $" + costo);
    }
}

// Clase Main
public class SistemaAlquilerBicicletas {
    public static void main(String[] args) {
        EstadoBicicleta estadoNueva = new EstadoBicicleta(1, "Nueva");
        EstadoBicicleta estadoUsada = new EstadoBicicleta(2, "Usada");

        Bicicleta bici1 = new BicicletaMontaña(101, "Trek", "X-Caliber", estadoNueva, 1000f, "Hidráulica");
        Bicicleta bici2 = new BicicletaRuta(102, "Giant", "Propel", estadoUsada, 1500f, 7.5f);

        // Polimorfismo en acción
        bici1.modificarDatos();
        bici2.modificarDatos();

        bici1.verificarEstado();
        bici2.verificarEstado();

        bici1.mostrarTipo();
        bici2.mostrarTipo();

        Cliente cliente = new Cliente(1, "Carlos", "12345678", "carlos@email.com");
        cliente.registrarCliente();

        Alquiler alquiler = new Alquiler(1, new Date(2025 - 1900, 4, 20), new Date(2025 - 1900, 4, 25));
        alquiler.iniciarAlquiler();
        alquiler.finalizarAlquiler();
        alquiler.calcularCosto();
    }
}

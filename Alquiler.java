import java.util.Date;

public class Alquiler {
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
        float costo = dias * 50; // Suponiendo costo fijo diario
        System.out.println("Costo total del alquiler: $" + costo);
    }
}

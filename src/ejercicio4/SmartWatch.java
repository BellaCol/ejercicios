package ejercicio4;

public class SmartWatch extends SmartDevice {

    // Atributes
    Boolean monitorCardiaco;
    Boolean acelerometro;
    Boolean sensorTemperatura;
    Boolean brujula;
    Boolean gps;
    Boolean sensorOgenoEnSangre;



    // Constructors


    public SmartWatch() {

    }

    public SmartWatch(String color, String modelo, String marca, double pantalla, double peso, double precioDescuento,
                      Boolean bluethoo, double precio, Boolean monitorCardiaco, Boolean acelerometro,
                      Boolean sensorTemperatura, Boolean brujula, Boolean gps, Boolean sensorOgenoEnSangre) {
        super(color, modelo, marca, pantalla, peso, precioDescuento, bluethoo, precio);
        this.monitorCardiaco = monitorCardiaco;
        this.acelerometro = acelerometro;
        this.sensorTemperatura = sensorTemperatura;
        this.brujula = brujula;
        this.gps = gps;
        this.sensorOgenoEnSangre = sensorOgenoEnSangre;
    }
}






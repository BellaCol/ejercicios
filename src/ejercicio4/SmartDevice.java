package ejercicio4;

public abstract class  SmartDevice {

    //Atributes
    String color;
    String modelo;
    String marca;
    double pantalla;
    double peso;
    private double precioDescuento;
    Boolean bluethoo;
    double precio;



    // Constructors

    public SmartDevice() {

    }
    public SmartDevice(String color, String modelo, String marca, double pantalla, double peso) {
        this.color = color;
        this.modelo = modelo;
        this.marca = marca;
        this.pantalla = pantalla;
    }

    public SmartDevice(String color, String modelo, String marca, double pantalla, double peso, double precioDescuento, Boolean bluethoo, double precio) {
        this.color = color;
        this.modelo = modelo;
        this.marca = marca;
        this.pantalla = pantalla;
        this.peso = peso;
        this.precioDescuento = precioDescuento;
        this.bluethoo = bluethoo;
        this.precio = precio;
    }

    // Methodesc

    public double getPrecioDescuento() {
        return precioDescuento;
    }

    public void setPrecioDescuento(double precioConDescuento) {
      double descuento= ((precio-precioConDescuento)/precio)*100;
       if (descuento<15) {
           this.precioDescuento = precioConDescuento;
       } else if (descuento>=15 && descuento<30) {
           System.out.println("Requiere autorización del Gerente de Ventas, para dar un descuento mayor al 15%");
       } else if (descuento>=30 ){
           System.out.println("El descuento en el precio del equipo, no debe superar el 30%");
       }
    }





}

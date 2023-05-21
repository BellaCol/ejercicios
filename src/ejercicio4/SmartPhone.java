package ejercicio4;

public class SmartPhone extends SmartDevice  {

    int pixelsCamaraFrontal;
    int pixelsCamaraPosterior;
    Boolean dobleChip ;





    // Constructors
    public SmartPhone(){
    }

    public SmartPhone(String color, String modelo, String marca, double pantalla, double peso, double precioDescuento, Boolean bluethoo, double precio, int pixelsCamaraFrontal, int pixelsCamaraPosterior, Boolean dobleChip) {
        super(color, modelo, marca, pantalla, peso, precioDescuento, bluethoo, precio);
        this.pixelsCamaraFrontal = pixelsCamaraFrontal;
        this.pixelsCamaraPosterior = pixelsCamaraPosterior;
        this.dobleChip = dobleChip;
    }
}

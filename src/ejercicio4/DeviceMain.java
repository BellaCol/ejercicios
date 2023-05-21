package ejercicio4;

public class DeviceMain {

    public static void main(String[] args) {

        SmartPhone motorola = new SmartPhone("Negro", "MotoG", "Motorola", 13, 300,
                205, true, 210, 30, 15, true );
        SmartPhone iPhone = new SmartPhone("plateado", "IP20", "Apple", 18, 120,
                890, true, 900, 50, 80, false);
        SmartWatch watch1= new SmartWatch("rojo", "VC1", "Sansumg", 3, 50,
                145, true, 150, true, true, true,
                true, true, true);
        SmartWatch watch2= new SmartWatch("verde", "VC2", "Sansumg", 2, 40,
                105, true, 110, true, true, true,
                true, true, true);

        iPhone.setPrecioDescuento(400);

        System.out.println("Carac.Smart Phone " + motorola.modelo +": "+ motorola +" "+ motorola.getPrecioDescuento());
        System.out.println("Cara.téc. Smart Phone " + iPhone.modelo + ": " + iPhone + "/ precio con desc "
                + iPhone.getPrecioDescuento());
        System.out.println("Características técnicas del Smart Watch " + watch1.modelo + ": " + watch1);
        System.out.println("Características técnicas del Smart Watch " + watch2.modelo + ": " + watch2);



    }

}

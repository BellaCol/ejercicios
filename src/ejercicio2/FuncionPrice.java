package ejercicio2;

public class FuncionPrice {

    public static void main(String[] args) {

        double precio = getPrice(380);
        System.out.println("Precio con IVA:  " + precio);

    }

   static double getPrice(double price){
        return price * 1.14;
   }


}

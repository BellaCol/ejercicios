package ejercicio3;

public class BucleConcatena {
    public static void main(String[] args){
        String[] cadena1 = {"Hola", "Cerebro!", "que", "vamos", "a hacer", "esta", "noche?"};
        String[] cadena2 = {"Lo mismo", "que", "todas", "las noches", "Pinky,", "tratar", "de", "conquistar", "al", "Mundo!!!"};
        String resultado= "";
        String resultado2= "";
        String espacio = " ";
        int[]nuni= new int[10];
        for (int i = 0; i < 10; i++) {
            nuni[i] = 0;
        }


        for (String palabra: cadena1) {
            resultado = resultado + palabra + espacio;

        }
        for (String palabra: cadena2) {
            resultado2 = resultado2 + palabra + espacio;
        }
        System.out.println("Hablando Pinky: " + resultado);

    }
//    public static void main(String[] args){
//        int[]nuni= new int[10];
//        for (int i = 0; i < 10; i++) {
//            nuni[i] = i;
//            System.out.println(nuni);
//        }
//
//
//    }
}

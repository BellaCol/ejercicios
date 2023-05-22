package Ejercicio5;

public class CocheMain {

    public static void main(String[] args) {

        CocheCRUDImpl coche = new CocheCRUDImpl();
        coche.save();
        coche.findAll();
        coche.delete();

    }
}

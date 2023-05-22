package Ejercicio5;

public class CocheCRUDImpl implements CocheCRUD{
    @Override
    public void save() {
        System.out.println("El nombre de este método es save");

    }

    @Override
    public void findAll() {
        System.out.println("El nombre de este método es findAll");
    }

    @Override
    public void delete() {
        System.out.println("El nombre de este método es delete");
    }


}

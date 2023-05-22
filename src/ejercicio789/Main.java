package ejercicio789;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Vector;

import static com.sun.tools.attach.VirtualMachine.list;

public class Main {

    public static void main(String[] args) {

        //    Enunciado del ejercicio:
        //    Dada la función:
        //    Escribe el código que devuelva una cadena al revés. Por ejemplo, la cadena "hola mundo", debe retornar
        //    "odnum aloh".

        System.out.println("Ingrese una cadena de texto, para devolver su reverso: ");
        Scanner scanner = new Scanner( System.in);
        String cadenaAlDerecho = scanner.nextLine(); ;
        String resultado= devuelveAlReves(cadenaAlDerecho);//esta función está declarada al final de este main
        System.out.println(resultado);







        // 1.-  Crea un array unidimensional de Strings y recórrelo, mostrando únicamente sus valores.

        String[] ejercicio1 = {
                "Mi ",
                "nombre ",
                "es: ",
                "Bella ",
                "Kharina ",
                "Colmenares ",
                "Evoli"
        };

        for (String palabra : ejercicio1) {
            System.out.println(palabra);
        }


        //    2.- Crea un array bidimensional de enteros y recórrelo, mostrando la posición y el valor de
        //    cada elemento en ambas dimensiones.

        int[][] ejercicio2 = new int[2][4];
        ejercicio2[0][0] = 1;
        ejercicio2[0][1] = 2;
        ejercicio2[0][2] = 3;
        ejercicio2[0][3] = 4;
        ejercicio2[1][0] = 5;
        ejercicio2[1][1] = 6;
        ejercicio2[1][2] = 7;
        ejercicio2[1][3] = 8;

        for (int i = 0; i < ejercicio2.length; i++) {
            for (int j = 0; j < ejercicio2[i].length; j++) {
                System.out.println(ejercicio2[i][j]);
            }

        }

        //    3.- Crea un "Vector" del tipo de dato que prefieras, y añádele 5 elementos. Elimina el 2o y 3er elemento y
        //    muestra el resultado final.

        Vector<Integer> vector = new Vector();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        vector.add(5);

        vector.remove(1);
        vector.remove(1);

        System.out.println("Resultado del vector, después de remover el 2do y el 3er elemento: " + vector);

        //  4.- Indica cuál es el problema de utilizar un Vector con la capacidad por defecto si tuviésemos 1000 elementos
        //    para ser añadidos al mismo.

        //  Respuesta: el problema, es que se genera 100 veces una operación costosa (que duplica el consumo de memoria),
        //  que es el resize o ampliación del vector, el cual por defecto tiene una capacidad inicial de 10 elementos.
        //  Es decir cada vez que la cantidad de datos introducidos supera la capacidad del vector, se genera una copia
        //  del mismo, pero con una longitud ampliada de 10 posiciones adicionales. Y esa operación se repite 100 veces,
        //  hasta que el vector (ampliándose de 10 en 10) llega a tener la capacidad de 1000 elementos.



        //  5.- Crea un ArrayList de tipo String, con 4 elementos. Cópialo en una LinkedList. Recorre ambos mostrando
        //  únicamente el valor de cada elemento.


        // el ArrayList es más rápido para almacenar y buscar datos

        ArrayList<String> arrayLista =  new ArrayList();
        arrayLista.add("Yo");
        arrayLista.add("soy");
        arrayLista.add("un");
        arrayLista.add("ArrayList");

        for (String palabra : arrayLista) {
            System.out.println(palabra);
        }
        System.out.println("Imprimiendo por consola un arrayList: " + arrayLista);

        // el LinkedList es más rápido para modificar datos

        LinkedList<String> linkedLista =  new LinkedList(arrayLista);
        for (String palabra : arrayLista) {
            System.out.println(palabra);
        }
        System.out.println("Imprimiendo por consola un LinkedList, que copia al ArrayList anterior: " + arrayLista);



        // 6.- Crea un ArrayList de tipo int, y, utilizando un bucle rellénalo con elementos 1..10. A continuación, con
        // otro bucle, recórrelo y elimina los numeros pares. Por último, vuelve a recorrerlo y muestra el ArrayList final.
        //Si te atreves, puedes hacerlo en menos pasos, siempre y cuando cumplas el primer "for" de relleno.

        ArrayList<Integer> numeros = new ArrayList();
        for (int i = 1; i <= 10; i++) {
            numeros.add(i);
        }
        ArrayList aux = numeros;
        System.out.println(aux);

        for (int i = 0; i < aux.size() ; i++) {
            int aux1 = aux.get(i).hashCode();//hashCode devuelve el entero
            if (aux1 % 2 == 0) {
                aux.remove(i);
                i--;
            }else {
                System.out.println(aux.get(i));
            }
        }
        System.out.println(aux);



        //7.- Crea una función DividePorCero. Esta, debe generar una excepción ("throws") a su llamante del tipo
        // ArithmeticException que será capturada por su llamante (desde "main", por ejemplo). Si se dispara la
        // excepción, mostraremos el mensaje "Esto no puede hacerse". Finalmente, mostraremos en cualquier caso:
        // "Demo de código".

        try{
            float result = divPorCero(5,0);
            System.out.println("el resultado es: " + result);
        } catch (ArithmeticException e){
            System.out.println("Introduce un número diferente de cero, en el divisor (" + e.getClass() + ")");
        }finally{
            System.out.println("Esto es una Demo");
        }

        //8.-Utilizando InputStream y PrintStream, crea una función que reciba dos parámetros: "fileIn" y "fileOut".
        // La tarea de la función será realizar la copia del fichero dado en el parámetro "fileIn" al fichero dado en
        // "fileOut".

        try{

            InputStream fileIn = new FileInputStream ("C:\\Users\\Lenovo\\democitoBelliBelli6.txt");
            PrintStream fileOut = new PrintStream ("C:\\Users\\Lenovo\\democitoBelliBelli7.txt");

            //try{
                copiaFichero(fileIn, fileOut);
                fileIn.close();
                fileOut.close();
            //}catch (IOException e){
             //   System.out.println("Error: " + e.getMessage());
            //}

        }catch(FileNotFoundException e){
            System.out.println("El fichero no existe: " +  e.getMessage());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }




    }

    public static String devuelveAlReves (String cadenaDeTexto){
        String alReves = "";
        for (int i = cadenaDeTexto.length()-1; i >=0; i--) {

            alReves += cadenaDeTexto.charAt(i);

        }

        return(alReves);

    }


    public static float divPorCero  (int num1, int num2)throws ArithmeticException{
        try{

            return (num1/num2);
        }catch (ArithmeticException e){
            throw new ArithmeticException();
        }
        
    }

    public static void copiaFichero (InputStream in, PrintStream out) throws IOException {
        //try {
            //InputStream in= new FileInputStream("C:\\Users\\Lenovo\\democitoBelliBelli6.txt");
            byte[] datos = in.readAllBytes();

            //PrintStream out1 = new PrintStream("destino.txt");
            out.write(datos);
        //} catch (Exception e) {
       //     System.out.println("");
       // }
    }
}









/*

//            InputStream fichero= new FileInputStream("C:\\Users\\Lenovo\\democitoBelliBelli6.txt");
//            BufferedInputStream ficheroBuffer= new BufferedInputStream(fichero);


            //try {
              //  int dato= ficheroBuffer.read();
//                while(dato!= -1){
//                    info6.write(dato);
//                    System.out.println((char)dato);
//                    dato= ficheroBuffer.read();
//
//                }
//            }catch (IOException e){
//                System.out.println("No se puede leer fichero" + e.getMessage());
//            }



try{

            PrintStream info = new PrintStream ("democitoBelliBelli.txt");
            File info1 = new File ("democitoBelliBelli1.txt");
            info.println("Hola la mas preciosa");
            info.close();
            PrintStream info3 = new PrintStream ("democitoBelliBelli3ccd.txt");
            File info4 = new File ("democitoBelliBelli4.txt");
            info4.createNewFile();
            File info5 = new File ("C:\\Users\\Lenovo\\democitoBelliBelli5.txt");
            info5.createNewFile();
            PrintStream info6 = new PrintStream ("C:\\Users\\Lenovo\\democitoBelliBelli6.txt");
            String path= info1.getPath();
            String abstracto = info1.getAbsolutePath();
            String canonico= info1.getCanonicalPath();
            System.out.println(path);
            System.out.println(abstracto);
            System.out.println(canonico);


            if (info1.createNewFile()) {
                System.out.println("The file is created with the name: " + info1.getName());
                String path1= info1.getPath();
                String abstracto1 = info1.getAbsolutePath();
                String canonico1= info1.getCanonicalPath();
                System.out.println(path);
                System.out.println(abstracto);
                System.out.println(canonico);

            } else {
                System.out.println("The file already exists.");
            }

        }catch(Exception e){
            System.out.println(" eee");
        }
        //System.out.println("Imprimiendo por consola el fichero: " + "democitoBelliBelli.txt");
        //String path= info1.getPath();
        //String abstracto = info1.getAbsolutePath();
        //String canonico= info1.getCanonicalPath();






/*

import java.io.File;
import java.io.IOException;

public class Main {
  public static void main(String[] args) {

    //Try catch block
    try {

      //Creating a file with the name demofile.txt
      File myFile = new File("demofile.txt");

      if (myFile.createNewFile()) {
        System.out.println("The file is created with the name: " + myFile.getName());
      } else {
        System.out.println("The file already exists.");
      }
    } catch (IOException x) {
      System.out.println("An error is encountered.");
      x.printStackTrace();
    }
  }
}




import java.io.FileWriter;
import java.io.IOException;

        public class Main {
            public static void main(String[] args) {
                try {
                    //create an object
                    FileWriter writeInFile = new FileWriter("demofile.txt");

                    //Adding content to this file
                    writeInFile.write("We are learning about paths in Java.");

                    writeInFile.close();
                    System.out.println("Successfully done!");
                } catch (IOException x) {
                    System.out.println("An error is encountered.");
                    x.printStackTrace();
                }
            }
        }
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;  //scanner class for reading the file

        public class Main {
            public static void main(String[] args) {
                try {
                    File myFile = new File("demofile.txt");

                    //create the scanner object
                    Scanner readFile = new Scanner(myFile);

                    while (readFile.hasNextLine()) {
                        String data = readFile.nextLine();
                        System.out.println(data);
                    }
                    readFile.close();
                } catch (FileNotFoundException x) {
                    System.out.println("An error occurred.");
                    x.printStackTrace();
                }
            }
        }

import java.io.*;
        public class Main {
            public static void main(String args[]){
                try {
                    //create an object
                    File myFile = new File("demo.txt");

                    //call the getPath() method
                    String path = myFile.getPath();
                    System.out.println("The path of this file is: " + path);
                }
                catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }

//import the java.io library
import java.io.*;

        public class Main {
            public static void main(String args[])
            {
                // try catch block
                try {
                    // create the file object
                    File myFile = new File("pathdemo.txt");

                    // call the getAbsolutePath() method
                    String absolutePath = myFile.getAbsolutePath();

                    System.out.println("The Absolute path of the file is: "+ absolutePath);
                }
                catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }


//import the java.io library
import java.io.*;

        public class Main {
            public static void main(String args[])
            {
                // try catch block
                try {
                    // create the file object
                    File myFile = new File("C:\\Users");

                    // call the getCanonicalPath() method
                    String canonical = myFile.getCanonicalPath();

                    System.out.println("The Canonical path is : "+ canonical);
                }
                catch (Exception x) {
                    System.err.println(x.getMessage());
                }
            }*/

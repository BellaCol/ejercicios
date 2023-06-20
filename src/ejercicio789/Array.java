package ejercicio789;
import java.io.*;
import java.util.*;
//9.-Sorpréndenos creando un programa de tu elección que utilice InputStream, PrintStream, excepciones, un
// HashMap y un ArrayList, LinkedList o array.
//
public class Array {
    static HashMap<String, List> mapa = new HashMap<>();
    static HashMap<String, List> mapa1 = new HashMap<>();
    public static void main(String[] args) {


        System.out.println("Desea crear una base de datos [1], o desea hacer CRUD de una BD existente [2]? ");
        Scanner scannerSioNo = new Scanner(System.in);
        int SioNo = scannerSioNo.nextInt();

        String[] preguntas = {

                "1.- DNI",
                "2.- Nombre y Apellido: ",
                "3.- Sexo: ",
                "4.- Pais: ",
                "5.- Antecedentes: ",

        };

        if (SioNo == 1) {
            System.out.println("Introduzca la cantidad de personas a ingresar: ");
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();


            String[][] datosPersona = new String[n][5];

            for (int i = 0; i < n; i++) {
                System.out.println("Introduzca datos de persona " + (i+1) + ":");
                int cont=0;
                for (String pregunta : preguntas) {
                    System.out.println(pregunta);
                    Scanner scannerRespuesta = new Scanner(System.in);
                    String respuesta = scannerRespuesta.nextLine();
                    datosPersona[i][cont]=(respuesta);
                    cont++;
                }
            }
                try {
                    FileWriter baseDeDatosPMB = new FileWriter("personasMasBuscadas.txt");
                    BufferedWriter fb = new BufferedWriter(baseDeDatosPMB);
                    //fb.write(Arrays.stream(preguntas).toList() +"\n");
                    baseDeDatosPMB.write(Arrays.stream(preguntas).toList().toString()+"\n");
                    String[] persona= new String[5] ;
                    for (int i=0; i< datosPersona.length; i++){
                        for (int j=0; j<5; j++){
                        persona[j] = datosPersona[i][j];
                        }
                        baseDeDatosPMB.write(Arrays.stream(persona).toList().toString()+"\n");
                    }
                 baseDeDatosPMB.close();
                } catch (IOException e) {
                    System.out.println("Error al buscar el archivo" + e.getMessage());
                }
        }else if (SioNo == 2) {
                System.out.println("Buscar personas  [1]");
                System.out.println("Ingresar persona [2]");
                System.out.println("Eliminar persona [3]");
                System.out.println("Salir del sistema [4]");

                Scanner scannerOpcion = new Scanner(System.in);
                int opcion = scannerOpcion.nextInt();


                    if (opcion == 1) {

                        System.out.println("Ingrese la cantidad de personas a buscar en la basede datos de los mas " +
                                "buscados: ");
                        Scanner scannerCantRegistro = new Scanner(System.in);
                        int n1 = scannerCantRegistro.nextInt();
                        String[] grupoBusqueda = new String[n1];
                        for (int i = 0; i < n1; i++) {

                            System.out.println("Ingrese el DNI: ");
                            Scanner scannerGrupRegistBusqueda = new Scanner(System.in);
                            String dniVarios = scannerGrupRegistBusqueda.nextLine();
                            grupoBusqueda[i] = dniVarios;
                        }
                        String[] personis;
                        try {
                            FileReader lectura = new FileReader("personasMasBuscadas.txt");
                            BufferedReader fichero = new BufferedReader(lectura);
                            String[] encabezado = fichero.readLine().split(",");
                            String linea = "";

                            while (linea != null) {

                                linea = fichero.readLine();

                                if (linea != null) {

                                    String prub = linea.replace("[", "");
                                    String prub2 = prub.replace("]", "");
                                    linea = prub2;
                                    personis = linea.split(",");

                                    for (int i = 0; i < grupoBusqueda.length; i++) {

                                        String dni = grupoBusqueda[i];
                                        String dniBD = personis[0];
                                        if (dni.compareTo(dniBD) == 0 ) {
                                            mapa.put(dni.toString(), Arrays.stream(personis).toList());
                                        }
                                    }
                                }
                            }

                            lectura.close();
                            fichero.close();
                            System.out.println("Este es el resultado de su busqueda");
                            System.out.println(Arrays.stream(encabezado).toList());
                            for (Map.Entry elemento : mapa.entrySet()) {
                                System.out.println("DNI buscado: " + elemento.getKey() + ", Datos:" +
                                        elemento.getValue());
                            }
                            //System.out.println(mapa);
                            System.out.println("Las personas que no se muestran por pantalla, no se encuentran en la " +
                                    "Base de Datos");

                        } catch (IOException e) {
                            System.out.println("Error" + e.getMessage());
                        }
                    }else if (opcion ==2) {

                        System.out.println("Introduzca la cantidad de personas a ingresar: ");
                        Scanner scanner = new Scanner(System.in);
                        int n = scanner.nextInt();

                        String[][] datosPersona = new String[n][5];

                        for (int i = 0; i < n; i++) {
                            System.out.println("Introduzca datos de persona " + (i + 1) + ":");
                            int cont = 0;
                            for (String pregunta : preguntas) {
                                System.out.println(pregunta);
                                Scanner scannerRespuesta = new Scanner(System.in);
                                String respuesta = scannerRespuesta.nextLine();
                                datosPersona[i][cont] = (respuesta);
                                cont++;
                            }
                        }

                        BufferedWriter bw = null;
                        FileWriter fw = null;

                        try {


                            // File file = new File("personasMasBuscadas.txt");
                            // Si el archivo no existe, se crea!
//                            if (!file.exists()) {
//                                file.createNewFile();
//                            }
                            // flag true, indica adjuntar información al archivo.
                            fw = new FileWriter("personasMasBuscadas.txt", true);
                            bw = new BufferedWriter(fw);

                            String[] persona1 = new String[5];
                            for (int i = 0; i < datosPersona.length; i++) {
                                for (int j = 0; j < 5; j++) {
                                    persona1[j] = datosPersona[i][j];
                                }
                                bw.write(Arrays.stream(persona1).toList().toString() + "\n");
                            }

                            //Cierra instancias de FileWriter y BufferedWriter
                            if (bw != null)
                                bw.close();
                            if (fw != null)
                                fw.close();

                            System.out.println("información agregada!");

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    } else if (opcion == 3) {

                        Boolean llave4 = true;
                        int contador = 0;
                        System.out.println("Ingrese la cantidad de personas a eliminar de la basede datos de los mas buscados: ");
                        Scanner scannerNPersonasEliminar = new Scanner(System.in);
                        int n3 = scannerNPersonasEliminar.nextInt();
                        String[] grupoEliminar = new String[n3];
                        for (int i = 0; i < n3; i++) {

                            System.out.println("Ingrese el DNI: ");
                            Scanner scannerGrupRegistBusqueda1 = new Scanner(System.in);
                            String dniVarios1 = scannerGrupRegistBusqueda1.nextLine();
                            grupoEliminar[i] = dniVarios1;
                        }

                        try {
                            FileReader lectura2 = new FileReader("personasMasBuscadas.txt");
                            BufferedReader fichero2 = new BufferedReader(lectura2);
                            String encabezado1=fichero2.readLine();
                            long cantidadLineas= fichero2.lines().count();
                            fichero2.close();
                            lectura2.close();
                            FileReader lectura3 = new FileReader("personasMasBuscadas.txt");
                            BufferedReader fichero3 = new BufferedReader(lectura3);
                            fichero3.readLine();
                            String linea = "";
                            String[] personaBD = new String[0];
                            String[] temporal = new String[(int)cantidadLineas];
                            while (linea != null) {
                                llave4 = true;
                                linea = fichero3.readLine();

                                if (linea != null) {
                                    String prub5 = linea.replace("[", "");
                                    String prub6 = prub5.replace("]", "");
                                    linea = prub6;
                                    personaBD = linea.split(",");

                                    for (int i = 0; i < grupoEliminar.length; i++) {
                                        String dni = grupoEliminar[i];
                                        String dniBD = personaBD[0];
                                        if (dni.compareTo(dniBD) == 0) {
                                            llave4 = false;
                                            System.out.println();
                                            mapa1.put(dni.toString(), Arrays.stream(personaBD).toList());
                                        }
                                    }
                                }
                                if (llave4 == true & linea != null) {

                                    temporal[contador] = linea;

                                    contador++;
                                }
                            }

                            lectura3.close();
                            fichero3.close();

                            FileWriter baseDatoEditada = new FileWriter("personasMasBuscadas.txt");
                            BufferedWriter fbd = new BufferedWriter(baseDatoEditada);
                            baseDatoEditada.write(Arrays.stream(preguntas).toList() + "\n");

                                for(String linea11: temporal){
                                    if(linea11!=null){
                                    baseDatoEditada.write("["+linea11+"]" + "\n");
                                    }
                                }


                            
                            baseDatoEditada.close();
                            fbd.close();
                            System.out.println("Los datos de las personas indicadas, han sido eliminados de" +
                                    " la Base de Datos");
                            System.out.println(encabezado1);
                            for (Map.Entry elemento : mapa1.entrySet()) {
                                System.out.println("DNI eliminado: " + elemento.getKey() + ", Datos:" +
                                        elemento.getValue());
                            }

                        } catch (IOException e) {
                            System.out.println("Error" + e.getMessage());
                        }

                    } else if (opcion == 4) {
                        while(opcion == 4){
                            System.out.println("saliendo del sistema");
                            break;
                        }



                    } else {
                        System.out.println("introduzca un número del 1 al 4");
                    }

        }
    }
}

















//System.out.println("Este es el resultado de su busqueda, para el dni: "+ dni);
//System.out.println(Arrays.stream(encabezado).toList());
//System.out.println(Arrays.stream(personis).toList());

//                             int ki=0;
//Como comparar 2 valores de dos posiciones de 2 arrays.?
//System.out.println(Arrays.stream(personis).toList());
//System.out.println(personis[ki]);
//System.out.println((grupoBusqueda[i]));
// sdvsddfbfdg
//System.out.println(grupoBusqueda.length);
//System.out.println(dni);
//System.out.println(personis[0].split(",")[0]);
//System.out.println(personis.length);
//grupoPersonasIngreso.add(mapa);
//System.out.println(grupoPersonasIngreso.toString());
//System.out.println(Arrays.stream(personis).spliterator();
//                                System.out.println(Arrays.stream(personis).toList());
//                                String [] personis2= new String[personis.length];
//                                for(int i=0; i<personis2.length; i++){
//                                  personis2[i]=personis[i];
//                            }
//PBM = personas mas buscadas
//import javax.print.DocFlavor;
//import java.nio.charset.StandardCharsets;
//
//ArrayList<HashMap<Integer, String[][]>> grupoPersonasIngreso = new ArrayList();
//  ArrayList<String[][]> grupoDatos = new ArrayList<>();
//                            for (String elemento1 : encabezado) {
//                                System.out.println(elemento1);
//                            }
//String dniBD = "";

//                for (int j=0; j< grupoDatos.size(); j++){
//                    System.out.println(j);
//                    System.out.println(Arrays.stream(grupoDatos.get(j)).toList());
//                    System.out.println("hasta aqui 1");
//                }

//                       ArrayList<String> personasSolicitadas = new ArrayList();

                 /*   try {
                        InputStream grupoRegistrosBusqueda = new FileInputStream("personasMasBuscadas.txt") {
                        //InputStream in= new FileInputStream("C:\\Users\\Lenovo\\democitoBelliBelli6.txt");
                            Hash datos = grupoRegistrosBusqueda;
                            grupoRegistrosBusqueda.close();

                            //PrintStream out1 = new PrintStream("destino.txt");
                            out.write(datos);
                    }catch (FileNotFoundException e) {
                        System.out.println("Error al buscar el archivo" + e.getMessage());
                    }
                    }catch (IOException e) {
                        System.out.println("Error al buscar el archivo" + e.getMessage());
                    }*/

//                    for (HashMap hash : grupoPersonasIngreso) {
//                            System.out.println("Valor de la vuelta  del array2: " + hash);
//                            }
//                            System.out.println(grupoPersonasIngreso.get(i));
//
//                            for (Map.Entry elemento : mapa.entrySet()) {
//                            System.out.println(elemento.getKey() + " " + elemento.getValue());
//                            }
//                            System.out.println(mapa);
//




        //for(MapEntry element: mapa.entrySet()) {}





/*


        try{

            InputStream fileIn = new FileInputStream("C:\\Users\\Lenovo\\democitoBelliBelli6.txt");
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

        ArrayList<Integer> numeros = new ArrayList();
        for (int i = 1; i <= 10; i++) {
            numeros.add(i);
        }
        ArrayList aux = numeros;
        System.out.println(aux);

        for (int i = 0; i < aux.size() ; i++) {
            int aux1 = aux.get(i).hashCode();
            if (aux1 % 2 == 0) {
                aux.remove(i);
                i--;
            }else {
                System.out.println(aux.get(i));
            }
        }
        System.out.println(aux);

        // el LinkedList es más rápido para modificar datos

        LinkedList<String> linkedLista =  new LinkedList(arrayLista);
        for (String palabra : arrayLista) {
            System.out.println(palabra);
        }
        System.out.println("Imprimiendo por consola un LinkedList, que copia al ArrayList anterior: " + arrayLista);



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
    }*/




import java.util.*;
import java.io.*;


public class Main {

    Scanner leer = new Scanner(System.in);
    Artista cab,p,q;
    Perros_Calientes cab1,r,s;
    Paginas_Amarillas cab2,t,u;
    Curso cab3,x,y;
    int opc;
    //int codigo=0;
    int numeroArtistas=0;
    File cargar = new File("C:\\Users\\Brayan\\IdeaProjects\\Proyecto_Listas\\Txt_Artista\\Artista.txt");
    public Main()
    {
        menuPrincipal();
    }

    public void menuPrincipal()
    {
        int opc;
        System.out.println("\nMENU PRINCIPAL");
        System.out.println("1. Listas simples");
        System.out.println("2. Listas circulares");
        System.out.println("3. Listas dobles");
        System.out.println("4. Listas circulares dobles");
        System.out.println("5. Terminar");

        System.out.println("");
        System.out.println("Escoja la opcion:");
        opc = Integer.parseInt(leer.nextLine());

        switch (opc) {
            case 1:
                menuListasSimples();
                menuPrincipal();
                break;

            case 2:
                menuListasCirculares();
                menuPrincipal();
                break;

            case 3:
                menuListasDobles();
                menuPrincipal();
                break;

            case 4:
                menuListasCircularesDobles();
                menuPrincipal();
                break;

            case 5:
                System.exit(0);
                break;

            default:
                menuPrincipal();
        }
    }

    public void menuListasSimples()
    {
        int opc;
        System.out.println("\nMENU LISTAS SIMPLES");
        System.out.println("1. Crear listas simples");
        System.out.println("2. Adicionar listas simples.");
        System.out.println("3. Eliminar listas simples");
        System.out.println("4. Modificar listas simples");
        System.out.println("5. Imprimir listas simples");
        System.out.println("6. Imprimir listas simples impares");
        System.out.println("7. Reportes listas simples");
        System.out.println("8. Volver.");

        System.out.println("\nEscoja una opcion: ");
        opc = Integer.parseInt(leer.nextLine());

        switch (opc) {
            case 1:
                //crearListasSimples();
                cargarArtistasTxt();
                menuListasSimples();
                break;

            case 2:
                menuAdicionarListasSimples();
                menuListasSimples();
                break;

            case 3:
                menuEliminarListasSimples();
                menuListasSimples();
                break;

            case 4:
                modificarListasSimples();
                menuListasSimples();
                break;

            case 5:
                imprimirListasSimples();
                menuListasSimples();
                break;
            case 6:
                imprimirArtistasImpares();
                menuListasSimples();
            case 7:
                menuReportesListasSimples();
                menuListasSimples();
                break;

            case 8:
                menuPrincipal();
                break;

            default:
                menuListasSimples();
        }
    }

    public void crearListasSimples()
    {
        q = new Artista("Luis","peruano",23);
        cab=q;
        p=q;

        q = new Artista("Elsa","japonesa",45);
        p.sig=q;
        p=q;

        q = new Artista("Gabriel","aleman",58);
        p.sig=q;
        p=q;

        q = new Artista("Estela","india",18);
        p.sig=q;
        p=q;

        q = new Artista("Brayan","colombiano",19);
        p.sig=q;
        p=q;

        q = new Artista("Dylan","colombiano",75);
        p.sig=q;
        p=q;

        /*try (PrintWriter writer = new PrintWriter(cargar)) {
            p = cab;

            while (p != null) {
                writer.println( p.getNombre());
                writer.println(p.getNacionalidad());
                writer.println(p.getEdad());
                p = p.sig;
            }

            System.out.println("Lista de artistas guardada en el archivo correctamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }*/
    }

    public void imprimirArtistasImpares()
    {
        if (cab == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        int contador = 1;
        p = cab;

        while (p != null) {
            System.out.println("\nId: " + contador);
            System.out.println("Nombre: " + p.getNombre());
            System.out.println("Nacionalidad: " + p.getNacionalidad());
            System.out.println("Edad: " + p.getEdad());

            if (p.sig != null) {
                p = p.sig.sig;
                contador += 2;
            } else {
                break;
            }
        }

    }

    public void cargarArtistasTxt() {

        int cont;
        String nombre;
        String nacionalidad;
        int edad;
        String linea = " ";
        int contadorListas = 1;

        try {
            FileReader reader = new FileReader(cargar);
            BufferedReader bufer = new BufferedReader(reader);

            linea = bufer.readLine();
            System.out.println(linea);
            cont = Integer.parseInt(linea);

            for (int i = 0; i < cont; i++) {
                nombre = bufer.readLine();
                nacionalidad = bufer.readLine();
                edad = Integer.parseInt(bufer.readLine());

                q = new Artista(nombre, nacionalidad, edad);

                if (contadorListas == 1) {
                    cab = q;
                    p = q;
                    contadorListas = 2;
                } else {
                    p.sig = q;
                    p = q;
                }
            }
            System.out.println("La información se ha cargado correctamente desde el archivo.");

        } catch (FileNotFoundException e) {
            System.out.println("Error: Archivo no encontrado.");

        } catch (IOException e) {
            System.out.println("Error: Problema de lectura del archivo.");

        } catch (NumberFormatException e) {
            System.out.println("Error: Formato incorrecto en el archivo.");
        }
    }

    public void menuReportesListasSimples()
    {
        int opc;

        System.out.println("\nMENÚ REPORTES LISTAS SIMPLES");
        System.out.println("1. Mostrar número de artistas");
        System.out.println("2. Encontrar artista por caracter alfabético");
        System.out.println("3. Mostrar artista joven y viejo");
        System.out.println("4. Mostrar artistas por nacionalidad (colombiano)");
        System.out.println("5. Volver");

        System.out.println("\nEscoja una opción");
        opc = Integer.parseInt(leer.nextLine());

        switch (opc){
            case 1:
                numeroArtistas();
                menuReportesListasSimples();
                break;
            case 2:
                encontrarArtistaPorCaracterAlfabetico();
                menuReportesListasSimples();
                break;
            case 3:
                artistaJovenYViejo();
                menuReportesListasSimples();
                break;
            case 4:
                mostrarArtistasPorNacionalidadColombiana();
                menuReportesListasSimples();
                break;
            case 5:
                menuListasSimples();
                break;
            default:
                menuReportesListasSimples();
                break;
        }
    }

    public void numeroArtistas()
    {
        numeroArtistas=0;

        p=cab;
        while (p!=null)
        {
            p=p.sig;
            numeroArtistas++;
        }
        System.out.println("El número de artistas es de: " + numeroArtistas);
    }

    public void encontrarArtistaPorCaracterAlfabetico()
    {
        if (cab == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        String caracterAlfabetico;
        p = cab;

        System.out.println("Ingrese la letra por la cual desea buscar los nombres");
        caracterAlfabetico = leer.nextLine().toUpperCase(); // Convertir a mayúsculas para hacer la comparación insensible a mayúsculas/minúsculas

        while (p != null) {
            if (Character.toUpperCase(caracterAlfabetico.charAt(0)) == Character.toUpperCase(p.getNombre().charAt(0))) {
                System.out.println(p.toString());
            }
            p = p.sig;
        }
    }

    public void artistaJovenYViejo()
    {
        if (cab == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        p = cab;
        Artista artistaJoven = p;
        Artista artistaViejo = p;

        while (p != null) {
            if (p.getEdad() < artistaJoven.getEdad()) {
                artistaJoven = p;
            }

            if (p.getEdad() > artistaViejo.getEdad()) {
                artistaViejo = p;
            }

            p = p.sig;
        }

        System.out.println("\nARTISTA MÁS JOVEN:");
        System.out.println("Nombre: " + artistaJoven.getNombre());
        System.out.println("Edad: " + artistaJoven.getEdad());
        System.out.println("Nacionalidad: " + artistaJoven.getNacionalidad());
        System.out.println("");

        System.out.println("\nARTISTA MÁS VIEJO:");
        System.out.println("Nombre: " + artistaViejo.getNombre());
        System.out.println("Edad: " + artistaViejo.getEdad());
        System.out.println("Nacionalidad: " + artistaViejo.getNacionalidad());
    }

    public void mostrarArtistasPorNacionalidadColombiana()
    {
        if (cab == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        p = cab;
        boolean encontrados = false;

        while (p != null) {
            if (p.getNacionalidad().compareToIgnoreCase("colombiano")==0) {
                System.out.println("\nNombre: " + p.getNombre());
                System.out.println("Nacionalidad: " + p.getNacionalidad());
                System.out.println("Edad: " + p.getEdad());
                encontrados = true;
            }
            p = p.sig;
        }

        if (!encontrados) {
            System.out.println("No hay artistas con nacionalidad colombiana/o en la lista.");
        }

    }

    public void menuAdicionarListasSimples()
    {
        int opc;
        System.out.println("\nMENU ADICIONAR LISTAS SIMPLES");
        System.out.println("1. Adicionar por el inicio listas simples.");
        System.out.println("2. Adicionar por el fin listas simples.");
        System.out.println("3. Adicionar antes de nodo listas simples");
        System.out.println("4. Adicionar despues de nodo listas simples");
        System.out.println("5. Volver.");

        System.out.println("\nEscoja una opcion:");
        opc = Integer.parseInt(leer.nextLine());

        switch (opc) {
            case 1:
                adicionarInicioListasSimples();
                menuAdicionarListasSimples();
                break;

            case 2:
                adicionarFinListasSimples();
                menuAdicionarListasSimples();
                break;

            case 3:
                adicionarAntesListasSimples();
                menuAdicionarListasSimples();
                break;

            case 4:
                adicionarDespuesListasSimples();
                menuAdicionarListasSimples();
                break;

            case 5:
                menuListasSimples();
                break;

            default:
                menuAdicionarListasSimples();
                break;
        }
    }

    public void adicionarInicioListasSimples()
    {
        String nombre, nacimiento;
        int edad;
        System.out.println("Digite el nombre del artista: ");
        nombre=leer.nextLine();

        System.out.println("Digite la nacionalidad del artista: ");
        nacimiento=leer.nextLine();

        System.out.println("Digite edad del artista: ");
        edad = Integer.parseInt(leer.nextLine());

        q=new Artista(nombre,nacimiento, edad);
        q.sig=cab;
        cab=q;
    }

    public void adicionarFinListasSimples()
    {
        String nombre, nacimiento;
        int edad;
        System.out.println("Digite el nombre del artista: ");
        nombre=leer.nextLine();
        System.out.println("Digite la nacionalidad del artista: ");
        nacimiento=leer.nextLine();
        System.out.println("Digite la edad del artista: ");
        edad = Integer.parseInt(leer.nextLine());

        q=new Artista(nombre,nacimiento, edad);
        p=cab;
        while(p.sig!=null)
            p=p.sig;
        p.sig=q;
    }

    public void adicionarAntesListasSimples()
    {
        Artista m;
        String nombre, nacimiento;
        int edad;
        String dato;

        p=cab;
        System.out.println("Digite el nombre a buscar para adicionar antes del mismo ");
        dato=leer.nextLine();
        if(p.getNombre().compareToIgnoreCase(dato)==0)
        {
            adicionarInicioListasSimples();
        }
        else
        {

            System.out.println("Digite el nombre del artista: ");
            nombre=leer.nextLine();
            System.out.println("Digite la nacionalidad del artista: ");
            nacimiento=leer.nextLine();
            System.out.println("Digite fecha nacimientoe del artista: ");
            edad = Integer.parseInt(leer.nextLine());

            q=new Artista(nombre,nacimiento, edad);
            p=cab.sig;
            m=cab;
            while(p.getNombre().compareToIgnoreCase(dato)!=0 && p.sig!=null)
            {
                m=p;
                p=p.sig;
            }
            if(p.getNombre().compareToIgnoreCase(dato)==0)
            {
                q.sig=p;
                m.sig=q;
            }
            else
                System.out.println("El nombre buscado no se encuentra en la lista");

        }

    }

    public void adicionarDespuesListasSimples()
    {
        Artista m;
        String nombre, nacionalidad;
        int edad;
        String dato;

        p = cab;
        System.out.println("Digite el nombre a buscar para adicionar despues del mismo: ");
        dato = leer.nextLine();

        System.out.println("Digite el nombre del artista a agregar: ");
        nombre = leer.nextLine();

        System.out.println("Digite la nacionalidad del artista: ");
        nacionalidad = leer.nextLine();

        System.out.println("Digite edad del artista: ");
        edad = Integer.parseInt(leer.nextLine());

        q = new Artista(nombre, nacionalidad, edad);

        while (p != null && !p.getNombre().equalsIgnoreCase(dato)) {
            p = p.sig;
        }

        if (p != null) {
            q.sig = p.sig;
            p.sig = q;
        } else {
            System.out.println("El nombre buscado no se encuentra en la lista.");
        }
    }

    public void menuEliminarListasSimples()
    {
        int opc;
        System.out.println("\nMENU ELIMINAR LISTAS SIMPLES");
        System.out.println("1. Eliminar por el inicio listas simples.");
        System.out.println("2. Eliminar por el fin listas simples.");
        System.out.println("3. Eliminar antes de nodo listas simples");
        System.out.println("4. Eliminar despues de nodo listas simples");
        System.out.println("5. Eliminar nodo dado listas simples.");
        System.out.println("6. Volver.");

        System.out.println("\nEscoja una opcion;");
        opc =Integer.parseInt(leer.nextLine());

        switch (opc) {
            case 1:
                eliminarInicioListasSimples();
                menuEliminarListasSimples();
                break;

            case 2:
                eliminarFinListasSimples();
                menuEliminarListasSimples();
                break;

            case 3:
                eliminarAntesListasSimples();
                menuEliminarListasSimples();
                break;

            case 4:
                eliminarDespuesListasSimples();
                menuEliminarListasSimples();
                break;

            case 5:
                eliminarNodoDadoListasSimples();
                menuEliminarListasSimples();
                break;

            case 6:
                menuListasSimples();
                break;

            default:
                menuEliminarListasSimples();
                break;
        }
    }

    public void eliminarInicioListasSimples()
    {
        if (cab == null) {
            System.out.println("La lista está vacía, no se puede eliminar.");
        } else {
            p = cab;
            cab = cab.sig;
            p.sig = null;
        }
    }

    public void eliminarFinListasSimples()
    {
        if (cab == null) {
            System.out.println("La lista está vacía, no se puede eliminar.");
        } else if (cab.sig == null) {
            cab = null; // Si solo hay un nodo en la lista
        } else {
            Artista u = cab;
            while (u.sig.sig != null)
            {
                u = u.sig;
            }
            u.sig = null;
        }
    }

    public void eliminarAntesListasSimples()
    {
        String dato;
        Artista nodoAnterior = null;
        Artista nodoAnteriorAnterior = null;
        boolean encontrado = false;

        System.out.println("Ingrese el nombre a buscar para eliminar su anterior: ");
        dato = leer.nextLine();
        p = cab;

        if (cab == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        if (cab.getNombre().compareToIgnoreCase(dato) == 0) {
            System.out.println("No existe nodo anterior a eliminar.");
            return;
        } else if (p.sig == null) {
            System.out.println("La lista solo contiene un elemento.");
            return;
        } else if (p.sig.getNombre().compareToIgnoreCase(dato) == 0) {
            eliminarInicioListasSimples();
            System.out.println("Se ha eliminado el nodo correctamente");
            return;
        } else {
            while (p != null) {
                if (p.sig != null && p.sig.sig != null && p.sig.sig.getNombre().compareToIgnoreCase(dato) == 0) {
                    nodoAnteriorAnterior = p;
                    nodoAnterior = p.sig;
                    nodoAnteriorAnterior.sig = nodoAnteriorAnterior.sig.sig;
                    nodoAnterior = null;
                    encontrado = true;
                    System.out.println("Se eliminó el nodo correctamente.");
                    break;
                }
                p = p.sig;
            }
        }

        if (!encontrado) {
            System.out.println("El artista con el nombre ingresado no existe en la lista.");
        }

    }

    public void eliminarDespuesListasSimples()
    {
        if (cab == null || cab.sig == null) {
            System.out.println("No se puede eliminar después, la lista está vacía o tiene un solo elemento.");
        } else {
            System.out.println("Digite el nombre del nodo para eliminar su siguiente: ");
            String dato = leer.nextLine();

            Artista u = cab;
            while (u != null && !u.getNombre().equalsIgnoreCase(dato)) {
                u = u.sig;
            }

            if (u != null && u.sig != null) {
                u.sig = u.sig.sig; // Se elimina el nodo después de 'temp'
            } else {
                System.out.println("El nodo después del nombre buscado no se encuentra en la lista.");
            }
        }
    }

    public void eliminarNodoDadoListasSimples()
    {
        String valor;
        Artista u;
        System.out.println("Digite el nombre a eliminar: ");
        valor = leer.nextLine();

        p=cab;
        while (p.getNombre().compareToIgnoreCase(valor)!=0 && p.sig !=null)
            p= p.sig;
        if (p.getNombre().compareToIgnoreCase(cab.getNombre())==0)
            eliminarInicioListasSimples();

        else if (p.getNombre().compareToIgnoreCase(valor)==0 && p.sig==null)
            eliminarFinListasSimples();

        else if (p.getNombre().compareToIgnoreCase(valor)==0)
        {
            u=cab;
            while(u.sig.getNombre().compareToIgnoreCase(valor)!=0)
                u= u.sig;
            u.sig=p.sig;
        }
        else
            System.out.println("El valor no existe");
    }

    public void modificarListasSimples()
    {
        String nombre,nacionalidad;
        int edad;
        String dato;
        System.out.println("Digite el nombre del artista a modificar: ");
        dato=leer.nextLine();

        Artista q = cab;
        boolean encontrado = false;

        while (q != null) {
            if(q.getNombre().compareToIgnoreCase(dato)==0) {
                encontrado = true;
                int opcion;
                System.out.println("\n1. Cambiar nombre");
                System.out.println("2. Cambiar nacionalidad");
                System.out.println("3. Cambiar edad");
                System.out.println("4. Cambiar todos los datos");
                System.out.println("\nEscoja una opción: ");

                opcion = Integer.parseInt(leer.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese el nuevo nombre del artista: ");
                        nombre = leer.nextLine();
                        q.setNombre(nombre);
                        break;
                    case 2:
                        System.out.println("Ingrese la nueva nacionalidad del artista: ");
                        nacionalidad= leer.nextLine();
                        q.setNacionalidad(nacionalidad);
                        break;
                    case 3:
                        System.out.println("Ingrese la nueva edad del artista: ");
                        edad= Integer.parseInt(leer.nextLine());
                        q.setEdad(edad);
                        break;
                    case 4:
                        System.out.println("Ingrese el nuevo nombre del artista: ");
                        nombre = leer.nextLine();
                        q.setNombre(nombre);

                        System.out.println("Ingrese la nueva nacionalidad del artista: ");
                        nacionalidad= leer.nextLine();
                        q.setNacionalidad(nacionalidad);

                        System.out.println("Ingrese la nueva edad del artista: ");
                        edad= Integer.parseInt(leer.nextLine());
                        q.setEdad(edad);
                        break;
                }
                System.out.println("Se ha modificado el artista con nombre: " + dato);
                break;
            }
            q = q.sig;
        }
        if (!encontrado) {
            System.out.println("El artista con el nombre " + dato + " no se encuentra en la lista.");
        }
    }

    public void imprimirListasSimples()
    {
        p=cab;
        while (p!=null)
        {
            System.out.println("\nNombre: "+ p.getNombre());
            System.out.println("Nacionalidad: "+ p.getNacionalidad());
            System.out.println("Edad: "+ p.getEdad());
            //System.out.println("p : "+ p.getSig());
            p=p.sig;
        }
    }

    public void menuListasCirculares()
    {
        int opc;
        String valor;
        System.out.println("\nMENU LISTAS CIRCULARES");
        System.out.println("1. Crear listas circulares");
        System.out.println("2. Adicionar listas circulares");
        System.out.println("3. Eliminar listas circulares");
        System.out.println("4. Modificar listas circulares");
        System.out.println("5. Imprimir listas circulares");
        System.out.println("6. Reportes listas circulares");
        System.out.println("7. Volver.");

        System.out.println("\nEscoja una opcion");
        valor= leer.nextLine();
        opc=Integer.parseInt(valor);
        switch (opc) {
            case 1:
                crearListasCirculares();
                menuListasCirculares();
                break;

            case 2:
                menuAdicionarListasCirculares();
                menuListasCirculares();
                break;

            case 3:
                menuEliminarListasCirculares();
                menuListasCirculares();
                break;

            case 4:
                modificarListasCirculares();
                menuListasCirculares();
                break;

            case 5:
                imprimirListasCirculares();
                menuListasCirculares();
                break;
            case 6:
                menuReportesListasCirculares();
                menuListasCirculares();
            case 7:
                menuPrincipal();
                break;

            default:
                menuListasCirculares();
        }
    }

    public void crearListasCirculares(){

        cab1 = new Perros_Calientes("Juan Delgadillo", "peruano", 78.3, 3.2,16, "adulto");
        cab1.siguiente = cab1;
        r = new Perros_Calientes("Luang Xion", "chino", 65.4, 4.6,23, "junior");
        s = cab1;
        s.siguiente = r;
        r.siguiente = cab1;
        s = r;
        r = new Perros_Calientes("Robert Conti", "italiano",67.8 ,3.6 ,18, "junior");
        s.siguiente = r;
        r.siguiente = cab1;

    }

    public void menuReportesListasCirculares()
    {
        int opc;

        System.out.println("\nMENÚ REPORTES LISTAS CIRCULARES");
        System.out.println("1. Mostrar lista de los participantes registrados según su categoria");
        System.out.println("2. Mostrar participante que menos perros ha consumido");
        System.out.println("3. Buscar participante por su nombre");
        System.out.println("4. Buscar participante más veloz en toda la competencia");
        System.out.println("5. Buscar el participante más eficiente en toda la competencia");
        System.out.println("6. Volver");

        System.out.println("\nEscoja una opción");
        opc = Integer.parseInt(leer.nextLine());

        switch (opc){
            case 1:
                mostrarParticipantesRegistradosSegunSuCategoria();
                menuReportesListasCirculares();
                break;
            case 2:
                mostrarParticipanteMenosPerrosConsumidos();
                menuReportesListasCirculares();
                break;
            case 3:
                buscarParticipantePorNombre();
                menuReportesListasCirculares();
                break;
            case 4:
                buscarParticipanteMasVeloz();
                menuReportesListasCirculares();
                break;
            case 5:
                buscarPartcipanteMasEficiente();
                menuReportesListasCirculares();
                break;
            case 6:
                menuListasCirculares();
                break;
            default:
                menuReportesListasCirculares();
                break;
        }
    }

    public void mostrarParticipantesRegistradosSegunSuCategoria()
    {
        final String CATEGORIA_JUNIOR = "junior";
        final String CATEGORIA_ADULTO = "adulto";

        if (cab1 == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        s = cab1;
        boolean hayParticipantesJunior = false;
        boolean hayParticipantesAdulto = false;

        System.out.println("\nPARTICIPANTES DE CATEGORIA JUNIOR: ");
        do {
            if (s.getCategoria().compareToIgnoreCase(CATEGORIA_JUNIOR) == 0) {
                System.out.println("\nNombre: " + s.getNombre());
                System.out.println("Nacionalidad: " + s.getNacionalidad());
                System.out.println("Peso: " + s.getPeso());
                System.out.println("Velocidad de ingestión: " + s.getVelocidadIngestion());
                System.out.println("Perros consumidos: " + s.getPerrosConsumidos());
                System.out.println("Categoria: " + s.getCategoria());
                hayParticipantesJunior = true;
            }
            s = s.getSiguiente();
        } while (s != cab1);

        s = cab1;

        System.out.println("\nPARTICIPANTES DE CATEGORIA ADULTO: ");
        do {
            if (s.getCategoria().compareToIgnoreCase(CATEGORIA_ADULTO) == 0) {
                System.out.println("\nNombre: " + s.getNombre());
                System.out.println("Nacionalidad: " + s.getNacionalidad());
                System.out.println("Peso: " + s.getPeso());
                System.out.println("Velocidad de ingestión: " + s.getVelocidadIngestion());
                System.out.println("Perros consumidos: " + s.getPerrosConsumidos());
                System.out.println("Categoria: " + s.getCategoria());
                hayParticipantesAdulto = true;
            }
            s = s.getSiguiente();
        } while (s != cab1);

        if (!hayParticipantesJunior) {
            System.out.println("No hay participantes en la categoría Junior.");
        }

        if (!hayParticipantesAdulto) {
            System.out.println("No hay participantes en la categoría Adulto.");
        }
    }


    public void mostrarParticipanteMenosPerrosConsumidos()
    {
        if (cab1 == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        s = cab1;
        Perros_Calientes participanteMenosPerrosConsumidos = s;

        while (s.getSiguiente() != cab1) {
            s = s.getSiguiente();
            if (s.getPerrosConsumidos() < participanteMenosPerrosConsumidos.getPerrosConsumidos()) {
                participanteMenosPerrosConsumidos = s;
            }
        }

        System.out.println("\nParticipante que ha consumido menos perros calientes:");
        System.out.println("\nNombre: " + participanteMenosPerrosConsumidos.getNombre());
        System.out.println("Nacionalidad: " + participanteMenosPerrosConsumidos.getNacionalidad());
        System.out.println("Peso: " + participanteMenosPerrosConsumidos.getPeso());
        System.out.println("Velocidad de ingestión: " + participanteMenosPerrosConsumidos.getVelocidadIngestion());
        System.out.println("Perros consumidos: " + participanteMenosPerrosConsumidos.getPerrosConsumidos());
        System.out.println("Categoría: " + participanteMenosPerrosConsumidos.getCategoria());
    }

    public void buscarParticipantePorNombre()
    {
        if (cab1 == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        String dato;
        System.out.println("Digite el nombre del participante a buscar: ");
        dato = leer.nextLine();
        s = cab1;
        boolean encontrado = false;

        do {
            if (s.getNombre().compareToIgnoreCase(dato) == 0) {
                System.out.println("\nParticipante encontrado:");
                System.out.println("\nNombre: " + s.getNombre());
                System.out.println("Nacionalidad: " + s.getNacionalidad());
                System.out.println("Peso: " + s.getPeso());
                System.out.println("Velocidad de ingestión: " + s.getVelocidadIngestion());
                System.out.println("Perros consumidos: " + s.getPerrosConsumidos());
                System.out.println("Categoría: " + s.getCategoria());
                encontrado = true;
                break;
            }
            s = s.getSiguiente();
        } while (s != cab1);

        if (!encontrado) {
            System.out.println("Participante no encontrado con el nombre: " + dato);
        }
    }

    public void buscarParticipanteMasVeloz()
    {
        if (cab1 == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        s = cab1;
        Perros_Calientes participanteMasVeloz = s;

        do {
            if (s.getPerrosConsumidos() > participanteMasVeloz.getPerrosConsumidos()) {
                participanteMasVeloz = s;
            }
            s = s.getSiguiente();
        } while (s != cab1);

        System.out.println("\nParticipante más veloz:");
        System.out.println("\nNombre: " + participanteMasVeloz.getNombre());
        System.out.println("Nacionalidad: " + participanteMasVeloz.getNacionalidad());
        System.out.println("Peso: " + participanteMasVeloz.getPeso());
        System.out.println("Velocidad de ingestión: " + participanteMasVeloz.getVelocidadIngestion());
        System.out.println("Perros consumidos: " + participanteMasVeloz.getPerrosConsumidos());
        System.out.println("Categoría: " + participanteMasVeloz.getCategoria());
    }

    public void buscarPartcipanteMasEficiente()
    {
        if (cab1 == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        final double PESO_PERROCALIENTE = 1.5; // Peso del perro caliente (constante)
        s = cab1;
        Perros_Calientes participanteMasEficiente = s;
        double eficienciaMasAlta = s.getPerrosConsumidos() * PESO_PERROCALIENTE / s.getPeso();

        do {
            double eficienciaActual = s.getPerrosConsumidos() * PESO_PERROCALIENTE / s.getPeso();
            if (eficienciaActual > eficienciaMasAlta) {
                eficienciaMasAlta = eficienciaActual;
                participanteMasEficiente = s;
            }
            s = s.getSiguiente();
        } while (s != cab1);

        System.out.println("\nParticipante más eficiente:");
        System.out.println("\nNombre: " + participanteMasEficiente.getNombre());
        System.out.println("Nacionalidad: " + participanteMasEficiente.getNacionalidad());
        System.out.println("Peso: " + participanteMasEficiente.getPeso());
        System.out.println("Velocidad de ingestión: " + participanteMasEficiente.getVelocidadIngestion());
        System.out.println("Perros consumidos: " + participanteMasEficiente.getPerrosConsumidos());
        System.out.println("Eficiencia: " + eficienciaMasAlta);
        System.out.println("Categoría: " + participanteMasEficiente.getCategoria());
    }

    public void menuAdicionarListasCirculares(){
        int opc;
        String valor;
        System.out.println("\nMENU ADICIONAR LISTAS CIRCULARES");
        System.out.println("1. Adicionar por el inicio listas circulares.");
        System.out.println("2. Adicionar por el fin listas circulares.");
        System.out.println("3. Adicionar antes de nodo listas circulares");
        System.out.println("4. Adicionar despues de nodo listas circulares");
        System.out.println("5. Volver.");
        System.out.println("\nEscoja una opcion;");
        valor= leer.nextLine();
        opc=Integer.parseInt(valor);

        switch (opc) {
            case 1:
                adicionarInicioListasCirculares();
                menuAdicionarListasCirculares();
                break;

            case 2:
                adicionarFinListasCirculares();
                menuAdicionarListasCirculares();
                break;

            case 3:
                adicionaranterioresListasCirculares();
                menuAdicionarListasCirculares();
                break;

            case 4:
                adicionarDespuesListasCirculares();
                imprimirListasCirculares();
                menuAdicionarListasCirculares();
                break;

            case 5:
                menuListasCirculares();
                break;

            default:
                menuAdicionarListasCirculares();
                break;
        }
    }
    public void adicionarInicioListasCirculares()
    {

        s = cab1;
        r = new Perros_Calientes("Sofia Reina", "mexicana",63.0 ,5.2 ,31, "adulto");
        while(s.siguiente!=cab1)
            s=s.siguiente;
        r.siguiente=cab1;
        s.siguiente=r;
        cab1=r;

        System.out.println("Se ha añadido correctamente un participante");
    }
    public void adicionarFinListasCirculares()
    {
        s = cab1;
        r = new Perros_Calientes("Sofia Reina", "mexicana",63.0 ,5.2 ,31, "adulto");
        while(s.siguiente!=cab1)
            s=s.siguiente;
        r.siguiente=cab1;
        s.siguiente=r;

        System.out.println("Se ha añadido correctamente un participante");
    }

    public void adicionaranterioresListasCirculares()
    {
        Perros_Calientes opc;
        String valor;
        System.out.println("Digite el nombre a buscar");
        valor = leer.nextLine();

        s = cab1;
        r = new Perros_Calientes("Sofia reina", "mexicana",63.0 ,5.2 ,31, "adulto");

        if(s.getNombre().compareToIgnoreCase(valor)==0 )
        {
            r.siguiente=cab1;
            while(s.siguiente!=cab1)
                s=s.siguiente;
            s.siguiente=r;
            cab1=r;
        }
        else
        {
            s=s.siguiente;
            opc=cab1;
            while (s.getNombre().compareToIgnoreCase(valor)!=0 && s.siguiente!= cab1)
            {
                opc=s;
                s = s.siguiente;
            }
            if(s.getNombre().compareToIgnoreCase(valor)==0 )
            {
                r.siguiente = s;
                opc.siguiente = r;
            }
            else{
                System.out.println("El participanteriore no se encuentra en la lista");
            }
        }

    }
    public void adicionarDespuesListasCirculares(){
        String valor;
        System.out.println("Digite el nombre a buscar");
        valor = leer.nextLine();

        s = cab1;

        while (s.getNombre().compareToIgnoreCase(valor)!=0 && s.siguiente!= cab1){
            s = s.siguiente;
        }

        if(s.getNombre().compareToIgnoreCase(valor)==0 && s.siguiente== cab1){
            r = new Perros_Calientes("Sofia reina", "mexicana",63.0 ,5.2 ,31, "adulto");
            s.siguiente = r;
            r.siguiente = cab1;

        }else {
            if(s.getNombre().compareToIgnoreCase(valor)==0 && s.siguiente != cab1){
                r = new Perros_Calientes("Sofia reina", "mexicana",63.0 ,5.2 ,31, "adulto");
                r.siguiente = s.siguiente;
                s.siguiente = r;

            }else{
                System.out.println("El participanteriore no se encuentra en la lista");
            }
        }



    }
    public void menuEliminarListasCirculares(){
        int opc;
        System.out.println("\nMENU ELIMINAR LISTAS CIRCULARES");
        System.out.println("1. Eliminar por el inicio listas circulares.");
        System.out.println("2. Eliminar por el fin listas circulares.");
        System.out.println("3. Eliminar antes de nodo listas circulares");
        System.out.println("4. Eliminar despues de nodo listas circulares");
        System.out.println("5. Eliminar nodo dado listas circulares.");
        System.out.println("6. Volver.");

        System.out.println("\nEscoja una opcion;");
        opc =Integer.parseInt(leer.nextLine());

        switch (opc) {
            case 1:
                eliminarInicioListasCirculares();
                menuEliminarListasCirculares();
                break;

            case 2:
                eliminarFinListasCirculares();
                menuEliminarListasCirculares();
                break;

            case 3:
                eliminaranterioresListasCirculares();
                menuEliminarListasCirculares();
                break;

            case 4:
                eliminarDespuesListasCirculares();
                menuEliminarListasCirculares();
                break;

            case 5:
                eliminarNodoDadoListasCirculares();
                menuEliminarListasCirculares();
                break;

            case 6:
                menuListasCirculares();
                break;

            default:
                menuEliminarListasCirculares();
                break;
        }

    }

    public void eliminarInicioListasCirculares()
    {
        s = cab1;
        while (s.siguiente != cab1)
            s = s.siguiente;
        s.siguiente = cab1.siguiente;
        cab1 = cab1.siguiente;
    }

    public void eliminarFinListasCirculares()
    {
        s = cab1;
        while (s.siguiente.siguiente != cab1)
            s = s.siguiente;
        s.siguiente = cab1;
    }

    public void eliminaranterioresListasCirculares()
    {
        String dato;
        System.out.println("Digite el dato a eliminar");
        dato = leer.nextLine();
        s = cab1;
        if(dato.compareToIgnoreCase(s.getNombre() )== 0)

            System.out.println("no existe anterior para eliminar");

        else {
            s = s.siguiente;
            if(dato.compareToIgnoreCase(s.getNombre() )== 0){

                eliminarInicioListasCirculares();

            }
            else{

                Perros_Calientes opc = cab1;
                s = s.siguiente;

                while (dato.compareToIgnoreCase(s.getNombre() ) != 0 && s.siguiente != cab1)
                {
                    s = s.siguiente;
                    opc = opc.siguiente;
                }

                if (dato.compareToIgnoreCase(s.getNombre()) ==0)

                    opc.siguiente = s;
                else{

                    System.out.println("EL DATO NO EXISTE");
                }

            }
        }
    }

    public void eliminarDespuesListasCirculares()
    {
        String valor;
        System.out.println("Digite el nombre a buscar: ");
        valor = leer.nextLine();
        s=cab1;
        while (s.getNombre().compareToIgnoreCase(valor)!=0 && s.siguiente!=cab1)
            s= s.siguiente;
        if(s.getNombre().compareToIgnoreCase(valor)==0 && s.siguiente.siguiente ==cab1)
            s.siguiente=cab1;
        else
        if(s.getNombre().compareToIgnoreCase(valor)==0 && s.siguiente==cab1)
            eliminarInicioListasCirculares();
        else
        if(s.getNombre().compareToIgnoreCase(valor)==0)
            s.siguiente=s.siguiente.siguiente;
        else
            System.out.println("El valor no existe");

    }

    public void eliminarNodoDadoListasCirculares()
    {
        String valor;
        Perros_Calientes t;
        System.out.println("Digite el nombre a eliminar: ");
        valor = leer.nextLine();
        s=cab1;
        while (s.getNombre().compareToIgnoreCase(valor)!=0 && s.siguiente !=cab1)
            s= s.siguiente;
        if(s.getNombre().compareToIgnoreCase(cab1.getNombre())==0)
            eliminarInicioListasCirculares();
        else
        if(s.getNombre().compareToIgnoreCase(valor)==0 && s.siguiente==cab1)
            eliminarFinListasCirculares();
        else
        if(s.getNombre().compareToIgnoreCase(valor)==0)
        {
            t=cab1;
            while(t.siguiente.getNombre().compareToIgnoreCase(valor)!=0)
                t= t.siguiente;
            t.siguiente=s.siguiente;

        }
        else
            System.out.println("El valor no existe");
    }

    public void modificarListasCirculares()
    {
        String nombre, nacionalidad, categoria;
        double peso, velocidadIngestion;
        int perroConsumidos;
        String dato;

        System.out.println("Digite el nombre del perro caliente a modificar: ");
        dato=leer.nextLine();

        r = cab1;
        boolean encontrado = false;

        do {
            if (r.getNombre().compareToIgnoreCase(dato)==0) {
                encontrado = true;
                int opcion;
                System.out.println("1. Cambiar nombre");
                System.out.println("2. Cambiar nacionalidad");
                System.out.println("3. Cambiar peso");
                System.out.println("4. Cambiar velocidad de ingestión");
                System.out.println("5. Cambiar cantidad de perros consumidos");
                System.out.println("6. Cambiar categoría");
                System.out.println("7. Cambiar todos los datos");
                System.out.println("\nEscoja una opción: ");

                opcion = Integer.parseInt(leer.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese el nuevo nombre del perro caliente: ");
                        nombre = leer.nextLine();
                        r.setNombre(nombre);
                        break;
                    case 2:
                        System.out.println("Ingrese la nueva nacionalidad del perro caliente: ");
                        nacionalidad = leer.nextLine();
                        r.setNacionalidad(nacionalidad);
                        break;
                    case 3:
                        System.out.println("Ingrese el nuevo peso del perro caliente (x.x): ");
                        peso = Double.parseDouble(leer.nextLine());
                        r.setPeso(peso);
                        break;
                    case 4:
                        System.out.println("Ingrese la nueva velocidad de ingestión del perro caliente (x.x): ");
                        velocidadIngestion = Double.parseDouble(leer.nextLine());
                        r.setVelocidadIngestion(velocidadIngestion);
                        break;
                    case 5:
                        System.out.println("Ingrese la nueva cantidad de perros consumidos: ");
                        perroConsumidos = Integer.parseInt(leer.nextLine());
                        r.setPerrosConsumidos(perroConsumidos);
                        break;
                    case 6:
                        System.out.println("Ingrese la nueva categoría del perro caliente: ");
                        categoria = leer.nextLine();
                        r.setCategoria(categoria);
                        break;
                    case 7:
                        System.out.println("Ingrese el nuevo nombre del perro caliente: ");
                        nombre = leer.nextLine();
                        r.setNombre(nombre);

                        System.out.println("Ingrese la nueva nacionalidad del perro caliente: ");
                        nacionalidad = leer.nextLine();
                        r.setNacionalidad(nacionalidad);

                        System.out.println("Ingrese el nuevo peso del perro caliente: ");
                        peso = Double.parseDouble(leer.nextLine());
                        r.setPeso(peso);

                        System.out.println("Ingrese la nueva velocidad de ingesta del perro caliente: ");
                        velocidadIngestion = Double.parseDouble(leer.nextLine());
                        r.setVelocidadIngestion(velocidadIngestion);

                        System.out.println("Ingrese la nueva cantidad de perros consumidos: ");
                        perroConsumidos = Integer.parseInt(leer.nextLine());
                        r.setPerrosConsumidos(perroConsumidos);

                        System.out.println("Ingrese la nueva categoría del perro caliente: ");
                        categoria = leer.nextLine();
                        r.setCategoria(categoria);
                        break;
                }
                System.out.println("Se ha modificado el perro caliente con nombre: " + dato);
                break;
            }
            r = r.siguiente;
        } while (r != cab1);

        if (!encontrado) {
            System.out.println("El perro caliente con el nombre " + dato + " no se encuentra en la lista.");
        }
    }

    public void imprimirListasCirculares(){
        r=cab1;
        while (r.siguiente!=cab1)
        {
            System.out.println("\nNombre: "+ r.getNombre());
            System.out.println("Nacionalidad: "+ r.getNacionalidad());
            System.out.println("Peso: "+ r.getPeso());
            System.out.println("Velocidad de ingestión: "+ r.getVelocidadIngestion());
            System.out.println("Perros consumidos: "+ r.getPerrosConsumidos());
            System.out.println("Categoria: "+ r.getCategoria());
            r=r.siguiente;
        }

        System.out.println("\nNombre: "+ r.getNombre());
        System.out.println("Nacionalidad: "+ r.getNacionalidad());
        System.out.println("Peso: "+ r.getPeso());
        System.out.println("Velocidad de ingestión: "+ r.getVelocidadIngestion());
        System.out.println("Perros consumidos: "+ r.getPerrosConsumidos());
        System.out.println("Categoria: "+ r.getCategoria());
        r=r.siguiente;
    }

    public void menuListasDobles()
    {
        int opc;
        System.out.println("\nMENU LISTAS DOBLES");
        System.out.println("1. Crear listas Dobles");
        System.out.println("2. Adicionar listas Dobles.");
        System.out.println("3. Eliminar listas Dobles");
        System.out.println("4. Modificar listas Dobles");
        System.out.println("5. Imprimir listas Dobles");
        System.out.println("6. Reportes listas dobles");
        System.out.println("7. Volver.");

        System.out.println("");
        System.out.println("Escoja una opcion");
        opc =Integer.parseInt(leer.nextLine());

        switch (opc) {
            case 1:
                crearListasDobles();
                menuListasDobles();
                break;

            case 2:
                menuAdicionarListasDobles();
                menuListasDobles();
                break;

            case 3:
                menuEliminarListasDobles();
                menuListasDobles();
                break;

            case 4:
                modificarListasDobles();
                menuListasDobles();
                break;

            case 5:
                imprimirListasDobles();
                menuListasDobles();
                break;
            case 6:
                menuReportesListasDobles();
                menuListasDobles();
            case 7:
                menuPrincipal();
                break;

            default:
                menuListasDobles();
        }
    }

    public void crearListasDobles()
    {
        t = new Paginas_Amarillas("Construcciones Beta Sas","calle 12 n° 20-14","3103332211");
        cab2=t;
        u=t;

        t = new Paginas_Amarillas("Inversiones Electronicas","calle 21 n° 4-11","3117776655");
        u.siguiente=t;
        t.anterior=u;
        u=t;

        t = new Paginas_Amarillas("Comercializadora Mayor Ltda","tv 34 n° 37-40","3122221817");
        u.siguiente=t;
        t.anterior=u;
        u=t;

        t = new Paginas_Amarillas("Zapateria Insana","calle 44 n° 12-05","3229183377");
        u.siguiente=t;
        t.anterior=u;
        u=t;

        t = new Paginas_Amarillas("Adress Compani Clips","princial 64 n° 23-12","3108558916");
        u.siguiente=t;
        t.anterior=u;
        u=t;

        t = new Paginas_Amarillas("Cacharreria Urbana","dg 72 n° 104-2","3003143218");
        u.siguiente=t;
        t.anterior=u;
        u=t;
    }

    public void menuReportesListasDobles()
    {
        int opc;

        System.out.println("\nMENÚ REPORTES LISTAS DOBLES");
        System.out.println("1. Mostrar empresas cuya dirección se encuentre en una calle");
        System.out.println("2. Ordenar empresas por nombre");
        System.out.println("3. Volver");

        System.out.println("\nEscoja una opción");
        opc = Integer.parseInt(leer.nextLine());

        switch (opc){
            case 1:
                mostrarEmpresasDireccionEnCalle();
                menuReportesListasDobles();
                break;
            case 2:
                ordenarEmpresasPorNombre();
                menuReportesListasDobles();
                break;
            case 3:
                menuListasDobles();
                break;
            default:
                menuReportesListasDobles();
                break;
        }
    }

    public void mostrarEmpresasDireccionEnCalle()
    {
        if (cab2 == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        String palabraClave = "calle";
        u = cab2;

        System.out.println("\nEmpresas cuya dirección se encuentra en una \"calle\":");
        while (u != null) {
            if (u.getDireccion().toLowerCase().contains(palabraClave)) {
                System.out.println("\nNombre: " + u.getNombre());
                System.out.println("Dirección: " + u.getDireccion());
                System.out.println("Teléfono: " + u.getTelefono());
            }
            u = u.siguiente;
        }
    }

    public void ordenarEmpresasPorNombre() {

        if (cab2 == null || cab2.siguiente == null) {
            System.out.println("La lista está vacía o solo tiene un elemento. No es necesario ordenar.");
            return;
        }

        Paginas_Amarillas temp;
        boolean intercambio;
        do {
            intercambio = false;
            u = cab2;

            while (u.siguiente != null) {
                if (u.getNombre().compareToIgnoreCase(u.siguiente.getNombre()) > 0) {
                    // Intercambiar los nodos si están en el orden incorrecto
                    temp = u;
                    u = u.siguiente;
                    temp.siguiente = u.siguiente;
                    if (u.siguiente != null) {
                        u.siguiente.setAnterior(temp);
                    }

                    u.anterior = temp.anterior;
                    if (temp.anterior != null) {
                        temp.anterior.setSiguiente(u);
                    }

                    u.siguiente = temp;
                    temp.anterior = u;

                    if (temp == cab2) {
                        cab2 = u;
                    }

                    intercambio = true;
                } else {
                    u = u.siguiente;
                }
            }
        } while (intercambio);

        // Imprimir empresas ordenadas
        System.out.println("\nEmpresas ordenadas por nombre:");
        Paginas_Amarillas u = cab2;
        while (u != null) {
            System.out.println("\nNombre: " + u.getNombre());
            System.out.println("Dirección: " + u.getDireccion());
            System.out.println("Teléfono: " + u.getTelefono());
            u = u.siguiente;
        }
    }

    public void menuAdicionarListasDobles()
    {
        int opc;
        System.out.println("\nMENU ADICIONAR LISTAS DOBLES");
        System.out.println("1. Adicionar por el inicio listas Dobles.");
        System.out.println("2. Adicionar por el fin listas Dobles.");
        System.out.println("3. Adicionar antes de nodo listas Dobles");
        System.out.println("4. Adicionar despues de nodo listas Dobles");
        System.out.println("5. Volver.");

        System.out.println("\nEscoja una opcion: ");
        opc =Integer.parseInt(leer.nextLine());

        switch (opc) {
            case 1:
                adicionarInicioListasDobles();
                menuAdicionarListasDobles();
                break;

            case 2:
                adicionarFinListasDobles();
                menuAdicionarListasDobles();
                break;

            case 3:
                adicionarAnterioresListasDobles();
                menuAdicionarListasDobles();
                break;

            case 4:
                adicionarDespuesListasDobles();
                menuAdicionarListasDobles();
                break;

            case 5:
                menuListasDobles();
                break;

            default:
                menuAdicionarListasDobles();
                break;
        }
    }

    public void adicionarInicioListasDobles()
    {
        String nombre, dirreccion, telefono;
        System.out.println("Digite el nombre de la empresa: ");
        nombre =leer.nextLine();
        System.out.println("Digite la dirección de la empresa: ");
        dirreccion =leer.nextLine();
        System.out.println("Digite el telefono de la empresa: ");
        telefono=leer.nextLine();

        t=new Paginas_Amarillas(nombre,dirreccion,telefono);
        u=cab2;
        t.siguiente=u;
        u.anterior=t;
        cab2=t;
    }

    public void adicionarFinListasDobles()
    {
        String nombre, dirreccion, telefono;
        System.out.println("Digite el nombre de la empresa: ");
        nombre =leer.nextLine();
        System.out.println("Digite la dirección de la empresa: ");
        dirreccion =leer.nextLine();
        System.out.println("Digite el telefono de la empresa: ");
        telefono=leer.nextLine();


        t=new Paginas_Amarillas(nombre,dirreccion,telefono);
        u=cab2;
        while(u.siguiente!=null) {
            u = u.siguiente;
        }
        t.anterior=u;
        u.siguiente=t;
    }

    public void adicionarAnterioresListasDobles()
    {
        String nombre, direccion, telefono;
        String dato;

        u=cab2;
        System.out.println("Digite el nombre de la empresa a buscar ");
        dato=leer.nextLine();
        if (u.getNombre().compareToIgnoreCase(dato)==0)
        {
            adicionarInicioListasDobles();
        }

        else
        {

            while(u.getNombre().compareToIgnoreCase(dato)!= 0 && u.siguiente!=null)
            {
                u=u.siguiente;

            }
            if (u.getNombre().compareToIgnoreCase(dato)==0)
            {
                System.out.println("Digite el nombre de la empresa");
                nombre=leer.nextLine();
                System.out.println("Digite la dirreccion de la empresa");
                direccion=leer.nextLine();
                System.out.println("Digite el telefono de la empresa");
                telefono=leer.nextLine();

                t= new Paginas_Amarillas(nombre, direccion, telefono);

                t.siguiente=u;
                t.anterior=u.anterior;
                u.anterior.siguiente=t;
                u.anterior=t;
            }

            else
            {
                System.out.println("El nombre de la empresa no se encuentra en la lista");
            }

        }

    }

    public void adicionarDespuesListasDobles()
    {
        String nombre, direccion, telefono;
        String dato;
        System.out.println("Digite el nombre de la empresa a buscar ");
        dato = leer.nextLine();

        t = new Paginas_Amarillas("", "", ""); // Crear una instancia para llenar los datos

        u = cab2;
        while (u != null && !u.getNombre().equalsIgnoreCase(dato)) {
            u = u.siguiente;
        }

        if (u != null) {
            System.out.println("Digite el nombre de la empresa");
            nombre = leer.nextLine();
            System.out.println("Digite la dirección de la empresa");
            direccion = leer.nextLine();
            System.out.println("Digite el teléfono de la empresa");
            telefono = leer.nextLine();

            t = new Paginas_Amarillas(nombre, direccion, telefono);
            t.siguiente = u.siguiente;
            if (u.siguiente != null) {
                u.siguiente.anterior = t;
            }
            u.siguiente = t;
            t.anterior = u;
        } else {
            System.out.println("El nombre de la empresa no se encuentra en la lista");
        }
    }

    public void menuEliminarListasDobles()
    {
        int opc;
        System.out.println("\nMENU ELIMINAR LISTAS DOBLES");
        System.out.println("1. Eliminar por el inicio listas Dobles.");
        System.out.println("2. Eliminar por el fin listas Dobles.");
        System.out.println("3. Eliminar antes de nodo listas Dobles");
        System.out.println("4. Eliminar despues de nodo listas Dobles");
        System.out.println("5. Eliminar nodo dado listas Dobles.");
        System.out.println("6. Volver.");

        System.out.println("\nEscoja una opcion: ");
        opc =Integer.parseInt(leer.nextLine());

        switch (opc) {
            case 1:
                eliminarInicioListasDobles();
                menuEliminarListasDobles();
                break;

            case 2:
                eliminarFinListasDobles();
                menuEliminarListasDobles();
                break;

            case 3:
                eliminarAntesListasDobles();
                menuEliminarListasDobles();
                break;

            case 4:
                eliminarDespuesListasDobles();
                menuEliminarListasDobles();
                break;

            case 5:
                eliminarNodoDadoListasDobles();
                menuEliminarListasDobles();
                break;

            case 6:
                menuListasDobles();
                break;

            default:
                menuEliminarListasDobles();
                break;
        }
    }

    public void eliminarInicioListasDobles()
    {
        cab2=cab2.siguiente;
        cab2.anterior=null;
    }

    public void eliminarFinListasDobles()
    {
        t=cab2;
        while(t.siguiente!=null)
        {
            t=t.siguiente;

        }
        t.anterior.siguiente=null;
    }

    public void eliminarAntesListasDobles()
    {
        String dato;
        boolean encontrado = false;

        System.out.println("Ingrese el nombre a buscar para eliminar su anterior: ");
        dato = leer.nextLine();
        u = cab2;

        if (cab2 == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        if (cab2.getNombre().compareToIgnoreCase(dato) == 0) {
            System.out.println("No existe nodo anterior a eliminar.");
            return;
        } else if (cab2.getSiguiente() == null) {
            System.out.println("La lista solo contiene un elemento.");
            return;
        } else if (cab2.getSiguiente().getNombre().compareToIgnoreCase(dato) == 0) {
            cab2 = cab2.getSiguiente();
            cab2.setAnterior(null);
            System.out.println("Se ha eliminado el nodo correctamente.");
            return;
        } else {
            while (u != null) {
                if (u.getSiguiente() != null && u.getSiguiente().getSiguiente() != null &&
                        u.getSiguiente().getSiguiente().getNombre().compareToIgnoreCase(dato) == 0) {
                    u.anterior = u.getSiguiente();
                    u.siguiente = u.getSiguiente().getSiguiente();
                    u.anterior.setSiguiente(u.siguiente);
                    if (u.siguiente != null) {
                        u.siguiente.setAnterior(u.anterior);
                    }
                    encontrado = true;
                    System.out.println("Se eliminó el nodo correctamente.");
                    break;
                }
                u = u.getSiguiente();
            }
        }

        if (!encontrado) {
            System.out.println("El artista con el nombre ingresado no existe en la lista.");
        }
    }

    public void eliminarDespuesListasDobles()
    {
        if (cab2 == null || cab2.siguiente == null) {
            System.out.println("No hay suficientes nodos para eliminar después de un nodo.");
            return;
        }

        String dato;
        System.out.println("Digite el nombre de la empresa para eliminar su siguiente:");
        dato = leer.nextLine();

        u = cab2;
        while (u != null && !u.getNombre().equalsIgnoreCase(dato)) {
            u = u.siguiente;
        }

        if (u != null && u.siguiente != null) {
            Paginas_Amarillas temp = u.siguiente;
            u.siguiente = temp.siguiente;
            if (temp.siguiente != null) {
                temp.siguiente.anterior = u;
            }
            System.out.println("Nodo siguiente eliminado correctamente.");
        } else {
            System.out.println("El nodo siguiente al nombre proporcionado no se encuentra en la lista.");
        }
    }

    public void eliminarNodoDadoListasDobles()
    {
        if (cab2 == null) {
            System.out.println("La lista de empresas está vacía.");
            return;
        }

        System.out.println("Digite el nombre de la empresa que desea eliminar:");
        String nombre = leer.nextLine();

        boolean empresaExiste = false; // Variable para verificar si se encontró la empresa

        if (cab2.getNombre().equalsIgnoreCase(nombre)) {
            cab2 = cab2.siguiente;
            if (cab2 != null) {
                cab2.anterior = null;
            }
            empresaExiste = true;
        } else {
            u = cab2;
            while (u != null && !u.getNombre().equalsIgnoreCase(nombre)) {
                u = u.siguiente;
            }

            if (u != null) {
                if (u.siguiente != null) {
                    u.siguiente.anterior = u.anterior;
                }
                u.anterior.siguiente = u.siguiente;
                empresaExiste = true;
            }
        }

        if (!empresaExiste) {
            System.out.println("La empresa con el nombre dado no se encuentra en la lista.");
        }
    }

    public void modificarListasDobles()
    {
        String nombre, direccion, telefono;
        String dato;
        System.out.println("Digite el nombre de la empresa a modificar: ");
        dato = leer.nextLine();
        u = cab2;

        boolean empresaEncontrada = false; // Variable para verificar si se encontró la empresa

        while (u != null && u.getNombre().compareToIgnoreCase(dato) != 0) {
            u = u.siguiente;
        }

        if (u != null) {
            empresaEncontrada = true;

            int opc;
            System.out.println("1. Cambiar el nombre");
            System.out.println("2. Cambiar la dirección");
            System.out.println("3. Cambiar el Teléfono");
            System.out.println("4. Cambiar todos los datos");

            System.out.println("Escoja una opción:");
            opc = Integer.parseInt(leer.nextLine());

            switch (opc) {
                case 1:
                    System.out.println("Digite el nuevo nombre de la empresa: ");
                    nombre = leer.nextLine();
                    u.setNombre(nombre);
                    break;

                case 2:
                    System.out.println("Digite la nueva dirección de la empresa: ");
                    direccion = leer.nextLine();
                    u.setDireccion(direccion);
                    break;

                case 3:
                    System.out.println("Digite el nuevo teléfono de la empresa: ");
                    telefono = leer.nextLine();
                    u.setTelefono(telefono);
                    break;

                case 4:
                    System.out.println("Digite el nuevo nombre de la empresa: ");
                    nombre = leer.nextLine();
                    u.setNombre(nombre);

                    System.out.println("Digite la nueva dirección de la empresa: ");
                    direccion = leer.nextLine();
                    u.setDireccion(direccion);

                    System.out.println("Digite el nuevo teléfono de la empresa: ");
                    telefono = leer.nextLine();
                    u.setTelefono(telefono);
                    break;
            }
        }

        if (!empresaEncontrada) {
            System.out.println("La empresa con el nombre " + dato + " no se encuentra en la lista.");
        }
    }

    public void imprimirListasDobles()
    {
        t=cab2;
        while (t.siguiente!=null)
        {
            System.out.println("\nNombre: "+ t.getNombre());
            System.out.println("Dirección: "+ t.getDireccion());
            System.out.println("Telefono: "+ t.getTelefono());
            t=t.siguiente;

        }

        System.out.println("\nNombre: "+ t.getNombre());
        System.out.println("Dirección: "+ t.getDireccion());
        System.out.println("Telefono: "+ t.getTelefono());
        /*System.out.println("\nLista inversa");

        while (t.anterior!=null) {

            System.out.println("\nNombre: "+ t.getNombre());
            System.out.println("Dirección : "+ t.getDireccion());
            System.out.println("Telefono: "+ t.getTelefono());
            t=t.anterior;

        }

        System.out.println("\nNombre: "+ t.getNombre());
        System.out.println("Dirección: "+ t.getDireccion());
        System.out.println("Telefono: "+ t.getTelefono());*/

    }

    public void menuListasCircularesDobles()
    {
        int opc;
        System.out.println("\nMENU LISTAS CIRCULARES DOBLES");
        System.out.println("1. Crear listas Circulares Dobles");
        System.out.println("2. Adicionar listas Circulares Dobles.");
        System.out.println("3. Eliminar listas Circulares Dobles");
        System.out.println("4. Modificar listas Circulares Dobles");
        System.out.println("5. Imprimir listas Circulares Dobles");
        System.out.println("6. Reportes listas circulares dobles");
        System.out.println("7. Volver.");

        System.out.println("\nEscoja una opcion:");
        opc =Integer.parseInt(leer.nextLine());

        switch (opc) {
            case 1:
                crearListasCircularesDobles();
                menuListasCircularesDobles();
                break;

            case 2:
                menuAdicionarListasCircularesDobles();
                menuListasCircularesDobles();
                break;

            case 3:
                menuEliminarListasCircularesDobles();
                menuListasCircularesDobles();
                break;

            case 4:
                modificarListasCircularesDobles();
                menuListasCircularesDobles();
                break;

            case 5:
                imprimirListasCircularesDobles();
                menuListasCircularesDobles();
                break;
            case 6:
                menuReportesListasCircularesDobles();
                menuListasCircularesDobles();
                break;
            case 7:
                menuPrincipal();
                break;

            default:
                menuListasCircularesDobles();
        }
    }

    public void crearListasCircularesDobles()
    {
        x = new Curso(34010,"algoritmia",4.3);
        cab3=x;
        y=x;
        x.siguiente=cab3;
        cab3.anterior=x;

        x = new Curso(34011,"herramientas computacionales",3.5);
        x.anterior=y;
        x.siguiente=cab3;
        y.siguiente=x;
        cab3.anterior=x;
        y=x;

        x = new Curso(34012,"estructuras de datos",4.7);
        x.anterior=y;
        x.siguiente=cab3;
        y.siguiente=x;
        cab3.anterior=x;
        y=x;

        x = new Curso(34012,"ingenieria del software",3.8);
        x.anterior=y;
        x.siguiente=cab3;
        y.siguiente=x;
        cab3.anterior=x;
        y=x;
    }

    public void modificarListasCircularesDobles()
    {
        String asignatura;
        int codigo;
        double nota;

        String dato;
        System.out.println("Digite el nombre de la asignatura a modificar: ");
        dato = leer.nextLine();
        x = cab3;

        boolean asignaturaEncontrada = false; // Variable para verificar si se encontró la asignatura

        while (x.getAsignatura().compareToIgnoreCase(dato) != 0) {
            x = x.siguiente;
            if (x == cab3) { // Se ha vuelto al inicio de la lista sin encontrar la asignatura
                System.out.println("La asignatura con el nombre " + dato + " no se encuentra en la lista");
                return;
            }
        }

        asignaturaEncontrada = true;

        if (asignaturaEncontrada) {
            int opc;
            System.out.println("1. Cambiar el nombre de la asignatura");
            System.out.println("2. Cambiar la nota de la asignatura");
            System.out.println("3. Cambiar el código de la asignatura");
            System.out.println("4. Cambiar todos los datos");

            System.out.println("Escoja una opción:");
            opc = Integer.parseInt(leer.nextLine());

            switch (opc) {
                case 1:
                    System.out.println("Digite el nuevo nombre de la asignatura: ");
                    asignatura = leer.nextLine();
                    x.setAsignatura(asignatura);
                    break;

                case 2:
                    System.out.println("Digite la nueva nota de la asignatura (x.x): ");
                    nota = Double.parseDouble(leer.nextLine());
                    x.setNota(nota);
                    break;

                case 3:
                    System.out.println("Digite el nuevo código de la asignatura: ");
                    codigo = Integer.parseInt(leer.nextLine());
                    x.setCodigo(codigo);
                    break;

                case 4:
                    System.out.println("Digite el nuevo nombre de la asignatura: ");
                    asignatura = leer.nextLine();
                    x.setAsignatura(asignatura);

                    System.out.println("Digite la nueva nota de la asignatura: ");
                    nota = Double.parseDouble(leer.nextLine());
                    x.setNota(nota);

                    System.out.println("Digite el nuevo código de la asignatura: ");
                    codigo = Integer.parseInt(leer.nextLine());
                    x.setCodigo(codigo);
                    break;
            }
        }
    }

    public void imprimirListasCircularesDobles()
    {
        x=cab3;
        while (x.siguiente!=cab3)
        {
            System.out.println("\nCódigo: "+ x.getCodigo());
            System.out.println("Asignatura: "+ x.getAsignatura());
            System.out.println("Nota: "+ x.getNota());

            x=x.siguiente;
        }
        System.out.println("\nCódigo: "+ x.getCodigo());
        System.out.println("Asignatura: "+ x.getAsignatura());
        System.out.println("Nota: "+ x.getNota());
    }

    public void menuReportesListasCircularesDobles()
    {
        int opc;

        System.out.println("\nMENÚ REPORTES LISTAS CIRCULARES DOBLES");
        System.out.println("1. Calcular promedio del curso");
        System.out.println("2. Asignaturas con una nota superior al promedio");
        System.out.println("3. Volver");

        System.out.println("\nEscoja una opción");
        opc = Integer.parseInt(leer.nextLine());

        switch (opc){
            case 1:
                calcularPromedioCurso();
                menuReportesListasCircularesDobles();
                break;
            case 2:
                numeroDeEstudiantesConNotaSuperiorAlPromedio();
                menuReportesListasCircularesDobles();
                break;
            case 3:
                menuListasCircularesDobles();
                break;
            default:
                menuReportesListasCircularesDobles();
                break;
        }
    }

    public double calcularPromedioCurso()
    {
        if (cab3 == null) {
            System.out.println("La lista está vacía.");
            return 0.0;
        }

        x = cab3;
        double sumaCalificaciones = 0.0;
        int cantidadCursos = 0;

        do {
            sumaCalificaciones += x.getNota();
            cantidadCursos++;
            x = x.getSiguiente();
        } while (x != cab3);

        double promedio = sumaCalificaciones / cantidadCursos;
        System.out.println("El promedio del curso es de: " + promedio);
        return promedio;
    }

    public void numeroDeEstudiantesConNotaSuperiorAlPromedio()
    {
        double promedio = calcularPromedioCurso();
        if (cab3 == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        x = cab3;

        System.out.println("\nAsignaturas con calificación superior al promedio (" + promedio + "):");
        do {
            if (x.getNota() > promedio) {
                System.out.println("\nCódigo: " + x.getCodigo());
                System.out.println("Asignarura: " + x.getAsignatura());
                System.out.println("Nota: " + x.getNota());
            }
            x = x.getSiguiente();
        } while (x != cab3);
    }

    public void menuAdicionarListasCircularesDobles()
    {
        int opc;
        System.out.println("\nMENU ADICIONAR LISTAS CIRCULARES DOBLES");
        System.out.println("1. Adicionar por el inicio listas Circulares Dobles.");
        System.out.println("2. Adicionar por el fin listas Circulares Dobles.");
        System.out.println("3. Adicionar antes de nodo listas Circulares Dobles");
        System.out.println("4. Adicionar despues de nodo listas Circulares Dobles");
        System.out.println("5. Volver.");

        System.out.println("\nEscoja una opcion: ");
        opc =Integer.parseInt(leer.nextLine());

        switch (opc) {
            case 1:
                adicionarInicioListasCiruclaresDobles();
                menuAdicionarListasDobles();
                break;

            case 2:
                adicionarFinListasCircularesDobles();
                menuAdicionarListasDobles();
                break;

            case 3:
                adicionarAntesListasCircularesDobles();
                menuAdicionarListasDobles();
                break;

            case 4:
                adicionarDespuesListasCircularesDobles();
                menuAdicionarListasDobles();
                break;

            case 5:
                menuListasCircularesDobles();
                break;

            default:
                menuAdicionarListasCircularesDobles();
                break;
        }
    }

    public void adicionarInicioListasCiruclaresDobles()
    {
        String nombre;
        int codigo;
        Double nota;
        System.out.println("Digite el codigo del estudiante: ");
        codigo = Integer.parseInt(leer.nextLine());

        System.out.println("Digite nombre de la asignatura: ");
        nombre = leer.nextLine();

        System.out.println("Digite nota del estudiante: ");
        nota = Double.parseDouble(leer.nextLine());

        y=new Curso(codigo,nombre,nota);
        x=cab3;
        y.siguiente=x;
        y.anterior=x.anterior;
        x.anterior.siguiente=y;
        x.anterior=y;
        cab3=y;
    }

    public void adicionarFinListasCircularesDobles()
    {
        String nombre;
        int codigo;
        Double nota;
        System.out.println("Digite el codigo del estudiante: ");
        codigo = Integer.parseInt(leer.nextLine());

        System.out.println("Digite nombre de la asignatura: ");
        nombre = leer.nextLine();

        System.out.println("Digite nota del estudiante: ");
        nota = Double.parseDouble(leer.nextLine());

        y=new Curso(codigo, nombre, nota);
        x=cab3;
        y.anterior=x.anterior;
        y.siguiente=x;
        x.anterior.siguiente=y;
        x.anterior=y;
    }

    public void adicionarAntesListasCircularesDobles()
    {
        int codigo;
        String nombre;
        Double nota;
        String dato;
        x=cab3;
        System.out.println("Digite la asignatura a buscar: ");
        dato=leer.nextLine();

        while(x.getAsignatura().compareToIgnoreCase(dato)!=0 && x.siguiente!=cab3)
        {
            x=x.siguiente;
        }
        if(x==cab3)
        {
            System.out.println("Digite el codigo del estudiante: ");
            codigo = Integer.parseInt(leer.nextLine());

            System.out.println("Digite nombre de la asignatura: ");
            nombre = leer.nextLine();

            System.out.println("Digite nota del estudiante: ");
            nota = Double.parseDouble(leer.nextLine());

            y=new Curso(codigo, nombre, nota);

            y.siguiente=x;
            y.anterior=x.anterior;
            x.anterior.siguiente=y;
            x.anterior=y;
            cab3=y;

        }
        else
        {
            if(x.getAsignatura().compareToIgnoreCase(dato)==0)
            {
                System.out.println("Digite el codigo del estudiante: ");
                codigo = Integer.parseInt(leer.nextLine());

                System.out.println("Digite nombre de la asignatura: ");
                nombre = leer.nextLine();

                System.out.println("Digite nota del estudiante: ");
                nota = Double.parseDouble(leer.nextLine());

                y=new Curso(codigo, nombre, nota);
                y.siguiente=x;
                y.anterior=x.anterior;
                x.anterior.siguiente=y;
                x.anterior=y;
            }
            else
                System.out.println("la asignatura no se encuentra en la lista");

        }
    }

    public void adicionarDespuesListasCircularesDobles()
    {
        int codigo;
        String nombre;
        Double nota;
        String dato;

        x=cab3;
        System.out.println("Digite la asignatura a buscar: ");
        dato=leer.nextLine();

        while(x.getAsignatura().compareToIgnoreCase(dato)!=0 && x.siguiente!=cab3)
        {
            x=x.siguiente;
        }
        if(x.getAsignatura().compareToIgnoreCase(dato)==0 && x.siguiente==cab3)
        {
            System.out.println("Digite el codigo del estudiante: ");
            codigo = Integer.parseInt(leer.nextLine());

            System.out.println("Digite nombre de la asignatura: ");
            nombre = leer.nextLine();

            System.out.println("Digite nota del estudiante: ");
            nota = Double.parseDouble(leer.nextLine());

            y=new Curso(codigo, nombre,nota);

            y.anterior=cab3.anterior;
            y.siguiente=cab3;
            cab3.anterior.siguiente=y;
            cab3.anterior=y;
        }
        else
        {
            if(x.getAsignatura().compareToIgnoreCase(dato)==0)
            {
                System.out.println("Digite el codigo del estudiante: ");
                codigo = Integer.parseInt(leer.nextLine());

                System.out.println("Digite nombre de la asignatura: ");
                nombre = leer.nextLine();

                System.out.println("Digite nota del estudiante: ");
                nota = Double.parseDouble(leer.nextLine());

                y=new Curso(codigo, nombre,nota);
                y.siguiente=x.siguiente;
                y.anterior=x;
                x.siguiente.anterior=y;
                x.siguiente=y;
            }
            else
                System.out.println("la asignatura no se encuentra en la lista");

        }
    }


    public void menuEliminarListasCircularesDobles()
    {
        int opc;
        System.out.println("\nMENU ELIMINAR LISTAS CIRCULARES DOBLES");
        System.out.println("1. Eliminar por el inicio listas Circulares Dobles.");
        System.out.println("2. Eliminar por el fin listas Circulares Dobles.");
        System.out.println("3. Eliminar antes de nodo listas Circulares Dobles");
        System.out.println("4. Eliminar despues de nodo listas Circulares Dobles");
        System.out.println("5. Eliminar nodo dado listas Circulares Dobles.");
        System.out.println("6. Volver.");

        System.out.println("\nEscoja una opcion: ");
        opc =Integer.parseInt(leer.nextLine());

        switch (opc) {
            case 1:
                eliminarInicioListasCircularesDobles();
                menuEliminarListasCircularesDobles();
                break;

            case 2:
                eliminarFinListasCircularesDobles();
                menuEliminarListasCircularesDobles();
                break;

            case 3:
                eliminarAntesListasCircularesDobles();
                menuEliminarListasCircularesDobles();
                break;

            case 4:
                eliminarDespuesListasCircularesDobles();
                menuEliminarListasCircularesDobles();
                break;

            case 5:
                eliminarNodoDadoListasCircularesDobles();
                menuEliminarListasCircularesDobles();
                break;

            case 6:
                menuListasCircularesDobles();
                break;

            default:
                menuEliminarListasCircularesDobles();
                break;
        }
    }

    public void eliminarInicioListasCircularesDobles()
    {
        x=cab3;
        x.anterior.siguiente=x.siguiente;
        x.siguiente.anterior=x.anterior;
        cab3=x.siguiente;
    }

    public void eliminarFinListasCircularesDobles()
    {
        x=cab3;
        x.anterior.anterior.siguiente=x;
        x.anterior=x.anterior.siguiente;
    }

    public void eliminarAntesListasCircularesDobles()
    {
        String dato;
        System.out.println("Digite el nombre cuyo nodo anterior desea eliminar: ");
        dato=leer.nextLine();

        x=cab3;
        y=x.siguiente;

        if (dato.compareToIgnoreCase(x.getAsignatura())==0)
        {
            eliminarFinListasDobles();

        }else if (dato.compareToIgnoreCase(y.getAsignatura())==0)
        {
            eliminarInicioListasDobles();

        }else
        {
            x=y.siguiente;

            while (dato.compareToIgnoreCase(x.getAsignatura())!=0 && x.siguiente!=cab3)
            {
                x=x.siguiente;
            }

            if (dato.compareToIgnoreCase(x.getAsignatura())==0)
            {
                x.anterior.anterior.siguiente=x;
                x.anterior=x.anterior.anterior;
            }else
            {
                System.out.println("El nodo no se encuentra");
            }
        }
    }

    public void eliminarDespuesListasCircularesDobles()
    {
        String dato;
        System.out.println("Digite nombre cuyo nodo siguiente desea eliminar: ");
        dato=leer.nextLine();

        x=cab3;

        while (dato.compareToIgnoreCase(x.getAsignatura())!=0 && x.siguiente!=cab3)
        {
            x=x.siguiente;
        }

        if (x.siguiente.siguiente==cab3)
        {
            eliminarFinListasDobles();

        } else if (x.siguiente==cab3)
        {
            eliminarInicioListasDobles();
        } else if (dato.compareToIgnoreCase(x.getAsignatura())==0)
        {
            x.siguiente=x.siguiente.siguiente;
            x.siguiente.anterior=x;
        }else
        {
            System.out.println("El nodo no se encuentra");
        }
    }

    public void eliminarNodoDadoListasCircularesDobles()
    {
        String dato;
        System.out.println("Digite el nombre del nodo a eliminar");
        dato=leer.nextLine();

        x=cab3;

        while (dato.compareToIgnoreCase(x.getAsignatura())!=0 && x.siguiente!=cab3)
        {
            x=x.siguiente;
        }
        if (x==cab3)
        {
            eliminarInicioListasDobles();

        } else if (x.siguiente==cab3)
        {
            eliminarFinListasDobles();

        } else if (dato.compareToIgnoreCase(x.getAsignatura())==0)
        {
            x.anterior.siguiente=x.siguiente;
            x.siguiente.anterior=x.anterior;
        }else if (dato.compareToIgnoreCase(x.getAsignatura())!=0 && x.siguiente!=cab3)
            System.out.println("El nodo no existe");
    }

    public static void main(String[] args)
    {
        Main obj = new Main ();
    }
}
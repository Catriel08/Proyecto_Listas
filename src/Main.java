import java.util.Scanner;


public class Main {

    Scanner leer = new Scanner(System.in);
    Artista cab,p,q;
    Perros_Calientes cab1,r,s;
    Paginas_Amarillas cab2,t,u;
    Curso cab3,x,y;
    int opc;
    int codigo=0;
    int numeroArtistas=0;
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
        System.out.println("6. Mostrar número de artistas");
        System.out.println("7. Volver.");

        System.out.println("");
        System.out.println("Escoja una opcion: ");
        opc = Integer.parseInt(leer.nextLine());

        switch (opc) {
            case 1:
                crearListasSimples();
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
                numeroArtistas();
                menuListasSimples();

            case 7:
                menuPrincipal();
                break;

            default:
                menuListasSimples();
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

    public void crearListasSimples()
    {
        q = new Artista("Luis","peruano","12/08/1994");
        cab=q;
        p=q;
        q = new Artista("Elsa","japonesa","21/10/1980");
        p.sig=q;
        p=q;
        q = new Artista("Gabriel","aleman","13/01/1910");
        p.sig=q;
        p=q;
        q = new Artista("Estela","india","21/12/1991");
        p.sig=q;
        p=q;
    }

    public void menuAdicionarListasSimples()
    {
        int opc;
        System.out.println("\nMENU ADICIONAR LISTAS SIMPLES");
        System.out.println("1. Adicionar por el inicio listas simples.");
        System.out.println("2. Adicionar por el fin listas simples.");
        System.out.println("3. Adicionar anteriores de nodo listas simples");
        System.out.println("4. Adicionar despues de nodo listas simples");
        System.out.println("5. Volver.");

        System.out.println("\nEscoja una opcion;");
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
                adicionaranterioresListasSimples();
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
        String nombre, nacimiento, fecha;
        System.out.println("Digite el nombre del artista ");
        nombre=leer.nextLine();
        System.out.println("Digite la nacionalidad del artista ");
        nacimiento=leer.nextLine();
        System.out.println("Digite fecha nacimientoe del artista ");
        fecha =leer.nextLine();

        q=new Artista(nombre,nacimiento, fecha);
        q.sig=cab;
        cab=q;
    }

    public void adicionarFinListasSimples()
    {
        String nombre, nacimiento, fecha;
        System.out.println("Digite el nombre del artista ");
        nombre=leer.nextLine();
        System.out.println("Digite la nacionalidad del artista ");
        nacimiento=leer.nextLine();
        System.out.println("Digite fecha nacimientoe del artista ");
        fecha =leer.nextLine();

        q=new Artista(nombre,nacimiento, fecha);
        p=cab;
        while(p.sig!=null)
            p=p.sig;
        p.sig=q;
    }

    public void adicionaranterioresListasSimples()
    {
        Artista m;
        String nombre, nacimiento, fecha;
        String dato;

        p=cab;
        System.out.println("Digite el nombre a buscar ");
        dato=leer.nextLine();
        if(p.getNombre().compareToIgnoreCase(dato)==0)
        {
            adicionarInicioListasSimples();
        }
        else
        {

            System.out.println("Digite el nombre del artista ");
            nombre=leer.nextLine().toUpperCase();
            System.out.println("Digite la nacionalidad del artista ");
            nacimiento=leer.nextLine().toUpperCase();
            System.out.println("Digite fecha nacimientoe del artista ");
            fecha =leer.nextLine();

            q=new Artista(nombre,nacimiento, fecha);
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
                System.out.println("El nombre buscdo no se encuentra en la lista");

        }

    }

    public void adicionarDespuesListasSimples()
    {

    }

    public void menuEliminarListasSimples()
    {
        int opc;
        System.out.println("\nMENU ELIMINAR LISTAS SIMPLES");
        System.out.println("1. Eliminar por el inicio listas simples.");
        System.out.println("2. Eliminar por el fin listas simples.");
        System.out.println("3. Eliminar anteriores de nodo listas simples");
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
                eliminaranterioresListasSimples();
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

    }

    public void eliminarFinListasSimples()
    {

    }

    public void eliminaranterioresListasSimples()
    {

    }

    public void eliminarDespuesListasSimples()
    {

    }

    public void eliminarNodoDadoListasSimples()
    {

    }

    public void modificarListasSimples()
    {

    }

    public void imprimirListasSimples()
    {
        p=cab;
        while (p!=null)
        {
            System.out.println("\nNombre: "+ p.getNombre());
            System.out.println("Nacionalidad: "+ p.getNacionalidad());
            System.out.println("Fecha: "+ p.getFecha());
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
        System.out.println("6. Volver.");

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
    public void menuAdicionarListasCirculares(){
        int opc;
        String valor;
        System.out.println("\nMENU ADICIONAR LISTAS CIRCULARES");
        System.out.println("1. Adicionar por el inicio listas circulares.");
        System.out.println("2. Adicionar por el fin listas circulares.");
        System.out.println("3. Adicionar anteriores de nodo listas circulares");
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
        r = new Perros_Calientes("Sofia Reina", "mexicana",63.0 ,5.2 ,31, "infanterioril");
        while(s.siguiente!=cab1)
            s=s.siguiente;
        r.siguiente=cab1;
        s.siguiente=r;
        cab1=r;
    }
    public void adicionarFinListasCirculares()
    {
        s = cab1;
        r = new Perros_Calientes("Sofia Reina", "mexicana",63.0 ,5.2 ,31, "infanterioril");
        while(s.siguiente!=cab1)
            s=s.siguiente;
        r.siguiente=cab1;
        s.siguiente=r;
    }

    public void adicionaranterioresListasCirculares()
    {
        Perros_Calientes opc;
        String valor;
        System.out.println("Digite el nombre a buscar");
        valor = leer.nextLine();

        s = cab1;
        r = new Perros_Calientes("Sofia reina", "mexicana",63.0 ,5.2 ,31, "infanterioril");

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
            r = new Perros_Calientes("Sofia reina", "mexicana",63.0 ,5.2 ,31, "infanterioril");
            s.siguiente = r;
            r.siguiente = cab1;

        }else {
            if(s.getNombre().compareToIgnoreCase(valor)==0 && s.siguiente != cab1){
                r = new Perros_Calientes("Sofia reina", "mexicana",63.0 ,5.2 ,31, "infanterioril");
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
        System.out.println("3. Eliminar anteriores de nodo listas circulares");
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

            System.out.println("NO EXISTE NODO anteriorES PARA ELIMINAR");

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
        System.out.println("6. Volver.");

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
                menuPrincipal();
                break;

            default:
                menuListasDobles();
        }
    }

    public void crearListasDobles()
    {
        t = new Paginas_Amarillas("Construcciones Beta Sas","cll 12 n° 20-14","3103332211");
        cab2=t;
        u=t;
        t = new Paginas_Amarillas("Inversiones Electronicas","crr 21 n° 4-11","3117776655");
        u.siguiente=t;
        t.anterior=u;
        u=t;
        t = new Paginas_Amarillas("Comercializadora Mayor Ltda","tv 34 n° 37-40","3122221817");
        u.siguiente=t;
        t.anterior=u;
        u=t;
        t = new Paginas_Amarillas("Cacharreria Urbana","dg 72 n° 104-2","3003143218");
        u.siguiente=t;
        t.anterior=u;
        u=t;
    }

    public void menuAdicionarListasDobles()
    {
        int opc;
        System.out.println("\nMENU ADICIONAR LISTAS DOBLES");
        System.out.println("1. Adicionar por el inicio listas Dobles.");
        System.out.println("2. Adicionar por el fin listas Dobles.");
        System.out.println("3. Adicionar anteriores de nodo listas Dobles");
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
                adicionaranterioresListasDobles();
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

    public void adicionaranterioresListasDobles()
    {
        String nombre, direccion, telefono;
        String dato;

        u=cab2;
        System.out.println("Digite el nombre de la empresa a buscar ");
        dato=leer.nextLine();
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

    }

    public void menuEliminarListasDobles()
    {
        int opc;
        System.out.println("\nMENU ELIMINAR LISTAS DOBLES");
        System.out.println("1. Eliminar por el inicio listas Dobles.");
        System.out.println("2. Eliminar por el fin listas Dobles.");
        System.out.println("3. Eliminar anteriores de nodo listas Dobles");
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
                eliminaranterioresListasDobles();
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

    public void eliminaranterioresListasDobles()
    {

    }

    public void eliminarDespuesListasDobles()
    {

    }

    public void eliminarNodoDadoListasDobles()
    {

    }

    public void modificarListasDobles()
    {
        String nombre,direcion, telefono;
        String dato;
        System.out.println("Digite el nombre de la empresa a modificar: ");
        dato=leer.nextLine();
        u=cab2;
        while(u.getNombre().compareToIgnoreCase(dato)!=0 && u.siguiente != null)
            u=u.siguiente;
        if (true)
        {
            int opc;
            System.out.println("1. Cambiar el nombre");
            System.out.println("2. Cambiar la direccion");
            System.out.println("3.Cambiar el Telefono");
            System.out.println("4.Cambiar todos los datos");

            System.out.println("Escoja una opcion");
            opc =Integer.parseInt(leer.nextLine());

            switch(opc)
            {
                case 1:
                    System.out.println("Digite el nuevo nombre de la empresa: ");
                    nombre=leer.nextLine();
                    u.setNombre(nombre);
                    break;

                case 2:
                    System.out.println("Digite la nueva direccion de la empresa: ");
                    direcion=leer.nextLine();
                    u.setDireccion(direcion);
                    break;

                case 3:
                    System.out.println("Digite el nuevo telefono de la empresa: ");
                    telefono =leer.nextLine();
                    u.setTelefono(telefono);
                    break;

                case 4:
                    System.out.println("Digite el nuevo nombre de la empresa: ");
                    nombre=leer.nextLine();
                    u.setNombre(nombre);

                    System.out.println("Digite la nueva direccion de la empresa: ");
                    direcion=leer.nextLine();
                    u.setDireccion(direcion);

                    System.out.println("Digite el nuevo telefono de la empresa: ");
                    telefono =leer.nextLine();
                    u.setTelefono(telefono);
                    break;
            }
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
        System.out.println("\nLista inversa");

        while (t.anterior!=null) {

            System.out.println("\nNombre: "+ t.getNombre());
            System.out.println("Dirección : "+ t.getDireccion());
            System.out.println("Telefono: "+ t.getTelefono());
            t=t.anterior;

        }

        System.out.println("\nNombre: "+ t.getNombre());
        System.out.println("Dirección: "+ t.getDireccion());
        System.out.println("Telefono: "+ t.getTelefono());

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
        System.out.println("6. Volver.");

        System.out.println("");
        System.out.println("Escoja una opcion");
        opc =Integer.parseInt(leer.nextLine());

        switch (opc) {
            case 1:
                crearListasCircularesDobles();
                menuListasCircularesDobles();
                break;

            case 2:
                menuAdicionarListasCircularesDobles();
                menuListasDobles();
                break;

            case 3:
                menuEliminarListasCircularesDobles();
                menuListasDobles();
                break;

            case 4:
                modificarListasCircularesDobles();
                menuListasDobles();
                break;

            case 5:
                imprimirListasCircularesDobles();
                menuListasDobles();
                break;

            case 6:
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

    }

    public void imprimirListasCircularesDobles()
    {
        x=cab3;
        while (x.siguiente!=cab3)
        {

            System.out.println("codigo : "+ x.getCodigo() + "   " + "asignatura : "+ x.getAsignatura() + "    " + "nota : "+ x.getNota());

            x=x.siguiente;

        }
        System.out.println("codigo : "+ x.getCodigo() + "   " + "asignatura : "+ x.getAsignatura() + "    " + "nota : "+ x.getNota());
    }

    public void menuAdicionarListasCircularesDobles()
    {
        int opc;
        System.out.println("\nMENU ADICIONAR LISTAS CIRCULARES DOBLES");
        System.out.println("1. Adicionar por el inicio listas Circulares Dobles.");
        System.out.println("2. Adicionar por el fin listas Circulares Dobles.");
        System.out.println("3. Adicionar anteriores de nodo listas Circulares Dobles");
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
                adicionaranterioresListasCircularesDobles();
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
        //codigo++;

        String nombre;
        int codigo;
        Double nota;
        System.out.println("Digite el codigo del estudiante ");
        codigo =leer.nextInt();

        System.out.println("Digite nombre de la asignatura ");
        nombre =leer.nextLine();

        System.out.println("Digite nota del estudiante ");
        nota =leer.nextDouble();

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
        System.out.println("Digite el codigo del estudiante ");
        codigo =leer.nextInt();

        System.out.println("Digite nombre de la asignatura ");
        nombre =leer.nextLine();

        System.out.println("Digite nota del estudiante ");
        nota =leer.nextDouble();

        y=new Curso(codigo, nombre, nota);
        x=cab3;
        y.anterior=x.anterior;
        y.siguiente=x;
        x.anterior.siguiente=y;
        x.anterior=y;
    }

    public void adicionaranterioresListasCircularesDobles()
    {
        int cod;
        String nombre;
        Double nota;
        String dato;
        x=cab3;
        System.out.println("Digite la asignatura a buscar ");
        dato=leer.nextLine();

        while(x.getAsignatura().compareToIgnoreCase(dato)!=0 && x.siguiente!=cab3)
        {
            x=x.siguiente;
        }
        if(x==cab3)
        {
            System.out.println("Digite el codigo del estudiante ");
            cod=leer.nextInt();

            System.out.println("Digite nombre de la asignatura ");
            nombre =leer.nextLine();

            System.out.println("Digite nota del estudiante ");
            nota =leer.nextDouble();

            y=new Curso(cod, nombre, nota);

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
                System.out.println("Digite el codigo del estudiante ");
                cod=leer.nextInt();

                System.out.println("Digite nombre de la asignatura ");
                nombre =leer.nextLine();

                System.out.println("Digite nota del estudiante ");
                nota =leer.nextDouble();

                y=new Curso(cod, nombre, nota);
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
        System.out.println("Digite la asignatura a buscar ");
        dato=leer.nextLine();

        while(x.getAsignatura().compareToIgnoreCase(dato)!=0 && x.siguiente!=cab3)
        {
            x=x.siguiente;
        }
        if(x.getAsignatura().compareToIgnoreCase(dato)==0 && x.siguiente==cab3)
        {
            System.out.println("Digite el codigo del estudiante ");
            codigo =leer.nextInt();
            System.out.println("Digite nombre de la asignatura ");
            nombre =leer.nextLine();
            nombre =leer.nextLine();
            System.out.println("Digite nota del estudiante ");
            nota=leer.nextDouble();

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
                System.out.println("Digite el codigo del estudiante ");
                codigo =leer.nextInt();

                System.out.println("Digite nombre de la asignatura ");
                nombre =leer.nextLine();

                System.out.println("Digite nota del estudiante ");
                nota=leer.nextDouble();

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
        System.out.println("3. Eliminar anteriores de nodo listas Circulares Dobles");
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
                eliminaranterioresListasCircularesDobles();
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

    public void eliminaranterioresListasCircularesDobles()
    {
        String dato;
        System.out.println("Digite el dato a eliminar");
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
                System.out.println("El dato no se encuentra");
            }
        }
    }

    public void eliminarDespuesListasCircularesDobles()
    {
        String dato;
        System.out.println("Digite el dato a eliminar");
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
            System.out.println("El dato no se encuentra");
        }
    }

    public void eliminarNodoDadoListasCircularesDobles()
    {
        String dato;
        System.out.println("Digite el dato a eliminar");
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
            System.out.println("El dato no existe");
    }

    public static void main(String[] args)
    {
        Main obj = new Main ();
    }

}
import java.util.Scanner;


public class Main {

    Scanner leer = new Scanner(System.in);
    Artista cab,p,q;
    Perros_Calientes cab1,r,s;
    Paginas_Amarillas cab2,t,u;
    Curso cab3,x,y;
    int opc;
    public Main()
    {
        menuPrincipal();
    }

    public void menuPrincipal()
    {
        int opc;
        System.out.println("MENU PRINCIPAL");
        System.out.println("1. Listas simples");
        System.out.println("2. Listas circulares");
        System.out.println("3. Listas dobles");
        System.out.println("4. Listas circulares dobles");
        System.out.println("5. Terminar");

        System.out.println("");
        System.out.println("Escoja la opcion:");
        opc =Integer.parseInt(leer.nextLine());

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
        System.out.println("6. Volver.");

        System.out.println("");
        System.out.println("Escoja una opcion");
        opc =Integer.parseInt(leer.nextLine());

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
                menuPrincipal();
                break;

            default:
                menuListasSimples();
        }
    }

    public void crearListasSimples()
    {
        q = new Artista("luis","peruano","12/08/1994");
        cab=q;
        p=q;
        q = new Artista("elsa","japonesa","21/10/1980");
        p.sig=q;
        p=q;
        q = new Artista("gabriel","aleman","13/01/1910");
        p.sig=q;
        p=q;
        q = new Artista("estela","india","21/12/1991");
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
        opc =Integer.parseInt(leer.nextLine());

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
            nombre=leer.nextLine();
            System.out.println("Digite la nacionalidad del artista ");
            nacimiento=leer.nextLine();
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
                System.out.println("el nombre buscdo no se encuentra en la lista");

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
            System.out.println("\nnombre : "+ p.getNombre());
            System.out.println("nacionalida : "+ p.getNacionalidad());
            System.out.println("fecha : "+ p.getNacionalidad());
            System.out.println("p : "+ p);
            p=p.sig;
        }
    }

    public void menuListasCirculares()
    {
        int opc;
        String valor;
        System.out.println("\nMENU LISTAS SIMPLES");
        System.out.println("1. Crear listas circulares");
        System.out.println("2. Adicionar listas circulares");
        System.out.println("3. Eliminar listas circulares");
        System.out.println("4. Modificar listas circulares");
        System.out.println("5. Imprimir listas circulares");
        System.out.println("6. Volver.");

        System.out.println("");
        System.out.println("Escoja una opcion");
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
        cab1 = new Perros_Calientes("juan delgadillo", "peruano", 78.3, 3.2,16, "adulto");
        cab1.siguiente = cab1;
        r = new Perros_Calientes("luang xion", "chino", 65.4, 4.6,23, "junior");
        s = cab1;
        s.siguiente = r;
        r.siguiente = cab1;
        s = r;
        r = new Perros_Calientes("robert conti", "italiano",67.8 ,3.6 ,18, "junior");
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
        System.out.println("7");
        System.out.println("\nEscoja una opcion;");
        valor= leer.nextLine();
        opc=Integer.parseInt(valor);

        switch (opc) {
            case 1:
                adicionarInicioListasDobles();
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
        r = new Perros_Calientes("sofia reina", "mexicana",63.0 ,5.2 ,31, "infanterioril");
        while(s.siguiente!=cab1)
            s=s.siguiente;
        r.siguiente=cab1;
        s.siguiente=r;
        cab1=r;
    }
    public void adicionarFinListasCirculares()
    {
        s = cab1;
        r = new Perros_Calientes("sofia reina", "mexicana",63.0 ,5.2 ,31, "infanterioril");
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
        r = new Perros_Calientes("sofia reina", "mexicana",63.0 ,5.2 ,31, "infanterioril");

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
            r = new Perros_Calientes("sofia reina", "mexicana",63.0 ,5.2 ,31, "infanterioril");
            s.siguiente = r;
            r.siguiente = cab1;

        }else {
            if(s.getNombre().compareToIgnoreCase(valor)==0 && s.siguiente != cab1){
                r = new Perros_Calientes("sofia reina", "mexicana",63.0 ,5.2 ,31, "infanterioril");
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
        System.out.println("digite el nombre a buscar");
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
            System.out.println("el valor no existe");

    }

    public void eliminarNodoDadoListasCirculares()
    {
        String valor;
        Perros_Calientes t;
        System.out.println("digite el nombre a eliminar");
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
            System.out.println("el valor no existe");
    }

    public void modificarListasCirculares()
    {

    }



    public void imprimirListasCirculares(){
        r=cab1;
        while (r.siguiente!=cab1)
        {
            System.out.println("\nnombre : "+ r.getNombre());
            System.out.println("nacionalidad : "+ r.getNacionalidad());
            System.out.println("peso : "+ r.getPeso());
            System.out.println("velocidad de ingestion : "+ r.getVelocidadIngestion());
            System.out.println("perros consumidos : "+ r.getPerrosConsumidos());
            System.out.println("categoria : "+ r.getCategoria());
            r=r.siguiente;
        }

        System.out.println("\nnombre : "+ r.getNombre());
        System.out.println("nacionalidad : "+ r.getNacionalidad());
        System.out.println("peso : "+ r.getPeso());
        System.out.println("velocidad de ingestion : "+ r.getVelocidadIngestion());
        System.out.println("perros consumidos : "+ r.getPerrosConsumidos());
        System.out.println("categoria : "+ r.getCategoria());
        r=r.siguiente;
    }



    public void menuListasCircularesDobles()
    {

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
        t = new Paginas_Amarillas("construcciones beta sas","cll 12 n° 20-14","3103332211");
        cab2=t;
        u=t;
        t = new Paginas_Amarillas("inversiones electronicas","crr 21 n° 4-11","3117776655");
        u.siguiente=t;
        t.anterior=u;
        u=t;
        t = new Paginas_Amarillas("comercializadora mayor ltda","tv 34 n° 37-40","3122221817");
        u.siguiente=t;
        t.anterior=u;
        u=t;
        t = new Paginas_Amarillas("cacharreria urbana","dg 72 n° 104-2","3003143218");
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

        System.out.println("\nEscoja una opcion;");
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

        System.out.println("\nEscoja una opcion;");
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
        while (t.siguiente!=null){

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
        System.out.println("Digite el nombre de la empresa a modificar");
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
                    System.out.println("Digite el nuevo nombre de la empresa");
                    nombre=leer.nextLine();
                    u.setNombre(nombre);
                    break;

                case 2:
                    System.out.println("Digite la nueva direccion de la empresa");
                    direcion=leer.nextLine();
                    u.setDireccion(direcion);
                    break;

                case 3:
                    System.out.println("Digite el nuevo telefono de la empresa");
                    telefono =leer.nextLine();
                    u.setTelefono(telefono);
                    break;

                case 4:
                    System.out.println("Digite el nuevo nombre de la empresa");
                    nombre=leer.nextLine();
                    u.setNombre(nombre);

                    System.out.println("Digite la nueva direccion de la empresa");
                    direcion=leer.nextLine();
                    u.setDireccion(direcion);

                    System.out.println("Digite el nuevo telefono de la empresa");
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
            System.out.println("\nNombre : "+ t.getNombre());
            System.out.println("Direccion : "+ t.getDireccion());
            System.out.println("Telefono : "+ t.getTelefono());
            t=t.siguiente;

        }

        System.out.println("\nNombre : "+ t.getNombre());
        System.out.println("Direccion : "+ t.getDireccion());
        System.out.println("Telefono : "+ t.getTelefono());
        System.out.println("\nLista inversa");

        while (t.anterior!=null) {

            System.out.println("\nNombre : "+ t.getNombre());
            System.out.println("Direccion : "+ t.getDireccion());
            System.out.println("Telefono : "+ t.getTelefono());
            t=t.anterior;

        }

        System.out.println("\nNombre : "+ t.getNombre());
        System.out.println("Direccion : "+ t.getDireccion());
        System.out.println("Telefono : "+ t.getTelefono());

    }

    public static void main(String[] args)
    {
        Main obj = new Main ();
    }

}
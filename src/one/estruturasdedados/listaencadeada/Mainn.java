package one.estruturasdedados.listaencadeada;

public class Mainn {
    public static void main(String[] args) {
        ListaEncadeada<String>lista = new ListaEncadeada<>();
        lista.add("2");
        lista.add("3");

        System.out.println(lista.toString());
        lista.remove(1);
        System.out.println(lista);
    }

    }



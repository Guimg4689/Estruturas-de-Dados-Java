package one.estruturasdedados.duplalistaencadeada;

public class MainListaEncadeada {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada<String>minhaLista = new ListaDuplamenteEncadeada<>();
        minhaLista.add("c1");
        minhaLista.add("c2");
        minhaLista.add("c3");
        minhaLista.add("c4");
        minhaLista.add("c5");

        System.out.println(minhaLista);
        minhaLista.remove(3);
        minhaLista.add(3,"c99");
        System.out.println(minhaLista);

    }
}

package one.estruturasdedados.duplalistaencadeada;

public class ListaDuplamenteEncadeada <T>{
    private NoDuplo<T> primeiroNo;
    private NoDuplo<T> ultimoNo;
    private int tamanhoLista;

    ListaDuplamenteEncadeada(){
        this.tamanhoLista = 0;
        primeiroNo = null;
        ultimoNo = null;
    }

    public T get(int index){
        return getNO(index).getConteudo();
    }

    public void  add(T elemento){
        NoDuplo<T>novoNo = new NoDuplo<>(elemento);
        novoNo.setNoProximo(null);
        novoNo.setNoPrevio(ultimoNo);
        if(primeiroNo ==null)
            primeiroNo = novoNo;

        if(ultimoNo!= null)
            ultimoNo.setNoProximo(novoNo);

        ultimoNo = novoNo;
        tamanhoLista++;
    }
    public void add(int index,T elemento){
        NoDuplo<T>aux = getNO(index);
        NoDuplo<T>novoNo = new NoDuplo<>(elemento);
        novoNo.setNoProximo(aux);

        if(novoNo.getNoProximo()!=null){
            novoNo.setNoPrevio(aux.getNoPrevio());
            novoNo.getNoProximo().setNoPrevio(novoNo);
        }else{
            novoNo.setNoPrevio(ultimoNo);
            ultimoNo = novoNo;
        }
        if(index == 0){
            primeiroNo = novoNo;

        }else{
            novoNo.getNoPrevio().setNoProximo(novoNo);
        }
        tamanhoLista++;

    }

    public void remove(int index){

        if(index == 0){
            primeiroNo = primeiroNo.getNoProximo();
            if(primeiroNo!= null){
                primeiroNo.setNoPrevio(null);
            }
        }else {
          NoDuplo<T>aux = getNO(index);
          aux.getNoPrevio().setNoProximo(aux.getNoProximo());
          if(aux!= ultimoNo){
              aux.getNoProximo().setNoPrevio(aux.getNoPrevio());
          }else{
              ultimoNo = aux;
          }
        }
        this.tamanhoLista--;
    }
    private NoDuplo<T> getNO(int index){
        NoDuplo<T>noAux = primeiroNo;

        for(int i = 0; (i < index) && (noAux !=null);i++){
            noAux = noAux.getNoProximo();
        }
        return noAux;

    }

    public int size(){
        return this.tamanhoLista;
    }

    @Override
    public String toString() {
        String str = "";
        NoDuplo<T>aux = primeiroNo;
        for(int i = 0;i< size();i++){
            str+="No{conteudo=" + aux.getConteudo() + "}" + "-->";
            aux = aux.getNoProximo();

        }
        str+="null";
        return str;
    }
}

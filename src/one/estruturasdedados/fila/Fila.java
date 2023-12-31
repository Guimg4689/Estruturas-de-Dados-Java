package one.estruturasdedados.fila;

public class Fila <T>{
    private  No<T>  refNoEntrada;


    public Fila(){
        this.refNoEntrada = null;
    }

    public void enqueue(T obj){
        No novoNo = new No(obj);
        novoNo.setRefNo(refNoEntrada);
        refNoEntrada = novoNo;
    }

    public T first(){
        if (!this.isEmpty()){
            No primeiroNo = refNoEntrada;


            while (true){
                if (primeiroNo.getRefNo()!= null){

                    primeiroNo = primeiroNo.getRefNo();
                }else{

                    break;

                }
            }
            return (T)primeiroNo.getObject();
        }
        return null;
    }

    public T dequeue(){
        if (!this.isEmpty()){
            No primeiroNo = refNoEntrada;
            No aux = refNoEntrada;

            while (true){
                if (primeiroNo.getRefNo()!= null){
                    aux = primeiroNo;
                    primeiroNo = primeiroNo.getRefNo();
                }else{

                    aux.setRefNo(null);

                    break;

                }
            }
            return (T)primeiroNo.getObject();
        }
        return null;
    }

    public boolean isEmpty(){
       return this.refNoEntrada ==null ? true : false;
    }

    @Override
    public String toString() {
       String stringRetorno = "";
       No aux = refNoEntrada;

       if (refNoEntrada!=null){
           while (true){
               stringRetorno +="[No{objeto=" + aux.getObject() + "}]----->";

               if(aux.getRefNo()!=null){
                   aux = aux.getRefNo();
               }else {
                   break;
               }
           }

       }else {stringRetorno = "null";}

       return stringRetorno;
    }
}

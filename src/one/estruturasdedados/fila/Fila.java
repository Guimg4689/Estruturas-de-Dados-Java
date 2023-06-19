package one.estruturasdedados.fila;

public class Fila {
    private  No  refNoEntrada;


    public Fila(){
        this.refNoEntrada = null;
    }

    public void enqueue(No novoNo){
     novoNo.setRefNo(refNoEntrada);
     refNoEntrada = novoNo;
    }

    public No first(){
        if (!this.isEmpty()){
            No primeiroNo = refNoEntrada;


            while (true){
                if (primeiroNo.getRefNo()!= null){

                    primeiroNo = primeiroNo.getRefNo();
                }else{

                    break;

                }
            }
            return primeiroNo;
        }
        return null;
    }

    public No dequeue(){
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
            return primeiroNo;
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

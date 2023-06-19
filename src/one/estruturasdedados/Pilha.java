package one.estruturasdedados;

public class Pilha {
   private No refNoEntradaP;

    public Pilha() {
        this.refNoEntradaP = null;
    }

    public boolean isEmpty(){

        return refNoEntradaP == null ? true : false;
    }

    public No top(){
        return refNoEntradaP;
    }

    public void push(No novoNo){
        No refaux = refNoEntradaP;
        refNoEntradaP = novoNo;
        refNoEntradaP.setProx(refaux);

    }

    public No pop(){
        if(!this.isEmpty()){
            No poped = refNoEntradaP;
            refNoEntradaP = refNoEntradaP.getProx();
            return poped;
        }
        return null;
    }

    @Override
    public String toString(){
        String stringRetorno = "---------------\n";
        stringRetorno += "Pilha\n";
        stringRetorno +="---------------\n";
        No aux = refNoEntradaP;
        while (true){
            if(aux != null){
             stringRetorno+= "[No{dado =" + aux.getDado()+"}]\n";
             aux = aux.getProx();
            }else{
                break;
            }

        }
        stringRetorno+= "---------------";
        return stringRetorno;
    }
}

package one.estruturasdedados.arvorebuscabinaria;

public class ArvoreBinaria <T extends Comparable<T>>{

    private NoBin<T>raiz;

    public ArvoreBinaria(){
        this.raiz = null;
    }

    public void inserir(T conteudo){
        NoBin<T> novoNo = new NoBin<>(conteudo);
        raiz = inserir(raiz,novoNo);
    }
    private NoBin<T> inserir(NoBin<T>atual,NoBin<T>novoNo){
        if(atual == null){
            return novoNo;
        } else if (novoNo.getConteudo().compareTo(atual.getConteudo()) < 0) {
            atual.setNoEsq(inserir(atual.getNoEsq(),novoNo));
        }else{
            atual.setNoDir(inserir(atual.getNoDir(),novoNo));
        }
      return atual;
    }



    public void exibirInOrdem(){
        System.out.println("Exibindo InOrdem:");
        exibirInOrdem(this.raiz);
    }

    private void exibirInOrdem(NoBin<T>atual){
        if(atual!=null){
            exibirInOrdem(atual.getNoEsq());
            System.out.print(atual.getConteudo() + ", ");
            exibirInOrdem(atual.getNoDir());
        }

    }

    public void exibirPosOrdem(){
        System.out.println("\nExibindo PosOrdem:");
        exibirPosOrdem(this.raiz);
    }

    private void exibirPosOrdem(NoBin<T>atual){
        if(atual!=null){
            exibirPosOrdem(atual.getNoEsq());
            exibirPosOrdem(atual.getNoDir());
            System.out.print(atual.getConteudo() + ", ");

        }

    }

    public void exibirPreOrdem(){
        System.out.println(" \n Exibindo PreOrdem:");
        exibirPreOrdem(this.raiz);
    }

    private void exibirPreOrdem(NoBin<T>atual){
        if(atual!=null){

            System.out.print(atual.getConteudo() + ", ");
            exibirPreOrdem(atual.getNoEsq());
            exibirPreOrdem(atual.getNoDir());

        }

    }

    public void remover(T conteudo){
        try {
            NoBin<T>atual = this.raiz;
            NoBin<T>pai = null;
            NoBin<T>filho = null;
            NoBin<T>temp = null;

            while ((atual!=null) && (atual.getConteudo()!= conteudo)){
                pai = atual;
                if(conteudo.compareTo(atual.getConteudo())< 0){
                    atual = atual.getNoEsq();
                }else{
                   atual= atual.getNoDir();
                }
            }
            if (atual == null){
                System.out.println("Conteudo nao encontrado. Bloco Try");
            }

            if(pai == null){
                if (atual.getNoDir() == null){
                    this.raiz = atual.getNoEsq();
                }else if (atual.getNoEsq() == null) {
                    this.raiz = atual.getNoDir();
                }else {
                   for(temp = atual,filho = atual.getNoEsq();filho.getNoDir()!= null; temp = filho,filho = filho.getNoEsq()){
                       if(filho!=atual.getNoEsq()){
                           temp.setNoDir(filho.getNoEsq());
                           filho.setNoEsq(raiz.getNoEsq());
                       }
                   }
                   filho.setNoDir(raiz.getNoDir());
                   raiz = filho;
                }


            }else if(atual.getNoDir() == null){
              if(pai.getNoEsq() == atual){
                  pai.setNoEsq(atual.getNoEsq());
              }else{
                  pai.setNoDir(atual.getNoEsq());
              }

            } else if (atual.getNoEsq() == null) {
                if(pai.getNoEsq() == atual){
                    pai.setNoEsq(atual.getNoDir());
                }else{
                    pai.setNoDir(atual.getNoDir());
                }
            }else {
               for(temp = atual,filho = atual.getNoEsq();filho.getNoDir() != null;temp = filho, filho = filho.getNoDir()){
                   if (filho!= atual.getNoEsq()){
                       temp.setNoDir(filho.getNoEsq());
                       filho.setNoEsq(atual.getNoEsq());
                   }
                   filho.setNoDir(atual.getNoDir());
                   if (pai.getNoEsq() == atual){
                     pai.setNoEsq(filho);
                   }else{
                       pai.setNoDir(filho);
                   }
               }
            }

        }catch (NullPointerException e) {
            System.out.println("Conteudo nao encontrado. Bloco Catch");
        }
    }
}

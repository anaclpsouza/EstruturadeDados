public class BSTree {
    No raiz = null;

    public void inserir(No no, Aluno a) {
        if (no != null) {
            if (a.getMat() < no.aluno.getMat()) {
                if (no.esquerda != null)
                    inserir(no.esquerda, a);
                else
                    no.esquerda = new No(a);
            } else {
                if (no.direita != null)
                    inserir(no.direita, a);
                else
                    no.direita = new No(a);
            }
        } else {
            raiz = new No(a);
        }
    }

    public No remover(int mat) throws Exception {
        raiz = remover(this.raiz, mat);
        return raiz;
    }

    private No remover(No no, int mat) throws Exception {
        if (no == null) {
            throw new Exception("Aluno não encontrado");
        }

        if (this.raiz == null) {
            throw new Exception("Árvore vazia");
        }

        if (mat < no.aluno.getMat()) {
            no.esquerda = remover(no.esquerda, mat);
        } else if (mat > no.aluno.getMat()) {
            no.direita = remover(no.direita, mat);
        } else {
            // caso de dois filhos
            if (no.esquerda != null && no.direita != null) {
                no.aluno =  minimo(no.direita).aluno;
                no.direita = removeMinimo(no.direita);
            } else {
                no = (no.esquerda != null) ? no.esquerda : no.direita;
            }
        }
        return no;
    }

    public boolean inArvore(No no, int mat) {
        if (no == null) {
            return false;
        }
        if (mat < no.aluno.getMat()) {
            return inArvore(no.esquerda, mat);
        } else if (mat > no.aluno.getMat()) {
            return inArvore(no.direita, mat);
        }
        return true;
    }

    public void imprime_preOrdem(No no) {
        if (no != null) {
            System.out.print(no.aluno.toString());
            imprime_preOrdem(no.esquerda);
            imprime_preOrdem(no.direita);
        }
    }

    private No minimo(No no) throws Exception {
        if (no == null)
            throw new Exception("Raiz nula");
        if (no.esquerda != null)
            return minimo(no.esquerda);
        else
            return no;
    }

    public No maiorMat(No no) throws Exception {
        if (no == null)
            throw new Exception("Raiz nula");
        if (no.direita != null)
            return maiorMat(no.direita);
        else
            return no;
    }

    private No removeMinimo(No no) throws Exception {
        if (no == null)
            throw new Exception("Raiz nula");
        else if (no.esquerda != null) {
            no.esquerda = (removeMinimo(no.esquerda));
            return no;
        } else {
            return no.direita;
        }
    }
}

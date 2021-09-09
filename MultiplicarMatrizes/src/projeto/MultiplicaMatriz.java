package projeto;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class MultiplicaMatriz extends RecursiveAction{
	
	private static final long serialVersionUID = 8766161727351749778L;
	private Matriz a, b, c;
    private int linha;

    MultiplicaMatriz(Matriz a, Matriz b, Matriz c) {
        this(a, b, c, -1);
    }

    MultiplicaMatriz(Matriz a, Matriz b, Matriz c, int linha) {
        if (a.getColunas() != b.getLinhas()) {
            throw new IllegalArgumentException("linhas/colunas incompatíveis");
        }
        this.a = a;
        this.b = b;
        this.c = c;
        this.linha = linha;
    } 

    @Override
    public void compute() {
        if (linha == -1) {
            List<MultiplicaMatriz> tasks = new ArrayList<>();
            for (int linha = 0; linha < a.getLinhas(); linha++) {
                tasks.add(new MultiplicaMatriz(a, b, c, linha));
            }
            invokeAll(tasks);
        } else {
            multipliqueLinhaPorColuna(a, b, c, linha);
        }
    }

    void multipliqueLinhaPorColuna(Matriz a, Matriz b, Matriz c, int linha) {
        for (int j = 0; j < b.getColunas(); j++) {
            for (int k = 0; k < a.getColunas(); k++) {
                c.setValor(linha, j, (int)(c.getValor(linha, j) +  a.getValor(linha, k)* b.getValor(k, j)));
            }
        }
    }

}

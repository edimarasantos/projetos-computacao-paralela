package projeto;

import java.util.concurrent.ForkJoinPool;

public class Principal {
	
	public static void main(String[] args) {
        Matriz a = new Matriz(2, 3);
        a.setValor(0, 0, 1); // | 1 2 3 | 
        a.setValor(0, 1, 2); // | 4 5 6 | 
        a.setValor(0, 2, 3);
        a.setValor(1, 0, 4);
        a.setValor(1, 1, 5);
        a.setValor(1, 2, 6);
        Matriz b = new Matriz(3, 2);
        b.setValor(0, 0, 7); // | 7 1 | 
        b.setValor(1, 0, 8); // | 8 2 | 
        b.setValor(2, 0, 9); // | 9 3 | 
        b.setValor(0, 1, 1);
        b.setValor(1, 1, 2);
        b.setValor(2, 1, 3);
        Matriz c = new Matriz(2, 2);
        
        System.out.println("Iniciando a multiplicação das matrizes");
        long tempoInicial = System.currentTimeMillis();
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new MultiplicaMatriz(a, b, c));
        long tempoFinal = System.currentTimeMillis();
        System.out.println("Concluído.");
        System.out.format("Tempo decorrido: %d ms\n", tempoFinal-tempoInicial);
    }

}

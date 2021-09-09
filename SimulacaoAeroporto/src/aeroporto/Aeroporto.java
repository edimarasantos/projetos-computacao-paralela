package aeroporto;

import java.util.LinkedList;


public class Aeroporto {
	
	private final String nomeAeroporto;
	@SuppressWarnings("unused")
	private final int numeroPistas;
    private int contadorPistas;
    private final Boolean[] pistas;
    private final LinkedList<Integer> linhaEspera;

    protected Aeroporto(String nomeAeroporto, int numeroPistas) {
        this.nomeAeroporto = nomeAeroporto;
        this.numeroPistas = numeroPistas;
        contadorPistas = 0;
        linhaEspera = new LinkedList<Integer>();
        pistas = new Boolean[numeroPistas];
        for (int i = 0; i < numeroPistas; i++) {
            pistas[i] = true;
        }

    }

    protected synchronized int partir(int numeroVoo) { // partindo do aeroporto
    	linhaEspera.add(numeroVoo);
        System.out.println("Voo " + numeroVoo + " esperando para sair do aeroporto " + nomeAeroporto);

        while (!(contadorPistas < pistas.length && numeroVoo == (Integer) linhaEspera.getFirst())) {//verificando se existe uma faixa livre e se é o primeiro da fila
            try {
                wait();
            } catch (InterruptedException ignored) {
            }

        }
        int i = 0;
        for (; i < pistas.length; i++) { // pesquisando pista livre

            if (pistas[i])
                break;

        }
        pistas[i] = false;
        contadorPistas++;
        linhaEspera.removeFirst();
        System.out.println("Voo " + numeroVoo + " partindo " + nomeAeroporto + " do número da pista " + i);
        return i;
    }


    protected synchronized int pouso(int numeroVoo) {//pouso

    	linhaEspera.add(numeroVoo);
        System.out.println("Voo " + numeroVoo + " esperando para pousar no aeroporto " + nomeAeroporto);

        while (!(contadorPistas < pistas.length && numeroVoo == (Integer) linhaEspera.getFirst())) {
            try {
                wait();
            } catch (InterruptedException error) {
            }

        }
        int i = 0;
        for (; i < pistas.length; i++) {

            if (pistas[i])
                break;
        }
        pistas[i] = false;
        contadorPistas++;
        linhaEspera.removeFirst();
        System.out.println("Voo " + numeroVoo + " pousou em " + nomeAeroporto + " no número da pista " + i);
        return i;
    }

    protected synchronized void pistaLivre(int numeroVoo, int numeroPista) {//liberando uma pista e despertando todos os voos

        pistas[numeroPista] = true;
        contadorPistas--;
        notifyAll();
        System.out.println("Número da pista " + numeroPista + " está livre! Número do voo " + numeroVoo + " no aeroporto " + nomeAeroporto);
    }

}

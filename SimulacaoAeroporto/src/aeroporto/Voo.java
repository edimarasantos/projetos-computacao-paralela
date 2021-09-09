package aeroporto;

public class Voo extends Thread {
	
	private final int numeroVoo;
    private final Aeroporto nomePartida;
    private final Aeroporto nomeAterragem;

    public Voo(int numeroVoo, Aeroporto nomePartida, Aeroporto nomeAterragem) {
        this.numeroVoo = numeroVoo;
        this.nomePartida = nomePartida;
        this.nomeAterragem = nomeAterragem;
    }


    public void run() {

        int partidaLivre = nomePartida.partir(numeroVoo);
        partindo();
        nomePartida.pistaLivre(numeroVoo, partidaLivre);
        Voando();
        int aterrissagemLivre = nomeAterragem.pouso(numeroVoo);
        aterrissagem();
        nomeAterragem.pistaLivre(numeroVoo, aterrissagemLivre);
    }

    private void partindo() {
        int tempoPartida = (int) (Math.random() * 5000);
        try {
            Thread.sleep(tempoPartida);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void Voando() {
        int tempoVoando = (int) (Math.random() * 20000);
        System.out.println("Voo " + numeroVoo + " NO AR! ");

        try {
            Thread.sleep(tempoVoando);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private void aterrissagem() {
        int tempoPartida = (int) (Math.random() * 5000);
        try {
            Thread.sleep(tempoPartida);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

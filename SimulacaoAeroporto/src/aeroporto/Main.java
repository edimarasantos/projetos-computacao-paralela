package aeroporto;

//Projeto simulações de vôos em aeroportos

public class Main {

	public static void main(String[] args) {
		
		Aeroporto brasilAeroporto = new Aeroporto("Brasil", 3);
        Aeroporto euaAeroporto = new Aeroporto("Estados Unidos", 3);

        Voo[] voos = new Voo[10];

        for (int i = 0; i < voos.length; i++) {//
            int random = (int) (Math.random() * 4);

            switch (random) {

                case 0: {
                    voos[i] = new Voo(i, brasilAeroporto, euaAeroporto);
                    break;
                }
                case 1: {
                    voos[i] = new Voo(i, euaAeroporto, brasilAeroporto);
                    break;

                }
                case 2: {
                    voos[i] = new Voo(i, brasilAeroporto, brasilAeroporto);
                    break;

                }
                case 3: {
                    voos[i] = new Voo(i, euaAeroporto, euaAeroporto);
                    break;
                }

            }

        }

        for (Voo voo : voos) {
            voo.start();
        }

    }

}

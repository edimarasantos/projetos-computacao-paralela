package projeto;

public class Matriz {
	
	private int[][] doubleArray;
	
	Matriz(int numeroLinhas, int numeroColunas) {
	    doubleArray = new int[numeroLinhas][numeroColunas];
	}

	int getColunas() {
	    return doubleArray[0].length;
	}

	int getLinhas() {
	    return doubleArray.length;
	}

	double getValor(int linha, int coluna) {
	    return doubleArray[linha][coluna];
	}

	void setValor(int linha, int coluna, int valor) {
	    doubleArray[linha][coluna] = valor;
	}

}

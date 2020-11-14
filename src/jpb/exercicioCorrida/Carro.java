package jpb.exercicioCorrida;

import static java.lang.Math.random;

public class Carro extends Thread {

	private String nome = "";
	private int distancia = 0;

	// private static final int OP_PULO = 1;
	private static final int OP_ABASTECIMENTO = 2;
	private static int COLOCACAO = 0;

	public Carro(String nome) {
		this.nome = nome;
	}

	public void andar(int distanciaPercorrida) {
		if ((distanciaPercorrida + distancia) <= 100) {
			distancia = distancia + distanciaPercorrida;
		} else {
			distancia = 100;
		}
	}

	public void pitStop(long tempoPitStop) {
		try {
			Thread.sleep(tempoPitStop);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {


		iniciar_corrida();

		mostrar_resultados();

	}

	private void mostrar_resultados() {
		System.out.println(" == UM CARRO CHEGOU A LINHA DE CHEGADA ==");
		System.out.print(this);
	}

	public void iniciar_corrida() {
		final int FINAL_CORRIDA = 100;
		
		while (true) {
			if (distancia >= FINAL_CORRIDA) {
				break;
			}
			int opcao = (int) (random() * 10) + 1;
			if(opcao == OP_ABASTECIMENTO) {
				int pitStopTempo = ((int) (random() * 10) + 1) * 1000;
				System.out.println("O carro de " + nome + " entrou no Pit Stop por " + pitStopTempo / 1000+ " segundos.");
				pitStop(pitStopTempo);
			}else {
				int distanciaPercorrida = (int) (random() * 10) + 1;
				andar(distanciaPercorrida);
				System.out.println("O carro de " + nome + " andou " + distanciaPercorrida + " km.");
			}
		}
		COLOCACAO++;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		System.out.println("O CARRO DE " + nome + " OBTEU A COLOCAÇÃO " + COLOCACAO + "!");
		return builder.toString();
	}

}
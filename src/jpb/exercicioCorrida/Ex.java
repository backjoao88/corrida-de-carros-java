package jpb.exercicioCorrida;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex {

	public static void main(String[] args) throws InterruptedException {

		try (BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));) {

			Carro[] carros = new Carro[3];
			for (int k = 0; k < carros.length; k++) {
				System.out.print("Informe o nome do piloto " + (k + 1) + ": ");
				String nome = buff.readLine();
				carros[k] = new Carro(nome);
			}

			System.out.println("==============================================================");

			System.out.println("A CORRIDA VAI INICIAR, AGUARDE !!");

			System.out.println("==============================================================\n");

			Thread.sleep(2000);

			System.out.println("A CORRIDA FOI INICIADA !!!!\n");

			for (int k = 0; k < carros.length; k++) {
				carros[k].start();
			}

			for (int k = 0; k < carros.length; k++) {
				carros[k].join();
			}

			System.out.println("A CORRIDA TERMINOU !!!!");

		} catch (Exception e) {
			System.out.println("Algum erro ocorreu!");
		}

	}

}
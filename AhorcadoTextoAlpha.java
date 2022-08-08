package pruebasArrayRandom;

import java.util.Scanner;

public class AhorcadoTexto {

	// DEFINIR AS PALABRAS e as constantes, como o número de erros
	private static final String[] PALABRASOBJETIVOS = { "SANCHO", "QUIJOTE", "DULCINEA" };

	private static final int ERROS = 10;

	public static void main(String[] args) {

		// PEDIR LETRA POR PANTALLA
		Scanner teclado = new Scanner(System.in);

		// escoller ao azar a palabra obxetivo.
		int aleatorio = (int) (Math.random() * PALABRASOBJETIVOS.length); // numeros aleatorios do [0,2] para escoller
																			// aleatoriamente que
		// palabra sairá
		char[] palabraObjetivo = PALABRASOBJETIVOS[aleatorio].toCharArray(); //

		// VARIABLES
		char[] arrayDeFallos = new char[ERROS];
		char[] arrayDeAciertos = new char[palabraObjetivo.length];
		int contadorErros = 0;
		int contadorAcertos = 0;
		char letra;
		char letra2;
		boolean b = true; // por defecto, sempre vale true. É para salir do lazo cando se perda
		// char palabra[];
		char[] arrayDeLetrasProbadas = new char[palabraObjetivo.length + ERROS];
		System.out.println("Que palabra e?");
		for (int k = 0; k < palabraObjetivo.length; k++) {
			arrayDeAciertos[k] = '_'; // para que aparezcan '_' cando see está resolvendo a palabra, senon solo se
										// vían espazos en branco
			System.out.print(arrayDeAciertos[k] + " "); // Mostrase a palabra vacía, para que o xogador sepa de cantos
														// ocos se compon
		}
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Comeza o xogo!");

		// LAZOS DO PROGRAMA
		for (int i = 0; i < (arrayDeFallos.length + arrayDeAciertos.length); i++) { // para pedir a letra
			System.out.println("");
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
			System.out.println(""); // separadores, para ver máis claro entre cada xogada, senon pérdome
			boolean a = false; // cada letra que se introduce, a=false
			System.out.println("  ");
			System.out.println("Que letra queres probar?");
			letra = teclado.nextLine().charAt(0);

			// COMPROBACIÓN DE QUE A LETRA INTRODUCIDA NON SE REPITA
			for (int j = 0; j < arrayDeLetrasProbadas.length; j++) {
				while (letra == arrayDeLetrasProbadas[j]) {
					System.out.println("OLLO!!! Letra xogada. Por favor, introduce unha nova letra:");
					letra = teclado.nextLine().charAt(0);
				}
			}
			arrayDeLetrasProbadas[i] = letra; // gardase a letra no arrayDeLetrasProbadas[]

			// COMPROBAR SE A LETRA É CORRECTA
			for (int j = 0; j < palabraObjetivo.length; j++) {
				if (letra == palabraObjetivo[j]) {
					a = true;
					contadorAcertos++;
					arrayDeAciertos[j] = letra; // gardase a letra no array dos acertos
				}
			}
			// aqui salese do lazo de recorrer a palabra obxetivo

			// CANDO SE ACERTA COA LETRA
			if (a) {
				System.out.println("Correcto! Esa letra pertence a palabra a adiviñar.");
			}

			// CANDO SE ERRA COA LETRA
			if (a == false) {
				contadorErros++;
				arrayDeFallos[contadorErros - 1] = letra; // gardase a letra no array das letras non acertadas

				System.out.println("  ");
				// Imprimese o debuxo
				switch (contadorErros) {
				case 1:
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("       ");
					System.out.println("+------");
					break;
				case 2:
					System.out.println("+      ");
					System.out.println("|      ");
					System.out.println("|      ");
					System.out.println("|      ");
					System.out.println("|      ");
					System.out.println("+------");
					break;
				case 3:
					System.out.println("+----+");
					System.out.println("|      ");
					System.out.println("|      ");
					System.out.println("|      ");
					System.out.println("|      ");
					System.out.println("+------");
					break;
				case 4:
					System.out.println("+----+");
					System.out.println("|    | ");
					System.out.println("|      ");
					System.out.println("|      ");
					System.out.println("|      ");
					System.out.println("+------");
					break;
				case 5:
					System.out.println("+----+");
					System.out.println("|    |");
					System.out.println("|    ()");
					System.out.println("|      ");
					System.out.println("|      ");
					System.out.println("+------");
					break;
				case 6:
					System.out.println("+----+");
					System.out.println("|    |");
					System.out.println("|    ()");
					System.out.println("|    []");
					System.out.println("|      ");
					System.out.println("+------");
					break;
				case 7:
					System.out.println("+----+");
					System.out.println("|    |");
					System.out.println("|    ()");
					System.out.println("|   ![]");
					System.out.println("|      ");
					System.out.println("+------");
					break;
				case 8:
					System.out.println("+----+");
					System.out.println("|    |");
					System.out.println("|    ()");
					System.out.println("|   ![]! ");
					System.out.println("|       ");
					System.out.println("+------");
					break;
				case 9:
					System.out.println("+----+");
					System.out.println("|    |");
					System.out.println("|    ()");
					System.out.println("|   ![]!");
					System.out.println("|    ! ");
					System.out.println("+------");
					break;
				case 10:
					System.out.println("+----+");
					System.out.println("|    |");
					System.out.println("|    ()");
					System.out.println("|   ![]!");
					System.out.println("|    !!");
					System.out.println("+------");
					System.out.println("");
					System.out.println("Game Over");
					System.out.print("A palabra correcta era: ");
					for (int k = 0; k < palabraObjetivo.length; k++) {
						System.out.print(palabraObjetivo[k]);
					}
					b = false; // rematase, o xogo, polo que b=false
					break;
				default:
					b = false;
					break;
				}
			}

			if (b == false) { // para que se pare o xogo, xa que xa se chegou a situación de Game Over.
				break;
			}
			if (contadorAcertos == palabraObjetivo.length) {// que remate o xogo se se acertan todas as letras da
															// palabra obxetivo
				System.out.println(" ");
				System.out.println("Noraboa! Partida gañada.");
				break;
			}

			// MOSTRAR AS LETRAS COAS QUE SE XOGOU
			// cando se continua coa partida, porque ainda non rematou, mostranse as letras
			// introducidas, erradas e acertadas (no sitio correspondente)
			System.out.println("  ");
			System.out.print("As letras xogadas son:");
			for (int k = 0; k < arrayDeLetrasProbadas.length; k++) {
				System.out.print(arrayDeLetrasProbadas[k] + " ");
			}
			System.out.println("  ");
			System.out.print("As letras erradas son:");
			for (int k = 0; k < arrayDeFallos.length; k++) {
				System.out.print(arrayDeFallos[k] + " ");
			}
			System.out.println(" ");
			System.out.print("Actualmente, as túas pistas son: ");
			for (int k = 0; k < arrayDeAciertos.length; k++) {
				System.out.print(arrayDeAciertos[k] + " ");
			}

			// INTENTAR ACERTAR A PALABRA DIRECTAMENTE
			System.out.println(" ");
			System.out.println("Queres intentar resolver a palabra? s/n ");
			letra2 = teclado.nextLine().charAt(0);
			if (letra2 == 's') { // se a resposta é positiva, comprobar se é correcta
				int contadorAcertos2 = 0; // inicializador dentro do propio lazo, porque se está fora vai sumando xogada
											// tras xogada. Ten que estar a cero ao comezo da xogada
				System.out.println("Introducir a palabra que se crea correcta: ");
				char palabra[] = teclado.nextLine().toCharArray();
				for (int k = 0; k < palabraObjetivo.length; k++) { // comprobación de se a palabra introducida é a
																	// correcta
					if (palabra[k] == palabraObjetivo[k])
						contadorAcertos2++;
				}
				if (contadorAcertos2 == palabraObjetivo.length) {// que remate o xogo se se acerta directamente a
																	// PALABRAOBJETIVO[]
					System.out.println(" ");
					System.out.println("Noraboa! Partida gañada.");
					break;
				}
			} else if (letra2 == 'n') // no caso de non querer introducir a palabra directamente, que se continue
										// xogando
				continue;
			else
				System.out.println("Non é unha opción correcta. Continuamos co xogo."); // no caso de que se introduzan
																						// outras letras sen ser s ou n
		}

		teclado.close();
	}
}
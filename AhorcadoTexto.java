/*Rosa Castineiras Farina
 * 06/12/2020
 * Xogo do aforcado
 * */

package pruebasArrayRandom;

import java.util.Scanner;

public class AhorcadoTexto {

	// DEFINIR AS PALABRAS e as constantes, como o número de erros
	private static final String[] PALABRASOBJETIVOS = { "SANCHO", "QUIJOTE", "DULCINEA", "ROCINANTE", "RUCIO" };
	private static final int ERROS = 10;

	// OS DEBUXOS DE CANDO SE ERRA
	private static final String DEBUXO1 = "       " + System.lineSeparator() + "       " + System.lineSeparator()
			+ "       " + System.lineSeparator() + "       " + System.lineSeparator() + "       "
			+ System.lineSeparator() + "+------";
	private static final String DEBUXO2 = "+      " + System.lineSeparator() + "|      " + System.lineSeparator()
			+ "|      " + System.lineSeparator() + "|      " + System.lineSeparator() + "|      "
			+ System.lineSeparator() + "+------";
	private static final String DEBUXO3 = "+----+ " + System.lineSeparator() + "|      " + System.lineSeparator()
			+ "|      " + System.lineSeparator() + "|      " + System.lineSeparator() + "|      "
			+ System.lineSeparator() + "+------";
	private static final String DEBUXO4 = "+----+ " + System.lineSeparator() + "|    | " + System.lineSeparator()
			+ "|      " + System.lineSeparator() + "|      " + System.lineSeparator() + "|      "
			+ System.lineSeparator() + "+------";
	private static final String DEBUXO5 = "+----+ " + System.lineSeparator() + "|    | " + System.lineSeparator()
			+ "|    ()" + System.lineSeparator() + "|      " + System.lineSeparator() + "|      "
			+ System.lineSeparator() + "+------";
	private static final String DEBUXO6 = "+----+ " + System.lineSeparator() + "|    | " + System.lineSeparator()
			+ "|    ()" + System.lineSeparator() + "|    []" + System.lineSeparator() + "|      "
			+ System.lineSeparator() + "+------";
	private static final String DEBUXO7 = "+----+ " + System.lineSeparator() + "|    | " + System.lineSeparator()
			+ "|    ()" + System.lineSeparator() + "|   ![]" + System.lineSeparator() + "|      "
			+ System.lineSeparator() + "+------";
	private static final String DEBUXO8 = "+----+  " + System.lineSeparator() + "|    |  " + System.lineSeparator()
			+ "|    () " + System.lineSeparator() + "|   ![]!" + System.lineSeparator() + "|       "
			+ System.lineSeparator() + "+------ ";
	private static final String DEBUXO9 = "+----+  " + System.lineSeparator() + "|    |  " + System.lineSeparator()
			+ "|    () " + System.lineSeparator() + "|   ![]!" + System.lineSeparator() + "|    !  "
			+ System.lineSeparator() + "+------ ";
	private static final String DEBUXO10 = "+----+  " + System.lineSeparator() + "|    |  " + System.lineSeparator()
			+ "|    () " + System.lineSeparator() + "|   ![]!" + System.lineSeparator() + "|    !! "
			+ System.lineSeparator() + "+------ " + System.lineSeparator() + " " + System.lineSeparator() + "Game Over";

	public static void main(String[] args) {

// PEDIR LETRA POR PANTALLA
		Scanner teclado = new Scanner(System.in);

// ESCOLLER AO AZAR A PALABRA OBXETIVO
		int aleatorio = (int) (Math.random() * PALABRASOBJETIVOS.length); // numeros aleatorios do [0,4] para escoller
																			// aleatoriamente que palabra sairá -- 3 num
		char[] palabraObjetivo = PALABRASOBJETIVOS[aleatorio].toCharArray();

// VARIABLES
		char[] arrayDeFallos = new char[ERROS];
		char[] arrayDeAciertos = new char[palabraObjetivo.length];
		for (int k = 0; k < palabraObjetivo.length; k++) {
			arrayDeAciertos[k] = '_'; // para que aparezcan '_' cando see está resolvendo a palabra, senon solo se
										// vían espazos en branco
		}
		char[] arrayDeLetrasProbadas = new char[palabraObjetivo.length + ERROS];
		char letra;
		char sn;
		int contadorErros = 0;
		boolean eLetraRepetida; // para comprobar se a letra esta repetida
		boolean eLetraCorrecta; // para comprobar se se acertou a letra na palabra obxetivo
		boolean ePalabraCorrecta;
		boolean sair = false;

//MOSTRAR A PALABRAOBXETIVO POR PANTALLA
		System.out.println("Que palabra e?");
		mostrarLetras(arrayDeAciertos, arrayDeAciertos.length);
		System.out.println(" ");
		System.out.println("Comeza o xogo!");

// LAZOS DO PROGRAMA
		for (int i = 0; i < (arrayDeFallos.length + arrayDeAciertos.length); i++) { // para pedir a letra
			System.out.println("");
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
			System.out.println(""); // separadores, para ver máis claro entre cada xogada, senon pérdome

// MÉTODO PARA PEDIR LETRA
			letra = pedirLetra(teclado);
			eLetraRepetida = estaRepetida(letra, arrayDeLetrasProbadas, arrayDeLetrasProbadas.length);
			while (eLetraRepetida) { // namentres eLetraRepetida sexa verdadeiro, significa que a letra
										// e repetida,
				// polo que se repite o lazo de pedir letra e comprobala
				letra = pedirLetra(teclado);
				eLetraRepetida = estaRepetida(letra, arrayDeLetrasProbadas, arrayDeLetrasProbadas.length);
			}
			arrayDeLetrasProbadas[i] = letra; // unha vez fora do bucle, eLetraRepetida vai valer falso, polo que se
												// garda a letra no arrayDeLetrasProbadas

// COMPROBAR SE A LETRA É CORRECTA NA PALABRA
			eLetraCorrecta = comprobarLetra(letra, palabraObjetivo, arrayDeAciertos, palabraObjetivo.length);

// CANDO SE ACERTA COA LETRA
			if (eLetraCorrecta) {
				System.out.println("Correcto! Esa letra pertence a palabra a adiviñar.");
				// contadorAcertos++;
			}

// CANDO SE ERRA COA LETRA
			if (!eLetraCorrecta) {
				contadorErros++; // así lévase a conta de cantas veces se fallou. Esta variable suma aqui,non nos
									// metodos. Aos métodoso pasaselle por parametro
				arrayDeFallos[contadorErros - 1] = letra; // gardase a letra no array das letras non acertadas
				mostrarErros(contadorErros, palabraObjetivo, palabraObjetivo.length);
			}

			if (contadorErros == ERROS) { // para que se pare o xogo, xa que xa se chegou a situación de Game Over.
				System.out.print("A palabra correcta era: "); // para mostrar a solucion
				mostrarLetras(palabraObjetivo, palabraObjetivo.length);
				break;
			}

//CANDO SE GAÑA
			if (ePalabra(palabraObjetivo, palabraObjetivo.length, arrayDeAciertos))
				break;

// MOSTRAR AS LETRAS COAS QUE SE XOGOU
			// cando se continua coa partida, porque ainda non rematou, mostranse as letras
			// introducidas, erradas e acertadas (no sitio correspondente)
			System.out.println("  ");
			System.out.print("As letras xogadas son: ");
			mostrarLetras(arrayDeLetrasProbadas, arrayDeLetrasProbadas.length);
			System.out.println("  ");
			System.out.print("As letras erradas son: ");
			mostrarLetras(arrayDeFallos, arrayDeFallos.length);
			System.out.println(" ");
			System.out.print("Actualmente, as túas pistas son: ");
			mostrarLetras(arrayDeAciertos, arrayDeAciertos.length);

// INTENTAR ACERTAR A PALABRA DIRECTAMENTE
			System.out.println(" ");
			System.out.println("Queres intentar resolver a palabra? s/n ");
			sn = teclado.nextLine().charAt(0);
			if (sn == 's') { // se a resposta é positiva, comprobar se é correcta
				System.out.println("Introducir a palabra que se crea correcta: ");
				char[] palabra = teclado.nextLine().toCharArray();
				// comprobar que a palabra que introduce o usuario ten a mesma lonxitude que a
				// palabraObjetivo.
				if (palabra.length == palabraObjetivo.length) {
					ePalabraCorrecta = ePalabra(palabraObjetivo, palabraObjetivo.length, palabra);
					if (ePalabraCorrecta) { // no caso de acertar a palabra, sairse do xogo
						sair = true;
						break;
					} else {
						System.out.println("So sorry, non é a palabra que se busca.");
						contadorErros++; // no caso de fallar a palabra, que conte como erro e continuar coa partida
						mostrarErros(contadorErros, palabraObjetivo, palabraObjetivo.length);
					}
					// no caso de fallar, continuar xogando, pero non me conta erro!!!
				} else {
					System.out.println("So sorry, non é a palabra que se busca.");
					contadorErros++; // no caso de fallar a palabra, que conte como erro e continuar coa partida
					mostrarErros(contadorErros, palabraObjetivo, palabraObjetivo.length);
					continue;
				}
				if (sair) {
					break;
				}

			} else if (sn == 'n') // no caso de non querer introducir a palabra directamente, que se continue
									// xogando
				continue;
			else
				System.out.println("Non é unha opción correcta. Continuamos co xogo."); // no caso de que se introduzan
																						// outras letras sen ser s ou n
		}

		teclado.close();
	}

	private static boolean ePalabra(char[] palabraObjetivo, int length, char[] palabra) {
		int contador = 0; // para saber cantas letras se acertaron, e poder dicir se se acertou a palabra
		boolean a = false;// unha variable booleana para que o método devolva true or false por parametro
		for (int k = 0; k < length; k++) { // comprobación de se a palabra introducida é a
			// correcta
			if (palabra[k] == palabraObjetivo[k])
				contador++;
		}
		if (contador == palabraObjetivo.length) {// que remate o xogo se se acerta directamente a
			// PALABRAOBJETIVO[]
			a = true;
			System.out.println(" ");
			System.out.println("Noraboa! Partida gañada.");
			mostrarLetras(palabraObjetivo, palabraObjetivo.length);
		}
		return a;
	}

//MOSTRA OS ERROS COMO MÉTODO EXTERNO
	private static void mostrarErros(int contadorErros, char[] array, int length) {

		System.out.println("  ");
		// Imprimese o debuxo
		switch (contadorErros) {
		case 1:
			System.out.println(DEBUXO1);
			break;
		case 2:
			System.out.println(DEBUXO2);
			break;
		case 3:
			System.out.println(DEBUXO3);
			break;
		case 4:
			System.out.println(DEBUXO4);
			break;
		case 5:
			System.out.println(DEBUXO5);
			break;
		case 6:
			System.out.println(DEBUXO6);
			break;
		case 7:
			System.out.println(DEBUXO7);
			break;
		case 8:
			System.out.println(DEBUXO8);
			break;
		case 9:
			System.out.println(DEBUXO9);
			break;
		case 10:
			System.out.println(DEBUXO10);
			break;
		default:
			contadorErros = ERROS; // nunca se vai a dar esta situacion, pero de todas formas ponselle que e a
									// situacion de perdida
			break;
		}
	}

	private static boolean comprobarLetra(char letra, char[] palabraObjetivo, char[] array, int length) {
		boolean eAcertada = false;
		for (int i = 0; i < length; i++) {
			if (letra == palabraObjetivo[i]) {
				array[i] = letra; // que sustituia o valor da letra acertada no arrayDeAciertos
				eAcertada = true;
			}
		}
		return eAcertada;
	}

	private static char pedirLetra(Scanner teclado) { // este metodo permite pedir a letra ao xogador. A entrada é o que
														// pregunta pola letra
		System.out.println("  ");
		System.out.println("Que letra queres probar? ");
		char letra = ' ';
		try { // controlase que non se introduzcan enters, ou caracteres non desexados, con un
				// control de excepciosn try...catch. Isto so permite introducir unha vez un
				// salto de liña
			letra = teclado.nextLine().charAt(0);
		} // introducese a letra como o primeiro caracter da lina. Non fai
			// distincións entre maiúsculas e minúsculas
		catch (StringIndexOutOfBoundsException e) {
			System.out.println("Proba a meter unha letra, non un salto de liña: ");
			letra = teclado.nextLine().charAt(0);
		}

		return letra; // este metodo ten unha saida, que e a letra que introduce o usuario
	}

	private static boolean estaRepetida(char letris, char[] array, int numero) {
		boolean a = false; // por defecto, a letra non esta repetida
		for (int i = 0; i < numero; i++) {
			if (letris == array[i]) { // se coincide que a letra está incluida no array de letras xogadas, o metodo
										// devolve true, que si que está repetida
				a = true;
				break;
			}
		}
		return a;
	}

	private static void mostrarLetras(char[] array, int length) {
		for (int k = 0; k < length; k++) {
			System.out.print(array[k] + " ");
		}
		System.out.println("  ");
	}
}

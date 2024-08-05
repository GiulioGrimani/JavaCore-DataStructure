package com.main;

public class Main1Array {

	public static void main(String[] args) {
		/*
		 * ARRAY - STRUTTURA DATI STATICA
		 * 
		 * Una definizione molto precisa di cosa e' un array e' la seguente: e' una
		 * struttura dati che raccoglie sotto un unico nome un insieme indicizzato di
		 * variabili dello stesso tipo.
		 * 
		 * Abbiamo sostanzialmente due modi per dichiarare e valorizzare un array:
		 * possiamo usare l'operatore di allocazione "new" specificando tra parentesi
		 * quadre la dimensione dell'array:
		 */
		int[] numeri = new int[3];

		/*
		 * oppure possiamo specificare anche il contenuto dell'array (i due modi qui
		 * sotto sono del tutto equivalenti):
		 */

		/*-                 indici:   0    1    2    3    4    */
		char[] vocali = new char[] { 'a', 'e', 'i', 'o', 'u' };

		/*-       indici:       0        1         2           */
		String[] persone = { "Tizio", "Caio", "Sempronio" };

		/*
		 * in ogni caso, ciascun array ha allocato (riservato) nella memoria (heap) un
		 * numero predefinito di "celle" contigue. Per quanto riguarda gli array
		 * "vocali" e "persone", queste celle contengono i valori specificati in fase di
		 * dichiarazione. Per quanto riguarda l'array "numeri", non avendo specificato
		 * alcun valore, le sue celle contengono il valore di default (che per gli int
		 * e' 0).
		 * 
		 * Quel che importa capire e' che la dimensione di questi array e' stata fissata
		 * ora, a compile-time, e non potra' cambiare a run-time. Per questo gli array
		 * vengono definiti strutture dati STATICHE.
		 * 
		 * Gli indici partono sempre da 0 e sono usati per far riferimento ad ogni
		 * singola cella dell'array:
		 */
		numeri[0] = 100; // <-- assegno alla prima cella dell'array il valore 100
		numeri[1] = 200;
		numeri[2] = 300;
		numeri[3] = 400; // sto cercando di scrivere 400 sulla quarta cella (indice 3) dell'array
		// "numeri", che e' lungo 3 celle. Questa istruzione generera' a run-time una
		// ArrayIndexOutOfBoundException

		char a = vocali[0]; // <-- assegno al char "a" il valore contenuto nella prima cella dell'array
		char e = vocali[1];
		char i = vocali[2];
		char o = vocali[3];
		char u = vocali[4];
//		char y = vocali[5]; // stesso discorso di prima: vocali[5] non esiste

		/*
		 * Gli array NON sono primitive, sono oggetti complessi e in quanto tali hanno
		 * una (sola) proprieta' interna che indica la dimensione dell'array. Tale
		 * proprieta' e' di tipo int, e' public e si chiama "length":
		 */
		int dimensioneArrayNumeri = numeri.length; // vale 3
		int numeroVocali = vocali.length; // vale 5
		int numeroPersone = persone.length; // vale 3

		/*
		 * Viene tipicamente usata quando si vuole iterare sull'array con un ciclo for:
		 */
		System.out.println("Stampo l'array \"vocali\" col for tradizionale:");
		System.out.print("indici: 0\t1\t2\t3\t4\nvocali:");
		for (int indice = 0; indice < vocali.length; indice++) {
			char vocaleCorrente = vocali[indice];
			System.out.print("\t" + vocaleCorrente);
		}

		/*
		 * Tuttavia questo non e' l'unico modo che abbiamo di iterare su una collezione
		 * di elementi. Un altro modo molto popolare e' il for each, anche detto
		 * "enhanced for":
		 */
		System.out.println("\n\nStampo l'array \"persone\" col for each:");
		for (String persona : persone) {
			System.out.print(persona + "\t");
		}
		/*
		 * Possiamo leggerlo nel seguente modo: per ogni elemento di tipo String che
		 * chiamo "persona" all'interno della mia collezione di String chiamata
		 * "persone". La reference "persona" e' locale al for (come la variabile
		 * "indice" nel for tradizionale di prima), e di volta in volta fa riferimento a
		 * tutti gli elementi dell'array: alla prima iterazione fa riferimento al primo
		 * elemento dell'array, alla seconda iterazione fa riferimento al secondo
		 * elemento dell'array, ecc ecc. Non abbiamo piu' ne' l'indice ne' la condizione
		 * di permanenza all'interno del ciclo: viene gestito tutto internamente.
		 * Ulteriore caratteristica del for each e' che la reference usata per iterare
		 * su tutti gli elementi della collezione NON puo' essere primitiva. Quindi se
		 * si vuole iterare su un array di primitive bisognera' usare la relativa classe
		 * Wrapper:
		 */
		for (Character vocale : vocali) {
			// fai qualcosa
		}

	}

}

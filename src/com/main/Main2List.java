package com.main;

import java.util.ArrayList;
import java.util.List;

import com.model.Dog;
import com.model.Person;

public class Main2List {

	public static void main(String[] args) {
		/*-
		 * LIST - STRUTTURA DATI DINAMICA
		 * 
		 * List<T> e' un'interfaccia del framework delle Collection che offre delle
		 * strutture dati in grado di modificare la propria dimensione a run-time. Per
		 * questo, vengono definite DINAMICHE. Le classi concrete che implementano tale
		 * interfaccia sono:
		 * 
		 * - ArrayList
		 * - LinkedList
		 * - Vector
		 * 
		 * Le API offerte, a parte qualche metodo caratteristico di questa o quella
		 * implementazione, sono pressoche' le stesse. Useremo l'ArrayList in quanto
		 * piu' performante nella stragrande maggioranza degli scenari.
		 * 
		 * Possiamo vedere l'ArrayList come un wrapper di un array.
		 * 
		 * Partiamo con la dichiarazione:
		 */
		List<Person> amici = new ArrayList<>();

		/*
		 * Il costruttore vuoto crea un ArrayList con una capacita' iniziale di 10
		 * elementi. Se pensiamo che la nostra lista dovra' contenere molti piu'
		 * elementi, e' bene fare una stima e passare tale stima come parametro al
		 * costruttore, per evitare che la lista venga continuamente ridimensionata a
		 * run-time:
		 */
		List<String> vocabolario = new ArrayList<>(250000);

		/*
		 * Sebbene la capacita' iniziale delle liste create non sia zero, il numero di
		 * elementi inizialmente presenti all'interno delle liste e' zero. Il metodo
		 * size restituisce il numero di elementi presenti all'interno della lista:
		 */
		int numeroAmici = amici.size();
		int numeroParole = vocabolario.size();
		System.out.println("Numero di amici: " + numeroAmici + "\nNumero parole: " + numeroParole);

		/*
		 * INSERIMENTO
		 * 
		 * L'API ci fornisce 4 tipi di inserimento:
		 */

		// di un singolo elemento: avviene in coda alla lista
		vocabolario.add("elemento");
		vocabolario.add("oggetto");
		System.out.println("\nStampo il vocabolario:\n" + vocabolario + "\nDimensione: " + vocabolario.size());

		// di un singolo elemento in una determinata posizione
		vocabolario.add(1, "hotel");
		System.out.println("\nStampo il vocabolario:\n" + vocabolario + "\nDimensione: " + vocabolario.size());

		// di una collezione di elementi dello stesso tipo: avviene in coda alla lista
		List<String> paroleConLaZ = new ArrayList<>();
		paroleConLaZ.add("zio");
		paroleConLaZ.add("zotico");
		paroleConLaZ.add("zuzzurellone");

		vocabolario.addAll(paroleConLaZ);
		System.out.println("\nStampo il vocabolario:\n" + vocabolario + "\nDimensione: " + vocabolario.size());

		// di una collezione di elementi dello stesso tipo in una determinata posizione
		List<String> paroleConLaA = new ArrayList<>();
		paroleConLaA.add("abaco");
		paroleConLaA.add("alieno");
		paroleConLaA.add("azzerare");

		vocabolario.addAll(0, paroleConLaA);
		System.out.println("\nStampo il vocabolario:\n" + vocabolario + "\nDimensione: " + vocabolario.size());

		/*
		 * LETTURA
		 * 
		 * Per recuperare un elemento dalla lista, abbiamo il classico get sull'indice:
		 */

		String parola3 = vocabolario.get(3);
		System.out.println("\nLa parola del vocabolario di indice 3 e': " + parola3);

		/*
		 * AGGIORNAMENTO
		 * 
		 * Anche qui, abbiamo il classico set sull'indice:
		 */

		vocabolario.set(3, "elementare");
		parola3 = vocabolario.get(3);
		System.out.println("\nStampo il vocabolario:\n" + vocabolario + "\nDimensione: " + vocabolario.size());
		System.out.println("Dopo la modifica, la parola del vocabolario di indice 3 e': " + parola3);

		/*
		 * anche se spesso, quando abbiamo una lista di oggetti complessi, con
		 * "aggiornare un elemento" intendiamo semplicemente modificare le proprieta'
		 * interne dell'oggetto usando la sua reference:
		 */
		Person p1 = new Person("Tizio");
		Person p2 = new Person("Caio");
		Person p3 = new Person("Sempronio");
		List<Person> persone = new ArrayList<>();
		persone.add(p1);
		persone.add(p2);
		persone.add(p3);
		System.out.println("\nStampo List<Person>:\n" + persone);
		p2.setFirstName("Barbara");
		System.out.println("\nStampo List<Person> dopo aver modificato le proprieta' di p2:\n" + persone);

		/*
		 * RIMOZIONE
		 * 
		 * Anche qui l'API ci fornisce 4 modi diversi per rimuovere elementi. Tuttavia
		 * la rimozione e' un'operazione un pelino piu' delicata e necessita di
		 * particolare attenzione se vogliamo che due dei quattro metodi di rimozione si
		 * comportino come ci si aspetta.
		 * 
		 * Dobbiamo difatti porre attenzione ai due metodi che fanno la rimozione degli
		 * elementi prendendo in input gli oggetti da rimuovere. Questi due metodi hanno
		 * un comportamento diverso a seconda del fatto che sia stato ridefinito o meno
		 * l'equals all'interno della classe. Ma andiamo con ordine:
		 */

		// Creo una lista di cani. Nella classe Dog NON e' stato ridefinito l'equals
		List<Dog> cani = new ArrayList<>();
		Dog d1 = new Dog("Bobby");
		Dog d2 = new Dog("Fido");
		Dog d3 = new Dog("Lessie");
		Dog d4 = new Dog("Rin tin tin");
		Dog d5 = new Dog("Pluto");
		Dog d6 = new Dog("Scooby Doo");
		Dog d7 = new Dog("Balto");
		Dog d8 = new Dog("Santa's Little Helper");
		Dog d9 = new Dog("Snoopy");
		Dog d10 = new Dog("Brian");
		cani.add(d1);
		cani.add(d2);
		cani.add(d3);
		cani.add(d4);
		cani.add(d5);
		cani.add(d6);
		cani.add(d7);
		cani.add(d8);
		cani.add(d9);
		cani.add(d10);

		// Aggiungo altrettante persone alla lista di persone, classe in cui e' stato
		// ridefinito l'equals
		Person p4 = new Person("Robert");
		Person p5 = new Person("Alice");
		Person p6 = new Person("Jack");
		Person p7 = new Person("Tim");
		Person p8 = new Person("Tom");
		Person p9 = new Person("John");
		Person p10 = new Person("Paul");
		persone.add(p4);
		persone.add(p5);
		persone.add(p6);
		persone.add(p7);
		persone.add(p8);
		persone.add(p9);
		persone.add(p10);

		System.out.println("\nStampo List<Person> (con equals):\n" + persone + "\nDimensione: " + persone.size());
		System.out.println("\nStampo List<Dog> (senza equals):\n" + cani + "\nDimensione: " + cani.size());

		// rimozione tramite indice: nessun problema
		persone.remove(1);
		cani.remove(1);
		System.out.println("\nDopo la rimozione dell'elemento di indice 1:");
		System.out.println("\nStampo List<Person> (con equals):\n" + persone + "\nDimensione: " + persone.size());
		System.out.println("\nStampo List<Dog> (senza equals):\n" + cani + "\nDimensione: " + cani.size());

		// rimozione tramite lambda (vedremo piu' avanti le lambda): nessun problema se
		// la lambda non usa il metodo equals
		persone.removeIf(persona -> persona.getFirstName().length() == 3);
		cani.removeIf(cane -> cane.getName().endsWith("y"));
		System.out.println("\nDopo la rimozione con le lambda:");
		System.out.println("\nStampo List<Person> (con equals):\n" + persone + "\nDimensione: " + persone.size());
		System.out.println("\nStampo List<Dog> (senza equals):\n" + cani + "\nDimensione: " + cani.size());

		// rimozione tramite Object: nella lista dove e' ridefinito l'equals (persone)
		// la rimozione di un elemento funziona come ci si aspetta:
		persone.remove(p1); // rimuove la reference di Tizio
		persone.remove(new Person("Sempronio")); // rimuove l'oggetto uguale a Sempronio
		System.out.println("\nDopo la rimozione con l'Object:");
		System.out.println("\nStampo List<Person> (con equals):\n" + persone + "\nDimensione: " + persone.size());

		// nella lista dove NON e' stato ridefinito l'equal, funziona solo la rimozione
		// delle reference, mentre quella che rimuove l'oggetto new Dog non funziona in
		// quanto la classe non ha ridefinito il metodo per verificare se due oggetti
		// sono uguali
		cani.remove(d5); // rimuove la reference di Pluto
		cani.remove(new Dog("Rin tin tin")); // idealmente dovrebbe rimuovere l'oggetto uguale a Rin tin tin, ma cerca
												// semplicemente di rimuovere la stessa reference, ed essendo l'oggetto
												// creato col new, ovviamente non trova reference uguali da rimuovere
		System.out.println("\nStampo List<Dog> (senza equals):\n" + cani + "\nDimensione: " + cani.size());

		// Stesso identico discorso per la rimozione tramite collection
		List<Person> personeDaRimuovere = new ArrayList<>();
		personeDaRimuovere.add(p4); // reference di Robert
		personeDaRimuovere.add(new Person("Alice"));
		persone.removeAll(personeDaRimuovere);

		System.out.println("\nDopo la rimozione con la Collection:");
		System.out.println("\nStampo List<Person> (con equals):\n" + persone + "\nDimensione: " + persone.size());

		List<Dog> caniDaRimuovere = new ArrayList<>();
		caniDaRimuovere.add(d3);// reference di Lessie: l'unica che riuscira' a rimuovere
		caniDaRimuovere.add(new Dog("Rin tin tin"));
		cani.removeAll(caniDaRimuovere);
		System.out.println("\nStampo List<Dog> (senza equals):\n" + cani + "\nDimensione: " + cani.size());

		/*
		 * Stesso identico discorso vale anche per il metodo contains, che ti dice se il
		 * parametro passato in input e' presente all'interno della lista:
		 */
		boolean found = persone.contains(p6); // reference di Jack
		System.out.println("\nPersone contiene Jack? " + found);
		found = persone.contains(new Person("John"));
		System.out.println("Persone contiene John? " + found);
		found = cani.contains(d10); // reference di Brian
		System.out.println("Cani contiene Brian? " + found);
		found = cani.contains(new Dog("Balto"));
		System.out.println("Cani contiene Balto? " + found);

		/*
		 * Infine, vale la pena menzionare due metodi di frequente utilizzo: il clear e
		 * l'isEmpty. Il primo rimuove tutti gli elementi all'interno della lista, il
		 * secondo ti dice se la lista e' vuota:
		 */
		boolean isEmpty = persone.isEmpty();
		System.out.println("\nLa List<Person> e' vuota? " + isEmpty);
		persone.clear();
		isEmpty = persone.isEmpty();
		System.out.println("La List<Dog> e' vuota? " + isEmpty);

		/*-
		 * Concludiamo elencando i tratti distintivi delle List:
		 * 
		 * 1. una List ammette duplicati
		 * 2. l'ordine di inserimento nella List viene preservato all'interno della List
		 */
		persone.add(p7); // Tim
		persone.add(p8); // Tom
		persone.add(p9); // John
		persone.add(new Person("Tim"));
		persone.add(p8);
		persone.add(p9);
		System.out.println("\nStampo List<Person>:\n" + persone
				+ "\nL'ordine di inserimento e' preservato e sono presenti duplicati");
	}
}

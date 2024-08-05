package com.main;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import com.model.Cat;
import com.model.Person;

public class Main3Set {

	public static void main(String[] args) {

		/*-
		 * SET - STRUTTURA DATI DINAMICA
		 * 
		 * Come la List<T>, anche la Set<T> e' un'interfaccia del framework Collection
		 * che offre diverse strutture dati in grado di modificare la propria dimensione
		 * a run-time. Come si evince dalla foto, troviamo anche qui tre implementazioni
		 * concrete:
		 * 
		 * - HashSet
		 * - LinkedHashSet
		 * - TreeSet
		 * 
		 * Il tratto distintivo dei Set e' che, a differenza delle List, NON ammettono
		 * duplicati.
		 * 
		 * Per quanto riguarda invece l'ordine degli elementi, la situazione varia a
		 * seconda dell'implementazione che scegliamo di usare:
		 * 
		 * - HashSet NON preserva l'ordine di inserimento, e l'ordine degli elementi
		 * all'interno del Set non segue una politica particolare. Ammette un solo
		 * elemento null
		 * 
		 * - LinkedHashSet preserva l'ordine di inserimento. Ammette un solo elemento
		 * null
		 * 
		 * - TreeSet NON preserva l'ordine di inserimento perche' inserisce gli elementi
		 * all'interno del Set in modo ordinato in base al Comparable definito
		 * (altrimenti in ordine ascendente). Non ammette elementi null
		 * 
		 * Per questi motivi, il TreeSet e' tra i Set quello meno efficiente in termini
		 * prestazionali, mentre l'HashSet e' il piu' efficiente. A meno di esigenze
		 * particolari, quest'ultimo e' quello generalmente piu' usato.
		 */

		// Dimostrazione delle differenze tra List e Set e tra i vari tipi di Set:
		Set<String> myHashSet = new HashSet<>();
		myHashSet.add("Uno");
		myHashSet.add("Uno"); // duplicato
		myHashSet.add("Due");
		myHashSet.add("Tre");
		myHashSet.add("Quattro");
		myHashSet.add("Cinque");
		myHashSet.add("Sei");
		myHashSet.add(null);

		Set<String> myLinkedHashSet = new LinkedHashSet<>();
		myLinkedHashSet.add("Uno");
		myLinkedHashSet.add("Uno"); // duplicato
		myLinkedHashSet.add("Due");
		myLinkedHashSet.add("Tre");
		myLinkedHashSet.add("Quattro");
		myLinkedHashSet.add("Cinque");
		myLinkedHashSet.add("Sei");
		myLinkedHashSet.add(null);

		Set<String> myTreeSet = new TreeSet<>();
		myTreeSet.add("Uno");
		myTreeSet.add("Uno"); // duplicato
		myTreeSet.add("Due");
		myTreeSet.add("Tre");
		myTreeSet.add("Quattro");
		myTreeSet.add("Cinque");
		myTreeSet.add("Sei");
//		myTreeSet.add(null); // lancia un'eccezione

		System.out.println("HashSet: \t" + myHashSet);
		System.out.println("LinkedHashSet: \t" + myLinkedHashSet);
		System.out.println("TreeSet: \t" + myTreeSet);

		/*
		 * Molti dei metodi visti per le List li ritroviamo anche per i Set, tuttavia
		 * essendo l'interfaccia Set di base intesa come una Collection non ordinata,
		 * non sono presenti gli indici. Quindi tutti quei metodi delle List che si
		 * basano sugli indici non sono presenti nei Set.
		 * 
		 * Osserviamo inoltre che le implementazioni piu' comuni dei Set<T> utilizzano
		 * funzioni di hash per associare univocamente un numero ad un oggetto. Questo
		 * significa che, come per le List<T> ed il metodo equals, se la classe T non
		 * ridefinisce sia il metodo equals che il metodo hashCode, il comportamento dei
		 * metodi che hanno come parametro in input degli oggetti potrebbe essere
		 * inatteso:
		 */

		System.out.println("\nOperazioni sulla ADD");
		// Set di Person che ridefinisce sia il metodo equals che hashCode
		Set<Person> persone = new HashSet<>();
		Person p1 = new Person("Alice");
		Person p2 = new Person("Bob");
		persone.add(p1);
		persone.add(p1); // provo a inserire due volte la stessa reference "Alice"
		persone.add(p2);
		persone.add(new Person("Bob")); // provo ad inserire due volte un oggetto con stato "Bob"
		System.out.println("\nStampo Set<Person> (con hashCode):\n" + persone + "\nDimensione: " + persone.size());

		// Set di Cat che ridefinisce il metodo equals ma NON l'hashCode
		Set<Cat> gatti = new HashSet<>();
		Cat c1 = new Cat("Felix");
		Cat c2 = new Cat("Stregatto");
		gatti.add(c1);
		gatti.add(c1); // provo a inserire due volte la stessa reference "Felix"
		gatti.add(c2);
		gatti.add(new Cat("Stregatto")); // inserisco due volte un oggetto con lo stesso stato "Stregatto"
		System.out.println("\nStampo Set<Cat> (senza hashCode):\n" + gatti + "\nDimensione: " + gatti.size());

		System.out.println("\nOperazioni sulla REMOVE");

		persone.remove(new Person("Bob")); // effettua la rimozione
		System.out.println("\nStampo Set<Person> (con hashCode):\n" + persone + "\nDimensione: " + persone.size());

		gatti.remove(new Cat("Stregatto")); // non effettua la rimozione
		System.out.println("\nStampo Set<Cat> (senza hashCode):\n" + gatti + "\nDimensione: " + gatti.size());

		/*
		 * tra questi metodi "sensibili" troviamo gli altri tipi di add, gli altri tipi
		 * di remove ed i vari metodi contains, come nelle List.
		 */
	}
}

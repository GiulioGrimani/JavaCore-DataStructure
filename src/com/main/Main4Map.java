package com.main;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import com.model.Cat;
import com.model.Person;

public class Main4Map {

	public static void main(String[] args) {

		/*-
		 * MAP - STRUTTURA DATI DINAMICA
		 * 
		 * L'interfaccia Map<K, V> offre delle strutture dati dinamiche che organizzano
		 * i dati al loro interno sotto forma di coppie chiave -> valore (Key -> Value).
		 * 
		 * All'interno di una Map non possono esserci due chiavi uguali. Questo
		 * significa che l'insieme delle chiavi di una Map non contiene duplicati.
		 * Difatti, l'insieme delle K in una Map<K, V> e' a tutti gli effetti un Set<K>.
		 * 
		 * Come conseguenza logica del fatto che le chiavi sono tutte distinte, possiamo
		 * affermare che anche tutte le coppie chiave -> valore all'interno della Map lo
		 * sono. Se a questo aggiungiamo il fatto che la coppia K -> V all'interno
		 * dell'interfaccia Map<K, V> e' rappresentata con l'interfaccia Entry<K, V>
		 * (definita all'interno della stessa interfaccia Map), allora e' possibile
		 * vedere una Map<K, V> come un Set<Entry<K, V>>.
		 * 
		 * Vedremo piu' avanti come queste due strutture derivate da una Map<K, V>
		 * (ovvero il Set<K> ed il Set<Entry<K, V>>) sono a tutti gli effetti utili per
		 * accedere e manipolare le informazioni contenute all'interno della stessa
		 * Map<K, V>.
		 * 
		 * Anche per le Map abbiamo tre principali implementazioni:
		 * 
		 * - HashMap
		 * - LinkedHashMap
		 * - TreeMap
		 * 
		 * Le differenze sono sostanzialmente quelle gia' osservate per i Set:
		 */

		Map<String, Integer> hashMap = new HashMap<>();
		hashMap.put("eee", 5);
		hashMap.put("ddd", 4);
		hashMap.put("ccc", 3);
		hashMap.put("bbb", 2);
		hashMap.put("aaa", 1);
		hashMap.put(null, 0);

		Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
		linkedHashMap.put("eee", 5);
		linkedHashMap.put("ddd", 4);
		linkedHashMap.put("ccc", 3);
		linkedHashMap.put("bbb", 2);
		linkedHashMap.put("aaa", 1);
		linkedHashMap.put(null, 0);

		Map<String, Integer> treeMap = new TreeMap<>();
		treeMap.put("eee", 5);
		treeMap.put("ddd", 4);
		treeMap.put("ccc", 3);
		treeMap.put("bbb", 2);
		treeMap.put("aaa", 1);
//		treeMap.put(null, 0); // lancia un'eccezione

		System.out.println("HashMap:\t" + hashMap);
		System.out.println("LinkedHashMap:\t" + linkedHashMap);
		System.out.println("TreeMap:\t" + treeMap);

		/*
		 * Come gia' osservato, il modo piu' comune (non certo l'unico) per fare un
		 * inserimento all'interno di una Map e' il metodo put(K, V). Tuttavia, dal
		 * momento che non possono esistere due chiavi uguali, questo metodo:
		 * 
		 * - inserisce la coppia K -> V quando la K non esiste all'interno della Map
		 * 
		 * - aggiorna il V relativo alla K quando la K e' gia' presente nella Map
		 */
		System.out.println("\nOperazioni di inserimento e aggiornamento:");

		// creo 3 chiavi
		Person p1 = new Person("Alice");
		Person p2 = new Person("Bob");
		Person p3 = new Person("Charlie");

		// creo la Map e inserisco 3 coppie chiave -> valore
		Map<Person, String> personMap = new HashMap<>();
		personMap.put(p1, "Roma");
		personMap.put(p2, "Palermo");
		personMap.put(p3, "Milano");
		System.out.println(
				"\nStampo Map<Person, String> (con hashCode):\n" + personMap + "\nDimensione: " + personMap.size());

		// aggiorno il primo usando la reference come chiave
		personMap.put(p1, "Bologna");
		// aggiorno il secondo usando l'oggetto come chiave
		personMap.put(new Person("Bob"), "Bari");
		System.out.println("\nStampo Map<Person, String> (con hashCode) dopo aggiornamento:\n" + personMap
				+ "\nDimensione: " + personMap.size());

		/*
		 * Per recuperare il valore corrispondente ad una determinata chiave usiamo il
		 * classico metodo get sulla chiave get(K key):
		 */
		System.out.println("\nOperazioni di lettura:");

		// recupero il valore di Alice passando la chiave come reference
		String aliceCity = personMap.get(p1);
		// recupero il valore di Bob passando la chiave come oggetto
		String bobCity = personMap.get(new Person("Bob"));

		System.out.println("\nValore associato ad Alice: " + aliceCity);
		System.out.println("Valore associato a Bob: " + bobCity);

		/*
		 * Abbiamo una moltitudine di modi per rimuovere dalla Map una determinata
		 * coppia chiave -> valore. Il piu' immediato e' quello di usare il metodo
		 * remove(K key):
		 */
		System.out.println("\nOperazione di rimozione:");

		System.out.println(
				"\nStampo Map<Person, String> (con hashCode):\n" + personMap + "\nDimensione: " + personMap.size());

		personMap.remove(p3); // Rimozione di Charlie -> Milano tramite reference
		personMap.remove(new Person("Bob")); // Rimozione di Bob -> Bari tramite oggetto

		System.out.println("\nStampo Map<Person, String> (con hashCode) dopo la rimozione:\n" + personMap
				+ "\nDimensione: " + personMap.size());

		/*
		 * Vale la pena ricordare anche qui la presenza dei metodi contains. Dal momento
		 * che le Map sono un insieme di coppie chiave -> valore, abbiamo due contains,
		 * uno per la chiave ed uno per il valore:
		 */
		System.out.println("\nOperazione di controllo presenza chiavi e presenza valori:");

		// Controllo presenza chiavi Alice e Bob
		boolean found = personMap.containsKey(p1);
		System.out.println("\nAlice (reference) e' presente come chiave? " + found);
		found = personMap.containsKey(new Person("Alice"));
		System.out.println("Alice (oggetto) e' presente come chiave? " + found);
		found = personMap.containsKey(p2);
		System.out.println("Bob (reference) e' presente come chiave? " + found);
		found = personMap.containsKey(new Person("Bob"));
		System.out.println("Bob (oggetto) e' presente come chiave? " + found);

		// Controllo presenza valore Bologna
		aliceCity = personMap.get(p1);

		found = personMap.containsValue(aliceCity);
		System.out.println("Bologna (reference) e' presente come valore? " + found);
		found = personMap.containsValue(new String("Bologna"));
		System.out.println("Bologna (oggetto) e' presente come valore? " + found);

		/*
		 * Prima di passare a vedere le componenti strutturali della Map e' bene
		 * ricordare che anche qui, cosi' come per i Set, dobbiamo prestare particolare
		 * attenzione a come sono definite le classi coinvolte nella definizione della
		 * Map, piu' nello specifico al fatto che tali classi abbiano ridefinito o meno
		 * i metodi equals e hashCode. Qualora ad esempio mancasse la definizione del
		 * metodo hashCode, tutti i metodi che abbiamo visto finora si comporterebbero
		 * in modo potenzialmente disatteso:
		 */
		System.out.println("\nOperazioni di inserimento e aggiornamento (senza hashCode):");

		// creo 3 chiavi di una classe senza hashCode
		Cat c1 = new Cat("Felix");
		Cat c2 = new Cat("Tom");
		Cat c3 = new Cat("Stregatto");

		// creo la Map e inserisco 3 coppie chiave -> valore
		Map<Cat, String> catMap = new HashMap<>();
		catMap.put(c1, "Felix il gatto");
		catMap.put(c2, "Tom & Jerry");
		catMap.put(c3, "Alice nel paese delle meraviglie");

		System.out.println("\nStampo Map<Cat, String> (senza hashCode) dopo inserimento:\n" + catMap + "\nDimensione: "
				+ catMap.size());

		// aggiorno usando la reference: tutt ok
		catMap.put(c1, "Felix the cat");

		// provo ad aggiornare usando l'oggetto: verra' invece fatto un inserimento
		catMap.put(new Cat("Stregatto"), "Alice in Wonderland");

		System.out.println("\nStampo Map<Cat, String> (senza hashCode) dopo aggiornamento:\n" + catMap
				+ "\nDimensione: " + catMap.size());

		// Provo il recupero del valore
		System.out.println("\nOperazioni di lettura (senza hashCode):");

		// recupero il valore di Tom passando la chiave come reference
		String tomToon = catMap.get(c2);
		// recupero il valore di Tom passando la chiave come oggetto
		String tomToon2 = catMap.get(new Cat("Tom"));

		System.out.println("\nValore associato a Tom (reference): " + tomToon);
		System.out.println("Valore associato a Tom (oggetto): " + tomToon2);

		// Provo la rimozione
		System.out.println("\nOperazione di rimozione (senza hashCode):");

		System.out.println("\nStampo Map<Cat, String> (senza hashCode):\n" + catMap + "\nDimensione: " + catMap.size());

		catMap.remove(c1); // rimuovo tramite reference la coppia Felix -> "Felix the cat"
		catMap.remove(new Cat("Tom")); // fallisco la rimozione tramite oggetto della coppia Tom -> "Tom & Jerry"

		System.out.println("\nStampo Map<Cat, String> (senza hashCode) dopo la rimozione:\n" + catMap + "\nDimensione: "
				+ catMap.size());

		// Test dei vari contains
		System.out.println("\nOperazione di controllo presenza chiavi e presenza valori (senza hashCode):");

		// Controllo presenza chiavi Tom e Stregatto
		found = catMap.containsKey(c2);
		System.out.println("\nTom (reference) e' presente come chiave? " + found);
		found = catMap.containsKey(new Cat("Tom"));
		System.out.println("Tom (oggetto) e' presente come chiave? " + found);
		found = catMap.containsKey(c3);
		System.out.println("Stregatto (reference) e' presente come chiave? " + found);
		found = catMap.containsKey(new Cat("Stregatto"));
		System.out.println("Stregatto (oggetto) e' presente come chiave? " + found);

		/*
		 * Vediamo infine come iterare sulle Map<K, V> tramite tre metodi particolari
		 * che restituiscono delle strutture dati sulle quali e' per l'appunto possibile
		 * iterare accedendo ai dati contenuti nella Map:
		 * 
		 * - values() restituisce la Collection<V>
		 * 
		 * - keySet() restituisce il Set<K>
		 * 
		 * - entrySet() restituisce il Set<Entry<K, V>>
		 */
		System.out.println("\nMetodo values():\n");

		// svuoto la Map per ripopolarla da capo
		personMap.clear();
		personMap.put(p1, "Roma");
		personMap.put(p2, "Palermo");
		personMap.put(p3, "Milano");

		// acquisisco la Collection<V> corrispondente all'elenco dei valori contenuti
		// all'interno della Map<K, V>. Nota: dal momento che i valori possono essere
		// ripetuti, e' corretto usare una generica Collection anziche' un Set
		Collection<String> values = personMap.values();
		System.out
				.println("Collection<String> della Map<Person, String>:\n" + values + "\nDimensione: " + values.size());

		System.out.println("\nMetodo keySet():\n");

		// acquisisco il Set<K> della mia Map<K, V>:
		Set<Person> keySet = personMap.keySet();
		System.out
				.println("Set<Person> della Map<Person, String>:\n" + keySet + "\nDimensione: " + keySet.size() + "\n");

		// il metodo e' spesso usato per iterare sulla mappa nel seguente modo:
		for (Person currentKey : personMap.keySet()) {
			String currentValue = personMap.get(currentKey);
			System.out.println("chiave: " + currentKey + "\tvalore: " + currentValue);
		}

		System.out.println("\nMetodo entrySet():\n");

		// acquisisco il Set<Entry<K, V>> della mia Map<K, V>:
		Set<Entry<Person, String>> entrySet = personMap.entrySet();

		System.out.println("Set<Entry<Person, String>> della Map<Person, String>:\n" + entrySet + "\nDimensione: "
				+ entrySet.size() + "\n");

		// anche questo metodo e' spesso usato per iterare sulla mappa:
		for (Entry<Person, String> entry : personMap.entrySet()) {
			Person currentKey = entry.getKey();
			String currentValue = entry.getValue();
			System.out.println("chiave: " + currentKey + "\tvalore: " + currentValue);
		}

	}

}

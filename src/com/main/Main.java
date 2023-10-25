package com.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.model.Account;
import com.model.Contact;
import com.model.Person;

public class Main {

	public static void main(String[] args) {

		/*
		 * Struttura dati STATICA: l'array
		 */

		// Struttura dati statica: non posso cambiarne la dimensione a runtime
		int[] array = new int[5];

		// Questa istruzione da' errore a runtime: sto cercando di accedere
		// ad una posizione dell'array che non esiste
//		array[5] = 213;

		// Stampo la dimensione dell'array:
		int lunghezzaArray = array.length;
		System.out.println("lunghezza array: " + lunghezzaArray);
		System.out.println();

		/*
		 * Struttura dati DINAMICA: la lista
		 */

		// Struttura dati dinamica: la dimensione cambia a runtime
		List<Integer> myList = new ArrayList<>();

		/*
		 * Test inserimenti
		 */

		// Inserisco un valore: dimensione della lista pari a 1
		myList.add(100);
		// Inserisco un altro valore: dimensione della lista pari a 2
		myList.add(-200);

		// Stampo la dimensione della lista:
		int lunghezzaLista = myList.size();
		System.out.println("lunghezza lista: " + lunghezzaLista);

		// Stampo la lista:
		System.out.println("Stampo la lista: " + myList);

		// Inserisco un altro valore in posizione di indice 0: dimensione della lista
		// pari a 3
		myList.add(0, 10000);

		// Stampo la dimensione della lista:
		lunghezzaLista = myList.size();
		System.out.println("lunghezza lista: " + lunghezzaLista);

		// Stampo la lista:
		System.out.println("Stampo la lista: " + myList);

		/*
		 * Test rimozioni
		 */

		System.out.println();
		List<Person> myPersonList = new ArrayList<>();
		Person p1 = new Person("Giulio");
		Person p2 = new Person("Alex");
		Person p3 = new Person("Riccardo");
		Person p1Copy = new Person("Giulio");

		myPersonList.add(p1);
		myPersonList.add(p2);
		myPersonList.add(p3);

		// Stampo la lista:
		System.out.println("Stampo la lista: " + myPersonList);

		// Rimozione di un elemento tramite l'indice
		myPersonList.remove(0);

		// Stampo la lista:
		System.out.println("Stampo la lista: " + myPersonList);

		// Rimozione di un elemento tramite il riferimento
		myPersonList.remove(p3);

		// Stampo la lista:
		System.out.println("Stampo la lista: " + myPersonList);

		// Rimuove tutti gli elementi dalla lista
		myPersonList.clear();

		// Ti dice se la lista e' vuota:
		boolean isEmpty = myPersonList.isEmpty();
		System.out.println("La lista e' vuota? " + isEmpty);

		myPersonList.add(p1);
		myPersonList.add(p2);
		myPersonList.add(p3);
		myPersonList.add(p1Copy);

		// Stampo la lista:
		System.out.println("Stampo la lista prima della rimozione: " + myPersonList);

		Person personToRemove = new Person("Giulio");

		myPersonList.remove(personToRemove);

		// Stampo la lista:
		System.out.println("Stampo la lista dopo la rimozione: " + myPersonList);

		// Il metodo contains(Elem e) ci dice se l'elemento e' contenuto all'interno
		// della lista
		boolean found = myPersonList.contains(p2);
		System.out.println(p2 + " e' dentro la lista? " + found);

		// Il metodo get(int index) ovviamente recupera l'elemento in dato indice
		Person myGetPerson = myPersonList.get(1);
		System.out.println("Persona recuperata dalla lista: " + myGetPerson);

		/*
		 * Caratteristica delle List e' quella di ammettere duplicati
		 */

		myPersonList.clear();

		myPersonList.add(p1);
		myPersonList.add(p1);
		myPersonList.add(p1);
		myPersonList.add(p1);
		myPersonList.add(p1);

		// Stampo la lista:
		System.out.println("Stampo la lista: " + myPersonList);

		/*
		 * Struttura dati DINAMICA: il set
		 */
		System.out.println();

		Set<Person> mySetPerson = new HashSet<>();

		// Prima differenza rispetto ad una lista: il set NON ammette duplicati

		mySetPerson.add(p1);
		mySetPerson.add(p1);
		mySetPerson.add(p1);
		mySetPerson.add(p1);
		mySetPerson.add(p1);

		// Stampo il set:
		System.out.println("Stampo il set: " + mySetPerson);

		// Altra differenza con le liste: l'ordine di inserimento dentro una lista
		// viene rispettato, dentro un set no

		Set<String> mySetString = new HashSet<>();
		mySetString.add("uno");
		mySetString.add("due");
		mySetString.add("tre");
		mySetString.add("quattro");

		System.out.println("Stampo il set: " + mySetString);

		// Come conseguenza deduciamo che i set NON sono indicizzati
		// quindi non esiste la get di un elemento in base all'indice

		/*
		 * Come iterare (ciclare) sulle collections (List e Set)
		 */

		myPersonList.clear();
		myPersonList.add(p1);
		myPersonList.add(p2);
		myPersonList.add(p3);

		System.out.println();

		// Per le List possiamo usare il tradizionale ciclo for
		for (int i = 0; i < myPersonList.size(); i++) {
			System.out.println("i = " + i + "\tperson = " + myPersonList.get(i));
		}

		System.out.println();
		// Sia per le List che per i Set possiamo iterare sugli elementi
		// anche usando il for each
		for (Person p : myPersonList) {
			System.out.println("person = " + p);
		}

		// Per quanto riguarda il Set, e' possibile iterare sui suoi elementi
		// solo tramite un for each
		System.out.println();
		for (String s : mySetString) {
			System.out.println("Stringa corrente: " + s);
		}

		/*
		 * Struttura dati DINAMICA: la map
		 * 
		 * E' composta da coppie chiave --> valore
		 */

		System.out.println();

		Map<String, Person> myMap = new HashMap<>();

		// L'inserimento si fa tramite il metodo put(key, value)
		myMap.put("uno", p1);
		myMap.put("due", p2);
		myMap.put("tre", p3);

		// L'insieme delle chiavi e' un set, pertanto non rispecchia l'ordine
		// di inserimento
		System.out.println(myMap);

		// Difatti e' possibile ottenere tale set tramite il metodo keySet()
		Set<String> myKeySet = myMap.keySet();

		System.out.println();
		// L'inserimento di una coppia chiave-valore la cui chiave e' gia' presente
		// all'interno della mappa, ne aggiorna semplicemente il valore
		myMap.put("tre", p1);
		System.out.println(myMap);

		System.out.println();
		// Rimozione elemento tramite la chiave
		myMap.remove("tre");
		System.out.println(myMap);

		System.out.println();
		// Il get si effettua tramite la chiave e restitusce un oggetto del tipo del
		// valore della mappa in corrispondenza della chiave data
		Person myMappedPerson = myMap.get("due");
		System.out.println(myMappedPerson);

		// I metodi containsKey/Value() ti dicono se e' presente la key / il value
		// all'interno della mappa
		System.out.println();
		System.out.println(myMap.containsKey("tre"));
		System.out.println(myMap.containsValue(p1));

		// Il metodo replace(key, value) rimpiazza il valore corrispondente alla chiave
		// data SOLO se esiste quella coppia chiave --> valore, altrimenti non fa
		// niente.
		// La differenza con la put e' che, se non esiste quella data chiave, la put
		// inserisce la coppia chiave --> valore data in input

		// Provo a rimpiazzare il valore di una chiave non piu' presente
		System.out.println();
		myMap.replace("tre", p3);
		System.out.println(myMap);

		// Per iterare su una mappa, di solito sfruttiamo il metodo keySet() che ci
		// restituisce il Set delle chiavi. Iteriamo quindi su tale Set per ottenere
		// i vari valori corrispondenti
		System.out.println();
		for (String key : myMap.keySet()) {
			Person currentPerson = myMap.get(key);
			System.out.println("chiave: " + key + "\tvalore: " + currentPerson);
		}

		// Vien naturale rappresentare con una mappa una situazione nella quale
		// abbiamo come chiave un'azienda (Account) e come valore una lista
		// di referenti dell'azienda (Contact)

		Map<Account, List<Contact>> myAccountContactMap = new HashMap<>();

		Account pirelli = new Account("Pirelli", "fkahfklsah");
		List<Contact> referentiPirelli = new ArrayList<>();
		referentiPirelli.add(new Contact("Tizio1"));
		referentiPirelli.add(new Contact("Tizio2"));
		referentiPirelli.add(new Contact("Tizio3"));

		myAccountContactMap.put(pirelli, referentiPirelli);

		for (Account a : myAccountContactMap.keySet()) {
			List<Contact> myCurrentContactList = myAccountContactMap.get(a); // <-- questa e' una lista
			for (Contact c : myCurrentContactList) {
				// faccio cose con i contact
			}
		}

	}

}

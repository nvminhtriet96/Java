package mt.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;


import mt.entities.*;

public class testbook {
	public static void before() {
		Set set = new TreeSet();
		set.add("2");
		set.add(3);
		set.add("1");
		Iterator it = set.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
	}

	public static void main(String[] args) {
		List<Book> listOfBooks = new ArrayList<>();
//		listOfBooks.add(new Book("Effective Java", "Joshua Bloch", 32));
//		listOfBooks.add(new Book("Core Java", "Joshua Bloch", 22));
//		listOfBooks.add(new Book("Core Java", "Brian Goetz", 42));
//		listOfBooks.add(new Book("Core Java", "Cay S. Horstmann", 34));
//		listOfBooks.add(new Book("Core Java", "Minh Triet", 32));
//		
//		
//		Collections.sort(listOfBooks);
//		listOfBooks.stream().forEach(System.out::println);
//		Collections.sort(listOfBooks, new ComparatorBook());
//		System.out.println("-----------------------");
//		listOfBooks.stream().forEach(System.out::println);
//		
//		Collections.sort(listOfBooks, new ComparatorBook());
//		Comparator<Book> byAuthor = (b1, b2) -> b1.getAuthor().compareTo(b2.getAuthor());
//		System.out.println("-----------------------");
//		Collections.sort(listOfBooks, (b1, b2) -> b1.getAuthor().compareTo(b2.getAuthor()));
//		listOfBooks.stream().forEach(System.out::println);
//		listOfBooks.sort(Comparator.comparing(Book::getAuthor).reversed());		
//		System.out.println("-----------------------");
//		listOfBooks.stream().forEach(System.out::println);
//		listOfBooks.sort(Comparator.naturalOrder());		
//		System.out.println("-----------------------");
//		listOfBooks.stream().forEach(System.out::println);
//		listOfBooks.add(new Book());
//		listOfBooks.sort(Comparator.nullsLast(byAuthor));
//		System.out.println("-----------------------");
//		listOfBooks.stream().forEach(System.out::println);

		int t = 0;
		Double ki = 9.0;
		System.out.print(ki.doubleValue());
		Set set = new TreeSet();
		set.add("2");
		set.add(3);
		set.add("1");
		Iterator it = set.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}		
		
	}

}


//listOfBooks.add(new Book("Effective Java", "Joshua Bloch", 32));
//listOfBooks.add(new Book("Java Puzzlers", "Joshua Bloch", 22));
//listOfBooks.add(new Book("Java Concurrency in Practice", "Brian Goetz", 42));
//listOfBooks.add(new Book("Java SE 8 for Really Impatient", "Cay S. Horstmann", 34));
//listOfBooks.add(new Book("Core Java", "Cay S. Horstmann", 32));

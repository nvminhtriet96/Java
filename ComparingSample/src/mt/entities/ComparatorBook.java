package mt.entities;

import java.util.Comparator;

public class ComparatorBook implements Comparator<Book>{
	
	@Override
	public int compare(Book b1, Book b2) {
		int i = b2.getTitle().compareTo(b1.getTitle());
		if (i!=0) {
			return i;
		}
		i = b2.getAuthor().compareTo(b1.getAuthor());
		if (i!=0) {
			return i;
		}
		return b2.getPrice() - b1.getPrice();
		
	}

}

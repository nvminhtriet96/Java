package fn.utils;
/**
 * java doc
 * 
 * @author Minh Triet
 * @birthday 11/10/1996
 */
import java.util.Comparator;

import fn.entities.Person;


public class PersonComparator implements Comparator<Person> {
	
	@Override
	public int compare(Person o1, Person o2 ) {

		return o1.getID().compareTo(o2.getID());
	}

}

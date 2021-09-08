package fa.training.entities;

import java.util.Comparator;

public class FixedwingIdCompare implements Comparator<Fixedwing> {

	@Override
	public int compare(Fixedwing o1, Fixedwing o2) {
		return o1.getID().compareToIgnoreCase(o2.getID());
	}

}

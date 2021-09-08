package fa.training.entities;

import java.util.Comparator;

public class HelicopterIdCompare implements Comparator<Helicopter> {

	@Override
	public int compare(Helicopter o1, Helicopter o2) {
		return o1.getID().compareToIgnoreCase(o2.getID());
	}

}
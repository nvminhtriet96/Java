package fa.training.entities;

import java.util.Comparator;

public class AirportIdCompare implements Comparator<Airport> {

	@Override
	public int compare(Airport o1, Airport o2) {
		return o1.getID().compareToIgnoreCase(o2.getID());
	}

}
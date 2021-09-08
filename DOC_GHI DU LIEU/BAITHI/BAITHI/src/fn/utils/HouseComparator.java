package fn.utils;

import java.util.Comparator;

import fn.entities.HouseForRent;


public class HouseComparator implements Comparator<HouseForRent> {
	
	@Override
	public int compare(HouseForRent o1, HouseForRent o2 ) {
		if (o1.getCreateDate().equals(o2.getCreateDate())) {
			return o2.getRentalPrice().compareTo(o1.getRentalPrice());
		}
		return o1.getCreateDate().compareTo(o2.getCreateDate());
	}

}

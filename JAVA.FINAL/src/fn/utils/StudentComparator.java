package fn.utils;

import java.util.Comparator;

import fn.entities.Student;

public class StudentComparator implements Comparator<Student> {
	
	@Override
	public int compare(Student o1, Student o2 ) {
		if (o1.getFullName() == o2.getFullName()) {
			return o1.getPhoneNumber().compareTo(o2.getPhoneNumber());
		}
		return o2.getFullName().compareTo(o1.getFullName());
	}

	

}

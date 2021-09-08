package testfile.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.Month;
import java.util.Map.Entry;

import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.TreeMap;
import java.util.function.Predicate;

public class testone {

	public static void main(String[] args) {
		
		String s = null;
		try {
			FileReader fr = new FileReader("myfule.txt");
			BufferedReader br = new BufferedReader(fr);
			while((s = br.readLine()) != null)
				System.out.print(s);

		} catch(IOException e) {System.out.print(s);}

	}
}



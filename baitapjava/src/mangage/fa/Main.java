package mangage.fa;
public class Main {

	public static void main(String[] args) {
		//Candidate d100 = new Candidate(100, "abc","nam", "11/10/1996","@jav.com",8d);
		CandidateManagement d3 = new CandidateManagement();
        //d3.display(d100);
        Candidate[] d1000 = d3.createCandidate(); 
        d3.display(d1000);
		byte a = -1;
		int b = 0;
		System.out.print(a);
	}

}

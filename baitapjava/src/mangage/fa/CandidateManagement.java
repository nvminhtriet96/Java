package mangage.fa;

 class CandidateManagement {
	public Candidate[] createCandidate () {
		Candidate[] d = new Candidate[3];
		d[0] = new Candidate(100, "abc","nam", "11/10/1996","@jav.com",8d);
		d[1] = new Candidate(200, "bcd","bede", "111/10/1996","@jaccv.com",9d);
		d[2] = new Candidate(300, "def","nam", "11fsa/fdsg10/1996","@javl.com",7d);
		return d;
	}
	
	public void display(Candidate[] candi) {
		for (Candidate dz : candi)
			System.out.println(dz.name + " " + dz.gender + " " + dz.gpa);
		}
	}
	


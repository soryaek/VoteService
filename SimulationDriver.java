package Assignment1;

public class SimulationDriver {
	
	public static void main(String[] args) {	
		iVoteService iVote = new iVoteService();
		iVote.printStudentAnswers(iVote.StudentSubmissions());
	}

}
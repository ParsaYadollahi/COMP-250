// Program that chooses Rock Paper or Scissors depending on the best option possible
package Quiz;

import java.util.Random;

public class RockPaperScissors {

	public static void main(String[] args) {
// the array of wins should be formated like this
		String[] player1 = {"paper", "scissors", "scissors"};
		System.out.println(game(player1));

	}
	public static String game(String[] p1) {
		assert p1.length != 0;
		int rockP1 = 0;
		int paperP1 = 0;
		int scissorsP1 = 0;
		int arrayWins = 0;
		Random random = new Random();
//	Make sure even if there only loses, program don't crash
		for(int index = 0; index < p1.length; index++) {
			if(p1[index].equalsIgnoreCase("rock") || p1[index].equalsIgnoreCase("paper") || p1[index].equalsIgnoreCase("scissors")) {
				arrayWins++;
			}
		}
//	If the array has no wins or looses, all elements have same probability
		if (arrayWins == 0) {
			 if (random.nextDouble() < 0.33) {
				 return "Rock";
			 } else if (random.nextDouble() >= 0.33 || random.nextDouble() <= 0.66) {
				 return "Paper";
			 } else {
				 return "Scissors";
			 }
		} else {
			for(int i = 0; i < p1.length; i++) {
				if (p1[i].equalsIgnoreCase("rock")) {
					rockP1++;
				} else if (p1[i].equalsIgnoreCase("paper")) {
					paperP1++;
				} else if (p1[i].equalsIgnoreCase("scissors")){
					scissorsP1++;
				}
			}
// Evaluating the best option with the ratio
			if (rockP1  > paperP1  && rockP1  > scissorsP1 ) {
				return "rock";
			} else if (paperP1  > rockP1  && paperP1  > scissorsP1 ) {
				return "paper";
			} else if ( rockP1  == paperP1  && rockP1 != 0) {
				if (random.nextDouble() < 0.5) {
					return "rock";
				} else {
					return "paper";
				}
			} else if ( paperP1  ==  scissorsP1  && paperP1 != 0) {
				if (random.nextDouble() < 0.5) {
					return "paper";
				} else {
					return "scissors";
				}
			} else if ( scissorsP1  ==  rockP1  && scissorsP1 !=0) {
				if (random.nextDouble() < 0.5) {
					return "scissors";
				} else {
					return "rock";
				}
			} else {
				return "scissors";
			}
		}
	}
}

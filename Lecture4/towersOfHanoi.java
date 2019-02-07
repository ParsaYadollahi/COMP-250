package Lecture4;

public class towersOfHanoi {

	public static void main(String[] args) {
		int n = 3; 
        towerOfHanoi(n, "A", "C", "B");

	}
	public static void towerOfHanoi(int numberOfDisks, String startPole, String tempPole, String endPole) {
		if(numberOfDisks != 1) {
			towerOfHanoi(numberOfDisks-1, startPole, tempPole, endPole);
			System.out.println("\tMove disk from " + startPole + " to " + tempPole);
			towerOfHanoi(numberOfDisks-1, tempPole, endPole, startPole);
		} else {
			System.out.println("Move disk from " + startPole + " to " + endPole);
		}
	}
}

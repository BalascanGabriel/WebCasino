package gamemodes;

import java.util.Random;


public class Coinflip {

	public Coinflip() {
		// TODO Auto-generated constructor stub
	}
	
	public static String flipCoin() {
        Random rand = new Random();
        int flip = rand.nextInt(2);
        if (flip == 0) {
            return "heads";
        } else {
            return "tails";
        }
    }

}

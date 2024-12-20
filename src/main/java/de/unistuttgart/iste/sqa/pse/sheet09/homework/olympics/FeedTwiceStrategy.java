package de.unistuttgart.iste.sqa.pse.sheet09.homework.olympics;

/**
 * Implements a strategy where the Hamster eats one Grain, which equals 5 energy points
 * 
 * @return true if the hamster is allowed to eat the grain, according to his strategy of eating two grains per Verpflegungsstation.
 * @return false if the hamster is not allowed to eat the grain, according to his strategy of eating two grains per Verpflegungsstation.
 * @author Magnus Dickerhof
 */
public final class FeedTwiceStrategy implements FeedingStrategy {

	private static int foodRound = 2;

	@Override
	public boolean isFeedingRequired() {
		if (foodRound <= 2 && foodRound > 0){
			foodRound -= 1;
			return true;
		}

		else{
			return false;

		}
	}
}

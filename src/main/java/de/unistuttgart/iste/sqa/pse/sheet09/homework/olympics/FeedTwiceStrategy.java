package de.unistuttgart.iste.sqa.pse.sheet09.homework.olympics;

/**
 * Implements a strategy where the Hamster eats one Grain, which equals 10 energy points
 * 
 * @return true if the hamster is allowed to eat the grain, according to his strategy of eating two grains per Verpflegungsstation.
 * @return false if the hamster is not allowed to eat the grain, according to his strategy of eating two grains per Verpflegungsstation.
 * @author Magnus Dickerhof
 */
public final class FeedTwiceStrategy implements FeedingStrategy {
    private int feedLeft = 2;

    @Override
    public boolean isFeedingRequired() {
        if (feedLeft > 0) {
            feedLeft--;
            return true;
        } else {
            return false;
        }
    }
}
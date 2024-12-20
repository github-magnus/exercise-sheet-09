package de.unistuttgart.iste.sqa.pse.sheet09.homework.olympics;

/**
 * Implements a strategy where the Hamster eats one Grain, which equals 5 energy points
 * 
 * @return true if the hamster is allowed to eat the grain, according to his strategy of eating one Grain per Verpflegungsstation.
 * @return false if the hamster is not allowed to eat the grain, according to his strategy of eating one Grain per Verpflegungsstation.
 * @author Magnus Dickerhof
 */
public final class FeedOnceStrategy implements FeedingStrategy {

    private boolean hasJustFed = false;

    @Override
    public boolean isFeedingRequired() {
        if (!hasJustFed) {
            hasJustFed = true;
            return true;
        } 
		else {
            hasJustFed = false;
            return false;
        }
    }
}

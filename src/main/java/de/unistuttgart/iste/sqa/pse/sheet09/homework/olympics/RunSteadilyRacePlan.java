package de.unistuttgart.iste.sqa.pse.sheet09.homework.olympics;

/**
 * Implements a Race Plan in which the the RunnerHamster runs steadily.
 *
 * @author Magnus Dickerhof
 */
public final class RunSteadilyRacePlan implements RacePlan {
	@Override
	public void nextStep(final RunnerHamster hamster) {
		hamster.runSteadily();
		// put your code for task (c) here
	}
}

package de.unistuttgart.iste.sqa.pse.sheet09.homework.olympics;

import de.hamstersimulator.objectsfirst.datatypes.Direction;
import de.hamstersimulator.objectsfirst.datatypes.Location;
import de.hamstersimulator.objectsfirst.external.simple.game.SimpleHamsterGame;
import java.util.LinkedList;
import java.util.List;

/**
 * This class sets up the race
 *
 * @author Magnus Dickerhof
 */
public final class OlympicsHamsterGame extends SimpleHamsterGame {
	List<RunnerHamster> runners;

	public OlympicsHamsterGame() {
		this.loadTerritoryFromResourceFile("/territories/raceTrackTerritory.ter");
		this.displayInNewGameWindow();
		game.startGame();
		runners = new LinkedList<RunnerHamster>();
	}

	@Override
	protected void run() {
		//paule.write("Welcome to the first race of the day!");
		//setupTaskC();
		//race();

		// paule.write("And now for the second race!");
		// setupTaskD();
		// race();

		paule.write("To top it all off: Speedy`s attempt at beating the WORLD RECORD!");
		recordAttempt();
		race();
	}

	/**
	 * Speedy runs the course in 30 or less turns.
	 *
	 * To achieve this, speedy switches strategies during the race.
	 *
	 * Ensures that speedy needed at most 30 actions to reach the goal.
	 */
	private void recordAttempt() {

		final RunnerHamster speedy = new RunnerHamster(game.getTerritory(), new Location(1, 1), Direction.EAST);

		final RacePlan tacticSprinter = new SprinterRacePlan();
		final FeedingStrategy tacticFeedTwice = new FeedTwiceStrategy();

		speedy.setRacePlan(tacticSprinter);
		speedy.setFeedingTactics(tacticFeedTwice);

		while(!speedy.hasFinished()) {
			
			if (speedy.getEnergyRemaining() == 0) {
				speedy.setRacePlan(new RunSlowlyRacePlan());
				speedy.executeNextAction();
			}

			else if (speedy.getEnergyRemaining() >= 5){
				speedy.setRacePlan(new SprinterRacePlan());
				speedy.executeNextAction();
			}

			else{
				speedy.setRacePlan(new RunSteadilyRacePlan());
				speedy.executeNextAction();
			}
		}


		// ...and here. Do NOT put any code after here.

		if (speedy.hasFinished()) {
			speedy.write("I needed " + speedy.getActionsTaken() + " actions!");
		} else {
			speedy.write("Oops, i did not even reach the goal.");
		}
	}

	/**
	 * sets up the runners to take part in a race with strategies as implemented in task (c).
	 *
	 * Ensures that a steady runner and a sprinting runner both on the tile (1,1) and
	 * facing east.
	 *
	 * The steady runner uses a {@code RunSteadilyRacePlan}.
	 * The sprinting runner uses a {@code SprinterRacePlan}.
	 *
	 */
	private void setupTaskC() {
		runners = new LinkedList<RunnerHamster>();

		final RunnerHamster steadyRunner = new RunnerHamster(game.getTerritory(), new Location(1, 1), Direction.EAST);
		final RunnerHamster sprintingRunner =
				new RunnerHamster(game.getTerritory(), new Location(1, 1), Direction.EAST);
		final RunnerHamster slowlyHammster = new RunnerHamster(game.getTerritory(), new Location(1, 1), Direction.EAST);

		final RacePlan tacticSteady = new RunSteadilyRacePlan();
		steadyRunner.setRacePlan(tacticSteady);


		final RacePlan tacticSprinting = new SprinterRacePlan();
		sprintingRunner.setRacePlan(tacticSprinting);

		final RacePlan tacticSlowly = new RunSlowlyRacePlan();
		slowlyHammster.setRacePlan(tacticSlowly);

		runners.add(steadyRunner);
		runners.add(sprintingRunner);
		runners.add(slowlyHammster);
	}

	/**
	 * Sets up the runners to take part in a race with strategies as implemented in task (d).
	 *
	 * Ensures that a steady runner and a sprinting runner both on the tile (1,1) and
	 * facing east.
	 * The steady runner uses a {@code FeedOnceStrategy} and a {@code RunSteadilyRacePlan}.
	 * The sprinting runner uses a {@code FeedTwiceStrategy} and a {@code SprinterRacePlan}.
	 *
	 */
	private void setupTaskD() {
		runners = new LinkedList<RunnerHamster>();
		final RunnerHamster slowlyHammster = new RunnerHamster(game.getTerritory(), new Location(1, 1), Direction.EAST);
		final RunnerHamster steadyRunner = new RunnerHamster(game.getTerritory(), new Location(1, 1), Direction.EAST);
		final RunnerHamster sprintingRunner = new RunnerHamster(game.getTerritory(), new Location(1, 1), Direction.EAST);		

		final RacePlan tacticSlow = new RunSlowlyRacePlan();
		final FeedingStrategy tacticFeedNever = new FeedNeverStrategy();
		slowlyHammster.setRacePlan(tacticSlow);
		slowlyHammster.setFeedingTactics(tacticFeedNever);

		final RacePlan tacticSteady = new RunSteadilyRacePlan();
		final FeedingStrategy tacticFeedOnce = new FeedOnceStrategy();
		steadyRunner.setRacePlan(tacticSteady);
		steadyRunner.setFeedingTactics(tacticFeedOnce);

		final RacePlan tacticSprinting = new SprinterRacePlan();
		final FeedingStrategy tacticFeedTwice = new FeedTwiceStrategy();
		sprintingRunner.setRacePlan(tacticSprinting);
		sprintingRunner.setFeedingTactics(tacticFeedTwice);

		runners.add(slowlyHammster);
		runners.add(steadyRunner);
		runners.add(sprintingRunner);
	}

	/**
	 * runs a race with the competitors currently in runners.
	 *
	 * ensures that a new race has been executed
	 */
	private void race() {
		final Race race = new Race(runners);
		race.executeRace();
	}
}

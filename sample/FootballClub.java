package sample;

import java.util.Objects;

			public class FootballClub extends SportsClub implements Comparable<FootballClub> {
			//sub class of the sports club is football club

						private int wins;
						private int draws;
						private int defeats;
						private int goalsReceived;
						private int goalsScored;
						private int numberOfPoints;
						private int numberOfMatchesPlayed;


			//constructor
			public FootballClub(String nameOfTheClub, String location, int wins, int draws, int defeats, int goalsReceived, int goalsScored, int numberOfMatchesPlayed, int numberOfPoints){
						super(nameOfTheClub, location);
						this.wins = wins;
						this.draws = draws;
						this.defeats = defeats;
						this.goalsReceived = goalsReceived;
						this.goalsScored = goalsScored;
						this.numberOfPoints = numberOfPoints;
						this.numberOfMatchesPlayed = numberOfMatchesPlayed;
			}

			//getts and setters for wins,draws ,defeats ,number of goals received ,number of scored, number of points and the number of matches played
			public int getWins() {
						return wins;
			}

			public void setWins(int wins) {
						this.wins = wins;
			}

			public int getDraws() {
						return draws;
			}

			public void setDraws(int draws) {
						this.draws = draws;
			}

			public int getDefeats() {
						return defeats;
			}

			public void setDefeats(int defeats) {
						this.defeats = defeats;
			}

			public int getGoalsReceived() {
						return goalsReceived;
			}

			public void setGoalsReceived(int goalsReceived) {
						this.goalsReceived = goalsReceived;
			}

			public int getGoalsScored() {
						return goalsScored;
			}

			public void setGoalsScored(int goalsScored) {
						this.goalsScored = goalsScored;
			}

			public int getNumberOfPoints() {
						return numberOfPoints;
			}

			public void setNumberOfPoints(int numberOfPoints) {
						this.numberOfPoints = numberOfPoints;
			}

			public int getNumberOfMatchesPlayed() {
						return numberOfMatchesPlayed;
			}

			public void setNumberOfMatchesPlayed(int numberOfMatchesPlayed) {
						this.numberOfMatchesPlayed = numberOfMatchesPlayed;
			}

				//converts objects to string
				public String toString() {
					return "FootballClub{" + super.toString() +
							"wins=" + wins +
							", draws=" + draws +
							", defeats=" + defeats +
							", goalsReceived=" + goalsReceived +
							", goalsScored=" + goalsScored +
							", numberOfPoints=" + numberOfPoints +
							", numberOfMatchesPlayed=" + numberOfMatchesPlayed +
							'}';
				}

				//two objects are equal to eachother
				public boolean equals(Object o) {
						if (this == o) return true;
						if (o == null || getClass() != o.getClass()) return false;
						if (!super.equals(o)) return false;
						FootballClub that = (FootballClub) o;
						return wins == that.wins &&
								draws == that.draws &&
								defeats == that.defeats &&
								goalsReceived == that.goalsReceived &&
								goalsScored == that.goalsScored &&
								numberOfPoints == that.numberOfPoints &&
								numberOfMatchesPlayed == that.numberOfMatchesPlayed;
			}


			public int hashCode() {
						return Objects.hash(super.hashCode(), wins, draws, defeats, goalsReceived, goalsScored, numberOfPoints, numberOfMatchesPlayed);
			}


			//comparing the goals received and goals scored
			public int compareTo(FootballClub football1) {

						int difference = goalsScored - goalsReceived;
						if(getNumberOfPoints() == this.numberOfPoints){
							return difference - this.numberOfPoints;
						}
						else {
							numberOfPoints = football1.getNumberOfPoints();
							return this.getNumberOfPoints() - football1.numberOfPoints;
						}

			}

			//sorting according to the goals scored
			public int compareGoalScored(FootballClub o){

						return this.getGoalsScored() - o.getGoalsScored();
			}

			//sorting according to the points
			public int comparePoints(FootballClub o){
						return this.getNumberOfPoints() - o.getNumberOfPoints();
			}

			//sorting according to the number of wins
			public int compareWins(FootballClub o){

						return this.getWins() - o.getWins();
			}



		}

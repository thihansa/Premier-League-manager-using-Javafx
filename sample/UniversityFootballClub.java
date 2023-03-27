package sample;

import java.util.Objects;

			public class UniversityFootballClub extends FootballClub {
			// sub classes of football club
				private String universityName;


						public UniversityFootballClub(String nameOfTheClub, String location, int wins,
													  int draws, int defeats, int goalsReceived, int goalsScored, int numberOfMatchesPlayed, int numberOfPoints) {
								super(nameOfTheClub, location, wins, draws, defeats, goalsReceived, goalsScored, numberOfMatchesPlayed, numberOfPoints);
								this.universityName = universityName;
						}

						public String getUniversityName() {
								return universityName;
						}

						public void setUniversityName(String universityName) {
								this.universityName = universityName;
						}


						//converts objects to string
						public String toString() {
								return "UniversityFootballClub{" +
										"universityName='" + universityName + '\'' +
										'}';
						}

						//two objects are equal to eachother
						public boolean equals(Object o) {
								if (this == o) return true;
								if (o == null || getClass() != o.getClass()) return false;
								if (!super.equals(o)) return false;
								UniversityFootballClub that = (UniversityFootballClub) o;
								return Objects.equals(universityName, that.universityName);
						}

						public int hashCode() {
								return Objects.hash(super.hashCode(), universityName);
						}
			}

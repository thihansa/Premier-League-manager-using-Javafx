package sample;

import java.util.Objects;

			public class SchoolFootballClub extends FootballClub{
			//sub classes of
					private String schoolName;


					public SchoolFootballClub(String nameOfTheClub, String location, int wins, int draws,
											  int defeats, int goalsReceived, int goalsScored, int numberOfMatchesPlayed, int numberOfPoints) {
							super(nameOfTheClub, location, wins, draws, defeats, goalsReceived, goalsScored, numberOfMatchesPlayed, numberOfPoints);
							this.schoolName = schoolName;
					}

					public String getSchoolName() {
							return schoolName;
					}

					public void setSchoolName(String schoolName) {
							this.schoolName = schoolName;
					}


					//converts objects to string
					public String toString() {
							return "SchoolFootballClub{" +
									"schoolName='" + schoolName + '\'' +
									'}';
					}

					//two objects are equal to eachother
					public boolean equals(Object o) {
							if (this == o) return true;
							if (o == null || getClass() != o.getClass()) return false;
							if (!super.equals(o)) return false;
							SchoolFootballClub that = (SchoolFootballClub) o;
							return Objects.equals(schoolName, that.schoolName);
					}

					public int hashCode() {
							return Objects.hash(super.hashCode(), schoolName);
					}
			}

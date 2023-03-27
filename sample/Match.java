package sample;

import java.io.Serializable;
			import java.util.Objects;

			public class Match implements Comparable<Match>, Serializable {
					private String homeTeam;
					private String awayTeam;
					private FootballClub firstClub;
					private FootballClub secondClub;
					private int firstClubScore;
					private int secondClubScore;
					private int day;
					private int month;
					private int year;

					public Match(FootballClub firstClub, FootballClub secondClub, int firstClubScore, int secondClubScore, int day, int month, int year) {
							this.homeTeam = firstClub.getNameOfTheClub();
							this.awayTeam = secondClub.getNameOfTheClub();
							this.firstClub = firstClub;
							this.secondClub = secondClub;
							this.firstClubScore = firstClubScore;
							this.secondClubScore = secondClubScore;
							this.day = day;
							this.month = month;
							this.year = year;
					}

					public Match() {
					}


					//getters and setters
					public FootballClub getFirstClub() {
							return firstClub;
					}

					public void setFirstClub(FootballClub firstClub) {
							this.firstClub = firstClub;
					}

					public FootballClub getSecondClub() {
							return secondClub;
					}

					public void setSecondClub(FootballClub secondClub) {
							this.secondClub = secondClub;
					}

					public int getFirstClubScore() {
							return firstClubScore;
					}

					public void setFirstClubScore(int firstClubScore) {
							this.firstClubScore = firstClubScore;
					}

					public int getSecondClubScore() {
							return secondClubScore;
					}

					public void setSecondClubScore(int secondClubScore) {
							this.secondClubScore = secondClubScore;
					}

					public int getDay() {
							return day;
					}

					public void setDay(int day) {
							this.day = day;
					}

					public int getMonth() {
							return month;
					}

					public void setMonth(int month) {
							this.month = month;
					}

					public int getYear() {
							return year;
					}

					public String getHomeTeam() {
							return homeTeam;
					}

					public void setHomeTeam(String homeTeam) {
							this.homeTeam = homeTeam;
					}

					public String getAwayTeam() {
							return awayTeam;
					}

					public void setAwayTeam(String awayTeam) {
							this.awayTeam = awayTeam;
					}

					public void setYear(int year) {
							this.year = year;
					}

					//converts objects to string
					public String toString() {
							return "NameDateUpdate{" +
									"firstClub=" + firstClub.getNameOfTheClub() +
									", secondClub=" + secondClub.getNameOfTheClub() +
									", firstClubScore=" + firstClubScore +
									", secondClubScore=" + secondClubScore +
									", day=" + day +
									", month=" + month +
									", year=" + year +
									'}';
					}

					//two objects are equal to eachother
					public boolean equals(Object o) {
							if (this == o) return true;
							if (o == null || getClass() != o.getClass()) return false;
							Match that = (Match) o;
							return firstClubScore == that.firstClubScore &&
									secondClubScore == that.secondClubScore &&
									day == that.day &&
									month == that.month &&
									year == that.year &&
									Objects.equals(firstClub, that.firstClub) &&
									Objects.equals(secondClub, that.secondClub);
					}


					public int hashCode() {
							return Objects.hash(firstClub, secondClub, firstClubScore, secondClubScore, day, month, year);
					}



					public int compareTo(Match o) {
							return this.getTotalDays(this.getYear(), this.getMonth(), this.getDay()) - o.getTotalDays(o.getYear(), o.getMonth(), o.getDay());
					}


					public int getTotalDays(int year,int month, int day) {
							return (year * 365 ) + (month * 30 ) + (day) ;
					}
			}

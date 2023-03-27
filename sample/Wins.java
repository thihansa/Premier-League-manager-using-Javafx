package sample;

import java.util.Comparator;

			public class Wins implements Comparator<SportsClub> {
				//class for sorting according to the number fo wins
					public int compare(SportsClub o1, SportsClub o2) {
							return ((FootballClub)o1).compareWins((FootballClub)o2);
					}
			}

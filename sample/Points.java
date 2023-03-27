package sample;

import java.util.Comparator;

			public class Points implements Comparator<SportsClub> {
						//class for sorting according to the points
						public int compare(SportsClub o1, SportsClub o2) {
								return ((FootballClub)o1).comparePoints((FootballClub)o2);
						}
			}

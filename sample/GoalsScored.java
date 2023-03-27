package sample;

import java.util.Comparator;

			public class GoalsScored implements Comparator<SportsClub> {
						//class for sorting according to the goals scored
						public int compare(SportsClub o1, SportsClub o2) {
								return ((FootballClub)o1).compareGoalScored((FootballClub)o2);
						}

			}

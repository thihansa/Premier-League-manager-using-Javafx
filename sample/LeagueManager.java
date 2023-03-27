package sample;

import java.io.IOException;

			public interface LeagueManager {

						void deleteFootball ();

						void displayVariousStatistics();

						void displayPremierLeagueTable();

						void addFootballClub(SportsClub sportsClub);

						void loadFromFile(String Details) throws IOException, ClassNotFoundException;

						void saveToFile(String Details)  throws IOException;

						void addClubDateName();

			}

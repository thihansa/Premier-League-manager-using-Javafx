package sample;

import java.io.*;
			import java.util.ArrayList;
			import java.util.Collections;
			import java.util.List;
			import java.util.Scanner;

			public class PremierLeagueManager implements LeagueManager  {
						final static public int MAXIMUM_CLUBS = 20;  //the maximum amount of clubs that can be input
						private int maximumClubs = MAXIMUM_CLUBS;
						static List<FootballClub> football = new ArrayList<FootballClub>();
						static List<Match> matches = new ArrayList<Match>();


						//adding a football club only if there's a slot
						public void addFootballClub(SportsClub club) {

								if (football.contains(club)) { //if the club is already in premier league
									System.out.println("Club is already in the premier league");

								} else if(maximumClubs == 0){ //checking if club is full
									System.out.println("The Club is Full");
								}
								else {
									football.add((FootballClub) club);
									System.out.println(maximumClubs > 0 ? ("Slots Remaining: " + maximumClubs) : "No more space for clubs");
								}

						}


						//deleting a football club
						public void deleteFootball() {
							System.out.println("Please Enter the name of the football club:");
							Scanner sc2 = new Scanner(System.in);
							String nameOfTheClub = sc2.nextLine();

							if (football.isEmpty()) { //checking if there are no clubs
									System.out.println("No clubs are in the table!");
								} else { //if clubs are there
									boolean found = false;

									for (SportsClub club : football) {
										if (club.getNameOfTheClub().equals(nameOfTheClub)) {
											found = true;
											football.remove(club);
											break;
										}
									}
									//if wrong name
									if (!found) {
										System.out.println("Invalid name! Please enter again!");
									}
								}
						}

						//displaying statistics
						public void displayVariousStatistics() {
							System.out.println("Enter name of the club:");
							Scanner sc = new Scanner(System.in);
							String nameOfTheClub = sc.nextLine();
							for (SportsClub club : PremierLeagueManager.football) {
									if(club.getNameOfTheClub().equals(nameOfTheClub)){
										//table
										System.out.println("+------------------+------------+------+-------+---------+----------------+--------------+--------+----------------+");
										System.out.println("| Name of the club |  Location  | Wins | Draws | Defeats | Goals Received | Goals Scored | Points | Matched Played |");
										System.out.println("+------------------+------------+------+-------+---------+----------------+--------------+--------+----------------+");
										System.out.printf("| %-17s| %-11s| %-5s| %-6s| %-8s| %-15s| %-13s| %-7s| %-15s|\n", club.getNameOfTheClub(), club.getLocation(), ((FootballClub)club).getWins(),
												((FootballClub)club).getDraws(), ((FootballClub)club).getDefeats(),  ((FootballClub)club).getGoalsReceived(),
												((FootballClub)club).getGoalsScored(), ((FootballClub)club).getNumberOfMatchesPlayed(), ((FootballClub)club).getNumberOfPoints());
									}
							}
						}

						//displaying the premier league time table
						public void displayPremierLeagueTable() {
							//table
							System.out.println("+------------------+------------+------+-------+---------+----------------+--------------+--------+----------------+");
							System.out.println("| Name of the club |  Location  | Wins | Draws | Defeats | Goals Received | Goals Scored | Points | Matched Played |");
							System.out.println("+------------------+------------+------+-------+---------+----------------+--------------+--------+----------------+");
							football.sort(Collections.reverseOrder()); //sorting in descending
								if(football.isEmpty()){ //checking if there are no clubs
									System.out.println("No clubs in the table!");
								}
								else {

									System.out.println("List of the clubs");

								}
								for (SportsClub club : football) {
									//displaying the statistics in a table
									System.out.printf("| %-17s| %-11s| %-5s| %-6s| %-8s| %-15s| %-13s| %-7s| %-15s|\n", club.getNameOfTheClub(), club.getLocation(), ((FootballClub)club).getWins(),
											((FootballClub)club).getDraws(), ((FootballClub)club).getDefeats(),  ((FootballClub)club).getGoalsReceived(),
											((FootballClub)club).getGoalsScored(), ((FootballClub)club).getNumberOfMatchesPlayed(), ((FootballClub)club).getNumberOfPoints());
							}
						}


						//saving the club data to the file
						public void saveToFile(String Details) throws IOException {
								FileOutputStream file = new FileOutputStream("Details.txt");
								ObjectOutputStream out = new ObjectOutputStream(file);

								FileOutputStream file1 = new FileOutputStream("Matches.txt");
								ObjectOutputStream out1 = new ObjectOutputStream(file1);

								for(FootballClub club : football) {
									out.writeObject(club);
								}

								for(Match club : matches) {
									out1.writeObject(club);
								}

								out.flush();
								file.close();
								out.close();

								out1.flush();
								file1.close();
								out1.close();

						}

						//loading the club data back to the array when the application is run again
						public void loadFromFile(String Details) throws IOException, ClassNotFoundException {
								FileInputStream file = new FileInputStream("Details.txt");
								ObjectInputStream out = new ObjectInputStream(file);

								FileInputStream file1 = new FileInputStream("Matches.txt");
								ObjectInputStream out1 = new ObjectInputStream(file1);

								for(;;) {
									try {
										FootballClub club = (FootballClub) out.readObject();
										football.add(club); //data added to the football array-list
									}
									catch (EOFException e) {
										break;
									}

								}

								for(;;) {
									try {
										Match club = (Match) out1.readObject();
										matches.add(club); //data added to the matches array-list
									}
									catch (EOFException e) {
										break;
									}

								}

								file.close();
								out.close();

								file1.close();
								out1.close();

								System.out.println(football);
								System.out.println(matches);
						}

						public void addClubDateName(){
								Match d = new Match();
								Scanner sc = new Scanner(System.in);
								Scanner sc2 = new Scanner(System.in);

								//Entering the name of the club and setting it
								System.out.println("Enter the first club name : ");
								String firstClub = sc.nextLine();
								FootballClub first = null;
								for(FootballClub club : PremierLeagueManager.football){
									if(club.getNameOfTheClub().equals(firstClub))
										first = club;
								}
								d.setFirstClub(first);
								System.out.println();

								//Entering the score and setting the score
								System.out.println("Enter the score of the first club:");
								int firstClubScore = sc.nextInt();
								System.out.println();
								d.setFirstClubScore(firstClubScore);

								//Entering the name of the club and setting it
								System.out.println("Enter the second club name: ");
								String secondClub = sc2.nextLine();
								FootballClub second = null;
								for(FootballClub club : PremierLeagueManager.football){
									if(club.getNameOfTheClub().equals(secondClub))
										second = club;
								}
								d.setSecondClub(second);
								System.out.println();

								//Entering the score and setting the score
								System.out.println("Enter the score of the second club:");
								int secondClubScore = sc2.nextInt();
								System.out.println();
								d.setSecondClubScore(secondClubScore);
								System.out.println();

								//Entering the day of the match
								System.out.println("Enter the day of the match: ");
								int day = sc.nextInt();
								System.out.println("Enter the month of the match: ");
								int month = sc.nextInt();
								System.out.println("Enter the year of the match: ");
								int year = sc.nextInt();

								//gets everything entered to an object
								d  = new Match(first,second,firstClubScore,secondClubScore,day, month, year);

								//adding everything into a array-list using that object
								matches.add(d);

								//setting the entered first-club-score and the second-club-score to the goals scored
								first.setGoalsScored(first.getGoalsScored()+firstClubScore);
								second.setGoalsScored(second.getGoalsScored()+secondClubScore);

								//setting the entered first-club-score and the second-club-score to the goals received
								first.setGoalsReceived(first.getGoalsReceived()+secondClubScore);
								second.setGoalsReceived(second.getGoalsReceived()+firstClubScore);

								//increasing the number of matches played by 1
								first.setNumberOfMatchesPlayed(first.getNumberOfMatchesPlayed()+1);
								second.setNumberOfMatchesPlayed(second.getNumberOfMatchesPlayed()+1);


								//checking if first club or second club has won and adding 3 points and 1 win to the club who won
								// and adding 1 defeat to the one who lost
								if (firstClubScore > secondClubScore) {
									first.setNumberOfPoints(first.getNumberOfPoints()+3);
									first.setWins(first.getWins()+1);
									second.setDefeats(second.getDefeats()+1);
								}

								else if (firstClubScore < secondClubScore) {
									second.setNumberOfPoints(second.getNumberOfPoints()+3);
									second.setWins(second.getWins()+1);
									first.setDefeats(first.getDefeats()+1);
								}
								//if draw the increase number of points by 1 and draws by 1
								else {
									first.setNumberOfPoints(first.getNumberOfPoints()+1);
									second.setNumberOfPoints(second.getNumberOfPoints()+1);
									first.setDraws(first.getDraws()+1);
									second.setDraws(second.getDraws()+1);
								}
								Collections.sort(matches,Collections.reverseOrder());

						}


			}


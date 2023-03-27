package sample;

import java.io.File;
			import java.io.FileNotFoundException;
			import java.io.IOException;
			import java.util.Scanner;



			public class Menu {

					static PremierLeagueManager manages = new PremierLeagueManager();
					static GUI show = new GUI();

					public  static void console() throws IOException, ClassNotFoundException {

								displayMenu();
								Scanner sc = new Scanner(System.in);
								int option =  sc.nextInt();


								switch (option) {
									case  1:
										addFootballClub();
										console();
										break;
									case 2:
										deleteFootballClub();
										console();
										break;
									case 3:
										displayVariousStatistics();
										console();
										break;
									case 4:
										manages.saveToFile("Details.txt");
										console();
										break;
									case 5:
										try{
										manages.loadFromFile("Details.txt");
										console();
										}catch (FileNotFoundException e){
										new File("Details.txt");
											new File("Matches.txt");
										}
										break;
									case 6:
										manages.displayPremierLeagueTable();
										console();
										break;
									case 7:
										enterClubNames();
										console();
										break;
								case 8:
									show.display(true,false);
									break;

									default:
										System.out.println("Invalid input! Please try again! ");
										displayMenu();
								}

						}



					//Menu
					public static void displayMenu() {
								System.out.println("Welcome to premier league football championship! ");
								System.out.println(" ");
								System.out.println("Enter 1: To add a football club");
								System.out.println(" ");
								System.out.println("Enter 2: To delete a football club");
								System.out.println(" ");
								System.out.println("Enter 3: To display various statistics");
								System.out.println(" ");
								System.out.println("Enter 4: To save the clubs into a file");
								System.out.println(" ");
								System.out.println("Enter 5: To load the clubs into the application");
								System.out.println(" ");
								System.out.println("Enter 6: To display the premier league table");
								System.out.println(" ");
								System.out.println("Enter 7: To enter a match");
								System.out.println(" ");
								System.out.println("Enter 8: To show the gui");
					}

					//Add method to add a football club's name, location,wins,
					//draws ,defeats ,number of goals received ,number of scored, number of points and the number of matches played
					public static void addFootballClub() {
								SportsClub club;

								//taking the user input on football club's name, location,wins,
								//draws ,defeats ,number of goals received ,number of scored, number of points and the number of matches played
								Scanner sc1 = new Scanner(System.in);
								System.out.println("Enter the name of the football club");
								String nameOfTheClub = sc1.nextLine();

								System.out.println("Enter the location of the football club");
								String location = sc1.nextLine();

								System.out.println("How many wins in the season? ");
								int wins = sc1.nextInt();

								System.out.print("How many draws in the season? ");
								int draws = sc1.nextInt();

								System.out.print("How many defeats in the season? ");
								int defeats = sc1.nextInt();

								System.out.print("How many goals received in the season? ");
								int goalsReceived = sc1.nextInt();

								System.out.print("How many goals scored in the season? ");
								int goalsScored = sc1.nextInt();

								System.out.print("How many matches played in the season? ");
								int numberOfMatchesPlayed = sc1.nextInt();

								System.out.print("How many number of points currently has? ");
								int numberOfPoints = sc1.nextInt();

								club  = new FootballClub(nameOfTheClub, location, wins, draws, defeats, goalsReceived, goalsScored, numberOfMatchesPlayed, numberOfPoints);

								manages.addFootballClub(club);


					}

					//delete a football club
					private static void deleteFootballClub() {

								manages.deleteFootball();

					}

					//displaying the statistics of the football club
					private static void displayVariousStatistics() {

								manages.displayVariousStatistics();

					}

					//adding football club
					public static void enterClubNames(){

								manages.addClubDateName();

					}


			}

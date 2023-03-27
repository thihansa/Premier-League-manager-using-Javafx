package sample;

import javafx.application.Application;
			import javafx.collections.FXCollections;
			import javafx.collections.ObservableList;
			import javafx.scene.Scene;
			import javafx.scene.control.*;
			import javafx.scene.control.cell.PropertyValueFactory;
			import javafx.scene.layout.StackPane;
			import javafx.scene.paint.Color;
			import javafx.scene.text.Font;
			import javafx.scene.text.FontWeight;
			import javafx.stage.Stage;
			import java.io.File;
			import java.io.FileNotFoundException;
			import java.io.IOException;
			import java.util.*;


			public class GUI extends Application  {

					static Stage screen ;
					Scene scene ;
					static Stage primaryStage = new Stage();
					TableView<SportsClub> displayTable = new TableView<>(); //Premier league table
					TableView<Match> displayMatchTable = new TableView<>(); //match table
					static PremierLeagueManager load = new PremierLeagueManager();
					static ObservableList<SportsClub> sportsClubObservableList = FXCollections.observableArrayList(); //Observablelist
					static ObservableList<Match> matchObservableList = FXCollections.observableArrayList(); //Observablelist
					static TextField search ; //for entering the search date

					public static  void  main  (String[] args) throws IOException, ClassNotFoundException {
							//loading the file into the gui
							try {
								load.loadFromFile("Details.txt");
							} catch (FileNotFoundException e){
								new File("Details.txt");
								new File("Matches.txt");
							}
							launch(args);
					}

					//method of the gui
					public void display(boolean use, boolean show){
							screen = primaryStage;
							screen.setTitle("Premier League");
							Label b = new Label("Premier League Table");
							b.setTextFill(Color.web("white"));
							b.setFont(Font.font("Times New Roman", FontWeight.BOLD, 48));
							b.setTranslateX(-700);
							b.setTranslateY(-450);
							Label sort = new Label("Sort By:");
							sort.setTextFill(Color.web("white"));
							sort.setFont(Font.font("Times New Roman", FontWeight.BOLD, 24));
							sort.setTranslateX(-800);
							sort.setTranslateY(-380);



							//creating the premier league table

					if (use){ //for duplicating the columns in the premier league table

							TableColumn<SportsClub, String> nameCol = new TableColumn<>("Name of the club");
							nameCol.setMinWidth(150);
							nameCol.setCellValueFactory(new PropertyValueFactory<>("nameOfTheClub"));


							TableColumn<SportsClub, String> location = new TableColumn<>("Location");
							location.setMinWidth(50);
							location.setCellValueFactory(new PropertyValueFactory<>("location"));

							TableColumn<SportsClub, Integer> winsCol = new TableColumn<>(" Number of Wins");
							winsCol.setMinWidth(150);
							winsCol.setCellValueFactory(new PropertyValueFactory<>("wins"));

							TableColumn<SportsClub, Integer> drawsCol = new TableColumn<>("Number of Draws");
							drawsCol.setMinWidth(150);
							drawsCol.setCellValueFactory(new PropertyValueFactory<>("draws"));

							TableColumn<SportsClub, Integer> defeatsCol = new TableColumn<>("Number of Defeats");
							defeatsCol.setMinWidth(150);
							defeatsCol.setCellValueFactory(new PropertyValueFactory<>("defeats"));

							TableColumn<SportsClub, Integer> receivedCol = new TableColumn<>("Number of Goals Received");
							receivedCol.setMinWidth(200);
							receivedCol.setCellValueFactory(new PropertyValueFactory<>("goalsReceived"));

							TableColumn<SportsClub, Integer> scoredCol = new TableColumn<>("Number of Goals Scored");
							scoredCol.setMinWidth(200);
							scoredCol.setCellValueFactory(new PropertyValueFactory<>("goalsScored"));

							TableColumn<SportsClub, Integer> matchesPlayedCol = new TableColumn<>("Number of Matches Played");
							matchesPlayedCol.setMinWidth(190);
							matchesPlayedCol.setCellValueFactory(new PropertyValueFactory<>("numberOfMatchesPlayed"));

							TableColumn<SportsClub, Integer> pointsCol = new TableColumn<>("Number Of Points");
							pointsCol.setMinWidth(150);
							pointsCol.setCellValueFactory(new PropertyValueFactory<>("numberOfPoints"));

							displayTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
							displayTable.setTranslateX(-50);
							displayTable.setTranslateY(-150);
							displayTable.setMaxHeight(300);
							displayTable.setMaxWidth(1600);
							displayTable.setOpacity(0.9);
                            displayTable.getColumns().addAll(nameCol, location, winsCol,drawsCol,defeatsCol,receivedCol,scoredCol, matchesPlayedCol,pointsCol );
}
							//boolean to avoid duplication values in the table
							if (use==true) {
								displayTable.setItems(getFootballClub());
							}


							//creating a drop down box to the premier league table sort according to the point , goals scored and wins
                        ChoiceBox<String> box = new ChoiceBox<>();
                        box.getItems().addAll("points","goals scored", "wins");

                        box.setOnAction(event -> {
                            String choice  = box.getValue();
                            if (choice.equals("points")) {
                                Collections.sort(sportsClubObservableList, new Points().reversed());
                            }
                            if (choice.equals("goals scored")) {
                                Collections.sort(sportsClubObservableList, new GoalsScored().reversed());
                            }
                            else if (choice.equals("wins")) {
                                Collections.sort(sportsClubObservableList, new Wins().reversed());
                            }

                        });

							box.setTranslateX(-700);
							box.setTranslateY(-350);

							//creating the matches table

                    if (use) { //for duplicating the columns in the premier league table
                        TableColumn<Match, String> firstNameCol = new TableColumn<>("Name of the first club");
                        firstNameCol.setMinWidth(200);
                        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("homeTeam"));

                        TableColumn<Match, String> secondNameCol = new TableColumn<>("Name of the second club");
                        secondNameCol.setMinWidth(200);
                        secondNameCol.setCellValueFactory(new PropertyValueFactory<>("awayTeam"));

                        TableColumn<Match, Integer> firstScore = new TableColumn<>(" First club score");
                        firstScore.setMinWidth(150);
                        firstScore.setCellValueFactory(new PropertyValueFactory<>("firstClubScore"));

                        TableColumn<Match, Integer> secondScore = new TableColumn<>("Second club score");
                        secondScore.setMinWidth(150);
                        secondScore.setCellValueFactory(new PropertyValueFactory<>("secondClubScore"));

                        TableColumn<Match, Integer> dayCol = new TableColumn<>("Day of the Match");
                        dayCol.setMinWidth(150);
                        dayCol.setCellValueFactory(new PropertyValueFactory<>("day"));

                        TableColumn<Match, Integer> monthCol = new TableColumn<>("Month of the Match");
                        monthCol.setMinWidth(150);
                        monthCol.setCellValueFactory(new PropertyValueFactory<>("month"));

                        TableColumn<Match, Integer> yearCol = new TableColumn<>("Year of the Match");
                        yearCol.setMinWidth(150);
                        yearCol.setCellValueFactory(new PropertyValueFactory<>("year"));


                        displayMatchTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                        displayMatchTable.setTranslateX(-280);
                        displayMatchTable.setTranslateY(200);
                        displayMatchTable.setMaxHeight(300);
                        displayMatchTable.setMaxWidth(1150);
                        displayMatchTable.setOpacity(0.9);
                        displayMatchTable.getColumns().addAll(firstNameCol, secondNameCol, firstScore, secondScore, dayCol, monthCol, yearCol);
                    }
                            //boolean to avoid duplication values in the matches table
                            if (!use) {
                                displayMatchTable.setItems(getMatch());
                            }


							Label match1 = new Label("Match Table");
							match1.setTextFill(Color.web("white"));
							match1.setFont(Font.font("Times New Roman", FontWeight.BOLD, 32));
							match1.setTranslateX(475);
							match1.setTranslateY(70);

							search = new TextField();
							search.setFont(Font.font("Cambria",15));
							search.setPromptText("Search By Date");
							search.setMaxWidth(200);

							Button searchButton = new Button("Click to search date");
                            searchButton.setStyle("-fx-background-color:grey; -fx-border-width: 4px; -fx-border-color: black;");

							searchButton.setOnAction(event ->{
								searchMethod();
							});
							search.setTranslateY(150);
							search.setTranslateX(465);
							searchButton.setTranslateY(148);
							searchButton.setTranslateX(650);


							//creating a button to generate a match in the matches table
							Button bt = new Button("Click to enter Match");
							bt.setStyle("-fx-background-color:grey; -fx-border-width: 4px; -fx-border-color: black;");
							bt.setTranslateY(195);
							bt.setTranslateX(450);
							bt.setOnAction(event -> {

								random(); //calling the generate method
								display(false,false);

							});

							//creating a button to sort according to dates in the matches table
							Button button1 = new Button("Click to sort dates");
							button1.setTranslateY(240);
							button1.setTranslateX(442);
							button1.setStyle("-fx-background-color:grey; -fx-border-width: 4px; -fx-border-color: black;"); //giving the button a color
							button1.setOnAction(event -> {
								Collections.sort(matchObservableList); //sorting the the match observable list
							});

							//button to go back to the console
							Button console1 = new Button("Back to Menu");
                            console1.setStyle("-fx-background-color:grey; -fx-border-width: 4px; -fx-border-color: black;");
							console1.setTranslateY(285);
							console1.setTranslateX(425);
							console1.setOnAction(event -> {
								screen.setIconified(true);
								try {
									Menu.console();
								} catch (IOException e) {
									e.printStackTrace();
								} catch (ClassNotFoundException e) {
									e.printStackTrace();
								}
							});


							StackPane layout = new StackPane();
							layout.getChildren().addAll(b,sort,box,displayTable,displayMatchTable,match1,search,searchButton,bt,button1,console1);
							layout.setId("pane");
							scene = new Scene(layout, 1900, 1000);
							scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm()); //calling the css file
							screen.setScene(scene);
							screen.show();
							screen.setIconified(show);

					}



					public void start(Stage primaryStage) throws IOException, ClassNotFoundException {
							display(false,true);
							Menu.console();
					}

					//adding the football array elements into the observable list
					public ObservableList<SportsClub> getFootballClub()  {
                        sportsClubObservableList.clear();
                        sportsClubObservableList.addAll(PremierLeagueManager.football);
							Collections.sort(sportsClubObservableList, new Points().reversed());
							return sportsClubObservableList;
					}

					//adding the matches array elements into the observable list
					public ObservableList<Match> getMatch() {
							matchObservableList.clear();
                        matchObservableList.addAll(PremierLeagueManager.matches);
							return matchObservableList;
					}


					//method to generate a match randomly
					public static void random() {
							//randomly generating numbers dor day, month and year
							int rand_int1 = (int) (Math.random() * (PremierLeagueManager.football.size()));
							int firstClubScore = (int) (Math.random() * 11) + 1;
							int secondClubScore = (int) (Math.random() * 11) + 1;
							int day = (int) (Math.random() * 31) + 1;
							int month = (int) (Math.random() * 12) + 1;
							int year = (int) (Math.random() * (2022-2020) + 2020);
							int rand_int2 = (int) (Math.random() * (PremierLeagueManager.football.size()));
							while (rand_int1 == rand_int2) {
								rand_int2 = (int) (Math.random() * (PremierLeagueManager.football.size()));
							}


							FootballClub firstName = PremierLeagueManager.football.get(rand_int1);
							FootballClub secondName = PremierLeagueManager.football.get(rand_int2);


							Match list = new Match(firstName,secondName, firstClubScore,secondClubScore,day,month,year);
							PremierLeagueManager.matches.add(list);


							//updating the score
							//setting the entered first-club-score and the second-club-score to the goals scored
							firstName.setGoalsScored(firstName.getGoalsScored()+firstClubScore);
							secondName.setGoalsScored(secondName.getGoalsScored()+secondClubScore);

							//setting the entered first-club-score and the second-club-score to the goals received
							firstName.setGoalsReceived(firstName.getGoalsReceived()+secondClubScore);
							secondName.setGoalsReceived(secondName.getGoalsReceived()+firstClubScore);

							//increasing the number of matches played by 1
							firstName.setNumberOfMatchesPlayed(firstName.getNumberOfMatchesPlayed()+1);
							secondName.setNumberOfMatchesPlayed(secondName.getNumberOfMatchesPlayed()+1);

							//checking if first club or second club has won and adding 3 points and 1 win to the club who won
							// and adding 1 defeat to the one who lost
							if (firstClubScore > secondClubScore) {
								firstName.setNumberOfPoints(firstName.getNumberOfPoints()+3);
								firstName.setWins(firstName.getWins()+1);
								secondName.setDefeats(secondName.getDefeats()+1);
							}

							else if (firstClubScore < secondClubScore) {
								secondName.setNumberOfPoints(secondName.getNumberOfPoints()+3);
								secondName.setWins(secondName.getWins()+1);
								firstName.setDefeats(firstName.getDefeats()+1);
							}
							//if draw the increase number of points by 1 and draws by 1
							else {
								firstName.setNumberOfPoints(firstName.getNumberOfPoints()+1);
								secondName.setNumberOfPoints(secondName.getNumberOfPoints()+1);
								firstName.setDraws(firstName.getDraws()+1);
								secondName.setDraws(secondName.getDraws()+1);
							}

						}

						//method for the date search
						public void searchMethod(){
							String input = search.getText();
							String[] breakDate = input.split("/"); //splits using "/"
							String breakDay = breakDate[0];
							String breakMonth = breakDate[1];
							String breakYear = breakDate[2];

							int dayNum = Integer.parseInt(breakDay);
							int monthNum = Integer.parseInt(breakMonth);
							int yearNum = Integer.parseInt(breakYear);

							ObservableList<Match> filteredDate = FXCollections.observableArrayList();
							for (Match date : PremierLeagueManager.matches){
								if(dayNum == date.getDay()){
									if(monthNum == date.getMonth()){
										if(yearNum == date.getYear()){
											filteredDate.add(date);
										}
									}
								}
							}displayMatchTable.setItems(filteredDate);

						}



			}

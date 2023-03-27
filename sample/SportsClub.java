package sample;

import java.io.Serializable;
			import java.util.Objects;

			public  class SportsClub implements Serializable {
			//super class is the sports club

						private String nameOfTheClub;
						private String location;


						public SportsClub(String nameOfTheClub, String location ) {
								this.nameOfTheClub = nameOfTheClub;
								this.location = location;
						}

						public String getNameOfTheClub() {
								return nameOfTheClub;
						}

						public void setNameOfTheClub(String nameOfTheClub) {
								this.nameOfTheClub = nameOfTheClub;
						}

						public String getLocation() {
								return location;
						}

						public void setLocation(String location) {
								this.location = location;
						}


						//converts objects to string
						public String toString() {
								return "SportsClub{" +
										"nameOfTheClub='" + nameOfTheClub + '\'' +
										", location='" + location + '\'' +
										'}';
						}

						//two objects are equal to eachother
						public boolean equals(Object o) {
								if (this == o) return true;
								if (o == null || getClass() != o.getClass()) return false;
								SportsClub that = (SportsClub) o;
								return Objects.equals(nameOfTheClub, that.nameOfTheClub) &&
										Objects.equals(location, that.location);
						}

						public int hashCode() {
								return Objects.hash(nameOfTheClub, location);
						}
			}

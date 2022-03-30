/*
Name: Luke Perri, Logan Raposo, Edward Nieves
Date: 5/2/21
Email: lukeperri71@gmail.com, lraposo@mocsflsouthern.edu, edwardn102@icloud.com
Assignment: Program 5
Course Number: CSC2290 002
Honor Code: 
“I will practice academic and personal integrity and excellence of character and expect the same from others.”
As an academic community, Florida Southern College is firmly committed to honor and integrity in the pursuit of knowledge. 
Therefore, as a member of this academic community, each student acknowledges  responsibility  
for  his  or  her  actions  and  commits  to  the  highest  standards  of integrity. 
In doing so through this Honor Code, each student makes a covenant with the college not to engage in any form of academic
dishonesty, fraud, cheating, or theft.  Further information on the Honor Code is available in the current Catalog.
 */
package program5;

import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Program5 extends Application {
// declare variables at the top
    private static Stage searchStage = null;

    private static Stage personStage = null;

    private static ArrayList<Person> personsAdded = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Here, we open the actual main menu window.
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        primaryStage.setTitle("Main Menu");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        createSearchStage();
        createPersonStage();
    }

    public void createSearchStage() {
        // Here, we create a new stage, which opens up the window to search a person.
        searchStage = new Stage();
        searchStage.setTitle("Search for a Person");
        searchStage.setAlwaysOnTop(true);
        searchStage.setResizable(false);
        searchStage.initModality(Modality.APPLICATION_MODAL);
    }

    public static Stage getSearchStage() {
        return searchStage;
    }

    public void createPersonStage() {
        // Here, we create a new stage in order to open up the window 
        // that adds a person to the ArrayList.
        personStage = new Stage();
        personStage.setTitle("Create a Contact");
        personStage.setAlwaysOnTop(true);
        personStage.setResizable(false);
        personStage.initModality(Modality.APPLICATION_MODAL);
    }

    public static Stage getPersonStage() {
        return personStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void addPerson(Person tempPerson) {
        personsAdded.add(tempPerson);
    }

    public static ArrayList<Person> getPersons() {
        return personsAdded;
    }

}

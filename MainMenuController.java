package program5;

import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class MainMenuController {
    // This is the controller for the main menu.
    // We create a new ArrayList to save all the people we add to the program.
    ArrayList<Person> personsAdded = new ArrayList<>();

    public void openSearchWindow() {
        try {
            // By opening the window to search for a person, we get the fxml file used to create the window and run it.
            // We then show it to the user.
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/program5/SearchPerson.fxml"));
            Parent root = loader.load();

            Program5.getSearchStage().setScene(new Scene(root));

            Program5.getSearchStage().show();

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public void openAddPersonWindow() {
        try {
            // Here, this method will get the fxml file to open the window for the user to add a person and show it to them.
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/program5/Person.fxml"));
            Parent root = loader.load();

            Program5.getPersonStage().setScene(new Scene(root));

            Program5.getPersonStage().show();

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public void onMouseClick(MouseEvent mouseEvent) {

        Button button = (Button) mouseEvent.getSource();
        String buttonText = button.getText();
        switch (buttonText) {
            case "Search":
                // If we click the button labeled "Search", the SearchPerson window will open.
                openSearchWindow();
                break;
            case "Add":
                // If we click the button labeled "Add", the Person window will open.
                openAddPersonWindow();
                break;
        }
    }

}

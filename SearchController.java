/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program5;

import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class SearchController {
    // This class is the controller for the search person window.

    @FXML
    private TextField searchPerson;

    @FXML
    // We create a series of labels to identify events that happen in the window, and what we are entering in each text box.
    private Label studentInfoStatement, errorMessage, firstName, lastName, phoneNumber, city, state, zipCode, email, sreetAddress;

    public void onMouseClick(MouseEvent mouseEvent) {
        // We create a method that executes when we click using a mouse.
        Button button = (Button) mouseEvent.getSource();
        String buttonText = button.getText();
        String fullName;
        ArrayList<Person> personsAdded;
        personsAdded = Program5.getPersons();
        String tempName;
        boolean personFound = false;
        // For each button that can be clicked, we have a switch statement to execute what happens once the click occurs.
        switch (buttonText) {
            // If we click the button labeled "Search, the following under this case runs.
            case "Search":
                fullName = searchPerson.getText();
                for (int i = 0; i < personsAdded.size(); i++) {
                    tempName = personsAdded.get(i).getFirstName() + " " + personsAdded.get(i).getLastName();
                    // For ALL the students in the arrayList, if the full name is found in the arrayList,
                    // we then get all the information from that student, then print it to the user in the window.
                    if (fullName.equalsIgnoreCase(tempName)) {
                        personFound = true;
                        studentInfoStatement.setText("Student's Information:");
                        firstName.setText("First Name: " + personsAdded.get(i).getFirstName());
                        lastName.setText("Last Name: " + personsAdded.get(i).getLastName());
                        phoneNumber.setText("Phone Number: " + personsAdded.get(i).getPhone());
                        city.setText("City: " + personsAdded.get(i).getCity());
                        state.setText("State: " + personsAdded.get(i).getState());
                        zipCode.setText("Zipcode:  " + personsAdded.get(i).getZip());
                        sreetAddress.setText("Address: " + personsAdded.get(i).getStreet());
                        email.setText("Email: " + personsAdded.get(i).getEmail());
                        errorMessage.setText("");
                        break;
                    }
                }
                // If the full name is NOT found in the arrayList, an error message will appear to the user,
                // and the user can try again to input another name.
                if (personFound == false) {
                    errorMessage.setText("Error: The person you were looking for was not found");
                    studentInfoStatement.setText("");
                    firstName.setText("");
                    lastName.setText("");
                    phoneNumber.setText("");
                    city.setText("");
                    state.setText("");
                    zipCode.setText("");
                    sreetAddress.setText("");
                    email.setText("");

                }
        }

    }
    // Once we are done using the program, we can then click the button labeled "Close", and the window will close.
    public void onCloseClick() throws Exception{
        Program5.getSearchStage().close();
    }

}

package program5;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PersonController {
    // This is the controller for the Person.fxml file.
    @FXML
    // We have a series of labels to identify events that happen in the program.
    private Label message, firstNameError, lastNameError, cityError, stateError, zipError, streetError, emailError, phoneError;

    @FXML
    // These identify the text fields in the Person window.
    private TextField firstName, lastName, city, state, streetAddress, zip, email, phoneNumber;
    
    // We create a set of boolean variables to identify if what is entered for each text box is valid.
    
    boolean fNameValid, lNameValid, cityValid, stateValid, streetValid, zipValid, emailValid, phoneValid;

    public void onOkClick() throws IOException {

        String addFirstName = firstName.getText();
        String addLastName = lastName.getText();
        String addCity = city.getText();
        String addState = state.getText();
        String addZip = zip.getText();
        String addStreet = streetAddress.getText();
        String addEmail = email.getText();
        String addPhone = phoneNumber.getText();
       // If a text field is left empty, an exclamation mark appears next to the field.
        if (addFirstName.length() < 1) {
            firstNameError.setText("!");
            fNameValid = false;
        }
        else {
            firstNameError.setText("");
            fNameValid = true;
        }
        if (addLastName.length() < 1) {
            lastNameError.setText("!");
            lNameValid = false;
        }
        else {
            lastNameError.setText("");
            lNameValid = true;
        }
        if (addCity.length() < 1) {
            cityError.setText("!");
            cityValid = false;
        }
        else {
            cityError.setText("");
            cityValid = true;
        }
        if (addState.length() < 1) {
            stateError.setText("!");
            stateValid = false;
        }
        else {
            stateError.setText("");
            stateValid = true;
        }
        if (addStreet.length() < 1) {
            streetError.setText("!");
            streetValid = false;
        }
        else {
            streetError.setText("");
            streetValid = true;
        }
        // If the email does not contain an "@" symbol or a ".", it is not 
        // a valid email address, thus showing an error.
        if (addEmail.length() < 1 || addEmail.contains("@") == false || addEmail.contains(".") == false) {
            emailError.setText("!");
            emailValid = false;
        }
        else {
            emailError.setText("");
            emailValid = true;
        }
        // If the zip code is NOT 5 digits, it is not a valid zip code, thus showing an error.
        if (addZip.length() != 5) {
            zipError.setText("!");
            zipValid = false;
        }
        else {
            zipError.setText("");
            zipValid = true;
        }
        // If the phone number is NOT 10 digits, it is not a valid phone number, thus showing an error.
        if (addPhone.length() != 10) {
            phoneError.setText("!");
            phoneValid = false;
        }
        else {
            phoneError.setText("");
            phoneValid = true;
        }
        char tempChar;
        //validate that the zip code is only digits
        // loop through the length of the zipCode and verify that each 
        // character at index i is a digit
        for (int i = 0; i < addZip.length(); i++) {
            tempChar = addZip.charAt(i);
            if (Character.isDigit(tempChar) == false) {
                zipError.setText("!");
                zipValid = false;
            }
        }
        //validate that the phone number is only digits
        // loop through the length of the phone number and verify that each 
        // character at index i is a digit
        for (int i = 0; i < addPhone.length(); i++) {
            tempChar = addPhone.charAt(i);
            if (Character.isDigit(tempChar) == false) {
                phoneError.setText("!");
                phoneValid = false;
            }
        }
        if (zipValid == true) {
            zipError.setText("");
        }
        if (phoneValid == true) {
            phoneError.setText("");
        }
        // The error message for if the text fields are empty or 
        // invalid information is entered will be printed to the user.
        if (phoneValid == false || zipValid == false || fNameValid == false || lNameValid == false || cityValid == false || stateValid == false || streetValid == false || emailValid == false) {
            message.setText("Error: Please fill out the fields correctly");
        }
        else {
            // If everything is added successfully, the information is stored 
            // in a person object, saved to the ArrayList, then the text fields are reset.
            message.setText("");
            Person tempPerson = new Person(addFirstName, addLastName, addEmail, addPhone, addStreet, addCity, addState, addZip);
            Program5.addPerson(tempPerson);
            firstName.setText("");
            lastName.setText("");
            email.setText("");
            phoneNumber.setText("");
            zip.setText("");
            streetAddress.setText("");
            city.setText("");
            state.setText("");
            message.setText("Person successfully added to database");

        }

    }
    // If the user clicks "close", the window will close.
    public void onMouseClick() throws Exception {
        Program5.getPersonStage().close();
    }

}

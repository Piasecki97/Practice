package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class Controller {
    @FXML
    private TextField nameField;
    @FXML
    Button helloButton;
    @FXML
    Button byeButton;
    @FXML
    private CheckBox ourCheckBox;

    @FXML
    public void initialize() {
        helloButton.setDisable(true);
        byeButton.setDisable(true);

    }
    @FXML
    public void onButtonClicked(ActionEvent e) {
        if (e.getSource().equals(helloButton)) {
            System.out.println("Hello, " + nameField.getText());
        }
        else if (e.getSource().equals(byeButton)){
            System.out.println("Bye, " + nameField.getText());

        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException event){

        }
        if(ourCheckBox.isSelected()){
            nameField.clear();
            helloButton.setDisable(true);
            byeButton.setDisable(true);
        }
    }
    @FXML
    public void handleKeyReleased() {
        String text = nameField.getText();
        boolean disableButtons = text.isEmpty() || text.trim().isEmpty();
        helloButton.setDisable(disableButtons);
        byeButton.setDisable(disableButtons);
    }

    public void handleChange() {
        System.out.println("The checkbox is " + (ourCheckBox.isSelected() ? "checked" : "not checked"));
    }
}

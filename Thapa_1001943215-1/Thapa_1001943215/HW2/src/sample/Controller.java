package sample;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import java.io.BufferedWriter;
import java.io.IOException;

public class Controller {

    @FXML
    private TextField purchase_date;

    @FXML
    private TextField acc_no;

    @FXML
    private ComboBox chooseOne;

    @FXML
    private TextField name;

    @FXML
    private TextField street;

    @FXML
    private TextField city;

    @FXML
    private TextField state;

    @FXML
    private TextField zip;

    @FXML
    private TextField title;

    @FXML
    private ToggleGroup ToggleGroup;

    @FXML
    private Label typeMusic;

    @FXML
    private Label typeApp;

    @FXML
    private HBox toggle;

    @FXML
    private CheckBox appButton;

    @FXML
    private CheckBox musicButton;

    public void togglemusic() {
        if (appButton.isSelected()){
            chooseOne.setDisable(true);
            typeMusic.setDisable(true);
            musicButton.setDisable(true);
        }
        else {
            chooseOne.setDisable(false);
            typeMusic.setDisable(false);
            musicButton.setDisable(false);
        }
    }
    public void toggleapp(){
        if(musicButton.isSelected()){
            toggle.setDisable(true);
            typeApp.setDisable(true);
            appButton.setDisable(true);
        }
        else {
            toggle.setDisable(false);
            typeApp.setDisable(false);
            appButton.setDisable(false);
        }
    }

    String document;
    Alert document1 = new Alert(AlertType.NONE);

    public void execute(){
        Platform.exit();
        System.exit(0);
    }

    public void dataProcess() {
        String[] customer = new String[11];
        String newState = state.getText();
        String newZip = zip.getText();
        String newButton = appButton.getText();
        String newMusic = musicButton.getText();
        String choose_one = chooseOne.getValue().toString();
        String newName = name.getText();
        String newStreet = street.getText();
        String newCity = city.getText();
        String newTitle = title.getText();
        String newPurchase = purchase_date.getText();
        String newAccount = acc_no.getText();
        RadioButton radioButton = (RadioButton) ToggleGroup.getSelectedToggle();

        if(newName.isEmpty()) {
            showAlert("Enter your name");
            name.requestFocus();
        }
        else if(newStreet.isEmpty()) {
            showAlert("Enter your street");
            street.requestFocus();
        }
        else if(appButton.isSelected() && musicButton.isSelected()) {
            showAlert(" One Music or App");
            appButton.requestFocus();
        }
        else if(chooseOne.equals("CHOOSE ONE")) {
            showAlert("Select valid option");
            chooseOne.requestFocus();
        }
        else if (toggle.equals("choose one")){
            showAlert("select valid option");
            toggle.requestFocus();
        }
        else if(newTitle.isEmpty()) {
            showAlert("Enter your Title");
            title.requestFocus();
        }
        else if(newCity.isEmpty()) {
            showAlert("Enter your city!!");
            city.requestFocus();
        }
        else if(newState.isEmpty()) {
            showAlert("Enter your state");
            state.requestFocus();
        }
        else if(newZip.isEmpty()) {
            showAlert("Enter your zip");
            zip.requestFocus();
        }
        else if(!appButton.isSelected() && !musicButton.isSelected()) {
            showAlert("Select Music or App");
            appButton.requestFocus();
        }

        else if(newPurchase.isEmpty()) {
            showAlert("Enter your Purchase Date");
            purchase_date.requestFocus();
        }
        else if(newAccount.isEmpty()) {
            showAlert("Enter your Account number");
            acc_no.requestFocus();
        }
        else {
            if(appButton.isSelected()) {
                customer[6]=newButton;
                document="app.txt";
            }
            if (musicButton.isSelected()) {
                customer[6]=newMusic;
                document="music.txt";
            }

            customer[0]= "Name ="+ newName;
            customer[1]= "Street = "+ newStreet;
            customer[2]= "City = "+newCity;
            customer[3]="State = "+newState;
            customer[4]="Zip = "+newZip;
            customer[5]=choose_one;
            customer[8]= "Title = "+ newTitle;
            customer[9]= " Date Purchase  = "+ newPurchase;
            customer[10]= "Account Number = "+ newAccount;
            createFile(customer);
        }
    }

    private void createFile(String[] customer) {
        Path path = Paths.get(document);

        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<11;i++)
            stringBuilder.append(customer[i]+"\t\t");
        stringBuilder.append("\n");

        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8,
                StandardOpenOption.APPEND, StandardOpenOption.CREATE)) {
            writer.write(stringBuilder.toString());
        } catch (IOException event) {
            event.printStackTrace();
        }
        clearFields();
        name.requestFocus();
    }

    public void showAlert(String text){
        document1.setAlertType(AlertType.ERROR);
        document1.setContentText(text);
        document1.show();
    }

    public void clearFields(){
        name.clear();
        street.clear();
        city.clear();
        state.clear();
        zip.clear();
        appButton.setSelected(false);
        musicButton.setSelected(false);
        chooseOne.getSelectionModel().select(0);
        title.clear();
        purchase_date.clear();
        acc_no.clear();
    }
}
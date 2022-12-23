package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller implements Initializable {

    @FXML
    private Label timeLabel;

    @FXML
    private Label displayUsername;

    @FXML
    private Text total;

    @FXML
    private Text wpm;

    @FXML
    private Text invalid;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        File file = new File("username.txt");
        if (file.length() != 0) {
            Scanner reader = null;
            try {
                reader = new Scanner(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            String data = reader.nextLine();
            displayUsername.setText("Welcome, "+data);

        }
        // set the day
        Date date = new Date();
        Locale locale = new Locale("en");
        DateFormat formatter = new SimpleDateFormat("EEEE", locale);
        String day = formatter.format(date);

        timeLabel.setText("Today is " + day);

        // filehandling
        int [] data= FileHandling.sumText("src/data/");
        total.setText(String.valueOf(data[0]));
        wpm.setText(String.valueOf(Math.round(data[1]*1.0/data[3])));
        invalid.setText(String.valueOf(data[2]));
    }


    public void playGame(ActionEvent event) throws IOException {
        Main main = new Main();

        File file = new File("username.txt");
        if (file.length() == 0) {
            try {
                main.changeScene("popup.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            main.changeScene("game.fxml");
        }

    }
}
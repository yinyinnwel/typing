package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.FileWriter;
import java.io.IOException;

public class PopupController {

    @FXML
    private TextField username;

    public void submit(ActionEvent event) throws IOException {
        String name = username.getText();
        FileWriter fw = new FileWriter("username.txt");
        fw.write(name);
        fw.close();

        Main main = new Main();
        main.changeScene("sample.fxml");
    }

}
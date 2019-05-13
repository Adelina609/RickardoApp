package ru.kpfu.itis;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class QuestionController implements Initializable {

    @FXML
    private AnchorPane background;

    @FXML
    private ImageView imageView;

    @FXML
    private Button answerButton;

    @FXML
    private TextField answer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File file = new File("src/main/assets/img/1question.png");
        Image image = new Image(file.toURI().toString());
        imageView.setImage(image);
    }
}

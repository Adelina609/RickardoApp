package ru.kpfu.itis.controllers;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.client.HelloService;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class QuestionController implements Initializable {
    private static final Logger log = LoggerFactory.getLogger(QuestionController.class);

    private HelloService helloService = new HelloService();

    @FXML
    private AnchorPane background;

    @FXML
    private ImageView imageView;

    @FXML
    private TextField answer;

    @FXML
    private Label messageLabel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        File file = new File("src/main/assets/img/1question.png");
        Image image = new Image(file.toURI().toString());
        imageView.setImage(image);
    }

    @FXML
    private void check(){
        messageLabel.setText("");
        helloService.setName(answer.getText());

        helloService.setOnSucceeded(event -> {
            if (helloService.getValue().equals("true")){
                //вызов успешного модального окна
            } else{
                //вызов неуспешного модального окна
            }
        });

        helloService.setOnFailed(event ->
                log.error(
                        "Unable to say hello to " +
                                helloService.getException()
                )
        );

        helloService.restart();
    }
}

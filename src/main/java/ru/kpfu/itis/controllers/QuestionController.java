package ru.kpfu.itis.controllers;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class QuestionController implements Initializable {

    @Autowired
    ConfigurableApplicationContext springContext;

    @FXML
    private AnchorPane background;

    @FXML
    private ImageView imageView;

    @FXML
    private Button submitButton;

    @FXML
    private Button deleteLast;

    @FXML
    private TextField answerField;

    @FXML
    private Button menuButton;

    @FXML
    private Button[] letters;

    @FXML
    private Button letter1, letter2, letter3, letter4, letter5, letter6, letter7, letter8,
            letter9, letter10, letter11, letter12, letter13, letter14, letter15, letter16,
            letter17, letter18, letter19, letter20, letter21, letter22, letter23, letter24,
            letter25, letter26, letter27, letter28, letter29, letter30, letter31, letter32;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        File file = new File("src/main/assets/img/1question.png");
        Image image = new Image(file.toURI().toString());
        imageView.setImage(image);

        deleteLast.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                answerField.setText(answerField.getText().substring(0, answerField.getText().length() - 1));
            }
        });

        menuButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                menuButton.getScene().getWindow().hide();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/fxml/home.fxml"));
                fxmlLoader.setControllerFactory(springContext::getBean);
                try {
                    Parent root = fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setTitle("Главное меню");
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                }

        });

        submitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/fxml/correctModal.fxml"));
                fxmlLoader.setControllerFactory(springContext::getBean);
                try {
                    Parent root = fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setTitle("yoyoyoyoyo broooo");
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            });

        letters = new Button[] {letter1, letter2, letter3, letter4, letter5, letter6, letter7, letter8,
                letter9, letter10, letter11, letter12, letter13, letter14, letter15, letter16,
                letter17, letter18, letter19, letter20, letter21, letter22, letter23, letter24,
                letter25, letter26, letter27, letter28, letter29, letter30, letter31, letter32};

        for (Button but : letters) {
            but.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    answerField.setText(answerField.getText() + but.getText());
                }
            });
        }
        }

    }
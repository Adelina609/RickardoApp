package ru.kpfu.itis;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.kpfu.itis.repository.QuestionRepository;
import ru.kpfu.itis.server.HelloServer;
import ru.kpfu.itis.services.QuestionService;

import javax.websocket.DeploymentException;

@SpringBootApplication
public class Main extends Application {

    private ConfigurableApplicationContext springContext;
    private Parent root;

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    private static final String MAIN_FXML_FILE = "/fxml/hello.fxml";

    private HelloServer server;

    private QuestionService questionService;

    @Override
    public void init() throws Exception {
        server = new HelloServer();
        server.start();
        springContext = SpringApplication.run(Main.class);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/fxml/home.fxml"));
        fxmlLoader.setControllerFactory(springContext::getBean);

//        springContext.getBean(QuestionRepository.class);
        questionService = new QuestionService();
        questionService.addAll();
        root = fxmlLoader.load();
    }

    @Override
    public void start(Stage stage) throws Exception{
        log.info("Starting Hello JavaFX WebSocket demonstration application");
        log.debug("Loading FXML for main view");

        stage.setMaxHeight(800);
        stage.setMaxHeight(800);
        stage.setTitle("Игра");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @Override
    public void stop() throws Exception, DeploymentException {
        springContext.stop();
        server.stop();
    }


    public static void main(String[] args) {
        launch(Main.class, args);
    }
}

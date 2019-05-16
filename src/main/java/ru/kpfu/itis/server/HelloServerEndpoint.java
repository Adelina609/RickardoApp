package ru.kpfu.itis.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import ru.kpfu.itis.models.Question;
import ru.kpfu.itis.services.QuestionService;

import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/")
@ComponentScan("ru.kpfu.itis.services")
public class HelloServerEndpoint {

    @Autowired
    private QuestionService questionService;

    private static final Logger log = LoggerFactory.getLogger(HelloServerEndpoint.class);

    @OnMessage
    public Boolean onMessage(Session session, String message) {
        log.debug("HelloServer received request for: " + message + " being processed for session " + session.getId());

        //здесь вызываем метод проверки слова и если правильно то возвращаем тру, если нет то фолс

//        questionService.getAll().get(0).getAnswer().equals(message);
        return false;
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        log.error("HelloServer encountered error for session " + session.getId(), throwable);
    }
}
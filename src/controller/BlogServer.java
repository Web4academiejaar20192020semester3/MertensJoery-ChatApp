package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.PersonService;
import domain.Reply;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import javax.xml.stream.events.Comment;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint("/comment")
public class BlogServer {
    public static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<>());
    private final PersonService personService = new PersonService();
    private ObjectMapper mapper = new ObjectMapper();

    @OnOpen
    public void open(Session session) {
        sessions.add(session);
    }
    @OnMessage
    public void message(String message, Session session){
        try {
            for (Session session1 : sessions){
                session1.getBasicRemote().sendText(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @OnClose
    public void close(Session session){
        sessions.remove(session);
    }
}

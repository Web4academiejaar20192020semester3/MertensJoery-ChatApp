package controller;

import domain.Reply;
import domain.Topic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class Home extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ArrayList<Topic> topics = new ArrayList<>();
        Topic topic1=new Topic("topic1");
        topic1.addReply(new Reply("jan","jan zijn comment", 7));
        topics.add(topic1);
        Topic topic2=new Topic("topic2");
        topic2.addReply(new Reply("jans","jan zijn commentses", 7));
        topics.add(topic2);
        Topic topic3=new Topic("topic3");
        topic3.addReply(new Reply("jand","jan zijn commentdsd", 8));
        topics.add(topic3);
        Topic topic4=new Topic("topic4");
        topic4.addReply(new Reply("janf","jan zijn commentfdfd", 7));
        topics.add(topic4);
        Topic topic5=new Topic("topic5");
        topic5.addReply(new Reply("jang","jan zijn commentdfsfg", 6));
        topics.add(topic5);

        request.setAttribute("topics",topics);
        return "index.jsp";
    }
}

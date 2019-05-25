package controller;

import domain.Conversation;
import domain.Message;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendMessage extends AsyncRequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Person person = (Person) request.getSession().getAttribute("user");

        String message = request.getParameter("message");

        String id = request.getParameter("messageTarget");

        Person target = this.getPersonService().getPerson(id);
        if (!(person.getConversation().contains(person) && person.getConversation().contains(target))) {
            person.setConversation(new Conversation(person, target));
        }

        if (message.equals("") || target == null) {
            return "";
        }
        Message m = new Message(message, person);


        person.getConversation().addMessage(m);
        target.setConversation(person.getConversation());
        return "";
    }
}

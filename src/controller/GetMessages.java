package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Message;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetMessages extends AsyncRequestHandler {
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Person person = (Person) request.getSession().getAttribute("user");
        List<Message> messageList = person.getConversation().getMessages();
        String result = mapper.writeValueAsString("");
        if (!(messageList == null)) {

            result = mapper.writeValueAsString(messageList);

        }
        return result;
    }

}
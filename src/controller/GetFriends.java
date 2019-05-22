package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Console;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class GetFriends extends AsyncRequestHandler  {
    private ObjectMapper mapper = new ObjectMapper();
    @Override
    public String handleRequest (HttpServletRequest request, HttpServletResponse response) throws IOException {
        Person user = (Person) request.getSession().getAttribute("user");
        ArrayList<Person> friends = user.getFriends();
        String json = mapper.writeValueAsString(friends);
        return json;
    }
}

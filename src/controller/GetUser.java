package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.AngularPerson;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetUser extends AsyncRequestHandler  {
    private ObjectMapper mapper = new ObjectMapper();
    @Override
    public String handleRequest (HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Person temp = super.getPersonService().getPerson(request.getParameter("userId"));
        AngularPerson angularPerson = new AngularPerson();
        angularPerson.setFirstName(temp.getFirstName());
        angularPerson.setAge(temp.getAge());
        angularPerson.setGender(temp.getGender());
        angularPerson.setLastName(temp.getLastName());
        angularPerson.setUserId(temp.getUserId());
        String json = mapper.writeValueAsString(angularPerson);
        System.out.println(json);
        //System.out.println(request.getParameter("userId"));
        return json;
    }
}

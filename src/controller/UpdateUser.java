package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateUser extends AsyncRequestHandler  {
    private ObjectMapper mapper = new ObjectMapper();
    @Override
    public String handleRequest (HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Person userAppPersoon = mapper.readValue(request.getInputStream(),Person.class);
        Person result = super.getPersonService().getPerson(userAppPersoon.getUserId());
        result.setFirstName(userAppPersoon.getFirstName());
        result.setLastName(userAppPersoon.getLastName());
        result.setAge(userAppPersoon.getAge());
        result.setGender(userAppPersoon.getGender());
        super.getPersonService().updatePersons(result);
      //  return toJSON(personService.getPerson(result.getUserId()));
        return "";
    }
}

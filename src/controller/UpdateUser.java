package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;
import domain.AngularPerson;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateUser extends AsyncRequestHandler  {
    private ObjectMapper mapper = new ObjectMapper();
    @Override
    @JsonIgnoreProperties(ignoreUnknown = true)
    public String handleRequest (HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        AngularPerson userAppPersoon = mapper.readValue(request.getInputStream(),AngularPerson.class);
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

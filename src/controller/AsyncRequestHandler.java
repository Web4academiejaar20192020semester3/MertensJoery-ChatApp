package controller;

import domain.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AsyncRequestHandler extends RequestHandler {
    private PersonService personService;

    public abstract String handleRequest (HttpServletRequest request, HttpServletResponse response) throws IOException;

    public void setModel (PersonService personService) {
        this.personService = personService;
    }

    public PersonService getPersonService() {
        return personService;
    }

}

package controller;

import domain.Person;
import domain.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeStatus extends AsyncRequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        PersonService personService = super.getPersonService();
        Person user = (Person) request.getSession().getAttribute("user");
        String status = request.getParameter("status");
        user.setStatus(status);
        return "";
    }
}

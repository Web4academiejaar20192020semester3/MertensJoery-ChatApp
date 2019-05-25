package controller;

import domain.Person;
import domain.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class AddPerson extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        List<String> errors = new ArrayList<String>();
        PersonService personService = super.getPersonService();
        String password = request.getParameter("password");
        if (!password.equals(request.getParameter("passwordR"))) {
            errors.add("Passwords were not equal");
        }
        Person person = new Person();
        try {
            person.setUserId(request.getParameter("email"));
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
        try {
            person.setFirstName(request.getParameter("Fname"));
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
        try {
            person.setLastName(request.getParameter("name"));
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
        try {
            person.setHashedPassword(request.getParameter("password"));
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
        try {
            person.setGender(request.getParameter("gender"));
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
        try {
            person.setAge(Integer.parseInt(request.getParameter("age")));
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
        if (errors.size() > 0) {
            System.out.println(errors);
            request.setAttribute("errors", errors);
            return "Controller?action=Register";
        }
        try {
            personService.addPerson(person);
        } catch (Exception e) {
            errors.add(e.getMessage());
            request.setAttribute("errors", errors);
            return "Controller?action=Register";
        }

        return "Controller?action=Home";
    }
}

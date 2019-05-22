package controller;

import domain.Person;
import domain.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddFriend extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        PersonService personService = super.getPersonService();
       Person user = (Person)request.getSession().getAttribute("user");
       String userid= request.getParameter("userid");
       Person friend = personService.getPerson(userid);
       user.addFriend(friend);
       friend.addFriend(user);
        return "";
    }
}

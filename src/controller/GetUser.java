package controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetUser extends AsyncRequestHandler  {
    private ObjectMapper mapper = new ObjectMapper();
    @Override
    public String handleRequest (HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        String json = mapper.writeValueAsString(super.getPersonService().getPerson(request.getParameter("userId")));
        System.out.println(json);
        System.out.println(request.getParameter("userId"));
        return json;
    }
}

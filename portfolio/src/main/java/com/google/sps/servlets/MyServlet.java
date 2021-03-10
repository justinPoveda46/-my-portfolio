package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
    private String[] myFacts = {"I am a magician", "I collect fitted hats", "I can recite the entire Nacho Libre Movie"};
    /**
     *
     */
    private static final long serialVersionUID = -6558145762346063268L;

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String json = convertToJson(myFacts);
        response.setContentType("text/html;");
        response.getWriter().println(json);
  }
  
  private String convertToJson(String[] myFacts) {
        String json = "{";
        json += "\"Fact 1\": ";
        json += "\"" + myFacts[0] + "\"";
        json += ", ";
        json += "\"Fact 2\": ";
        json += "\"" + myFacts[1] + "\"";
        json += ", ";
        json += "\"Fact 3\": ";
         json += "\"" + myFacts[2] + "\"";
         json += "}";
        return json;
    }
}
  
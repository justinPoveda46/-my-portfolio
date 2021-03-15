package com.google.sps.servlets;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = 6734233536872851287L;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String lanString = "es";
        // Get the value entered in the form.
        String textValue = request.getParameter("text-input");

         // Do the translation.
        Translate translate = TranslateOptions.getDefaultInstance().getService();
        Translation translation =
        translate.translate(textValue, Translate.TranslateOption.targetLanguage(lanString));
        String translatedText = translation.getTranslatedText();

        // Print the value so you can see it in the server logs.
        System.out.println("You submitted: " + textValue);
        System.out.println("Spanish Translation: " + translatedText);

        // Write the value to the response so the user can see it.
        response.getWriter().println("You submitted: " + textValue);
         response.getWriter().println("Spanish Translation: " + translatedText);

        // Redirects 
       // response.sendRedirect("http://jpoveda-sps-spring21.appspot.com/");
  }
}
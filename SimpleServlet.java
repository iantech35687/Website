package com.example;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class SimpleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirect to the form page for GET requests
        response.sendRedirect("index.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String text = request.getParameter("text");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String number = request.getParameter("number");
        String datetime = request.getParameter("datetime");
        String[] interests = request.getParameterValues("interests");
        String gender = request.getParameter("gender");

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Generate HTML response
        out.println("<html><body>");
        out.println("<h2>Processed User Input</h2>");
        out.println("<p><b>Text Input:</b> " + text + "</p>");
        out.println("<p><b>Name:</b> " + name + "</p>");
        out.println("<p><b>Email:</b> " + email + "</p>");
        out.println("<p><b>Age:</b> " + number + "</p>");
        out.println("<p><b>Date and Time:</b> " + datetime + "</p>");

        out.println("<p><b>Interests:</b> ");
        if (interests != null) {
            out.println(String.join(", ", interests));
        } else {
            out.println("None");
        }
        out.println("</p>");

        out.println("<p><b>Gender:</b> " + gender + "</p>");
        out.println("</body></html>");
    }
}


package com.example.backend4f;

import java.io.*;
import java.util.ArrayList;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "Voti", value = "/Voti")
public class Voti extends HttpServlet {
    private String messaggio;
    public void init() {
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String USERNAME = (String) session.getAttribute("username");
        String filePath = "voti.txt";
        String Username = USERNAME;
        int[] grades = getGradesByUsername(Username, filePath);
        if (grades.length > 0) {
            System.out.println("Grades for " + Username + ":");
            for (int grade : grades) {
                System.out.print(grade + " ");
            }
        } else {
            System.out.println("No grades found for " + Username);
        }
    }

    public static int[] getGradesByUsername(String Username, String filePath) {
        File file = new File(filePath);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(Username + " ")) {
                    return parseGrades(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        return new int[]{};
    }
    private static int[] parseGrades(String data) {

        int startIndex = data.indexOf('[') + 1;
        int endIndex = data.indexOf(']');
        if (startIndex < 0 || endIndex < 0) return new int[]{};

        String gradesString = data.substring(startIndex, endIndex).trim();
        if (gradesString.isEmpty()) return new int[]{};

        String[] gradesArray = gradesString.split(",\\s*");
        int[] grades = new int[gradesArray.length];
        for (int i = 0; i < gradesArray.length; i++) {
            try {
                grades[i] = Integer.parseInt(gradesArray[i]);
            } catch (NumberFormatException e) {
                System.out.println("Failed to parse grade: " + gradesArray[i]);
                return new int[]{};
            }
        }
        return grades;
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }
    public void destroy() {
    }
}
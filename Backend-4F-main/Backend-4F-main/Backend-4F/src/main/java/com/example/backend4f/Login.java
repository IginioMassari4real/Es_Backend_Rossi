package com.example.backend4f;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    private String message;
    public void init() {
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String username = request.getParameter("utente/username");
        String password = request.getParameter("password");

        private static final Map<String, String> credentials = new HashMap<>();

        public static void loadCredentials(String filePath) {
            File file = new File(filePath);

            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] parts = line.split(" ", 2);
                    if (parts.length == 2) {
                        credentials.put(parts[0], parts[1]);
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("File non trovato: " + filePath);
                e.printStackTrace();
            }
        }

        public static boolean authenticate(String username, String pass) {
            return credentials.getOrDefault(username, "").equals(pass);
        }

        public static void main(String[] args) {

            System.out.println(System.getProperty("username.dir"));
            loadCredentials("login.txt");

            // Test del metodo authenticate
            System.out.println(authenticate("alice.morgan", "strongP@ssw0rd!"));
            System.out.println(authenticate("bob.smith", "wrongpassword"));
            System.out.println(authenticate("nonexistentuser", "password"));
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/Errore");
    }
    public void destroy() {
    }
}
package com.app.MedicalHistory;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

public class SignUp {
    static class User{
        //Attributes
        public String UserType;
        public String email;
        public String password;

        //Constructor
        User(String UserType, String email, String password){
            this.UserType = UserType;
            this.email = email;
            this.password = password;
        }

        public String getUserType(){
            return UserType;
        }

        public String getEmail(){
            return email;
        }

        public String getPassword(){
            return password;
        }

        static List<User> usersList = new ArrayList<User>();
        public static void addUser(String UserType, String email, String password, Model model){
            usersList.add(new User(UserType, email, password));

            for(int i = 0; i <usersList.size(); i++){
                System.out.println("Type:");
                System.out.println(usersList.get(i).getUserType());
                System.out.println("Email:");
                System.out.println(usersList.get(i).getEmail());
                System.out.println("Pwd:");
                System.out.println(usersList.get(i).getPassword());
            }

            model.addAttribute("usersList", usersList);
        }

    }
}

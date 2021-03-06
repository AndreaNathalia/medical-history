package com.example.demo;
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
                System.out.println("\nType:");
                System.out.println(usersList.get(i).getUserType());
                System.out.println("\nEmail:");
                System.out.println(usersList.get(i).getEmail());
                System.out.println("\nPwd:");
                System.out.println(usersList.get(i).getPassword());
            }

            model.addAttribute("usersList", usersList);
        }

        public static List<User> getUsersList(){return usersList;}

    }
}

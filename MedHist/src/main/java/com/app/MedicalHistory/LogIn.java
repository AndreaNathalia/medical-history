package com.app.MedicalHistory;

import java.util.List;

public class LogIn {
    static List<SignUp.User> usersList = SignUp.User.getUsersList();
    public static boolean findUser(String email, String password){
        if(usersList.size() != 0) {
            for (int user = 0; user <= usersList.size(); user++) {
                if (usersList.get(user).getEmail() == email) {
                    if (usersList.get(user).getPassword() == password) {
                        return true;
                    }
                }
            }
        }
        else {
            return false;
        }
        return false;
    }

}

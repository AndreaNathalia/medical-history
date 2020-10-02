package com.app.MedicalHistory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Main {
    @RequestMapping(value = {"/"})
    @ResponseBody
    public static String info(){
        return "MEDICAL HISTORY";
    }

}

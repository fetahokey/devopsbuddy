package com.devopsbuddy.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* <h1>devopsbuddy!</h1>
* The devopsbuddy implements an application that
* simply displays "Hello World!" to the standard output.
* <p>
* Giving proper comments in your program makes it more
* user friendly and it is assumed as a high quality code.
* 
*
* @author  OULD KRADDA FATEH 
* @version 1.0.0
* @since   2018-10-10
*       TO 10/10/2018 2:46 PM 
*/
@Controller
public class PayloadController {
    public static final String PAYLOAD_VIEW_NAME="payload/payload";

    @RequestMapping("/payload")
    public String payload(){
        return PAYLOAD_VIEW_NAME;
    }
}

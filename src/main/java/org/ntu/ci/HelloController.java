package org.ntu.ci;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Udara on 20/7/17.
 */

@RestController
public class HelloController {

    @RequestMapping("/aaa")
    public String hello(){
        return "hello, how do you do.";
    }
}

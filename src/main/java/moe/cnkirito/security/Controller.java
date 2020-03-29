package moe.cnkirito.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class Controller {



    @GetMapping("/getoken")
    public String getToekn(){
        return "aa";
    }

}

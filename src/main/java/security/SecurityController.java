package security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SecurityController {
    @RequestMapping(value="/login",method = RequestMethod.GET)
    public String login() {

        return "login";
    }

    @RequestMapping(value="/")
    public String home() {

        return "redirect:/operations";
    }
}

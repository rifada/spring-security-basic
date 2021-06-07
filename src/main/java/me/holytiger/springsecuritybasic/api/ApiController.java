package me.holytiger.springsecuritybasic.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/sale")
    public String sale() {
        return "sale";
    }

    @GetMapping("/order")
    public String order() {
        return "order";
    }

    @GetMapping("/release")
    public String release() {
        return "release";
    }
}

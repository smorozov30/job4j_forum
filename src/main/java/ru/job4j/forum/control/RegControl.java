package ru.job4j.forum.control;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.Service;

@Controller
public class RegControl {

    private final PasswordEncoder encoder;

    public RegControl(PasswordEncoder encoder, Service service) {
        this.encoder = encoder;
    }

    @PostMapping("/reg")
    public String save(@ModelAttribute User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return "redirect:/login";
    }

    @GetMapping("/reg")
    public String reg() {
        return "reg";
    }
}

package mate.academy.spring.controller;

import javax.validation.Valid;
import mate.academy.spring.dto.DtoUtil;
import mate.academy.spring.dto.UserDto;
import mate.academy.spring.entity.User;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private DtoUtil dtoUtil;

    @GetMapping
    public String getRegisterPage() {
        return "register";
    }

    @PostMapping("/registration")
    public String createUser(@ModelAttribute @Valid UserDto userDto, Model model) {
        model.addAttribute("userDto", userDto);
        User user = dtoUtil.toEntity(userDto);
        userService.add(user);
        return "login";
    }
}

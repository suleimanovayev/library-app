package mate.academy.spring.controller;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import mate.academy.spring.dto.DtoUtil;
import mate.academy.spring.dto.UserDto;
import mate.academy.spring.entity.Role;
import mate.academy.spring.entity.User;
import mate.academy.spring.service.RoleService;
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
    private static final String ROLE_NAME = "ROLE_USER";

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Autowired
    private DtoUtil dtoUtil;

    @GetMapping
    public String getRegisterPage(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "register";
    }

    @PostMapping("/registration")
    public String createUser(@ModelAttribute @Valid UserDto userDto, Model model) {
        model.addAttribute("userDto", userDto);
        User user = dtoUtil.toEntity(userDto);
        Role role = roleService.getRoleByName(ROLE_NAME)
                .orElseThrow(() ->
                        new EntityNotFoundException("No role with name:" + ROLE_NAME));
        user.getRoles().add(role);
        userService.add(user);
        return "login";
    }
}

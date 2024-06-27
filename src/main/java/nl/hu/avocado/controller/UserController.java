package nl.hu.avocado.controller;


import nl.hu.avocado.controller.dto.UserDTO;
import nl.hu.avocado.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/user")
public class UserController{

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void addUser(@RequestBody UserDTO userDTO) {
        this.userService.addUser(userDTO);
    }


}

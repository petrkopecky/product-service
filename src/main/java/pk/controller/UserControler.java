package pk.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pk.modelDto.UserDto;
import pk.service.UserService;

import java.util.List;

@RestController
public class UserControler {
    private final UserService userService;

    public UserControler(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    List<UserDto> users() {
        return userService.getUserList();
    }

    @PostMapping("/users")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto newUserDto = userService.addUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUserDto);
    }

}

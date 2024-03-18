package uz.pdp.springbootstart.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootstart.dto.request.AuthDto;
import uz.pdp.springbootstart.dto.request.create.CardDto;
import uz.pdp.springbootstart.dto.request.create.UserCreateRequest;
import uz.pdp.springbootstart.dto.response.CardResponse;
import uz.pdp.springbootstart.dto.response.UserResponse;
import uz.pdp.springbootstart.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    @PostMapping("/sign-up")
    public UserResponse signUp(@Valid @RequestBody UserCreateRequest user) {
        return userService.create(user);
    }

    @PostMapping("/sign-in")
    public UserResponse signIn(@RequestBody AuthDto authDto) {
        return userService.signIn(authDto);
    }



}

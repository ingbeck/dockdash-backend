package com.ingbeck.dockdashbackend.appuser;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class AppUserController {
    private final AppUserService appUserService;

    @GetMapping("/me")
    public AppUser getLoggedInUser(){
        return appUserService.getLoggedInUser();
    }

    @PostMapping("/login")
    public void login(){
        //This method is only here to trigger the login process
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public AppUserResponse register(@RequestBody AppUserRegister appUserRegister){
        return appUserService.register(appUserRegister);
    }
}

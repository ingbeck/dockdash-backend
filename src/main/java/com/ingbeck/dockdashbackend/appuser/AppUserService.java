package com.ingbeck.dockdashbackend.appuser;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppUserService {

    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    public AppUser findByUsername(String username){
        return appUserRepository
            .findAppUserByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public AppUser getLoggedInUser(){
        var principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return findByUsername(principal.getUsername());
    }

    public AppUserResponse register(AppUserRegister appUserRegister){
        AppUser appUser = new AppUser();
        appUser.setUsername(appUserRegister.username());
        appUser.setPassword(passwordEncoder.encode(appUserRegister.password()));
        appUser = appUserRepository.save(appUser);
        return new AppUserResponse(appUser.getUsername());
    }

}

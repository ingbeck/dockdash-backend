package com.ingbeck.dockdashbackend.appuser;

public record AppUserRegister(
    String username, 
    String password,
    String firstName,
    String lastName
) {

}

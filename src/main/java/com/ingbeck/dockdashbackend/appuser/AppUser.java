package com.ingbeck.dockdashbackend.appuser;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "appusers")
public class AppUser {

    @MongoId
    private String id;
    private String username;
    private String password;

}

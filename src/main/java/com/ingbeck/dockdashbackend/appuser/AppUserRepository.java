package com.ingbeck.dockdashbackend.appuser;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface AppUserRepository extends MongoRepository<AppUser, String> {

    Optional<AppUser> findAppUserByUsername(String username);

}

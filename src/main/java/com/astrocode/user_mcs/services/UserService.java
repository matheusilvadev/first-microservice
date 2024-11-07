package com.astrocode.user_mcs.services;

import com.astrocode.user_mcs.models.UserModel;
import com.astrocode.user_mcs.producers.UserProducer;
import com.astrocode.user_mcs.repositories.UserRespository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    final UserRespository userRespository;
    final UserProducer userProducer;

    public UserService(UserRespository userRespository, UserProducer userProducer) {
        this.userRespository = userRespository;
        this.userProducer = userProducer;
    }

    @Transactional
    public UserModel save(UserModel userModel){
        userModel = userRespository.save(userModel);
        userProducer.publishMessage(userModel);

        return userModel;
    }

}

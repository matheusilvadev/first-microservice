package com.astrocode.user_mcs.repositories;

import com.astrocode.user_mcs.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRespository extends JpaRepository<UserModel, UUID> {
}

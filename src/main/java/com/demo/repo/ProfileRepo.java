package com.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.ProfileEntity;

@Repository
public interface ProfileRepo extends JpaRepository<ProfileEntity, Integer> {

}

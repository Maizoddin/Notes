package com.example.Learn.repository;

import com.example.Learn.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository  extends JpaRepository<Profile, Long> {
}

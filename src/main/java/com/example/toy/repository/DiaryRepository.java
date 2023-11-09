package com.example.toy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.toy.model.Diary;
import java.util.Optional;


public interface DiaryRepository extends JpaRepository<Diary, Long>{
    Optional<Diary> findById(long id);
}

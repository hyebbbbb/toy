package com.example.toy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.toy.model.Diary;

public interface DiaryRepository extends JpaRepository<Diary, Long>{
}

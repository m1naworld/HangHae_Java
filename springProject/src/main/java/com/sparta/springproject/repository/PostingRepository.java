package com.sparta.springproject.repository;


import org.springframework.data.jpa.repository.JpaRepository;

public interface PostingRepository<Posting> extends JpaRepository<com.sparta.springproject.entity.Posting, Long> {


}

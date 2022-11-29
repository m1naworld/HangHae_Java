package com.sparta.springproject.repository;

import com.sparta.springproject.entity.Posting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostingRepository extends JpaRepository<Posting, Long> {


}

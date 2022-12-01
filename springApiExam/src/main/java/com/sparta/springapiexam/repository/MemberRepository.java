package com.sparta.springapiexam.repository;

import com.sparta.springapiexam.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}

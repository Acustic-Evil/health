package com.travelAgency.Kursovaya.repository;

import com.travelAgency.Kursovaya.entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionsRepository extends JpaRepository<Questions,Long>{

}
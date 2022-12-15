package com.travelAgency.Kursovaya.repository;

import com.travelAgency.Kursovaya.entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionsRepository extends JpaRepository<Questions,Long>{
    default Boolean findQuestion(String question, String bodyPart, String illness) {
        return findFirstByTextAndBodyPartAndIllness(question, bodyPart, illness) !=null;
    }
    Questions findFirstByTextAndBodyPartAndIllness(String question, String bodyPart, String illness);

}
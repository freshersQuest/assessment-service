package com.fq.assessment_service.repository;

import com.fq.assessment_service.entity.QuizQuestionMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface QuizQuestionMappingRepository extends JpaRepository<QuizQuestionMapping, Long> {
    List<QuizQuestionMapping> findByQuizIdAndIsDeactivated(Long quizId, boolean b);
}

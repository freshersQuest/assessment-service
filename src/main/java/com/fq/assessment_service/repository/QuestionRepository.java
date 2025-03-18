package com.fq.assessment_service.repository;

import com.fq.assessment_service.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    @Query("SELECT q FROM Question q WHERE q.id IN :questionIds")
    List<Question> findByIds(@Param("questionIds") List<Long> questionIds);
}

package com.fq.assessment_service.service;

import com.fq.assessment_service.dto.QuizDTO;

import java.util.List;

public interface IQuizService {
    List<QuizDTO> getAllInternalQuiz();

    void addQuiz(QuizDTO quizDomainDTO);

    boolean updateQuiz(Long quizId,QuizDTO quizDomainDTO);

    boolean deleteQuiz(Long domainId);
}

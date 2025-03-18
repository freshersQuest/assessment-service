package com.fq.assessment_service.service;

import com.fq.assessment_service.dto.QuestionDTO;

import java.util.List;

public interface IQuestionService {
    List<QuestionDTO> getQuestionsByQuizId(Long domainId);

    void addQuestion(QuestionDTO questionDTO);

    boolean updateQuestion(Long questionId, QuestionDTO quizDomainDTO);

    boolean deleteQuestion(Long questionId);
}

package com.fq.assessment_service.service;

import com.fq.assessment_service.dto.QuestionDTO;
import com.fq.assessment_service.dto.QuestionRequestDTO;

import java.util.List;

public interface IQuestionService {
    List<QuestionDTO> getQuestionsByQuizId(Long domainId);

    void addQuestion(QuestionRequestDTO questionRequestDTO);

    boolean updateQuestion(Long questionId, QuestionRequestDTO questionRequestDTO);

    boolean deleteQuestion(Long questionId);
}

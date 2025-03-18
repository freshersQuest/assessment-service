package com.fq.assessment_service.service.impl;

import com.fq.assessment_service.dto.QuestionDTO;
import com.fq.assessment_service.entity.Question;
import com.fq.assessment_service.entity.QuizQuestionMapping;
import com.fq.assessment_service.repository.QuestionRepository;
import com.fq.assessment_service.repository.QuizQuestionMappingRepository;
import com.fq.assessment_service.service.IQuestionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("IQuestionService")
public class QuestionService implements IQuestionService {

    @Autowired
    private QuizQuestionMappingRepository quizQuestionMappingRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<QuestionDTO> getQuestionsByQuizId(Long quizId) {
        List<QuizQuestionMapping> quizQuestionMapping = quizQuestionMappingRepository.findByQuizIdAndIsDeactivated(quizId, false);
        List<Long> questionsIds = quizQuestionMapping.stream()
                .map(domain -> domain.getQuestion().getId())
                .collect(Collectors.toList());
        List<Question> questions = questionRepository.findByIds(questionsIds);
        return questions.stream()
                .map(question -> modelMapper.map(question, QuestionDTO.class))
                .collect(Collectors.toList());

    }

    @Override
    public void addQuestion(QuestionDTO questionDTO) {

    }

    @Override
    public boolean updateQuestion(Long questionId,QuestionDTO quizDomainDTO) {
        return null;
    }

    @Override
    public boolean deleteQuestion(Long domainId) {
        return null;
    }
}

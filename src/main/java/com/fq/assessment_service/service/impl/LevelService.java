package com.fq.assessment_service.service.impl;

import com.fq.assessment_service.constants.AssessmentConstants;
import com.fq.assessment_service.dto.LevelRequestDTO;
import com.fq.assessment_service.dto.QuestionDTO;
import com.fq.assessment_service.entity.Level;
import com.fq.assessment_service.repository.LevelRepository;
import com.fq.assessment_service.service.ILevelService;
import com.fq.common.dto.ResponseDTO;
import com.fq.common.exceptions.FQBadRequestException;
import com.fq.common.exceptions.FQResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service("ILevelService")
public class LevelService implements ILevelService {
    @Autowired
    private LevelRepository levelRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void addLevel(LevelRequestDTO levelRequestDTO) {
        Boolean levelExists = levelRepository.existsByScoreAndIsDeactivated(levelRequestDTO.getScore(), false);
        if(levelExists){
            throw new FQBadRequestException("level already exists");
        }
        Level newLevel = new Level();
        newLevel = modelMapper.map(levelRequestDTO, Level.class);
        levelRepository.save(newLevel);
    }

    @Override
    public boolean updateLevel(Long levelId, LevelRequestDTO levelRequestDTO) {
        boolean isUpdated = false;
        Level existingLevel = levelRepository.findByScoreAndIsDeactivated(levelRequestDTO.getScore(), false).orElseThrow(
                () -> new FQResourceNotFoundException("Level", "Score", levelRequestDTO.getScore().toString()));
        if(existingLevel!=null){
            existingLevel = modelMapper.map(levelRequestDTO, Level.class);
            levelRepository.save(existingLevel);
            isUpdated = true;
        }
        return isUpdated;
    }

    @Override
    public boolean deleteLevel(Long levelId) {
        boolean isDeleted = false;
        Level existingLevel = levelRepository.findByIdAndIsDeactivated(levelId, false).orElseThrow(
                () -> new FQResourceNotFoundException("Level", "Id",levelId.toString()));
        if(existingLevel!=null){
            existingLevel.setIsDeactivated(true);
            existingLevel.setDeactivatedAt(LocalDateTime.now());
            levelRepository.save(existingLevel);
            isDeleted = true;
        }
        return isDeleted;
    }
}

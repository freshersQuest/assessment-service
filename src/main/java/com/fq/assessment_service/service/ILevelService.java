package com.fq.assessment_service.service;

import com.fq.assessment_service.dto.LevelRequestDTO;
import com.fq.assessment_service.dto.QuestionDTO;
import com.fq.common.dto.ResponseDTO;

public interface ILevelService {
    void addLevel(LevelRequestDTO levelRequestDTO);

    boolean updateLevel(Long levelId, LevelRequestDTO levelRequestDTO);

    boolean deleteLevel(Long levelId);
}

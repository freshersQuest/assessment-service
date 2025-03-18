package com.fq.assessment_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuizDTO {
    private Long id;
    private String name;
    private String icon;
    private String color;
    private Time timer;
    private Boolean isExternalHost;
}

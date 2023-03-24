package com.courseware.courseware.manage.param;

import com.courseware.courseware.manage.entity.CourseEntity;
import com.courseware.courseware.manage.entity.WorksEntity;
import lombok.Data;

@Data
public class WorksParam extends WorksEntity {

    private Integer page;

    private Integer size;

    private Integer studentId;

    private String title;

    private String content;


}

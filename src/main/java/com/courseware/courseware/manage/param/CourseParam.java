package com.courseware.courseware.manage.param;

import com.courseware.courseware.manage.entity.CourseEntity;
import com.courseware.courseware.manage.entity.UserInfoEntity;
import lombok.Data;

@Data
public class CourseParam extends CourseEntity {

    private Integer page;

    private Integer size;

    private Integer userId;

}

package com.courseware.courseware.manage.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.courseware.courseware.manage.entity.CourseEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface CourseDao extends BaseMapper<CourseEntity> {
    List<CourseEntity> selectCourseList(Integer userId);
}
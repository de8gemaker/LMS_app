package com.courseware.courseware.manage.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.courseware.courseware.manage.entity.CourseEntity;
import com.courseware.courseware.manage.entity.WorksEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface WorksDao extends BaseMapper<WorksEntity> {
}
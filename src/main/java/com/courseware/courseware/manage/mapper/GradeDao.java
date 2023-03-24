package com.courseware.courseware.manage.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.courseware.courseware.manage.entity.GradeEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface GradeDao extends BaseMapper<GradeEntity> {
}
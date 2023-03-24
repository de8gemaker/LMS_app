package com.courseware.courseware.manage.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.courseware.courseware.manage.entity.RankVo;
import com.courseware.courseware.manage.entity.StudyRecordEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface StudyRecordDao extends BaseMapper<StudyRecordEntity> {

    List<RankVo> getRank(Long id);
}
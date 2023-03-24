package com.courseware.courseware.manage.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.courseware.courseware.manage.entity.UserInfoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserInfoDao extends BaseMapper<UserInfoEntity> {
    List<UserInfoEntity> selectStuList(Integer gradeId);
}
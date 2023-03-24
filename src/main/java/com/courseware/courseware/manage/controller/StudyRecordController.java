package com.courseware.courseware.manage.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.courseware.courseware.manage.base.Result;
import com.courseware.courseware.manage.entity.CourseEntity;
import com.courseware.courseware.manage.entity.StudyRecordEntity;
import com.courseware.courseware.manage.mapper.CourseDao;
import com.courseware.courseware.manage.mapper.StudyRecordDao;
import com.courseware.courseware.manage.param.CourseParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author ltf
 */
@Slf4j
@RestController
public class StudyRecordController {

    @Autowired
    private StudyRecordDao studyRecordDao;

    @Autowired
    private CourseDao courseDao;

    /**
     * 学生自学的list
     */
    @GetMapping("/studyRecord/list")
    public Result<CourseEntity> list(@ModelAttribute CourseParam param){
        Result result = new Result();
        result.setCode(200);
        try {
            List<CourseEntity> list = courseDao.selectCourseList(param.getUserId());
            result.setList(list);
        }catch (Exception e){
            log.error("列表查询失败:",e);
            result.setCode(500);
            result.setMessage("列表查询失败");
        }
        return result;
    }

    /**
     * 学生选择课程进行添加到自己学习的课程列表
     * @param dto
     * @return
     */
    @PostMapping("/studyRecord/add")
    public Result<Void> add(@ModelAttribute StudyRecordEntity dto){
        Result result = new Result();
        result.setCode(200);
        try{
            QueryWrapper<StudyRecordEntity> wrapper = new QueryWrapper<>();
            wrapper.eq("user_id",dto.getUserId()).eq("course_id",dto.getCourseId());
            StudyRecordEntity entity = studyRecordDao.selectOne(wrapper);
            if(Objects.nonNull(entity)){
                studyRecordDao.updateById(entity);
            }else {
                studyRecordDao.insert(dto);
            }
        }catch (Exception e){
            log.error("添加失败:",e);
            result.setCode(500);
            result.setMessage("添加失败");
        }
        return result;
    }
}

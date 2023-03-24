package com.courseware.courseware.manage.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.courseware.courseware.manage.base.Result;
import com.courseware.courseware.manage.entity.CourseEntity;
import com.courseware.courseware.manage.entity.GradeEntity;
import com.courseware.courseware.manage.entity.UserInfoEntity;
import com.courseware.courseware.manage.entity.WorksEntity;
import com.courseware.courseware.manage.mapper.GradeDao;
import com.courseware.courseware.manage.mapper.UserInfoDao;
import com.courseware.courseware.manage.mapper.WorksDao;
import com.courseware.courseware.manage.param.UserInfoParam;
import com.courseware.courseware.manage.param.WorksParam;
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
public class WorksController {

    @Autowired
    private WorksDao worksDao;

    /**
     * 作品列表
     * @param dto
     * @return
     */
    @GetMapping("/works/list")
    public Result<WorksEntity> list(@ModelAttribute WorksEntity dto){
        Result result = new Result();
        result.setCode(200);
        try {
            QueryWrapper<WorksEntity> wrapper = new QueryWrapper<>();
            wrapper.setEntity(dto);
            wrapper.eq("student_id",dto.getStudentId());
            List<WorksEntity> list = worksDao.selectList(wrapper);
            result.setList(list);
        }catch (Exception e){
            log.error("列表查询失败:",e);
            result.setCode(500);
            result.setMessage("列表查询失败");
        }
        return result;
    }


    /**
     * 上传作品
     */
    @PostMapping("/works/upload")
    public Result<Void> updateP(@ModelAttribute WorksParam param){
        Result result = new Result();
        result.setCode(200);
        try{
            WorksEntity worksEntity = new WorksEntity();
            worksEntity.setContent(param.getContent());
            worksEntity.setTitle(param.getTitle());
            worksEntity.setStudentId(param.getStudentId());
            worksEntity.setCreateTime(new Date());
            worksDao.insert(worksEntity);
        }catch (Exception e){
            log.error("修改失败:",e);
            result.setCode(500);
            result.setMessage("修改失败");
        }
        return result;
    }
}

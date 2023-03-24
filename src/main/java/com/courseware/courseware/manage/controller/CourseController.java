package com.courseware.courseware.manage.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.courseware.courseware.manage.base.Result;
import com.courseware.courseware.manage.entity.CourseEntity;
import com.courseware.courseware.manage.entity.RankVo;
import com.courseware.courseware.manage.mapper.CourseDao;
import com.courseware.courseware.manage.mapper.StudyRecordDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author ltf
 */
@Slf4j
@RestController
public class CourseController {

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private StudyRecordDao studyRecordDao;

    /**
     * 管理员进去显示的课程全部列表
     * @param dto
     * @return
     */
    @GetMapping("/course/list")
    public Result<CourseEntity> list(@ModelAttribute CourseEntity dto){
        Result result = new Result();
        result.setCode(200);
        try {
            QueryWrapper<CourseEntity> wrapper = new QueryWrapper<>();
            wrapper.setEntity(dto);
            List<CourseEntity> list = courseDao.selectList(wrapper);
            result.setList(list);
        }catch (Exception e){
            log.error("列表查询失败:",e);
            result.setCode(500);
            result.setMessage("列表查询失败");
        }
        return result;
    }

    /**
     * 教师进去显示该教师所申请的课
     */
    @GetMapping("/course/teacherList")
    public Result<CourseEntity> teacherList(@ModelAttribute CourseEntity dto) {
        Result result = new Result();
        result.setCode(200);
        try{
            QueryWrapper<CourseEntity> wrapper = new QueryWrapper<>();
            wrapper.setEntity(dto);
//            wrapper.eq("userId",dto.getUserId());
            List<CourseEntity> list = courseDao.selectList(wrapper);
            result.setList(list);
        } catch (Exception e) {
            log.error("列表查询失败:",e);
            result.setCode(500);
            result.setMessage("列表查询失败");
        }
        return result;
    }

    /**
     * 学生登进去显示的开了课程的列表
     * @param dto
     * @return
     */
    @GetMapping("/course/openList")
    public Result<CourseEntity> openList(@ModelAttribute CourseEntity dto){
        Result result = new Result();
        result.setCode(200);
        try {
            QueryWrapper<CourseEntity> wrapper = new QueryWrapper<>();
            wrapper.setEntity(dto);
            wrapper.eq("bz",1);
            List<CourseEntity> list = courseDao.selectList(wrapper);
            result.setList(list);
        }catch (Exception e){
            log.error("列表查询失败:",e);
            result.setCode(500);
            result.setMessage("列表查询失败");
        }
        return result;
    }

    /**
     * 老师登进去显示的未开课程的列表
     * @param dto
     * @return
     */
    @GetMapping("/course/closeList")
    public Result<CourseEntity> closeList(@ModelAttribute CourseEntity dto){
        Result result = new Result();
        result.setCode(200);
        try {
            QueryWrapper<CourseEntity> wrapper = new QueryWrapper<>();
            wrapper.setEntity(dto);
            wrapper.eq("bz",0);
            List<CourseEntity> list = courseDao.selectList(wrapper);
            result.setList(list);
        }catch (Exception e){
            log.error("列表查询失败:",e);
            result.setCode(500);
            result.setMessage("列表查询失败");
        }
        return result;
    }
    /**
     * 老师设置课程的开关
     */
    @PostMapping("/course/updateBz")
    public Result<Void> updateBz(@ModelAttribute CourseEntity dto){
        Result result = new Result();
        result.setCode(200);
        try{
            CourseEntity courseEntity = courseDao.selectById(dto.getId());
            courseEntity.setBz(dto.getBz());
            courseDao.updateById(courseEntity);
        }catch (Exception e){
            log.error("更新课程标志失败:",e);
            result.setCode(500);
            result.setMessage("更新课程标志失败");
        }
        return result;
    }
    /**
     * 学生根据课程类别查询课程
     * @param key
     * @return
     */
    @GetMapping("/course/key")
    public Result<CourseEntity> list(String key){
        Result result = new Result();
        result.setCode(200);
        try {
            QueryWrapper<CourseEntity> wrapper = new QueryWrapper<>();
            wrapper.eq("course_type",key);
            List<CourseEntity> list = courseDao.selectList(wrapper);
            result.setList(list);
        }catch (Exception e){
            log.error("CourseController-list-error: ",e);
            result.setCode(500);
            result.setMessage("查询失败");
        }
        return result;
    }

    /**
     * 管理员添加课程
     * @param dto
     * @return
     */
    @PostMapping("/course/add")
    public Result<Void> add(@ModelAttribute CourseEntity dto){
        Result result = new Result();
        result.setCode(200);
        try{
            dto.setCreateTime(new Date());
            courseDao.insert(dto);
        }catch (Exception e){
            log.error("添加失败:",e);
            result.setCode(500);
            result.setMessage("添加失败");
        }
        return result;
    }

    @GetMapping("/course/ranking")
    public Result<RankVo> ranking(Long id){
        Result result = new Result();
        result.setCode(200);
        try {
            List<RankVo> rankVos = studyRecordDao.getRank(id);
            result.setList(rankVos);
        }catch (Exception e){
            log.error("排名查询失败:",e);
            result.setCode(500);
            result.setMessage("排名查询失败");
        }
        return result;
    }

    /**
     * 管理员删除课程
     * @return
     */
    @PostMapping("/course/delete")
    public Result<Void> delete(Integer id){
        Result result = new Result();
        result.setCode(200);
        try{
            courseDao.deleteById(id);
        }catch (Exception e){
            log.error("删除失败:",e);
            result.setCode(500);
            result.setMessage("删除失败");
        }
        return result;
    }
}

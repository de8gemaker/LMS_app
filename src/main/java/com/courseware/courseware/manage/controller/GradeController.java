package com.courseware.courseware.manage.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.courseware.courseware.manage.base.Result;
import com.courseware.courseware.manage.entity.CourseEntity;
import com.courseware.courseware.manage.entity.GradeEntity;
import com.courseware.courseware.manage.entity.RankVo;
import com.courseware.courseware.manage.mapper.CourseDao;
import com.courseware.courseware.manage.mapper.GradeDao;
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
 * @author
 */
@Slf4j
@RestController
public class GradeController {

    @Autowired
    private GradeDao gradeDao;


    /**
     * 管理员进去显示的班级全部列表
     * @param dto
     * @return
     */
    @GetMapping("/grade/list")
    public Result<GradeEntity> list(@ModelAttribute GradeEntity dto){
        Result result = new Result();
        result.setCode(200);
        try {
            QueryWrapper<GradeEntity> wrapper = new QueryWrapper<>();
            wrapper.setEntity(dto);
            List<GradeEntity> list = gradeDao.selectList(wrapper);
            result.setList(list);
        }catch (Exception e){
            log.error("列表查询失败:",e);
            result.setCode(500);
            result.setMessage("列表查询失败");
        }
        return result;
    }

    /**
     * 管理员添加班级
     * @param dto
     * @return
     */
    @PostMapping("/grade/add")
    public Result<Void> add(@ModelAttribute GradeEntity dto){
        Result result = new Result();
        result.setCode(200);
        try{
            dto.setCreateTime(new Date());
            gradeDao.insert(dto);
        }catch (Exception e){
            log.error("添加失败:",e);
            result.setCode(500);
            result.setMessage("添加失败");
        }
        return result;
    }


    /**
     * 管理员删除班级
     * @return
     */
    @PostMapping("/grade/delete")
    public Result<Void> delete(Integer id){
        Result result = new Result();
        result.setCode(200);
        try{
            gradeDao.deleteById(id);
        }catch (Exception e){
            log.error("删除失败:",e);
            result.setCode(500);
            result.setMessage("删除失败");
        }
        return result;
    }
}

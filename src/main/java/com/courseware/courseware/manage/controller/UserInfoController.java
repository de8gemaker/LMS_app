package com.courseware.courseware.manage.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.courseware.courseware.manage.base.Result;
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

import java.util.*;

/**
 * @author ltf
 */
@Slf4j
@RestController
public class UserInfoController {

    @Autowired
    private UserInfoDao userDao;

    @Autowired
    private GradeDao gradeDao;

    @PostMapping("/user/login")
    public Result<UserInfoEntity> login(@ModelAttribute UserInfoEntity dto){
        Result result = new Result();
        result.setCode(200);
        try {
            QueryWrapper<UserInfoEntity> wrapper = new QueryWrapper<>();
            wrapper.setEntity(dto);
            UserInfoEntity userEntity = userDao.selectOne(wrapper);
            if(Objects.isNull(userEntity)){
                result.setCode(400);
                result.setMessage("用户名或密码错误");
            }else {
                result.setEntity(userDao.selectOne(wrapper));
            }
        }catch (Exception e){
            log.error("登录失败:",e);
            result.setCode(500);
            result.setMessage("登录失败");
        }
        return result;
    }

    @PostMapping("/user/register")
    public Result<Void> register(@ModelAttribute UserInfoEntity dto){
        Result result = new Result();
        result.setCode(200);
        try{
            QueryWrapper<UserInfoEntity> wrapper = new QueryWrapper<>();
            wrapper.eq("mobile",dto.getMobile());
            UserInfoEntity userEntity = userDao.selectOne(wrapper);
            if(Objects.nonNull(userEntity)){
                result.setCode(400);
                result.setMessage("此手机号已注册");
            }else{
                userDao.insert(dto);
            }
        }catch (Exception e){
            log.error("注册失败:",e);
            result.setCode(500);
            result.setMessage("注册失败");
        }
        return result;
    }

    @GetMapping("/user/list")
    public Result<UserInfoEntity> list(@ModelAttribute UserInfoEntity dto){
        Result result = new Result();
        result.setCode(200);
        try {
            QueryWrapper<UserInfoEntity> wrapper = new QueryWrapper<>();
            wrapper.setEntity(dto);
            result.setList(userDao.selectList(wrapper));
        }catch (Exception e){
            log.error("查询用户列表失败:",e);
            result.setCode(500);
            result.setMessage("查询用户列表失败");
        }
        return result;
    }

    /**
     * 学生列表
     */
    @GetMapping("/user/stuList")
    public Result<UserInfoEntity> stuList(int gradeId){
        Result result = new Result();
        result.setCode(200);
        try {
            List<UserInfoEntity> list = userDao.selectStuList(gradeId);
            result.setList(list);
        }catch (Exception e){
            log.error("查询学生用户列表失败:",e);
            result.setCode(500);
            result.setMessage("查询学生用户列表失败");
        }
        return result;
    }

    /**
     * 管理员添加用户
     * @param param
     * @return
     */
    @PostMapping("/user/insert")
    public Result<Void> insert(@ModelAttribute UserInfoParam param){
        Result result = new Result();
        result.setCode(200);
        Random random=new Random();
        //参数10000是指0-9999的数
        int id=random.nextInt(10000);
        try{
            UserInfoEntity userEntity = new UserInfoEntity();
            userEntity.setId(id);
            userEntity.setMobile(param.getMobile());
            userEntity.setUserName(param.getUserName());
            userEntity.setType(param.getType());
            userEntity.setCreateTime(new Date());
            userEntity.setPassword(param.getPassword());
            //往学生信息添加班级的id
            if("2".equals(param.getType())) {
                userEntity.setGradeId(param.getGradeId());
            }
            userDao.insert(userEntity);
        }catch (Exception e){
            log.error("插入失败:",e);
            result.setCode(500);
            result.setMessage("插入失败");
        }
        return result;
    }

    /**
     * 管理员修改用户
     * @param param
     * @return
     */
    @PostMapping("/user/update")
    public Result<Void> update(@ModelAttribute UserInfoParam param){
        Result result = new Result();
        result.setCode(200);
        try{
            UserInfoEntity userEntity = userDao.selectById(param.getUserId());
            userEntity.setMobile(param.getMobile());
            userEntity.setUserName(param.getUserName());
            userEntity.setType(param.getType());
            userEntity.setCreateTime(new Date());
            userEntity.setPassword(param.getPassword());
            //往班级列表中添加学生id
            if("2".equals(param.getType())) {
                userEntity.setGradeId(param.getGradeId());
            }
            userDao.updateById(userEntity);
        }catch (Exception e){
            log.error("修改失败:",e);
            result.setCode(500);
            result.setMessage("修改失败");
        }
        return result;
    }

    /**
     * 管理员删除用户
     * @param param
     * @return
     */
    @PostMapping("/user/delete")
    public Result<Void> delete(@ModelAttribute UserInfoParam param){
        Result result = new Result();
        result.setCode(200);
        try{
            UserInfoEntity userEntity = userDao.selectById(param.getUserId());
            userDao.deleteById(userEntity);
        }catch (Exception e){
            log.error("删除失败:",e);
            result.setCode(500);
            result.setMessage("删除失败");
        }
        return result;
    }

}

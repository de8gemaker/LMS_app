package com.courseware.courseware.manage.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * @author
 */
@Data
@TableName(value = "course")
public class CourseEntity implements Serializable{

    /**
    * id
    */
    @TableId(type = IdType.AUTO)
    private Integer id;
    
    /**
    * 课程名称
    */
    @TableField
    private String courseName;
    
    /**
    * 课程简介
    */
    @TableField
    private String content;
    
    /**
     * 创建时间
     */
    @TableField
    private Date createTime;

    @TableField
    private String courseType;

    @TableField
    private String bz;

    @TableField
    private String url;

    @TableField
    private Integer userId;
}
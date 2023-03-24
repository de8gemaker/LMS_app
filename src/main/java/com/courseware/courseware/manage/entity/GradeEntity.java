package com.courseware.courseware.manage.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * @author ltf
 */
@Data
@TableName(value = "grade")
public class GradeEntity implements Serializable{

    /**
    * id
    */
    @TableId(type = IdType.AUTO)
    private Integer id;
    
    /**
    * 班级名称
    */
    @TableField
    private String name;


    /**
     * 创建时间
     */
    @TableField
    private Date createTime;

}
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
@TableName(value = "study_record")
public class StudyRecordEntity implements Serializable{

    /**
    * id
    */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 学生id
     */
    @TableField
    private Long userId;

    /**
     * 课程id
     */
    @TableField
    private Long courseId;

    /**
     * 创建时间
     */
    @TableField
    private Date createTime;

}
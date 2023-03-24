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
@TableName(value = "works")
public class WorksEntity implements Serializable{

    /**
    * id
    */
    @TableId(type = IdType.AUTO)
    private Integer id;
    
    /**
    * 作品名称
    */
    @TableField
    private String title;
    
    /**
    * 作品内容
    */
    @TableField
    private String content;
    
    /**
     * 创建时间
     */
    @TableField
    private Date createTime;

    @TableField
    private Integer studentId;

}
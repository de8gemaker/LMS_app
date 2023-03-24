package com.courseware.courseware.manage.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * @author ltf
 */
@Data
@TableName(value = "template_info")
public class TemplateInfoEntity implements Serializable{

    /**
    * id
    */
    @TableId(type = IdType.AUTO)
    private Long id;
    
    /**
    * 标题
    */
    private String title;
    
    /**
    * 内容
    */
    private String content;
    
    /**
    * url
    */
    private String url;

    /**
     * 创建时间
     */
    private Date createTime;
}
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
@TableName(value = "user_info")
public class UserInfoEntity implements Serializable{

    /**
    * id
    */
    @TableId(type = IdType.INPUT)
    private Integer id;
    
    /**
    * 用户名称
    */
    private String userName;
    
    /**
    * 用户密码
    */
    private String password;
    
    /**
    * 手机号
    */
    private String mobile;


    private String type;

    /**
     * 创建时间
     */
    private Date createTime;

    private Integer gradeId;
}
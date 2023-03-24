package com.courseware.courseware.manage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "announcement")
public class AnnouncementEntity {

    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 公告标题
     */
    @TableField
    private String title;

    /**
     * 公告内容
     */
    @TableField
    private String content;

    /**
     * 是否置顶
     */
    @TableField
    private Integer top;

    /**
     * 公告创建人
     */
    @TableField
    private String person;

    @TableField
    private Date foundtime;
}

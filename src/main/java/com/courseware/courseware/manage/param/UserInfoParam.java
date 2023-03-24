package com.courseware.courseware.manage.param;

import com.courseware.courseware.manage.entity.UserInfoEntity;
import lombok.Data;

@Data
public class UserInfoParam extends UserInfoEntity {

    private Integer page;

    private Integer size;

    private Integer userId;

    private String userName;

    private String password;

    private String mobile;

    private String type;

    private Integer gradeId;
}

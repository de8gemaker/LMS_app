package com.courseware.courseware.manage.param;

import com.courseware.courseware.manage.entity.TemplateInfoEntity;
import lombok.Data;

/**
 * @author ltf
 */
@Data
public class TemplateInfoParam extends TemplateInfoEntity {
    private Integer page;
    private Integer size;
}

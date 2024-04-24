package com.backend.modules.entity.mysql.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;
@Data
public class MiddleBoxVo {
    private static final long serialVersionUID = 1L;
    @TableId
    private Integer middleBoxId;
    private String middleBoxTitle;
    private String middleBoxContent;
    private Date createTime;
}

package com.backend.modules.entity.mysql.ForumDiscoverEntity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**4
 * ClassName:middle_box
 * Package:com.backend.modules.entity.mysql.ForumDiscoverEntity
 * Descriptionn:
 *
 * @Author wqh
 * @Create 2024/4/22 23:50
 * @Version 1.0
 */
@Data
@TableName("middle_box")
public class Middle_boxEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId
    private Integer middle_boxId;
    /**
     *
     */

    private String middle_boxTitle;
    /**
     *
     */
    private String middle_boxContent;
    /**
     *
     */
    private Integer isDeleted;
    /**
     *
     */
    private Date createTime;
    /**
     *
     */
    private Date updateTime;
    /**
     *
     */
    private String src;

}

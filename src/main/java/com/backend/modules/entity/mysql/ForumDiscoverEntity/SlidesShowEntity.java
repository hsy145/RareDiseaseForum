package com.backend.modules.entity.mysql.ForumDiscoverEntity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**1
 * ClassName:rotograph
 * Package:com.backend.modules.entity.mysql.ForumDiscoverEntity
 * Descriptionn:
 *
 * @Author wqh
 * @Create 2024/4/22 23:44
 * @Version 1.0
 */
@Data
@TableName("slidesshow")
public class SlidesShowEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId
    private Integer slidesShowId;

    /**
     *
     */
    private String slidesShowTitle;
    /**
     *
     */
    private String slidesShowContent;
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

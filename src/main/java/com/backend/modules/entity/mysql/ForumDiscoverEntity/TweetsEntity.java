package com.backend.modules.entity.mysql.ForumDiscoverEntity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**3
 * ClassName:tweets
 * Package:com.backend.modules.entity.mysql.ForumDiscoverEntity
 * Descriptionn:
 *
 * @Author wqh
 * @Create 2024/4/22 23:49
 * @Version 1.0
 */
@Data
@TableName("tweets")
public class TweetsEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId
    private Integer tweetsId;
    /**
     *
     */

    private String tweetsTitle;
    /**
     *
     */
    private String tweetsContent;
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

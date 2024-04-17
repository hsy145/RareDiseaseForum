package com.backend.modules.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.backend.modules.entity.mysql.ForumDiscoverEntity;
import com.backend.modules.service.ForumDiscoverService;
import com.backend.common.utils.PageUtils;
import com.backend.common.utils.R;



/**
 * 
 *
 * @author hsy
 * @email 760356917@qq.com
 * @date 2024-04-08 21:35:17
 */
@RestController
@RequestMapping("/forumdiscover")
public class ForumDiscoverController {
    @Autowired
    private ForumDiscoverService forumDiscoverService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = forumDiscoverService.queryPage(params);

        return R.ok().put("page", page);
    }


    // 获取推文列表
    @GetMapping("/tweets")
    public R getTweets() {
        try {
            List<ForumDiscoverEntity> data = forumDiscoverService.getTweets();
            return R.ok().put("data", data);
        } catch (Exception e) {
            return R.error(e.getMessage());
        }
    }

    // 获取推荐列表，包括内容的部分显示和创建时间
    @GetMapping("/recommendations")
    public R getRecommendations() {
        try {
            List<ForumDiscoverEntity> data = forumDiscoverService.getRecommendations();
            return R.ok().put("data", data);
        } catch (Exception e) {
            return R.error(e.getMessage());
        }
    }

    // 获取中间框内容
    @GetMapping("/middle-box")
    public R getMiddleBoxContents() {
        try {
            List<ForumDiscoverEntity> data = forumDiscoverService.getMiddleBoxContents();
            return R.ok().put("data", data);
        } catch (Exception e) {
            return R.error(e.getMessage());
        }
    }

    // 根据ID获取完整内容，可用于用户点击推荐模块后查看完整文章
    @GetMapping("/content/{id}")
    public R getFullContentById(@PathVariable Integer id) {
        try {
            ForumDiscoverEntity content = forumDiscoverService.getFullContentById(id);
            if (content != null) {
                return R.ok().put("data", content);
            } else {
                return R.error(404, "Content not found"); // 如果没有找到内容，返回404错误
            }
        } catch (Exception e) {
            return R.error(e.getMessage());
        }
    }

}

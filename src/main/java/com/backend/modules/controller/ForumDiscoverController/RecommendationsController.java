package com.backend.modules.controller.ForumDiscoverController;

import com.backend.common.utils.R;
import com.backend.modules.entity.mysql.ForumDiscoverEntity.RecommendationsEntity;

import com.backend.modules.service.ForumDiscoverService.RecommendationsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName:RecommendationsController
 * Package:com.backend.modules.controller.ForumDiscoverController
 * Descriptionn:
 *
 * @Author wqh
 * @Create 2024/4/22 23:59
 * @Version 1.0
 */

@RestController
@RequestMapping("/forumdiscover/")
public class RecommendationsController {

    @Autowired
    private RecommendationsService recommendationsrService;

    // 2获取推荐列表，包括内容的部分显示和创建时间
    @GetMapping("/recommendations")
    public R getRecommendations() {
        try {
            List<RecommendationsEntity> data = recommendationsrService.getRecommendations();
            return R.ok().put("data", data);
        } catch (Exception e) {
            return R.error(e.getMessage());
        }
    }

    // 2根据ID获取完整内容，可用于用户点击推荐模块后查看完整文章
    @GetMapping("/recommendations/{id}")
    public R getFullContentById(@PathVariable Integer id) {
        try {
            RecommendationsEntity content = recommendationsrService.getFullContentById(id);
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
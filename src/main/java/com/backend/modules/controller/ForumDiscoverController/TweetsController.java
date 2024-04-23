package com.backend.modules.controller.ForumDiscoverController;

import com.backend.common.utils.R;
import com.backend.modules.entity.mysql.ForumDiscoverEntity.TweetsEntity;

import com.backend.modules.service.ForumDiscoverService.TweetsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName:TweetsController
 * Package:com.backend.modules.controller.ForumDiscoverController
 * Descriptionn:
 *
 * @Author wqh
 * @Create 2024/4/23 0:00
 * @Version 1.0
 */

@RestController
@RequestMapping("/forumdiscover")
public class TweetsController {

    @Autowired
    private TweetsService tweetsService;

    // 3获取推文列表
    @GetMapping("/tweets")
    public R getTweets() {
        try {
            List<TweetsEntity> data = tweetsService.getTweets();
            return R.ok().put("data", data);
        } catch (Exception e) {
            return R.error(e.getMessage());
        }
    }
}
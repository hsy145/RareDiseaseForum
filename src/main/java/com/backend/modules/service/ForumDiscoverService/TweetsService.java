package com.backend.modules.service.ForumDiscoverService;

import com.backend.modules.entity.mysql.ForumDiscoverEntity.TweetsEntity;

import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * ClassName:TweetsService
 * Package:com.backend.modules.service.ForumDiscoverService
 * Descriptionn:
 *
 * @Author wqh
 * @Create 2024/4/23 0:06
 * @Version 1.0
 */
public interface TweetsService  extends IService<TweetsEntity> {

    List<TweetsEntity> getTweets();
}

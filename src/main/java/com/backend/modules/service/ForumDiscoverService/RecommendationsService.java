package com.backend.modules.service.ForumDiscoverService;

import com.backend.modules.entity.mysql.ForumDiscoverEntity.RecommendationsEntity;

import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * ClassName:RecommendationsService
 * Package:com.backend.modules.service.ForumDiscoverService
 * Descriptionn:
 *
 * @Author wqh
 * @Create 2024/4/23 0:04
 * @Version 1.0
 */
public interface RecommendationsService extends IService<RecommendationsEntity> {

    List<RecommendationsEntity> getRecommendations();

    RecommendationsEntity getFullContentById(Integer id);
}

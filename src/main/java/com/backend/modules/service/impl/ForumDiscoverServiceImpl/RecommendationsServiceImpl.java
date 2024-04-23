package com.backend.modules.service.impl.ForumDiscoverServiceImpl;

import com.backend.modules.dao.ForumDiscoverDao.RecommendationsDao;

import com.backend.modules.entity.mysql.ForumDiscoverEntity.RecommendationsEntity;

import com.backend.modules.service.ForumDiscoverService.RecommendationsService;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:RecommendationsServiceImpl
 * Package:com.backend.modules.service.impl.ForumDiscoverServiceImpl
 * Descriptionn:
 *
 * @Author wqh
 * @Create 2024/4/23 7:22
 * @Version 1.0
 */

@Service("recommendationsService")
public class RecommendationsServiceImpl extends ServiceImpl<RecommendationsDao, RecommendationsEntity> implements RecommendationsService {

    @Autowired
    private RecommendationsDao recommendationsDao;

    @Override
    public List<RecommendationsEntity> getRecommendations() {
        return recommendationsDao.getRecommendations();
    }

    @Override
    public RecommendationsEntity getFullContentById(Integer id) {
        return recommendationsDao.getFullContentById(id);
    }


}

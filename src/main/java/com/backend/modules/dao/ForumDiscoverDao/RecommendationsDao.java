package com.backend.modules.dao.ForumDiscoverDao;

import com.backend.modules.entity.mysql.ForumDiscoverEntity.RecommendationsEntity;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName:RecommendationsDao
 * Package:com.backend.modules.dao.ForumDiscoverDao
 * Descriptionn:
 *
 * @Author wqh
 * @Create 2024/4/23 7:35
 * @Version 1.0
 */

@Mapper
public interface RecommendationsDao extends BaseMapper<RecommendationsEntity> {


    List<RecommendationsEntity> getRecommendations();
    RecommendationsEntity getFullContentById(Integer id);
}

package com.backend.modules.dao.ForumDiscoverDao;

import com.backend.modules.entity.mysql.ForumDiscoverEntity.TweetsEntity;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName:TweetsDao
 * Package:com.backend.modules.dao.ForumDiscoverDao
 * Descriptionn:
 *
 * @Author wqh
 * @Create 2024/4/23 7:38
 * @Version 1.0
 */

@Mapper
public interface TweetsDao extends BaseMapper<TweetsEntity> {

    List<TweetsEntity> getTweets();
}
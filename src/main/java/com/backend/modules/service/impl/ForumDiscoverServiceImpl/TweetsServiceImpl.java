package com.backend.modules.service.impl.ForumDiscoverServiceImpl;

import com.backend.modules.dao.ForumDiscoverDao.TweetsDao;

import com.backend.modules.entity.mysql.ForumDiscoverEntity.TweetsEntity;

import com.backend.modules.service.ForumDiscoverService.TweetsService;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:TweetsServiceImpl
 * Package:com.backend.modules.service.impl.ForumDiscoverServiceImpl
 * Descriptionn:
 *
 * @Author wqh
 * @Create 2024/4/23 7:23
 * @Version 1.0
 */

@Service("tweetsService")
public class TweetsServiceImpl extends ServiceImpl<TweetsDao, TweetsEntity> implements TweetsService {

    @Autowired
    private TweetsDao tweetsDao;

    @Override
    public List<TweetsEntity> getTweets() {
        return tweetsDao.getTweets();
    }


}
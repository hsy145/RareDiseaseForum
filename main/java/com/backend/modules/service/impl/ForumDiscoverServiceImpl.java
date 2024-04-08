package com.backend.modules.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.backend.common.utils.PageUtils;
import com.backend.common.utils.Query;

import com.backend.modules.dao.ForumDiscoverDao;
import com.backend.modules.entity.ForumDiscoverEntity;
import com.backend.modules.service.ForumDiscoverService;


@Service("forumDiscoverService")
public class ForumDiscoverServiceImpl extends ServiceImpl<ForumDiscoverDao, ForumDiscoverEntity> implements ForumDiscoverService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ForumDiscoverEntity> page = this.page(
                new Query<ForumDiscoverEntity>().getPage(params),
                new QueryWrapper<ForumDiscoverEntity>()
        );

        return new PageUtils(page);
    }

}
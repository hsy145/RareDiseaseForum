package com.backend.modules.service.impl.ForumDiscoverServiceImpl;

import com.backend.modules.dao.ForumDiscoverDao.Middle_boxDao;

import com.backend.modules.entity.mysql.ForumDiscoverEntity.Middle_boxEntity;

import com.backend.modules.service.ForumDiscoverService.Middle_boxService;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:Middle_boxServiceImpl
 * Package:com.backend.modules.service.impl.ForumDiscoverServiceImpl
 * Descriptionn:
 *
 * @Author wqh
 * @Create 2024/4/23 7:22
 * @Version 1.0
 */

@Service("middle_boxService")
public class Middle_boxServiceImpl extends ServiceImpl<Middle_boxDao, Middle_boxEntity> implements Middle_boxService {


    @Autowired
    private Middle_boxDao middle_boxDao;

    @Override
    public List<Middle_boxEntity> getMiddleBoxContents() {
        return middle_boxDao.getMiddleBoxContents();
    }
}
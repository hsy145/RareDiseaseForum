package com.backend.modules.service.impl.ForumDiscoverServiceImpl;

import com.backend.modules.dao.ForumDiscoverDao.SlidesShowDao;

import com.backend.modules.entity.mysql.ForumDiscoverEntity.SlidesShowEntity;

import com.backend.modules.service.ForumDiscoverService.SlidesShowService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:SlidesShowServiceImpl
 * Package:com.backend.modules.service.impl.ForumDiscoverServiceImpl
 * Descriptionn:
 *
 * @Author wqh
 * @Create 2024/4/23 7:23
 * @Version 1.0
 */

@Service("slidesShowService")
public class SlidesShowServiceImpl extends ServiceImpl<SlidesShowDao, SlidesShowEntity> implements SlidesShowService {

    @Autowired
    private SlidesShowDao slidesShowDao;

    @Override
    public List<SlidesShowEntity> getSlidesShowArticles() {
        return slidesShowDao.getSlidesShowArticles();
    }

    @Override
    public SlidesShowEntity getSlidesShowPictureById(Integer id) {
        return slidesShowDao.getSlidesShowPictureById(id);
    }
    @Override
    public List<SlidesShowEntity> getSlidesShowPictures() {
        return slidesShowDao.getSlidesShowPictures();
    }
}

package com.backend.modules.service.ForumDiscoverService;

import com.backend.modules.entity.mysql.ForumDiscoverEntity.SlidesShowEntity;

import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * ClassName:SlidesShowService
 * Package:com.backend.modules.service.ForumDiscoverService
 * Descriptionn:
 *
 * @Author wqh
 * @Create 2024/4/23 0:05
 * @Version 1.0
 */
public interface SlidesShowService extends IService<SlidesShowEntity> {

    List<SlidesShowEntity> getSlidesShowArticles();
    SlidesShowEntity getSlidesShowPictureById(Integer id);
    List<SlidesShowEntity> getSlidesShowPictures();
}

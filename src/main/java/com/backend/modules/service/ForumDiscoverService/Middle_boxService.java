package com.backend.modules.service.ForumDiscoverService;

import com.backend.modules.entity.mysql.ForumDiscoverEntity.Middle_boxEntity;

import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * ClassName:Middle_boxService
 * Package:com.backend.modules.service.ForumDiscoverService
 * Descriptionn:
 *
 * @Author wqh
 * @Create 2024/4/23 0:04
 * @Version 1.0
 */
public interface Middle_boxService extends IService<Middle_boxEntity> {

    List<Middle_boxEntity> getMiddleBoxContents();
}

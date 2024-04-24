package com.backend.modules.dao.ForumDiscoverDao;

import com.backend.modules.entity.mysql.ForumDiscoverEntity.Middle_boxEntity;

import com.backend.modules.entity.mysql.vo.MiddleBoxVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName:Middle_boxDao
 * Package:com.backend.modules.dao.ForumDiscoverDao
 * Descriptionn:
 *
 * @Author wqh
 * @Create 2024/4/23 7:33
 * @Version 1.0
 */
@Mapper
public interface Middle_boxDao extends BaseMapper<Middle_boxEntity> {

    List<MiddleBoxVo> getMiddleBoxContents();
}
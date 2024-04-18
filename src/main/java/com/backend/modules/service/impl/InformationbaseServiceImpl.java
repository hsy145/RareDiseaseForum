package com.backend.modules.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.backend.common.utils.PageUtils;
import com.backend.common.utils.Query;

import com.backend.modules.dao.InformationbaseDao;
import com.backend.modules.entity.mysql.InformationbaseEntity;
import com.backend.modules.service.InformationbaseService;


@Service("informationbaseService")
public class InformationbaseServiceImpl extends ServiceImpl<InformationbaseDao, InformationbaseEntity>
        implements InformationbaseService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<InformationbaseEntity> page = this.page(
                new Query<InformationbaseEntity>().getPage(params),
                new QueryWrapper<InformationbaseEntity>()
        );

        return new PageUtils(page);
    }



    @Autowired
    private InformationbaseDao InformationbaseDao;

    @Override
    public List<InformationbaseEntity> selectAllArticles() {
        return InformationbaseDao.selectAllArticles();
    }

    @Override
    public InformationbaseEntity selectArticleById(Integer id) {
        return InformationbaseDao.selectById(id);
    }

    @Override
    public List<InformationbaseEntity> searchByKeyword(String keyword) {
        return InformationbaseDao.searchByKeyword(keyword);
    }



}
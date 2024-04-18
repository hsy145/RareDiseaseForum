package com.backend.modules.service;

import com.backend.modules.dao.InformationbaseDao;
import com.baomidou.mybatisplus.extension.service.IService;
import com.backend.common.utils.PageUtils;
import com.backend.modules.entity.mysql.InformationbaseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author hsy
 * @email 760356917@qq.com
 * @date 2024-04-08 21:35:18
 */
public interface InformationbaseService extends IService<InformationbaseEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<InformationbaseEntity> selectAllArticles();
    InformationbaseEntity selectArticleById(Integer id);
    List<InformationbaseEntity> searchByKeyword(String keyword);

}


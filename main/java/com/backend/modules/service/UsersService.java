package com.backend.modules.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.backend.common.utils.PageUtils;
import com.backend.modules.entity.UsersEntity;

import java.util.Map;

/**
 * 
 *
 * @author hsy
 * @email 760356917@qq.com
 * @date 2024-04-08 21:35:18
 */
public interface UsersService extends IService<UsersEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


package com.backend.modules.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.modules.entity.mysql.ForumDiscoverEntity;
import com.backend.modules.service.ForumDiscoverService;
import com.backend.common.utils.PageUtils;
import com.backend.common.utils.R;



/**
 * 
 *
 * @author hsy
 * @email 760356917@qq.com
 * @date 2024-04-08 21:35:17
 */
@RestController
@RequestMapping("/forumdiscover")
public class ForumDiscoverController {
    @Autowired
    private ForumDiscoverService forumDiscoverService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = forumDiscoverService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{discoverId}")
    public R info(@PathVariable("discoverId") Integer discoverId){
		ForumDiscoverEntity forumDiscover = forumDiscoverService.getById(discoverId);

        return R.ok().put("forumDiscover", forumDiscover);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ForumDiscoverEntity forumDiscover){
		forumDiscoverService.save(forumDiscover);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ForumDiscoverEntity forumDiscover){
		forumDiscoverService.updateById(forumDiscover);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] discoverIds){
		forumDiscoverService.removeByIds(Arrays.asList(discoverIds));

        return R.ok();
    }

}

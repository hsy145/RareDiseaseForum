package com.backend.modules.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.modules.entity.InformationbaseEntity;
import com.backend.modules.service.InformationbaseService;
import com.backend.common.utils.PageUtils;
import com.backend.common.utils.R;



/**
 * 
 *
 * @author hsy
 * @email 760356917@qq.com
 * @date 2024-04-08 21:35:18
 */
@RestController
@RequestMapping("/informationbase")
public class InformationbaseController {
    @Autowired
    private InformationbaseService informationbaseService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = informationbaseService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{iId}")
    public R info(@PathVariable("iId") Integer iId){
		InformationbaseEntity informationbase = informationbaseService.getById(iId);

        return R.ok().put("informationbase", informationbase);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody InformationbaseEntity informationbase){
		informationbaseService.save(informationbase);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody InformationbaseEntity informationbase){
		informationbaseService.updateById(informationbase);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] iIds){
		informationbaseService.removeByIds(Arrays.asList(iIds));

        return R.ok();
    }

}

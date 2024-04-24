package com.backend.modules.controller.ForumDiscoverController;

import com.backend.common.utils.R;
import com.backend.modules.entity.mysql.ForumDiscoverEntity.Middle_boxEntity;

import com.backend.modules.entity.mysql.vo.MiddleBoxVo;
import com.backend.modules.service.ForumDiscoverService.Middle_boxService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName:Middle_boxController
 * Package:com.backend.modules.controller.ForumDiscoverController
 * Descriptionn:
 *
 * @Author wqh
 * @Create 2024/4/23 0:00
 * @Version 1.0
 */

@RestController
@RequestMapping("/forumdiscover")
public class Middle_boxController {

    @Autowired
    private Middle_boxService middle_boxService;


    // 4获取中间框内容
    @GetMapping("/middle-box")
    public R getMiddleBoxContents() {
        try {
            List<MiddleBoxVo> data = middle_boxService.getMiddleBoxContents();
            return R.ok().put("data", data);
        } catch (Exception e) {
            return R.error(e.getMessage());
        }
    }
}
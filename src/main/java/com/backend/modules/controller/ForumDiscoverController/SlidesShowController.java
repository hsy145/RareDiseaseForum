package com.backend.modules.controller.ForumDiscoverController;

import com.backend.common.utils.R;
import com.backend.modules.entity.mysql.ForumDiscoverEntity.SlidesShowEntity;
import com.backend.modules.service.ForumDiscoverService.SlidesShowService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName:SlidesShowController
 * Package:com.backend.modules.controller.ForumDiscoverController
 * Descriptionn:
 *
 * @Author wqh
 * @Create 2024/4/22 23:58
 * @Version 1.0
 */

@RestController
@RequestMapping("/forumdiscover")
public class SlidesShowController {

    @Autowired
    private SlidesShowService slidesShowService;


    // 1获取轮播图文章
    @GetMapping("/slidesshowarticles")
    public R getRotographArticles() {
        try {
            List<SlidesShowEntity> data = slidesShowService.getSlidesShowArticles();
            return R.ok().put("data", data);
        } catch (Exception e) {
            return R.error(e.getMessage());
        }
    }

    // 1根据ID获取完整内容，可用于用户点击推荐模块后查看完整文章
    @GetMapping("/slidesshowarticles/{id}")
    public R getRotographtPictureById(@PathVariable Integer id) {
        try {
            SlidesShowEntity picture = slidesShowService.getSlidesShowPictureById(id);
            if (picture != null) {
                return R.ok().put("data", picture);
            } else {
                return R.error(404, "Picture not found"); // 如果没有找到内容，返回404错误
            }
        } catch (Exception e) {
            return R.error(e.getMessage());
        }
    }

    //1获取轮播图所有图片
    @GetMapping("/slidesshowpictures")
    public R getRotographPictures() {
        try {
            List<SlidesShowEntity> pictures = slidesShowService.getSlidesShowPictures();
            return R.ok().put("data", pictures);
        } catch (Exception e) {
            return R.error(e.getMessage());
        }
    }
}

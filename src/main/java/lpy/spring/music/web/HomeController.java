package lpy.spring.music.web;

import lpy.spring.music.bean.po.MusicBaseInfoPO;
import lpy.spring.music.result.AjaxResult;
import lpy.spring.music.service.IMusicBasicInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;

/**
 * <一句话简单描述>
 * <详细介绍>
 */
@Controller
@RequestMapping("/music/")
public class HomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @Resource
    private IMusicBasicInfoService iMusicBasicInfoService;

    @RequestMapping("/get-by-id")
    @ResponseBody
    public Object getById(@RequestParam(value = "musicId") String musicId)
            throws InvocationTargetException, IllegalAccessException {
        MusicBaseInfoPO musicBaseInfoPO = iMusicBasicInfoService.getMusicBaseInfoByMusicId(musicId);
        return new AjaxResult(0, "成功", true, musicBaseInfoPO);
    }


    @RequestMapping("/add-music")
    @ResponseBody
    public Object insert(MusicBaseInfoPO musicBaseInfoPO)
            throws InvocationTargetException, IllegalAccessException {
        try {
            iMusicBasicInfoService.addMusicBaseInfo(musicBaseInfoPO);
            return new AjaxResult(0, "成功", true, null);
        } catch (Exception e) {
            return new AjaxResult(1,"失败！"+ e.getMessage(), false, null);
        }
    }
    @RequestMapping("/get-all-list")
    @ResponseBody
    public Object getAllList()
            throws InvocationTargetException, IllegalAccessException {
        MusicBaseInfoPO musicBaseInfoPO = iMusicBasicInfoService.getMusicBaseInfoByMusicId(musicId);
        return new AjaxResult(0, "成功", true, musicBaseInfoPO);
    }
}

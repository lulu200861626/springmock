package lpy.spring.music.service.impl;

import lpy.spring.music.bean.po.MusicBaseInfoPO;
import lpy.spring.music.dao.MusicBaseInfoDAO;
import lpy.spring.music.exception.UserException;
import lpy.spring.music.service.IMusicBasicInfoService;
import lpy.spring.music.util.JsonUtil;
import lpy.spring.music.util.UUIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by lulu on 17/9/23.
 */
@Service
public class MusicBasicInfoServiceImpl implements IMusicBasicInfoService {

    Logger logger = LoggerFactory.getLogger(MusicBasicInfoServiceImpl.class);
    @Resource
    private MusicBaseInfoDAO musicBaseInfoDAO;

    @Override
    public MusicBaseInfoPO getMusicBaseInfoByMusicId(String musicId) {
        MusicBaseInfoPO musicBaseInfoPO = musicBaseInfoDAO.selectById(musicId);
        logger.info("result = " + JsonUtil.toJson(musicBaseInfoPO));
        return musicBaseInfoPO;
    }

    @Override
    public void addMusicBaseInfo(MusicBaseInfoPO musicBaseInfoPO){
        MusicBaseInfoPO infoPO = musicBaseInfoDAO.selectByName(musicBaseInfoPO.getName());
        if(infoPO != null)
            throw new UserException("名字不能重复");
        musicBaseInfoPO.setMusicId(UUIDUtil.getUUID());
        musicBaseInfoDAO.insert(musicBaseInfoPO);
    }
    @Override
    public List<MusicBaseInfoPO> getAlllist(){
        return new ArrayList<>();
    }
}

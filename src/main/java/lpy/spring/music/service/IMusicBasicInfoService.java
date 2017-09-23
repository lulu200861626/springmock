package lpy.spring.music.service;

import java.util.List;
import lpy.spring.music.bean.po.MusicBaseInfoPO;

/**
 * Created by lulu on 17/9/23.
 */
public interface IMusicBasicInfoService {

    public MusicBaseInfoPO getMusicBaseInfoByMusicId(String musicId);
    public void addMusicBaseInfo(MusicBaseInfoPO musicBaseInfoPO);

    public List<MusicBaseInfoPO> getAlllist();
}

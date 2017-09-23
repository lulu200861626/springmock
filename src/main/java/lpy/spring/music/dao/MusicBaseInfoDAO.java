package lpy.spring.music.dao;

/**
 * Created by lulu on 17/9/23.
 */

import java.util.List;
import lpy.spring.music.bean.po.MusicBaseInfoPO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicBaseInfoDAO {
    @Select("select * from music_base_info where music_id=#{musicId}")
    public MusicBaseInfoPO selectById(@Param(value = "musicId")String musicId);

    @Update("insert into music_base_info(music_id,name,author,style,addtime,modtime) values (#{musicId},#{name},#{author},#{style},unix_timestamp(),unix_timestamp())")
    public int insert(MusicBaseInfoPO infoPO);

    @Select("select * from music_base_info where name=#{name}")
    public MusicBaseInfoPO selectByName(@Param(value = "name")String name);



}

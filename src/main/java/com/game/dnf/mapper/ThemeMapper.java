package com.game.dnf.mapper;

import com.game.dnf.pojo.Theme;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ThemeMapper {

    List<Theme> queryAllTheme();

    Theme queryThemeById(int tmid);

    int insertTheme(Theme theme);

    int updateTheme(Theme theme);

}

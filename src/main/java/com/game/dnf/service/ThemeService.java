package com.game.dnf.service;

import com.game.dnf.mapper.ThemeMapper;
import com.game.dnf.pojo.Theme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThemeService {

    @Autowired
    ThemeMapper mapper;

    public List<Theme> allTheme(){
        return mapper.queryAllTheme();
    }

    public Theme getTheme(int tmid){
        return mapper.queryThemeById(tmid);
    }

    public boolean addTheme(Theme theme){
        return mapper.insertTheme(theme)>0?true:false;
    }

    public boolean updTheme(Theme theme){
        return mapper.updateTheme(theme)>0?true:false;
    }

}

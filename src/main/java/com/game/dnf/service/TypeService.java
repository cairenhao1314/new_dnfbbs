package com.game.dnf.service;

import com.game.dnf.mapper.TypeMapper;
import com.game.dnf.pojo.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {

    @Autowired
    TypeMapper mapper;

    public List<Type> allType(){
        return mapper.queryAllType();
    }

    public Type getType(int tyid){
        return mapper.queryTypeById(tyid);
    }

    public boolean addType(Type type){
        return mapper.insertType(type)>0?true:false;
    }

    public boolean updType(Type type){
        return mapper.updateType(type)>0?true:false;
    }

}

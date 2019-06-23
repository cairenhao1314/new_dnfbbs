package com.game.dnf.mapper;

import com.game.dnf.pojo.Type;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TypeMapper {

    List<Type> queryAllType();

    Type queryTypeById(int tyid);

    int insertType(Type type);

    int updateType(Type type);

}

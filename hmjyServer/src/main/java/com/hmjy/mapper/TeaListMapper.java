package com.hmjy.mapper;

import com.hmjy.pojo.TeaInfo;

import java.util.List;

public interface TeaListMapper {
    List<TeaInfo> getTeaList();
    List<TeaInfo> getTeaListByName(String nameLike);
    List<TeaInfo> getTeaListBycategoryId(String categoryId);
}

package com.hmjy.service;

import com.hmjy.pojo.TeaInfo;

import java.util.List;


public interface GetTeaListService {
    List<TeaInfo> getTeaList(String categoryId, String nameLike);
}

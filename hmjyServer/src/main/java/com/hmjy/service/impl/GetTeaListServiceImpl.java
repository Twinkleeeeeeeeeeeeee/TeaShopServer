package com.hmjy.service.impl;


import com.hmjy.mapper.TeaListMapper;
import com.hmjy.pojo.TeaInfo;
import com.hmjy.service.GetTeaListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetTeaListServiceImpl implements GetTeaListService {
    @Autowired
    private TeaListMapper teaListMapper;

    @Override
    public List<TeaInfo> getTeaList(String categoryId, String nameLike) {
        List<TeaInfo> teaList = null;
        //
        if ("0".equals(categoryId) && "".equals(nameLike) || nameLike == null) {
            teaList = teaListMapper.getTeaList();
        } else if ("0".equals(categoryId) || categoryId == null) {
            teaList = teaListMapper.getTeaListByName(nameLike);
        } else if ("".equals(nameLike) || nameLike == null) {
            teaList = teaListMapper.getTeaListBycategoryId(categoryId);
        }
        return teaList;
    }
}

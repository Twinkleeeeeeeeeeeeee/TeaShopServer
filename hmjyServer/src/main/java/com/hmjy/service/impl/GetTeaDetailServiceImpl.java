package com.hmjy.service.impl;

import com.hmjy.mapper.TeaDetailMapper;
import com.hmjy.service.GetTeaDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class GetTeaDetailServiceImpl implements GetTeaDetailService {
    @Autowired
    private TeaDetailMapper teaDetail;
    @Override
    public Map getTeaDetail(int teaId) {
        Map<String, Object> teaDetail = this.teaDetail.getTeaDetail(teaId);
        return teaDetail;
    }
}

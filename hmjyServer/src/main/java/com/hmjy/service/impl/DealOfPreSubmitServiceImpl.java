package com.hmjy.service.impl;

import com.hmjy.mapper.DealOfPreSubmitMapper;
import com.hmjy.service.DealOfPreSubmitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DealOfPreSubmitServiceImpl implements DealOfPreSubmitService {

    @Autowired
    private DealOfPreSubmitMapper dealOfPreSubmitMapper;
    @Override
    public Map<String, Object> DealOfPreSubmit(String teaId) {
        Map<String,Object> map= dealOfPreSubmitMapper.getTeaInfo(teaId);
        return map;
    }
}

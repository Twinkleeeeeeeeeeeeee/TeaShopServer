package com.hmjy.service.impl;

import com.hmjy.mapper.BannerPicMapper;
import com.hmjy.pojo.BannerPic;
import com.hmjy.service.GetBannerPicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GetBannerPicServiceImpl implements GetBannerPicService {
    @Autowired
    private BannerPicMapper bannerPicMapper;
    @Override
    public List<BannerPic> getBannerPic() {
        List<BannerPic> bannerPic = bannerPicMapper.getBannerPic();
        return bannerPic;
    }
}

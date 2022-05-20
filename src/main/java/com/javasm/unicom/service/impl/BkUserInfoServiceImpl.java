package com.javasm.unicom.service.impl;

import com.javasm.unicom.bean.BkUserInfo;
import com.javasm.unicom.bean.PageInfo;
import com.javasm.unicom.bean.vo.BkUserInfoVo;
import com.javasm.unicom.dao.BkUserInfoDao;
import com.javasm.unicom.dao.impl.BkUserInfoDaoImpl;
import com.javasm.unicom.service.BkUserInfoService;

import java.util.List;

/**
 * <h4>financial_manage_sys</h4>
 * <p></p >
 *
 * @Author : huangshuai
 * @Date : 2022-05-20 22:01
 * @Version : 1.0
 **/
public class BkUserInfoServiceImpl implements BkUserInfoService {
   private BkUserInfoDao bkUserInfoDao = new BkUserInfoDaoImpl();

    @Override
    public PageInfo<BkUserInfoVo> selectBkUserInfo(String nowPage, String pageNum, BkUserInfo bkUserInfo) {
        Integer count = bkUserInfoDao.count(bkUserInfo);
        PageInfo<BkUserInfoVo> pageInfo = new PageInfo<>(nowPage,pageNum,count);
        List<BkUserInfoVo> bkUserInfoVos = bkUserInfoDao.selectUserInfo(pageInfo, bkUserInfo);
        pageInfo.setDataList(bkUserInfoVos);
        return pageInfo;
    }
}

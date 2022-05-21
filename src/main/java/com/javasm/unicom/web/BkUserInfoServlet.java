package com.javasm.unicom.web;

import com.alibaba.fastjson.JSONObject;
import com.javasm.controlUtil.BaseServlet;
import com.javasm.unicom.bean.BkUserInfo;
import com.javasm.unicom.bean.PageInfo;
import com.javasm.unicom.bean.vo.BkUserInfoVo;
import com.javasm.unicom.service.BkUserInfoService;
import com.javasm.unicom.service.impl.BkUserInfoServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * <h4>financial_manage_sys</h4>
 * <p></p >
 *
 * @Author : huangshuai
 * @Date : 2022-05-20 22:11
 * @Version : 1.0
 **/
@WebServlet("/userInfo.do")
public class BkUserInfoServlet extends BaseServlet<BkUserInfo> {

    private BkUserInfoService userInfoService = new BkUserInfoServiceImpl();

    /**
     * 分页查询
     *
     * @param request
     * @param bkUserInfo
     * @return
     */
    public String showUserInfo(HttpServletRequest request,BkUserInfo bkUserInfo){
        String nowPage = request.getParameter("nowPage");
        String pageNum = request.getParameter("pageNum");
        PageInfo<BkUserInfoVo> pageInfo = userInfoService.selectBkUserInfo(nowPage,pageNum,bkUserInfo);
        String toJSONString = JSONObject.toJSONString(pageInfo);
        return toJSONString;
    }
}

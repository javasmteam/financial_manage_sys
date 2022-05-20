package com.javasm.unicom.web;

import com.alibaba.fastjson.JSONObject;
import com.javasm.controlUtil.BaseServlet;
import com.javasm.unicom.bean.BkInvestMoney;
import com.javasm.unicom.bean.PageInfo;
import com.javasm.unicom.service.BkInvestMoneyService;
import com.javasm.unicom.service.impl.BkInvestMoneyServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * <h4>financial_manage_sys</h4>
 * <p></p >
 *
 * @Author : huangshuai
 * @Date : 2022-05-20 10:39
 * @Version : 1.0
 **/
@WebServlet("/invest.do")
public class BkInvestMoneyServlet extends BaseServlet<BkInvestMoney> {

    private BkInvestMoneyService bkInvestMoneyService = new BkInvestMoneyServiceImpl();

    public String showInvest (HttpServletRequest request,BkInvestMoney bkInvestMoney){
        String nowPage = request.getParameter("nowPage");
        String pageNum = request.getParameter("pageNum");

        PageInfo<BkInvestMoney> pageInfo =bkInvestMoneyService.getBkInvestMoneyByPage(nowPage,pageNum,bkInvestMoney);
        String jsonString = JSONObject.toJSONString(pageInfo);

        return jsonString;
    }



}

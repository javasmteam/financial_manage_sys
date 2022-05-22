package com.javasm.unicom.web;

import com.alibaba.fastjson.JSONObject;
import com.javasm.controlUtil.BaseServlet;
import com.javasm.unicom.bean.CompanyInfo;
import com.javasm.unicom.bean.HistoryFunding;
import com.javasm.unicom.bean.vo.HistoryFundingVo;
import com.javasm.unicom.service.CompanyInfoService;
import com.javasm.unicom.service.impl.CompanyInfoServiceImpl;
import com.javasm.util.DataUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <h4>financial_manage_sys</h4>
 * <p></p >
 *
 * @Author : huangshuai
 * @Date : 2022-05-22 13:36
 * @Version : 1.0
 **/
@WebServlet("/history.do")
public class HistoryServlet extends BaseServlet<HistoryFunding> {
private CompanyInfoService companyInfoService = new CompanyInfoServiceImpl();
    /**
     * 根据ID查询历史融资
     *
     * @param request
     * @return
     */
    public String showHistory(HttpServletRequest request,HistoryFunding historyFunding){
        String comIdStr = request.getParameter("comId");


        Integer comId = DataUtil.stringConvertToInteger(comIdStr);
        List<HistoryFunding> historyFundings = companyInfoService.selectHistory(comId);

        String toJSONString = JSONObject.toJSONString(historyFundings);
        return toJSONString;
    }
}

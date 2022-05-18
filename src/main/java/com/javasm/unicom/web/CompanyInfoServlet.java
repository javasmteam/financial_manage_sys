package com.javasm.unicom.web; /**
 * <h4>financial_manage_sys</h4>
 * <p>${description}</p >
 *
 * @Author : huangshuai
 * @Date : 2022-05-16 19:52
 * @Version : 1.0
 **/

import com.alibaba.fastjson.JSONObject;
import com.javasm.controlUtil.BaseServlet;
import com.javasm.unicom.bean.CompanyInfo;
import com.javasm.unicom.bean.PageInfo;
import com.javasm.unicom.service.CompanyInfoService;
import com.javasm.unicom.service.impl.CompanyInfoServiceImpl;
import com.javasm.util.ServletUtil;

import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(  "/companyInfo.do")
public class CompanyInfoServlet extends BaseServlet<CompanyInfo> {
    private CompanyInfoService companyInfoService = new CompanyInfoServiceImpl();

    public String showCompany(CompanyInfo companyInfo,HttpServletRequest request){
        String nowPage = request.getParameter("nowPage");
        String pageNum = request.getParameter("pageNum");

        PageInfo<CompanyInfo> pageInfo = companyInfoService.getCompanyInfoByPage(nowPage,pageNum,companyInfo);
        String jsonString = JSONObject.toJSONString(pageInfo);
        return jsonString;
    }




}

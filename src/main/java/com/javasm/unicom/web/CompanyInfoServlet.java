package com.javasm.unicom.web; /**
 * <h4>financial_manage_sys</h4>
 * <p>${description}</p >
 *
 * @Author : huangshuai
 * @Date : 2022-05-16 19:52
 * @Version : 1.0
 **/

import cn.hutool.core.convert.impl.MapConverter;
import com.alibaba.fastjson.JSONObject;
import com.javasm.annotation.ResponseTypeAnnotation;
import com.javasm.controlUtil.BaseServlet;
import com.javasm.myEnum.ResponseEnum;
import com.javasm.unicom.bean.CompanyInfo;
import com.javasm.unicom.bean.HistoryFunding;
import com.javasm.unicom.bean.PageInfo;
import com.javasm.unicom.service.CompanyInfoService;
import com.javasm.unicom.service.impl.CompanyInfoServiceImpl;
import com.javasm.util.DataUtil;
import com.javasm.util.ServletUtil;
import com.jhlabs.image.MapColorsFilter;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.Map;

@WebServlet( "/companyInfo.do")
public class CompanyInfoServlet extends BaseServlet<CompanyInfo> {
    private CompanyInfoService companyInfoService = new CompanyInfoServiceImpl();


    /**
     * 分页查询
     *
     * @param companyInfo
     * @param request
     * @return
     */
    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String showCompany(CompanyInfo companyInfo,HttpServletRequest request){
        String nowPage = request.getParameter("nowPage");
        String pageNum = request.getParameter("pageNum");

        PageInfo<CompanyInfo> pageInfo = companyInfoService.getCompanyInfoByPage(nowPage,pageNum,companyInfo);
        String jsonString = JSONObject.toJSONString(pageInfo);
        return jsonString;
    }

    /**
     * 添加
     *
     * @param request
     * @return
     */
    public String addCompany(HttpServletRequest request){
        Map<String,String[]> map = request.getParameterMap();

        CompanyInfo companyInfo = ServletUtil.requestParamsConvertEntity(map,CompanyInfo.class);

        companyInfo.setComInfoState(1);

        Integer flag = companyInfoService.addCompanyInfo(companyInfo);

        return flag>0 ? "添加成功":"添加失败";

    }

    /**
     * 修改
     *
     * @param request
     * @return
     */
    public String updateCompany(HttpServletRequest request){
        Map<String, String[]> map = request.getParameterMap();

        CompanyInfo companyInfo = ServletUtil.requestParamsConvertEntity(map,CompanyInfo.class);

        Boolean flag = companyInfoService.updateCompany(companyInfo);

        return flag ? "修改成功" : "修改失败" ;

    }

    /**
     * 根据ID查询
     *
     * @param request
     * @return
     */
    public String showHistory(HttpServletRequest request){
        String comIdStr = request.getParameter("comId");

        Integer comId = DataUtil.stringConvertToInteger(comIdStr);

        HistoryFunding history = companyInfoService.selectHistory(comId);
        return String.valueOf(history);
    }








}

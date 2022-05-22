package com.javasm.unicom.web;

import com.alibaba.fastjson.JSONObject;
import com.javasm.controlUtil.BaseServlet;
import com.javasm.unicom.bean.MakerPrice;
import com.javasm.unicom.bean.vo.MakerPriceVo;
import com.javasm.unicom.service.CompanyInfoService;
import com.javasm.unicom.service.impl.CompanyInfoServiceImpl;
import com.javasm.util.ServletUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * <h4>financial_manage_sys</h4>
 * <p></p >
 *
 * @Author : huangshuai
 * @Date : 2022-05-22 15:34
 * @Version : 1.0
 **/
@WebServlet("/maker.do")
public class MakerPriceServlet extends BaseServlet<MakerPrice> {

    private CompanyInfoService companyInfoService = new CompanyInfoServiceImpl();


    /**
     * 修改挂单价
     *
     * @return
     */
    public String updatePrice(HttpServletRequest request){
        Map<String, String[]> map = request.getParameterMap();

        MakerPriceVo priceVo = ServletUtil.requestParamsConvertEntity(map, MakerPriceVo.class);

        Boolean flag = companyInfoService.updatePrice(priceVo);
        return flag ? "修改成功":"修改失败";

    }

}

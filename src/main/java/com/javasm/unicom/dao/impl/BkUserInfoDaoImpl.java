package com.javasm.unicom.dao.impl;

import com.javasm.unicom.bean.BkUserInfo;
import com.javasm.unicom.bean.PageInfo;
import com.javasm.unicom.bean.vo.BkUserInfoVo;
import com.javasm.unicom.dao.BkUserInfoDao;
import com.javasm.util.JDBCUtils;

import java.util.List;

/**
 * <h4>financial_manage_sys</h4>
 * <p></p >
 *
 * @Author : huangshuai
 * @Date : 2022-05-17 17:45
 * @Version : 1.0
 **/
public class BkUserInfoDaoImpl implements BkUserInfoDao {
    @Override
    public Integer addBkUserInfo(BkUserInfo bkUserInfo) {
        String sql = "insert into bk_user_info values(userid,?,?,?,?,?,?,?,?,?,?,?,1)";
        return JDBCUtils.insert("bk_user_info",bkUserInfo);
    }

    @Override
    public Integer count(BkUserInfo bkUserInfo) {
        String sql = "select count(userid) from bk_user_info";
        return JDBCUtils.size(sql);
    }

    @Override
    public List<BkUserInfoVo> selectUserInfo(PageInfo<BkUserInfoVo> page, BkUserInfo bkUserInfo) {
        StringBuilder sql = new StringBuilder("select u.usercode ,u.username,u.iphone,c.com_name comName,a.holdnumber,a.holdmoney\n" +
                "from bk_user_info u,bk_customer_assets a,company_info c where u.userid = a.userid and a.com_id = c.com_id");
        if (bkUserInfo != null){
            if (bkUserInfo.getUsername() != null && !"".equals(bkUserInfo.getUsername())){
                sql.append(" and u.username like '%"+bkUserInfo.getUsername()+"%'");
            }
            if (bkUserInfo.getIphone() !=null && !"".equals(bkUserInfo.getIphone())){
                sql.append(" and u.iphone like '%"+bkUserInfo.getIphone()+"%'");
            }
        }
        sql.append(" limit ?,? ");
        return JDBCUtils.query(sql.toString(),BkUserInfoVo.class,page.getStartIndex(),page.getPageNum());
    }
}

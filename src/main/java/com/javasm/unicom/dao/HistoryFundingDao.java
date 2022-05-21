package com.javasm.unicom.dao;

import com.javasm.unicom.bean.HistoryFunding;
import com.javasm.unicom.bean.vo.HistoryFundingVo;

public interface HistoryFundingDao {


    /**
     * 查询历史融资
     *
     * @param comId
     * @return
     */
    HistoryFundingVo selectHistory(Integer comId);
}

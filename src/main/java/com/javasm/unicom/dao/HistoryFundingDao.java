package com.javasm.unicom.dao;

import com.javasm.unicom.bean.HistoryFunding;

public interface HistoryFundingDao {


    /**
     * 查询历史融资
     *
     * @param comId
     * @return
     */
    HistoryFunding selectHistory(Integer comId);
}

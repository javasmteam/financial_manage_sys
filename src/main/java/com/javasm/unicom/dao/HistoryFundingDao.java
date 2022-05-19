package com.javasm.unicom.dao;

import com.javasm.unicom.bean.HistoryFunding;

import java.util.List;

public interface HistoryFundingDao {


    /**
     * 查询历史融资
     *
     * @param historyFunding
     * @return
     */
    List<HistoryFunding> selectHistory(HistoryFunding historyFunding);
}

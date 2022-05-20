package com.javasm.unicom.dao;

import com.javasm.unicom.bean.HistoryFunding;

import java.util.List;

public interface HistoryFundingDao {

    /**
     * 根据id查询历史融资
     * @param hyFunId
     * @return
     */
    HistoryFunding selectHistory(Integer hyFunId);
}

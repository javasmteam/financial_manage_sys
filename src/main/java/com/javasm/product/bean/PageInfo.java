package com.javasm.product.bean;

import com.javasm.util.DataUtil;

import java.util.List;

/**
 * <h4>Financial_manage_sys</h4>
 * <p>分页信息</p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-05-15 21:01
 * @Version : 1.0
 **/
public class PageInfo<T> {
    /**
     * 当前页
     */
    private Integer nowPage;
    /**
     * 每页显示数据量
     */
    private Integer pageNum;
    /**
     * 起始索引
     */
    private Integer startIndex;
    /**
     * 总条数
     */
    private Integer allCount;
    /**
     * 总页数
     */
    private Integer sumPage;
    /**
     * 分页数据
     */
    private List<T> dataList;

    @Override
    public String toString() {
        return "PageInfo{" +
                "nowPage=" + nowPage +
                ", pageNum=" + pageNum +
                ", startIndex=" + startIndex +
                ", allCount=" + allCount +
                ", sumPage=" + sumPage +
                ", dataList=" + dataList +
                '}';
    }

    public PageInfo() {
    }

    public PageInfo(String nowPageStr, String pageNumStr, Integer allCount) {
        Integer nowPage = DataUtil.stringConvertToInteger(nowPageStr);
        Integer pageNum = DataUtil.stringConvertToInteger(pageNumStr);

        //赋值
        this.nowPage = nowPage == null || nowPage < 1 ? 1 : nowPage;
        this.pageNum = pageNum == null || pageNum < 2 ? 5 : pageNum;
        this.allCount = allCount;

        //计算
        this.sumPage = this.allCount % this.pageNum == 0 ? this.allCount / this.pageNum : this.allCount / this.pageNum + 1;
        this.sumPage = this.sumPage < 1 ? 1 : this.sumPage;

        this.nowPage = this.nowPage > this.sumPage ? this.sumPage : this.nowPage;
        this.startIndex = (this.nowPage - 1) * this.pageNum;
    }

    public Integer getNowPage() {
        return nowPage;
    }

    public void setNowPage(Integer nowPage) {
        this.nowPage = nowPage;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Integer getAllCount() {
        return allCount;
    }

    public void setAllCount(Integer allCount) {
        this.allCount = allCount;
    }

    public Integer getSumPage() {
        return sumPage;
    }

    public void setSumPage(Integer sumPage) {
        this.sumPage = sumPage;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}

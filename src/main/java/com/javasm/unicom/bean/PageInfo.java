package com.javasm.unicom.bean;


import com.javasm.util.DataUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @Author：liulei
 * @Version：1.0
 * @Date：2022/4/29-11:17
 * @Since:jdk1.8
 * @Description:
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PageInfo<T> {

    /**
     *  当前页(从页面传递过来的)
     */
    private Integer nowPage;
    /**
     *  每页显示几条数据（从页面传递过来的）
     */
    private Integer pageNum;
    /**
     *  起始下标（计算）
     */
    private Integer startIndex;
    /**
     *  总条数（查询数据库统计的结果）
     */
    private Integer allCount;
    /**
     * 总页数（计算）
     */
    private Integer sumPage;
    /**
     * 分页数据
     */
    private List<T> dataList;





    public List<T> getDataList(){
        return dataList;
    }


    public void setDataList(List<T> dataList){
        this.dataList = dataList;
    }

    /**
     * 有参构造
     *
     * @param nowPageStr 当前页
     * @param pageNumStr 每页显示几条数据
     * @param allCount   总条数
     */
    public PageInfo(String nowPageStr, String pageNumStr, Integer allCount) {
        Integer nowPage = DataUtil.stringConvertToInteger(nowPageStr);
        Integer pageNum = DataUtil.stringConvertToInteger(pageNumStr);
        // 赋值
        this.nowPage = nowPage == null || nowPage < 1 ? 1 : nowPage;
        this.pageNum = pageNum == null || pageNum < 2 ? 3 : pageNum;
        this.allCount = allCount;

        // 计算
        this.sumPage = this.allCount % this.pageNum == 0 ? this.allCount / this.pageNum : this.allCount / this.pageNum + 1;// 总页数
        this.nowPage = this.nowPage > this.sumPage ? this.sumPage : this.nowPage;
        this.startIndex = (this.nowPage - 1) * this.pageNum;// 起始下标
    }


    public Integer getNowPage() {
        return nowPage;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public Integer getAllCount() {
        return allCount;
    }

    public Integer getSumPage() {
        return sumPage;
    }
}

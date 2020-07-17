package com.smart.cmsystem.mapper;

import com.smart.cmsystem.domain.entity.MoneyDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MoneyDetailMapper {

    /**
     * 添加用户
     * @param
     * @return
     */

    int insert(@Param("moneyDetail") MoneyDetail moneyDetail);

    /**
     * 修改
     *
     */
    int update(@Param("moneyDetail") MoneyDetail moneyDetail);
    /**
     * 单个删除用户
     * @param
     * @return
     */
    int delete(@Param("mdId") int mdId);

//    /**
//     *通过房产编号查询用户
//     */
//    Housing selectByhConding(@Param("hConding") String hConding);
    /**
     * 批量删除
     * @param
     */
    int deleteMoneyDetail(@Param("mdIds") List<Integer> mdIds);
    /**
     * 全部查找
     * 根据户主名字  户主的手机号
     */
    List<MoneyDetail> selectAll(@Param("keyWord") String keyWord,
                                @Param("update_time") String updateTime,
                                @Param("create_time") String createTime,
                                @Param("ending_time") String endingTime,
                                @Param("limit") int limit,
                                @Param("offset") int offset);
}
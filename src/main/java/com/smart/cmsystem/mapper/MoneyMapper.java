package com.smart.cmsystem.mapper;

import com.smart.cmsystem.domain.entity.Housing;
import com.smart.cmsystem.domain.entity.Money;
import com.sun.org.apache.bcel.internal.generic.MONITORENTER;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MoneyMapper {
    /**
     * 添加用户
     * @param
     * @return
     */

    int insert(@Param("money") Money money);

    /**
     * 修改
     *
     */
    int update(@Param("money") Money money);
    /**
     * 单个删除用户
     * @param
     * @return
     */
    int delete(@Param("mId") int mId);


    /**
     * 批量删除
     * @param
     */
    int deleteMoneys(@Param("mIds") List<Integer> mIDs);
    /**
     * 全部查找
     * 根据户主名字  户主的手机号
     */
    List<Money> selectAll(@Param("keyWord") String keyWord,
                          @Param("create_time") String createTime,
                          @Param("ending_time") String endingTime,
                          @Param("limit") int limit,
                          @Param("offset") int offset);
}
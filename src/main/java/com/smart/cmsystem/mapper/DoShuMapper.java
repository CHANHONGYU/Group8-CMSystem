package com.smart.cmsystem.mapper;

import com.smart.cmsystem.domain.entity.DoShu;
import com.smart.cmsystem.domain.entity.Housing;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DoShuMapper {
    /**
     * 添加用户
     *
     * @param
     * @return
     */
    int insert(@Param("doShu") DoShu doShu);

    /**
     * 修改
     */
    int update(@Param("doShu") DoShu doShu);
//    /**
//     *通过房产编号查询用户
//     */
//    Housing selectByhConding(@Param("hConding") String hConding);

    /**
     * 单个删除用户
     *
     * @param
     * @return
     */
    int delete(@Param("dId") int dId);

    /**
     * 批量删除
     */
    int deleteDoShus(@Param("dIds") List<Integer> dIds);

    /**
     * 全部查找
     * 根据栋数名字
     */
    List<DoShu> selectAll(@Param("keyWord") String keyWord,
                          @Param("create_time") String createTime,
                          @Param("ending_time") String endingTime,
                          @Param("limit") int limit,
                          @Param("offset") int offset);
}

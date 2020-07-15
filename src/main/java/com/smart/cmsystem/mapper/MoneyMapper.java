package com.smart.cmsystem.mapper;

import com.smart.cmsystem.domain.entity.DoShu;
import com.smart.cmsystem.domain.entity.Money;
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
    int update(@Param("money")Money money);
//    /**
//     *通过房产编号查询用户
//     */
//    Housing selectByhConding(@Param("hConding") String hConding);
    /**
     * 单个删除用户
     * @param
     * @return
     */
    int delete(@Param("money") Money money);
    /**
     * 批量删除
     */
    int updateDoShu(@Param("monIds") List<Integer> monIds);
    /**
     * 全部查找
     * 根据栋数名字
     */
    List<DoShu> selectAll(@Param("keyWord")String keyWord, @Param("creatTime") String  creatTime);
}

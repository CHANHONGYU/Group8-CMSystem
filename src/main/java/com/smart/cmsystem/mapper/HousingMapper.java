package com.smart.cmsystem.mapper;

import com.smart.cmsystem.domain.entity.Housing;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HousingMapper {

    /**
     * 添加用户
     * @param
     * @return
     */

    int insert(@Param("housing") Housing housing);

    /**
     * 修改
     *
     */
    int update(@Param("housing")Housing housing);
    /**
     * 单个删除用户
     * @param housing
     * @return
     */
    int delete(@Param("housing") Housing housing);

//    /**
//     *通过房产编号查询用户
//     */
//    Housing selectByhConding(@Param("hConding") String hConding);
    /**
     * 批量删除
     */
    int updateHousing(@Param("hIds") List<Integer>hIds);
    /**
     * 全部查找
     * 根据户主名字  户主的手机号
     */
    List<Housing> selectAll(@Param("keyWord")String keyWord, @Param("creatTime") String  creatTime);
}

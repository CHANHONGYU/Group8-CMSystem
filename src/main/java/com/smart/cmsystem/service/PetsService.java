package com.smart.cmsystem.service;

import com.smart.cmsystem.domain.dto.Search;
import com.smart.cmsystem.domain.entity.Pets;

import java.util.List;

public interface PetsService {
    /**
     * 搜索所需宠物信息
     * @param search
     * @return
     */
    List<Pets> searchPets(Search search);
    /**
     * 添加新宠物信息
     * @param pets
     * @return
     */
    int addPets(Pets pets);

    /**
     * 批量删除宠物信息
     * @param petsList
     * @return
     */
    int delPetss(List<Pets> petsList);

    /**
     * 显示所有宠物的信息
     * @return
     */
    List<Pets> selectAll();

    /**
     * 修改一只宠物的信息
     * @param pets
     * @return
     */
    int modifyPets(Pets pets);

    /**
     * 删除一只宠物的信息
     * @param pets
     * @return
     */
    int delPets(Pets pets);
}

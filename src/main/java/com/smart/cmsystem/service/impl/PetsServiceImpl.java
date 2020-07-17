package com.smart.cmsystem.service.impl;

import com.smart.cmsystem.domain.dto.Search;
import com.smart.cmsystem.domain.entity.Pets;
import com.smart.cmsystem.domain.entity.Pets;
import com.smart.cmsystem.mapper.PetsMapper;
import com.smart.cmsystem.service.FileService;
import com.smart.cmsystem.service.PetsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PetsServiceImpl implements PetsService {
    @Resource
    PetsMapper petsMapper;
    @Resource
    FileService fileService;
    /**
     * 搜索所需宠物信息
     *
     * @param search
     * @return
     */
    @Override
    public List<Pets> searchPets(Search search) {
        return petsMapper.selectAllByDate(search);
    }

    /**
     * 添加新宠物信息
     *
     * @param pets
     * @return
     */
    @Override
    @Transactional
    public int addPets(Pets pets) {
        return  petsMapper.insertSelective(pets);
    }

    /**
     * 批量删除宠物信息
     *
     * @param petsList
     * @return count：返回一个删除总数
     */
    @Override
    @Transactional
    public int delPetss(List<Pets> petsList) {
        int count=0;
        if (petsList!=null){
            for (Pets pets : petsList) {
                //查询数据库中是否有这个宠物的信息
                Pets newPets = petsMapper.selectByPrimaryKey(pets.getPetsId());
                if (newPets!=null) {
                    //执行删除操作
                    petsMapper.deleteByPrimaryKey(newPets.getPetsId());
                    count++;
                }
            }

        }
        return count;
    }

    /**
     * 显示所有宠物的信息
     *
     * @return petsList:所有宠物的信息
     */
    @Override
    public List<Pets> selectAll() {
        List<Pets> petsList= petsMapper.selectAll();
        return petsList;
    }

    /**
     * 修改一只宠物的信息
     *
     * @param pets
     * @return
     */
    @Override
    @Transactional
    public int modifyPets(Pets pets) {
        int count = petsMapper.updateByPrimaryKeySelective(pets);
        return count;
    }

    /**
     * 删除一只宠物的信息
     *
     * @param pets
     * @return
     */
    @Override
    @Transactional
    public int delPets(Pets pets) {
        int count = petsMapper.deleteByPrimaryKey(pets.getPetsId());
        return count;
    }
}

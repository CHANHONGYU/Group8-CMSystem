package com.smart.cmsystem.controller;

import com.smart.cmsystem.domain.dto.Search;
import com.smart.cmsystem.domain.entity.Pets;
import com.smart.cmsystem.service.PetsService;
import com.smart.cmsystem.utils.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/pets")
@CrossOrigin(origins = "*",maxAge = 3600)
public class PetsController {
    @Resource
    PetsService petsService;

    /**
     * 搜索所需宠物信息
     *
     * @param search
     * @return
     */
    @RequestMapping("/selectByDate")
    public List<Pets> selectByDate(@RequestBody Search search){
        return petsService.searchPets(search);
    }
    /**
     * 添加一只宠物信息
     * @param pets
     * @return
     */
    @RequestMapping("/addPets")
    public int addPets(@RequestBody Pets pets){
        int count = petsService.addPets(pets);
        return count;
    }

    /**
     * 查询所有宠物的信息
     * @return
     */
    @CrossOrigin(origins = "*",maxAge = 3600)
    @RequestMapping(method = RequestMethod.POST,value = "/selectAll")
    @ResponseBody
    public ResponseEntity<List<Pets>> selectAll(){
        List petsLis =petsService.selectAll();
        return ResponseEntity.success(petsLis);
    }

    /**
     * 修改一只宠物的信息
     * @param pets
     * @return
     */
    @RequestMapping("/modifyPets")
    public int modifyPets(@RequestBody Pets pets){
        int count = petsService.modifyPets(pets);
        return count;
    }

    /**
     * 删除一只宠物的信息
     *
     * @param pets
     * @return
     */
    @RequestMapping("/delPets")
    public int delPets(@RequestBody Pets pets) {
        int count = petsService.delPets(pets);
        return count;
    }

    /**
     * 批量删除宠物的信息（假删除）
     * @param petsList
     * @return
     */
    @RequestMapping("/delPetss")
    public int delPetss(@RequestBody List<Pets> petsList){
        int count = petsService.delPetss(petsList);
        return count;
    }
}

package com.smart.cmsystem.controller;

import com.smart.cmsystem.domain.dto.Search;
import com.smart.cmsystem.domain.entity.Assets;
import com.smart.cmsystem.service.impl.AssetsServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/assets")
@CrossOrigin(origins = "*",maxAge = 3600)
public class AssetsController {
    @Resource
    AssetsServiceImpl assetsService;
    /**
     * 搜索所需资产信息
     *
     * @param search
     * @return
     */
    @RequestMapping("/selectByDate")
    public List<Assets> selectByDate(@RequestBody Search search){
        return assetsService.searchAssets(search);
    }
    /**
     * 添加资产信息
     * @param assets
     * @return
     */
    @RequestMapping("/addAssets")
    public int addAssets(@RequestBody Assets assets){
        return assetsService.addAssets(assets);
    }

    /**
     * 查询所有资产的信息
     * @return
     */
    @RequestMapping("/selectAll")
    @ResponseBody
    public List<Assets> selectAll(){
        return assetsService.selectAll();
    }

    /**
     * 修改资产的信息
     * @param assets
     * @return
     */
    @RequestMapping("/modifyAssets")
    public int modifyAssets(@RequestBody Assets assets){
        return assetsService.modifyAssets(assets);
    }

    /**
     * 删除资产的信息
     *
     * @param assets
     * @return
     */
    @RequestMapping("/delAssets")
    public int delAssets(@RequestBody Assets assets) {
        return assetsService.delAssets(assets);
    }

    /**
     * 批量删除资产的信息（假删除）
     * @param assetsList
     * @return
     */
    @RequestMapping("/delAssetsList")
    public int delAssetsList(@RequestBody List<Assets> assetsList){
        return assetsService.delAssetsList(assetsList);
    }
}

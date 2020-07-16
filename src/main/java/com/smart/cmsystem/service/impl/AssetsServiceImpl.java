package com.smart.cmsystem.service.impl;

import com.smart.cmsystem.domain.dto.Search;
import com.smart.cmsystem.domain.entity.Assets;
import com.smart.cmsystem.domain.entity.Car;
import com.smart.cmsystem.mapper.AssetsMapper;
import com.smart.cmsystem.service.AssetsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class AssetsServiceImpl implements AssetsService {
    @Resource
    AssetsMapper assetsMapper;
    /**
     * 搜索所需资产信息
     *
     * @param search
     * @return
     */
    @Override
    public List<Assets> searchAssets(Search search) {
        return assetsMapper.selectAllByDate(search);
    }

    /**
     * 添加新资产信息
     *
     * @param assets
     * @return
     */
    @Override
    public int addAssets(Assets assets) {
        return  assetsMapper.insertSelective(assets);
    }

    /**
     * 批量删除资产信息
     *
     * @param assetsList
     * @return
     */
    @Override
    public int delAssetsList(List<Assets> assetsList) {
        int count=0;
        if (assetsList!=null){
            for (Assets assets : assetsList) {
                //查询数据库中是否有这个车辆的信息
                Assets newAssets = assetsMapper.selectByPrimaryKey(assets.getAssetsId());
                if (newAssets!=null) {
                    //执行删除操作
                    assetsMapper.deleteByPrimaryKey(newAssets.getAssetsId());
                    count++;
                }
            }

        }
        return count;
    }

    /**
     * 显示所有资产的信息
     *
     * @return
     */
    @Override
    public List<Assets> selectAll() {
        return assetsMapper.selectAll();
    }

    /**
     * 修改资产的信息
     *
     * @param assets
     * @return
     */
    @Override
    public int modifyAssets(Assets assets) {
        return assetsMapper.updateByPrimaryKeySelective(assets);
    }

    /**
     * 删除资产的信息
     *
     * @param assets
     * @return
     */
    @Override
    public int delAssets(Assets assets) {
        return assetsMapper.deleteByPrimaryKey(assets.getAssetsId());
    }
}

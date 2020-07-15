package com.smart.cmsystem.service;


import com.smart.cmsystem.domain.dto.Search;
import com.smart.cmsystem.domain.entity.Assets;

import java.util.List;

public interface AssetsService {
    /**
     * 搜索所需资产信息
     * @param search
     * @return
     */
    List<Assets> searchAssets(Search search);
    /**
     * 添加新资产信息
     * @param assets
     * @return
     */
    int addAssets(Assets assets);

    /**
     * 批量删除资产信息
     * @param assetsList
     * @return
     */
    int delAssetss(List<Assets> assetsList);

    /**
     * 显示所有资产的信息
     * @return
     */
    List<Assets> selectAll();

    /**
     * 修改资产的信息
     * @param assets
     * @return
     */
    int modifyAssets(Assets assets);

    /**
     * 删除资产的信息
     * @param assets
     * @return
     */
    int delAssets(Assets assets);
}

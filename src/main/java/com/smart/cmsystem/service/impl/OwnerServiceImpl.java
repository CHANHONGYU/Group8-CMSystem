package com.smart.cmsystem.service.impl;

import com.smart.cmsystem.domain.dto.Search;
import com.smart.cmsystem.domain.entity.Owner;
import com.smart.cmsystem.mapper.OwnerMapper;
import com.smart.cmsystem.service.FileService;
import com.smart.cmsystem.service.OwnerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {
    @Resource
    OwnerMapper ownerMapper;
    @Resource
    FileService fileService;
    /**
     * 搜索所需业主信息
     *
     * @param search
     * @return
     */
    @Override
    public List<Owner> searchOwner(Search search) {
        return ownerMapper.selectAllByDate(search);
    }

    /**
     * 添加新业主信息
     *
     * @param owner
     * @return
     */
    @Override
    @Transactional
    public int addOwner(Owner owner) {
        return  ownerMapper.insertSelective(owner);
    }

    /**
     * 批量删除业主信息
     *
     * @param ownerList
     * @return count：返回一个删除总数
     */
    @Override
    @Transactional
    public int delOwners(List<Owner> ownerList) {
        int count=0;
        if (ownerList!=null){
            for (Owner owner : ownerList) {
                //查询数据库中是否有这个业主的信息
                Owner newOwner = ownerMapper.selectByPrimaryKey(owner.getOwnerId());
                if (newOwner!=null) {
                    //执行删除操作
                    ownerMapper.deleteByPrimaryKey(newOwner.getOwnerId());
                    count++;
                }
            }

        }
        return count;
    }

    /**
     * 显示所有业主的信息
     *
     * @return ownerList:所有业主的信息
     */
    @Override
    public List<Owner> selectAll() {
        List<Owner> ownerList= ownerMapper.selectAll();
        return ownerList;
    }

    /**
     * 修改一名业主的信息
     *
     * @param owner
     * @return
     */
    @Override
    @Transactional
    public int modifyOwner(Owner owner) {
        int count = ownerMapper.updateByPrimaryKeySelective(owner);
        return count;
    }

    /**
     * 删除一名业主的信息
     *
     * @param owner
     * @return
     */
    @Override
    @Transactional
    public int delOwner(Owner owner) {
        int count = ownerMapper.deleteByPrimaryKey(owner.getOwnerId());
        return count;
    }
}

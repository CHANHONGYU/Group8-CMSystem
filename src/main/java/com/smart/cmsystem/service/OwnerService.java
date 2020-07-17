package com.smart.cmsystem.service;

import com.smart.cmsystem.domain.dto.Search;
import com.smart.cmsystem.domain.entity.Owner;
import com.smart.cmsystem.exception.ServiceException;

import java.util.List;

public interface OwnerService {

    /**
     * 搜索所需业主信息
     * @param search
     * @return
     */
    List<Owner> searchOwner(Search search) throws ServiceException;
    /**
     * 添加新业主信息
     * @param owner
     * @return
     */
    int addOwner(Owner owner) throws ServiceException;

    /**
     * 批量删除业主信息
     * @param ownerList
     * @return
     */
    int delOwners(List<Owner> ownerList) throws ServiceException;

    /**
     * 显示所有业主的信息
     * @return
     */
    List<Owner> selectAll() throws ServiceException;

    /**
     * 修改一名业主的信息
     * @param owner
     * @return
     */
    int modifyOwner(Owner owner) throws ServiceException;

    /**
     * 删除一名业主的信息
     * @param owner
     * @return
     */
    int delOwner(Owner owner) throws ServiceException;


}

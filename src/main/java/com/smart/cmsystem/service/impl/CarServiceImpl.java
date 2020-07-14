package com.smart.cmsystem.service.impl;

import com.smart.cmsystem.domain.dto.Search;
import com.smart.cmsystem.domain.entity.Car;
import com.smart.cmsystem.mapper.CarMapper;
import com.smart.cmsystem.service.CarService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Resource
    CarMapper carMapper;
    /**
     * 搜索所需车辆信息
     *
     * @param search 搜索实体类
     * @return List<car>
     */
    @Override
    public List<Car> searchCar(Search search) {
        return carMapper.selectAllByDate(search);
    }

    /**
     * 添加新车辆信息
     *
     * @param car 车辆实体类
     * @return 添加是否成功
     */
    @Override
    @Transactional
    public int addCar(Car car) {
        return  carMapper.insertSelective(car);
    }

    /**
     * 批量删除车辆信息
     *
     * @param carList 车辆实体类List
     * @return count：返回一个删除总数
     */
    @Override
    @Transactional
    public int delCars(List<Car> carList) {
        int count=0;
        if (carList!=null){
            for (Car car : carList) {
                //查询数据库中是否有这个车辆的信息
                Car newCar = carMapper.selectByPrimaryKey(car.getCarId());
                if (newCar!=null) {
                    //执行删除操作
                    carMapper.deleteByPrimaryKey(newCar.getCarId());
                    count++;
                }
            }

        }
        return count;
    }

    /**
     * 显示所有车辆的信息
     * @return carList:所有车辆的信息
     */
    @Override
    public List<Car> selectAll() {
        return carMapper.selectAll();
    }

    /**
     * 修改一名车辆的信息
     *
     * @param car  要修改车辆的实体类
     * @return 修改车辆是否成功，0表示不成功，1表示成功
     */
    @Override
    @Transactional
    public int modifyCar(Car car) {
        return carMapper.updateByPrimaryKeySelective(car);
    }

    /**
     * 删除一名车辆的信息
     *
     * @param car 要删除车辆的实体类
     * @return 删除车辆是否成功，0表示不成功，1表示成功
     */
    @Override
    @Transactional
    public int delCar(Car car) {
        return carMapper.deleteByPrimaryKey(car.getCarId());
    }
}

package com.smart.cmsystem.service;

import com.smart.cmsystem.domain.dto.Search;
import com.smart.cmsystem.domain.entity.Car;

import java.util.List;

public interface CarService {
    /**
     * 搜索所需车辆信息
     * @param search
     * @return
     */
    List<Car> searchCar(Search search);
    /**
     * 添加新车辆信息
     * @param car
     * @return
     */
    int addCar(Car car);

    /**
     * 批量删除车辆信息
     * @param carList
     * @return
     */
    int delCars(List<Car> carList);

    /**
     * 显示所有车辆的信息
     * @return
     */
    List<Car> selectAll();

    /**
     * 修改一名车辆的信息
     * @param car
     * @return
     */
    int modifyCar(Car car);

    /**
     * 删除一名车辆的信息
     * @param car
     * @return
     */
    int delCar(Car car);
}

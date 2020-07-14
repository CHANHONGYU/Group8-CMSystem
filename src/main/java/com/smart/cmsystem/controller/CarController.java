package com.smart.cmsystem.controller;

import com.smart.cmsystem.domain.dto.Search;
import com.smart.cmsystem.domain.entity.Car;
import com.smart.cmsystem.service.impl.CarServiceImpl;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    @Resource
    CarServiceImpl carService;
    /**
     * 搜索所需车辆信息
     *
     * @param search
     * @return
     */
    @RequestMapping("/selectByDate")
    public List<Car> selectByDate(@RequestBody Search search){
        return carService.searchCar(search);
    }
    /**
     * 添加一辆车信息
     * @param car
     * @return
     */
    @RequestMapping("/addCar")
    public int addCar(@RequestBody Car car){
        return carService.addCar(car);
    }

    /**
     * 查询所有车辆的信息
     * @return
     */
    @RequestMapping("/selectAll")
    @ResponseBody
    public List<Car> selectAll(){
        return carService.selectAll();
    }

    /**
     * 修改一辆车的信息
     * @param car
     * @return
     */
    @RequestMapping("/modifyCar")
    public int modifyCar(@RequestBody Car car){
        return carService.modifyCar(car);
    }

    /**
     * 删除一辆车的信息
     *
     * @param car
     * @return
     */
    @RequestMapping("/delCar")
    public int delCar(@RequestBody Car car) {
        return carService.delCar(car);
    }

    /**
     * 批量删除车辆的信息（假删除）
     * @param carList
     * @return
     */
    @RequestMapping("/delCars")
    public int delCars(@RequestBody List<Car> carList){
        return carService.delCars(carList);
    }
}

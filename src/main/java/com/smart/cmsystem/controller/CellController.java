package com.smart.cmsystem.controller;


import com.smart.cmsystem.domain.entity.Cell;
import com.smart.cmsystem.service.CellService;
import com.smart.cmsystem.utils.RUtity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/cell")
public class CellController {
    @Resource
    CellService cellService;
    //查询列表，分页
    @GetMapping("/list/{page}/{size}")
    public RUtity<List<Cell>> list(@PathVariable("page") int page, @PathVariable("size") int size){
        List<Cell> cells = cellService.queryAll(page, size);
        return RUtity.success(cells);
    }
    //修改状态
    @PutMapping("/modify")
    public RUtity<Integer> modify(@RequestParam int state,@RequestParam int cid){
        int i = cellService.modifyByState(state, cid);
        return RUtity.success(i);
    }
    //删除
    @PutMapping("/del")
    public RUtity<Integer> del(@RequestParam int cid){
        int i = cellService.removeData(cid);
        return RUtity.success(i);
    }
    //关键字查询
    @GetMapping("/query")
    public RUtity<List<Cell>> query(@RequestParam String keyword){
        List<Cell> querykeywords = cellService.querykeywords(keyword);
        return RUtity.success(querykeywords);
    }
    //修改
    @PutMapping("/amended")
    public RUtity<Integer>  amended(@RequestBody Cell cell){
        int i = cellService.RevisedContent(cell);
        return RUtity.success(i);
    }
    //添加
    @PostMapping("/add")
    public RUtity<Integer>  addTo(@RequestBody Cell cell){
        int i = cellService.setupData(cell);
        return RUtity.success(i);
    }
    //批量删除
    @PostMapping("/array")
    public RUtity<Integer> array(@RequestBody int[] ints){
        int i = cellService.BatchDeletion(ints);
        return RUtity.success(i);
    }

}

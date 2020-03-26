package org.wukl.vhr.controller.system.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.wukl.vhr.model.Position;
import org.wukl.vhr.model.ResponseBean;
import org.wukl.vhr.service.PositionService;

import java.util.List;
@RestController
@RequestMapping("/sys/basic/pos")
public class PositionController {
    @Autowired
    PositionService positionService;
    @GetMapping("/")
    public List<Position> getAllPositions() {
        return positionService.getAllPositions();
    }

    @PostMapping("/")
    public ResponseBean addPosition(@RequestBody Position position) {
        if (positionService.addPosition(position) == 1) {
            return ResponseBean.responseSuccess("职位添加成功!");
        }
        return ResponseBean.responseError("职位添加失败!");
    }

    @PutMapping("/")
    public ResponseBean updatePositions(@RequestBody Position position) {
        if (positionService.updatePositions(position) == 1) {
            return ResponseBean.responseSuccess("职位更新成功!");
        }
        return ResponseBean.responseError("职位更新失败!");
    }

    @DeleteMapping("/{id}")
    public ResponseBean deletePositionById(@PathVariable Integer id) {
        if (positionService.deletePositionById(id) == 1) {
            return ResponseBean.responseSuccess("职位删除成功!");
        }
        return ResponseBean.responseError("职位删除失败!");
    }
    @DeleteMapping("/")
    public ResponseBean deletePositionByIds(Integer[] ids)
    {
        if(positionService.deletePositionsByIds(ids)==ids.length)
        {
           return ResponseBean.responseSuccess("职位信息批量删除成功");
        }
        return ResponseBean.responseError("职位信息批量删除失败");
    }


}
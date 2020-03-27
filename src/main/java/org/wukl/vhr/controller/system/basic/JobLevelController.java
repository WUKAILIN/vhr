package org.wukl.vhr.controller.system.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.wukl.vhr.model.JobLevel;
import org.wukl.vhr.model.ResponseBean;
import org.wukl.vhr.service.JobLevelService;

import java.util.List;

@RestController
@RequestMapping("/sys/basic/jobLevel")
public class JobLevelController {
    @Autowired
    JobLevelService jobLevelService;
    @GetMapping("/")
    public List<JobLevel> getAllJobLevel()
    {
        return jobLevelService.queryAllJobLevel();
    }
    @PostMapping("/")
    public ResponseBean saveJobLevel(@RequestBody JobLevel jobLevel)
    {
        if(jobLevelService.addJobLevel(jobLevel)==1)
        {
            return ResponseBean.responseSuccess("职位信息添加成功");
        }
        return ResponseBean.responseError("职位信息添加失败");
    }
    @PutMapping("/")
    public ResponseBean updateJobLevel(@RequestBody JobLevel jobLevel)
    {
        if(jobLevelService.updateJobLevel(jobLevel)==1)
        {
            return ResponseBean.responseSuccess("职位信息更新成功");
        }
        return ResponseBean.responseError("职位信息更新失败");
    }
    @DeleteMapping("/{id}")
    public ResponseBean deleteJobLevelById(@PathVariable("id") Integer id)
    {
        if(jobLevelService.deleteJobLevel(id)==1)
        {
            return ResponseBean.responseSuccess("职位信息删除成功");
        }
        return ResponseBean.responseError("职位信息删除失败");
    }
    @DeleteMapping("/")
    public ResponseBean deleteJobLevelByIds(Integer[] ids)
    {
        if(jobLevelService.deleteJobLevelByIds(ids)==ids.length)
        {
            return ResponseBean.responseSuccess("职位信息批量删除成功");
        }
        return ResponseBean.responseError("职位信息批量删除失败");
    }
}

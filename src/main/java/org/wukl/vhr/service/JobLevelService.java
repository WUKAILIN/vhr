package org.wukl.vhr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wukl.vhr.mapper.JobLevelMapper;
import org.wukl.vhr.model.JobLevel;

import java.util.Date;
import java.util.List;

@Service
public class JobLevelService  {
    @Autowired
    JobLevelMapper jobLevelMapper;

    /**
     * 查询全部职位集合信息
     * @return 全部职位集合信息
     */
    public List<JobLevel> queryAllJobLevel()
    {
        return jobLevelMapper.queryAllJobLevel();
    }

    /**
     * 添加职位信息
     * @param jobLevel:职位信息
     * @return 受影响行数
     */
    public Integer addJobLevel(JobLevel jobLevel)
    {
        jobLevel.setCreateDate(new Date());
        jobLevel.setEnabled(true);
        return jobLevelMapper.insert(jobLevel);
    }

    /**
     * 更新职位信息
     * @param jobLevel:职位信息
     * @return 受影响行数
     */
    public Integer updateJobLevel(JobLevel jobLevel)
    {
        return jobLevelMapper.updateByPrimaryKeySelective(jobLevel);
    }

    /**
     * 根据职位标识删除职位信息
     * @param id:职位标识
     * @return 受影响行数
     */
    public Integer deleteJobLevel(Integer id)
    {
        return jobLevelMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据职位标识数组批量删除职位信息
     * @param ids:批量删除职位标识数组
     * @return 受影响行数
     */
    public Integer deleteJobLevelByIds(Integer[] ids)
    {
        return jobLevelMapper.deleteJobLevelByIds(ids);
    }
}

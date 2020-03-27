package org.wukl.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.wukl.vhr.model.JobLevel;

import java.util.List;

public interface JobLevelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JobLevel record);

    int insertSelective(JobLevel record);

    JobLevel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JobLevel record);

    int updateByPrimaryKey(JobLevel record);
    //查询全部角色职位
    List<JobLevel> queryAllJobLevel();
    //根据标识数组批量删除职位信息
    Integer deleteJobLevelByIds(@Param("ids") Integer[] ids);
}
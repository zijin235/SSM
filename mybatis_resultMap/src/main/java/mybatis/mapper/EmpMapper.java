package mybatis.mapper;

import mybatis.pojo.Dept;
import mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {
    Emp getEmpByEmpId(@Param("empId")Integer empId);
    Emp getEmpAndDeptByEmpId(@Param("empId")Integer empId);

    /**
     * 分布查询第一步
     * @param empId
     * @return
     */
    Emp getEmpAndDeptByStepOne(@Param("empId") Integer empId);
    /**
     * 分步查询第二步
     */
    List<Emp> getDeptAndEmpByStepTwo(@Param("deptId") Integer deptId);
}

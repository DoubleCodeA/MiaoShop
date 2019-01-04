package com.pinyougou.mapper;

import com.pinyougou.pojo.TbSpecificationOption;
import com.pinyougou.pojo.TbSpecificationOptionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbSpecificationOptionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_specification_option
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    int countByExample(TbSpecificationOptionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_specification_option
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    int deleteByExample(TbSpecificationOptionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_specification_option
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_specification_option
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    int insert(TbSpecificationOption record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_specification_option
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    int insertSelective(TbSpecificationOption record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_specification_option
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    List<TbSpecificationOption> selectByExample(TbSpecificationOptionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_specification_option
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    TbSpecificationOption selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_specification_option
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    int updateByExampleSelective(@Param("record") TbSpecificationOption record, @Param("example") TbSpecificationOptionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_specification_option
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    int updateByExample(@Param("record") TbSpecificationOption record, @Param("example") TbSpecificationOptionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_specification_option
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    int updateByPrimaryKeySelective(TbSpecificationOption record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_specification_option
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    int updateByPrimaryKey(TbSpecificationOption record);
}
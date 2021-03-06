package com.pinyougou.mapper;

import com.pinyougou.pojo.TbCities;
import com.pinyougou.pojo.TbCitiesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbCitiesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_cities
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    int countByExample(TbCitiesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_cities
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    int deleteByExample(TbCitiesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_cities
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_cities
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    int insert(TbCities record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_cities
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    int insertSelective(TbCities record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_cities
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    List<TbCities> selectByExample(TbCitiesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_cities
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    TbCities selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_cities
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    int updateByExampleSelective(@Param("record") TbCities record, @Param("example") TbCitiesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_cities
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    int updateByExample(@Param("record") TbCities record, @Param("example") TbCitiesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_cities
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    int updateByPrimaryKeySelective(TbCities record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_cities
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    int updateByPrimaryKey(TbCities record);
}
package com.pinyougou.pojo;

import java.io.Serializable;

public class TbCities implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_cities.id
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_cities.cityid
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    private String cityid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_cities.city
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    private String city;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_cities.provinceid
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    private String provinceid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_cities.id
     *
     * @return the value of tb_cities.id
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_cities.id
     *
     * @param id the value for tb_cities.id
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_cities.cityid
     *
     * @return the value of tb_cities.cityid
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    public String getCityid() {
        return cityid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_cities.cityid
     *
     * @param cityid the value for tb_cities.cityid
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    public void setCityid(String cityid) {
        this.cityid = cityid == null ? null : cityid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_cities.city
     *
     * @return the value of tb_cities.city
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    public String getCity() {
        return city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_cities.city
     *
     * @param city the value for tb_cities.city
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_cities.provinceid
     *
     * @return the value of tb_cities.provinceid
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    public String getProvinceid() {
        return provinceid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_cities.provinceid
     *
     * @param provinceid the value for tb_cities.provinceid
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    public void setProvinceid(String provinceid) {
        this.provinceid = provinceid == null ? null : provinceid.trim();
    }
}
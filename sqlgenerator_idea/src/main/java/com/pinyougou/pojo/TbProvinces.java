package com.pinyougou.pojo;

public class TbProvinces {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_provinces.id
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_provinces.provinceid
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    private String provinceid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_provinces.province
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    private String province;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_provinces.id
     *
     * @return the value of tb_provinces.id
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_provinces.id
     *
     * @param id the value for tb_provinces.id
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_provinces.provinceid
     *
     * @return the value of tb_provinces.provinceid
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    public String getProvinceid() {
        return provinceid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_provinces.provinceid
     *
     * @param provinceid the value for tb_provinces.provinceid
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    public void setProvinceid(String provinceid) {
        this.provinceid = provinceid == null ? null : provinceid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_provinces.province
     *
     * @return the value of tb_provinces.province
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    public String getProvince() {
        return province;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_provinces.province
     *
     * @param province the value for tb_provinces.province
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }
}
package com.pinyougou.pojo;

import java.io.Serializable;

public class TbTypeTemplate implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_type_template.id
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_type_template.name
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_type_template.spec_ids
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    private String specIds;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_type_template.brand_ids
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    private String brandIds;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_type_template.custom_attribute_items
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    private String customAttributeItems;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_type_template.id
     *
     * @return the value of tb_type_template.id
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_type_template.id
     *
     * @param id the value for tb_type_template.id
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_type_template.name
     *
     * @return the value of tb_type_template.name
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_type_template.name
     *
     * @param name the value for tb_type_template.name
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_type_template.spec_ids
     *
     * @return the value of tb_type_template.spec_ids
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    public String getSpecIds() {
        return specIds;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_type_template.spec_ids
     *
     * @param specIds the value for tb_type_template.spec_ids
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    public void setSpecIds(String specIds) {
        this.specIds = specIds == null ? null : specIds.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_type_template.brand_ids
     *
     * @return the value of tb_type_template.brand_ids
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    public String getBrandIds() {
        return brandIds;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_type_template.brand_ids
     *
     * @param brandIds the value for tb_type_template.brand_ids
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    public void setBrandIds(String brandIds) {
        this.brandIds = brandIds == null ? null : brandIds.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_type_template.custom_attribute_items
     *
     * @return the value of tb_type_template.custom_attribute_items
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    public String getCustomAttributeItems() {
        return customAttributeItems;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_type_template.custom_attribute_items
     *
     * @param customAttributeItems the value for tb_type_template.custom_attribute_items
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    public void setCustomAttributeItems(String customAttributeItems) {
        this.customAttributeItems = customAttributeItems == null ? null : customAttributeItems.trim();
    }
}
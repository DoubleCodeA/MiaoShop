package com.pinyougou.pojo;

public class TbContent {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_content.id
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_content.category_id
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    private Long categoryId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_content.title
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_content.url
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    private String url;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_content.pic
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    private String pic;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_content.status
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_content.sort_order
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    private Integer sortOrder;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_content.id
     *
     * @return the value of tb_content.id
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_content.id
     *
     * @param id the value for tb_content.id
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_content.category_id
     *
     * @return the value of tb_content.category_id
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_content.category_id
     *
     * @param categoryId the value for tb_content.category_id
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_content.title
     *
     * @return the value of tb_content.title
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_content.title
     *
     * @param title the value for tb_content.title
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_content.url
     *
     * @return the value of tb_content.url
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_content.url
     *
     * @param url the value for tb_content.url
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_content.pic
     *
     * @return the value of tb_content.pic
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    public String getPic() {
        return pic;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_content.pic
     *
     * @param pic the value for tb_content.pic
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_content.status
     *
     * @return the value of tb_content.status
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_content.status
     *
     * @param status the value for tb_content.status
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_content.sort_order
     *
     * @return the value of tb_content.sort_order
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    public Integer getSortOrder() {
        return sortOrder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_content.sort_order
     *
     * @param sortOrder the value for tb_content.sort_order
     *
     * @mbggenerated Mon Nov 26 17:05:24 CST 2018
     */
    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }
}
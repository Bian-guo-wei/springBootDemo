package com.example.demo.reading.model.po;

public class GuideReadingPo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column guide_reading.id
     *
     * @mbggenerated Wed Sep 25 10:21:17 CST 2019
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column guide_reading.guide_reading
     *
     * @mbggenerated Wed Sep 25 10:21:17 CST 2019
     */
    private String guideReading;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column guide_reading.id
     *
     * @return the value of guide_reading.id
     *
     * @mbggenerated Wed Sep 25 10:21:17 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column guide_reading.id
     *
     * @param id the value for guide_reading.id
     *
     * @mbggenerated Wed Sep 25 10:21:17 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column guide_reading.guide_reading
     *
     * @return the value of guide_reading.guide_reading
     *
     * @mbggenerated Wed Sep 25 10:21:17 CST 2019
     */
    public String getGuideReading() {
        return guideReading;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column guide_reading.guide_reading
     *
     * @param guideReading the value for guide_reading.guide_reading
     *
     * @mbggenerated Wed Sep 25 10:21:17 CST 2019
     */
    public void setGuideReading(String guideReading) {
        this.guideReading = guideReading == null ? null : guideReading.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guide_reading
     *
     * @mbggenerated Wed Sep 25 10:21:17 CST 2019
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", guideReading=").append(guideReading);
        sb.append("]");
        return sb.toString();
    }
}
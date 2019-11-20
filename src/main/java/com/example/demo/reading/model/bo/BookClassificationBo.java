package com.example.demo.reading.model.bo;

/**
 * @author admin
 */
public class BookClassificationBo {
    private String originBookClassificationId;
    private String parentBookClassificationId;
    private String bookClassificationId;
    private String firstBookClassificationName;
    private String secondBookClassificationName;
    private String thirdBookClassificationName;
    private Integer bookCounts;

    public String getOriginBookClassificationId() {
        return originBookClassificationId;
    }

    public void setOriginBookClassificationId(String originBookClassificationId) {
        this.originBookClassificationId = originBookClassificationId;
    }

    public String getFirstBookClassificationName() {
        return firstBookClassificationName;
    }

    public void setFirstBookClassificationName(String firstBookClassificationName) {
        this.firstBookClassificationName = firstBookClassificationName;
    }

    public String getSecondBookClassificationName() {
        return secondBookClassificationName;
    }

    public void setSecondBookClassificationName(String secondBookClassificationName) {
        this.secondBookClassificationName = secondBookClassificationName;
    }

    public String getThirdBookClassificationName() {
        return thirdBookClassificationName;
    }

    public void setThirdBookClassificationName(String thirdBookClassificationName) {
        this.thirdBookClassificationName = thirdBookClassificationName;
    }

    public Integer getBookCounts() {
        return bookCounts;
    }

    public void setBookCounts(Integer bookCounts) {
        this.bookCounts = bookCounts;
    }

    public String getParentBookClassificationId() {
        return parentBookClassificationId;
    }

    public void setParentBookClassificationId(String parentBookClassificationId) {
        this.parentBookClassificationId = parentBookClassificationId;
    }

    public String getBookClassificationId() {
        return bookClassificationId;
    }

    public void setBookClassificationId(String bookClassificationId) {
        this.bookClassificationId = bookClassificationId;
    }

    @Override
    public String toString() {
        return "BookClassificationBo{" +
                "originBookClassificationId='" + originBookClassificationId + '\'' +
                ", parentBookClassificationId='" + parentBookClassificationId + '\'' +
                ", bookClassificationId='" + bookClassificationId + '\'' +
                ", firstBookClassificationName='" + firstBookClassificationName + '\'' +
                ", secondBookClassificationName='" + secondBookClassificationName + '\'' +
                ", thirdBookClassificationName='" + thirdBookClassificationName + '\'' +
                ", bookCounts=" + bookCounts +
                '}';
    }
}

/*
*
* BookssayInfoMapperPo.java
* Copyright(C) 1993-2018 超星公司
* @date 2019-08-19
*/
package com.example.demo.reading.model.po;

import java.io.Serializable;

public class BookssayInfoMapperPo implements Serializable {
    /**
     *
     * 
     * 表字段 : book_essayinfo_mapper.id
     */
    private Integer id;

    /**
     *
     * 
     * 表字段 : book_essayinfo_mapper.resourceid
     */
    private String resourceid;

    /**
     *
     * 
     * 表字段 : book_essayinfo_mapper.uuid
     */
    private String uuid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResourceid() {
        return resourceid;
    }

    public void setResourceid(String resourceid) {
        this.resourceid = resourceid == null ? null : resourceid.trim();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", resourceid=").append(resourceid);
        sb.append(", uuid=").append(uuid);
        sb.append("]");
        return sb.toString();
    }
}
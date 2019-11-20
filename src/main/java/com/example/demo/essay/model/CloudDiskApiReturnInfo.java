package com.example.demo.essay.model;

public class CloudDiskApiReturnInfo {
    private String objectId;
    private String status;

    @Override
    public String toString() {
        return "CloudDiskApiReturnInfo{" +
                "objectId='" + objectId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

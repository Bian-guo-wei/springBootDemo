package com.example.demo.essay.model.bo;


import com.example.demo.essay.model.po.EssayInfoPo;

public class EssayInfoBo {

    /**
     * 征文大赛信息 po 类
     */
    private EssayInfoPo essayInfoPo;

    /**
     * 状态值名称
     */
    private String statusName;

    /**
     * 评选类型名称
     */
    private String approvalTypeName;

    @Override
    public String toString() {
        return "EssayInfoBo{" +
                "essayInfoPo=" + essayInfoPo +
                ", statusName='" + statusName + '\'' +
                ", approvalTypeName='" + approvalTypeName + '\'' +
                '}';
    }

    public EssayInfoPo getEssayInfoPo() {
        return essayInfoPo;
    }

    public void setEssayInfoPo(EssayInfoPo essayInfoPo) {
        this.essayInfoPo = essayInfoPo;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getApprovalTypeName() {
        return approvalTypeName;
    }

    public void setApprovalTypeName(String approvalTypeName) {
        this.approvalTypeName = approvalTypeName;
    }
}

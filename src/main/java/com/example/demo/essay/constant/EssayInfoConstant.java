package com.example.demo.essay.constant;

/**
 * 大赛信息常量
 *
 * @author ayne
 * @date 2018-06-19 14:52:34
 */
public class EssayInfoConstant {

    public static final String TABLE_NAME_DAYA_ESSAY = "essay_info";

    public static final String UUID_TIMESTAMP_SEPARATOR = "_";

    /**
     * 征文大赛状态枚举类
     */
    public enum EssayInfoStatusEnum {

        /**
         * 默认，已发布
         */
        PUBLISHED_0(0, "已创建"),
        WORKING_1(1, "正在进行"),
        ENDING_2(2, "已结束");

        private int status;
        private String info;

        @Override
        public String toString() {
            return "EssayInfoStatusEnum{" +
                    "status=" + status +
                    ", info='" + info + '\'' +
                    '}';
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        EssayInfoStatusEnum(int status, String info) {
            this.status = status;
            this.info = info;
        }

        public static EssayInfoStatusEnum getByValue(int value) throws NullPointerException {
            for (EssayInfoStatusEnum essayInfoStatusEnum : values()) {
                if (essayInfoStatusEnum.getStatus() == value) {
                    return essayInfoStatusEnum;
                }
            }
            throw new NullPointerException("未找到征文大赛状态类型id: " + value);
        }

        public static String getInfoByValue(int value) throws NullPointerException {
            String result = "";
            for (EssayInfoStatusEnum essayInfoStatusEnum : values()) {
                if (essayInfoStatusEnum.getStatus() == value) {
                    result = essayInfoStatusEnum.getInfo();
                }
            }
            return result;
        }
    }

    /**
     * 征文评分类型枚举类
     */
    public enum EssayInfoApprovalTypeEnum {

        /**
         * 老师评分再导出名单
         */
        SCORE(1, "线上评审"),

        /**
         * 作品无需评审，直接导入获奖名单
         */
        IMPORT(2, "线下评审"),
        /**
         * 这个是真的线下,不需要经过任何先上流程
         */
        TRULYOFFLINE(3, "无需评审");

        private int typeId;
        private String name;

        EssayInfoApprovalTypeEnum(int typeId, String name) {
            this.typeId = typeId;
            this.name = name;
        }

        public static String getNameByValue(int value) throws NullPointerException {
            String result = "";
            for (EssayInfoApprovalTypeEnum typeEnum : values()) {
                if (typeEnum.getTypeId() == value) {
                    result = typeEnum.getName();
                }
            }
            return result;
        }

        public static EssayInfoApprovalTypeEnum getByValue(int value) throws NullPointerException {
            for (EssayInfoApprovalTypeEnum typeEnum : values()) {
                if (typeEnum.getTypeId() == value) {
                    return typeEnum;
                }
            }
            throw new NullPointerException("EssayInfoApprovalTypeEnum -> 没有对应的枚举类， value = " + value);
        }

        @Override
        public String toString() {
            return "EssayInfoApprovalTypeEnum{" +
                    "typeId=" + typeId +
                    ", name='" + name + '\'' +
                    '}';
        }

        public int getTypeId() {
            return typeId;
        }

        public void setTypeId(int typeId) {
            this.typeId = typeId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}

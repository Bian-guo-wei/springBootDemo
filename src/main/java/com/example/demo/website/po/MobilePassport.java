package com.example.demo.website.po;

import com.dayainfo.lib.search.Builder;

/**
 * 学习通<i>用户信息</i>接口中的对象<br>
 * 使用工厂模式从接口对象中灵活设置对象
 *
 * @author gewu
 * @time 2017/3/20
 */
public class MobilePassport {
    private int uid = 0;
    private String realname;
    private int sex = 0;//默认0 - 女；1 - 男；-1 - 保密
    private String phone;
    private int copyRight = 0;
    private int dxfid = 0;
    private String email;
    private int industry = 0;//行业id，为1时生效
    private int isCertify = 0;
    private String nickname;
    private String openid1;
    private String openid2;
    private String openid3;
    private String openid4;
    private String openid5;
    private boolean result;
    private String roleid;//用户角色，1 - 老师；3 - 学生；7 - 单位管理员；8 - 联盟管理员。
    private int schoolid = 0;
    private String schoolname;
    private int status = 0;
    private long time;
    private String uname;

    public MobilePassport() {
    }

    public static class BeanBuilder implements Builder<MobilePassport> {
        //必须属性
        private int uid;
        private String realname;
        private int sex;
        private String phone;

        //可选属性，初始化默认值
        private int copyRight = 0;
        private int dxfid = 0;
        private String email = null;
        private int industry = 0;//行业id，为1时生效
        private int isCertify = 0;
        private String nickname = null;
        private String openid1 = null;
        private String openid2 = null;
        private String openid3 = null;
        private String openid4 = null;
        private String openid5 = null;
        private boolean result = Boolean.FALSE;
        private String roleid = null;//用户角色，1 - 老师；3 - 学生；7 - 单位管理员；8 - 联盟管理员。
        private int schoolid = 0;
        private String schoolname = null;
        private int status = 0;
        private long time = 0;
        private String uname = null;

        public BeanBuilder(int uid, String realname, int sex, String phone) {
            this.uid = uid;
            this.realname = realname;
            this.sex = sex;
            this.phone = phone;
        }

        public BeanBuilder copyRight(int val) {
            this.copyRight = val;
            return this;
        }

        public BeanBuilder dxfid(int val) {
            this.dxfid = val;
            return this;
        }

        public BeanBuilder email(String val) {
            this.email = val;
            return this;
        }

        public BeanBuilder industry(int val) {
            this.industry = val;
            return this;
        }

        public BeanBuilder isCertity(int val) {
            this.isCertify = val;
            return this;
        }

        public BeanBuilder nickname(String val) {
            this.nickname = val;
            return this;
        }

        public BeanBuilder openid1(String val) {
            this.openid1 = val;
            return this;
        }

        public BeanBuilder openid2(String val) {
            this.openid2 = val;
            return this;
        }

        public BeanBuilder openid3(String val) {
            this.openid3 = val;
            return this;
        }

        public BeanBuilder openid4(String val) {
            this.openid4 = val;
            return this;
        }

        public BeanBuilder openid5(String val) {
            this.openid5 = val;
            return this;
        }

        public BeanBuilder result(boolean val) {
            this.result = val;
            return this;
        }

        public BeanBuilder roleid(String val) {
            this.roleid = val;
            return this;
        }

        public BeanBuilder schoolid(int val) {
            this.schoolid = val;
            return this;
        }

        public BeanBuilder schoolname(String val) {
            this.schoolname = val;
            return this;
        }

        public BeanBuilder status(int val) {
            this.status = val;
            return this;
        }

        public BeanBuilder time(long val) {
            this.time = val;
            return this;
        }

        public BeanBuilder uname(String val) {
            this.uname = val;
            return this;
        }

        @Override
        public MobilePassport build() {
            return new MobilePassport(this);
        }
    }

    public MobilePassport(BeanBuilder BeanBuilder) {
        uid = BeanBuilder.uid;
        realname = BeanBuilder.realname;
        sex = BeanBuilder.sex;
        phone = BeanBuilder.phone;
        copyRight = BeanBuilder.copyRight;
        dxfid = BeanBuilder.dxfid;
        email = BeanBuilder.email;
        industry = BeanBuilder.industry;
        isCertify = BeanBuilder.isCertify;
        nickname = BeanBuilder.nickname;
        openid1 = BeanBuilder.openid1;
        openid2 = BeanBuilder.openid2;
        openid3 = BeanBuilder.openid3;
        openid4 = BeanBuilder.openid4;
        openid5 = BeanBuilder.openid5;
        result = BeanBuilder.result;
        roleid = BeanBuilder.roleid;
        schoolid = BeanBuilder.schoolid;
        schoolname = BeanBuilder.schoolname;
        status = BeanBuilder.status;
        time = BeanBuilder.time;
        uname = BeanBuilder.uname;
    }

    @Override
    public String toString() {
        return "MobilePassport{" +
                "uid=" + uid +
                ", realname='" + realname + '\'' +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                ", copyRight=" + copyRight +
                ", dxfid=" + dxfid +
                ", email='" + email + '\'' +
                ", industry=" + industry +
                ", isCertify=" + isCertify +
                ", nickname='" + nickname + '\'' +
                ", openid1='" + openid1 + '\'' +
                ", openid2='" + openid2 + '\'' +
                ", openid3='" + openid3 + '\'' +
                ", openid4='" + openid4 + '\'' +
                ", openid5='" + openid5 + '\'' +
                ", result=" + result +
                ", roleid='" + roleid + '\'' +
                ", schoolid=" + schoolid +
                ", schoolname='" + schoolname + '\'' +
                ", status=" + status +
                ", time=" + time +
                ", uname='" + uname + '\'' +
                '}';
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCopyRight() {
        return copyRight;
    }

    public void setCopyRight(int copyRight) {
        this.copyRight = copyRight;
    }

    public int getDxfid() {
        return dxfid;
    }

    public void setDxfid(int dxfid) {
        this.dxfid = dxfid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIndustry() {
        return industry;
    }

    public void setIndustry(int industry) {
        this.industry = industry;
    }

    public int getIsCertify() {
        return isCertify;
    }

    public void setIsCertify(int isCertify) {
        this.isCertify = isCertify;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getOpenid1() {
        return openid1;
    }

    public void setOpenid1(String openid1) {
        this.openid1 = openid1;
    }

    public String getOpenid2() {
        return openid2;
    }

    public void setOpenid2(String openid2) {
        this.openid2 = openid2;
    }

    public String getOpenid3() {
        return openid3;
    }

    public void setOpenid3(String openid3) {
        this.openid3 = openid3;
    }

    public String getOpenid4() {
        return openid4;
    }

    public void setOpenid4(String openid4) {
        this.openid4 = openid4;
    }

    public String getOpenid5() {
        return openid5;
    }

    public void setOpenid5(String openid5) {
        this.openid5 = openid5;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public int getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(int schoolid) {
        this.schoolid = schoolid;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
}

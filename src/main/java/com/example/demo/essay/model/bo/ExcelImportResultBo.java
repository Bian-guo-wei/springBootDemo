package com.example.demo.essay.model.bo;

import java.util.List;

public class ExcelImportResultBo {
    private List<String> echoUname;
    private List<String> errorUname;
    private Boolean result;

    @Override
    public String toString() {
        return "ExcelImportResultBo{" +
                "echoUname=" + echoUname +
                ", errorUname=" + errorUname +
                ", result=" + result +
                '}';
    }

    public List<String> getEchoUname() {
        return echoUname;
    }

    public void setEchoUname(List<String> echoUname) {
        this.echoUname = echoUname;
    }

    public List<String> getErrorUname() {
        return errorUname;
    }

    public void setErrorUname(List<String> errorUname) {
        this.errorUname = errorUname;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }
}

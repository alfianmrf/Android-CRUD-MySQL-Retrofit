package com.alfian.crudmysql.Model;

import java.util.List;

public class ResponseModel {
    private List<DataModel> data;

    public List<DataModel> getData() {
        return data;
    }

    public void setResult(List<DataModel> data) {
        this.data = data;
    }
}

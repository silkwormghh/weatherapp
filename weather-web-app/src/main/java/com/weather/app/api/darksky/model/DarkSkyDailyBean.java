package com.weather.app.api.darksky.model;

import java.io.Serializable;
import java.util.List;

public class DarkSkyDailyBean implements Serializable {


    private static final long serialVersionUID = 3711550651775964116L;
    private String summary;
    private String icon;
    private List<DarkSkyDataPointBean> data;
    
    
    public String getSummary() {
        return summary;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }
    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
    public List<DarkSkyDataPointBean> getData() {
        return data;
    }
    public void setData(List<DarkSkyDataPointBean> data) {
        this.data = data;
    }
    
    @Override
    public String toString() {
	return "DarkSkyDailyBean [summary=" + summary + ", icon=" + icon + ", data=" + data + "]";
    }
}

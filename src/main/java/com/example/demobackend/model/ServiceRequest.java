package com.example.demobackend.model;

public class ServiceRequest {
    private String service_req_no;
    private String short_description;
    private String current_status;
    private String long_description;
    private String sr_open_date;
    private String request_notes;
    private String sr_close_date;

    // Getters and setters

    public String getService_req_no() {
        return service_req_no;
    }

    public void setService_req_no(String service_req_no) {
        this.service_req_no = service_req_no;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public String getCurrent_status() {
        return current_status;
    }

    public void setCurrent_status(String current_status) {
        this.current_status = current_status;
    }

    public String getLong_description() {
        return long_description;
    }

    public void setLong_description(String long_description) {
        this.long_description = long_description;
    }

    public String getSr_open_date() {
        return sr_open_date;
    }

    public void setSr_open_date(String sr_open_date) {
        this.sr_open_date = sr_open_date;
    }

    public String getRequest_notes() {
        return request_notes;
    }

    public void setRequest_notes(String request_notes) {
        this.request_notes = request_notes;
    }

    public String getSr_close_date() {
        return sr_close_date;
    }

    public void setSr_close_date(String sr_close_date) {
        this.sr_close_date = sr_close_date;
    }
}
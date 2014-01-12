package com.sr.servicepoint.carrier.entity;

public class Carrier {

    private CarrierType carrierType;
    private String detail;

    public CarrierType getCarrierType() {
        return carrierType;
    }

    public void setCarrierType(CarrierType carrierType) {
        this.carrierType = carrierType;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Carrier(CarrierType carrierType, String detail){
        this.carrierType = carrierType;
        this.detail = detail;
    }

}
package com.company;

import java.util.Objects;

public class RichUserInfo {
    private User baseUserInfo;
    private String address;
    private String city;

    public RichUserInfo(User baseUserInfo, String address, String city) {
        this.baseUserInfo = baseUserInfo;
        this.address = address;
        this.city = city;
    }

    @Override
    public String toString() {
        return "RichUserInfo{" +
                "baseUserInfo=" + baseUserInfo +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RichUserInfo that = (RichUserInfo) o;
        return Objects.equals(baseUserInfo, that.baseUserInfo) &&
                Objects.equals(address, that.address) &&
                Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {

        return Objects.hash(baseUserInfo, address, city);
    }

    public User getBaseUserInfo() {
        return baseUserInfo;
    }

    public void setBaseUserInfo(User baseUserInfo) {
        this.baseUserInfo = baseUserInfo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

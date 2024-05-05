package sanghun;

import java.util.Objects;

public class Address {
    private String state; // 서울특별시
    private String addresslinefirst; // 영등포구
    private String addresslinesecond; // 동
    private String optical; // 상세주소

    public Address(String state, String addresslinefirst, String addresslinesecond, String optical) {
        this.state = state;
        this.addresslinefirst = addresslinefirst;
        this.addresslinesecond = addresslinesecond;
        this.optical = optical;
    }

    public String getState() {
        return state;
    }

    public String getAddresslinefirst() {
        return addresslinefirst;
    }

    public String getAddresslinesecond() {
        return addresslinesecond;
    }

    public String getOptical() {
        return optical;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setAddresslinefirst(String addresslinefirst) {
        this.addresslinefirst = addresslinefirst;
    }

    public void setAddresslinesecond(String addresslinesecond) {
        this.addresslinesecond = addresslinesecond;
    }

    public void setOptical(String optical) {
        this.optical = optical;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(state, address.state) && Objects.equals(addresslinefirst, address.addresslinefirst) && Objects.equals(addresslinesecond, address.addresslinesecond) && Objects.equals(optical, address.optical);
    }

    @Override
    public int hashCode() {
        return Objects.hash(state, addresslinefirst, addresslinesecond, optical);
    }

    @Override
    public String toString() {
        return state + "-" + addresslinefirst + "-" + addresslinesecond +"-" + optical;
    }
}

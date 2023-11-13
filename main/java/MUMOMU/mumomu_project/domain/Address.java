package MUMOMU.mumomu_project.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class Address {
    private String city;
    private String street;
    private String zipcode;
    private String detail;

    protected Address(){
    }

    public Address(String city, String street, String zipcode, String detail ){
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
        this.detail = detail;
    }
}

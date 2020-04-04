package application.entities;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
@Getter
@Setter
@ToString
public class Address {

    private String addressLineOne;
    private String addressLineTwo;
    private String city;
    private String country;

    public Address(
            final String addressLineOne,
            final String addressLineTwo,
            final String city,
            final String country) {
        this.addressLineOne = addressLineOne;
        this.addressLineTwo = addressLineTwo;
        this.city = city;
        this.country = country;
    }

    public void setCountry(String us) {
    }
}
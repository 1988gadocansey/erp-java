package application.entities;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
@Getter
@Setter
@ToString
public class Hobby {

    private String name;

    public Hobby(final String name) {
        this.name = name;
    }
}
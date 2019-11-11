package application.entities;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.TypeAlias;

import javax.validation.constraints.NotEmpty;


import java.util.*;
/**
 * @author Gad Ocansey
 * @version 1.0
 */
@Document(collection = "colleges")
@Data
@TypeAlias("college")
public class College extends BaseEntity{

    @NotEmpty(message = "This field is required")
    @Indexed(name="collegeName", unique=true)
    private String name;

    @NotEmpty(message = "This field is required")
    @Indexed(name="collegeCode", unique=true)
    private  String code;

    public College(@NotEmpty(message = "This field is required") String name, @NotEmpty(message = "This field is required") String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}

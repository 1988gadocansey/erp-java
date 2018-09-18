package application.Entities;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.TypeAlias;

import javax.validation.constraints.NotEmpty;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Email;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Past;
import java.util.Date;
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

    private  List<Department> departments;




}

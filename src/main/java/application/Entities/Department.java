package application.Entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
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
@Document(collection = "departments")
@Data
@TypeAlias("department")
public class Department extends BaseEntity{

    @NotEmpty(message = "Department name is required")
    @Indexed(name="departmentName", unique=true)
    private String name;

    @NotEmpty(message = "Department is required")
    @Indexed(name="departmentCode", unique=true)
    private  String code;

    @DBRef
    @Field("college")
    private College college;


}

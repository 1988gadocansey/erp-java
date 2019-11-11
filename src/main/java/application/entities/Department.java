package application.entities;

import lombok.Data;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
import javax.validation.constraints.NotEmpty;

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

    public Department(@NotEmpty(message = "Department name is required") String name, @NotEmpty(message = "Department is required") String code, College college_id) {
        this.name = name;
        this.code = code;
        this.college_id = college_id;
    }

    @NotEmpty(message = "Department is required")
    @Indexed(name="departmentCode", unique=true)
    private  String code;

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

    public College getCollege_id() {
        return college_id;
    }

    public void setCollege_id(College college_id) {
        this.college_id = college_id;
    }

    @DBRef
    @Field("college")
    private College college_id;



}

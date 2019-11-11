package application.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;

import java.util.Date;

/**
 * @author Gad Ocansey
 */
@Document(collection = "students")

public class Student extends BaseEntity{
    @Id
    private Long id;

    @NotEmpty(message = "This field is required")
    private String firstName;

    @NotEmpty(message = "This field is required")
    private String lastName;

    private  String otherName;

    private String name;

    private Date dob;

    private int age;

    private  char gender;

    private  String level;

    private int year;

   /* @DBRef
    private Programme programme;*/

    private String phone;



    @Indexed
    @NotEmpty(message = "This field is required")
    private String email;

    public Student() {}



}


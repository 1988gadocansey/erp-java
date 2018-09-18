package application.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Email;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Past;
import java.util.Date;
import java.util.*;
/**
 * @author Gad Ocansey
 */
@Document
public class Student {
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


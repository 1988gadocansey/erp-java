package application.Entities;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
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
@Document(collection = "programmes")
@Data
@TypeAlias("programme")
public class Programme extends BaseEntity{

    @NotEmpty(message = "The programme name is required")
    @Indexed(name="programmeName", unique=true)
    private String name;

    @NotEmpty(message = "The programme code is required")
    @Indexed(name="programmeCode", unique=true)
    private  String code;

    @DBRef
    //private  ProgrammeOption programmeOption;

    private int minimumCredit;

    private  int maximumCredit;

    private  int affiliation;

    private  int duration;

    private  int gradingSystem;

    private  String type;

    private  int running;

    private  int showPortal;

    private  int slug;



}

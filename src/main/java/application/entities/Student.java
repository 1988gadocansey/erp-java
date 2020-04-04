package application.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString(exclude = { "id", "dateOfBirth" })
@Document(collection = "students")
public class Student {

	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String otherName;
	private String indexNo;
	private String phone;
	private String email;
	private int stno;
	private char gender;
	private char year;
	private String maritalStatus;
	private String hometown;
	private LocalDateTime dateOfBirth;
	private LocalDateTime dateAdmitted;
	private Address address;
	private List<Programme> programme;
	private List<Region> region;
	private List<Religion> religion;
	private List<Country>  country;
	private Boolean trail;
	private String graduatingGroup;
	private float cgpa;
	private String classObtained;
	private Boolean  industrialAttachment;
	private Boolean  qualityAssurance;
	private Boolean protocol;
	private String season;
	private String disability;
	private String cohort;
	private int entryGrade;
	private  String entryQualificationOne;
	private  String entryQualificationTwo;
	private List<School>  formerSchool;
	private List<Hall>  hall;
	private  String guardianName;
	private  String guardianAddress;
	private  String guardianContact;
	private  String guardianOccupation;
	private  String yearOfAdmission;
	private  Boolean residentialStatus;
	private String entryMode;  // mature,regular,access
	private  float bills;
	private float paid;
	private float outstandings;


	 
}
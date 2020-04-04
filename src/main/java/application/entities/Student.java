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
	private LocalDateTime dateOfBirth;
	private LocalDateTime dateAdmitted;
	private Address address;
	private List<Programme> programme;
	private List<Region> region;
	private List<Religion> religion;
	private List<Status>  status;
	private List<Country>  country;
	private Boolean trail;
	private String graduatingGroup;
	private float cgpa;
	private String class_obtained;
	private Boolean  industrialAttachment;
	private Boolean  qualityAssurance;
	private Boolean protocol;
	private String season;
	private String cohort;

	 
}
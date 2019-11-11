package application.entities;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.TypeAlias;

import javax.validation.constraints.NotEmpty;

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


    private int minimumCredit;

    private  int maximumCredit;

    public Programme(@NotEmpty(message = "The programme name is required") String name, @NotEmpty(message = "The programme code is required") String code, int minimumCredit, int maximumCredit, int affiliation, int duration, int gradingSystem, String type, int running, int showPortal, int slug, Department department_id) {
        this.name = name;
        this.code = code;
        this.minimumCredit = minimumCredit;
        this.maximumCredit = maximumCredit;
        this.affiliation = affiliation;
        this.duration = duration;
        this.gradingSystem = gradingSystem;
        this.type = type;
        this.running = running;
        this.showPortal = showPortal;
        this.slug = slug;
        this.department_id = department_id;
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

    public int getMinimumCredit() {
        return minimumCredit;
    }

    public void setMinimumCredit(int minimumCredit) {
        this.minimumCredit = minimumCredit;
    }

    public int getMaximumCredit() {
        return maximumCredit;
    }

    public void setMaximumCredit(int maximumCredit) {
        this.maximumCredit = maximumCredit;
    }

    public int getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(int affiliation) {
        this.affiliation = affiliation;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getGradingSystem() {
        return gradingSystem;
    }

    public void setGradingSystem(int gradingSystem) {
        this.gradingSystem = gradingSystem;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRunning() {
        return running;
    }

    public void setRunning(int running) {
        this.running = running;
    }

    public int getShowPortal() {
        return showPortal;
    }

    public void setShowPortal(int showPortal) {
        this.showPortal = showPortal;
    }

    public int getSlug() {
        return slug;
    }

    public void setSlug(int slug) {
        this.slug = slug;
    }

    public Department getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Department department_id) {
        this.department_id = department_id;
    }

    private  int affiliation;

    private  int duration;

    private  int gradingSystem;

    private  String type;

    private  int running;

    private  int showPortal;

    private  int slug;

    @DBRef
    private Department department_id;




}

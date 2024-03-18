package pc.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import java.util.Set;
/**
 * Entity class representing a reviewer.
 */
@Entity
@Table(name = "reviewers")
public class Reviewer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reviewer_id")
    private Long id;

    private String Name;
    private String Email;
    private String expertise;
    private String Mobile;
    private String PapersCount;

    
    @ManyToMany
    @JoinTable(
        name = "reviewer_paper",
        joinColumns = @JoinColumn(name = "reviewer_id"),
        inverseJoinColumns = @JoinColumn(name = "paper_id")
    )
    private Set<Paper> papers;

    /**
     * Gets the name of the reviewer.
     *
     * @return The name of the reviewer.
     */
    public String getName() {
        return Name;
    }

    /**
     * Sets the name of the reviewer.
     *
     * @param name The name of the reviewer.
     */
    public void setName(String name) {
        Name = name;
    }

    /**
     * Gets the email of the reviewer.
     *
     * @return The email of the reviewer.
     */
    public String getEmail() {
        return Email;
    }

    /**
     * Sets the email of the reviewer.
     *
     * @param email The email of the reviewer.
     */
    public void setEmail(String email) {
        Email = email;
    }

    

    /**
     * Gets the mobile number of the reviewer.
     *
     * @return The mobile number of the reviewer.
     */
    public String getMobile() {
        return Mobile;
    }

    /**
     * Sets the mobile number of the reviewer.
     *
     * @param mobile The mobile number of the reviewer.
     */
    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    /**
     * Gets the unique identifier (ID) of the reviewer.
     *
     * @return The ID of the reviewer.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier (ID) of the reviewer.
     *
     * @param id The ID of the reviewer.
     */
    public void setId(Long id) {
        this.id = id;
    }

	public String getPapersCount() {
		return PapersCount;
	}

	public void setPapersCount(String papersCount) {
		PapersCount = papersCount;
	}

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		expertise = expertise;
	}

    // Constructors, getters, and setters
}

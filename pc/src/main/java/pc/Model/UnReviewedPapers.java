package pc.Model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name ="UnreviewedPapers")
public class UnReviewedPapers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="paper_id")
    private Long id;

    private String title;
    private String author;
    private String abstractContent;

    // Constructors, getters, and setters

    public UnReviewedPapers() {
    }

    public UnReviewedPapers(String title, String author, String abstractContent) {
        this.title = title;
        this.author = author;
        this.abstractContent = abstractContent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAbstractContent() {
        return abstractContent;
    }

    public void setAbstractContent(String abstractContent) {
        this.abstractContent = abstractContent;
    }
}


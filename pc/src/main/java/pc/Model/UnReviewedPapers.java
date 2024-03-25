package pc.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UnReviewedPapers {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;

	    private String title;
	    private String author;
	    private String authorEmail;
		private String abstractContent;
	    private String assignedReviewer;
	    
	    public UnReviewedPapers() {
	    }

	   

	    public UnReviewedPapers(Long id, String title, String author, String abstractContent, String assignedReviewer) {
			super();
			this.id = id;
			this.title = title;
			this.author = author;
			this.abstractContent = abstractContent;
			this.assignedReviewer = assignedReviewer;
		}

		@Override
		public String toString() {
			return "UnReviewedPapers [id=" + id + ", title=" + title + ", author=" + author + ", abstractContent="
					+ abstractContent + ", assignedReviewer=" + assignedReviewer + "]";
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

	    public String getAssignedReviewer() {
	        return assignedReviewer;
	    }

	    public void setAssignedReviewer(String assignedReviewer) {
	        this.assignedReviewer = assignedReviewer;
	    }
	    public String getAuthorEmail() {
				return authorEmail;
			}



			public void setAuthorEmail(String authorEmail) {
				this.authorEmail = authorEmail;
			}

}

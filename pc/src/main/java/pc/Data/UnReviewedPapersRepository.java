package pc.Data;

import org.springframework.data.jpa.repository.JpaRepository;

import pc.Model.UnReviewedPapers;

public interface UnReviewedPapersRepository extends JpaRepository<UnReviewedPapers, Long>{
	Paper findByTitleAndAuthor(String title, String author);
}

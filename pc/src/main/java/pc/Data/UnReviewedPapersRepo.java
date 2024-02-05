package pc.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pc.Model.UnReviewedPapers;

public interface UnReviewedPapersRepo extends JpaRepository<UnReviewedPapers, Long>{

}


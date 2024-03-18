package pc.Data;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pc.Model.Paper;

@Repository
public interface PaperRepository extends JpaRepository<Paper, Long> {
    // Add custom query methods if needed
	
	
	 List<Paper> findByStatus(String status);
	 Paper findByTitleAndAuthor(String title, String author);
}

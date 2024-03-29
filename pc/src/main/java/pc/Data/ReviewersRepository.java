package pc.Data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pc.Model.Reviewer;

/**
 * Repository interface for managing Reviewer entities.
 */
@Repository
public interface ReviewersRepository extends JpaRepository<Reviewer, Long> {
    // Additional methods can be added if needed
	List<Reviewer> findByExpertise(String expertise);

}

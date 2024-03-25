package pc.Data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pc.Model.User;
import pc.Model.ResetToken;

@Repository
public interface ResetTokenRepository extends JpaRepository<ResetToken, Long> {
    ResetToken findByToken(String token);
}

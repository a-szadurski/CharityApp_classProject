package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.model.Donation;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query("SELECT SUM(d.quantity) FROM Donation d")
    Integer quantityTotal();

    @Query("SELECT COUNT(d.id) FROM Donation d")
    Integer donationsDeliveredCount();

    /*Czy dary na liście są posortowane wg:
    1) statusu odebrane/nieodebrane,
    2) daty odebrania (jeśli odebrane) i
    3) daty utworzenia wpisu?
     */
    @Query("SELECT d FROM Donation d WHERE d.user.id=?1 ORDER BY d.pickupStatus ASC, d.pickupDate DESC, d.entryDate DESC")
    List<Donation> findAllByUserPickupStatusAscPickupDateDescEntryDateDesc(Long id);

    @Query("SELECT d FROM Donation d WHERE d.id=?1 AND d.user.id=?2")
    Donation findByIdAndUser(Long donationId, Long userId);

    @Transactional
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("UPDATE Donation d SET d.pickupStatusDate = ?1, d.pickupStatus = true WHERE d.id=?2")
    void updatePickupStatus(LocalDate date, Long id);

}

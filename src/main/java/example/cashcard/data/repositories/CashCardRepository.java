package example.cashcard.data.repositories;

import example.cashcard.data.models.CashCard;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CashCardRepository extends JpaRepository<CashCard, Long> {

}

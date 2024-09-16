package example.cashcard.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CashCard {
    @Id
    private Long id;

    public CashCard(long l, double v) {
    }

    public CashCard() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

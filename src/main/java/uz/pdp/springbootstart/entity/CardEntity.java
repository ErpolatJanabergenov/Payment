package uz.pdp.springbootstart.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "card")
@AllArgsConstructor
@NoArgsConstructor

@Data
public class CardEntity extends BaseEntity {

    @Column(unique = true,nullable = false)
    private String number;
    private Double balance;
    private Boolean active = true;
    @ManyToOne
    private UserEntity user;

}

package uz.pdp.springbootstart.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "transaction")
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class TransactionEntity extends BaseEntity {

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private CardEntity sender;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private CardEntity receiver;

    private Double amount;

}

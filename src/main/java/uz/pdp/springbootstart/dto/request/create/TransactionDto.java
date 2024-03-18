package uz.pdp.springbootstart.dto.request.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.springbootstart.entity.CardEntity;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransactionDto {

    private CardEntity sender;
    private CardEntity receiver;
    private Double amount;
}

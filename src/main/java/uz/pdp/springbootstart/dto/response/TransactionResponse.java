package uz.pdp.springbootstart.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.springbootstart.dto.BaseDto;
import uz.pdp.springbootstart.entity.CardEntity;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TransactionResponse extends BaseDto {
    private String sender;
    private String receiver;
    private Double amount;
}

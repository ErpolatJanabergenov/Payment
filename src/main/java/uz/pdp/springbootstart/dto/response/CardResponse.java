package uz.pdp.springbootstart.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.springbootstart.dto.BaseDto;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CardResponse extends BaseDto {
   private String number;
   private Double balance;

}

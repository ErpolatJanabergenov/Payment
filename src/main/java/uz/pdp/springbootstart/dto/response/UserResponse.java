package uz.pdp.springbootstart.dto.response;

import lombok.*;
import uz.pdp.springbootstart.dto.BaseDto;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponse extends BaseDto {
    private String name;
    private String username;


}

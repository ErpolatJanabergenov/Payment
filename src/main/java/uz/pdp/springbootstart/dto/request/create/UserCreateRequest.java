package uz.pdp.springbootstart.dto.request.create;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserCreateRequest {
    private String name;
    @NotBlank(message = "username can not be empty or blank")
    private String username;
    @NotBlank(message = "password can not be empty or blank")
    @Min(value = 8,message = "password length should be at least 8")
//    @Pattern(regexp = "//{10}")
    private String password;

}

package uz.pdp.springbootstart.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class BaseDto {
    private UUID id;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}

package uz.pdp.springbootstart.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseEntity {
    @Id
    @GeneratedValue
    protected UUID id;
    @CreationTimestamp
    protected LocalDateTime createdDate;
    @UpdateTimestamp
    protected LocalDateTime updatedDate;
}

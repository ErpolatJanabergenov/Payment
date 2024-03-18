package uz.pdp.springbootstart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.springbootstart.entity.TransactionEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, UUID> {

  List<TransactionEntity> findTransactionEntitiesByCreatedDateBetween(LocalDateTime start, LocalDateTime last);

}

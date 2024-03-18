package uz.pdp.springbootstart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.springbootstart.dto.response.CardResponse;
import uz.pdp.springbootstart.entity.CardEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CardRepository extends JpaRepository<CardEntity, UUID> {

    List<CardResponse> findCardEntityByActive(Boolean active);
    void deleteById(UUID id);

    Optional<CardEntity> findCardEntityByNumber(String number);
}

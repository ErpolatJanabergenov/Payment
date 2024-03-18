package uz.pdp.springbootstart.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.pdp.springbootstart.dto.request.create.TransactionDto;
import uz.pdp.springbootstart.dto.response.TransactionResponse;
import uz.pdp.springbootstart.entity.CardEntity;
import uz.pdp.springbootstart.entity.TransactionEntity;
import uz.pdp.springbootstart.repository.CardRepository;
import uz.pdp.springbootstart.repository.TransactionRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final CardRepository cardRepository;
    private final ModelMapper modelMapper;

    public Optional<String> transaction(TransactionDto transactionDto) {

        TransactionEntity transaction = modelMapper.map(transactionDto, TransactionEntity.class);

        Double amount = transaction.getAmount();

        Optional<CardEntity> senderCard = cardRepository.findCardEntityByNumber(transactionDto.getSender().getNumber());
        Optional<CardEntity> receiverCard = cardRepository.findCardEntityByNumber(transactionDto.getReceiver().getNumber());

        if (receiverCard.isPresent() && senderCard.isPresent()) {
            receiverCard.get().setBalance(receiverCard.get().getBalance() + amount);
            senderCard.get().setBalance(senderCard.get().getBalance() - amount);

            transaction.setSender(senderCard.get());
            transaction.setReceiver(receiverCard.get());
            cardRepository.save(senderCard.get());
            cardRepository.save(receiverCard.get());
            transactionRepository.save(transaction);
        } else {
            return Optional.of("Bunaqa karta topilmadi");
        }
        return Optional.of("Success");

    }

    public List<TransactionResponse> findCardTransaction(UUID cardId) {
        List<TransactionEntity> transactionEntities = transactionRepository.findAll();

        if (transactionEntities.isEmpty()) {
            return new ArrayList<>();
        }

        List<TransactionEntity> transactionEntities1 = new ArrayList<>();
        for (TransactionEntity transactionEntity : transactionEntities) {
            if (Objects.equals(transactionEntity.getSender().getId(),cardId)
            || Objects.equals(transactionEntity.getReceiver().getId(),cardId)) {
                transactionEntities1.add(transactionEntity);
            }
        }

        return getTransactionResponses(transactionEntities1);
    }

    private static List<TransactionResponse> getTransactionResponses(List<TransactionEntity> transactionEntities1) {
        List<TransactionResponse > response = new ArrayList<>();
        for (TransactionEntity transactionEntity : transactionEntities1) {
            TransactionResponse response1 = TransactionResponse.builder()
                    .sender(transactionEntity.getSender().getNumber())
                    .receiver(transactionEntity.getReceiver().getNumber())
                    .amount(transactionEntity.getAmount())
                    .build();
            response1.setId(transactionEntity.getId());
            response1.setCreatedDate(transactionEntity.getCreatedDate());
            response1.setUpdatedDate(transactionEntity.getUpdatedDate());
            response.add(response1);
        }
        return response;
    }


    public List<TransactionResponse> findInPeriod(LocalDateTime startTime, LocalDateTime lastTime) {
        List<TransactionEntity> transactionEntitiesByCreatedDateBetween =
                      transactionRepository.
                        findTransactionEntitiesByCreatedDateBetween(startTime, lastTime);
        return getTransactionResponses(transactionEntitiesByCreatedDateBetween);
    }
}
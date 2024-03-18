package uz.pdp.springbootstart.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.pdp.springbootstart.dto.request.create.CardDto;
import uz.pdp.springbootstart.dto.response.CardResponse;
import uz.pdp.springbootstart.entity.CardEntity;
import uz.pdp.springbootstart.repository.CardRepository;
import uz.pdp.springbootstart.repository.TransactionRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardService {

    private final ModelMapper modelMapper;
    private final CardRepository cardRepository;
    private final TransactionRepository transactionRepository;


    public CardResponse createCard(CardDto cardDto) {
        CardEntity card = modelMapper.map(cardDto, CardEntity.class);
        cardRepository.save(card);

        return modelMapper.map(card,CardResponse.class);
    }

    public List<CardResponse> readAllCards(Boolean active) {
        return cardRepository.findCardEntityByActive(active);
    }

    public void deleteCard(UUID id) {
        cardRepository.deleteById(id);
    }



}

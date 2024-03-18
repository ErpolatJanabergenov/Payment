package uz.pdp.springbootstart.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootstart.dto.request.create.CardDto;
import uz.pdp.springbootstart.dto.response.CardResponse;
import uz.pdp.springbootstart.service.CardService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class CardController {

   private final CardService cardService;


    @PostMapping("/create")
    public CardResponse create(@RequestBody CardDto cardDto) {
        return cardService.createCard(cardDto);
    }

    @GetMapping("/read")
    public List<CardResponse> read(@RequestParam Boolean a) {
        return cardService.readAllCards(a);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable UUID id) {
        cardService.deleteCard(id);
    }



}

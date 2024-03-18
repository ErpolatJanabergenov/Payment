package uz.pdp.springbootstart.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootstart.dto.request.create.TransactionDto;
import uz.pdp.springbootstart.dto.response.TransactionResponse;
import uz.pdp.springbootstart.service.TransactionService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService transactionService;


    @PostMapping
    public Optional<String> transaction(@RequestBody TransactionDto transactionDto) {
        return transactionService.transaction(transactionDto);
    }

    @GetMapping("/{id}")
    public List<TransactionResponse> findCardTransaction(@PathVariable UUID id) {
        return transactionService.findCardTransaction(id);
    }

    @GetMapping("/period")
    public List<TransactionResponse> findInPeriod(@RequestParam String startTime, @RequestParam String lastTime) {
        LocalDateTime start = LocalDateTime.parse(startTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime end = LocalDateTime.parse(lastTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return transactionService.findInPeriod(start,end);
    }


}

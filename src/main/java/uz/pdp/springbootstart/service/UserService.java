package uz.pdp.springbootstart.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.pdp.springbootstart.dto.request.AuthDto;
import uz.pdp.springbootstart.dto.request.create.CardDto;
import uz.pdp.springbootstart.dto.response.CardResponse;
import uz.pdp.springbootstart.dto.response.UserResponse;
import uz.pdp.springbootstart.dto.request.create.UserCreateRequest;
import uz.pdp.springbootstart.entity.CardEntity;
import uz.pdp.springbootstart.entity.UserEntity;
import uz.pdp.springbootstart.exception.QovunAuthException;
import uz.pdp.springbootstart.repository.CardRepository;
import uz.pdp.springbootstart.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CardRepository cardRepository;

    public UserResponse create(UserCreateRequest userCreateRequest) {
        UserEntity userEntity = modelMapper.map(userCreateRequest, UserEntity.class);
        userRepository.save(userEntity);
        return modelMapper.map(userEntity, UserResponse.class);
    }

    public UserResponse signIn(AuthDto authDto) {
        UserEntity userEntity = userRepository.findUserEntityByUsername(authDto.getUsername())
                .orElseThrow(() -> new QovunAuthException("User not found"));
        if (userEntity.getPassword().equals(authDto.getPassword())) {
            return modelMapper.map(userEntity, UserResponse.class);
        }

        throw new QovunAuthException("password didn't match");
    }


}

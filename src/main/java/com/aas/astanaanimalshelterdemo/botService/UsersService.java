package com.aas.astanaanimalshelterdemo.botService;

import com.aas.astanaanimalshelterdemo.botModel.Users;
import com.aas.astanaanimalshelterdemo.botRepositories.CatUsersRepository;
import com.aas.astanaanimalshelterdemo.botRepositories.DogUsersRepository;
import com.aas.astanaanimalshelterdemo.botRepositories.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsersService {
    private final UsersRepository usersRepository;
    private final DogUsersRepository dogUsersRepository;
    private final CatUsersRepository catUsersRepository;

    public UsersService(UsersRepository usersRepository,
                        DogUsersRepository dogUsersRepository,
                        CatUsersRepository catUsersRepository) {
        this.usersRepository = usersRepository;
        this.dogUsersRepository = dogUsersRepository;
        this.catUsersRepository = catUsersRepository;
    }

    public Users save(Users user) {
        return usersRepository.save(user);
    }

    public void delete(Users user) {
        usersRepository.delete(user);
    }

    public Optional<Users> getUsersByChatId(Long chatId) {
        return usersRepository.findUsersByChatId(chatId);
    }

    public List<Users> getUsersWithPet() {
        List<Long> ids = dogUsersRepository.findAllIdWithPet();
        ids.addAll(catUsersRepository.findAllIdWithPet());
        return ids.stream().map(id -> usersRepository.findById(id).get()).toList();
    }
}
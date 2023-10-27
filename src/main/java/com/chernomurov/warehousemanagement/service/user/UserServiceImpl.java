package com.chernomurov.warehousemanagement.service.user;

import com.chernomurov.warehousemanagement.custom.http.DTO.UserRoleDto;
import com.chernomurov.warehousemanagement.custom.http.request.UserRequest;
import com.chernomurov.warehousemanagement.entity.User;
import com.chernomurov.warehousemanagement.entity.UserRole;
import com.chernomurov.warehousemanagement.repository.UserRepository;
import com.chernomurov.warehousemanagement.repository.UserRoleRepository;
import com.chernomurov.warehousemanagement.util.ValidationUtils;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    @Override
    public User createUser(UserRequest request) {
        User user = getUserFromRequest(null, request);
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Пользователь с id " + id + " не найден, действие отменено."));
    }

    @Override
    public User updateUser(Long id, UserRequest request) {
        User user = getUserFromRequest(id, request);

        if (userRepository.existsById(id)){
            return userRepository.save(user);
        }
        else {
            throw new  EntityNotFoundException("Пользователь с id " + id + " не найден, действие отменено.");
        }
    }

    @Override
    public void deleteUserById(Long id) {
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
        }
        else {
            throw new  EntityNotFoundException("Пользователь с id " + id + " не найден, действие отменено.");
        }
    }

    private User getUserFromRequest(Long id, UserRequest request) {
        List<String> fieldNamesToValidate = new ArrayList<>();
        fieldNamesToValidate.add("name");
        fieldNamesToValidate.add("surname");
        fieldNamesToValidate.add("password");
        ValidationUtils.validateRequest(request, fieldNamesToValidate);

        Set<UserRole> userRoles = new HashSet<>();
        for (UserRoleDto e : request.userRoles()) {
            UserRole userRole = userRoleRepository.findById(e.id())
                    .orElseThrow(() -> new EntityNotFoundException("Роль пользователя с id " + e.id() + " не найдено, действие отменено."));
            userRoles.add(userRole);
        }

        return User.builder()
                .id(id)
                .name(request.name())
                .surname(request.surname())
                .patronymic(request.patronymic())
                .password(request.password())
                .userRoles(userRoles)
                .build();
    }
}

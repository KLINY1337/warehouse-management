package com.chernomurov.warehousemanagement.service.user_role;

import com.chernomurov.warehousemanagement.custom.http.request.UserRoleRequest;
import com.chernomurov.warehousemanagement.entity.UserRole;
import com.chernomurov.warehousemanagement.repository.UserRoleRepository;
import com.chernomurov.warehousemanagement.util.RequestUtils;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    @Override
    public UserRole createUserRole(UserRoleRequest request) {
        UserRole userRole = getUserRoleFromRequest(null, request);
        return userRoleRepository.save(userRole);
    }

    @Override
    public UserRole getUserRoleById(Long id) {
        return userRoleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Роль пользователя с id " + id + " не найдена, действие отменено."));
    }

    @Override
    public UserRole updateUserRole(Long id, UserRoleRequest request) {
        UserRole userRole = getUserRoleFromRequest(id, request);

        if (userRoleRepository.existsById(id)){
            return userRoleRepository.save(userRole);
        }
        else {
            throw new  EntityNotFoundException("Роль пользователя с " + id + " не найдена, действие отменено.");
        }
    }

    @Override
    public void deleteUserRoleById(Long id) {
        if (userRoleRepository.existsById(id)){
            userRoleRepository.deleteById(id);
        }
        else {
            throw new  EntityNotFoundException("Роль пользователя с id " + id + " не найдена, действие отменено.");
        }
    }

    private UserRole getUserRoleFromRequest(Long id, UserRoleRequest request) {
        List<String> fieldNamesToValidate = new ArrayList<>();
        fieldNamesToValidate.add("name");
        RequestUtils.validateRequest(request, fieldNamesToValidate);

        return UserRole.builder()
                .id(id)
                .name(request.name())
                .build();
    }
}

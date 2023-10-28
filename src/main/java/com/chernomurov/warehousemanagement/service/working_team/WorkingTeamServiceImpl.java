package com.chernomurov.warehousemanagement.service.working_team;

import com.chernomurov.warehousemanagement.custom.http.DTO.UserRoleDto;
import com.chernomurov.warehousemanagement.custom.http.request.UserRequest;
import com.chernomurov.warehousemanagement.custom.http.request.WorkingTeamRequest;
import com.chernomurov.warehousemanagement.entity.Equipment;
import com.chernomurov.warehousemanagement.entity.User;
import com.chernomurov.warehousemanagement.entity.UserRole;
import com.chernomurov.warehousemanagement.entity.WorkingTeam;
import com.chernomurov.warehousemanagement.repository.UserRepository;
import com.chernomurov.warehousemanagement.repository.UserRoleRepository;
import com.chernomurov.warehousemanagement.repository.WorkingTeamRepository;
import com.chernomurov.warehousemanagement.util.RequestUtils;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.hibernate.exception.DataException;
import org.springframework.data.repository.query.ParameterOutOfBoundsException;
import org.springframework.stereotype.Service;

import javax.management.BadAttributeValueExpException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class WorkingTeamServiceImpl implements WorkingTeamService {

    private final WorkingTeamRepository workingTeamRepository;
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    @Override
    public WorkingTeam createWorkingTeam(WorkingTeamRequest request) {
        WorkingTeam workingTeam = getWorkingTeamFromRequest(null, request);
        return workingTeamRepository.save(workingTeam);
    }

    @Override
    public WorkingTeam getWorkingTeamById(Long id) {
        return workingTeamRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Рабочая бригада с id " + id + " не найдена, действие отменено."));
    }

    @Override
    public WorkingTeam updateWorkingTeam(Long id, WorkingTeamRequest request) {
        WorkingTeam workingTeam = getWorkingTeamFromRequest(id, request);
        if (workingTeamRepository.existsById(id)){
            return workingTeamRepository.save(workingTeam);
        }
        else {
            throw new  EntityNotFoundException("Рабочая бригада с id " + id + " не найдена, действие отменено.");
        }
    }

    @Override
    public void deleteWorkingTeamById(Long id) {
        if (workingTeamRepository.existsById(id)){
            workingTeamRepository.deleteById(id);
        }
        else {
            throw new  EntityNotFoundException("Рабочая бригада с id " + id + " не найдена, действие отменено.");
        }
    }

    private WorkingTeam getWorkingTeamFromRequest(Long id, WorkingTeamRequest request) {
        List<String> fieldNamesToValidate = new ArrayList<>();
        fieldNamesToValidate.add("manager");
        fieldNamesToValidate.add("peopleAmount");
        RequestUtils.validateRequest(request, fieldNamesToValidate);

        User manager = userRepository
                .findById(request.manager().id())
                .orElseThrow(() -> new EntityNotFoundException("Пользователь с id " + request.manager().id() + " не найден, действие отменено."));

        if (!manager.getUserRoles().contains(userRoleRepository.getManagerRole())) {
            throw new DataException("Пользователь с id " + manager.getId() + " не является менеджером, действие отменено", new SQLException("Record is not presented in table"));
        }

        if (request.peopleAmount() <= 0) {
            throw new IndexOutOfBoundsException("Количество людей в бригаде не может быть меньше 1, действие отменено");
        }

        return WorkingTeam.builder()
                .id(id)
                .manager(manager)
                .peopleAmount(request.peopleAmount())
                .specialization(request.specialization())
                .build();
    }
}

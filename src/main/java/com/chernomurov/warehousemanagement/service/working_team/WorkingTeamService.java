package com.chernomurov.warehousemanagement.service.working_team;

import com.chernomurov.warehousemanagement.entity.User;
import com.chernomurov.warehousemanagement.entity.UserRole;
import com.chernomurov.warehousemanagement.entity.WorkingTeam;

public interface WorkingTeamService {
    void createWorkingTeam(User manager, Integer peopleAmount, String specialization);
    WorkingTeam getWorkingTeamById(Long id);
    void updateWorkingTeam(Long id, User manager, Integer peopleAmount, String specialization);
    void deleteWorkingTeamById(Long id);
}

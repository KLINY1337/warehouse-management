package com.chernomurov.warehousemanagement.service.working_team;

import com.chernomurov.warehousemanagement.custom.http.request.WorkingTeamRequest;
import com.chernomurov.warehousemanagement.entity.User;
import com.chernomurov.warehousemanagement.entity.UserRole;
import com.chernomurov.warehousemanagement.entity.WorkingTeam;

public interface WorkingTeamService {
    WorkingTeam createWorkingTeam(WorkingTeamRequest request);
    WorkingTeam getWorkingTeamById(Long id);
    WorkingTeam updateWorkingTeam(Long id, WorkingTeamRequest request);
    void deleteWorkingTeamById(Long id);
}

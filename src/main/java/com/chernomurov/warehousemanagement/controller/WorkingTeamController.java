package com.chernomurov.warehousemanagement.controller;

import com.chernomurov.warehousemanagement.custom.http.request.WorkingTeamRequest;
import com.chernomurov.warehousemanagement.entity.WorkingTeam;
import com.chernomurov.warehousemanagement.service.working_team.WorkingTeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/working/team")
public class WorkingTeamController {

    private final WorkingTeamService workingTeamService;

    @PostMapping
    public WorkingTeam createWorkingTeam(@RequestBody WorkingTeamRequest request) {
        return workingTeamService.createWorkingTeam(request);
    }

    @GetMapping("/{id}")
    public WorkingTeam getWorkingTeamById(@PathVariable Long id) {
        return workingTeamService.getWorkingTeamById(id);
    }

    @PutMapping("/{id}")
    public WorkingTeam updateWorkingTeam(@PathVariable Long id, @RequestBody WorkingTeamRequest request) {
        return workingTeamService.updateWorkingTeam(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteWorkingTeamById(@PathVariable Long id) {
        workingTeamService.deleteWorkingTeamById(id);
    }
}

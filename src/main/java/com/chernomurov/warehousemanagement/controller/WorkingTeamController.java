package com.chernomurov.warehousemanagement.controller;

import com.chernomurov.warehousemanagement.custom.http.request.WorkingTeamRequest;
import com.chernomurov.warehousemanagement.entity.WorkingTeam;
import com.chernomurov.warehousemanagement.service.working_team.WorkingTeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/working/team")
public class WorkingTeamController {

    private final WorkingTeamService workingTeamService;

    @PostMapping
    public ResponseEntity<WorkingTeam> createWorkingTeam(@RequestBody WorkingTeamRequest request) {
        return ResponseEntity.ok(workingTeamService.createWorkingTeam(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkingTeam> getWorkingTeamById(@PathVariable Long id) {
        return ResponseEntity.ok(workingTeamService.getWorkingTeamById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkingTeam> updateWorkingTeam(@PathVariable Long id, @RequestBody WorkingTeamRequest request) {
        return ResponseEntity.ok(workingTeamService.updateWorkingTeam(id, request));
    }

    @DeleteMapping("/{id}")
    public void deleteWorkingTeamById(@PathVariable Long id) {
        workingTeamService.deleteWorkingTeamById(id);
    }
}

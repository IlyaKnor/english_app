package study.englishApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.englishApp.models.entity.Role;
import study.englishApp.service.RoleService;

import java.util.List;

@RestController
@RequestMapping(value = "/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Role role) {
        roleService.create(role);
        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Role> find(@PathVariable(name = "id")Long id){
        roleService.find(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Role>> fidAll(){
        List<Role> roles = roleService.findAll();
        return roles != null && !roles.isEmpty()
                ? new ResponseEntity<>(roles, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id){
        roleService.delete(id);

        return new ResponseEntity<> (HttpStatus.OK);
    }
}

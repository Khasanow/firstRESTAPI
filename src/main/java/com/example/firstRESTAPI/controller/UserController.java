package com.example.firstRESTAPI.controller;


import com.example.firstRESTAPI.entity.UserEntity;
import com.example.firstRESTAPI.exception.UserAlreadyExistException;
import com.example.firstRESTAPI.exception.UserNotFoundException;
import com.example.firstRESTAPI.repository.UserRepo;
import com.example.firstRESTAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user) {

        try {
//            if(userRepo.findByUsername(user.getUsername()) != null) {
//                return ResponseEntity.badRequest().body("Пользователь с таким именем уже существует");
//            }
//            userRepo.save(user);
            userService.registration(user);
            return ResponseEntity.ok("Пользователь успешно сохранен!");
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping
    public ResponseEntity getOneUser(@RequestParam Long id){
        try {
            return ResponseEntity.ok(userService.getOne(id));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}

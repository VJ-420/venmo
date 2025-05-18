package com.EWallet.Venmo.controller;


import com.EWallet.Venmo.exception_handling.UnableToAdd;
import com.EWallet.Venmo.exception_handling.ResourceNotFound;
import com.EWallet.Venmo.models.User;
import com.EWallet.Venmo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService UserService;

    private final static Logger logger = LoggerFactory.getLogger(AdminController.class);

    @GetMapping("/getAllUser")
    public List<User> getUsers(){
        List<User> list = this.UserService.getAllUser();
        if(list.isEmpty()){
            logger.warn("User not Found");
            throw new ResourceNotFound("User not found");
        }
        else {
            logger.info("User Given");
            return list;

        }
    }
    @GetMapping("/getById/{id}")
    public User getUserById(@PathVariable("id") int id){
        User u = this.UserService.getUserById(id);
        if(u==null){
            logger.warn("User not Found");
            throw new ResourceNotFound("User not found");
        } else{
            logger.info("User given");
            return u;
        }
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user){

        User u = this.UserService.addUser(user);
        if(u==null){
            logger.error("User not added");
            throw new UnableToAdd("Not able to add");
        }
        logger.info("Student Added");
        return u;

    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") int id) throws Exception {
        try{
            this.UserService.deleteUser(id);
            logger.info("User Deleted");
        }catch (Exception e){
            throw  new Exception("Unable to Delete");
        }
    }

    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable ("id") int id, @RequestBody User user) throws Exception {
         User u = this.UserService.update(id,user);
         if(u==null){
             logger.error("Unable to update");
             throw new Exception("Unable to Update");
         }else{
             logger.info("User Updated");
             return u;
         }
    }









}

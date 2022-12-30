package ru.javabegin.oauth.spring.oauth.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/admin")
@RestController
public class AdminController {

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id, @AuthenticationPrincipal Jwt jwt){
        System.out.println("jwt = " + jwt.getClaim("email"));
        System.out.println("is delete = "+id);
        return "delete work";}

    @GetMapping("/add")
    @PreAuthorize("hasRole('admin')")
    public String add(){return "add work";}

}

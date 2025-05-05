package com.example.securitydemo.controller;

import com.example.securitydemo.modal.Workers;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WorkController {

    private List<Workers> workers = new ArrayList<>(List.of(
            new Workers (1, "Viktor", 3600),
            new Workers (2, "Vladimir", 2800),
            new Workers (3, "Vladislav", 2400),
            new Workers (4, "Vasiliy", 1700)
    ));

    @GetMapping("/workers")
    public List<Workers> allWorkers() {
        return workers;
    }

    @PostMapping("/workers")
    public Workers addWorker(@RequestBody Workers worker) {
        workers.add(worker);
        return worker;
    }

    @GetMapping("/csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }
}

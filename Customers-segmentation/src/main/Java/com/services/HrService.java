package com.services;


import com.entities.Hr;
import com.repositories.HrRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HrService {

    @Autowired
    private HrRepo hrRepo;


    public List<Hr> getAllAHrs() {

        List<Hr> Hrs = new ArrayList<>();
        hrRepo.findAll().forEach(Hrs::add);
        return Hrs;
    }

    public Optional<Hr> getHr(String id) {

        return hrRepo.findById(id);
    }

    public void addHr(Hr hr) {

        hrRepo.save(hr);
    }


    public void updateHr(String id, Hr hr) {

        hrRepo.save(hr);
    }


    public void deleteHr(String id) {

        hrRepo.deleteById(id);
    }
}
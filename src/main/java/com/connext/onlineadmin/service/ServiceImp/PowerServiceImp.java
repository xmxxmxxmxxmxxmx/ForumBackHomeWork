package com.connext.onlineadmin.service.ServiceImp;

import com.connext.onlineadmin.repository.PowerRepository;
import com.connext.onlineadmin.model.Power;
import com.connext.onlineadmin.service.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PowerServiceImp implements PowerService {
    @Autowired
    private PowerRepository powerRepository;
    @Override
    public List<Power> findAll() {
        return this.powerRepository.findAll();
    }

    @Override
    public void deleteOne(Integer id) {
        this.powerRepository.delete(id);
    }

    @Override
    public void addPower(Power power) {
        this.powerRepository.save(power);
    }


}

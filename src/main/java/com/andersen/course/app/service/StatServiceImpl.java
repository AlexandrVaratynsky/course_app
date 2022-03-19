package com.andersen.course.app.service;

import com.andersen.course.app.dao.StatRepository;
import com.andersen.course.app.entity.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatServiceImpl implements StatService{

    @Autowired
    private StatRepository statRepository;

    @Override
    public List<Stat> getAllStat() {
        return statRepository.findAll();
    }

    public StatServiceImpl() {
    }

    @Override
    public void saveStat(Stat stat) {
        statRepository.save(stat);
    }

    @Override
    public Stat getStat(int id) {
        Stat stat = null;
        Optional<Stat> crs = statRepository.findById(id);
        if (crs.isPresent()) {
            stat = crs.get();
        }

        return stat;
    }

    @Override
    public void deleteStat(int id) {
        statRepository.deleteById(id);
    }


}

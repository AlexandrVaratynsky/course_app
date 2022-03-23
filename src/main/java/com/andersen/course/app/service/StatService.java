package com.andersen.course.app.service;

import com.andersen.course.app.entity.Stat;
import com.andersen.course.app.quiz.DataGatherer;

import java.util.HashMap;
import java.util.List;

public interface StatService {
    public List<Stat> getAllStat();
    public void saveStat(Stat stat);
    public Stat getStat(int id);
    public void deleteStat(int id);
    public void saveStatByGathererData(DataGatherer gatherer);

}

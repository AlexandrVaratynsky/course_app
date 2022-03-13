package com.andersen.course.app.dao;

import com.andersen.course.app.entity.Stat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatRepository extends JpaRepository<Stat, Integer> {

}

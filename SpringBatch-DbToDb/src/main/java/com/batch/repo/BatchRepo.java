package com.batch.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.batch.pojo.TargetData;

public interface BatchRepo extends JpaRepository<TargetData, Integer> {

}

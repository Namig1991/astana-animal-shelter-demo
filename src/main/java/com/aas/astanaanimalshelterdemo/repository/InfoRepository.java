package com.aas.astanaanimalshelterdemo.repository;

import com.aas.astanaanimalshelterdemo.model.Info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfoRepository extends JpaRepository<Info, Long> {
}

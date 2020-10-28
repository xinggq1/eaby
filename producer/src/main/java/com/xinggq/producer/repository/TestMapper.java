package com.xinggq.producer.repository;

import com.xinggq.producer.entity.Test;
import org.springframework.stereotype.Repository;

@Repository
public interface TestMapper {

  Test selectById(Integer id);
}

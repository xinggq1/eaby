package com.xinggq.consumer.repository;

import com.xinggq.consumer.entity.Test;
import org.springframework.stereotype.Repository;

@Repository
public interface TestMapper {

  Test selectById(Integer id);
}

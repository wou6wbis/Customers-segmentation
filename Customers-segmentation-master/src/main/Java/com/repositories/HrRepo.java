package com.repositories;

import com.entities.Hr;
import org.springframework.data.repository.CrudRepository;

public interface HrRepo extends CrudRepository<Hr, String> {
}

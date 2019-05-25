package com.repositories;

import com.entities.Hr;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HrRepo extends CrudRepository<Hr, String> {
}

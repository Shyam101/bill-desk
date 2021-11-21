package com.example.billdesk.repository;

import com.example.billdesk.models.Bill;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface BillRepository extends CrudRepository<Bill, Long> {
    List<Bill> findAll();

    List<Bill> findAllByDueDate(Date dateTime);
}

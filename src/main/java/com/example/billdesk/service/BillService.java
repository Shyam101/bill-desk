package com.example.billdesk.service;

import com.example.billdesk.models.Bill;
import com.example.billdesk.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BillService {

    @Autowired
    BillRepository billRepository;

    public List<Bill> getBills() {
        return billRepository.findAll();
    }

    public Optional<Bill> getSingleBill(long id) {
        return billRepository.findById(id);
    }

    public List<Bill> getBillByDueDate(Date date) {
        return billRepository.findAllByDueDate(date);
    }

    public long saveBill(Bill bill) {

        bill.setDueDate(trim(bill.getDueDate()));

        billRepository.save(bill);
        return bill.getId();
    }

    private static Date trim(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR, 0);

        return calendar.getTime();
    }

}

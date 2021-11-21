package com.example.billdesk.Controllers;

import com.example.billdesk.models.Bill;
import com.example.billdesk.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class BillController {

    @Autowired
    BillService billService;

    @PostMapping("/bills")
    public ResponseEntity<?> addBill(@RequestBody Bill bill) {
        long id = billService.saveBill(bill);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public String gitUrl() {
        return "hello";
    }

    @GetMapping("/bills")
    public List<Bill> getAllBills() {
        return billService.getBills();
    }

    @GetMapping("/bills/{id}")
    public ResponseEntity<?> getBill(@PathVariable long id) {
        Optional<Bill> bill = billService.getSingleBill(id);
        HttpStatus status = HttpStatus.OK;
        if(bill.isEmpty())
            status = HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(bill, status);
    }

    @GetMapping("/bills/due/{date}")
    public List<Bill> billsByDueDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        return billService.getBillByDueDate(date);
    }
}

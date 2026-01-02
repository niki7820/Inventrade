package com.inventrade.inventrade.service;

import com.inventrade.inventrade.repository.SupplierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepo supplierRepo;
}

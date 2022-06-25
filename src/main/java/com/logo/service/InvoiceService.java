package com.logo.service;

import com.logo.model.company.Account;
import com.logo.model.invoice.Invoice;
import com.logo.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

    @Autowired
    InvoiceRepository invoiceRepository;


    public Invoice save(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

   public Invoice findById(long id) {
        return invoiceRepository.findById(id);
   }

   public void deleteById(long id) {
        invoiceRepository.deleteById(id);
   }

   public Invoice update(Invoice invoice) {

       Invoice invoiceToUpdate = invoiceRepository.findById(invoice.getId());

       invoiceToUpdate.setInvoiceDate(invoice.getInvoiceDate());
       invoiceToUpdate.setStatus(invoice.getStatus());
       invoiceToUpdate.setDiscount(invoice.getDiscount());

       return invoiceRepository.save(invoiceToUpdate);
   }







}

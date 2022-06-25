package com.logo.repository;

import com.logo.model.enums.Status;
import com.logo.model.invoice.Invoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice,Long> {

    public Invoice findById(long id);
    public Invoice findByTotalPrice(double price);
    public Invoice deleteById(long id);


}

package com.logo.model.invoice;

import com.logo.model.company.Account;
import com.logo.model.company.Customer;
import com.logo.model.enums.SalesType;
import com.logo.model.item.Product;

import java.util.ArrayList;
import java.util.List;

public class InvoiceBuilder {

    private InvoiceBuilder() {
    }

    private long id;                                  // auto calculated
    private String invoiceDate;                      // required
    private String dueDate;                          // required
    private String status;                             // required //AKTIF PASIF CANCEL
    private SalesType salesType;                        // required //RETAIL OR WHOLESALE
    private double vat;                                 // required
    private Customer customer;                          // required
    private Account account;                            // required

    private List<Product> productList;                  // optional
    private double discount;                            // optional  else 0;

    private static List<InvoiceBuilder> invoiceList = new ArrayList<>();

    private double vatTotal;                            // not required auto calculated
    private double totalPriceWithVat;                   // not required auto calculated
    private double totalPrice;                          // not required auto calculated

// Satış faturaları => Müşteri ...
// Alış faturaları => Tedarikçi...

    public static class Builder {

        // necessary
        private String invoiceDate;                         // required
        private String dueDate;                             // required
        private String status;                              // required //AKTIF PASIF CANCEL
        private SalesType salesType;                        // required //RETAIL OR WHOLESALE
        private double vat;                                 // required
        private Customer customer;                          // required
        private Account account;

        private double discount = 0;                            // optional  else 0;


        public Builder(String invoiceDate, String dueDate, String status, SalesType salesType, double vat, Customer customer, Account account) {
            this.invoiceDate = invoiceDate;
            this.dueDate = dueDate;
            this.status = status;
            this.salesType = salesType;
            this.vat = vat;
            this.customer = customer;
            this.account = account;
        }


        public Builder discount(double val) {
            this.discount = val;
            return this;
        }

        public InvoiceBuilder build() {
            return new InvoiceBuilder();
        }
    }

    private InvoiceBuilder(Builder builder) {

        this.invoiceDate = builder.invoiceDate;
        this.dueDate = builder.dueDate;
        this.status = builder.status;
        this.salesType = builder.salesType;
        this.vat = builder.vat;
        this.customer = builder.customer;
        this.account = builder.account;

        calculateTotalPrice();
        invoiceList.add(this);

        this.id = invoiceList.size();
    }





    // bunu nereye koymak lazım?
    private void calculateTotalPrice() {
        totalPrice = productList.stream().mapToDouble(o -> o.getPrice()).sum();
        totalPrice = totalPrice - (totalPrice * discount);

        if (salesType == SalesType.RETAIL) {
            vatTotal = totalPrice * vat;
        } else if (salesType == SalesType.WHOLESALE) {
            vatTotal = totalPrice;
        }
        totalPriceWithVat = totalPrice + vatTotal;
    }

}

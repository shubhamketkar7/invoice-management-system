package invoice.management.system.InvoiceManagementSystem.controller;

import invoice.management.system.InvoiceManagementSystem.model.Invoice;
import invoice.management.system.InvoiceManagementSystem.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("home")
    public String home() {
        return "index";
    }

    @GetMapping("allInvoices")
    public ResponseEntity<List<Invoice>> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable("id") Long id) {
        return invoiceService.getInvoiceById(id);
    }

    @PostMapping
    public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice) {
        return invoiceService.createInvoice(invoice);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Invoice> updateInvoice(@PathVariable("id") Long id, @RequestBody Invoice invoice) {
        return invoiceService.updateInvoice(id, invoice);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable("id") Long id) {
        return invoiceService.deleteInvoice(id);
    }
}

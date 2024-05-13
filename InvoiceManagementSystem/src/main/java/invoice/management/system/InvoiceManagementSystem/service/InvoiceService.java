package invoice.management.system.InvoiceManagementSystem.service;

import invoice.management.system.InvoiceManagementSystem.model.Invoice;
import java.util.List;
import org.springframework.http.ResponseEntity;


public interface InvoiceService {
    ResponseEntity<List<Invoice>> getAllInvoices();
    ResponseEntity<Invoice> getInvoiceById(Long id);
    ResponseEntity<Invoice> createInvoice(Invoice invoice);
    ResponseEntity<Invoice> updateInvoice(Long id, Invoice invoice);
    ResponseEntity<Void> deleteInvoice(Long id);
}
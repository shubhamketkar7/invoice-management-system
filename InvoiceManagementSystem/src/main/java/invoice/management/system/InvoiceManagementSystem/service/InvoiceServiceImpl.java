package invoice.management.system.InvoiceManagementSystem.service;

import invoice.management.system.InvoiceManagementSystem.model.Invoice;
import invoice.management.system.InvoiceManagementSystem.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public ResponseEntity<List<Invoice>> getAllInvoices() {
        List<Invoice> invoices = invoiceRepository.findAll();
        return ResponseEntity.ok().body(invoices);
    }

    @Override
    public ResponseEntity<Invoice> getInvoiceById(Long id) {
        Optional<Invoice> optionalInvoice = invoiceRepository.findById(id);
        return optionalInvoice.map(invoice -> ResponseEntity.ok().body(invoice)).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Invoice> createInvoice(Invoice invoice) {
        Invoice createdInvoice = invoiceRepository.save(invoice);
        System.out.println("Hello");
        return ResponseEntity.status(HttpStatus.CREATED).body(createdInvoice);
    }

    @Override
    public ResponseEntity<Invoice> updateInvoice(Long id, Invoice invoice) {
        Optional<Invoice> optionalInvoice = invoiceRepository.findById(id);
        if (optionalInvoice.isPresent()) {
            Invoice existingInvoice = optionalInvoice.get();
            existingInvoice.setInvoiceNumber(invoice.getInvoiceNumber());
            existingInvoice.setDate(invoice.getDate());
            existingInvoice.setAmount(invoice.getAmount());
            existingInvoice.setCustomerName(invoice.getCustomerName());
            Invoice updatedInvoice = invoiceRepository.save(existingInvoice);
            return ResponseEntity.ok(updatedInvoice);
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Void> deleteInvoice(Long id) {
        Optional<Invoice> optionalInvoice = invoiceRepository.findById(id);
        if (optionalInvoice.isPresent()) {
            invoiceRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
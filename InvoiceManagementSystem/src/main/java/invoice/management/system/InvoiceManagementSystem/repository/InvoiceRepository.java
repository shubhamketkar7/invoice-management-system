package invoice.management.system.InvoiceManagementSystem.repository;

import invoice.management.system.InvoiceManagementSystem.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}

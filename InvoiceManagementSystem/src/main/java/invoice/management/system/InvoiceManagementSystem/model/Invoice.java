package invoice.management.system.InvoiceManagementSystem.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "invoices")
@Getter
@Setter
@Data
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "invoice_number", nullable = false, unique = true)
    private String invoiceNumber;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "customer_name")
    private String customerName;
}

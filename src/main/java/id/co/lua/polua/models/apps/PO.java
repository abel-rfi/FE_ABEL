package id.co.lua.polua.models.apps;

import id.co.lua.polua.models.AuditModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "po")
public class PO extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customer;
    private Integer amount;

    @OneToOne(fetch = FetchType.LAZY, targetEntity = OpenPOProduct.class)
    @JoinColumn(name = "openPOId")
    private OpenPOProduct openPOp;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Product.class)
    @JoinColumn(name = "productId")
    private Product product;
}

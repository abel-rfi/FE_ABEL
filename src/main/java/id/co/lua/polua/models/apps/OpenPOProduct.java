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
@Table(name = "openPop")
public class OpenPOProduct extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Product.class)
    @JoinColumn(name = "productId")
    private Product product;

    @OneToOne(fetch = FetchType.LAZY, targetEntity = OpenPO.class)
    @JoinColumn(name = "openPOId")
    private OpenPO openPo;
}

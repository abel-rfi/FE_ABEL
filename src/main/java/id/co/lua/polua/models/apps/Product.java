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
@Table(name = "product")
public class Product extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String price;
    private String description;
    private String image;
    private Integer stock;

    @OneToOne(fetch = FetchType.LAZY, targetEntity = Group.class)
    @JoinColumn(name = "groudId")
    private Group group;
}

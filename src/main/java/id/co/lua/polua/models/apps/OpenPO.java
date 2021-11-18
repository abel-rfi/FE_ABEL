package id.co.lua.polua.models.apps;

import id.co.lua.polua.models.AuditModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.sql.Date;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "openPo")
public class OpenPO extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date closeOrderDate;

    @OneToOne(fetch = FetchType.LAZY, targetEntity = Group.class)
    @JoinColumn(name = "groudId")
    private Group group;
}

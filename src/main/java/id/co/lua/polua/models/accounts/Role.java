package id.co.lua.polua.models.accounts;

import id.co.lua.polua.models.AuditModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "role")
public class Role  extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "role")
    private List<RoleFeature> roleFeature;

    public boolean isAdmin(){
        return id == 1;
    }
    public boolean isPPK(){
        return id == 2;
    }
    public boolean isPAKPA(){
        return id == 3;
    }
    public boolean isPanitia(){
        return id == 4;
    }
    public boolean isKUPPBJ(){
        return id == 5;
    }

    public String getNamaLowerCase(){
        return this.name.toLowerCase();
    }
}

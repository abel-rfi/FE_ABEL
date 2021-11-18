package id.co.lua.polua.models.accounts;

import id.co.lua.polua.models.AuditModel;
import id.co.lua.polua.models.apps.Feature;
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
@Table(name = "role_feature")
public class RoleFeature extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Role.class)
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Feature.class)
    @JoinColumn(name = "feature_id")
    private Feature feature;
}

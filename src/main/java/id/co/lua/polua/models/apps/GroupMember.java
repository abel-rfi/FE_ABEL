package id.co.lua.polua.models.apps;

import id.co.lua.polua.models.AuditModel;
import id.co.lua.polua.models.accounts.User;
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
@Table(name = "groupMember")
public class GroupMember extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY, targetEntity = Group.class)
    @JoinColumn(name = "group_id")
    private Group groups;
}

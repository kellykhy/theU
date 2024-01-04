package UMC.teamC.theU.entity;

import UMC.teamC.theU.entity.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Team extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String subtitle;

    private String introduction;

    private LocalDate date;

    private String enterCode;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Member> memberList = new ArrayList<>();

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Information> informationList = new ArrayList<>();

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Question> questionList = new ArrayList<>();

    public void setEnterCode(String enterCode) {
        this.enterCode = enterCode;
    }
}

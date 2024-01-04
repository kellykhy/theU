package UMC.teamC.theU.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class StepServicelmpl implements StepService {
    private final MemberService memberService;

    @Override
    public List<String> stepOne() {
        return new ArrayList<>();
    }

}

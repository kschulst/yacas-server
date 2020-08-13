package no.udp.yacas.api.cases;

import no.udp.yacas.domain.UserId;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Singleton
public class CasesService {

    private static final Set<Case> STATIC_CASES = Set.of(
      Case.selfReportedCovid19("1"),
      Case.selfReportedCovid19("2"),
      Case.selfReportedCovid19("3")
    );

    private final Map<UserId, Case> casesRepository = new HashMap<>();

    public CasesService() {
        STATIC_CASES.forEach(this::addCase);
    }

    public void addCase(Case c) {
        casesRepository.put(c.getUserId(), c);
    }

    public Set<Case> findCases(Set<UserId> contacts) {
        return casesRepository.values().stream()
          .filter(c -> contacts.contains(c.getUserId()))
          .collect(Collectors.toSet());
    }

}

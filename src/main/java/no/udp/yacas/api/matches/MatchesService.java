package no.udp.yacas.api.matches;

import lombok.RequiredArgsConstructor;
import no.udp.yacas.api.cases.Case;
import no.udp.yacas.api.cases.CasesService;
import no.udp.yacas.domain.UserId;

import javax.inject.Singleton;
import java.util.Set;

@Singleton
@RequiredArgsConstructor
public class MatchesService {

    private final CasesService casesService;

    public Set<Case> findMatches(Set<UserId> contacts) {
        return casesService.findCases(contacts);
    }
}

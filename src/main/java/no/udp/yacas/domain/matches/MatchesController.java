package no.udp.yacas.domain.matches;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import no.udp.yacas.domain.cases.Case;
import no.udp.yacas.domain.UserId;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Controller("/matches")
@RequiredArgsConstructor
public class MatchesController {

    private final MatchesService matchesService;

    @Post
    public HttpResponse<FindMatchesResponse> findMatches(@Valid @Body FindMatchesRequest req) {
        FindMatchesResponse res = new FindMatchesResponse();
        Set<Case> cases = matchesService.findMatches(req.getContacts());
        res.cases.addAll(cases);
        return HttpResponse.ok(res);
    }

    @Data
    @Introspected
    static class FindMatchesRequest {
        @NotNull
        private Set<UserId> contacts;
    }

    @Data
    static class FindMatchesResponse {
        private Set<Case> cases = new HashSet<>();
    }

}

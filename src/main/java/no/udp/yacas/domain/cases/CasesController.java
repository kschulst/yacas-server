package no.udp.yacas.domain.cases;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import lombok.RequiredArgsConstructor;
import no.udp.yacas.domain.UserId;

import javax.validation.Valid;

@Controller("/cases")
@RequiredArgsConstructor
public class CasesController {

    private final CasesService casesService;

    @Post
    public HttpResponse registerCase(@Valid @Body Case newCase) {
        casesService.addCase(newCase);
        return HttpResponse.ok();
    }

    /** TODO: Remove, for dev purposes only*/
    @Delete("/{userId}")
    public HttpResponse removeCase(@PathVariable() UserId userId) {
        if ()
        casesService.removeCase(userId);
        return HttpResponse.ok();
    }

    /** TODO: Remove, for dev purposes only*/
    @Delete
    public HttpResponse removeAllCases() {
        casesService.removeAllCases();
        return HttpResponse.ok();
    }



}

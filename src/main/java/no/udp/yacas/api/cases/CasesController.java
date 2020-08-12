package no.udp.yacas.api.cases;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import lombok.RequiredArgsConstructor;

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

}

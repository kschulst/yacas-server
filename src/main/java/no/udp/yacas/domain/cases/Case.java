package no.udp.yacas.domain.cases;

import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import no.udp.yacas.domain.UserId;
import no.udp.yacas.domain.Disease;
import no.udp.yacas.domain.Reporter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Introspected
public class Case {

    private UserId userId;
    private Disease disease;
    private Reporter reporter;

    public static Case selfReportedCovid19(String userId) {
        return new Case(new UserId(userId), Disease.COVID19, Reporter.SELF);
    }
}

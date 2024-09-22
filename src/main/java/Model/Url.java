package Model;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class Url {
    private LocalDate dataExpiracao;
    private UUID id;
    private String urlEncurtada;
    private String urlOriginal;
}





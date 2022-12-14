package kodlama.io.devs.devs.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetSubTechnologyResponse {
    private int id;
    private String name;
    private int programmingLanguageId;
}

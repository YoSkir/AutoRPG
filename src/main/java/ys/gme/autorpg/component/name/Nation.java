package ys.gme.autorpg.component.name;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import ys.gme.autorpg.util.Constant;

import java.util.List;

/**
 * @author yoskir
 */
@Data
@ToString(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Nation{
    @JsonProperty(value = "first_names")
    private List<String> firstNames;
    @JsonProperty(value = "last_names")
    private List<String> lastNames;
    @JsonProperty(value = "nation")
    private Constant.Nation nation;
}

package ys.gme.autorpg.component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import ys.gme.autorpg.component.name.Nation;

import java.util.List;

/**
 * 名字的容器
 * @author yoskir
 */
@Data
@ToString(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NameComponent {
    @JsonProperty(value = "national_name_list")
    private List<Nation> nationalNameList;
}

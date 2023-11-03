package bj.nazonhou.springinaction.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
  private Long id;
  @NotBlank
  private String name;
  @NotNull
  private Long authorId;
}

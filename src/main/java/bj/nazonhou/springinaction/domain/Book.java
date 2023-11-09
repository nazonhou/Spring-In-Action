package bj.nazonhou.springinaction.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books")
@Builder
public class Book {
  @Id
  @Column("id")
  private Long id;
  @NotBlank
  @Column("name")
  private String name;
  @NotNull
  @Column("author_id")
  private Long authorId;
}

package com.history.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "history")
public class History {

  @Id
  private String id;

  @Field(value = "name")
  private String name;

  @Field(value = "date")
  private Date date;

  @Field(value = "state")
  private String state;

}

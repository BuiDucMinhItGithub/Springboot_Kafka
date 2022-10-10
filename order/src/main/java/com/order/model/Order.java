package com.order.model;

import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "order")
public class Order {
  @Id
  private String id;
  @Field(value = "name")
  private String name;
  @Field(value = "customer")
  private String customer;
  @Field(value = "action")
  private String action;
  @Field(value = "state")
  private String state;
}

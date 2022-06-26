package com.market.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ResponseObject {
    private String status;
    private String message;
    private Object data;
}

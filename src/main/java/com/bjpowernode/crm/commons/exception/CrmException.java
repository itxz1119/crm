package com.bjpowernode.crm.commons.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrmException extends RuntimeException{
    private Integer code;
    private String message;
}

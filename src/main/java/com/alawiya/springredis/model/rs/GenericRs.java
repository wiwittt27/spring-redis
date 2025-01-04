package com.alawiya.springredis.model.rs;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@Accessors(chain = true)
public class GenericRs implements BaseResponse {
    String status;
    String code;
    String message;
    Object data;

    @Override
    public void setSuccess() {
        this.status = "ok";
        this.code = "00";
        this.message = "success";
    }

    @Override
    public void setSuccess(Object data) {
        setSuccess();
        this.data = data;
    }
}

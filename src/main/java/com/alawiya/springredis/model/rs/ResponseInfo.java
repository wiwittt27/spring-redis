package com.alawiya.springredis.model.rs;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@ToString
@Accessors(chain = true)
public class ResponseInfo {
    private HttpStatus httpStatus;
    private HttpHeaders httpHeaders;
    private BaseResponse body;

    /**f
     * set success without set data
     */
    public void setSuccess() {
        this.httpStatus = HttpStatus.OK;
        body.setSuccess();
    }

    /**
     * set success with data
     * @param data  {@link Object} (generic)
     */
    public void setSuccess(Object data) {
        setSuccess();
        body.setSuccess(data);
    }
}

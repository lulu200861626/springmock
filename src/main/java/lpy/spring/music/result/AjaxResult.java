package lpy.spring.music.result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 */
public class AjaxResult {

    private int code = 0;
    private String message = "";
    private boolean status = true;
    private Object data;

    public AjaxResult() {
    }

    public AjaxResult(int code, String message, boolean status, Object data) {
        this.code = code;
        this.message = message;
        this.status = status;
        this.data = data;
    }


    public AjaxResult(int code, String message, boolean status, Map<String, String> info, boolean isError) {
        this.code = code;
        this.message = message;
        this.status = status;
        if (isError) {
            Map<String, Object> data = new HashMap<>();
            data.put("errors", info);
            this.data = data;
        } else {
            this.data = info;
        }

    }

    public AjaxResult(int code, String message, boolean status, List<String> info, boolean isError) {
        this.code = code;
        this.message = message;
        this.status = status;
        if (isError) {
            Map<String, Object> data = new HashMap<>();
            data.put("errors", info);
            this.data = data;
        } else {
            this.data = info;
        }

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}

package jp.yuiki.dev.qiita4jv2;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @see <a href="https://qiita.com/api/v2/docs#エラーレスポンス">https://qiita.com/api/v2/docs#エラーレスポンス</a>
 */
public class QiitaException extends Exception {
    /**
     * The error message
     */
    @JsonProperty("message")
    private String message;

    /**
     * The error type
     */
    @JsonProperty("type")
    private String type;

    public QiitaException() {
    }

    public QiitaException(Throwable cause, String message, String type) {
        super(message, cause);
        this.message = message;
        this.type = type;
    }

    public QiitaException(String message, String type) {
        super(message);
        this.message = message;
        this.type = type;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

package zzy.okhttp;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HttpResponse {
    private boolean isSuccess;
    private String error_msg;
    private String result;
}

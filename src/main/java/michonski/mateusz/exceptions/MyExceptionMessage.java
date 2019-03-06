package michonski.mateusz.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class MyExceptionMessage {
    private String exceptionMessage;
    private LocalDateTime exceptionDateTime;
}

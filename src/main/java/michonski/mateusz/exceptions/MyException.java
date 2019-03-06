package michonski.mateusz.exceptions;

import java.time.LocalDateTime;

public class MyException extends RuntimeException {
    private MyExceptionMessage myExceptionMessage;

    public MyException(String exceptionMessage, LocalDateTime exceptionDateTime) {
        myExceptionMessage = new MyExceptionMessage(exceptionMessage, exceptionDateTime);
    }

    public MyExceptionMessage getMyExceptionMessage() {
        return myExceptionMessage;
    }
}

package tw.com.msig.exception;

/** 沒有實作此功能 */
public class NoImpormentException extends RuntimeException {

	public NoImpormentException() {
	}

	public NoImpormentException(String message) {
		super(message);
	}

	public NoImpormentException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoImpormentException(Throwable cause) {
		super(cause);
	}

	public NoImpormentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}

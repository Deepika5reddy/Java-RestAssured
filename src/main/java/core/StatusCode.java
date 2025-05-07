package core;

public enum StatusCode {

    SUCCESS(200, "The request succeeded"),
    CREATED(201, "A new resource was created"),
    BAD_REQUEST(400, "Missing required field: name"),
    UNAUTHORIZED(401, "Invalid access token"),
    NOT_FOUND(404, "Cannot Find Requested Resource"),
    NO_CONTENT(204, "No content to send in the response body");

    public final int code;
    public final String message;





    StatusCode( int code, String message)
    {
        this.code = code;
        this.message = message;
    }
}



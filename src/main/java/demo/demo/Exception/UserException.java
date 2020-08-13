package demo.demo.Exception;

public class UserException extends RuntimeException{
     

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public UserException(String id) {
        super("In Database has no id or firstName: " + id);
    }
    
}
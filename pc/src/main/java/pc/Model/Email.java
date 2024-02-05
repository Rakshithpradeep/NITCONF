package pc.Model;

/**
 * Represents an email with the recipient, subject, and message.
 */
public class Email {

    private String to;
    private String subject;
    private String message;

    /**
     * Gets the recipient email address.
     *
     * @return The recipient email address.
     */
    public String getTo() {
        return to;
    }

    /**
     * Sets the recipient email address.
     *
     * @param to The recipient email address.
     */
    public void setTo(String to) {
        this.to = to;
    }

    /**
     * Gets the subject of the email.
     *
     * @return The subject of the email.
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets the subject of the email.
     *
     * @param subject The subject of the email.
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Gets the message content of the email.
     *
     * @return The message content of the email.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message content of the email.
     *
     * @param message The message content of the email.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Returns a string representation of the Email object.
     *
     * @return String representation of the Email object.
     */
    @Override
    public String toString() {
        return "Email [to=" + to + ", subject=" + subject + ", message=" + message + "]";
    }
}

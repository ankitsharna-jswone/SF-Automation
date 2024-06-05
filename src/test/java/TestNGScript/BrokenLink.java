package TestNGScript;

public class BrokenLink {
    private String url;
    private int statusCode;
    private String statusMessage;

    public BrokenLink(String url, int statusCode, String statusMessage) {
        this.url = url;
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public String getUrl() {
        return url;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    @Override
    public String toString() {
        return "URL: " + url + ", Status Code: " + statusCode + ", Message: " + statusMessage;
    }
}

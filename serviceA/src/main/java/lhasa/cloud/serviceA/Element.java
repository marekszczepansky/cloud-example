package lhasa.cloud.serviceA;

public class Element {
    private String sourceService = "Service A";
    private int sourcePort;
    private String message;

    public Element(String message) {
        this.message = message;
    }

    public Element(String message, Integer port) {
        this.message = message;
        this.sourcePort = port;
    }

    public String getSourceService() {
        return sourceService;
    }

    public void setSourceService(String sourceService) {
        this.sourceService = sourceService;
    }

    public int getSourcePort() {
        return sourcePort;
    }

    public void setSourcePort(int sourcePort) {
        this.sourcePort = sourcePort;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

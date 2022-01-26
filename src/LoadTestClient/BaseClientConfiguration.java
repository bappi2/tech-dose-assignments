package LoadTestClient;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class BaseClientConfiguration {
    private static final int MAX_RETRIES = 5;
    String baseUrl;
    String baseUrlDev;
    int maxRetries = 5;
    int retryTimeout;
    int socketTimeout = 10000;
    int timeout = 10000;
    Integer maxBackoffIncreases = null;
    ArrayList<Integer> retryOnStatusCodes = new ArrayList();
    ArrayList<Integer> acceptableErrors = new ArrayList();
    HashMap<String, Object> extraLoggingInfo = null;
    int zuniRateLimitCounter;

    public BaseClientConfiguration() {
    }

    public Boolean getRetriesOk() {
        return this.maxRetries > 0;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public String getBaseUrlDev() {
        return this.baseUrlDev;
    }

    public int getMaxRetries() {
        return this.maxRetries;
    }

    public int getRetryTimeout() {
        return this.retryTimeout;
    }

    public int getSocketTimeout() {
        return this.socketTimeout;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public Integer getMaxBackoffIncreases() {
        return this.maxBackoffIncreases;
    }

    public ArrayList<Integer> getRetryOnStatusCodes() {
        return this.retryOnStatusCodes;
    }

    public ArrayList<Integer> getAcceptableErrors() {
        return this.acceptableErrors;
    }

    public HashMap<String, Object> getExtraLoggingInfo() {
        return this.extraLoggingInfo;
    }

    public int getZuniRateLimitCounter() {
        return this.zuniRateLimitCounter;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void setBaseUrlDev(String baseUrlDev) {
        this.baseUrlDev = baseUrlDev;
    }

    public void setMaxRetries(int maxRetries) {
        this.maxRetries = maxRetries;
    }

    public void setRetryTimeout(int retryTimeout) {
        this.retryTimeout = retryTimeout;
    }

    public void setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public void setMaxBackoffIncreases(Integer maxBackoffIncreases) {
        this.maxBackoffIncreases = maxBackoffIncreases;
    }

    public void setRetryOnStatusCodes(ArrayList<Integer> retryOnStatusCodes) {
        this.retryOnStatusCodes = retryOnStatusCodes;
    }

    public void setAcceptableErrors(ArrayList<Integer> acceptableErrors) {
        this.acceptableErrors = acceptableErrors;
    }

    public void setExtraLoggingInfo(HashMap<String, Object> extraLoggingInfo) {
        this.extraLoggingInfo = extraLoggingInfo;
    }

    public void setZuniRateLimitCounter(int zuniRateLimitCounter) {
        this.zuniRateLimitCounter = zuniRateLimitCounter;
    }
}


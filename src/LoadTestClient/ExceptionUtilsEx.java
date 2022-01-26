package LoadTestClient;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.reactivex.rxjava3.core.Observable;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.File;
import java.net.InetAddress;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExceptionUtilsEx extends ExceptionUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static final int MAX_STACKTRACE_LENGTH = 1024;
    private static String host = null;

    public ExceptionUtilsEx() {
    }

    public static String getStackTraceEx(Throwable ex) {
        StringBuilder errors = new StringBuilder();
        String[] stackTrace = ExceptionUtils.getRootCauseStackTrace(ex);
        Observable.fromArray(stackTrace).takeUntil((x) -> {
            return x.indexOf("invoke") > 0;
        }).doOnNext((line) -> {
            errors.append(line + ";");
        }).subscribe();
        String stackTraceString = errors.toString();
        return stackTraceString.substring(0, Math.min(stackTraceString.length(), 1024));
    }

    public static String getExceptionInformation(Throwable ex) {
        String exceptionInformation = getStackTraceEx(ex);
        return ";" + exceptionInformation.substring(0, Math.min(exceptionInformation.length(), 1024));
    }

    public static String getHost() {
        if (StringUtils.isEmpty(host)) {
            host = "";

            try {
                File file = new File("/etc/hostname");
                if (file.exists()) {
                    host = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
                }

                if (StringUtils.isEmpty(host)) {
                    host = InetAddress.getLocalHost().getHostName();
                }
            } catch (Exception var1) {
                ;
            }
        }

        return host;
    }
/*
    public static String dumpThreads(Object err, String comment, String stopTag) {
        StringBuilder message = new StringBuilder();
        message.append("<div>Host: " + getHost() + "</div>");
        if (err != null) {
            dumpThrowable(message, err, (StackTraceElement[])null, comment, stopTag);
        }

        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        message.append("<div>" + allStackTraces.size() + " threads</div>");
        ArrayList<ThreadDetails> threadDetailsArrayList = new ArrayList();
        allStackTraces.forEach((x, y) -> {
            ThreadDetails threadDetails = new ThreadDetails();
            threadDetails.setName(x.getName());
            threadDetails.setState(x.getState().toString());
            threadDetails.setAlive(x.isAlive() ? "Alive" : "Dead");
            threadDetails.setStacktrace(dumpThread(y, stopTag));
            threadDetailsArrayList.add(threadDetails);
        });
        threadDetailsArrayList.sort((x, y) -> {
            if (x.getName().equals(y.getName())) {
                if (x.getState().equals(y.getState())) {
                    return x.getAlive().equals(y.getAlive()) ? 0 : StringUtils.compare(x.getAlive(), y.getAlive());
                } else {
                    return StringUtils.compare(x.getState(), y.getState());
                }
            } else {
                return StringUtils.compare(x.getName(), y.getName());
            }
        });
        message.append("<table>");
        threadDetailsArrayList.forEach((x) -> {
            message.append(String.format("<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>", x.getName(), x.getState(), x.getAlive(), x.getStacktrace()));
        });
        message.append("</table>");
        return message.toString();
    }

    public static String dumpThread(StackTraceElement[] stackTrace, String stopTag) {
        AtomicReference<String> stackTraceT = new AtomicReference();
        Observable.fromArray(stackTrace).takeUntil((x) -> {
            return stopTag == null || x.toString().indexOf(stopTag) > 0;
        }).map((x) -> {
            return x.toString();
        }).reduce((x, y) -> {
            return x + "," + y;
        }).subscribe((x) -> {
            stackTraceT.set(x);
        });
        String stackAsString = (String)stackTraceT.get();
        if (StringUtils.isEmpty(stackAsString)) {
            stackAsString = "";
        }

        return stackAsString;
    }

    public static void dumpThrowable(StringBuilder message, Object err, StackTraceElement[] stackTrace, String comment, String stopTag) {
        message.append(comment);
        if (err != null) {
            if (stackTrace == null) {
                stackTrace = ((Exception)err).getStackTrace();
            }

            if (err instanceof HttpResponseException) {
                HttpResponseException responseException = (HttpResponseException)err;
                message.append(responseException.getStatusCode() + " " + responseException.getMessage());
            } else {
                message.append(err.toString());
            }
        }

        AtomicReference<String> stackTraceT = new AtomicReference();
        Observable.fromArray(stackTrace).takeUntil((x) -> {
            return stopTag == null || x.toString().indexOf(stopTag) > 0;
        }).map((x) -> {
            return x.toString();
        }).reduce((x, y) -> {
            return x + "," + y;
        }).subscribe((x) -> {
            stackTraceT.set(x);
        });
        String stackAsString = (String)stackTraceT.get();
        if (StringUtils.isEmpty(stackAsString)) {
            stackAsString = "";
        }

        message.append(" " + stackAsString + ";\n");
    } */
}

package LoadTestClient;


import org.slf4j.Logger;
import org.slf4j.Marker;

public class LoggerWrapper implements Logger {
    private Logger logger = null;
    private static Boolean flattenLines = true;

    public LoggerWrapper(Logger logger, Boolean flattenLines) {
        this.logger = logger;
        flattenLines = flattenLines;
    }

    public String getName() {
        return this.logger.getName();
    }

    public boolean isTraceEnabled() {
        return this.logger.isTraceEnabled();
    }

    public void trace(String s) {
        this.logger.trace(this.flattenLine(s, false));
    }

    public void trace(String s, Object o) {
        this.logger.trace(this.flattenLine(s, false), o);
    }

    public void trace(String s, Object o, Object o1) {
        this.logger.trace(this.flattenLine(s, false), o, o1);
    }

    public void trace(String s, Object... objects) {
        this.logger.trace(this.flattenLine(s, false), objects);
    }

    public void trace(String s, Throwable throwable) {
        this.logger.trace(this.flattenLine(s, false), throwable);
    }

    public boolean isTraceEnabled(Marker marker) {
        return this.logger.isTraceEnabled(marker);
    }

    public void trace(Marker marker, String s) {
        this.logger.trace(marker, this.flattenLine(s, false));
    }

    public void trace(Marker marker, String s, Object o) {
        this.logger.trace(marker, this.flattenLine(s, false), o);
    }

    public void trace(Marker marker, String s, Object o, Object o1) {
        this.logger.trace(marker, this.flattenLine(s, false), o, o1);
    }

    public void trace(Marker marker, String s, Object... objects) {
        this.logger.trace(marker, this.flattenLine(s, false), objects);
    }

    public void trace(Marker marker, String s, Throwable throwable) {
        this.logger.trace(marker, this.flattenLine(s, false), throwable);
    }

    public boolean isDebugEnabled() {
        return this.logger.isDebugEnabled();
    }

    public void debug(String s) {
        if (LoggerFactoryExt.isInfo(this.getName())) {
            this.logger.info(this.flattenLine(s, true));
        } else {
            this.logger.debug(this.flattenLine(s, true));
        }

    }

    public void debug(String s, Object o) {
        if (LoggerFactoryExt.isInfo(this.getName())) {
            this.logger.info(this.flattenLine(s, true), o);
        } else {
            this.logger.debug(this.flattenLine(s, true), o);
        }

    }

    public void debug(String s, Object o, Object o1) {
        if (LoggerFactoryExt.isInfo(this.getName())) {
            this.logger.info(this.flattenLine(s, true), o, o1);
        } else {
            this.logger.debug(this.flattenLine(s, true), o, o1);
        }

    }

    public void debug(String s, Object... objects) {
        if (LoggerFactoryExt.isInfo(this.getName())) {
            this.logger.info(this.flattenLine(s, true), objects);
        } else {
            this.logger.debug(this.flattenLine(s, true), objects);
        }

    }

    public void debug(String s, Throwable throwable) {
        if (LoggerFactoryExt.isInfo(this.getName())) {
            this.logger.info(this.flattenLine(s, true), throwable);
        } else {
            this.logger.debug(this.flattenLine(s, true), throwable);
        }

    }

    public boolean isDebugEnabled(Marker marker) {
        return this.logger.isDebugEnabled(marker);
    }

    public void debug(Marker marker, String s) {
        if (LoggerFactoryExt.isInfo(this.getName())) {
            this.logger.info(marker, this.flattenLine(s, true));
        } else {
            this.logger.debug(marker, this.flattenLine(s, true));
        }

    }

    public void debug(Marker marker, String s, Object o) {
        if (LoggerFactoryExt.isInfo(this.getName())) {
            this.logger.info(marker, this.flattenLine(s, true), o);
        } else {
            this.logger.debug(marker, this.flattenLine(s, true), o);
        }

    }

    public void debug(Marker marker, String s, Object o, Object o1) {
        if (LoggerFactoryExt.isInfo(this.getName())) {
            this.logger.info(marker, this.flattenLine(s, true), o, o1);
        } else {
            this.logger.debug(marker, this.flattenLine(s, true), o, o1);
        }

    }

    public void debug(Marker marker, String s, Object... objects) {
        if (LoggerFactoryExt.isInfo(this.getName())) {
            this.logger.info(marker, this.flattenLine(s, true), objects);
        } else {
            this.logger.debug(marker, this.flattenLine(s, true), objects);
        }

    }

    public void debug(Marker marker, String s, Throwable throwable) {
        if (LoggerFactoryExt.isInfo(this.getName())) {
            this.logger.info(marker, this.flattenLine(s, true), throwable);
        } else {
            this.logger.debug(marker, this.flattenLine(s, true), throwable);
        }

    }

    public boolean isInfoEnabled() {
        return this.logger.isInfoEnabled();
    }

    public void info(String s) {
        this.logger.info(this.flattenLine(s, false));
    }

    public void info(String s, Object o) {
        this.logger.info(this.flattenLine(s, false), o);
    }

    public void info(String s, Object o, Object o1) {
        this.logger.info(this.flattenLine(s, false), o, o1);
    }

    public void info(String s, Object... objects) {
        this.logger.info(this.flattenLine(s, false), objects);
    }

    public void info(String s, Throwable throwable) {
        this.logger.info(this.flattenLine(s, false), throwable);
    }

    public boolean isInfoEnabled(Marker marker) {
        return this.logger.isInfoEnabled(marker);
    }

    public void info(Marker marker, String s) {
        this.logger.info(marker, this.flattenLine(s, false));
    }

    public void info(Marker marker, String s, Object o) {
        this.logger.info(marker, this.flattenLine(s, false), o);
    }

    public void info(Marker marker, String s, Object o, Object o1) {
        this.logger.info(marker, this.flattenLine(s, false), o, o1);
    }

    public void info(Marker marker, String s, Object... objects) {
        this.logger.info(marker, this.flattenLine(s, false), objects);
    }

    public void info(Marker marker, String s, Throwable throwable) {
        this.logger.info(marker, this.flattenLine(s, false), throwable);
    }

    public boolean isWarnEnabled() {
        return this.logger.isWarnEnabled();
    }

    public void warn(String s) {
        this.logger.warn(this.flattenLine(s, false));
    }

    public void warn(String s, Object o) {
        this.logger.warn(this.flattenLine(s, false), o);
    }

    public void warn(String s, Object... objects) {
        this.logger.warn(this.flattenLine(s, false), objects);
    }

    public void warn(String s, Object o, Object o1) {
        this.logger.warn(this.flattenLine(s, false), o, o1);
    }

    public void warn(String s, Throwable throwable) {
        this.logger.warn(this.flattenLine(s, false), throwable);
    }

    public boolean isWarnEnabled(Marker marker) {
        return this.logger.isWarnEnabled(marker);
    }

    public void warn(Marker marker, String s) {
        this.logger.warn(marker, this.flattenLine(s, false));
    }

    public void warn(Marker marker, String s, Object o) {
        this.logger.warn(marker, this.flattenLine(s, false), o);
    }

    public void warn(Marker marker, String s, Object o, Object o1) {
        this.logger.warn(marker, this.flattenLine(s, false), o, o1);
    }

    public void warn(Marker marker, String s, Object... objects) {
        this.logger.warn(marker, this.flattenLine(s, false), objects);
    }

    public void warn(Marker marker, String s, Throwable throwable) {
        this.logger.warn(marker, this.flattenLine(s, false), throwable);
    }

    public boolean isErrorEnabled() {
        return this.logger.isErrorEnabled();
    }

    public void error(String s) {
        this.logger.error(this.flattenLine(s, false));
    }

    public void error(String s, Object o) {
        this.logger.error(this.flattenLine(s, false), o);
    }

    public void error(String s, Object o, Object o1) {
        this.logger.error(this.flattenLine(s, false), o, o1);
    }

    public void error(String s, Object... objects) {
        this.logger.error(this.flattenLine(s, false), objects);
    }

    public void error(String s, Throwable throwable) {
        this.logger.error(this.flattenLine(s, false), throwable);
    }

    public boolean isErrorEnabled(Marker marker) {
        return this.logger.isErrorEnabled(marker);
    }

    public void error(Marker marker, String s) {
        this.logger.error(marker, this.flattenLine(s, false));
    }

    public void error(Marker marker, String s, Object o) {
        this.logger.error(marker, this.flattenLine(s, false), o);
    }

    public void error(Marker marker, String s, Object o, Object o1) {
        this.logger.error(marker, this.flattenLine(s, false), o, o1);
    }

    public void error(Marker marker, String s, Object... objects) {
        this.logger.error(marker, this.flattenLine(s, false), objects);
    }

    public void error(Marker marker, String s, Throwable throwable) {
        this.logger.error(marker, this.flattenLine(s, false), throwable);
    }

    private String flattenLine(String s, Boolean isDebug) {
        if (flattenLines) {
            String flattened = s.replaceAll("[\\n\\r]", " ");
            return isDebug ? "DBG: " + flattened : flattened;
        } else {
            return isDebug ? "DBG: " + s : s;
        }
    }
}

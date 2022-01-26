package LoadTestClient;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LoggerFactoryExt {
    private static HashMap<String, Logger> loggers = new HashMap();
    private static HashSet<String> infoLoggers = new HashSet();
    private static Boolean logAllLevels = false;

    public LoggerFactoryExt() {
    }

    public static Logger getLogger(Class clazz) {
        return getLogger(clazz, true);
    }

    public static Logger getLogger(Class clazz, Boolean flattenLines) {
        String name = clazz.getName();
        if (loggers.containsKey(name)) {
            return (Logger)loggers.get(name);
        } else {
            Logger logger = LoggerFactory.getLogger(clazz);
            LoggerWrapper loggerWrapper = new LoggerWrapper(logger, flattenLines);
            loggers.put(name, loggerWrapper);
            return loggerWrapper;
        }
    }

    public static boolean isInfo(String name) {
        return logAllLevels || infoLoggers.contains(name);
    }

    public static void setLoggerAsInfo(String name) {
        infoLoggers.add(name);
    }

    public static void removeLoggerAsInfo(String name) {
        infoLoggers.remove(name);
    }

    public static HashMap<String, Object> getInfoLoggers() {
        String host = null;
        if (StringUtils.isEmpty(host)) {
            host = "-";
        }

        HashMap<String, Object> returnVal = new HashMap();
        returnVal.put("logAllLevels", logAllLevels);
        List<String> infos = (List)infoLoggers.stream().collect(Collectors.toList());
        returnVal.put("host", host);
        returnVal.put("modules", infos);
        return returnVal;
    }

    public static HashMap<String, Object> getLoggers() {
        String host = null;
        if (StringUtils.isEmpty(host)) {
            host = "-";
        }

        HashMap<String, Object> returnVal = new HashMap();
        List<String> loggersNames = (List)loggers.keySet().stream().collect(Collectors.toList());
        returnVal.put("host", host);
        returnVal.put("modules", loggersNames);
        return returnVal;
    }

    public static List<String> getLoggersRaw() {
        List<String> loggersNames = (List)loggers.keySet().stream().collect(Collectors.toList());
        return loggersNames;
    }

    public static List<String> getInfoLoggersRaw() {
        List<String> loggersNames = (List)infoLoggers.stream().collect(Collectors.toList());
        return loggersNames;
    }

    /*
    public static HashMap<String, Object> clearAllInfoLoggers() {
        String host = ExceptionUtilsEx.getHost();
        if (StringUtils.isEmpty(host)) {
            host = "-";
        }

        HashMap<String, Object> returnVal = new HashMap();
        infoLoggers.clear();
        returnVal.put("host", host);
        returnVal.put("modules", "");
        return returnVal;
    } */

    public static void setLogAll(Boolean logAll) {
        logAllLevels = logAll;
    }

    public static Boolean getLogAll() {
        return logAllLevels;
    }
}


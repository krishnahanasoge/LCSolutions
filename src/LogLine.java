import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogLine {
    public List<String> reorderLines(int logFileSize, List<String> logLines)
    {
        Map<String, String> logLineStringMap = new HashMap<>();
        List<String> logLineIntegerList = new ArrayList<>();
        List<String> reorderedLines = new ArrayList<>();
        for(String logLine: logLines){
            String[] splitLog = logLine.split(" ");
            if(Character.isDigit(splitLog[1].charAt(0))){
                logLineIntegerList.add(logLine);
            }else{
                logLineStringMap.put(splitLog[0], logLine.substring(splitLog[0].length()));
            }
        }
        logLineStringMap.entrySet().stream().sorted(Map.Entry.<String, String>comparingByValue())
                .forEach(entry -> reorderedLines.add(entry.getKey() + " " +entry.getValue()));
        reorderedLines.addAll(logLineIntegerList);
        return reorderedLines;

    }
}

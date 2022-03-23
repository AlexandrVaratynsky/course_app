package com.andersen.course.app.quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DataGatherer {

    Map<String, String[]> sourceData;
    Map<String, String[]> outData;
    int courseID;
    int meetingID;

    public DataGatherer(Map<String, String[]> sourceData) {
        this.sourceData = sourceData;
        outData = new HashMap<String, String[]>();
    }

    public void setSourceData(Map<String, String[]> sourceData) {
        this.sourceData = sourceData;
    }

    public Map<String, String[]> getOutData() {
        if (outData.isEmpty() || (outData == null)) {
            this.gether();
        }
        return outData;
    }

    public void gether() {

        for (String key : sourceData.keySet()) {
            ArrayList<String> keySplitted = new ArrayList(Arrays.asList(key.split("\\-")));
            if (keySplitted.size() > 1) {
                String outMapKey = keySplitted.get(1);
                outData.put(outMapKey, new String[]{"0", "0", "0", "false"});
            }
        }

        for (String key : sourceData.keySet()) {
            ArrayList<String> keySplitted = new ArrayList(Arrays.asList(key.split("\\-")));
            if (keySplitted.size() > 1) {
                if (keySplitted.get(0).equals("bonus")) {
                    outData.get(keySplitted.get(1))[0] = sourceData.get(key)[0];
                }
                if (keySplitted.get(0).equals("question")) {
                    outData.get(keySplitted.get(1))[1] = sourceData.get(key)[0];
                }
                if (keySplitted.get(0).equals("answer")) {
                    outData.get(keySplitted.get(1))[2] = sourceData.get(key)[0];
                }
            } else {
                if (sourceData.get(key)[0].equals("checked")) {
                    outData.get(keySplitted.get(0))[3] = "true";
                }
                meetingID = Integer.parseInt(sourceData.get("meetingID")[0]);
                courseID = Integer.parseInt(sourceData.get("courseID")[0]);
            }

        }

    }

    @Override
    public String toString() {
        String result = "";
        if ((sourceData == null) || sourceData.isEmpty()) {
            return "sourse data is empty";
        }

        result = printMapwithArr(sourceData);
        result += "--------------------" + System.lineSeparator();
        result += printMap(outData);
        return result;
    }


    String printMapwithArr(Map<String, String[]> map) {
        String result = "";
        for (String s : map.keySet()) {
            result += s + ": ";
            for (String valS : map.get(s)) {
                result += valS + " ";
            }
            result += System.lineSeparator();
        }
        return result;
    }

    String printMap(Map<String, String[]> map) {
        String result = "";
        for (String s : map.keySet()) {
            result += s + ": ";
            for (String val : map.get(s)) {

                result += val + " ";
            }
            result += System.lineSeparator();
        }

        return result;
    }

    public int getCourseID() {
        return courseID;
    }

    public int getMeetingID() {
        return meetingID;
    }
}

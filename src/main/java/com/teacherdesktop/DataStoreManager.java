package com.teacherdesktop;

import com.teacherdesktop.entities.Workspace;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DataStoreManager {

    public static class DataStore {
        public static List<Workspace> Workspaces = new ArrayList<>();
        public static String hostIp;
    }

    public static void saveWorkSpaces(){
        setHostIp();
        Workspace workspace = new Workspace();
        workspace.ip = DataStore.hostIp;
    }

    private static void setHostIp(){
        try {
            Process process = Runtime.getRuntime().exec("arp -a");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                DataStore.hostIp = line.substring(line.indexOf("(") + 1, line.indexOf(")"));
                System.out.println(DataStore.hostIp);
                Workspace workspace = new Workspace();
                workspace.ip = line.substring(10, 24);
                DataStore.Workspaces.add(workspace);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

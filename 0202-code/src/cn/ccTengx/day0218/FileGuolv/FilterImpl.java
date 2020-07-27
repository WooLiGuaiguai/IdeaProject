package cn.ccTengx.day0218.FileGuolv;

import java.io.File;
import java.io.FileFilter;

public class FilterImpl implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        if(pathname.isDirectory()){
            return true;
        }
        return pathname.getName().toLowerCase().endsWith(".txt");

    }
}

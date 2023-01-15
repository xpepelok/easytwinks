package dev.xpepelok.easytwinks.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class DownloadFile {
    public static void downloadUsingNIO(String urlStr, String file, String name) throws IOException {
        URL url = new URL(urlStr);
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream fos = new FileOutputStream(file);
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        System.out.println("File " + name + " downloaded");
        fos.close();
        rbc.close();
    }
}

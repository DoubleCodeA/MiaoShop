package com.test;

import org.csource.fastdfs.*;
import org.junit.Test;

public class fast {
    @Test
    public void testDemo() throws Exception {
        ClientGlobal.init("I:\\tutu_parent\\tutu_shop_web\\src\\main\\resources\\config\\fdfs_client.conf");
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer connection = trackerClient.getConnection();

        StorageServer storageServer = null;
        StorageClient storageClient = new StorageClient(connection,storageServer);

        String[] jpgs = storageClient.upload_appender_file("C:\\Users\\Double\\Pictures\\Camera Roll\\timg.jpg", "jpg", null);
        for (String jpg : jpgs) {
            System.out.println(jpg);
        }

    }
}

package com.changgou.util;

import com.changgou.file.FastDFSFile;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * package name: com.changgou.util
 *
 * @author zmc
 * Date: 2021/8/20
 */
public class FastDFSClient {

    static{
        ClassPathResource classPathResource = new ClassPathResource("fdfs_client.conf");
        String path = classPathResource.getPath();
        try {
            ClientGlobal.init(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //上传图片

    public static String[] upload(FastDFSFile file) throws Exception {
//1、创建一个配置文件，用于配置tracker_server的ip和端口
        //2、加载配置文件生效

        //3、创建trackerclient对象
        TrackerClient trackerClient = new TrackerClient();
        //4、获取trackerServer对象
        TrackerServer trackerServer = trackerClient.getConnection();
        //5、创建storageClient对象
        StorageClient storageClient = new StorageClient(trackerServer,null);
        //6、执行一个方法(上传图片的方法) storageClient 提供了许多操作文件的方法
        //参数1 指定要上传文件饿的本地路径
        //参数
        NameValuePair[] meta_list = new NameValuePair[]{
          new NameValuePair(file.getName())
        };
        String[] pngs = storageClient.upload_file(file.getContent(),file.getExt(),meta_list);
        for (String png : pngs) {
            System.out.println(png);
        }

        return pngs;


    }

    //下载图片

    public static byte[] downFile(String groupName,String remoteFileName) throws Exception {
        //1、创建一个配置文件，用于配置tracker_server的ip和端口
        //2、加载配置文件生效
        //3、创建trackerclient对象
        TrackerClient trackerClient = new TrackerClient();
        //4、获取trackerServer对象
        TrackerServer trackerServer = trackerClient.getConnection();
        //5、创建storageClient对象
        StorageClient storageClient = new StorageClient(trackerServer,null);
        byte[] bytes = storageClient.download_file(groupName, remoteFileName);
        return bytes;
    }


    //删除图片

    public static boolean deleteFile(String groupName,String remoteFileName) throws Exception {
        //1、创建一个配置文件，用于配置tracker_server的ip和端口
        //2、加载配置文件生效
        //3、创建trackerclient对象
        TrackerClient trackerClient = new TrackerClient();
        //4、获取trackerServer对象
        TrackerServer trackerServer = trackerClient.getConnection();
        //5、创建storageClient对象
        StorageClient storageClient = new StorageClient(trackerServer,null);
        int i = storageClient.delete_file(groupName, remoteFileName);
        return i == 0;
    }

}

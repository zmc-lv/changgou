package com.changgou;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * package name: com.changgou
 *
 * @author zmc
 * Date: 2021/8/20
 */
public class FastdfsTest {


    //上传图片
    @Test
    public void upload() throws Exception {
    //1、创建一个配置文件，用于配置tracker_server的ip和端口
    //2、加载配置文件生效
        ClientGlobal.init("E:\\Project\\changgou-parent\\changgou-service\\changgou-service-file\\src\\main\\resources\\fdfs_client.conf");
    //3、创建trackerclient对象
        TrackerClient trackerClient = new TrackerClient();
    //4、获取trackerServer对象
        TrackerServer trackerServer = trackerClient.getConnection();
    //5、创建storageClient对象
        StorageClient storageClient = new StorageClient(trackerServer,null);
    //6、执行一个方法(上传图片的方法) storageClient 提供了许多操作文件的方法
        //参数1 指定要上传文件饿的本地路径
        //参数
        String[] pngs = storageClient.upload_file("C:\\Users\\zmc\\Desktop\\a.jpg", "jpg", null);
        for (String png : pngs) {
            System.out.println(png);
        }

    }

    //下载图片
    @Test
    public void download() throws Exception {
        //1、创建一个配置文件，用于配置tracker_server的ip和端口
        //2、加载配置文件生效
        ClientGlobal.init("E:\\Project\\changgou-parent\\changgou-service\\changgou-service-file\\src\\main\\resources\\fdfs_client.conf");
        //3、创建trackerclient对象
        TrackerClient trackerClient = new TrackerClient();
        //4、获取trackerServer对象
        TrackerServer trackerServer = trackerClient.getConnection();
        //5、创建storageClient对象
        StorageClient storageClient = new StorageClient(trackerServer,null);
        byte[] bytes = storageClient.download_file("group1", "M00/00/00/wKjThGEfzJqAPkzlABOt1D1Dwcw430.jpg");

        //写入磁盘
        File file = new File("e:/abc.jpg");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(bytes);
        fos.close();

    }



    //删除图片
    @Test
    public void delete() throws Exception {
        //1、创建一个配置文件，用于配置tracker_server的ip和端口
        //2、加载配置文件生效
        ClientGlobal.init("E:\\Project\\changgou-parent\\changgou-service\\changgou-service-file\\src\\main\\resources\\fdfs_client.conf");
        //3、创建trackerclient对象
        TrackerClient trackerClient = new TrackerClient();
        //4、获取trackerServer对象
        TrackerServer trackerServer = trackerClient.getConnection();
        //5、创建storageClient对象
        StorageClient storageClient = new StorageClient(trackerServer,null);
        int group1 = storageClient.delete_file("group1", "M00/00/00/wKjThGEfzJqAPkzlABOt1D1Dwcw430.jpg");
        if (group1 ==0) {
            System.out.println("成功");
        }
    }

    //获取图片信息

}

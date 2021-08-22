package com.changgou.file;

import com.changgou.util.FastDFSClient;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * package name: com.changgou.file
 *
 * @author zmc
 * Date: 2021/8/20
 */
@RestController
public class UploadController {

    @Value("${pic.url}")
    private String url;

    /**
     * 上传图片 接收页面传递过来的文件对象
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public String upload(MultipartFile file) throws Exception {
        if (! file.isEmpty()) {
            //获取文件的字节数据
            byte[] bytes = file.getBytes();
            //获取文件的名称 (按需求获取)
            String originalFilename = file.getOriginalFilename();
            //获取文件的扩展名
            String extension = StringUtils.getFilenameExtension(originalFilename);
            //使用工具类 上传图片到fastdfs
            String[] strings = FastDFSClient.upload(new FastDFSFile(originalFilename,bytes,extension));
            //拼接url 返回给页面
            String realPath=url+"/"+strings[0]+"/"+strings[1];
            return realPath;
        }
        return null;
    }
}

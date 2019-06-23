package com.game.dnf;

import com.game.dnf.util.FileUtil;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

@Component
public class DnfApplicationStartedEvent implements ApplicationListener<ApplicationStartedEvent> {


    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        try {
            String path = java.net.URLDecoder.decode(ResourceUtils.getURL("classpath:").getPath(), "utf-8");
            System.out.println("当前项目的路径" + path);

            File this_path = new File(path);
            //如果上传目录为/static/images/upload/，则可以如下获取：
            File upload = new File(this_path.getAbsolutePath(), "static/img/upload");
            if (!upload.exists()) upload.mkdirs();
            FileUtil.copy(new File("D:\\DNFfacedb"), upload, false);
            //System.out.println("upload url:"+upload.getAbsolutePath());
            //在开发测试模式时，得到的地址为：{项目跟目录}/target/static/images/upload/
            //在打包成jar正式发布时，得到的地址为：{发布jar包目录}/static/images/upload/
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.game.dnf.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileUtil {

    //复制文件  f 是目标文件  nf是目的文件  flag  true 整个复制  false 复制子目录
    public static void copy(File f, File nf, boolean flag) throws Exception {
        // 判断是否存在
        if (f.exists()) {
            // 判断是否是目录
            if (f.isDirectory()) {
                if (flag) {
                    // 制定路径，以便原样输出
                    nf = new File(nf + "/" + f.getName());
                    // 判断文件夹是否存在，不存在就创建
                    if (!nf.exists()) {
                        nf.mkdirs();
                    }
                }
                flag = true;
                // 获取文件夹下所有的文件及子文件夹
                File[] l = f.listFiles();
                // 判断是否为null
                if (null != l) {
                    for (File ll : l) {
                        // 循环递归调用
                        copy(ll, nf, flag);
                    }
                }
            } else {
                System.out.println("正在复制：" + f.getAbsolutePath());
                System.out.println("到：" + nf.getAbsolutePath() + "\\" + f.getName());
                // 获取输入流
                FileInputStream fis = new FileInputStream(f);
                // 获取输出流
                FileOutputStream fos = new FileOutputStream(nf + "/" + f.getName());
                byte[] b = new byte[1024];
                // 读取文件
                while (fis.read(b) != -1) {
                    // 写入文件，复制
                    fos.write(b);
                }
                fos.close();
                fis.close();
            }
        }
    }
}

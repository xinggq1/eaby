package com.xinggq.common.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SmsTest {

  public static void main(String[] args) throws Exception {
    SmsTest smsTest = new SmsTest();
    List<String> fpqqlshs = smsTest.getFpqqlshs();
    for(int i =0 ;i<fpqqlshs.size();i++){
      requestGet(fpqqlshs.get(i));
      Thread.sleep(1000);
    }




  }

  public static void requestGet(String fpqqlsh) throws Exception {
    // 获取我们的请求的url对象，需要传入请求的连接地址
    URL url = new URL("");
    // 通过调用openConnection 方法，获取网络连接
    URLConnection connection = url.openConnection();
    // 获取输入流，网页的所有内容都在这个输入流里面，将这个输入流转换成字符串就可以显示网页内容
    InputStream inputStream = connection.getInputStream();
    // 将输入流读到bufferedReader里面，然后就可以从bufferedReader里面获取字符串内容
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
    StringBuffer stringBuffer = new StringBuffer();
    String line = null;
    while ((line = bufferedReader.readLine()) != null) {

      stringBuffer.append(line);
      stringBuffer.append("\r\n");
    }
    System.out.println(stringBuffer.toString());

    // 关闭输入流
    inputStream.close();
  }


    private List<String> getFpqqlshs() throws IOException {

    List<String> fpqqlshs = new LinkedList<>();
    File file = new File("E:/as.txt");
    if(file.isFile() && file.exists()){
      InputStreamReader read = new InputStreamReader(
          new FileInputStream(file),"UTF-8");
      BufferedReader bufferedReader = new BufferedReader(read);
      String lineTxt = null;
      while((lineTxt = bufferedReader.readLine()) != null){
        fpqqlshs.add(lineTxt);
      }
      read.close();
    }else{
      System.out.println("找不到指定的文件");
    }
    if(fpqqlshs.size() != 933){
      System.out.println("数据数量不对");
      return Collections.emptyList();
    }
    return fpqqlshs;

  }

}

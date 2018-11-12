package io.eblock.eos4j.api.eosutils;

import io.eblock.eos4j.Rpc;
import io.eblock.eos4j.api.vo.transaction.Transaction;

import java.io.*;

/**
 * @ProjectName: eos4j
 * @Package: io.eblock.eos4j.api.eosutils
 * @ClassName: ${TransFerOneToMony}
 * @Description: eos 转账 多转一
 * @Author: skyhuihui
 * @CreateDate: 2018/10/27 21:34
 * @UpdateUser: Neil.Zhou
 * @UpdateDate: 2018/10/27 21:34
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class TransFerOneToMony {

    public static void main(String  [] args){
        readTxt();
    }

    public  static  void  transfer(String pk, String contractAccount, String from, String to, String quantity){
        Rpc rpc = new Rpc("https://rpc.eosys.io");

        System.out.println("============= 转账 ===============");
        try {
            Transaction t1 = rpc.eoswinonennn(pk, contractAccount, from, to, quantity, "Transfer bonus"); //  这不是个转账操作， 是调用  action   转账参考  rpc类
            System.out.println("转账成功 = " + t1.getTransactionId()+" \n ");
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    //读文件数据 发转账  多转1
    public  static  void  readTxt(){
        File f1 = new File("5KDBRoRHGMu5NyPbHRVsqP1Fa9NhcUa6TxZ7mTWkdT74WUBgidn");
        File f2 = new File("mytestmy2111");

        FileInputStream fis1 = null;
        FileInputStream fis2 = null;
        InputStreamReader isr1 = null;
        InputStreamReader isr2 = null;
        //用于包装InputStreamReader,提高处理性能。因为BufferedReader有缓冲的，而InputStreamReader没有。
        BufferedReader br1 = null;
        BufferedReader br2 = null;
        try {
            String str1 = "";
            String str2 = "";
            fis1 = new FileInputStream(f1);
            fis2 = new FileInputStream(f2);
            // 从文件系统中的某个文件中获取字节
            // InputStreamReader 是字节流通向字符流的桥梁,
            isr1 = new InputStreamReader(fis1);
            isr2 = new InputStreamReader(fis2);
            // 从字符输入流中读取文件中的内容,封装了一个new InputStreamReader的对象
            br1 = new BufferedReader(isr1);
            br2 = new BufferedReader(isr2);
            while ((str1 = br1.readLine()) != null && (str2 = br2.readLine()) != null) {
                    str1 = str1.replaceAll("\\s*", "");
                    str2 = str2.replaceAll("\\s*", "");
                    System.out.println(str1+"    "+str2);
                    transfer(str1,"eoswinonennn",str2, "eoswinonennn","0.0010 EOS");
            }
            // 当读取的一行不为空时,把读到的str的值赋给str1
        } catch (FileNotFoundException e) {
            System.out.println("找不到指定文件");
        } catch (IOException e) {
            System.out.println("读取文件失败");
        } finally {
            try {
                br1.close();
                isr1.close();
                fis1.close();
                br2.close();
                isr2.close();
                fis2.close();
                // 关闭的时候最好按照先后顺序关闭最后开的先关闭所以先关s,再关n,最后关m
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

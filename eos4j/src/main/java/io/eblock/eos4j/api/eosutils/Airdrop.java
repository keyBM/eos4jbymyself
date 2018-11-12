package io.eblock.eos4j.api.eosutils;

import io.eblock.eos4j.Rpc;
import io.eblock.eos4j.api.vo.transaction.Transaction;

import java.io.*;
import java.math.BigInteger;

/**
 * @ProjectName: eos4j
 * @Package: io.eblock.eos4j.api.eosutils
 * @ClassName: ${Airdrop}
 * @Description: 批量转账  一转多
 * @Author: skyhuihui
 * @CreateDate: 2018/10/15 15:30
 * @UpdateUser: Neil.Zhou
 * @UpdateDate: 2018/10/15 15:30
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class Airdrop {

    public static void main(String  [] args){
        readTxt();
    }

    public  static  void  transfer(String to, String quantity){
        Rpc rpc = new Rpc("https://api-v2.eosasia.one");//  请求太多次会被封ip

        System.out.println("============= 转账 ===============");
        try {
            Transaction t1 = rpc.transfer("5KDBRoRHGMu5NyPbHRVsqP1Fa9NhcUa6TxZ7mTWkdT74WUBgidn","eosio.token", "mytestmy2111" ,to, quantity, "第一次转账测试");
            System.out.println("转账成功 = " + t1.getTransactionId()+" \n ");
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    //读文件数据 发转账  一转多
    public  static  void  readTxt(){
        File f2 = new File("C:\\Users\\Keyboard Man\\Desktop");
        FileInputStream fis = null;
        InputStreamReader isr = null;
        //用于包装InputStreamReader,提高处理性能。因为BufferedReader有缓冲的，而InputStreamReader没有。
        BufferedReader br = null;
        try {
            String str = "";
            fis = new FileInputStream(f2);
            // 从文件系统中的某个文件中获取字节
            // InputStreamReader 是字节流通向字符流的桥梁,
            isr = new InputStreamReader(fis);
            // 从字符输入流中读取文件中的内容,封装了一个new InputStreamReader的对象
            br = new BufferedReader(isr);
            while ((str = br.readLine()) != null) {
                str = str.replaceAll("\\s*", "");
//                String  [] s = str.split(",");
//                System.out.println(s[0]+"    "+s[1]);
//                s[1] = "0.3000";
//                transfer(s[0],s[1]+" LOVE");
                transfer(str,"0.0500 EOS");
            }
            // 当读取的一行不为空时,把读到的str的值赋给str1
        } catch (FileNotFoundException e) {
            System.out.println("找不到指定文件");
        } catch (IOException e) {
            System.out.println("读取文件失败");
        } finally {
            try {
                br.close();
                isr.close();
                fis.close();
                // 关闭的时候最好按照先后顺序关闭最后开的先关闭所以先关s,再关n,最后关m
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

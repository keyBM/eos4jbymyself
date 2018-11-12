package io.eblock.eos4j.api.eosutils;

import io.eblock.eos4j.Ecc;
import io.eblock.eos4j.Rpc;
import io.eblock.eos4j.api.vo.transaction.Transaction;

import java.io.File;
import java.io.FileWriter;

/**
 * @ProjectName: eos4j
 * @Package: io.eblock.eos4j.utils
 * @ClassName: ${CreateAccount}
 * @Description: 批量创建eos账户
 * @Author: skyhuihui
 * @CreateDate: 2018/10/26 15:09
 * @UpdateUser: Neil.Zhou
 * @UpdateDate: 2018/10/26 15:09
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class CreateAccount {

    public static void main(String  [] args) throws Exception {

        creatAccount();
    }

    public  static  void  creatAccount() throws Exception {
        Rpc rpc = new Rpc("http://39.108.231.157:30065");
        File f1 = new File("C:\\Users\\Keyboard Man\\Desktop\\myaccount\\mytestmy2111.txt");
        FileWriter fileWriter = new FileWriter(f1, true);
        File f2 = new File("C:\\Users\\Keyboard Man\\Desktop\\myaccount\\mytestmy2111.txt");
        FileWriter fileWriter1 = new FileWriter(f2, true);
        File f3 = new File("C:\\Users\\Keyboard Man\\Desktop\\myaccount\\mytestmy2111.txt");
        FileWriter fileWriter2 = new FileWriter(f3, true);

        for (int i = 4111; i <= 4155; i++) {

            if (i % 10 == 6) {
                i += 4;
                continue;
            }
            System.out.println("============= 通过种子生成私钥 ===============");
            String pk = Ecc.seedPrivate("!@#$%^&*(lajdlkjaksjdlkjaskldM<>?87126162kajsdjlaksd kajdlkaslkd heiuheijpe f[a- si0ausd9asd ahsdvcyasdcasdc ajhsdg8ca"
                    + "we asds JHDKAHDKKASDKJALSKDKA ooidjajsdua09sid0asdo[paksdajsdlklasdmlk FJKLIKNLK;B/;LP[P'NC;PO'; OOPO;L0["
                    + "XP'C'[FG["
                    + "192187289091073289"+i+"72309289838982");
            System.out.println("private key :" + pk + "\n");

            System.out.println("============= 通过私钥生成公钥 ===============");
            String pu = Ecc.privateToPublic(pk);
            System.out.println("public key :" + pu + " \n ");
            String name = i+"mytestmy";

            try {
                System.out.println(name);
                Transaction t1 = rpc.createAccount("5KQwrPbwdL6PhXujxW37FSSQZ1JiwsST4cqQzDeyXtP79zkvFD3"
                        ,  "eosio", name, pu, pu,
                        2548L, "0.0020 EOS", "0.2000 EOS", 0L);
                System.out.println(" 创建成功= " + t1.getTransactionId() + " \n ");
//                fileWriter.write(pk+"\r\n");
//                fileWriter1.write(pu+"\r\n");
//                fileWriter2.write(i+"mytestmy\r\n");  会因为 网络原因写入本地失败， 分开写入
                System.out.println("私钥："+pk+"     公钥："+pu+"    账户名："+name);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        fileWriter.close();
        fileWriter1.close();
        fileWriter2.close();

    }
}

package io.eblock.eos4j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import io.eblock.eos4j.api.exception.ApiException;
import io.eblock.eos4j.api.vo.ChainInfo;
import io.eblock.eos4j.api.vo.TableRows;
import io.eblock.eos4j.api.vo.TableRowsReq;
import io.eblock.eos4j.api.vo.account.Account;
import io.eblock.eos4j.api.vo.transaction.Transaction;

public class Test {

	static final String eosjs_transfer_seriz = "00f2d4142123e95d0000c85353840ccdb486010000000000045359530000000019e6b58be8af95313233616263646f2e2f2c2e2f214023232425";

	static final String eosjs_account_seriz = "0000000000ea30550002a2f164772b5601000000010003ee4221c9c3f4f62646e3c758dbb8abaae506a559f67148a76968fa6b0f0868140100000001000000010003ba8de2f029cae85e7ca5c9f591bb17b86d750c5116cec30d94100e16e446d41501000000";

	public static void main(String[] args){
		System.out.println("******************* Ecc Start *******************\n");
		
		
		System.out.println("============= 通过种子生成私钥 ===============");
		String pk = Ecc.seedPrivate("!@#$%^&*(lajdlkjaksjdlkjaskldM<>?87126162kajsdjlaksd kajdlkaslkd heiuheijpe f[a- si0ausd9asd ahsdvcyasdcasdc ajhsdg8ca"
				+ "we asds JHDKAHDKKASDKJALSKDKA ooidjajsdua09sid0asdo[paksdajsdlklasdmlk FJKLIKNLK;B/;LP[P'NC;PO'; OOPO;L0["
				+ "XP'C'[FG["
				+ "19218728909107328972309289832098012");
		System.out.println("private key :" + pk +"\n");

		System.out.println("============= 通过私钥生成公钥 ===============");
		String pu = Ecc.privateToPublic(pk);
		System.out.println("public key :" + pu + " \n ");

		System.out.println("============= 自定义数据签名 ===============");
		String sign = Ecc.sign(pk,"is京東價as看到可可是是是@#￥%……&*（CVBNM《d ");
		System.out.println("sign :" + sign + " \n ");
		
		System.out.println("============= 转账数据序列化 ===============");
		String data = Ecc.parseTransferData("fromaccount", "toaccount", "10.0020 SYS", "测试123abcdo./,./!@##$%");
		System.out.println("seriz data :" + data);
		System.out.println("transfer eq eosjs seriz " + data.equals(eosjs_transfer_seriz)+" \n ");

		System.out.println("============= 创建账户数据序列化 ===============");
		String data1 = Ecc.parseAccountData("eosio", "espritbloc1.","EOS8eAX54cJtAngV2V22WZhRCW7e4sTAZz1mC5U22vp8mAGuFdMXx","EOS8FPooohZiiCAYXahWCQRxgXXzUbS2gNELAeYCUgGdDMbd2FHQT");
		System.out.println("seriz data :" + data1);
		System.out.println("account eq eosjs seriz " + data1.equals(eosjs_account_seriz));

		
		System.out.println("\n******************* Ecc End *******************\n\n\n");
		
		System.out.println("******************* Rpc Start *******************\n");
		
		Rpc rpc = new Rpc("http://api-kylin.eoshenzhen.io:8890");
		
		
		System.out.println("============= 转账 ===============");
		try {
			Account ac = rpc.getAccount("keyboardman1");
			System.out.println("我的麒麟账户 = " + ac.getAccountName());
			System.out.println("我的麒麟### = " + ac.getCreated());
			System.out.println("我的麒麟### = " + ac.getLastCodeUpdate());
			ChainInfo ci = rpc.getChainInfo();
			System.out.println("麒麟链ID = " + ci.getChainId());
			System.out.println("链版本号 = " + ci.getServerVersion());
			System.out.println("麒麟最高块 = " + ci.getHeadBlockNum());
			System.out.println("麒麟不可逆转块 = " + ci.getLastIrreversibleBlockNum());
			Long sum = Integer.parseInt(ci.getHeadBlockNum())-ci.getLastIrreversibleBlockNum();
			System.out.println("差几个块 = " + sum);
			Transaction t1 = rpc.ping("5JM1vxSbqeinDHLj86ZwY3sy3WkZTo81vm6QZ7VxNwrgeefuc1Z","keyboardman1", "keyboardman1","", "", "");
			System.out.println("转账成功 = " + t1.getTransactionId()+" \n ");
			System.out.println("============= 计数器 ===============");
			System.out.println("============= 计数器 ===============");
			System.out.println("============= 计数器 ===============");
			Transaction t2 = rpc.counter("5JNy9rWgb5whTcn5h9TaYJLwDaCdirFW2yuev1k2UzTfhFuNLYD","countercontr","countercontr","","","");
			System.out.println("转账成功 = " + t2.getTransactionId()+" \n ");
			System.out.println("============= 查表 ===============");
			System.out.println("============= 查表 ===============");
			System.out.println("============= 查表 ===============");
			TableRowsReq gettablerows = new TableRowsReq();
			gettablerows.setCode("countercontr");
			gettablerows.setScope("countercontr");
			gettablerows.setTable("counter");
			TableRows tr = rpc.getTableRows(gettablerows);
			System.out.println(tr.getRows());
			System.out.println("============= 插入学生 ===============");
			System.out.println("============= 插入学生 ===============");
			System.out.println("============= 插入学生 ===============");
			Transaction t3 = rpc.add("5HsP1KnVGfLtCmbwvxYSgxPecGhMn1EbUzmUiZsWnRMZufzASso","student12345","student12345","","","");
			System.out.println("转账成功 = " + t3.getTransactionId()+" \n ");
			System.out.println("============= 查学生表 ===============");
			System.out.println("============= 查学生表 ===============");
			System.out.println("============= 查学生表 ===============");
			TableRowsReq gettablerows1 = new TableRowsReq();
			gettablerows1.setCode("student12345");
			gettablerows1.setScope("student12345");
			gettablerows1.setTable("student");
			TableRows tr1 = rpc.getTableRows(gettablerows1);
			System.out.println(tr1.getRows());
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		/*System.out.println("============= 创建账户并且抵押 ===============");
		try {	
			Transaction t2 = rpc.createAccount("5KQwrPbwdL6PhXujxW37FSSQZ1JiwsST4cqQzDeyXtP79zkvFD3","eosio","hahahawojiu1", "EOS63MipDrXwY23nGrPe73dCMhQgKEV5nzNt5v4axRLwTnSV7F4Tu","EOS8hKMkzwWg28GTnfscmYdJrC8XfSKoLTaSZRrvXLr1kFgrZra8N", 8192l, "0.01 SYS","0.01 SYS", 0l);
			System.out.println("创建成功 = " + t2.getTransactionId()+" \n ");
		}catch(Exception ex) {
			ex.printStackTrace();
		}*/
		/*System.out.println("============= 创建账户不抵押 ===============");
		try {	
			Transaction t3 = rpc.createAccount("5JM1vxSbqeinDHLj86ZwY3sy3WkZTo81vm6QZ7VxNwrgeefuc1Z","keyboardman1","gtwdsf235412", "EOS63MipDrXwY23nGrPe73dCMhQgKEV5nzNt5v4axRLwTnSV7F4Tu","EOS8hKMkzwWg28GTnfscmYdJrC8XfSKoLTaSZRrvXLr1kFgrZra8N", 8192l);
			System.out.println("创建成功 = " + t3.getTransactionId()+" \n ");
		}catch(Exception ex) {
			ex.printStackTrace();
		}*/
		
		/*System.out.println("============= 代理投票 ===============");
		try {
			List<String> produces = new ArrayList<>();
			produces.add("pppppeeeeooo");
			produces.add("mdddssssddds");
			produces.add("mdjddjddddds");
			rpc.voteproducer("5KQwrPbwdL6PhXujxW37FSSQZ1JiwsST4cqQzDeyXtP79zkvFD3", "epskdkdsddss","iuewjdkslsdc",produces);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/*System.out.println("============= 关闭余额为0的token ===============");
		try {
			rpc.close("5KQwrPbwdL6PhXujxW37FSSQZ1JiwsST4cqQzDeyXtP79zkvFD3", "合约账户", "关闭账户", "0.0000 IPOS");
		}catch(ApiException e) {
			e.printStackTrace();
		}catch(Exception ex) {
			ex.printStackTrace();
		}*/
		System.out.println("\n******************* Rpc End *******************");
	}
}
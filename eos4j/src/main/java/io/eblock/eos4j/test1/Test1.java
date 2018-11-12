package io.eblock.eos4j.test1;

import java.util.List;

import io.eblock.eos4j.Rpc;
import io.eblock.eos4j.api.vo.ChainInfo;
import io.eblock.eos4j.api.vo.TableRows;
import io.eblock.eos4j.api.vo.TableRowsReq;
import io.eblock.eos4j.api.vo.TransactionInfo;
import io.eblock.eos4j.api.vo.account.Account;
import io.eblock.eos4j.api.vo.transaction.Processed;
import io.eblock.eos4j.api.vo.transaction.Transaction;

public class Test1 {
	public static void main(String[] args) throws Exception {
		Rpc rpc = new Rpc("https://api-kylin.eoslaomao.com");
		//Rpc rpc = new Rpc("http://39.108.231.157:30065");
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
		
		/*System.out.println("============= 查学生表 ===============");
		System.out.println("============= 查学生表 ===============");
		System.out.println("============= 查学生表 ===============");
		TableRowsReq gettablerows1 = new TableRowsReq();
		gettablerows1.setCode("student12345");
		gettablerows1.setScope("student12345");
		gettablerows1.setTable("student");
		TableRows tr1 = rpc.getTableRows(gettablerows1);
		System.out.println(tr1.getRows());*/
		
		
/*		System.out.println("============= 插入评价 ===============");
		System.out.println("============= 插入评价 ===============");
		System.out.println("============= 插入评价 ===============");
		for (int i = 0; i < 1; i++) {
			String str = ""+i;
			Transaction t1 = rpc.addPingjia("5JaMdr5GN1TsYtQ3LDmhfSUVR5dce2JUJWLizuUg4yW3u4bbidk","pingjia12345","pingjia12345",str,"老师人很好，讲的很细节。","耐心");
			System.out.println("插入成功"+t1.getTransactionId());
			Processed processed = t1.getProcessed();
			System.out.println("返回的transaction对象"+processed.getScheduled());
			System.out.println("返回的transaction对象"+processed.getId());
			System.out.println("返回的transaction对象"+processed.getElapsed());
			System.out.println("返回的transaction对象"+processed.getNetUsage());
			System.out.println("返回的transaction对象"+processed.getReceipt());
			System.out.println("返回的transaction对象的哈希：：："+processed.getId());
			System.out.println("返回的transaction对象的区块高度：：："+processed.getBlocknum());
			System.out.println("返回的transaction对象的时间戳：：："+processed.getBlocktime());
			System.out.println("============= 查询事务ID ===============");
			System.out.println("============= 查询事务ID ===============");
			TransactionInfo ti = rpc.getTransaction(t1.getTransactionId());
			System.out.println("区块高度 ： "+ti.getBlockNum());
			System.out.println("时间戳 ： "+rpc.getBlock(ti.getBlockNum()+"").getTimestamp());
			System.out.println("区块HASH ： "+rpc.getBlock(ti.getBlockNum()+"").getId());
		}*/
		
		/*TableRowsReq gettablerows1 = new TableRowsReq();
		gettablerows1.setCode("pingjia12345");
		gettablerows1.setScope("pingjia12345");
		gettablerows1.setTable("pingjia");
		gettablerows1.setLimit(300);
		TableRows tr1 = rpc.getTableRows(gettablerows1);
		List list = tr1.getRows();
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}*/
		
		
		//代币转账
		System.out.println("======================转账===========================");
		Transaction tran = rpc.transfer("5JaMdr5GN1TsYtQ3LDmhfSUVR5dce2JUJWLizuUg4yW3u4bbidk","eosiotokena1", "pingjia12345","keyboardman1", "100.00 SAD", "");
		System.out.println("给账号keyboardman1转账“SAD”成功 = " + tran.getTransactionId()+" \n ");
		Processed processed = tran.getProcessed();
		System.out.println("返回的transaction对象的哈希：：："+processed.getId());
		System.out.println("返回的transaction对象的区块高度：：："+processed.getBlocknum());
		System.out.println("返回的transaction对象的时间戳：：："+processed.getBlocktime());
		TableRowsReq gettablerows1 = new TableRowsReq();
		gettablerows1.setCode("eosiotokena1");
		gettablerows1.setScope("keyboardman1");
		gettablerows1.setTable("accounts");
		TableRows tr1 = rpc.getTableRows(gettablerows1);
		System.out.println(tr1.getRows());
	}
}

package io.eblock.eos4j.api.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionInfo {

	
	@JsonProperty("block_num")
	private Long blockNum;
	
	public Long getBlockNum() {
		return blockNum;
	}

	public void setBlockNum(Long blockNum) {
		this.blockNum = blockNum;
	}
	
}

package org.crawl;

public class ChinaRegionsInfo {
	/** 
     * 行政区域编码 
     */ 
    private String code; 
 
    /** 
     * 行政区域名称 
     */ 
    private String name; 
 
    /** 
     * 行政区域类型，1:省份，2：城市，3：区或者县城 
     */ 
    private Integer type; 
 
    /** 
     * 上一级行政区域编码 
     */ 
    private String parentCode;

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * @return the parentCode
	 */
	public String getParentCode() {
		return parentCode;
	}

	/**
	 * @param parentCode the parentCode to set
	 */
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	} 
    
}

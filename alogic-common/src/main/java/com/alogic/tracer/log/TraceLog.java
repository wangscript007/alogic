package com.alogic.tracer.log;

import java.lang.reflect.Field;
import com.anysoft.stream.Flowable;

/**
 * 追踪日志
 * 
 * @author duanyy
 * @since 1.6.5.3
 * 
 * @version 1.6.5.6 [20160523 duanyy] <br>
 * - 增加id()接口
 * 
 * @version 1.6.5.11 [20160603 duanyy] <br>
 * - tracelog增加type字段 <br>
 * 
 * @version 1.6.7.1 [20170117 duanyy] <br>
 * - trace日志调用链中的调用次序采用xx.xx.xx.xx字符串模式 <br>
 */
public class TraceLog implements Comparable<TraceLog>,Flowable{
	/**
	 * 序列号
	 */
	protected String sn;
	
	/**
	 * 调用次序
	 */
	protected String order;
	
	/**
	 * 方法类型
	 */
	protected String type;
	
	/**
	 * 方法
	 */
	protected String method;
	
	/**
	 * 开始时间
	 */
	protected long startDate;
	
	/**
	 * 调用时长
	 */
	protected long duration;
	
	/**
	 * 结果代码
	 */
	protected String code;
	
	/**
	 * 原因
	 */
	protected String reason;
	
	/**
	 * 内容长度
	 */
	protected long contentLength;
	
	@Override
	public String id(){
		return sn;
	}	
	
	@Override
	public String getValue(String varName, Object context, String defaultValue) {
		try {
			Class<?> clazz = this.getClass();
			Field field = clazz.getField(varName);
			if (field == null){
				return defaultValue;
			}
			
			Object found = field.get(this);
			return found.toString();
		}catch (Exception ex){
			return defaultValue;
		}
	}

	@Override
	public String getRawValue(String varName, Object context, String dftValue) {
		return getValue(varName,context,dftValue);
	}

	@Override
	public Object getContext(String varName) {
		return null;
	}

	@Override
	public String getStatsDimesion() {
		return code;
	}

	@Override
	public int compareTo(TraceLog o) {
		int ret = sn.compareTo(o.sn);
		if (ret == 0){
			ret = order.compareTo(o.order);
		}
		return ret;
	}

	public TraceLog sn(String sn) {
		this.sn = sn;
		return this;
	}
	
	public String sn(){
		return sn;
	}

	public TraceLog order(String order) {
		this.order = order;
		return this;
	}
	
	public String order(){
		return order;
	}
	
	public String type(){
		return type;
	}
	
	public TraceLog type(String type){
		this.type = type;
		return this;
	}

	public TraceLog method(String method) {
		this.method = method;
		return this;
	}
	
	public String method(){
		return method;
	}

	public TraceLog startDate(long startDate) {
		this.startDate = startDate;
		return this;
	}
	
	public long startDate(){
		return startDate;
	}

	public TraceLog duration(long duration) {
		this.duration = duration;
		return this;
	}
	
	public long duration(){
		return duration;
	}

	public TraceLog code(String code) {
		this.code = code;
		return this;
	}
	
	public String code(){
		return code;
	}

	public TraceLog reason(String reason) {
		this.reason = reason;
		return this;
	}
	
	public String reason(){
		return reason;
	}
	
	public TraceLog contentLength(long length){
		this.contentLength = length;
		return this;
	}
	
	public long contentLength(){
		return this.contentLength;
	}
}

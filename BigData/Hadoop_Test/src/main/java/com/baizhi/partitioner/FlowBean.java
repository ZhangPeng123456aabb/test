package com.baizhi.partitioner;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class FlowBean implements Writable {

    private String phone;
    private Long upFlow;
    private Long downFlow;
    private Long sumFlow;

    public FlowBean() {
    }

    public FlowBean(String phone, Long upFlow, Long downFlow, Long sumFlow) {
        this.phone = phone;
        this.upFlow = upFlow;
        this.downFlow = downFlow;
        this.sumFlow = sumFlow;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getUpFlow() {
        return upFlow;
    }

    public void setUpFlow(Long upFlow) {
        this.upFlow = upFlow;
    }

    public Long getDownFlow() {
        return downFlow;
    }

    public void setDownFlow(Long downFlow) {
        this.downFlow = downFlow;
    }

    public Long getSumFlow() {
        return sumFlow;
    }

    public void setSumFlow(Long sumFlow) {
        this.sumFlow = sumFlow;
    }


    @Override
    public String toString() {
        return "" +
                "phone='" + phone + '\'' +
                " upFlow=" + upFlow +
                " downFlow=" + downFlow +
                " sumFlow=" + sumFlow ;
    }

    /*
     * 序列化 编码
     * */
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this.phone);
        dataOutput.writeLong(this.upFlow);
        dataOutput.writeLong(this.downFlow);
        dataOutput.writeLong(this.sumFlow);
    }


    /*
     * 反序列化  解码
     *f */
    public void readFields(DataInput dataInput) throws IOException {

        this.phone = dataInput.readUTF();
        this.upFlow = dataInput.readLong();
        this.downFlow = dataInput.readLong();
        this.sumFlow = dataInput.readLong();

    }
}

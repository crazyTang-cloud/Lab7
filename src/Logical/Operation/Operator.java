package Logical.Operation;

import Logical.Data.OpData;

public interface Operator {
    /**
     * 运算规律：加法、减法
     * @param data
     * @return 计算结果
     */
    public int Op_rule(OpData data);

    /**
     * 随机产生操作数
     * @return 操作数
     */
    public OpData RandomData();

    /**
     * 从1到n做累加
     * @param n
     * @return
     */
    public int Accumulation(int n);


    public int Circulation(int n);


    public int Role(int n);

}

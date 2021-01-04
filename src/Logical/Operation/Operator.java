package Logical.Operation;

import Logical.Data.OpData;

public interface Operator {
    /**
     * ������ɣ��ӷ�������
     * @param data
     * @return ������
     */
    public int Op_rule(OpData data);

    /**
     * �������������
     * @return ������
     */
    public OpData RandomData();

    /**
     * ��1��n���ۼ�
     * @param n
     * @return
     */
    public int Accumulation(int n);


    public int Circulation(int n);


    public int Role(int n);

}

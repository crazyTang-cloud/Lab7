package Logical.Operation;

import Logical.ALU.Add;
import Logical.ALU.Algorithm;
import Logical.ALU.Sub;
import Logical.Data.OpData;
import Logical.RGD.Random;

public class Operation implements Operator{

    Algorithm alu;
    Random r = new Random();

    @Override
    public int Op_rule(OpData data) {
        switch(data.getData3()) {
            case 0:
                alu = new Add();
                return alu.Option(data.getData1(), data.getData2());
            case 1:
                alu = new Sub();
                return alu.Option(data.getData1(), data.getData2());
            default:
                return -1;
        }
    }


    @Override
    public OpData RandomData() {

        return r.Random();
    }

    @Override
    public int Accumulation(int n) {
        if(n<=0){
            return -1;
        }
        else {
            int sum = 0;
            for(int i = 1;i <= n;i++){
                sum = sum+i;
            }
            return sum;
        }
    }

    @Override
    public int Circulation(int n) {
        int sum = n;
        while(n<10&&n>=1){
            n++;
            sum = sum+n;
        }
        return  sum;
    }

    @Override
    public int Role(int n) {
        n=n+1;
        n=n+2;
        n=n+3;
        return n;
    }


}

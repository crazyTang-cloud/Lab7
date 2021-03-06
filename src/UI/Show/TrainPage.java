package UI.Show;

import Logical.Data.OpData;
import Logical.Operation.Operation;
import Logical.Operation.Operator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrainPage {

    JButton btnNew = new JButton("下一题");   //出题按钮
    //JButton startJButton = new JButton("开始");   //出题按钮
    JLabel lblA = new JLabel(); // 操作数A
    JLabel lblOp = new JLabel(); // 操作Op
    JLabel lblB = new JLabel(); // 操作数B
    JLabel label5 = new JLabel(); // =号
    JTextField txtAnswer = new JTextField();    //答案框

    private int count1 = 0;    //记录总题数
    JLabel sumExercise = new JLabel();

    private int count2 = 0;    //记录正确题数
    JLabel rightExercise = new JLabel();


    Integer a = 0, b = 0;
    String op = "+";
    int result = 0;

    public void show(){

        Operator operator = new Operation();
        OpData data = operator.RandomData();
        a = data.getData1();
        b = data.getData2();
        result = operator.Op_rule(data);
        int c = data.getData3();
        switch(c) {
            case 0:op="+";break;
            case 1:op="-";break;
        }

        JFrame frame = new JFrame();
        JPanel panel;
        panel = (JPanel) frame.getContentPane();
        panel.setLayout(null);



        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ImageIcon backgroundIcon = new ImageIcon("./source/imgs/背景2.jpg");
        JLabel imageJLabel = new JLabel(backgroundIcon);

        // 获取屏幕大小
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        // 设置窗体信息
        int frameWidth = 800;
        int frameHeight = 550;
        int frameX = (screenWidth - frameWidth) / 2;
        int frameY = (screenHeight - frameHeight) / 2;
        // 将窗体设置在屏幕中央
        frame.setBounds(frameX, frameY, frameWidth, frameHeight);
        imageJLabel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        frame.getLayeredPane().add(imageJLabel, Integer.MIN_VALUE);


        btnNew.setFont(new Font("Dialog", Font.BOLD, 25));
        btnNew.setBounds(117, 191, 127, 50);
        btnNew.setBackground(new Color(224, 255, 255));
        panel.add(btnNew);


        lblA.setBounds(92, 122, 61, 36);
        lblA.setText(a.toString());
        //设置字体
        lblA.setFont(new Font("Dialog",Font.PLAIN,24));
        panel.add(lblA);

        lblOp.setBounds(170, 121, 51, 37);
        lblOp.setText(op);
        lblOp.setFont(new Font("Dialog",Font.PLAIN,24));
        panel.add(lblOp);

        lblB.setBounds(241, 122, 61, 36);
        lblB.setText(b.toString());
        lblB.setFont(new Font("Dialog",Font.PLAIN,24));
        panel.add(lblB);

        label5.setBounds(321, 122, 42, 36);
        label5.setText("=");
        label5.setFont(new Font("Dialog",Font.PLAIN,24));
        panel.add(label5);


        txtAnswer.setBounds(379, 122, 113, 48);
        txtAnswer.setFont(new Font("Dialog",Font.PLAIN,24));
        panel.add(txtAnswer);

        sumExercise.setBounds(600, 100, 113, 48);
        sumExercise.setText("总题数:"+count1);
        sumExercise.setFont(new Font("宋体",Font.PLAIN,24));
        panel.add(sumExercise);

        rightExercise.setBounds(600, 150, 115, 48);
        rightExercise.setText("正确题数:"+count2);
        rightExercise.setFont(new Font("宋体",Font.PLAIN,20));
        panel.add(rightExercise);


        btnNew.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = txtAnswer.getText();
                Integer d = null;
                if(str.length()!=0)
                    d = Integer.valueOf(str);
                if(d==null||d!=result) {
                    return;
                }
                String disp = ""+ " "+a +" "+ op +" "+ b +" "+ "=" +" "+ str +" ";
                count2++;
                count1++;
                Operator operator = new Operation();
                OpData data = operator.RandomData();
                a = data.getData1();
                b = data.getData2();
                result = operator.Op_rule(data);
                int c = data.getData3();
                switch(c) {
                    case 0:op="+";break;
                    case 1:op="-";break;
                }
                sumExercise.setText("总题数:"+count1);
                rightExercise.setText("正确题数:"+count2);
                lblA.setText(a.toString());
                lblB.setText(b.toString());
                lblOp.setText(op);
                txtAnswer.setText("");
            }
        });



        panel.add(imageJLabel);
        panel.setOpaque(false);    //将内容面板设置为透明；背景图片位于内容面板下方
        frame.setVisible(true);
    }

    public static void main(String[] arg0){
        TrainPage trainPage = new TrainPage();
        trainPage.show();
    }
}

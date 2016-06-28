package Stacks;

/**
 * Created by Prashant on 6/27/16.
 */
public class TwoStacks {
    int[] a;
    int top1;
    int top2;
    int size;
    public TwoStacks(int n) {
        a = new int[n];
        size = n;
        top1 = -1;
        top2 = size;
    }

    public void push1(int val) {
        if(top1 < top2-1) {
            top1++;
            a[top1] = val;
        } else {
            System.out.println("Stackoverflow! stack 1");
            return;
        }
    }

    public int pop1() {
      int val = 0;
      if(top1>=0) {
          val = a[top1--];
          return val;
      } else {
          System.out.println("Stack empty!");
          return -1;
      }
    }


    public void push2(int val) {
        if(top1 < top2-1) {
            top2--;
            a[top2] = val;
        } else {
            System.out.print("Stackoverflow! stack 2");
            return;
        }
    }

    public int pop2() {
        int val = 0;
        if(top2<size) {
            val = a[top2++];
            return val;
        } else {
            System.out.print("Stack empty!");
            return -1;
        }
    }


    public static void main(String[] args) {

        TwoStacks ts = new TwoStacks(5);
        ts.push1(5);
        ts.push2(10);
        ts.push2(15);
        ts.push1(11);
        ts.push2(7);

        System.out.println(ts.pop1() + " ");
        ts.push2(40);
        System.out.println(ts.pop2() + " ");
    }
}

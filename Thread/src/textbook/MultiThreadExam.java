package textbook;


class Summing{
	private int sum;
	public synchronized void sumTo(int num) {
		sum=0;
		for(int i=1;i<=num;i++) {
			sum+=i;
			System.out.println("������ : "+Thread.currentThread().getName());
			System.out.println("�� 1 ~ "+i+"���� ���� "+sum);
			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {}
		}
	}
	public int getSun() {return sum;}
}
public class MultiThreadExam extends Thread{
	private Summing sum;
	private int num;
	public MultiThreadExam(String s, Summing sum, int num) {
		super(s);
		this.sum=sum;
		this.num=num;
		System.out.println("������ : "+getName()+"�� �����");
	}
	public void run() {
		sum.sumTo(num);
		System.out.println("������ : "+getName()+"�� �����");
	}
	public static void main(String[] args) {
		Summing sum = new Summing();
		MultiThreadExam a = new MultiThreadExam("A",sum,5);
		MultiThreadExam b = new MultiThreadExam("B",sum,5);
		a.setPriority(8);
		b.setPriority(10);
		a.start();
		b.start();

	}

}
import java.util.Scanner;
public class PrintCalendarDemo1
{
	public static void main (String [] args){
		int year;//save the inputed year
		int month;//save the inputed month
		boolean isRn;//����Ϊtrue,������Ϊfalse
		int dates=0;
		int totaldays=0;//����1900��1��1��������
		int days=0;//�����·�֮ǰ���·ݵ�������
		System.out.println("**********��ӭʹ��������**********");//��ӡ����ͷ
		Scanner input=new Scanner(System.in);
		System.out.println("��������ݣ�");
		year=input.nextInt();
		//�ж��Ƿ�����
		if((year%400==0)||(year%4==0&&year%100!=0)){
			isRn=true;
		}else{
			isRn=false;
		}
		
		
		/*
		if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
			dates=31;
		}else if(month==2){
			if(isRn){
				dates=29;
			}else{
				dates=28;
			}
		}else if(month==4||month==6||month==9||month==11){
			dates=30;
		}else{
			System.out.println("�����·�����");
		}
		*/
		//�������1900��1��1�յ����������
		for(int i=1900;i<year;i++){
			if(i%400==0||(i%4==0&&i%100!=0)){
				totaldays+=366;
			}else{
				totaldays+=365;
			}
		}
		
		//System.out.println(totaldays);
		
		//�ж��·������Ƿ�Ϸ����Ƿ��·���������
		do{
			System.out.println("�������·ݣ�");
				month=input.nextInt();
				if(month<1||month>12){
					System.out.println("�����·�����");
				}
		}while(month<1||month>12);
		
		//�ж������·ݵ��������Ҽ��������·�֮ǰ��������
		for(int i=1;i<=month;i++){	
				switch(i){
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
					dates=31;
					break;
				case 2:
					if(isRn){
						dates=29;
					}else{
						dates=28;
					}
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					dates=30;
					break;
				default:
					System.out.println("�����·�����");
					break;
				}
				if(i!=month){
					days+=dates;
				}
			}
		
		
		//���������·ݾ���1900��1��1�յ�������
		totaldays+=days;
		
		//����������µ���Ϣ
		if(isRn){System.out.println(year+"������");
		}else{
			System.out.println(year+"������");
			}
		
		System.out.println(year+"��"+month+"�µ�����Ϊ��"+dates);
		
		//��������ڼ�����ʵ����1��ǰ���м���\t
		int beforedays;
		beforedays=1+totaldays%7;
		if(beforedays==7){
			beforedays=0;//���������죬0��\t
		}
		
		//����ʽ�������
		System.out.println("������\t����һ\t���ڶ�\t������\t������\t������\t������");
		for(int i=0;i<beforedays;i++){
			System.out.print("\t");//���������1��ǰ�հ�
		}
		for(int i=1;i<=dates;i++){
			System.out.print(i+"\t");//��˳�����ÿһ��
			if((i+beforedays)%7==0){	//ÿ7�컻��
				System.out.println();
			}
		}
	}
}
import java.util.Scanner;
public class PrintCalendarDemo1
{
	public static void main (String [] args){
		int year;//save the inputed year
		int month;//save the inputed month
		boolean isRn;//闰年为true,非闰年为false
		int dates=0;
		int totaldays=0;//距离1900年1月1日总天数
		int days=0;//输入月份之前的月份的天数和
		System.out.println("**********欢迎使用万年历**********");//打印程序头
		Scanner input=new Scanner(System.in);
		System.out.println("请输入年份：");
		year=input.nextInt();
		//判断是否闰年
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
			System.out.println("输入月份有误！");
		}
		*/
		//计算距离1900年1月1日的年的总天数
		for(int i=1900;i<year;i++){
			if(i%400==0||(i%4==0&&i%100!=0)){
				totaldays+=366;
			}else{
				totaldays+=365;
			}
		}
		
		//System.out.println(totaldays);
		
		//判断月份输入是否合法，非法月份重新输入
		do{
			System.out.println("请输入月份：");
				month=input.nextInt();
				if(month<1||month>12){
					System.out.println("输入月份有误！");
				}
		}while(month<1||month>12);
		
		//判断输入月份的天数并且计算输入月份之前的总天数
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
					System.out.println("输入月份有误！");
					break;
				}
				if(i!=month){
					days+=dates;
				}
			}
		
		
		//计算输入月份距离1900年1月1日的总天数
		totaldays+=days;
		
		//输出输入年月的信息
		if(isRn){System.out.println(year+"是闰年");
		}else{
			System.out.println(year+"非闰年");
			}
		
		System.out.println(year+"年"+month+"月的天数为："+dates);
		
		//求出是星期几，其实就是1号前面有几个\t
		int beforedays;
		beforedays=1+totaldays%7;
		if(beforedays==7){
			beforedays=0;//代表星期天，0个\t
		}
		
		//按格式输出月历
		System.out.println("星期天\t星期一\t星期二\t星期三\t星期四\t星期五\t星期六");
		for(int i=0;i<beforedays;i++){
			System.out.print("\t");//先输出当月1日前空白
		}
		for(int i=1;i<=dates;i++){
			System.out.print(i+"\t");//按顺序输出每一天
			if((i+beforedays)%7==0){	//每7天换行
				System.out.println();
			}
		}
	}
}
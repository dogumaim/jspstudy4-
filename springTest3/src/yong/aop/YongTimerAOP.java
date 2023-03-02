package yong.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class YongTimerAOP {

	public Object yongTimeCheck(ProceedingJoinPoint jp) {
		
		System.out.println("[YongTimerAOP 구동됨!]");
		System.out.println("핵심기능 처리시간 체크  시작!");
		long start=System.currentTimeMillis();
		
		Object result=null;
		try {	//핵심코드
			result=jp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//	
		}
		long end=System.currentTimeMillis();
		System.out.println("[핵심기능 수행시간:"+(end-start)+"m/s]");
		System.out.println("[핵심기능 처리시간 체크 종료!]");
		System.out.println("[YongTimerAOP 종료!]");
		
		return result;
	}
	
}

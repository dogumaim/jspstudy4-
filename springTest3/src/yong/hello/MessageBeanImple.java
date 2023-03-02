package yong.hello;

public class MessageBeanImple implements MessageBean {

	private String name;
	private String greeting;
	
	
	public MessageBeanImple(String name) {
		super();
		this.name = name;
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public void sayHello() {
		
		
	
		///////////////////////핵심의 시작
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String msg=greeting+", "+name+"!";
		System.out.println(msg);
		///////////////////////핵심의 끝
		
	}
}

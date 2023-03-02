package yong.hello;

public class MessageBeanImple implements MessageBean {

	private String name; //생성자 주입법
	private String greeting; //세터 주입법
	private MsgOutput output;
	
	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public MessageBeanImple(String name) {
		super();
		this.name = name;
	}
	
	

	public MsgOutput getOutput() {
		return output;
	}

	public void setOutput(MsgOutput output) {
		this.output = output;
	}

	@Override
	public void sayHello() {
		
		String msg=greeting+"! "+name+"!";
		System.out.println(msg);
		
		try {
			output.output(msg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

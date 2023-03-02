package yong.hello;

public class DbMsgOutputImple implements MsgOutput {

	@Override
	public void output(String msg) throws Exception {
		
		System.out.println("==DB연동시작==");
		
		System.out.println("저장된 데이터:"+msg);
		
		System.out.println("==DB연동종료==");

	}
	
}



	
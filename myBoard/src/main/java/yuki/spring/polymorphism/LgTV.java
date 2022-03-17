package yuki.spring.polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("lg")
public class LgTV implements TV {
	
	@Autowired
	private Speaker speaker;

	public LgTV() {
		System.out.println("LgTV��ü ����");
	}

	public void volumeUp() {
		speaker.volumeUp();
	}

	public void volumeDown() {
		speaker.volumeDown();
	}

	public void powerOn() {
		System.out.println("LgTV ������ �Ҵ�.");
	}

	public void powerOff() {
		System.out.println("LgTV ������ ����.");
	}


}

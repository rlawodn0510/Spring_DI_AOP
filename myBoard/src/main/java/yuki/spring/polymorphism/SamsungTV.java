package yuki.spring.polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tv")
public class SamsungTV implements TV {
	@Autowired
	private Speaker speaker;
	private int price;

	public SamsungTV() {
		System.out.println("SamsungTV 객체 생성");
	}

	public SamsungTV(Speaker speaker) {
		System.out.println("SamsungTV 객체 생성 : Injection");
		this.speaker = speaker;
	}
	
	public SamsungTV(Speaker speaker, int price) {
		System.out.println("SamsungTV 객체 생성 : 생성자 다중맵핑");
		this.speaker = speaker;
		this.price = price;
	}

	public void start() {
		System.out.println("객체 초기화 작업 처리");
	}

	public void stop() {
		System.out.println("객체 삭제 전에 처리할 로직 처리");
	}

	public void powerOn() {
		System.out.println("SamsungTV 전원을 켠다. (가격 : " + price + "원)");
	}

	public void powerOff() {
		System.out.println("SamsungTV 전원을 끈다.");
	}

	public void volumeUp() {
		speaker.volumeUp();
	}

	public void volumeDown() {
		speaker.volumeDown();
	}
	
	public Speaker getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Speaker speaker) {
		System.out.println("setSpeaker 호출!");
		this.speaker = speaker;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		System.out.println("setPrice 호출!");
		this.price = price;
	}
}

package yuki.spring.polymorphism;

public class AppleSpeaker implements Speaker {

	public AppleSpeaker() {
		System.out.println("AppleSpeaker 按眉 积己");
	}

	@Override
	public void volumeUp() {
		System.out.println("AppleSpeaker 家府棵赴促");

	}

	@Override
	public void volumeDown() {
		System.out.println("AppleSpeaker 家府郴赴促");

	}

}

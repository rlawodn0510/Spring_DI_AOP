package yuki.spring.collection;

import java.util.Set;

import org.springframework.stereotype.Component;
@Component
public class CollectionBean {
	private Set<String> addressList;

	public CollectionBean() {
		System.out.println("asd");
	}

	public Set<String> getAddressList() {
		
		return addressList;
	}

	public void setAddressList(Set<String> addressList) {
		this.addressList = addressList;
	}


}

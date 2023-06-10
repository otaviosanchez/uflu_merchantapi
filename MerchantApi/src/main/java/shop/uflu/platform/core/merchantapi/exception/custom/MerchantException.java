package shop.uflu.platform.core.merchantapi.exception.custom;

import java.io.Serializable;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class MerchantException extends Exception implements Serializable {

	private static final long serialVersionUID = 7879477776455060946L;

	public MerchantException() {
		super();
	}

	public MerchantException(String msg) {
		super(msg);
	}

	public MerchantException(String msg, Exception e) {
		super(msg, e);
	}

}

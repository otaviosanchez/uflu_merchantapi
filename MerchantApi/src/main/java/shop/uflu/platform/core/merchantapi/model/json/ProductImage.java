package shop.uflu.platform.core.merchantapi.model.json;

import java.io.Serializable;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class ProductImage implements Serializable {

	private static final long serialVersionUID = 3843442487457078445L;
	
	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

 }

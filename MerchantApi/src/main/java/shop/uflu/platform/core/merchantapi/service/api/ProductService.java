package shop.uflu.platform.core.merchantapi.service.api;

import java.util.List;

import shop.uflu.platform.core.merchantapi.exception.custom.MerchantException;
import shop.uflu.platform.core.merchantapi.model.json.Product;

public interface ProductService {
	
    void save(Product product) throws MerchantException;

    List<Product> findByProvider(String providerId) throws MerchantException;

	List<Product> findAll() throws MerchantException;
}

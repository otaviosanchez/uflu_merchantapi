package shop.uflu.platform.core.merchantapi.service.impl;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import shop.uflu.platform.core.merchantapi.exception.custom.MerchantException;
import shop.uflu.platform.core.merchantapi.model.json.Product;
import shop.uflu.platform.core.merchantapi.service.api.ProductService;

@ApplicationScoped
public class ProductServiceBean implements ProductService {

	@ConfigProperty(name = "merchantapi.variables.microservice.product")
	private String endpointProductMicroservice;

	@Override
	public void save(Product product) throws MerchantException {
		try {
			JSONObject jsonObject = new JSONObject(product);
			HttpRequest request = HttpRequest.newBuilder()
					.uri(new URI(endpointProductMicroservice + "/product"))
					.header("Content-Type", "application/json")
					.POST(HttpRequest.BodyPublishers.ofString(jsonObject.toString())).build();
			var client = HttpClient.newHttpClient();
			var response = client.send(request, HttpResponse.BodyHandlers.ofString());
			if (response.statusCode() != 201) {
				throw new MerchantException();
			}
		} catch (MerchantException e) {
			throw e;
		} catch (Exception e) {
			throw new MerchantException();
		}	
	}

	@Override
	public List<Product> findByProvider(String providerId) throws MerchantException {
		List<Product> products = null;
		try {
			HttpRequest request = HttpRequest.newBuilder()
					.uri(new URI(endpointProductMicroservice + "/" + providerId))
					.header("Content-Type", "application/json")
					.GET().build();
			var client = HttpClient.newHttpClient();
			var response = client.send(request, HttpResponse.BodyHandlers.ofString());
			if (response.statusCode() == 200) {
				ObjectMapper mapper = new ObjectMapper();
			    products = mapper.readValue(response.body(), List.class);
			} else {
				throw new MerchantException();
			}
		} catch (Exception e) {
			throw new MerchantException();
		}
		return products;
	}

	@Override
	public List<Product> findAll() throws MerchantException {
		List<Product> products = null;
		try {
			HttpRequest request = HttpRequest.newBuilder()
					.uri(new URI(endpointProductMicroservice + "/product"))
					.header("Content-Type", "application/json")
					.GET().build();
			var client = HttpClient.newHttpClient();
			var response = client.send(request, HttpResponse.BodyHandlers.ofString());
			if (response.statusCode() == 200) {
				ObjectMapper mapper = new ObjectMapper();
			    products = mapper.readValue(response.body(), List.class);
			} else {
				throw new MerchantException();
			}
		} catch (Exception e) {
			throw new MerchantException();
		}
		return products;
	}

}

package shop.uflu.platform.core.merchantapi.exception.handler;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import shop.uflu.platform.core.merchantapi.exception.custom.MerchantException;

@Provider
public class MerchantExceptionHandler implements ExceptionMapper<MerchantException> {

	@Override
	public Response toResponse(MerchantException exception) {
		return Response.status(Status.BAD_REQUEST).build();
	}

}

package cn.whforever.core.serialize.impl;

import cn.whforever.core.serialize.AbstractSerializer;
import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * hessian serialize
 * @author xuxueli 2015-9-26 02:53:29
 */
public class HessianAbstractSerializer extends AbstractSerializer {

	@Override
	public <T> byte[] serialize(T obj){
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		HessianOutput ho = new HessianOutput(os);
		try {
			ho.writeObject(obj);
		} catch (IOException e) {
			throw new IllegalStateException(e.getMessage(), e);
		}
		return os.toByteArray();
	}

	@Override
	public <T> Object deserialize(byte[] bytes, Class<T> clazz) {
		ByteArrayInputStream is = new ByteArrayInputStream(bytes);
		HessianInput hi = new HessianInput(is);
		try {
			return hi.readObject();
		} catch (IOException e) {
			throw new IllegalStateException(e.getMessage(), e);
		}
	}
	
}

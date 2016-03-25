package tw.com.ktv.jersey.interceptors;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;

import tw.com.ktv.constraint.common.Validated;

/**
 * 
 * @author chris
 *
 */
@Provider
public class BaseReadInterceptor implements ReaderInterceptor {

  
  @Override
  public Object aroundReadFrom(ReaderInterceptorContext context)
      throws IOException, WebApplicationException {

    final Object parameter = context.proceed();

    this.volidGroup(parameter, context.getAnnotations());


    return parameter;
  }

  /**
   * volidGroup
   * 
   * @param context
   * @throws WebApplicationException
   * @throws IOException
   */
  private void volidGroup(Object parameter, Annotation[] anns)
      throws WebApplicationException, IOException {

    for (Annotation ann : anns) {
      if (ann instanceof Validated) {

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        // valid group
        Set<ConstraintViolation<Object>> violations =
            validator.validate(parameter, ((Validated) ann).value());

        if (violations.size() > 0) {
          throw new ConstraintViolationException(violations);
        }
      }
    }
  }

}

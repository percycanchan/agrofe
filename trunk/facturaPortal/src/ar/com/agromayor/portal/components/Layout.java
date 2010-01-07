package ar.com.agromayor.portal.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.annotations.IncludeStylesheet;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;

@SuppressWarnings("unused")
@IncludeStylesheet("context:css/styles.css")
public class Layout {
  @Property
  @Parameter(required=true, defaultPrefix=BindingConstants.LITERAL)
  private String title; //El titulo de la pagina
  
  
}
package com.didispace.demo;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.OperationBuilderPlugin;
import springfox.documentation.spi.service.contexts.OperationContext;
import springfox.documentation.swagger.common.SwaggerPluginSupport;

import java.util.Iterator;
import java.util.Set;
/**
 * swagger2本身的返回类型中定义了包含200,400,403,500等多种状态返回，
 * 但项目本身只需要200状态返回，其他的也没有定义，因此删除了其他的返回状态
 *
 * @author huang_kangjie
 * @date 2020/10/22 0022 17:16
 */
@Component
@Order(SwaggerPluginSupport.SWAGGER_PLUGIN_ORDER + 1002)
public class CustomOperationBuilder implements OperationBuilderPlugin {

     @Override
     public void apply(OperationContext operationContext) {
          Set<ResponseMessage> def = operationContext.operationBuilder().build().getResponseMessages();
          Iterator iterator = def.iterator();
          while (iterator.hasNext()) {
               ResponseMessage rm  = (ResponseMessage)iterator.next();
               if (rm.getCode() != 200) {
                    iterator.remove();
               }
          }
     }

     @Override
     public boolean supports(DocumentationType documentationType) {
          return true;
     }
}


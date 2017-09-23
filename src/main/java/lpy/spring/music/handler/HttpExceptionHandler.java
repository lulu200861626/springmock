package lpy.spring.music.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 */
public class HttpExceptionHandler implements HandlerExceptionResolver {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpExceptionHandler.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
                                         Object handler, Exception ex) {
        LOGGER.error("服务异常:", ex);
        String uri = request.getRequestURI();

        if (uri.startsWith("/ajax")) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

            Map<String, Object> model = new HashMap<>();
            model.put("errorCode", "500");
            model.put("errorMessage", "服务器错误");

            MappingJacksonJsonView view = new MappingJacksonJsonView();
            view.setAttributesMap(model);

            ModelAndView mav = new ModelAndView();
            mav.setView(view);
            return mav;
        } else
            return new ModelAndView("forward:/error");
    }
}
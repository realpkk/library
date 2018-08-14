package top.management.library.common.url;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.tuckey.web.filters.urlrewrite.Conf;
import org.tuckey.web.filters.urlrewrite.UrlRewriteFilter;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import java.io.IOException;


@Configuration
public class UrlRewriteFilterConfig extends UrlRewriteFilter {

    private static final String URL_REWRITE = "classpath:/urlrewrite.xml";

    @Value(URL_REWRITE)
    private Resource resource;

    @Override
    protected void loadUrlRewriter(FilterConfig filterConfig) throws ServletException{

        try {
            Conf conf = new Conf(filterConfig.getServletContext(),resource.getInputStream(),resource.getFilename(),"@@traceability@@");
            checkConf(conf);
        } catch (IOException e) {
            throw new ServletException("无法从"+URL_REWRITE+"加载URL重写配置文件",e);
        }
    }
}

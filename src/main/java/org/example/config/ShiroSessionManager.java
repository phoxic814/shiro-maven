package org.example.config;

import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;

/**
 * 自訂義session管理類
 */
public class ShiroSessionManager extends DefaultWebSessionManager {

    public ShiroSessionManager() {
        super();
        this.setDeleteInvalidSessions(true);
    }

    @Override
    public Serializable getSessionId(ServletRequest request, ServletResponse response) {
        return super.getSessionId(request, response);
    }
}

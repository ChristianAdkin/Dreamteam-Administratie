package com.dreamteam.payd.administration.util;

import javax.faces.context.FacesContext;
import javax.faces.context.PartialViewContext;

/**
 * Created by Christian Adkin on 20/03/2017.
 */
public class ContextUtil {

    public static boolean isAjaxRequest(FacesContext facesContext) {
        PartialViewContext pvc = facesContext.getPartialViewContext();
        return pvc.isAjaxRequest();
    }

}
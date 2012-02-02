package com.atex.confluence.plugin.action;


import javax.servlet.http.HttpServletRequest;

import com.atlassian.confluence.search.ChangeIndexer;
import com.atlassian.confluence.security.PermissionManager;
import com.atlassian.confluence.user.actions.EditMyProfileAction;
import com.opensymphony.webwork.ServletActionContext;

public class EditUserInfoAction extends EditMyProfileAction {
    /**
     * 
     */
    private static final long serialVersionUID = -1467478084269485784L;


    private ChangeIndexer changeIndexer;

    public ChangeIndexer getChangeIndexer() {
        return changeIndexer;
    }

    public void setChangeIndexer(ChangeIndexer changeIndexer) {
        this.changeIndexer = changeIndexer;
    }
    

    private String save;
    private String cancel;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    private String result;

    public String getCancel() {
        return cancel;
    }

    public void setCancel(String cancel) {
        this.cancel = cancel;
    }

    private boolean updateAllowed;


    public EditUserInfoAction() {
    }

    @Override public String doDefault() throws Exception {
        if(cancel != null) {
            return CANCEL;
        }
        return super.doDefault();
    }

    @Override public String execute() {
        // was the save button pressed
        if ( save == null ) {
            return CANCEL;
        }

        // For each of the custom fields, check if the value has been set as a
        // parameter on the action, if so set the custom field value (this will
        // also cause any validation to happen if the custom field validates
        // input.)
        HttpServletRequest req = ServletActionContext.getRequest();

        if ( hasActionErrors() || hasFieldErrors() ) {
            if(hasFieldErrors()) {
                addActionError(getText("userinfo.field.error.required"));
            }

            if ( LOG.isDebugEnabled() ) {
                LOG.debug( "field validation errors: " + getActionErrors() );
            }

            return ERROR;
        }
        
        addActionMessage( getText( "userInfo.fields.saved" ) );

        return SUCCESS;
    }

    public String getSave() {
        return save;
    }

    public void setSave( String save ) {
        this.save = save;
    }

    public PermissionManager getPermissionManager() {
        return permissionManager;
    }

    public boolean isUpdateAllowed() {
        return updateAllowed;
    }

}

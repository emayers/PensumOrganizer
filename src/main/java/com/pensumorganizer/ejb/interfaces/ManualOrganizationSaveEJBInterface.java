package com.pensumorganizer.ejb.interfaces;

import javax.ejb.Remote;

@Remote
public interface ManualOrganizationSaveEJBInterface {
    
    public String saveReorganization();
}

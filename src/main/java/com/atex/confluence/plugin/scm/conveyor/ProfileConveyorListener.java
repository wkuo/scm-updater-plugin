package com.atex.confluence.plugin.scm.conveyor;

import org.randombits.confluence.conveyor.ConveyorListener;
import org.randombits.confluence.conveyor.config.ConveyorConfigurationProvider;

public class ProfileConveyorListener extends ConveyorListener {

    private static final String CONFIG_LOCATION = "conveyor-config-profile.xml";

    protected ConveyorConfigurationProvider[] createProviders() {
        return new ConveyorConfigurationProvider[] { new ConveyorConfigurationProvider(CONFIG_LOCATION) };
    }

}

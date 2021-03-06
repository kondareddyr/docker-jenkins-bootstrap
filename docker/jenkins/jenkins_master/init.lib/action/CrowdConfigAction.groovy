package action

import de.theit.jenkins.crowd.CrowdSecurityRealm
import groovy.transform.InheritConstructors
import jenkins.model.Jenkins

@InheritConstructors
class CrowdConfigAction extends ConfigAction {

    @Override
    void execute() {
        def instance = Jenkins.getInstance()

        def crowdRealm = new CrowdSecurityRealm(config.crowdUrl, config.crowdApplication, config.crowdPassword,
            config.crowdGroup, false, 2, false, null, null, false, null, null, null, null, null, null, null);
        instance.setSecurityRealm(crowdRealm)

        instance.save()
    }
}

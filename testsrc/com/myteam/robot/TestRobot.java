/* Created Fri Sep 30 11:19:04 EDT 2016 */
package com.myteam.robot;

import org.junit.Assert;
import org.junit.Test;
import org.strongback.mock.Mock;
import org.strongback.mock.MockSolenoid;

public class TestRobot {

	@Test
    public void shouldRetractSolenoidWhenSolenoidIsAlreadyRetracted() {
        MockSolenoid solenoid = Mock.instantaneousSolenoid().retract();
        
        // FIrst open the solenoid
        OpenClaw command = new OpenClaw(solenoid, false);
        command.execute();
        
        Assert.assertTrue(solenoid.isRetracting() == false);
        Assert.assertTrue(solenoid.isExtending() == false);
        Assert.assertTrue(solenoid.isStopped()); //isRetracted()).isTrue();
        
        // Now, close the solenoid.
        CloseClaw cmd2 = new CloseClaw(solenoid, true);
        cmd2.execute();

        // Same solenoid.
        Assert.assertTrue(solenoid.isRetracting() == false);
        Assert.assertTrue(solenoid.isExtending() == false);
        Assert.assertTrue(solenoid.isStopped()); //isRetracted()).isTrue();
        
    }
}

package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId(){
        Job newJob = new Job();
        Job newerJob = new Job();
        assertNotEquals(newJob.getId(), newerJob.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(testJob instanceof Job);
        assertEquals("Product tester", testJob.getName());
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertEquals("ACME", testJob.getEmployer().getValue());
        assertTrue(testJob.getLocation() instanceof Location);
        assertEquals("Desert", testJob.getLocation().getValue());
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertEquals("Quality control", testJob.getPositionType().getValue());
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", testJob.getCoreCompetency().getValue());

    }
    @Test
    public void testJobsForEquality(){
        Job testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job testJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(testJob2.equals(testJob1));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job testJob3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        char firstChar = testJob3.toString().charAt(0);
        char lastChar = testJob3.toString().charAt(testJob3.toString().length()-1);
        assertEquals(firstChar, '\n');
        assertEquals(lastChar, '\n');

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job testJob4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String theResponse = "\n" + "ID: " + testJob4.getId() + "\n" +
                "Name: " + testJob4.getName() + "\n" +
                "Employer: " + testJob4.getEmployer() + "\n" +
                "Location: " + testJob4.getLocation() + "\n" +
                "Position Type: " + testJob4.getPositionType() + "\n" +
                "Core Competency: " + testJob4.getCoreCompetency() + "\n";
        assertEquals(testJob4.toString(), theResponse);
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job testJob5 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String theResponse = "\n" + "ID: " + testJob5.getId() + "\n" +
                "Name: " + testJob5.getName() + "\n" +
                "Employer: " + testJob5.getEmployer() + "\n" +
                "Location: " + testJob5.getLocation() + "\n" +
                "Position Type: " + testJob5.getPositionType() + "\n" +
                "Core Competency: " + testJob5.getCoreCompetency() + "\n";
        assertEquals(testJob5.toString(), theResponse);
    }


}

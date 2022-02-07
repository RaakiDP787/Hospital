import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.*;
import static org.testng.Assert.assertEquals;

public class HospitalTest{

    private HospitalVisit hospital1;
    private HospitalVisit hospital2;
    private Patient p1;
    private Patient p2;

    //Arrange
    @BeforeClass
    public void CreatePatientsAndTheirDetails(){
            hospital1 = new HospitalVisit("Sparsh","Mumbai",Arrays.asList(LocalDate.now(),LocalDate.of(2021,8,30),LocalDate.of(2021,6,30),LocalDate.of(2021,3,30)));
            hospital2 = new HospitalVisit("Sparsh","Bangalore",Arrays.asList(LocalDate.now(),LocalDate.of(2021,8,30),LocalDate.of(2021,6,30),LocalDate.of(2021,3,30)));
            p1 = new Patient(1, "Suhas", "Mumbai", Arrays.asList(hospital1, hospital2));
            p2 = new Patient(2, "Rocky", "Bangalore", Arrays.asList(hospital1, hospital2));

    }

    @Test
    public void testtotalVisitedCount() {
        //Assert
        assertEquals(8, p1.Visitcount("Sparsh"));
    }


    @Test
    public void testlast3daysVisit() {
        //Assert
        assertEquals(1,hospital1.getlastNodaysVisit(3));
    }

    @Test
    public void testtotalvisitduringrange()
    {
        LocalDate date = LocalDate.now();
        //Assert
        assertEquals(1,hospital1.getVisitDuringAtimeRange(date.minusDays(5),date.plusDays(5)));

    }

    @Test
    public void testPatientInsideBangalore() {
        //Arrange
        HospitalVisit hospital_Mumbai = new HospitalVisit("KMC","Mumbai",Arrays.asList(LocalDate.now(),LocalDate.of(2021,8,30),LocalDate.of(2021,6,30),LocalDate.of(2021,3,30)));
        HospitalVisit hospital_bangalore = new HospitalVisit("Sparsh","Bangalore",Arrays.asList(LocalDate.now(),LocalDate.of(2021,8,30),LocalDate.of(2021,6,30),LocalDate.of(2021,3,30)));

        //Act
        Patient p = new Patient(1,"Vinay","Mumbai",Arrays.asList(hospital_bangalore,hospital_Mumbai));
        Patient p2 = new Patient(2,"Dhanush","Bangalore",Arrays.asList(hospital_bangalore,hospital_Mumbai));
        Patient p1 = new Patient(3,"Ramu","Goa",Arrays.asList(hospital_bangalore,hospital_Mumbai));
        Hospital hospital = new Hospital("Bangalore","Sparsh",Arrays.asList(p,p1,p2));

        //Assert
        assertEquals(2,hospital.getPatientsOutsideBangalore("Bangalore"));
    }


    @Test
    public void testPatientOutsideBangalore() {

        //Arrange
        HospitalVisit hospital_Mumbai = new HospitalVisit("KMC","Mumbai",Arrays.asList(LocalDate.now(),LocalDate.of(2021,8,30),LocalDate.of(2021,6,30),LocalDate.of(2021,3,30)));
        HospitalVisit hospital_bangalore = new HospitalVisit("Sparsh","Bangalore",Arrays.asList(LocalDate.now(),LocalDate.of(2021,8,30),LocalDate.of(2021,6,30),LocalDate.of(2021,3,30)));

        //Act
        Patient p = new Patient(1,"Vinay","Mumbai",Arrays.asList(hospital_bangalore,hospital_Mumbai));
        Patient p2 = new Patient(2,"Dhanush","Bangalore",Arrays.asList(hospital_bangalore,hospital_Mumbai));
        Patient p1 = new Patient(3,"Ramu","Goa",Arrays.asList(hospital_bangalore,hospital_Mumbai));
        Hospital hospital = new Hospital("Bangalore","Sparsh",Arrays.asList(p,p1,p2));

        //Assert
        assertEquals(2,hospital.getPatientsOutsideBangalore("Bangalore"));
    }

    @Test
    public void testPatientRatio() {
        //Arrange
        HospitalVisit hospital_Mumbai = new HospitalVisit("KMC","Mumbai",Arrays.asList(LocalDate.now(),LocalDate.of(2021,8,30),LocalDate.of(2021,6,30),LocalDate.of(2021,3,30)));
        HospitalVisit hospital_bangalore = new HospitalVisit("Sparsh","Bangalore",Arrays.asList(LocalDate.now(),LocalDate.of(2021,8,30),LocalDate.of(2021,6,30),LocalDate.of(2021,3,30)));
        Patient p = new Patient(1,"Vinay","Mumbai",Arrays.asList(hospital_bangalore,hospital_Mumbai));
        Patient p2 = new Patient(2,"Dhanush","Bangalore",Arrays.asList(hospital_bangalore,hospital_Mumbai));
        Patient p1 = new Patient(3,"Ramu","Noida",Arrays.asList(hospital_bangalore,hospital_Mumbai));

        //Act
        Hospital hospital = new Hospital("Bangalore","Sparsh",Arrays.asList(p,p1,p2));

        //Assert
        assertEquals(3,hospital.getRatioInsideToOutside("Bangalore"),4);

    }

}
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.*;
import static org.testng.Assert.assertEquals;

public class HospitalTest {

    @Test
    public void testtotalVisitedCount() {

        HospitalVisit hospital1 = new HospitalVisit("Sparsh", "Mumbai", Arrays.asList(LocalDate.now(), LocalDate.of(2021, 8, 30), LocalDate.of(2021, 6, 30), LocalDate.of(2021, 3, 30)));
        HospitalVisit hospital2 = new HospitalVisit("Sparsh", "Bangalore", Arrays.asList(LocalDate.now(), LocalDate.of(2021, 8, 30), LocalDate.of(2021, 6, 30), LocalDate.of(2021, 3, 30)));
        Patient p1 = new Patient(1, "Rocky", "Mumbai", Arrays.asList(hospital1, hospital2));
        Patient p2 = new Patient(2, "Suhas", "Bangalore", Arrays.asList(hospital1, hospital2));
        assertEquals(8, p1.Visitcount("Sparsh"));
    }


    @Test
    public void testlast3daysVisit() {
        HospitalVisit hospital1 = new HospitalVisit("Sparsh","Mumbai",Arrays.asList(LocalDate.now(),LocalDate.of(2021,8,30),LocalDate.of(2021,6,30),LocalDate.of(2021,3,30)));
        HospitalVisit hospital2 = new HospitalVisit("Sparsh","Bangalore",Arrays.asList(LocalDate.now(),LocalDate.of(2021,8,30),LocalDate.of(2021,6,30),LocalDate.of(2021,3,30)));
        Patient p1 = new Patient(2,"Suhas","Mumbai",Arrays.asList(hospital1,hospital2));
        Patient p = new Patient(1,"Rocky","Bangalore",Arrays.asList(hospital1,hospital2));
        assertEquals(1,hospital1.getlastNodaysVisit(3));
    }

    @Test
    public void testtotalvisitduringrange()
    {
        HospitalVisit hospital1 = new HospitalVisit("Sparsh","Mumbai",Arrays.asList(LocalDate.now(),LocalDate.of(2021,8,30),LocalDate.of(2021,6,30),LocalDate.of(2021,3,30)));
        LocalDate date = LocalDate.now();
        HospitalVisit hospital2 = new HospitalVisit("Sparsh","Bangalore",Arrays.asList(LocalDate.now(),LocalDate.of(2021,8,30),LocalDate.of(2021,6,30),LocalDate.of(2021,3,30)));
        Patient p1 = new Patient(1,"Rocky","Mumbai",Arrays.asList(hospital1,hospital2));
        LocalDate date1 = LocalDate.now();
        Patient p = new Patient(2,"Suhas","Bangalore",Arrays.asList(hospital1,hospital2));
        assertEquals(1,hospital1.getVisitDuringAtimeRange(date.minusDays(5),date.plusDays(5)));

    }

    @Test
    public void testPatientInsideBangalore() {
        HospitalVisit hospital_Mumbai = new HospitalVisit("KMC","Mumbai",Arrays.asList(LocalDate.now(),LocalDate.of(2021,8,30),LocalDate.of(2021,6,30),LocalDate.of(2021,3,30)));
        HospitalVisit hospital_bangalore = new HospitalVisit("Sparsh","Bangalore",Arrays.asList(LocalDate.now(),LocalDate.of(2021,8,30),LocalDate.of(2021,6,30),LocalDate.of(2021,3,30)));
        Patient p = new Patient(1,"Vinay","Mumbai",Arrays.asList(hospital_bangalore,hospital_Mumbai));
        Patient p2 = new Patient(2,"Dhanush","Bangalore",Arrays.asList(hospital_bangalore,hospital_Mumbai));
        Patient p1 = new Patient(3,"Ramu","Goa",Arrays.asList(hospital_bangalore,hospital_Mumbai));
        Hospital hospital = new Hospital("Bangalore","Sparsh",Arrays.asList(p,p1,p2));
        assertEquals(2,hospital.getPatientsOutsideBangalore("Bangalore"));
    }


    @Test
    public void testPatientOutsideBangalore() {
        HospitalVisit hospital_Mumbai = new HospitalVisit("KMC","Mumbai",Arrays.asList(LocalDate.now(),LocalDate.of(2021,8,30),LocalDate.of(2021,6,30),LocalDate.of(2021,3,30)));
        HospitalVisit hospital_bangalore = new HospitalVisit("Sparsh","Bangalore",Arrays.asList(LocalDate.now(),LocalDate.of(2021,8,30),LocalDate.of(2021,6,30),LocalDate.of(2021,3,30)));
        Patient p = new Patient(1,"Vinay","Mumbai",Arrays.asList(hospital_bangalore,hospital_Mumbai));
        Patient p2 = new Patient(2,"Dhanush","Bangalore",Arrays.asList(hospital_bangalore,hospital_Mumbai));
        Patient p1 = new Patient(3,"Ramu","Goa",Arrays.asList(hospital_bangalore,hospital_Mumbai));
        Hospital hospital = new Hospital("Bangalore","Sparsh",Arrays.asList(p,p1,p2));
        assertEquals(2,hospital.getPatientsOutsideBangalore("Bangalore"));
    }
    @Test
    public void testPatientRatio() {
        HospitalVisit hospital_Mumbai = new HospitalVisit("KMC","Mumbai",Arrays.asList(LocalDate.now(),LocalDate.of(2021,8,30),LocalDate.of(2021,6,30),LocalDate.of(2021,3,30)));
        HospitalVisit hospital_bangalore = new HospitalVisit("Sparsh","Bangalore",Arrays.asList(LocalDate.now(),LocalDate.of(2021,8,30),LocalDate.of(2021,6,30),LocalDate.of(2021,3,30)));
        LocalDate date2 = LocalDate.now();
        Patient p = new Patient(1,"Vinay","Mumbai",Arrays.asList(hospital_bangalore,hospital_Mumbai));
        Patient p2 = new Patient(2,"Dhanush","Bangalore",Arrays.asList(hospital_bangalore,hospital_Mumbai));
        Patient p1 = new Patient(3,"Ramu","Noida",Arrays.asList(hospital_bangalore,hospital_Mumbai));
        Hospital hospital = new Hospital("Bangalore","Sparsh",Arrays.asList(p,p1,p2));
        assertEquals(3,hospital.getRatioInsideToOutside("Bangalore"),4);

    }

}
import lombok.Builder;

import java.util.List;


public class Hospital {
    private String location;
    private String hospitalname;
    List<Patient>patientinside;

    public Hospital(String location,String name,List<Patient>patients){
        this.location=location;
        this.hospitalname=name;
        this.patientinside=patients;
    }
    public List<Patient>getPatientList(){
        return patientinside;
    }
    public long getLocationPatients(String location){
        long count = this.patientinside.stream().filter((s) -> s.getLocation().contains(location)).count();
        return count;
    }
    public long getPatientsOutsideBangalore(String location){
        long count = this.patientinside.stream().filter((s) -> s.getLocation().contains(location)).count();
        return patientinside.size() - count;
    }
    public double getRatioInsideToOutside(String location) {
        long countinside = this.patientinside.stream().filter((s) -> s.getLocation().contains(location)).count();
        long countoutside = patientinside.size() - countinside;

        return countinside/countoutside;
    }

}
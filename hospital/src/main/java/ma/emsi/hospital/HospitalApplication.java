package ma.emsi.hospital;

import ma.emsi.hospital.entities.Patient;
import ma.emsi.hospital.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;


@SpringBootApplication
public class HospitalApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;
    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
 /*     meth1  Patient patient1= new Patient();
        patient1.setId(null);
        patient1.setNom("Hamid");
        patient1.setDateNaissance(new Date());
        patient1.setMalade(false);
        patient1.setScore(23);
        meth2
        Patient patient2= new Patient(null,"Yassine",new Date(),false,20);
        meth3
        Patient patient3= Patient.builder()
                .nom("Imane")
                .dateNaissance(new Date())
                .score(56)
                .malade(true)
                .build();*/
        patientRepository.save(new Patient(null,"Mohamed",new Date(),false,30));
            patientRepository.save(new Patient(null,"Brahim",new Date(),false,35));
        patientRepository.save(new Patient(null,"Mohcine",new Date(),true,45));

    }
}

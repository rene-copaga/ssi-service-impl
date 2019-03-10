/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.dip.ssiserviceimpl.bootstrap;

import edu.umss.dip.ssiserviceimpl.model.*;
import edu.umss.dip.ssiserviceimpl.repositories.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private ProjectRepository projectRepository;
    private RolRepository rolRepository;
    private WorkerRepository workerRepository;
    private ActivityRepository activityRepository;
    private DetailActivityRepository detailActivityRepository;
    private AsignationRepository asignationRepository;


    public DevBootstrap(ProjectRepository projectRepository, RolRepository rolRepository, WorkerRepository workerRepository, ActivityRepository activityRepository, DetailActivityRepository detailActivityRepository, AsignationRepository asignationRepository) {
        this.projectRepository = projectRepository;
        this.rolRepository = rolRepository;
        this.workerRepository = workerRepository;
        this.activityRepository = activityRepository;
        this.detailActivityRepository = detailActivityRepository;
        this.asignationRepository = asignationRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        //Proyecto

        Project project = new Project();
        project.setName("Condomio Mediterraneo X");
        project.setDescription("Cadena de 12 viviendas en la zona de Sarco");
        projectRepository.save(project);

        // Rol

        Rol rolSupervisor = new Rol();
        rolSupervisor.setName("Supervisor de obra");

        rolRepository.save(rolSupervisor);

        Rol rolCapataz = new Rol();
        rolCapataz.setName("Capataz");

        rolRepository.save(rolCapataz);

        Worker worker1 = new Worker();
        worker1.setFirstName("Abercrombie");
        worker1.setLastName("Kim");
        worker1.setHiringDate(new Date(1995,3,11));
        worker1.setRol(rolSupervisor);

        workerRepository.save(worker1);

        Worker worker2 = new Worker();
        worker2.setFirstName("Barzdukas");
        worker2.setLastName("Gytis");
        worker2.setHiringDate(new Date(2005,9,1));
        worker2.setRol(rolCapataz);

        workerRepository.save(worker2);

        Worker worker3 = new Worker();
        worker3.setFirstName("Justice");
        worker3.setLastName("Peggy");
        worker3.setHiringDate(new Date(2001,9,1));
        worker3.setRol(rolCapataz);

        workerRepository.save(worker3);

        Activity activity = new Activity();
        activity.setActivityName("Aprobacion de trabajos");

        activityRepository.save(activity);

        Activity activity2 = new Activity();
        activity2.setActivityName("Vaciado de cimiento");

        activityRepository.save(activity2);

        Activity activity3 = new Activity();
        activity3.setActivityName("Encofrado");

        activityRepository.save(activity3);


        DetailActivity detailActivity = new DetailActivity();
        detailActivity.setActivity(activity);
        detailActivity.setProject(project);

        detailActivityRepository.save(detailActivity);

        DetailActivity detailActivity2 = new DetailActivity();
        detailActivity2.setActivity(activity2);
        detailActivity2.setProject(project);

        detailActivityRepository.save(detailActivity2);

        DetailActivity detailActivity3 = new DetailActivity();
        detailActivity3.setActivity(activity3);
        detailActivity3.setProject(project);

        detailActivityRepository.save(detailActivity3);

        Asignation as1 = new Asignation();
        as1.setDetailActivity(detailActivity);
        as1.setWorker(worker1);

        asignationRepository.save(as1);

        Asignation as2 = new Asignation();
        as2.setDetailActivity(detailActivity2);
        as2.setWorker(worker2);

        asignationRepository.save(as2);

        Asignation as3 = new Asignation();
        as3.setDetailActivity(detailActivity3);
        as3.setWorker(worker3);

        asignationRepository.save(as3);

    }
}

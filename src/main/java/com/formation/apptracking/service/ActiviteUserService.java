package com.formation.apptracking.service;

import com.formation.apptracking.dao.ActiviteRepository;
import com.formation.apptracking.dao.ActiviteUserRepository;
import com.formation.apptracking.dao.PointGpsRepository;
import com.formation.apptracking.dao.UsersRepository;
import com.formation.apptracking.dto.ActiviteDto;
import com.formation.apptracking.dto.ActiviteUserDtoRetour;
import com.formation.apptracking.dto.AvtiviteUserDto;
import com.formation.apptracking.dto.PointGpsDto;
import com.formation.apptracking.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ActiviteUserService {

    private ActiviteUserRepository activiteUserRepository;
    private ActiviteRepository activiteRepository;
    private UsersRepository usersRepository;
    private PointGpsRepository pointGpsRepository;

    @Autowired
    public ActiviteUserService(ActiviteUserRepository activiteUserRepository, ActiviteRepository activiteRepository, UsersRepository usersRepository, PointGpsRepository pointGpsRepository) {
        this.activiteUserRepository = activiteUserRepository;
        this.activiteRepository = activiteRepository;
        this.usersRepository = usersRepository;
        this.pointGpsRepository = pointGpsRepository;
    }

    @Transactional
    public AvtiviteUserDto saveNewUserActivite(AvtiviteUserDto activiteUserDto){
        try {
            Activiteuser au= new Activiteuser();
            au.setIdActivite(activiteUserDto.getIdActivite());
            au.setIdUser(activiteUserDto.getIdUser());
            au.setDateActivite(activiteUserDto.getDateActivite());
            au.setHeureDebut(activiteUserDto.getHeureDebut());
            au.setHeureFin(activiteUserDto.getHeureFin());
            au.setValide('O');
            this.activiteUserRepository.save(au);
            activiteUserDto.setIdActiviteUser(au.getIdActiviteUser());
            return activiteUserDto;
        }catch (Exception ex){
            System.err.println("erreur lors de l'ajout"+ ex.getMessage());
            return activiteUserDto;
        }
    }

    @Transactional
    public AvtiviteUserDto UpdateUserActivite(AvtiviteUserDto activiteUserDto){
        try {
            Activiteuser au= this.activiteUserRepository.findById(activiteUserDto.getIdActiviteUser()).orElseThrow(()
                    -> new EntityNotFoundException(String.format("Activité introuvable par l'id ")));
            au.setHeureFin(activiteUserDto.getHeureFin());
            this.activiteUserRepository.save(au);
            activiteUserDto.setIdActiviteUser(au.getIdActiviteUser());
            return activiteUserDto;
        }catch (Exception ex){
            System.err.println("erreur lors de l'ajout"+ ex.getMessage());
            return activiteUserDto;
        }
    }


    @Transactional
    public PointGpsDto saveNewPointGpsPourActivite(PointGpsDto point){
        try {
            Pointgps p= new Pointgps();
            p.setIdActiviteUser(point.getIdActiviteUser());
            p.setHeure(point.getHeure());
            p.setLatitude(point.getLatitude());
            p.setLongitude(point.getLongitude());
            this.pointGpsRepository.save(p);
            return point;
        }catch (Exception ex){
            System.err.println("erreur lors de l'ajout"+ ex.getMessage());
            return point;
        }
    }

    public  ActiviteDto toActiviteDto(Activite a){
        ActiviteDto adt=new ActiviteDto();
        adt.setIdActivite(a.getIdActivite());
        adt.setLibelleActivite(a.getLibelleActivite());
        return adt;
    }

    public ActiviteUserDtoRetour toActiviteUserDtoRtour(Activiteuser a){
        Activite ac=this.activiteRepository.findById(a.getIdActivite()).orElseThrow(()
                -> new EntityNotFoundException(String.format("Id de l'activite selectionner n'existe pas dans la base: ",a.getActivite())));

        Users u=this.usersRepository.findById(a.getIdUser()).orElseThrow(()
                -> new EntityNotFoundException(String.format("Id de l'activite selectionner n'existe pas dans la base: ",a.getActivite())));

        List<Pointgps> listePointActivite=this.pointGpsRepository.findPointgpsByIdActiviteUser(a.getIdActiviteUser());
        List<PointGpsDto> listePointGpsActivite=getListPointGpsDtoByListPointGps(listePointActivite);

        ActiviteUserDtoRetour activiteRetour=new ActiviteUserDtoRetour();
        activiteRetour.setIdActiviteUser(a.getIdActiviteUser());
        activiteRetour.setDateActivite(a.getDateActivite());
        activiteRetour.setHeureDebut(a.getHeureDebut());
        activiteRetour.setHeureFin(a.getHeureFin());
        activiteRetour.setIdActivite(a.getIdActivite());
        activiteRetour.setIdUser(a.getIdUser());
        activiteRetour.setLibelleActivite(ac.getLibelleActivite());
        activiteRetour.setValide(a.getValide());
        activiteRetour.setListPointGps(listePointGpsActivite);
        activiteRetour.setPrenomNomUser(u.getNomUser()+" "+u.getPrenomUser());
        return activiteRetour;
    }

    public  List<PointGpsDto> getListePointGpsByIdActiviteUser(long idActiviteUser){
        List<Pointgps> listePoint=this.pointGpsRepository.findPointgpsByIdActiviteUser(idActiviteUser);
        return this.getListPointGpsDtoByListPointGps(listePoint);
    }

   public List<PointGpsDto>  getListPointGpsDtoByListPointGps(List<Pointgps> listePointActivite){
        List<PointGpsDto> listePointGpsActivite=new ArrayList<>();
        for(Pointgps p:listePointActivite){
            PointGpsDto npg=new PointGpsDto();
            npg.setIdActiviteUser(p.getIdActiviteUser());
            npg.setHeure(p.getHeure());
            npg.setLatitude(p.getLatitude());
            npg.setLongitude(p.getLongitude());
            listePointGpsActivite.add(npg);
        }
        return listePointGpsActivite;
    }

    public List<ActiviteUserDtoRetour> getListeActiviteUserByIdUser(Long idUser){
        List<Activiteuser> listActivite=this.activiteUserRepository.getActiviteTerminerByIdUser(idUser);
        List<ActiviteUserDtoRetour> listActiviterByUser=new ArrayList<>();
        for(Activiteuser activite:listActivite){
            listActiviterByUser.add(toActiviteUserDtoRtour(activite));
        }
        return listActiviterByUser;
    }

    public List<ActiviteUserDtoRetour> getAllActiviteEnCours(){
        List<Activiteuser> listActivite=this.activiteUserRepository.getActiviteEnCours();
        List<ActiviteUserDtoRetour> listActiviterByUser=new ArrayList<>();
        for(Activiteuser activite:listActivite){
            listActiviterByUser.add(toActiviteUserDtoRtour(activite));
        }
        return listActiviterByUser;
    }

    public List<ActiviteUserDtoRetour> getListeActiviteUserByIdActivite(Long idActivite){
        List<Activiteuser> listActivite=this.activiteUserRepository.findByIdActivite(idActivite);
        List<ActiviteUserDtoRetour> listActiviterByUser=new ArrayList<>();
        for(Activiteuser activite:listActivite){
            listActiviterByUser.add(toActiviteUserDtoRtour(activite));
        }
        return listActiviterByUser;
    }


    public List<ActiviteDto> getListeAllActivite(){
        List<ActiviteDto> listBqDto=new ArrayList<ActiviteDto>();
        for(Activite a :this.activiteRepository.findAll()){
            listBqDto.add(toActiviteDto(a));
        }
        return listBqDto;
    }

}

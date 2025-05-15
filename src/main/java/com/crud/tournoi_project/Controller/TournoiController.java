//package com.crud.tournoi_project.Controller;
//
//import com.crud.tournoi_project.Entity.DoubleElim;
//import com.crud.tournoi_project.Entity.RoundRobin;
//import com.crud.tournoi_project.Entity.SimpleElim;
//import com.crud.tournoi_project.Entity.Tournoi;
//import com.crud.tournoi_project.Repository.DoubleElimRepository;
//import com.crud.tournoi_project.Repository.RoundRobinRepository;
//import com.crud.tournoi_project.Repository.SimpleElimRepository;
//import com.crud.tournoi_project.Repository.TournoiRepository;
//import jakarta.transaction.Transactional;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//public class TournoiController {
//
//    private final SimpleElimRepository simpleElimRepository;
//    TournoiRepository tournoiRepository;
//    SimpleElimRepository SER;
//    DoubleElimRepository DER;
//    RoundRobinRepository RRR;
//
//    public TournoiController(SimpleElimRepository simpleElimRepository) {
//        this.simpleElimRepository = simpleElimRepository;
//    }
//
//    @GetMapping("/tournois")
//    public ResponseEntity tournois() {
//
//        return ResponseEntity.ok().body(tournoiRepository.findAll());
//    }
//
//    @PostMapping("/tournois")
//    @Transactional
//    public ResponseEntity addTournoi(@RequestBody Tournoi tournoi) {
//        tournoiRepository.save(tournoi);
//        return ResponseEntity.ok().body(tournoi);
//    }
//
//    @PutMapping("/tournoi/edit/{id}")
//    @Transactional
//    public ResponseEntity editTournoi(@PathVariable int id, @RequestBody Tournoi tournoi) {
//        if (tournoiRepository.existsById(id)) {
//            tournoi.setDate_debut(tournoi.getDate_debut());
//            tournoi.setDate_fin(tournoi.getDate_fin());
//            tournoi.setNom(tournoi.getNom());
//            tournoiRepository.save(tournoi);
//
//            return ResponseEntity.ok().body(tournoi);
//        }
//        else{
//            return ResponseEntity.status(404).body("Aucun tournoi trouvé pour cet id");
//        }
//    }
//
//    @DeleteMapping("/tournoi/delete/{id}")
//    @Transactional
//    public ResponseEntity deleteTournoi(@PathVariable int id) {
//        tournoiRepository.deleteById(id);
//
//        return ResponseEntity.ok().body(tournoiRepository.findById(id));
//    }
//
//    @GetMapping("/SERs")
//    public ResponseEntity sers() {
//        return ResponseEntity.ok().body(SER.findAll());
//    }
//
//    @PostMapping("/SERs")
//    @Transactional
//    public ResponseEntity serAdd(@RequestBody SimpleElim tournoi) {
//        SER.save(tournoi);
//        return ResponseEntity.ok().body(tournoi);
//    }
//
//    @PutMapping("SER/edit/{id}")
//    public ResponseEntity serEdit(@PathVariable int id, @RequestBody SimpleElim tournoi) {
//        if (SER.existsById(id)) {
//            tournoi.setNom(tournoi.getNom());
//            tournoi.setDate_debut(tournoi.getDate_debut());
//            tournoi.setDate_fin(tournoi.getDate_fin());
//            tournoi.setTroisiemePlace(tournoi.getTroisiemePlace());
//            SER.save(tournoi);
//
//            return ResponseEntity.ok().body(tournoi);
//        }
//        else{
//
//            return ResponseEntity.status(404).body("Aucun tournoi trouvé pour cet id");
//        }
//    }
//
//    @DeleteMapping("/SER/delete/{id}")
//    public ResponseEntity serDelete(@PathVariable int id) {
//        if (SER.existsById(id)) {
//            SER.deleteById(id);
//
//            return ResponseEntity.ok().body(SER.findById(id));
//        }
//        else{
//
//            return ResponseEntity.status(404).body("Aucun tournoi trouvé pour cet id");
//        }
//    }
//
//    @GetMapping("/DERs")
//    public ResponseEntity ders() {
//        return ResponseEntity.ok().body(DER.findAll());
//    }
//
//    @PostMapping("/DERs")
//    @Transactional
//    public ResponseEntity derAdd(@RequestBody DoubleElim tournoi) {
//        DER.save(tournoi);
//        return ResponseEntity.ok().body(tournoi);
//    }
//
//    @PutMapping("DER/edit/{id}")
//    public ResponseEntity serEdit(@PathVariable int id, @RequestBody DoubleElim tournoi) {
//        if (DER.existsById(id)) {
//            tournoi.setNom(tournoi.getNom());
//            tournoi.setDate_debut(tournoi.getDate_debut());
//            tournoi.setDate_fin(tournoi.getDate_fin());
//            tournoi.setFinale(tournoi.getFinale());
//            DER.save(tournoi);
//
//            return ResponseEntity.ok().body(tournoi);
//        }
//        else{
//
//            return ResponseEntity.status(404).body("Aucun tournoi trouvé pour cet id");
//        }
//    }
//
//    @DeleteMapping("/DER/delete/{id}")
//    public ResponseEntity derDelete(@PathVariable int id) {
//        if (DER.existsById(id)) {
//            DER.deleteById(id);
//
//            return ResponseEntity.ok().body(DER.findById(id));
//        }
//        else{
//
//            return ResponseEntity.status(404).body("Aucun tournoi trouvé pour cet id");
//        }
//    }
//
//    @GetMapping("/RRRs")
//    public ResponseEntity rrrs() {
//        return ResponseEntity.ok().body(RRR.findAll());
//    }
//
//    @PostMapping("/RRRs")
//    @Transactional
//    public ResponseEntity derAdd(@RequestBody RoundRobin tournoi) {
//        RRR.save(tournoi);
//        return ResponseEntity.ok().body(tournoi);
//    }
//
//    @PutMapping("RRR/edit/{id}")
//    public ResponseEntity serEdit(@PathVariable int id, @RequestBody RoundRobin tournoi) {
//        if (RRR.existsById(id)) {
//            tournoi.setNom(tournoi.getNom());
//            tournoi.setDate_debut(tournoi.getDate_debut());
//            tournoi.setDate_fin(tournoi.getDate_fin());
//            tournoi.setMatchRetour(tournoi.getMatchRetour());
//            RRR.save(tournoi);
//
//            return ResponseEntity.ok().body(tournoi);
//        }
//        else{
//
//            return ResponseEntity.status(404).body("Aucun tournoi trouvé pour cet id");
//        }
//    }
//
//    @DeleteMapping("/RRR/delete/{id}")
//    public ResponseEntity rrrDelete(@PathVariable int id) {
//        if (RRR.existsById(id)) {
//            RRR.deleteById(id);
//
//            return ResponseEntity.ok().body(RRR.findById(id));
//        }
//        else{
//
//            return ResponseEntity.status(404).body("Aucun tournoi trouvé pour cet id");
//        }
//    }
//}

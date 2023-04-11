//package com.example.Loc_mns.controller;
//
//import com.example.Loc_mns.entity.Connexion;
//import com.example.Loc_mns.service.ConnexionService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/connexion")
//public class ConnexionController {
//
//    @Autowired
//    private ConnexionService connexionService;
//
//    @PostMapping("/")
//    public Connexion save(@RequestBody Connexion connexion) {
//        return connexionService.save(connexion);
//    }
//
//    @GetMapping("/{id}")
//    public Connexion findById(@PathVariable int id) {
//        return connexionService.findById(id);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteById(@PathVariable int id) {
//        connexionService.deleteById(id);
//    }
//}
//



// à verifier *********************************************************

package com.example.Loc_mns.controller;

import com.example.Loc_mns.entity.Connexion;
import com.example.Loc_mns.service.ConnexionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/connexion")
public class ConnexionController {
@Autowired
private ConnexionService connexionService;

@Autowired
private PasswordEncoder passwordEncoder;

@GetMapping("/login")
public String showLoginPage(Model model) {
        model.addAttribute("login", new Connexion());
        return "login";
        }

@PostMapping("/login")
public String processLogin(@ModelAttribute("login") Connexion connexion, Model model) {
        // Vérifiez les informations d'identification de l'utilisateur à partir de la base de données.
        Connexion user = connexionService.findByLogin(connexion.getLogin());
        if (user != null && passwordEncoder.matches(connexion.getPassword(), user.getPassword())) {
        // Informations d'identification valides, redirigez l'utilisateur vers la page d'accueil.
        return "redirect:/";
        } else {
        // Informations d'identification invalides, renvoyez l'utilisateur vers la page de connexion avec un message d'erreur.
        model.addAttribute("error", true);
        return "login";
        }
        }
}



// connexion securisé ***************************************



//package com.example.Loc_mns.controller;
//
//import com.example.Loc_mns.service.ConnexionService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//
//@Controller
//@RequestMapping("/connexion")
//public class ConnexionController {
//
//    @Autowired
//    private ConnexionService connexionService;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @GetMapping("/login")
//    public String showLoginPage() {
//        return "login";
//    }
////
////    @PostMapping("/login")
////    public String processLogin(@RequestParam String login, @RequestParam String password, Model model) {
////        // Vérifiez les informations d'identification de l'utilisateur à partir de la base de données.
////        Connexion connexion = connexionService.findByLogin(login);
////        if (connexion != null && passwordEncoder.matches(password, connexion.getPassword())) {
////            // Informations d'identification valides, redirigez l'utilisateur vers la page d'accueil.
////            return "redirect:/";
////        } else {
////            // Informations d'identification invalides, renvoyez l'utilisateur vers la page de connexion avec un message d'erreur.
////            model.addAttribute("error", true);
////            return "login";
////        }
////    }
////
////    @PostMapping("/logout")
////    public String processLogout(HttpServletRequest request, HttpServletResponse response) {
////        // Invalidate the session and redirect to the login page
////        request.getSession().invalidate();
////        return "redirect:/connexion/login?logout";
////    }
//
//    @GetMapping("/profil")
//    public String showProfilePage(Model model) {
//        // Récupérez l'utilisateur connecté à partir de l'objet SecurityContextHolder
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication != null && authentication.isAuthenticated()) {
//            // L'utilisateur est connecté, récupérez ses informations et affichez-les sur la page de profil.
//            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//            model.addAttribute("username", userDetails.getUsername());
//            model.addAttribute("roles", userDetails.getAuthorities());
//            return "profil";
//        } else {
//            // L'utilisateur n'est pas connecté, renvoyez-le vers la page de connexion.
//            return "redirect:/connexion/login";
//        }
//    }
//}

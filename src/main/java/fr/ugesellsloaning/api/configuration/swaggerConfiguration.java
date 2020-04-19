package fr.ugesellsloaning.api.configuration;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.awt.print.Pageable;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableSwagger2
public class swaggerConfiguration {

    private static final String DEFAULT_INCLUDE_PATTERN = "/api/.*";
    private static final String AUTHORIZATION_HEADER = "Authorization";

    @Bean
    public Docket swaggerSpringfoxDocket() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .pathMapping("/")
                .forCodeGeneration(true)
                .genericModelSubstitutes(ResponseEntity.class)
                .ignoredParameterTypes(Pageable.class)
                .ignoredParameterTypes(java.sql.Date.class)
                .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
                .directModelSubstitute(java.time.LocalDateTime.class, Date.class)
                .useDefaultResponseMessages(false);

        docket = docket.select()
                .paths(PathSelectors.regex(DEFAULT_INCLUDE_PATTERN))
                .apis(RequestHandlerSelectors.basePackage("fr.ugesellsloaning.api.controllers"))
                .build();
        return  docket;
        }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("REST API - University Gustave Effeil")
                .description("Membres:\n" +
                        "\n" +
                        "Coté Android:\n" +
                        "- Mohsine Bahhou \n" +
                        "- Yasmine Mekouar\n" +
                        "- Fatima Zohra Sersouri\n" +
                        "- Ahmed Bennani\n" +
                        "\n" +
                        "Coté Service web:\n" +
                        "- Mamadou Kanghe Balde\n" +
                        "- Mamadou Hassimiou Diallo\n" +
                        "\n" +
                        "Sujet:\n" +
                        "\n" +
                        "L’université Gustave Eiffel désire offrir un service de partage interne de toutes sortes de produits (livres, vêtements, etc.), utilisable par ses enseignants et étudiants, et dont la gestion est effectuée avec une application Android, connecté avec un service web REST. Les produits peuvent être ajoutés à la base ou être empruntés par tous. Il est possible d’ajouter de notes et des commentaires sur le produit et son état lors de sa restitution. Lorsqu’une personne demande à emprunter un produit, et que celui-ci est déjà prêté à autrui, elle est inscrite sur liste d’attente ; dès que le produit demandé devient disponible, la personne est notifiée et l’emprunte. En présence de plusieurs personnes en attente, les enseignants sont servis en priorité. S’il y a deux étudiants ou deux enseignants en concurrence sur un produit, celui qui a le moins emprunté de produits est servi en priorité. Dans un deuxième temps, l’université Gustave Eiffel désire valoriser sa base de produits, enrichie par les notes et commentaires de ses enseignants et étudiants, et la rendre accessible à l’extérieur. Elle propose à la vente les produits qui ont été introduits dans sa base depuis au moins deux mois, et qui ont été empruntés au moins deux fois. Le service Web permet de consulter les prix des produits, de vérifier leur disponibilité, de les ajouter à un panier et de les acheter. Le panier d’un client peut à tout moment être modifié ou vidé. Pour effectuer un achat, l’application vérifie la disponibilité des fonds nécessaires à l'achat et effectue le paiement. Les prix des produits sont en Euros, mais l’université permet des ventes dans toutes les monnaies du monde, et doit fournir les prix dans la devise demandée par l'acheteur. Les taux de change utilisés doivent être trouvés en temps-réel. \n" +
                        "\n" +
                        "Détails techniques:\n" +
                        "\n" +
                        "- L’application Android est réalisée avec un SDK 28 voici les technologies que nous avons utilisé:\n" +
                        "- HttpURLConnection : pour lancer des requêtes avec le service web\n" +
                        "- ViewPager : utilisé dans les slides d’accueil \n" +
                        "- DialogFragment: pour afficher DatePickerDialog et TimePickerDialog\n" +
                        "- RecyclerView : Pour afficher une liste d’éléments\n" +
                        "- Picasso : pour charger les images depuis un url\n" +
                        "- FingerprintManager : pour s’authentifier avec empreinte digitale\n" +
                        "- SQLite Database : pour stocker les id des utilisateurs authentifiés par empreinte digitale\n" +
                        "- BroadcastReceiver : pour recevoir les notifications\n" +
                        "\n" +
                        "Le Service Web REST est codé en Java 11 avec : \n" +
                        "- Les frameworks Spring, Maven, Swagger (pour la documentation), la dépendance javax.mail pour l’envoie des mails. \n" +
                        "- L’api : http://data.fixer.io/api/ qui nous retourne un fichier JSON des taux de conversion de toute les monnaies du monde en temps réel.\n" +
                        "- Une base de données MySql.\n" +
                        "Le service web ainsi que la base de données sont hébergées sur le serveur de heroku sur ce liens : https://uge-webservice.herokuapp.com/swagger-ui.html \n" +
                        "\n" +
                        "Liens Github:\n" +
                        "\n" +
                        "Android : https://github.com/mohsinebahhou/ProjetAndroid_androidApp\n" +
                        "Service web : https://github.com/Hasmiou/ProjetAndroidWebService\n" +
                        "\n" +
                        "Liens de téléchargements:\n" +
                        "Projet Android : http://makcenter.ma/uge/projetAndroid/CodeSource/ProjetAndroid.zip\n" +
                        "Apk : http://makcenter.ma/uge/projetAndroid/CodeSource/app-debug.apk\n" +
                        "Service web : http://makcenter.ma/uge/projetAndroid/CodeSource/ProjetAndroidWebService-master.zip\n" +
                        "\n" +
                        "Liens de vidéos de démonstrations : \n" +
                        "\n" +
                        "Mohsine Bahhou : http://makcenter.ma/uge/projetAndroid/video/MohsineBahhou.mp4\n" +
                        "Mamadou Kanghe Balde : http://makcenter.ma/uge/projetAndroid/video/MamadouKangheBalde.mp4\n" +
                        "Fatima Zohra Sersouri : http://makcenter.ma/uge/projetAndroid/video/FatimaZohraSersouri.mp4\n" +
                        "Yasmine Mekouar : http://makcenter.ma/uge/projetAndroid/video/YasmineMekouar.mp4\n" +
                        "Mamadou Hassimiou Diallo : http://makcenter.ma/uge/projetAndroid/video/MamadouHassimiouDiallo.mp4\n" +
                        "Ahmed Bennani: http://makcenter.ma/uge/projetAndroid/video/AhmedBennani.mp4\n -Diallo Mamadou Hassimiou" +
                        "\n -Balde Mamadou Kanghe" +
                        "\n -Mouhsine" +
                        "\n -Fati" +
                        "\n -Yasmine Mekouar" +
                        "\n -Ahmed.").termsOfServiceUrl("")
                .contact(new Contact("Developper", "www.mondemarcheur.com", "mamadou-hassimiou.diallo@outlook.com"))
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .version("1.0.0")
                .build();
    }

}

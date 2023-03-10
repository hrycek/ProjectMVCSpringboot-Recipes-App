package com.example.lab3pp;

import com.example.lab3pp.models.*;
import com.example.lab3pp.repositories.*;
import com.example.lab3pp.services.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.*;

@Configuration
@AllArgsConstructor
public class InitRepositories {

    private final RecipeService recipeService;
    private final CategoryService categoryService;
    private final IngredientService ingredientService;
    private final UserServiceImpl userService;
    private final RoleService roleService;
    private final CommentService commentService;

    List<Category> categoryList = new ArrayList<Category>();
    List<Recipe> recipeList = new ArrayList<Recipe>();
    List<Ingredient> ingredientList = new ArrayList<Ingredient>();
    List<User> userList = new ArrayList<User>();
    List<Role> roleList = new ArrayList<Role>();
    List<Comment> commentList = new ArrayList<Comment>();

    private final PasswordEncoder passwordEncoder;

    @Bean
    InitializingBean init() {

        return () -> {
            if (categoryService.findAll().isEmpty()) {

                categoryList.add(new Category("Desery"));
                categoryList.add(new Category("Makarony"));
                categoryList.add(new Category("Zupy"));
                categoryService.saveAll(categoryList);
            }
            if (ingredientService.findAll().isEmpty()) {
                ingredientList.add(new Ingredient("Cebula"));
                ingredientList.add(new Ingredient("Szpinak"));
                ingredientList.add(new Ingredient("Marchewka"));
                ingredientList.add(new Ingredient("Ziemniak"));
                ingredientList.add(new Ingredient("Pomidor"));
                ingredientList.add(new Ingredient("Broku??"));

                ingredientList.add(new Ingredient("Wywar"));
                ingredientList.add(new Ingredient("Masa kr??wkowa"));
                ingredientList.add(new Ingredient("Powid??a"));
                ingredientList.add(new Ingredient("Przecier pomidorowy"));
                ingredientList.add(new Ingredient("??mietana"));
                ingredientList.add(new Ingredient("D??em"));
                ingredientList.add(new Ingredient("M??ka"));

                ingredientList.add(new Ingredient("Makaron"));
                ingredientList.add(new Ingredient("Mi??so"));
                ingredientList.add(new Ingredient("Ser"));
                ingredientList.add(new Ingredient("Jajka"));
                ingredientList.add(new Ingredient("Kurczak"));
                ingredientList.add(new Ingredient("Mleko"));

                ingredientService.saveAll(ingredientList);
            }
            if (recipeService.findAll().isEmpty()) {
                recipeList.add(new Recipe("Makaron ze szpinakiem",
                        "Makaron ugotowa?? al dente w osolonej wodzie. Szpinak op??uka?? i odcedzi??. \n" +
                                "\n" +
                                "Na patelni na oliwie i ma??le zeszkli?? pokrojon?? w kosteczk?? cebul?? (ok. 5 - 7 minut). Doprawi?? sol??, doda?? przeci??ni??ty przez prask?? czosnek i sma??y?? jeszcze przez ok. 2 minuty. \n" +
                                "\n" +
                                "Doda?? szpinak i mieszaj??c podgrzewa?? przez ok. 1 minut?? a?? zwi??dnie. \n" +
                                "\n" +
                                "Wla?? ??mietank??, doprawi?? ??wie??o zmielonym pieprzem i sol??, ca??o???? zagotowa??. Doda?? odcedzony makaron i wymiesza??. \n" +
                                "\n" +
                                "Po????czy?? z 1/3 ilo??ci sera, reszt?? wykorzysta?? do posypania makaronu. ",
                        LocalDate.now(), false, 28.50, categoryList.get(1), new CookingTime(1, 15), "easy"));
                recipeList.add(new Recipe("Spaghetti",
                        "Cebul?? i czosnek obra?? i poszatkowa??. \n" +
                                "\n" +
                                "Marchewk?? umy??, obra?? i pokroi?? w drobn?? kostk??. \n" +
                                "\n" +
                                "Cebul?? i czosnek chwilk?? podsma??y?? na oleju. Doda?? mi??so mielone i marchewk??. Wszystko razem chwil?? podsma??y??, a?? mi??so straci kolor r????owy. Doda?? pomidory z puszki (razem z sosem z puszki), przecier pomidorowy i bulion. Ca??o???? dusi?? pod przykryciem na niskiej mocy palnika ok. 20 minut. Przyprawi?? sol??, pieprzem i oregano. \n" +
                                "\n" +
                                "Spaghetti ugotowa?? w osolonej wodzie wed??ug przepisu na opakowaniu. Odcedzi?? na durszlaku. (Nie przelewa?? zimn?? wod??). \n" +
                                "\n" +
                                "Spaghetti roz??o??y?? na talerzach. Pola?? sosem z mi??sem i posypa?? parmezanem. ",
                        LocalDate.now(), true, 24.00, categoryList.get(1), new CookingTime(1, 15), "easy"));
                recipeList.add(new Recipe("Makaron z serem",
                        "Wstawiam garnek z wod?? na gaz. \n" +
                                "\n" +
                                "Cebule obieram i kroj?? w drobn?? kostk??. Rozgrzewam na g????bokiej patelni mas??o i delikatnie przysma??am cebule. \n" +
                                "\n" +
                                "Ser ??cieram na tarce o grubych oczkach. \n" +
                                "\n" +
                                "Do garnka z gotuj??c?? si?? wod?? wrzucam 2 ??y??eczki soli oraz makaron. Gotuj?? zgodnie z instrukcj?? na opakowaniu. \n" +
                                "\n" +
                                "Do cebuli dodaj?? ??mietan??, pieprz bia??y i ser. Na ma??ym gazie zagotowuj?? wszystko, tak ??eby ser si?? rozpu??ci??. W razie potrzeby doprawiam jeszcze do smaku. \n" +
                                "\n" +
                                "Z garnka z makaronem odlewam 1 szklank?? wody, makaron przecedzam przez sito i wrzucam na patelni??. Mieszam dok??adnie. Je??li sos jest zbyt g??sty dolewam wod?? z \tgotowania. Mieszam ponownie. \n" +
                                "\n" +
                                "Od razu rozk??adam na talerze. ",
                        LocalDate.now(), false, 30.00, categoryList.get(1), new CookingTime(1, 15), "medium"));
                recipeList.add(new Recipe("Nale??niki z d??emem",
                        "Mleko wlej do miski. Dodaj wod?? gazowan??, jajka, cukier wanilinowy, s??l i wszystko zmiksuj. Na koniec dosyp przesian?? m??k??. \n" +
                                "\n" +
                                "Gdy ciasto b??dzie g??adkie i bez grudek, dodaj olej i jeszcze chwil?? miksuj. \n" +
                                "\n" +
                                "Rozgrzej patelni?? delikatnie przetart?? olejem i sma?? cienkie nale??niki z obu stron na z??oty kolor. \n" +
                                "\n" +
                                "Gotowe nale??niki przek??adaj na talerz. Je??li nie zamierzasz ich od razu podawa?? przykryj drugim talerzem lub przykrywk??, aby nie wysch??y. \n" +
                                "\n" +
                                "Nale??niki smaruj ulubionym d??emem i zawijaj w rulony, ??wiartki, b??d?? koperty. ",
                        LocalDate.now(), false, 23.00, categoryList.get(0), new CookingTime(1, 0), "easy"));
                recipeList.add(new Recipe("Zupa pomidorowa",
                        "Do garnka wk??adamy udka i wlewamy wod?? (tak, aby je zakry??a). Dodajemy ziele angielskie i li???? laurowy oraz trzy obrane i umyte marchewki. \n" +
                                "\n" +
                                "Gotujemy na ma??ym ogniu przez oko??o godzin??. \n" +
                                "\n" +
                                "Kiedy marchewka zmi??knie, wyjmuje j??, kroimy w talarki i ponownie dodaje do zupy. \n" +
                                "\n" +
                                "Dodajemy przecier pomidorowy i bulion drobiowy WINIARY do smaku. \n" +
                                "\n" +
                                "Gotujemy jeszcze przez chwil?? na ma??ym ogniu i dodajemy ??mietan??. \n" +
                                "\n" +
                                "Zup?? podajemy razem z ugotowanym makaronem. ",
                        LocalDate.now(), true, 26.40, categoryList.get(2), new CookingTime(1, 45), "medium"));
                recipeList.add(new Recipe("Wafle z kajmakiem",
                        "Wafle smarujemy zawsze od strony, gdzie kratka jest mniejsza. Jest wydajniejszy spos??b, a wafle tak szybko nie zmi??kn??. \n" +
                                "\n" +
                                "Pierwsz?? warstw?? posmarowa?? d??emem z czarnej porzeczki, przy??o??y?? drugim waflem, docisn????, posmarowa?? go kajmakiem, przykry?? kolejnym waflem ??? docisn????. Nast??pny posmarowa?? powid??ami ??liwkowymi i zn??w przykry?? waflem, posmarowa?? go kajmakiem i przykry?? ostatnim waflem. \n" +
                                "\n" +
                                "Prze??o??one wafle przek??adamy ponownie do papieru, zawijamy i dociskamy np. ksi????kami lub ci????k?? desk?? do krojenia. Mo??na przenie???? je w ch??odne miejsce. \n" +
                                "\n" +
                                "Po godzinie s?? gotowe do jedzenia. ",
                        LocalDate.now(), false, 16.80, categoryList.get(0), new CookingTime(0, 45), "easy"));
            }
            if (roleService.findAll().isEmpty()) {
                roleList.add(new Role(Role.Types.ROLE_USER));
                roleList.add(new Role(Role.Types.ROLE_ADMIN));

                roleService.saveAll(roleList);
            }
            if (userService.findAll().isEmpty()) {
                Random rand = new Random();

                User a = new User("admin", true);
                a.setRoles(new HashSet<>(Arrays.asList(roleList.get(1))));
                a.setPassword(passwordEncoder.encode("admin"));
                a.setFirstname("Bartosz");
                a.setLastname("Hrycaj");
                a.setEmail("bh83464@stud.uph.edu.pl");
                userList.add(a);

                User ua = new User("superadmin", true);
                ua.setRoles(new HashSet<>(Arrays.asList(roleList.get(0), roleList.get(1))));
                ua.setPassword(passwordEncoder.encode("superadmin"));
                userList.add(ua);

                User u = new User("user", true);
                u.setRoles(new HashSet<>(Arrays.asList(roleList.get(0))));
                u.setPassword(passwordEncoder.encode("user"));
                userList.add(u);

                String[] listNicknames = {"Lovey", "ThunderRajhs32", "BabyLoco42", "Pop Tart", "DillyDally33",
                        "Fiesta", "Munchkin", "Poraro", "Bambino", "Rufio16",
                        "Cheddar", "Bumpkin", "Birdyx54", "MiniMaxMex32", "Dork",
                        "Boo Bear", "Twix", "Pinkie", "Cricket", "Bossy",
                        "Chefior4", "Rosield32", "Doll", "Bumblebee", "CheetLol32",
                        "Coxach5", "Joker", "Hawk", "BabyBird18", "Smirk"};

                String[] listNames =  {"Leland Boyer dwendlan@att.net", "Harry Mckinney quantaman@outlook.com", "Raina Cooley qrczak@yahoo.com", "Yaritza Wood murty@msn.com", "Abbie Jones thassine@me.com",
                        "Skye Ellis draper@hotmail.com", "Ryleigh Huff skythe@hotmail.com", "Atticus Herrera jmorris@sbcglobal.net", "Dennis Kaufman aprakash@optonline.net", "Yadiel Woods dcoppit@verizon.net",
                        "Ashtyn Morgan petersen@live.com", "Remington Vance aukjan@me.com", "Micah Schmitt jfmulder@optonline.net", "Evie Barron zeller@sbcglobal.net", "Tori Callahan jshirley@mac.com",
                        "Nikhil Fitzpatrick joehall@outlook.com", "Kassidy Sweeney jamuir@me.com", "Hanna Stein shrapnull@outlook.com", "Amare Ford research@me.com", "Jaylee Hanson mcraigw@msn.com",
                        "Gwendolyn Stout blixem@verizon.net", "Brayan Callahan gbacon@yahoo.com", "Devon Andrade schwaang@hotmail.com", "Cristal Guzman crimsane@hotmail.com", "Kaylynn Cochran shawnce@outlook.com",
                        "Ben Berger sagal@comcast.net", "Malakai Guerra marnanel@yahoo.com", "Zain Luna dvdotnet@me.com", "Broderick Barber damian@outlook.com", "Maritza Kelly catalog@live.com"};
                for (int i = 0; i < 30; i++) {
                    u = new User(listNicknames[i], true);
                    u.setRoles(new HashSet<>(Arrays.asList(roleList.get(0))));
                    u.setPassword(passwordEncoder.encode(listNicknames[i]));
                    int los = rand.nextInt(2);
                    if (los == 1) {
                        u.setFirstname(listNames[i].split(" ")[0]);
                        u.setLastname(listNames[i].split(" ")[1]);
                        u.setEmail(listNames[i].split(" ")[2]);
                    }
                    userList.add(u);
                }


                userService.saveAll(userList);
            }
            if(commentService.findAll().isEmpty()){
                commentList.add(new Comment("Bardzo dobry przepis. Polecam spr??bowa?? ka??demu!", LocalDate.now(), 1, recipeList.get(0).getName(), userList.get(5).getUsername()));
                commentList.add(new Comment("Ale pyszno??ci!!! Szybki, smaczny i tani przepis, polecam!", LocalDate.now(), 1, recipeList.get(0).getName(), userList.get(8).getUsername()));
                commentList.add(new Comment("Na pewno u??yje tego przepisu nie raz i nie dwa! :)", LocalDate.now(), 1, recipeList.get(0).getName(), userList.get(12).getUsername()));
                recipeList.get(0).setCommentsCount(3);

                commentList.add(new Comment("Bardzo dobry przepis. Polecam spr??bowa?? ka??demu! Dodaje do listy ulubionych przepis??w :D", LocalDate.now(), 2, recipeList.get(1).getName(), userList.get(24).getUsername()));
                recipeList.get(1).setCommentsCount(1);

                commentList.add(new Comment("Bardzo dobry przepis. Polecam spr??bowa?? ka??demu!", LocalDate.now(), 3, recipeList.get(2).getName(), userList.get(7).getUsername()));
                commentList.add(new Comment("Ale pyszno??ci!!! Szybki, smaczny i tani przepis, polecam!", LocalDate.now(), 3, recipeList.get(2).getName(), userList.get(6).getUsername()));
                commentList.add(new Comment("Na pewno u??yje tego przepisu nie raz i nie dwa! :)", LocalDate.now(), 3, recipeList.get(2).getName(), userList.get(9).getUsername()));
                recipeList.get(2).setCommentsCount(3);

                commentList.add(new Comment("Bardzo dobry przepis. Polecam spr??bowa?? ka??demu!", LocalDate.now(), 4, recipeList.get(3).getName(), userList.get(16).getUsername()));
                commentList.add(new Comment("Ale pyszno??ci!!! Szybki, smaczny i tani przepis, polecam!", LocalDate.now(), 4, recipeList.get(3).getName(), userList.get(26).getUsername()));
                recipeList.get(3).setCommentsCount(2);

                commentList.add(new Comment("Bardzo dobry przepis. Polecam spr??bowa?? ka??demu! Dodaje do mojej ksi????ki <3", LocalDate.now(), 5, recipeList.get(4).getName(), userList.get(17).getUsername()));
                commentList.add(new Comment("Ale pyszno??ci!!! Szybki, smaczny i tani przepis, polecam!", LocalDate.now(),5, recipeList.get(4).getName(), userList.get(22).getUsername()));
                recipeList.get(4).setCommentsCount(2);


                commentList.add(new Comment("Bardzo dobry przepis. Polecam spr??bowa?? ka??demu!", LocalDate.now(), 6, recipeList.get(5).getName(), userList.get(4).getUsername()));
                commentList.add(new Comment("Ale pyszno??ci!!! Szybki, smaczny i tani przepis, polecam!", LocalDate.now(), 6, recipeList.get(5).getName(), userList.get(28).getUsername()));
                recipeList.get(5).setCommentsCount(2);

                commentService.saveAll(commentList);
                recipeService.saveAll(recipeList);



            }
        };

    }
}



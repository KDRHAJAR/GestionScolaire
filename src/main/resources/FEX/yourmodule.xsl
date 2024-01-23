<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <head>
                <style>
                    body {
                    font-family: 'Arial', sans-serif;
                    background-color: #ffffff;
                    margin: 0;
                    padding: 0;
                    }

                    .dashboard {
                    display: flex;
                    height: 100vh;
                    }

                    header {
                    background-color: #f4f4f4;
                    box-shadow: 0 5px 10px rgba(0, 0, 0, 0.1);
                    display: flex;
                    justify-content: space-between;
                    align-items: center;
                    padding: 10px 20px;
                    height: 70px;
                    border-radius: 10px;
                    margin-right: 15x; /* Espacement entre le header et la barre de navigation */
                    }


                    .navigation {
                    display: flex;
                    flex-direction: column;
                    background-color: #ffffff;
                    box-shadow: 0 5px 10px rgba(0, 0, 0, 0.1);
                    padding: 20px;
                    border-radius: 10px;
                    width: 180px;
                    }

                    .nav-link {
                    color: #fff;
                    text-decoration: none;
                    margin-bottom: 10px;
                    }


                    .logo-container {
                    align-items: center;
                    display: flex;


                    }

                    .logo {
                    max-width: 100px;
                    height: auto;
                    margin-right: 10px;
                    border-radius: 15%;
                    }

                    h2 {
                    color: #000033;
                    font-size: 1.5em;
                    margin: 0;
                    }

                    .titre {
                    color: #000033;
                    font-size: 1em;
                    margin-top: 20px;
                    font-weight: 700; /* Ajoutez le poids de la police que vous souhaitez utiliser, par exemple 700 pour le gras */
                    }

                    #logout-btn {
                    background-color: #000033;
                    color: #ffffff;
                    padding: 10px 15px;
                    border: none;
                    border-radius: 5px;
                    cursor: pointer;
                    display: flex;
                    align-items: center;
                    }
                    .tableint{
                    background-color: #f4f4f4;
                    box-shadow: 0 5px 10px rgba(0, 0, 0, 0.1);
                    display: flex;
                    margin : 30px 10px 30px 10px;
                    align-items: center;
                    padding: 10px 20px;

                    border-radius: 10px;

                    }

                    #logout-btn img {
                    max-width: 20px;
                    height: auto;
                    margin-right: 5px;
                    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2); /* Ajout de l'ombre uniquement à l'image */

                    }
                    .contenue {
                    margin-left: 15px;
                    }

                    .containerr {
                    margin: 0 auto;
                    max-width: 1200px; /* ou une autre largeur selon vos besoins */
                    align-items: center;
                    }

                    .containerr-fluid {
                    margin: 0;
                    padding: 0;
                    }



                    img.logo {
                    max-width: 80px;
                    height: auto;
                    margin-right: 5px;
                    border-radius: 15%;
                    }

                    center {
                    margin-top: 20px;
                    }


                    table {
                    width: 100%;
                    border-collapse: collapse;
                    margin-top: 20px;
                    }

                    th, td {
                    padding: 10px;
                    text-align: left;
                    }

                    th {
                    background-color: #333;
                    color: #fff;
                    }

                    tr:nth-child(even) {
                    background-color: #f9f9f9;
                    }

                    tr:hover {
                    background-color: #ddd;
                    cursor: pointer;
                    }




















                    .site-footer
                    {
                    background-color:#f4f4f4;
                    padding:45px 0 20px;
                    font-size:15px;
                    line-height:24px;
                    color:#737373;
                    box-shadow: 0px -5px 15px rgba(0, 0, 0, 0.1);
                    }
                    .site-footer hr
                    {
                    border-top-color:#bbb;
                    opacity:0.5
                    }
                    .site-footer hr.small
                    {
                    margin:20px 0
                    }
                    .site-footer h6
                    {
                    color:black;
                    font-size:16px;
                    text-transform:uppercase;
                    margin-top:5px;
                    letter-spacing:2px
                    }
                    .site-footer a
                    {
                    color:#737373;
                    }
                    .site-footer a:hover
                    {
                    color:#3366cc;
                    text-decoration:none;
                    }
                    .footer-links
                    {
                    padding-left:0;
                    list-style:none
                    }
                    .footer-links li
                    {
                    display:block
                    }
                    .footer-links a
                    {
                    color:#737373
                    }
                    .footer-links a:active,.footer-links a:focus,.footer-links a:hover
                    {
                    color:#3366cc;
                    text-decoration:none;
                    }
                    .footer-links.inline li
                    {
                    display:inline-block
                    }
                    .site-footer .social-icons
                    {
                    text-align:right
                    }
                    .site-footer .social-icons a
                    {
                    width:40px;
                    height:40px;
                    line-height:40px;
                    margin-left:6px;
                    margin-right:0;
                    border-radius:100%;
                    background-color:#33353d
                    }
                    .copyright-text
                    {
                    margin:0
                    }
                    @media (max-width:991px)
                    {
                    .site-footer [class^=col-]
                    {
                    margin-bottom:30px
                    }
                    }
                    @media (max-width:767px)
                    {
                    .site-footer
                    {
                    padding-bottom:0
                    }
                    .site-footer .copyright-text,.site-footer .social-icons
                    {
                    text-align:center
                    }
                    }
                    .social-icons
                    {
                    padding-left:0;
                    margin-bottom:0;
                    list-style:none
                    }
                    .social-icons li
                    {
                    display:inline-block;
                    margin-bottom:4px
                    }
                    .social-icons li.title
                    {
                    margin-right:15px;
                    text-transform:uppercase;
                    color:#96a2b2;
                    font-weight:700;
                    font-size:13px
                    }
                    .social-icons a{
                    background-color:#eceeef;
                    color:#818a91;
                    font-size:16px;
                    display:inline-block;
                    line-height:44px;
                    width:44px;
                    height:44px;
                    text-align:center;
                    margin-right:8px;
                    border-radius:100%;
                    -webkit-transition:all .2s linear;
                    -o-transition:all .2s linear;
                    transition:all .2s linear
                    }
                    .social-icons a:active,.social-icons a:focus,.social-icons a:hover
                    {
                    color:#fff;
                    background-color:#29aafe
                    }
                    .social-icons.size-sm a
                    {
                    line-height:34px;
                    height:34px;
                    width:34px;
                    font-size:14px
                    }
                    .social-icons a.facebook:hover
                    {
                    background-color:#3b5998
                    }
                    .social-icons a.twitter:hover
                    {
                    background-color:#00aced
                    }
                    .social-icons a.linkedin:hover
                    {
                    background-color:#007bb6
                    }
                    .social-icons a.dribbble:hover
                    {
                    background-color:#ea4c89
                    }
                    @media (max-width:767px)
                    {
                    .social-icons li.title
                    {
                    display:block;
                    margin-right:0;
                    font-weight:600
                    }
                    }
                    .row {
                    display: flex;
                    flex-wrap: wrap;
                    margin-right: -15px;
                    margin-left: -1px;
                    }

                    /* Style de la classe "col" */
                    .col {
                    flex-basis: 0;
                    flex-grow: 1;
                    max-width: 100%;
                    padding-right: 15px;
                    padding-left: 15px;

                    }
                    span {
                    color: #002533;
                    font-size: 1em;
                    margin-top: 0; /* Ajustez l'espace en haut du texte selon vos préférences */
                    font-weight: 600;
                    font-family: system-ui;
                    }
                    .navigation-buttons {
                    margin-top: 70px; /* Ajoutez la marge en haut selon vos besoins */
                    /* Autres styles si nécessaire */
                    }
                    .btn-dash1 {
                    background-color: #f4f4f4;
                    box-shadow: 0 5px 10px rgba(0, 0, 0, 0.1);
                    display: flex;
                    justify-content: space-between;
                    align-items: center;
                    padding: 10px 20px;
                    height: 20px;
                    width: 140px;
                    border-radius: 5px;
                    margin-right: 15px;
                    margin-bottom: 20px;
                    color: #002533;
                    font-size: 0.9em;

                    font-weight: 600;
                    font-family: system-ui;
                    }



                    .btn-dash2 {
                    background-color: #ffffff;
                    box-shadow: 0 5px 5px rgba(0, 0, 0, 0.1); /* Modification ici */
                    display: flex;
                    justify-content: space-between;
                    align-items: center;
                    padding: 10px 20px;
                    height: 20px;
                    width: 140px; /* Correction ici */
                    border-radius: 5px;
                    margin-right: 15px;
                    margin-bottom: 20px;
                    color: #002533;
                    font-size: 0.9em;

                    font-weight: 600;
                    font-family: system-ui;
                    }

                    .btn-dash2desactivate {
                    background-color: #ffffff;

                    display: flex;
                    justify-content: space-between;
                    align-items: center;
                    padding: 10px 20px;
                    height: 20px;
                    width: 140px; /* Correction ici */
                    border-radius: 5px;
                    margin-right: 15px;
                    margin-bottom: 20px;
                    color: #002533;
                    font-size: 0.9em;

                    font-weight: 600;
                    font-family: system-ui;
                    }
                    .btn-dash1desactivate {
                    background-color: #f4f4f4;

                    display: flex;
                    justify-content: space-between;
                    align-items: center;
                    padding: 10px 20px;
                    height: 20px;
                    width: 140px;
                    border-radius: 5px;
                    margin-right: 15px;
                    margin-bottom: 20px;
                    color: #002533;
                    font-size: 0.9em;

                    font-weight: 600;
                    font-family: system-ui;
                    }

                    .btn-dash1, .btn-dash2 ,.btn-dash2desactivate a,.btn-dash1desactivate a {
                    text-align: left;
                    }

                    .btn-dash1 a, .btn-dash2 a,.btn-dash2desactivate a ,.btn-dash1desactivate a{
                    text-decoration: none;
                    color: #000000; /* Couleur du texte, ajustez selon vos besoins */
                    }
                </style>
                <script>
                    function redirectToProfile(numero, nom, prenom) {
                    // Encode the parameters to make sure special characters are handled properly
                    var encodedNom = encodeURIComponent(nom);
                    var encodedPrenom = encodeURIComponent(prenom);

                    window.location.href = "profile.html?selectedNumero=" + numero + "&amp;selectedNom=" + encodedNom + "&amp;selectedPrenom=" + encodedPrenom;
                    }
                    function logout() {
                    // Ajoutez ici la logique de déconnexion, par exemple, redirigez vers la page de déconnexion
                    window.location.href = "login";
                    }
                    function Affichage2() {
                    // Ajoutez ici la logique de déconnexion, par exemple, redirigez vers la page de déconnexion
                    window.location.href = "affichageS2";
                    }
                    function Affichage1() {
                    // Ajoutez ici la logique de déconnexion, par exemple, redirigez vers la page de déconnexion
                    window.location.href = "affichageS1";
                    }
                    function Liste() {
                    // Ajoutez ici la logique de déconnexion, par exemple, redirigez vers la page de déconnexion
                    window.location.href = "ListeEtud";
                    }
                    function Bulletin() {
                    // Ajoutez ici la logique de déconnexion, par exemple, redirigez vers la page de déconnexion
                    window.location.href = "Bulletin";
                    }

                </script>
            </head>
            <body>
            <div class="dashboard-container" style="display: flex;">

                <aside class="navigation">
                    <div class="logo-container">
                        <img class="logo" src="images/Ensa.png" alt="Logo"/>
                        <span>ENSAT</span>
                    </div>

                    <!-- Ajout des boutons -->
                    <div class="navigation-buttons">
                        <div class="btn-dash1">
                            <a href="Liste">Liste Étudiants</a>
                        </div>
                        <div class="btn-dash2">
                            <a href="Semester1">Affichage Semestre 1</a>
                        </div>
                        <div class="btn-dash1">
                            <a href="Semester2">Affichage Semestre 2</a>
                        </div>
                        <div class="btn-dash2">
                            <a href="Bulletin">Affichage Bulletin</a>
                        </div>
                        <div class="btn-dash1desactivate">
                            <a href="/Module">Notes des élèves</a>
                        </div>
                    </div>

                </aside>

                <main class="main-content" style="flex: 1;">

                  <div class="contenue">
                   <header>
                      <div class="logo-container">

                          <a class="opacity-5 text-dark">Pages / </a>
                      <p></p>
                      <strong> <span >Affichage</span></strong>

                      </div>
                       <button id="logout-btn" onclick="logout()">
                         Logout
                       </button>
                  </header>


                  <div class="tableint">
                     <div class="container">



                        <p class="titre"> module XML</p>
                         <center>
                             <table border="1">
                                 <xsl:for-each select="bulletin/etudiant">
                                     <tr id="{numero}" onclick="redirectToProfile('{numero}', '{Nom}', '{Prénom}','{xml}'">
                                         <td>
                                             <xsl:if test="position() > 1">
                                                 <xsl:value-of select="position() - 1"/>
                                             </xsl:if>
                                         </td>
                                         <td><xsl:value-of select="numero"/></td>
                                         <td><xsl:value-of select="Nom"/></td>
                                         <td><xsl:value-of select="Prénom"/></td>
                                         <td><xsl:value-of select="xml"/></td>

                                         <!-- Utilisez la matière du professeur connecté à partir du modèle Professor -->





                                     </tr>
                                 </xsl:for-each>
                             </table>
                             <div style="margin-top: 20px; height: 100px;"> <!-- Ajoutez la propriété style avec height pour spécifier la hauteur en pixels -->
                                 <form method="post" action="/generatePdf">
                                     <input value="Generer PDF" type="submit" id="logout-btn"  ></input>
                                 </form>
                             </div>

                         </center>

                     </div>
                 </div>








                      <footer class="site-footer">
                          <div class="container">
                              <div class="row">
                                  <div class="col">
                                      <h6>About</h6>
                                      <p class="text-justify">L'ENSA de Tanger, <i>École Nationale des Sciences Appliquées de Tanger</i>, est une institution académique qui se consacre à l'enseignement des sciences appliquées.</p>
                                  </div>

                                  <div class="col">
                                      <h6>Categories</h6>
                                      <ul class="footer-links">
                                          <li><a href="http://scanfcode.com/category/c-language/">C</a></li>
                                          <li><a href="http://scanfcode.com/category/front-end-development/">UI Design</a></li>
                                          <li><a href="http://scanfcode.com/category/back-end-development/">PHP</a></li>
                                          <li><a href="http://scanfcode.com/category/java-programming-language/">Java</a></li>
                                          <li><a href="http://scanfcode.com/category/android/">Android</a></li>
                                          <li><a href="http://scanfcode.com/category/templates/">Templates</a></li>
                                      </ul>
                                  </div>

                                  <div class="col">
                                      <h6>Quick Links</h6>
                                      <ul class="footer-links">
                                          <li><a href="http://scanfcode.com/about/">About Us</a></li>
                                          <li><a href="http://scanfcode.com/contact/">Contact Us</a></li>
                                          <li><a href="http://scanfcode.com/contribute-at-scanfcode/">Contribute</a></li>
                                          <li><a href="http://scanfcode.com/privacy-policy/">Privacy Policy</a></li>
                                          <li><a href="http://scanfcode.com/sitemap/">Sitemap</a></li>
                                      </ul>
                                  </div>
                                  <div class="col">
                                      <img classe="image" src="images/Ensa.png"></img>
                                  </div>
                              </div>
                              <hr></hr>
                          </div>
                          <div class="container">
                              <div class="row">
                                  <div class="col">
                                      <p class="copyright-text">Copyrigh; 2017 All Rights Reserved by
                                          <a href="#">Scanfcode</a>.
                                      </p>
                                  </div>

                                  <div class="col">
                                      <ul class="social-icons">
                                          <li><a class="facebook" href="#"><i class="fa fa-facebook"></i></a></li>
                                          <li><a class="twitter" href="#"><i class="fa fa-twitter"></i></a></li>
                                          <li><a class="dribbble" href="#"><i class="fa fa-dribbble"></i></a></li>
                                          <li><a class="linkedin" href="#"><i class="fa fa-linkedin"></i></a></li>
                                      </ul>
                                  </div>
                              </div>
                          </div>
                      </footer>
                  </div>
                </main>
            </div>

            <!-- Scripts JavaScript, jQuery, etc. -->
            <!-- Assurez-vous d'ajuster ces liens en fonction de l'emplacement réel de vos fichiers -->

        </body>
    </html>

    </xsl:template>

</xsl:stylesheet>

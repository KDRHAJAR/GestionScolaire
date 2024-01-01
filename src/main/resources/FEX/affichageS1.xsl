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

                    header {
                    background-color: #f4f4f4;
                    box-shadow: 0 5px 10px rgba(0, 0, 0, 0.1);
                    display: flex;
                    justify-content: space-between;
                    align-items: center;
                    padding: 10px 20px; /* Ajustement de la hauteur et de la marge intérieure */
                    height: 70px; /* Ajustement de la hauteur de l'en-tête */
                    }


                    .logo-container {
                    display: flex;
                    align-items: center;
                    }

                    .logo {
                    max-width: 100px;
                    height: auto;
                    margin-right: 10px;
                    border-radius: 15%;
                    }

                    h2 {
                    color: #000033;
                    font-size: 1.2em;
                    margin: 0;
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

                    #logout-btn img {
                    max-width: 20px;
                    height: auto;
                    margin-right: 5px;
                    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2); /* Ajout de l'ombre uniquement à l'image */

                    }

                    .container {
                    margin: 0 auto;
                    max-width: 1200px; /* ou une autre largeur selon vos besoins */
                    }

                    .container-fluid {
                    margin: 0;
                    padding: 0;
                    }



                    img.logo {
                    max-width: 100px;
                    height: auto;
                    margin-right: 5px;
                    border-radius: 15%;
                    }

                    center {
                    margin-top: 20px;
                    }

                    h1 {
                    color: #000033;
                    font-size: 1.5em; /* Ajustez la taille de la police selon vos préférences */
                    margin-top: 20px; /* Espace en haut du titre */
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
                    footer {
                    background-color: #343a40;
                    color: #fff;
                    padding-right: 30px;
                    text-align: center;
                    // position: absolute;
                    bottom: 0;
                    width: 100%;
                    height: auto;
                    display: flex;
                    justify-content: space-between;
                    align-items: center;
                    }

                    img.footer-img {
                    width: 300px; /* Taille de l'image */
                    height: auto;
                    }

                    .footer-text {
                    /*flex-grow: 1; *//* Permet au texte de remplir l'espace disponible à droite */
                    text-align: right;
                    margin-right: 20px;
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
                </script>
            </head>
            <body>
                <header >
                    <div class="logo-container">
                        <img class="logo" src="images\Ensa.png" alt="Logo"/>
                        <h2>ENSA Tanger</h2>
                    </div>
                    <button id="logout-btn" onclick="logout()">
                        <img src="images/deco.png" alt="Logout Icon"/> Logout
                    </button>
                </header>
                <div class="container">
                    <center>

                        <h1> L'affichage de Semestre 1 </h1>
                        <table border="1">
                            <xsl:for-each select="etudiants/etudiant">
                                <tr id="{numero}" onclick="redirectToProfile('{numero}', '{nom}', '{prenom}', '{ginf21}', '{ginf22}', '{ginf23}', '{ginf24}', '{ginf25}', '{ginf26}', '{moyenne}')">
                                    <td>
                                        <xsl:if test="position() > 1">
                                            <xsl:value-of select="position() - 1"/>
                                        </xsl:if>
                                    </td>
                                    <td><xsl:value-of select="numero"/></td>
                                    <td><xsl:value-of select="nom"/></td>
                                    <td><xsl:value-of select="prenom"/></td>
                                    <td><xsl:value-of select="ginf21"/></td>
                                    <td><xsl:value-of select="ginf22"/></td>
                                    <td><xsl:value-of select="ginf23"/></td>
                                    <td><xsl:value-of select="ginf24"/></td>
                                    <td><xsl:value-of select="ginf25"/></td>
                                    <td><xsl:value-of select="ginf26"/></td>
                                    <td>
                                        <xsl:choose>
                                            <xsl:when test="moyenne > 12">
                                                <xsl:attribute name="style">background-color: blue</xsl:attribute>
                                            </xsl:when>
                                            <xsl:when test="moyenne &lt;= 12 and moyenne > 8">
                                                <xsl:attribute name="style">background-color: green</xsl:attribute>
                                            </xsl:when>
                                            <xsl:when test="moyenne &lt;= 8">
                                                <xsl:attribute name="style">background-color: red</xsl:attribute>
                                            </xsl:when>
                                        </xsl:choose>
                                        <xsl:value-of select="moyenne"/>
                                    </td>
                                    <xsl:if test="position() > 1">
                                        <td style="background-color: #f4f4f4">
                                            Voir profil
                                        </td>
                                    </xsl:if>
                                </tr>
                            </xsl:for-each>
                        </table>

                        <br/>
                        <br/>

                    </center>
                </div>
                <footer class="container">
                    <img class="footer-img" src="images (2).png" alt="Description de l'image du footer"/>
                    <div class="footer-text">
                        <p>Uneversite Abdelmalik Essaadi</p>
                        <p>Contactez-nous : <a href="mailto:contact@universite.com">contact@universite.com</a></p>
                        <p>Téléphone : +212 698 571 217</p>
                        <address>Boukhalef Tanger Morocco</address>
                        <p>Développeurs : Sofiane ABETIOU and  Hajar KDIDAR</p>
                    </div>
                </footer>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>

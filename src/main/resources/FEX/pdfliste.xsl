<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format">

    <xsl:output method="xml" indent="yes"/>

    <xsl:template match="/bulletin">
        <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="simpleA4" page-height="29.7cm" page-width="21cm"
                                       margin-top="1cm" margin-bottom="1cm" margin-left="1cm" margin-right="1cm">
                    <fo:region-body margin-top="2cm"/>
                    <fo:region-before extent="1cm"/>
                    <fo:region-after extent="1cm"/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="simpleA4">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block>
                        <!-- Logo -->
                        <fo:external-graphic src="url('file:///C:/newt/demo/src/main/resources/static/images/Ensa.png')" content-width="3cm" content-height="3cm"/>

                        <!-- Ensa -->


                        <!-- Anne Universitaire -->
                        <fo:block text-align="end" >Anne Universitaire 2023/2024</fo:block>
                    </fo:block>

                    <fo:block font-size="24pt" font-weight="bold" text-align="center" color="navy">Note du module</fo:block>
                    <fo:table border="1pt solid navy" width="100%" background-color="#f2f2f2">
                        <fo:table-column column-width="auto"/>
                        <fo:table-column column-width="auto"/>
                        <fo:table-column column-width="auto"/>

                        <fo:table-header background-color="navy" color="white">
                            <fo:table-row>
                                <fo:table-cell padding="5pt"><fo:block>Nom</fo:block></fo:table-cell>
                                <fo:table-cell padding="5pt"><fo:block>Prénom</fo:block></fo:table-cell>
                                <fo:table-cell padding="5pt"><fo:block>XML</fo:block></fo:table-cell>
                            </fo:table-row>
                        </fo:table-header>

                        <fo:table-body>
                            <xsl:apply-templates select="etudiant"/>
                        </fo:table-body>
                    </fo:table>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>

    <xsl:template match="etudiant">
        <fo:table-row>
            <fo:table-cell padding="5pt"><fo:block font-weight="bold"><xsl:value-of select="Nom"/></fo:block></fo:table-cell>
            <fo:table-cell padding="5pt"><fo:block><xsl:value-of select="Prénom"/></fo:block></fo:table-cell>
            <fo:table-cell padding="5pt"><fo:block><xsl:value-of select="xml"/></fo:block></fo:table-cell>
        </fo:table-row>
    </xsl:template>
</xsl:stylesheet>

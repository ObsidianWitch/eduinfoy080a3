<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:nl="http://library.be" >
	<xsl:param name="second">foo</xsl:param>
	
	<xsl:template match="/">
		<root>
			<xsl:apply-templates select="//book" />
			
			<xsl:for-each select="$second/nl:searchForBooksReturn">
				<book xmlns="http://library.be">
					<author><xsl:value-of select="nl:author" /></author>
					<isbn><xsl:value-of select="nl:isbn" /></isbn>
					<pages>0</pages>
					<publicationDate><xsl:value-of select="nl:date"/></publicationDate>
					<publisher><xsl:value-of select="nl:publisher" /></publisher>
					<review></review>
					<summary></summary>
					<title><xsl:value-of select="nl:title" /></title>
				</book>
			</xsl:for-each>
		</root>
	</xsl:template>
	
	<xsl:template match="//book">
		<book xmlns="urn:soft.vub.ac.be/">
			<author><xsl:value-of select="author" /></author>
			<isbn><xsl:value-of select="isbn" /></isbn>
			<pages>0</pages>
			<publicationDate><xsl:value-of select="year"/>-01-01T00:00:00</publicationDate>
			<publisher><xsl:value-of select="publisher" /></publisher>
			<review></review>
			<summary></summary>
			<title><xsl:value-of select="title" /></title>
		</book>
	</xsl:template>
</xsl:stylesheet>
